/*
 * ForwardToolPanel.java
 *
 * Created on July 23, 2007, 6:59 PM
 */

package org.opensim.tracking;

import java.awt.Component;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;
import org.opensim.modeling.Model;

/**
 *
 * @author  erang
 */
public class ForwardToolPanel extends BaseToolPanel implements Observer {
  
   ForwardToolModel toolModel = null;
   ActuatorsAndExternalLoadsPanel actuatorsAndExternalLoadsPanel = null;

   /** Creates new form ForwardToolPanel */
   public ForwardToolPanel(Model model) throws IOException {
      toolModel = new ForwardToolModel(model);

      initComponents();

      outputDirectory.setIncludeOpenButton(true);
      setSettingsFileDescription("Forward tool settings file");

      actuatorsAndExternalLoadsPanel = new ActuatorsAndExternalLoadsPanel(toolModel, toolModel.getOriginalModel());
      jTabbedPane.insertTab("Actuators and External Loads", null, actuatorsAndExternalLoadsPanel, null, 1);

      updateStaticFields();
      updateFromModel();
      toolModel.addObserver(this);
   }

   public void update(Observable observable, Object obj) {
      if(observable == toolModel && obj == AbstractToolModel.Operation.ExecutionStateChanged)
         updateDialogButtons();
      else
         updateFromModel(); 
   }

   private void setEnabled(JPanel panel, boolean enabled) {
      for(Component comp : panel.getComponents()) {
         comp.setEnabled(enabled);
         if(comp instanceof JPanel) setEnabled((JPanel)comp, enabled);
      }
   }

   public void updateStaticFields() {
      modelName.setText(toolModel.getOriginalModel().getName());
   }

   public void updateFromModel() {
      // Start off with everything enabled
      setEnabled(mainSettingsPanel, true);
      setEnabled(advancedSettingsPanel, true);
      setEnabled(actuatorsAndExternalLoadsPanel, true);

      // Input
      controlsFileName.setFileName(toolModel.getControlsFileName(),false);
      initialStatesFileName.setFileName(toolModel.getInitialStatesFileName(),false);

      // Time
      initialTime.setText(((Double)toolModel.getInitialTime()).toString());
      finalTime.setText(((Double)toolModel.getFinalTime()).toString());

      // Output
      outputName.setText(toolModel.getOutputPrefix());
      outputDirectory.setFileName(toolModel.getResultsDirectory(),false);
      outputPrecision.setText(((Integer)toolModel.getOutputPrecision()).toString());

      // Integrator settings
      useSpecifiedDt.setSelected(toolModel.getUseSpecifiedDt());
      maximumNumberOfSteps.setText(((Double)toolModel.getMaximumNumberOfSteps()).toString());
      maxDT.setText(((Double)toolModel.getMaxDT()).toString());
      errorTolerance.setText(((Double)toolModel.getErrorTolerance()).toString());
      fineTolerance.setText(((Double)toolModel.getFineTolerance()).toString());
      
      // Actuators & external loads
      actuatorsAndExternalLoadsPanel.updatePanel();
   }

   public void updateDialogButtons() {
      updateApplyButton(!toolModel.isExecuting() && toolModel.isModified() && toolModel.isValid());
   }

   //------------------------------------------------------------------------
   // Overrides from BaseToolPanel
   //------------------------------------------------------------------------

   public void loadSettings(String fileName) { toolModel.loadSettings(fileName); }
   public void saveSettings(String fileName) { toolModel.saveSettings(fileName); }

   public void pressedCancel() {
      toolModel.cancel();
   }

   public void pressedClose() {
   }

   public void pressedApply() {
      toolModel.execute();
      updateDialogButtons();
   }

