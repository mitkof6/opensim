/*
 * ActuatorsAndExternalLoadsPanel.java
 *
 * Created on July 23, 2007, 7:32 PM
 */

package org.opensim.tracking;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import org.opensim.modeling.BodySet;
import org.opensim.modeling.Model;
import org.opensim.swingui.ComponentTitledBorder;

/**
 *
 * @author  erang
 */
public class ActuatorsAndExternalLoadsPanel extends javax.swing.JPanel {
  
   private JCheckBox externalLoadsPanelCheckBox = new JCheckBox(new EnableExternalLoadsAction());
   class EnableExternalLoadsAction extends AbstractAction {
      public EnableExternalLoadsAction() { super("External Loads"); }
      public void actionPerformed(ActionEvent evt) { toolModel.setExternalLoadsEnabled(((JCheckBox)evt.getSource()).isSelected()); }
   }

   AbstractToolModelWithExternalLoads toolModel;
   Model model;
   boolean internalTrigger = false;

   /** Creates new form ActuatorsAndExternalLoadsPanel */
   public ActuatorsAndExternalLoadsPanel(AbstractToolModelWithExternalLoads toolModel, Model model) {
      this.toolModel = toolModel;
      this.model = model;

      initComponents();

      // Add checkbox titled borders to external loads panel
      externalLoadsPanelCheckBox.setForeground(new Color(0,70,213));
      externalLoadsPanel.setBorder(new ComponentTitledBorder(externalLoadsPanelCheckBox, externalLoadsPanel, BorderFactory.createEtchedBorder()));

      updatePanel();
   }

   private void setEnabled(JPanel panel, boolean enabled) {
      for(Component comp : panel.getComponents()) {
         comp.setEnabled(enabled);
         if(comp instanceof JPanel) setEnabled((JPanel)comp, enabled);
      }
   }

   public void updatePanel() {
      internalTrigger = true;

      setEnabled(actuatorsPanel, true);
      setEnabled(externalLoadsPanel, true);

      //---------------------------------------------------------------------
      // Actuators
      //---------------------------------------------------------------------
      keepModelActuators.setSelected(!toolModel.getReplaceActuatorSet());

      String str = "";
      for(int i=0; i<toolModel.getActuatorSetFiles().getSize(); i++)
         str += (i>0?", ":"") + toolModel.getActuatorSetFiles().getitem(i);
      actuatorSetFiles.setText(str);

      //---------------------------------------------------------------------
      // External loads
      //---------------------------------------------------------------------

      externalLoadsPanelCheckBox.setSelected(toolModel.getExternalLoadsEnabled());
      if(!toolModel.getExternalLoadsEnabled()) setEnabled(externalLoadsPanel, false);

      // Update combo boxes with body names
      for(JComboBox comboBox : new JComboBox[]{externalLoadsBody1, externalLoadsBody2}) {
         comboBox.removeAllItems();
         if(model==null) continue;
         BodySet bodySet = model.getDynamicsEngine().getBodySet();
         if(bodySet==null) continue;
         for(int i=0; i<bodySet.getSize(); i++) comboBox.addItem(bodySet.get(i).getName());
         String selectedBody = (comboBox==externalLoadsBody1) ? toolModel.getExternalLoadsBody1() : toolModel.getExternalLoadsBody2();
         int index = bodySet.getIndex(selectedBody);
         comboBox.setSelectedIndex(index);
      }

      externalLoadsFileName.setFileName(toolModel.getExternalLoadsFileName(),false);
      externalLoadsModelKinematicsFileName.setFileName(toolModel.getExternalLoadsModelKinematicsFileName(),false);
      if(!toolModel.getFilterLoadKinematics()) {
         filterModelKinematics.setSelected(false);
         cutoffFrequency.setText("");
         cutoffFrequency.setEnabled(false);
      } else {
         filterModelKinematics.setSelected(true);
         cutoffFrequency.setText(((Double)toolModel.getLowpassCutoffFrequencyForLoadKinematics()).toString());
      }

      internalTrigger = false;
   }
   
