package org.opensim.tracking;

import java.util.prefs.Preferences;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import org.openide.windows.WindowManager;
import org.opensim.modeling.SimmMarkerPlacer;
import org.opensim.utils.FileUtils;
import org.opensim.utils.TheApp;

public final class MakeDModelVisualPanel extends workflowVisualPanelBase {
    
    /**
     * Creates new form MakeDModelVisualPanel
     */
    public MakeDModelVisualPanel(workflowWizardPanelBase basePanel) {
        super(basePanel);
        initComponents();
        putClientProperty("WizardPanel_helpURL",this.getClass().getResource("help/html/SubjectSpecificWorkflow.htm")); 
    }
    
    public String getName() {
        return "Generate dynamic model";
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jModelSpecPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jModelTextField = new javax.swing.JTextField();
        jBrowse4ModelButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jDynamicsDirTextField = new javax.swing.JTextField();
        jBrowseForDynamicsDirButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jMusclefileTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        KineticsFileTextField = new javax.swing.JTextField();
        jMessageTextArea = new javax.swing.JTextArea();

        jModelSpecPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Model Specification"));
        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, "Model file");

        jBrowse4ModelButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/opensim/swingui/FolderOpen.gif")));
        jBrowse4ModelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBrowse4ModelButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, "Directory for dynamics files:");

        jDynamicsDirTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jDynamicsDirTextFieldActionPerformed(evt);
            }
        });

        jBrowseForDynamicsDirButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/opensim/swingui/FolderOpen.gif")));
        jBrowseForDynamicsDirButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBrowseForDynamicsDirButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel3, "SIMM Muscle file");

        jMusclefileTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMusclefileTextFieldActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel4, "Kinetics file");

        org.jdesktop.layout.GroupLayout jModelSpecPanelLayout = new org.jdesktop.layout.GroupLayout(jModelSpecPanel);
        jModelSpecPanel.setLayout(jModelSpecPanelLayout);
        jModelSpecPanelLayout.setHorizontalGroup(
            jModelSpecPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jModelSpecPanelLayout.createSequentialGroup()
                .add(jModelSpecPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jModelSpecPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .add(jDynamicsDirTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 186, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jBrowseForDynamicsDirButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 32, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jModelSpecPanelLayout.createSequentialGroup()
                        .add(jModelSpecPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel1)
                            .add(jLabel3)
                            .add(jLabel2)
                            .add(jLabel4))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jModelSpecPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(KineticsFileTextField)
                            .add(jMusclefileTextField)
                            .add(jModelTextField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE))
                        .add(6, 6, 6)
                        .add(jBrowse4ModelButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 32, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jModelSpecPanelLayout.setVerticalGroup(
            jModelSpecPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jModelSpecPanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(jModelSpecPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(jModelTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jBrowse4ModelButton))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jModelSpecPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel3)
                    .add(jMusclefileTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jModelSpecPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel4)
                    .add(KineticsFileTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jLabel2)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jModelSpecPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jBrowseForDynamicsDirButton)
                    .add(jDynamicsDirTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
        );

        jMessageTextArea.setBackground(new java.awt.Color(224, 223, 227));
        jMessageTextArea.setColumns(20);
        jMessageTextArea.setEditable(false);
        jMessageTextArea.setFont(new java.awt.Font("Courier", 0, 12));
        jMessageTextArea.setForeground(new java.awt.Color(204, 0, 51));
        jMessageTextArea.setRows(5);
        jMessageTextArea.setText("Create a shared library to represent the dynamics \nof your model (.dll on Windows, .so on linux). \nUse SD/Fast, C compiler and the files created \nby OpenSim (model.h, model.sd, sdfor.c).\nPlace the generated shared library in your PATH.\n");
        jMessageTextArea.setWrapStyleWord(true);
        jMessageTextArea.setBorder(null);
        jMessageTextArea.setFocusable(false);
        jMessageTextArea.setOpaque(false);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jMessageTextArea, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
            .add(jModelSpecPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(jModelSpecPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jMessageTextArea, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 163, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jMusclefileTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMusclefileTextFieldActionPerformed
// TODO add your handling code here:
    }//GEN-LAST:event_jMusclefileTextFieldActionPerformed

    private void jDynamicsDirTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jDynamicsDirTextFieldActionPerformed
// TODO add your handling code here:
    }//GEN-LAST:event_jDynamicsDirTextFieldActionPerformed

    private void jBrowseForDynamicsDirButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBrowseForDynamicsDirButtonActionPerformed
        String defaultDir="";
        defaultDir = Preferences.userNodeForPackage(TheApp.class).get("WorkDirectory", defaultDir);
        final JFileChooser dlog = new JFileChooser(defaultDir);
        dlog.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        if (dlog.showOpenDialog((JFrame) WindowManager.getDefault().getMainWindow()) == JFileChooser.APPROVE_OPTION && dlog.getSelectedFile() != null) {
            jDynamicsDirTextField.setText(dlog.getSelectedFile().getAbsolutePath());
            Preferences.userNodeForPackage(TheApp.class).put("WorkDirectory", dlog.getSelectedFile().getParent());
        }
// TODO add your handling code here:
    }//GEN-LAST:event_jBrowseForDynamicsDirButtonActionPerformed

    private void jBrowse4ModelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBrowse4ModelButtonActionPerformed
        String defaultDir="";
        defaultDir = Preferences.userNodeForPackage(TheApp.class).get("WorkDirectory", defaultDir);
        final JFileChooser dlog = new JFileChooser(defaultDir);
        dlog.setFileFilter(FileUtils.getFileFilter(".xml", "Model to write dynamics for"));
        if (dlog.showOpenDialog((JFrame) WindowManager.getDefault().getMainWindow()) == JFileChooser.APPROVE_OPTION && dlog.getSelectedFile() != null) {
            jModelTextField.setText(dlog.getSelectedFile().getAbsolutePath());
            Preferences.userNodeForPackage(TheApp.class).put("WorkDirectory", dlog.getSelectedFile().getParent());
        }
