package vtk;

import vtk.vtkActor;
import vtk.vtkAssembly;
import vtk.vtkAxes;
import vtk.vtkPolyDataMapper;
import vtk.vtkTubeFilter;

public class AxesActor extends vtkAssembly {

  private double axisLength = 0.5;
  private double axisTextLength = 0.1;
  private vtkTextActor xactor, yactor, zactor;

  public AxesActor() {
    super();
    createAxes();
  }

  public void createAxes() {
    vtkAxes axes = new vtkAxes();
    axes.SetOrigin(0, 0, 0);
    axes.SetScaleFactor(axisLength);

    xactor = new vtkTextActor();
    yactor = new vtkTextActor();
    zactor = new vtkTextActor();

    xactor.SetInput("X");
    yactor.SetInput("Y");
    zactor.SetInput("Z");

    xactor.ScaledTextOn();
    yactor.ScaledTextOn();
    zactor.ScaledTextOn();

    xactor.GetPositionCoordinate().SetCoordinateSystemToWorld();
    yactor.GetPositionCoordinate().SetCoordinateSystemToWorld();
    zactor.GetPositionCoordinate().SetCoordinateSystemToWorld();

    xactor.GetPositionCoordinate().SetValue(axisLength, 0.0, 0.0);
    yactor.GetPositionCoordinate().SetValue(0.0, axisLength, 0.0);
    zactor.GetPositionCoordinate().SetValue(0.0, 0.0, axisLength);

    xactor.GetTextProperty().SetColor(1.0, 1.0, 1.0);
    xactor.GetTextProperty().ShadowOn();
    xactor.GetTextProperty().ItalicOn();
    xactor.GetTextProperty().BoldOff();

    yactor.GetTextProperty().SetColor(1.0, 1.0, 1.0);
    yactor.GetTextProperty().ShadowOn();
    yactor.GetTextProperty().ItalicOn();
    yactor.GetTextProperty().BoldOff();

    zactor.GetTextProperty().SetColor(1.0, 1.0, 1.0);
    zactor.GetTextProperty().ShadowOn();
    zactor.GetTextProperty().ItalicOn();
    zactor.GetTextProperty().BoldOff();

    xactor.SetMaximumLineHeight(0.25);
    yactor.SetMaximumLineHeight(0.25);
    zactor.SetMaximumLineHeight(0.25);

    vtkTubeFilter tube = new vtkTubeFilter();
    tube.SetInput(axes.GetOutput());
    tube.SetRadius(0.01);
    tube.SetNumberOfSides(6);

    vtkPolyDataMapper tubeMapper = new vtkPolyDataMapper();
    tubeMapper.SetInput(tube.GetOutput());

    vtkActor tubeActor = new vtkActor();
    tubeActor.SetMapper(tubeMapper);
    tubeActor.PickableOff();

    int coneRes = 12;
    double coneScale = 0.1;

    //--- x-Cone
    vtkConeSource xcone = new vtkConeSource();
    xcone.SetResolution(coneRes);
    vtkPolyDataMapper xconeMapper = new vtkPolyDataMapper();
    xconeMapper.SetInput(xcone.GetOutput());
    vtkActor xconeActor = new vtkActor();
    xconeActor.SetMapper(xconeMapper);
    xconeActor.GetProperty().SetColor(1,0,0);
    xconeActor.SetScale(coneScale, coneScale, coneScale);
    xconeActor.SetPosition(axisLength, 0.0, 0.0);

    //--- y-Cone
    vtkConeSource ycone = new vtkConeSource();
    ycone.SetResolution(coneRes);
    vtkPolyDataMapper yconeMapper = new vtkPolyDataMapper();
    yconeMapper.SetInput(ycone.GetOutput());
    vtkActor yconeActor = new vtkActor();
    yconeActor.SetMapper(yconeMapper);
    yconeActor.GetProperty().SetColor(1,1,0);
    yconeActor.RotateZ(90);
    yconeActor.SetScale(coneScale, coneScale, coneScale);
    yconeActor.SetPosition(0.0, axisLength, 0.0);

    //--- z-Cone
    vtkConeSource zcone = new vtkConeSource();
    zcone.SetResolution(coneRes);
    vtkPolyDataMapper zconeMapper = new vtkPolyDataMapper();
    zconeMapper.SetInput(zcone.GetOutput());
    vtkActor zconeActor = new vtkActor();
    zconeActor.SetMapper(zconeMapper);
    zconeActor.GetProperty().SetColor(0,1,0);
    zconeActor.RotateY(-90);
    zconeActor.SetScale(coneScale, coneScale, coneScale);
    zconeActor.SetPosition(0.0, 0.0, axisLength);

    this.AddPart(tubeActor);

    this.AddPart(xconeActor);
    this.AddPart(yconeActor);
    this.AddPart(zconeActor);

  }

  public void setAxesVisibility(boolean ison) {
    this.SetVisibility(ison ? 1 : 0);

    xactor.SetVisibility(ison ? 1 : 0);
    yactor.SetVisibility(ison ? 1 : 0);
    zactor.SetVisibility(ison ? 1 : 0);
  }

}
