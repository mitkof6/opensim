/*
 * OpenSimvtkGlyphCloud.java
 *
 * Created on January 25, 2007, 9:39 AM
 *
 * Copyright (c) 2006, Stanford University and Ayman Habib. All rights reserved.
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject
 * to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included
 * in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS
 * OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
 * IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY
 * CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT,
 * TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE
 * SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package org.opensim.view;

import java.util.Stack;
import vtk.vtkActor;
import vtk.vtkCylinderSource;
import vtk.vtkFloatArray;
import vtk.vtkLookupTable;
import vtk.vtkPoints;
import vtk.vtkPolyData;
import vtk.vtkPolyDataMapper;
import vtk.vtkProperty;
import vtk.vtkTensorGlyph;

/**
 *
 * @author Ayman Habib. An object representing a cloud of visual objects used to display markers, muscle points 
 * efficiently.
 */
public class OpenSimvtkOrientedGlyphCloud {    // Assume same shape
    
    private vtkPoints           pointCloud = new vtkPoints(); // object centers
    private vtkPolyData         pointPolyData = new vtkPolyData();
    private vtkPolyData         shape=new vtkCylinderSource().GetOutput();
    private vtkActor            actor = new vtkActor();
    private vtkPolyDataMapper   mapper = new vtkPolyDataMapper();
    private vtkTensorGlyph      glyph= new vtkTensorGlyph();
    private vtkFloatArray       tensorData = new vtkFloatArray();

    private vtkFloatArray       scalarData = null;
    private vtkLookupTable      lookupTable = null;

    private Stack<Integer> freeList = new Stack<Integer>();
    
    /**
    * Creates a new instance of OpenSimvtkGlyphCloud
    */
    public OpenSimvtkOrientedGlyphCloud() {
        tensorData.SetNumberOfTuples(1);
        tensorData.SetNumberOfComponents(9);
        pointPolyData.SetPoints(pointCloud);
        pointPolyData.GetPointData().SetTensors(tensorData);
        glyph.ExtractEigenvaluesOff();
        glyph.ThreeGlyphsOff();
        glyph.SymmetricOff();
    }
    
    public void setShape(vtkPolyData rep) {
        shape = rep;
    }
    public void setDisplayProperties(vtkProperty prop) {
        actor.SetProperty(prop);
    }
    public void setColor(double[] color) {
        actor.GetProperty().SetColor(color);
    }
    public void setOpacity(double newOpacity) {
        actor.GetProperty().SetOpacity(newOpacity);
    }

   public void setColorRange(double[] color0, double[] color1) {
      scalarData = new vtkFloatArray();
      scalarData.SetNumberOfTuples(1);
      scalarData.SetNumberOfComponents(1);
      pointPolyData.GetPointData().SetScalars(scalarData);
      glyph.SetColorGlyphs(1);
      glyph.SetColorModeToScalars();
      lookupTable = new vtkLookupTable();
      double c0[] = (color0.length==3) ? new double[]{color0[0], color0[1], color0[2], 1.0} : color0;
      double c1[] = (color1.length==3) ? new double[]{color1[0], color1[1], color1[2], 1.0} : color1;
      double c[] = new double[4];
      lookupTable.SetNumberOfTableValues(101);
      for(int i=0; i<101; i++) {
         double alpha = 0.01*i;
         lookupTable.SetTableValue(i, c0[0]+alpha*(c1[0]-c0[0]), c0[1]+alpha*(c1[1]-c0[1]), c0[2]+alpha*(c1[2]-c0[2]), c0[3]+alpha*(c1[3]-c0[3]));
      }
      mapper.SetLookupTable(lookupTable);
   }
    
    public vtkActor getVtkActor() {
        glyph.SetSource(shape);
        glyph.SetInput(pointPolyData);
        mapper.SetInput(glyph.GetOutput());
        actor.SetMapper(mapper);
        
        return actor;
    }
    
    public void setLocation(int index, double x, double y, double z) {
        pointCloud.SetPoint(index, x, y, z);
    }

    public void setLocation(int index, double[] point) {
        pointCloud.SetPoint(index, point[0], point[1], point[2]);
    }
    
    synchronized public void setTensorDataAtLocation(int index, double xx, double xy, double xz,
            double yx, double yy, double yz,
            double zx, double zy, double zz) {
        tensorData.SetTuple9(index, xx, xy, xz, yx, yy, yz, zx, zy, zz);
    }
    
    synchronized public void setScalarDataAtLocation(int index, double value) {
       if(scalarData!=null) scalarData.SetTuple1(index, value);
    }

   public vtkFloatArray getTensorData() {
      return tensorData;
   }

   public void setTensorData(vtkFloatArray tensorData) {
      this.tensorData = tensorData;
   }

   public void setModified() {
      pointPolyData.Modified();	//Enough to mark the polyData object as modified to trigger re-execution of the pipeline.
   }

    public void setPickable(boolean pickable) {
       if (pickable) {
          actor.SetPickable(1);
       } else {
          actor.SetPickable(0);
       }
    }

   /////////////////////////////////////////////////////////////////////////////
   // Add/Remove locations
   /////////////////////////////////////////////////////////////////////////////

   public int addLocation() {
      return addLocation(0.,0.,0.);
   }

   public int addLocation(double[] newPoint) {
      return addLocation(newPoint[0],newPoint[1],newPoint[2]);
   }

   public int addLocation(double px, double py, double pz) {
      int idx;
      if(!freeList.empty()) { // reuse existing index that was removed earlier
         idx = freeList.pop().intValue();
         show(idx);
      } else {
         idx = pointCloud.InsertNextPoint(px, py, pz);
         tensorData.InsertTuple9(idx, 1., 0., 0., 0., 1., 0., 0., 0., 1.);
         if(scalarData!=null) scalarData.InsertTuple1(idx, 1);
      }
      return idx;
   }

   /*
    * Remove the specified index from view. 
    * There should be a better way to do this but vtkPoints doesn't have an interface
    * to remove points AFAIK !!
    */
   void remove(int index) {
      freeList.push(index);
      hide(index);
   }

   /////////////////////////////////////////////////////////////////////////////
   // Show/Hide points
   /////////////////////////////////////////////////////////////////////////////
   
   public void show(int index) {
      tensorData.SetTuple9(index, 1., 0., 0., 0., 1., 0., 0., 0., 0.);
   }

   public void hide(int index) {
      tensorData.SetTuple9(index, 0., 0., 0., 0., 0., 0., 0., 0., 0.);
   }
}