// TODO add your handling code here:
    }//GEN-LAST:event_jBrowse4ModelButtonActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField KineticsFileTextField;
    private javax.swing.JButton jBrowse4ModelButton;
    private javax.swing.JButton jBrowseForDynamicsDirButton;
    private javax.swing.JTextField jDynamicsDirTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextArea jMessageTextArea;
    private javax.swing.JPanel jModelSpecPanel;
    private javax.swing.JTextField jModelTextField;
    private javax.swing.JTextField jMusclefileTextField;
    // End of variables declaration//GEN-END:variables
    void updateWorkflow(WorkflowDescriptor descriptor) {
        descriptor.setDynamicsModelFile(jModelTextField.getText());
        descriptor.setDynamicsDir(jDynamicsDirTextField.getText());
    }

    void updatePanel(WorkflowDescriptor aDescriptor) {
        // file is the output file from MarkerPlacement by default
        if (aDescriptor.getDynamicsModelFile() == null || aDescriptor.getDynamicsModelFile().equals("")){
            SimmMarkerPlacer params = aDescriptor.getSubject().getMarkerPlacer();
            jModelTextField.setText(aDescriptor.getSubject().getPathToSubject()+params.getOutputModelFileName());
        }
        else
            jModelTextField.setText(aDescriptor.getDynamicsModelFile());
        jDynamicsDirTextField.setText(aDescriptor.getSubject().getPathToSubject());
        
        String defaultFilename = aDescriptor.getSubject().getModelScaler().getOutputMuscleFileName();
        if (defaultFilename.equalsIgnoreCase("Unassigned") ||
                defaultFilename.equalsIgnoreCase("")){
            defaultFilename=aDescriptor.getSubject().getMarkerPlacer().getOutputMuscleFileName();
        }
        
        if (!defaultFilename.equalsIgnoreCase("Unassigned")){
            jMusclefileTextField.setText(defaultFilename);
        }
        else 
            jMusclefileTextField.setText("");
        
        String ikOutfilename = aDescriptor.getIKoutfilename();
         if (!ikOutfilename.equalsIgnoreCase("Unassigned")){
            KineticsFileTextField.setText(ikOutfilename);
        }
        else
            KineticsFileTextField.setText("");
        
        checkConsistentPanel();
       
    }

    public void appendMessage(String message) {
        jMessageTextArea.append(message);
        repaint();
    }
    /**
     * Query the form for the data we need to perform SaveDynamics
     */
    public String getModelFilename()
    {
        return jModelTextField.getText();
    }
    
    public String getDynamicsDirectory()
    {
        return jDynamicsDirTextField.getText();
    }
    
    public String getMuscleFilename()
    {
        return jMusclefileTextField.getText();
    }
    
    public String getKineticsFilename()
    {
        return KineticsFileTextField.getText();
    }

    public void checkConsistentPanel() {
        setGuiCanAdvance(true);
    }

}

