/*
 * ClassifyDataJPanel.java
 *
 * Created on March 9, 2009, 2:59 PM
 */

package org.opensim.view.experimentaldata;

import java.util.Vector;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.tree.DefaultMutableTreeNode;
import org.opensim.modeling.ArrayStr;
import org.opensim.view.SingleModelVisuals;
import org.opensim.view.motions.MotionControlJPanel;
import org.opensim.view.motions.MotionDisplayer;
import org.opensim.view.pub.ViewDB;
import vtk.vtkActor;
import vtk.vtkTransform;

/**
 *
 * @author  ayman
 * Copyright (c)  2009, Stanford University and Ayman Habib. All rights reserved.
 * Use of the OpenSim software in source form is permitted provided that the following
 * conditions are met:
 * 	1. The software is used only for non-commercial research and education. It may not
 *     be used in relation to any commercial activity.
 * 	2. The software is not distributed or redistributed.  Software distribution is allowed
 *     only through https://simtk.org/home/opensim.
 * 	3. Use of the OpenSim software or derivatives must be acknowledged in all publications,
 *      presentations, or documents describing work in which OpenSim or derivatives are used.
 * 	4. Credits to developers may not be removed from executables
 *     created from modifications of the source.
 * 	5. Modifications of source code must retain the above copyright notice, this list of
 *     conditions and the following disclaimer.
 *
 *  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY
 *  EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 *  OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT
 *  SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT,
 *  INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED
 *  TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS;
 *  HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 *  OR BUSINESS INTERRUPTION) OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY
 *  WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
public class ClassifyDataJPanel extends javax.swing.JPanel {
    
    private AnnotatedMotion amotion;
    ExperimentalDataTreeModel treeModel;
    RotationSpinnerListModel xSpinnerModel=new RotationSpinnerListModel(0., 0., 270., 90.);
    RotationSpinnerListModel ySpinnerModel=new RotationSpinnerListModel(0., 0., 270., 90.);
    RotationSpinnerListModel zSpinnerModel=new RotationSpinnerListModel(0., 0., 270., 90.);
    MotionDisplayer displayer;
    private vtkTransform lastTranform;
    private double[] rotations = new double[]{0., 0., 0.};
   /** Creates new form ClassifyDataJPanel */
    public ClassifyDataJPanel() {
        initComponents();
    }

    public AnnotatedMotion getAmotion() {
        return amotion;
    }

    public void setAmotion(AnnotatedMotion amotion) {
        this.amotion = amotion;
        DefaultMutableTreeNode root=new DefaultMutableTreeNode("Lab Frame");
        treeModel = new ExperimentalDataTreeModel(root);
        jDataTree.setModel(treeModel);
        // Get "classified" labels and use them to populate jListAvailable
        final Vector<ExperimentalDataObject> classified = amotion.getClassified();
        final ArrayStr labels = amotion.getColumnLabels();
        int labelIndex=1;   // Since time is 0
        for(int i=0; i<classified.size(); i++){
            DefaultMutableTreeNode nextChild=new DefaultMutableTreeNode(classified.get(i).toString());
            nextChild.setUserObject(classified.get(i));
            treeModel.appendChild(nextChild, root);
            labelIndex+= classified.get(i).getObjectType().getNumberOfColumns();
        }
        displayer=MotionControlJPanel.getInstance().getMasterMotion().getDisplayer(amotion);
        // get existing rotations
        double[] rots = amotion.getCurrentRotations();
        XSpinner.setValue(rots[0]);
        YSpinner.setValue(rots[1]);
        ZSpinner.setValue(rots[2]);
   }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jScrollPane1 = new javax.swing.JScrollPane();
        jListAvailable = new javax.swing.JList();
        jPanel1 = new javax.swing.JPanel();
        jTransformDataPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        XSpinner = new javax.swing.JSpinner();
        YSpinner = new javax.swing.JSpinner();
        ZSpinner = new javax.swing.JSpinner();
        jScrollPane2 = new javax.swing.JScrollPane();
        jDataTree = new javax.swing.JTree();
        jLabel4 = new javax.swing.JLabel();
        saveTransformedAsButton = new javax.swing.JButton();

        jListAvailable.setBorder(javax.swing.BorderFactory.createTitledBorder("Available Quantities"));
        jListAvailable.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jListAvailable);

        jLabel1.setText("Rotate X");

        jLabel2.setText("Rotate Y");

        jLabel3.setText("Rotate Z");

        XSpinner.setFont(new java.awt.Font("Tahoma", 0, 12));
        XSpinner.setModel(xSpinnerModel);
        XSpinner.setToolTipText("Rotation angle, 90 degree increments");
        XSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                XSpinnerStateChanged(evt);
            }
        });

        YSpinner.setModel(ySpinnerModel);
        YSpinner.setToolTipText("Rotation angle, 90 degree increments");
        YSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                YSpinnerStateChanged(evt);
            }
        });

        ZSpinner.setModel(zSpinnerModel);
        ZSpinner.setToolTipText("Rotation angle, 90 degree increments");
        ZSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                ZSpinnerStateChanged(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jTransformDataPanelLayout = new org.jdesktop.layout.GroupLayout(jTransformDataPanel);
        jTransformDataPanel.setLayout(jTransformDataPanelLayout);
        jTransformDataPanelLayout.setHorizontalGroup(
            jTransformDataPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jTransformDataPanelLayout.createSequentialGroup()
                .add(jTransformDataPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jTransformDataPanelLayout.createSequentialGroup()
                        .add(jLabel1)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(XSpinner, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE))
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jTransformDataPanelLayout.createSequentialGroup()
                        .add(jLabel2)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(YSpinner, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE))
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jTransformDataPanelLayout.createSequentialGroup()
                        .add(jLabel3)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(ZSpinner, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jTransformDataPanelLayout.setVerticalGroup(
            jTransformDataPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jTransformDataPanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(jTransformDataPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(XSpinner, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jTransformDataPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel2)
                    .add(YSpinner, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jTransformDataPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel3)
                    .add(ZSpinner, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jDataTree.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jDataTree.setDragEnabled(true);
        jScrollPane2.setViewportView(jDataTree);

        jLabel4.setText("Available Quantities");

        saveTransformedAsButton.setText("Save As...");
        saveTransformedAsButton.setToolTipText("Save transformed data into a new file");
        saveTransformedAsButton.setEnabled(false);
        saveTransformedAsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveTransformedAsButtonActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                        .add(jScrollPane2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jPanel1Layout.createSequentialGroup()
                                .add(jTransformDataPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .add(saveTransformedAsButton, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)))
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(18, 18, 18)
                        .add(jLabel4)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel4)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel1Layout.createSequentialGroup()
                        .add(jTransformDataPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 99, Short.MAX_VALUE)
                        .add(saveTransformedAsButton))
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jScrollPane2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE))
                .addContainerGap())
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void saveTransformedAsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveTransformedAsButtonActionPerformed
// TODO add your handling code here:
    }//GEN-LAST:event_saveTransformedAsButtonActionPerformed

    private void ZSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_ZSpinnerStateChanged
        double delta = getRotationAngleChange(evt);
        updateTransform(xSpinnerModel.getLastValue(), 
                ySpinnerModel.getLastValue(), 
                zSpinnerModel.getLastValue());        
    }//GEN-LAST:event_ZSpinnerStateChanged

    private double getRotationAngleChange(final javax.swing.event.ChangeEvent evt) {
// TODO add your handling code here:
        RotationSpinnerListModel numberModel = (RotationSpinnerListModel)((JSpinner)evt.getSource()).getModel();
        double newValue = numberModel.getNumber().doubleValue();
        double delta = newValue-numberModel.getLastValue();
        numberModel.setLastValue(newValue);
        return delta;
    }

    private void YSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_YSpinnerStateChanged
        double delta = getRotationAngleChange(evt);
        //updateTransform(0., delta, 0.);        
        updateTransform(xSpinnerModel.getLastValue(), 
                ySpinnerModel.getLastValue(), 
                zSpinnerModel.getLastValue());        
