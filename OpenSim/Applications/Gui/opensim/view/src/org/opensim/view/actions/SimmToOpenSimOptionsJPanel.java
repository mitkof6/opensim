/*
 * SimmToOpenSimOptionsJPanel.java
 *
 * Created on July 21, 2007, 9:37 AM
 */

package org.opensim.view.actions;

/**
 *
 * @author  Ayman
 */
public class SimmToOpenSimOptionsJPanel extends javax.swing.JPanel {
    String[] DynamicsEngineNames = new String[]{    // internal names corresponding to names exposed in gui
        "SimmKinematicsEngine",
        "Simbody"
    };
    /** Creates new form SimmToOpenSimOptionsJPanel */
    public SimmToOpenSimOptionsJPanel() {
        initComponents();
        jntfileTextFieldAndChooser.setExtensionsAndDescription(".jnt", "SIMM joint file");
        mslfileTextFieldAndChooser.setExtensionsAndDescription(".msl", "SIMM muscle file");
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
   // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
   private void initComponents() {
      angleUnitsButtonGroup = new javax.swing.ButtonGroup();
      buttonGroup1 = new javax.swing.ButtonGroup();
      jntfileTextFieldAndChooser = new org.opensim.swingui.FileTextFieldAndChooser();
      jLabel1 = new javax.swing.JLabel();
      jLabel2 = new javax.swing.JLabel();
      mslfileTextFieldAndChooser = new org.opensim.swingui.FileTextFieldAndChooser();
      jLabel4 = new javax.swing.JLabel();
      jEngineComboBox = new javax.swing.JComboBox();

      jntfileTextFieldAndChooser.setToolTipText("location of .jnt file");

      jLabel1.setText("Joint file:");

      jLabel2.setText("Muscle file:");

      mslfileTextFieldAndChooser.setToolTipText("location of .msl file (optional and can be specified in jnt file header)");

      jLabel4.setText("Dynamics Engine for OpenSim Model:");

      jEngineComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SIMM kinematics engine", "Simbody engine" }));
      jEngineComboBox.setToolTipText("SIMM knematics engine computes kinematics only while Simbody computes accelerations but has some limitations in 1.0.");

      org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
      this.setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
         .add(layout.createSequentialGroup()
            .addContainerGap()
            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
               .add(layout.createSequentialGroup()
                  .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                     .add(jLabel2)
                     .add(jLabel1))
                  .add(31, 31, 31)
                  .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                     .add(jntfileTextFieldAndChooser, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                     .add(mslfileTextFieldAndChooser, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)))
               .add(layout.createSequentialGroup()
                  .add(jLabel4)
                  .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                  .add(jEngineComboBox, 0, 153, Short.MAX_VALUE)))
            .addContainerGap())
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
         .add(layout.createSequentialGroup()
            .addContainerGap()
            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
               .add(jLabel1)
               .add(jntfileTextFieldAndChooser, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
            .add(15, 15, 15)
            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
               .add(jLabel2)
               .add(mslfileTextFieldAndChooser, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
            .add(52, 52, 52)
            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
               .add(jLabel4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 18, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
               .add(jEngineComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
            .addContainerGap())
      );
   }// </editor-fold>//GEN-END:initComponents
    
    
   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.ButtonGroup angleUnitsButtonGroup;
   private javax.swing.ButtonGroup buttonGroup1;
   private javax.swing.JComboBox jEngineComboBox;
   private javax.swing.JLabel jLabel1;
   private javax.swing.JLabel jLabel2;
   private javax.swing.JLabel jLabel4;
   private org.opensim.swingui.FileTextFieldAndChooser jntfileTextFieldAndChooser;
   private org.opensim.swingui.FileTextFieldAndChooser mslfileTextFieldAndChooser;
   // End of variables declaration//GEN-END:variables
    String getJointFilename()
    {
        if (jntfileTextFieldAndChooser.getFileIsValid())
            return jntfileTextFieldAndChooser.getFileName();
        return null;
    }
    String getMslFilename()
    {
        if (mslfileTextFieldAndChooser.getFileIsValid())
            return mslfileTextFieldAndChooser.getFileName();
        return null;        
    }
    String getDynamicsEngine()
    {
        return DynamicsEngineNames[jEngineComboBox.getSelectedIndex()];
    }
}