   /** This method is called from within the constructor to
    * initialize the form.
    * WARNING: Do NOT modify this code. The content of this method is
    * always regenerated by the Form Editor.
    */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jTabbedPane = new javax.swing.JTabbedPane();
        mainSettingsPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        controlsFileName = new org.opensim.swingui.FileTextFieldAndChooser();
        jLabel1 = new javax.swing.JLabel();
        initialStatesFileName = new org.opensim.swingui.FileTextFieldAndChooser();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        initialTime = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        finalTime = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        outputName = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        outputDirectory = new org.opensim.swingui.FileTextFieldAndChooser();
        outputPrecision = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        modelName = new javax.swing.JTextField();
        advancedSettingsPanel = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        useSpecifiedDt = new javax.swing.JCheckBox();
        jLabel6 = new javax.swing.JLabel();
        maximumNumberOfSteps = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        maxDT = new javax.swing.JTextField();
        errorTolerance = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        fineTolerance = new javax.swing.JTextField();

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Input"));
        jLabel3.setText("Controls");

        jLabel1.setText("Initial states");

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel2Layout.createSequentialGroup()
                        .add(19, 19, 19)
                        .add(jLabel3))
                    .add(jLabel1))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(controlsFileName, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                    .add(initialStatesFileName, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jLabel3)
                    .add(controlsFileName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jLabel1)
                    .add(initialStatesFileName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Time"));
        jLabel4.setText("Initial time");

        initialTime.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        initialTime.setText("0");
        initialTime.setMinimumSize(new java.awt.Dimension(64, 19));

        jLabel5.setText("Final time");

        finalTime.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        finalTime.setText("0");
        finalTime.setMinimumSize(new java.awt.Dimension(64, 19));

        org.jdesktop.layout.GroupLayout jPanel3Layout = new org.jdesktop.layout.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel4)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(initialTime, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 64, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(35, 35, 35)
                .add(jLabel5)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(finalTime, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 64, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(new java.awt.Component[] {finalTime, initialTime}, org.jdesktop.layout.GroupLayout.HORIZONTAL);

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel3Layout.createSequentialGroup()
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel4)
                    .add(jLabel5)
                    .add(finalTime, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(initialTime, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 20, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Output"));
        jLabel14.setText("Name");

        outputName.setText("jTextField1");
        outputName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outputNameActionPerformed(evt);
            }
        });
        outputName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                outputNameFocusLost(evt);
            }
        });

        jLabel15.setText("Directory");

        outputDirectory.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                outputDirectoryStateChanged(evt);
            }
        });

        outputPrecision.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        outputPrecision.setText("0");
        outputPrecision.setMinimumSize(new java.awt.Dimension(64, 19));
        outputPrecision.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outputPrecisionActionPerformed(evt);
            }
        });
        outputPrecision.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                outputPrecisionFocusLost(evt);
            }
        });

        jLabel16.setText("Precision");

        org.jdesktop.layout.GroupLayout jPanel4Layout = new org.jdesktop.layout.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel16)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel15)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel14))
                .add(9, 9, 9)
                .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(outputPrecision, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 64, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel4Layout.createSequentialGroup()
                        .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, outputName, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                            .add(outputDirectory, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel4Layout.createSequentialGroup()
                .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel14)
                    .add(outputName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jLabel15)
                    .add(outputDirectory, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(outputPrecision, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel16))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Current Model"));
        jLabel2.setText("Name");

        modelName.setEditable(false);
        modelName.setText("jTextField1");

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel2)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(modelName, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(6, 6, 6)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel2)
                    .add(modelName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout mainSettingsPanelLayout = new org.jdesktop.layout.GroupLayout(mainSettingsPanel);
        mainSettingsPanel.setLayout(mainSettingsPanelLayout);
        mainSettingsPanelLayout.setHorizontalGroup(
            mainSettingsPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(mainSettingsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(mainSettingsPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel2, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jPanel3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jPanel4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        mainSettingsPanelLayout.setVerticalGroup(
            mainSettingsPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(mainSettingsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jTabbedPane.addTab("Main Settings", mainSettingsPanel);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Integrator Settings"));
        jLabel7.setText("Integrator steps:");

        jLabel9.setText("Integrator tolerances:");

        jLabel12.setText("Error tolerance");

        useSpecifiedDt.setText("Use time steps from states file");
        useSpecifiedDt.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        useSpecifiedDt.setMargin(new java.awt.Insets(0, 0, 0, 0));

        jLabel6.setText("Maximum number");

        maximumNumberOfSteps.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        maximumNumberOfSteps.setText("jTextField5");

        jLabel13.setText("Maximum  size");

        maxDT.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        maxDT.setText("jTextField6");

        errorTolerance.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        errorTolerance.setText("jTextField7");

        jLabel8.setText("Fine tolerance");

        fineTolerance.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        fineTolerance.setText("jTextField8");

        org.jdesktop.layout.GroupLayout jPanel5Layout = new org.jdesktop.layout.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(useSpecifiedDt)
                    .add(jPanel5Layout.createSequentialGroup()
                        .add(jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel7)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel9))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel5Layout.createSequentialGroup()
                                .add(jLabel12)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(errorTolerance, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 64, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(jPanel5Layout.createSequentialGroup()
                                .add(jLabel6)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(maximumNumberOfSteps, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel8)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel13))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(maxDT, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                            .add(fineTolerance, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)))
                .addContainerGap())
        );

        jPanel5Layout.linkSize(new java.awt.Component[] {errorTolerance, fineTolerance, maxDT, maximumNumberOfSteps}, org.jdesktop.layout.GroupLayout.HORIZONTAL);

        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel5Layout.createSequentialGroup()
                .add(useSpecifiedDt)
                .add(5, 5, 5)
                .add(jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel7)
                    .add(jLabel13)
                    .add(maxDT, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel6)
                    .add(maximumNumberOfSteps, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel9)
                    .add(jLabel12)
                    .add(errorTolerance, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel8)
                    .add(fineTolerance, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout advancedSettingsPanelLayout = new org.jdesktop.layout.GroupLayout(advancedSettingsPanel);
        advancedSettingsPanel.setLayout(advancedSettingsPanelLayout);
        advancedSettingsPanelLayout.setHorizontalGroup(
            advancedSettingsPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(advancedSettingsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel5, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        advancedSettingsPanelLayout.setVerticalGroup(
            advancedSettingsPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(advancedSettingsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jTabbedPane.addTab("Advanced Settings", advancedSettingsPanel);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(jTabbedPane, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(jTabbedPane, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

   private void outputPrecisionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_outputPrecisionFocusLost
      if(!evt.isTemporary()) outputPrecisionActionPerformed(null);
   }//GEN-LAST:event_outputPrecisionFocusLost

   private void outputPrecisionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outputPrecisionActionPerformed
      try {
         toolModel.setOutputPrecision(Integer.valueOf(outputPrecision.getText()));
      } finally {
         outputPrecision.setText(((Integer)toolModel.getOutputPrecision()).toString());
      }
   }//GEN-LAST:event_outputPrecisionActionPerformed

   private void outputDirectoryStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_outputDirectoryStateChanged
      toolModel.setResultsDirectory(outputDirectory.getFileName());
   }//GEN-LAST:event_outputDirectoryStateChanged

   private void outputNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_outputNameFocusLost
      if(!evt.isTemporary()) outputNameActionPerformed(null);
   }//GEN-LAST:event_outputNameFocusLost

   private void outputNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outputNameActionPerformed
      toolModel.setOutputPrefix(outputName.getText());
   }//GEN-LAST:event_outputNameActionPerformed
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel advancedSettingsPanel;
    private org.opensim.swingui.FileTextFieldAndChooser controlsFileName;
    private javax.swing.JTextField errorTolerance;
    private javax.swing.JTextField finalTime;
    private javax.swing.JTextField fineTolerance;
    private org.opensim.swingui.FileTextFieldAndChooser initialStatesFileName;
    private javax.swing.JTextField initialTime;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTabbedPane jTabbedPane;
    private javax.swing.JPanel mainSettingsPanel;
    private javax.swing.JTextField maxDT;
    private javax.swing.JTextField maximumNumberOfSteps;
    private javax.swing.JTextField modelName;
    private org.opensim.swingui.FileTextFieldAndChooser outputDirectory;
    private javax.swing.JTextField outputName;
    private javax.swing.JTextField outputPrecision;
    private javax.swing.JCheckBox useSpecifiedDt;
    // End of variables declaration//GEN-END:variables
   
}