// TODO add your handling code here:
    }//GEN-LAST:event_YSpinnerStateChanged

    private void XSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_XSpinnerStateChanged
        double delta = getRotationAngleChange(evt);
        //updateTransform(delta, 0., 0.);   
        updateTransform(xSpinnerModel.getLastValue(), 
        ySpinnerModel.getLastValue(), 
        zSpinnerModel.getLastValue());        

// TODO add your handling code here:
    }//GEN-LAST:event_XSpinnerStateChanged

    private void updateTransform(double xRot, double yRot, double zRot) {
        /*Vector<vtkActor> dActors = displayer.getActors();
        for(vtkActor actor:dActors){
            actor.SetOrientation(xRot, yRot, zRot);
        }*/
        lastTranform = new vtkTransform();
        getLastTranform().RotateX(xRot);
        getLastTranform().RotateY(yRot);
        getLastTranform().RotateZ(zRot);
        // Remember reptations in case we need to xform again
        getRotations()[0]=xRot;
        getRotations()[1]=yRot;
        getRotations()[2]=zRot;
        
        ViewDB.getInstance().setOrientation(displayer.getModel(), getRotations());
        ViewDB.getInstance().updateAnnotationAnchors();
        ViewDB.getInstance().repaintAll();
    }

    void resetTransforms() {
        updateTransform(0., 0., 0.);
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner XSpinner;
    private javax.swing.JSpinner YSpinner;
    private javax.swing.JSpinner ZSpinner;
    private javax.swing.JTree jDataTree;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JList jListAvailable;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel jTransformDataPanel;
    private javax.swing.JButton saveTransformedAsButton;
    // End of variables declaration//GEN-END:variables

    class RotationSpinnerListModel extends SpinnerNumberModel {
    private double lastValue;

    public RotationSpinnerListModel(double initial, double min, double max, double step) {
        super(initial, min, max, step);
        setLastValue(initial);
    }

        public double getLastValue() {
            return lastValue;
        }

        public void setLastValue(double lastValue) {
            this.lastValue = lastValue;
        }

    } //RotationSpinnerListModel

    public vtkTransform getLastTranform() {
        return lastTranform;
    }

    public double[] getRotations() {
        return rotations;
    }

    public void setRotations(double[] rotations) {
        this.rotations = rotations;
    }
}