   /** This method is called from within the constructor to
    * initialize the form.
    * WARNING: Do NOT modify this code. The content of this method is
    * always regenerated by the Form Editor.
    */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        externalLoadsPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        filterModelKinematics = new javax.swing.JCheckBox();
        externalLoadsBody1 = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        externalLoadsBody2 = new javax.swing.JComboBox();
        externalLoadsFileName = new org.opensim.swingui.FileTextFieldAndChooser();
        externalLoadsModelKinematicsFileName = new org.opensim.swingui.FileTextFieldAndChooser();
        cutoffFrequency = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        actuatorsPanel = new javax.swing.JPanel();
        keepModelActuators = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        actuatorSetFiles = new javax.swing.JTextField();

        externalLoadsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "External Loads"));
        jLabel3.setText("External loads");

        jLabel4.setText("Model kinematics for external loads");

        jLabel6.setText("Applied to bodies:");

        filterModelKinematics.setText("Filter model kinematics");
        filterModelKinematics.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        filterModelKinematics.setMargin(new java.awt.Insets(0, 0, 0, 0));
        filterModelKinematics.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterModelKinematicsActionPerformed(evt);
            }
        });

        externalLoadsBody1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        externalLoadsBody1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                externalLoadsBody1ActionPerformed(evt);
            }
        });

        jLabel5.setText("Body1");

        jLabel7.setText("Body2");

        externalLoadsBody2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        externalLoadsBody2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                externalLoadsBody2ActionPerformed(evt);
            }
        });

        externalLoadsFileName.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                externalLoadsFileNameStateChanged(evt);
            }
        });

        externalLoadsModelKinematicsFileName.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                externalLoadsModelKinematicsFileNameStateChanged(evt);
            }
        });

        cutoffFrequency.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        cutoffFrequency.setText("jTextField3");
        cutoffFrequency.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cutoffFrequencyActionPerformed(evt);
            }
        });
        cutoffFrequency.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cutoffFrequencyFocusLost(evt);
            }
        });

        jLabel8.setText("Cutoff frequency");

        jLabel9.setText("Hz");

        org.jdesktop.layout.GroupLayout externalLoadsPanelLayout = new org.jdesktop.layout.GroupLayout(externalLoadsPanel);
        externalLoadsPanel.setLayout(externalLoadsPanelLayout);
        externalLoadsPanelLayout.setHorizontalGroup(
            externalLoadsPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(externalLoadsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(externalLoadsPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(filterModelKinematics)
                    .add(jLabel4)
                    .add(jLabel6)
                    .add(jLabel3))
                .add(externalLoadsPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(externalLoadsPanelLayout.createSequentialGroup()
                        .add(26, 26, 26)
                        .add(jLabel8)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(cutoffFrequency, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 139, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jLabel9)
                        .add(86, 86, 86))
                    .add(externalLoadsPanelLayout.createSequentialGroup()
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(externalLoadsModelKinematicsFileName, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE))
                    .add(externalLoadsPanelLayout.createSequentialGroup()
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(externalLoadsFileName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .add(externalLoadsPanelLayout.createSequentialGroup()
                        .add(16, 16, 16)
                        .add(jLabel5)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(externalLoadsBody1, 0, 127, Short.MAX_VALUE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jLabel7)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(externalLoadsBody2, 0, 139, Short.MAX_VALUE)))
                .addContainerGap())
        );
        externalLoadsPanelLayout.setVerticalGroup(
            externalLoadsPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(externalLoadsPanelLayout.createSequentialGroup()
                .add(externalLoadsPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jLabel3)
                    .add(externalLoadsFileName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(12, 12, 12)
                .add(externalLoadsPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel6)
                    .add(externalLoadsBody1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel5)
                    .add(jLabel7)
                    .add(externalLoadsBody2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(externalLoadsPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jLabel4)
                    .add(externalLoadsModelKinematicsFileName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(13, 13, 13)
                .add(externalLoadsPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(cutoffFrequency, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel8)
                    .add(filterModelKinematics)
                    .add(jLabel9))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        actuatorsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Actuators"));
        keepModelActuators.setText("Include actuators from model file");
        keepModelActuators.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        keepModelActuators.setMargin(new java.awt.Insets(0, 0, 0, 0));
        keepModelActuators.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keepModelActuatorsActionPerformed(evt);
            }
        });

        jLabel1.setText("Additional actuator set files");

        actuatorSetFiles.setEditable(false);
        actuatorSetFiles.setText("jTextField2");

        org.jdesktop.layout.GroupLayout actuatorsPanelLayout = new org.jdesktop.layout.GroupLayout(actuatorsPanel);
        actuatorsPanel.setLayout(actuatorsPanelLayout);
        actuatorsPanelLayout.setHorizontalGroup(
            actuatorsPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(actuatorsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(actuatorsPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(keepModelActuators)
                    .add(actuatorsPanelLayout.createSequentialGroup()
                        .add(jLabel1)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(actuatorSetFiles, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)))
                .addContainerGap())
        );
        actuatorsPanelLayout.setVerticalGroup(
            actuatorsPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(actuatorsPanelLayout.createSequentialGroup()
                .add(keepModelActuators)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(actuatorsPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(actuatorSetFiles, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, externalLoadsPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, actuatorsPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(actuatorsPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(externalLoadsPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

   private void keepModelActuatorsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keepModelActuatorsActionPerformed
      toolModel.setReplaceActuatorSet(!keepModelActuators.isSelected());
   }//GEN-LAST:event_keepModelActuatorsActionPerformed

   private void externalLoadsFileNameStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_externalLoadsFileNameStateChanged
      toolModel.setExternalLoadsFileName(externalLoadsFileName.getFileName());
   }//GEN-LAST:event_externalLoadsFileNameStateChanged

   private void externalLoadsBody1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_externalLoadsBody1ActionPerformed
      if(!internalTrigger) {
         if(externalLoadsBody1.getSelectedItem()==null) toolModel.setExternalLoadsBody1("");
         else toolModel.setExternalLoadsBody1((String)externalLoadsBody1.getSelectedItem());
      }
   }//GEN-LAST:event_externalLoadsBody1ActionPerformed

   private void externalLoadsBody2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_externalLoadsBody2ActionPerformed
      if(!internalTrigger) {
         if(externalLoadsBody2.getSelectedItem()==null) toolModel.setExternalLoadsBody2("");
         else toolModel.setExternalLoadsBody2((String)externalLoadsBody2.getSelectedItem());
      }
   }//GEN-LAST:event_externalLoadsBody2ActionPerformed

   private void externalLoadsModelKinematicsFileNameStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_externalLoadsModelKinematicsFileNameStateChanged
      toolModel.setExternalLoadsModelKinematicsFileName(externalLoadsModelKinematicsFileName.getFileName());
   }//GEN-LAST:event_externalLoadsModelKinematicsFileNameStateChanged
   
   private void filterModelKinematicsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterModelKinematicsActionPerformed
      toolModel.setFilterLoadKinematics(filterModelKinematics.isSelected());
   }//GEN-LAST:event_filterModelKinematicsActionPerformed

   private void cutoffFrequencyFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cutoffFrequencyFocusLost
      if(!evt.isTemporary()) cutoffFrequencyActionPerformed(null);
   }//GEN-LAST:event_cutoffFrequencyFocusLost

   private void cutoffFrequencyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cutoffFrequencyActionPerformed
      try {
         toolModel.setLowpassCutoffFrequencyForLoadKinematics(Double.valueOf(cutoffFrequency.getText()));
      } finally {
         cutoffFrequency.setText(((Double)toolModel.getLowpassCutoffFrequencyForLoadKinematics()).toString());
      }
   }//GEN-LAST:event_cutoffFrequencyActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField actuatorSetFiles;
    private javax.swing.JPanel actuatorsPanel;
    private javax.swing.JTextField cutoffFrequency;
    private javax.swing.JComboBox externalLoadsBody1;
    private javax.swing.JComboBox externalLoadsBody2;
    private org.opensim.swingui.FileTextFieldAndChooser externalLoadsFileName;
    private org.opensim.swingui.FileTextFieldAndChooser externalLoadsModelKinematicsFileName;
    private javax.swing.JPanel externalLoadsPanel;
    private javax.swing.JCheckBox filterModelKinematics;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JCheckBox keepModelActuators;
    // End of variables declaration//GEN-END:variables
   
}
