package org.opensim.tracking;

import java.io.IOException;
import java.util.prefs.Preferences;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import org.openide.windows.WindowManager;
import org.opensim.modeling.AbstractModel;
import org.opensim.modeling.IKTaskSet;
import org.opensim.modeling.IKTool;
import org.opensim.modeling.SimmIKTrial;
import org.opensim.modeling.SimmIKTrialSet;
import org.opensim.utils.FileUtils;
import org.opensim.utils.TheApp;
import org.opensim.view.SingleModelVisuals;
import org.opensim.view.editors.ObjectEditDialogMaker;
import org.opensim.view.pub.ViewDB;

public final class IKVisualPanel extends workflowVisualPanelBase {
    
    int numTrials;
   SimmIKTrialSet trialSet=null;
   SimmIKTrial[] availableTrials=null;
    static boolean initialized=false;   // Tooltips and other GUI elements need to be set only once
    IKTool ik = new IKTool();
    /**
     * Creates new form IKVisualPanel
     */
    public IKVisualPanel(workflowWizardPanelBase basePanel) {
        super(basePanel);
        initComponents();
        putClientProperty("WizardPanel_helpURL",this.getClass().getResource("help/html/SubjectSpecificWorkflow.htm")); 
    }
    
    public String getName() {
        return "Inverse Kinematics";
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jTrialSelectionPanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jTrialFileTextField = new javax.swing.JTextField();
        jBrowse4TRCButton5 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jFromTextField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jToTextField = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTrialSelectComboBox = new javax.swing.JComboBox();
        jOutputPanel = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jOutputMotionTextField = new javax.swing.JTextField();
        jBrowse4OutputMotionButton = new javax.swing.JButton();
        jIncludeMarkersInOutputCheckBox = new javax.swing.JCheckBox();
        jIncludeUserDataCheckBox = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jMessageTextArea = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jSetupFilenameTextField = new javax.swing.JTextField();
        jBrowse4SetupButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jIKTasksFileTextField = new javax.swing.JTextField();
        jBrowseForIKTasksButton = new javax.swing.JButton();
        jEditIKTasksButton = new javax.swing.JButton();

        jTrialSelectionPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Trials to solve"));
        org.openide.awt.Mnemonics.setLocalizedText(jLabel4, "Trial file");

        jBrowse4TRCButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/opensim/swingui/FolderOpen.gif")));
        jBrowse4TRCButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBrowse4TRCButton5ActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel6, "use time from");

        org.openide.awt.Mnemonics.setLocalizedText(jLabel7, "to");

        org.openide.awt.Mnemonics.setLocalizedText(jLabel11, "Select trial");

        jTrialSelectComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTrialSelectComboBoxActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jTrialSelectionPanelLayout = new org.jdesktop.layout.GroupLayout(jTrialSelectionPanel);
        jTrialSelectionPanel.setLayout(jTrialSelectionPanelLayout);
        jTrialSelectionPanelLayout.setHorizontalGroup(
            jTrialSelectionPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jTrialSelectionPanelLayout.createSequentialGroup()
                .add(jTrialSelectionPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jTrialSelectionPanelLayout.createSequentialGroup()
                        .add(24, 24, 24)
                        .add(jLabel6)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jFromTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 48, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jLabel7)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jToTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 48, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jTrialSelectionPanelLayout.createSequentialGroup()
                        .add(jTrialSelectionPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel11)
                            .add(jLabel4))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jTrialSelectionPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jTrialSelectionPanelLayout.createSequentialGroup()
                                .add(jTrialFileTextField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                                .add(6, 6, 6))
                            .add(jTrialSelectComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 149, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jBrowse4TRCButton5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 32, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jTrialSelectionPanelLayout.setVerticalGroup(
            jTrialSelectionPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jTrialSelectionPanelLayout.createSequentialGroup()
                .add(jTrialSelectionPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel11)
                    .add(jTrialSelectComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jTrialSelectionPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel4)
                    .add(jBrowse4TRCButton5)
                    .add(jTrialFileTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(5, 5, 5)
                .add(jTrialSelectionPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel6)
                    .add(jFromTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel7)
                    .add(jToTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(77, 77, 77))
        );

        jOutputPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Output files"));
        org.openide.awt.Mnemonics.setLocalizedText(jLabel10, "Motion file");

        jOutputMotionTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jOutputMotionTextFieldActionPerformed(evt);
            }
        });

        jBrowse4OutputMotionButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/opensim/swingui/FolderOpen.gif")));
        jBrowse4OutputMotionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBrowse4OutputMotionButtonActionPerformed(evt);
            }
        });

        jIncludeMarkersInOutputCheckBox.setSelected(true);
        org.openide.awt.Mnemonics.setLocalizedText(jIncludeMarkersInOutputCheckBox, "include markers");
        jIncludeMarkersInOutputCheckBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jIncludeMarkersInOutputCheckBox.setMargin(new java.awt.Insets(0, 0, 0, 0));

        jIncludeUserDataCheckBox.setSelected(true);
        org.openide.awt.Mnemonics.setLocalizedText(jIncludeUserDataCheckBox, "include other data from motion file ");
        jIncludeUserDataCheckBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jIncludeUserDataCheckBox.setMargin(new java.awt.Insets(0, 0, 0, 0));

        org.jdesktop.layout.GroupLayout jOutputPanelLayout = new org.jdesktop.layout.GroupLayout(jOutputPanel);
        jOutputPanel.setLayout(jOutputPanelLayout);
        jOutputPanelLayout.setHorizontalGroup(
            jOutputPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jOutputPanelLayout.createSequentialGroup()
                .add(jOutputPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jOutputPanelLayout.createSequentialGroup()
                        .add(jLabel10)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jOutputMotionTextField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jBrowse4OutputMotionButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 32, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jOutputPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .add(jIncludeMarkersInOutputCheckBox)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jIncludeUserDataCheckBox)))
                .addContainerGap())
        );
        jOutputPanelLayout.setVerticalGroup(
            jOutputPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jOutputPanelLayout.createSequentialGroup()
                .add(jOutputPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel10)
                    .add(jBrowse4OutputMotionButton)
                    .add(jOutputMotionTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jOutputPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jIncludeMarkersInOutputCheckBox)
                    .add(jIncludeUserDataCheckBox)))
        );

        jScrollPane1.setBorder(null);
        jScrollPane1.setForeground(new java.awt.Color(204, 0, 51));
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane1.setEnabled(false);
        jScrollPane1.setFocusable(false);
        jMessageTextArea.setBackground(new java.awt.Color(224, 223, 227));
        jMessageTextArea.setColumns(20);
        jMessageTextArea.setEditable(false);
        jMessageTextArea.setForeground(new java.awt.Color(204, 0, 51));
        jMessageTextArea.setRows(5);
        jMessageTextArea.setBorder(null);
        jMessageTextArea.setFocusable(false);
        jMessageTextArea.setOpaque(false);
        jScrollPane1.setViewportView(jMessageTextArea);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Setup file"));
        org.openide.awt.Mnemonics.setLocalizedText(jLabel8, "Setup file ");

        jBrowse4SetupButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/opensim/swingui/FolderOpen.gif")));
        jBrowse4SetupButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBrowse4SetupButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel5, "IK Tasks file");

        jBrowseForIKTasksButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/opensim/swingui/FolderOpen.gif")));
        jBrowseForIKTasksButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBrowseForIKTasksButtonActionPerformed(evt);
            }
        });

        jEditIKTasksButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/opensim/swingui/editor.gif")));
        jEditIKTasksButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jEditIKTasksButtonActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel8)
                    .add(jLabel5))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jIKTasksFileTextField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                    .add(jSetupFilenameTextField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(jBrowseForIKTasksButton, 0, 0, Short.MAX_VALUE)
                    .add(jBrowse4SetupButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 32, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 17, Short.MAX_VALUE)
                .add(jEditIKTasksButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 32, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel8)
                    .add(jBrowse4SetupButton)
                    .add(jSetupFilenameTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel5)
                    .add(jIKTasksFileTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jEditIKTasksButton)
                    .add(jBrowseForIKTasksButton))
                .add(31, 31, 31))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jTrialSelectionPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jOutputPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 87, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jTrialSelectionPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 120, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jOutputPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 153, Short.MAX_VALUE)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jEditIKTasksButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jEditIKTasksButtonActionPerformed
        String ikTasksFilename = jIKTasksFileTextField.getText();
        IKTaskSet taskSet = new IKTaskSet(jIKTasksFileTextField.getText());
        new ObjectEditDialogMaker(taskSet, true).process();
        taskSet.print(ikTasksFilename);
// TODO add your handling code here:
    }//GEN-LAST:event_jEditIKTasksButtonActionPerformed

    private void jBrowseForIKTasksButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBrowseForIKTasksButtonActionPerformed
       String ikTasksFilename = FileUtils.getInstance().
               browseForFilename(".xml", "File specifying IK tasks");
       if (ikTasksFilename != null) {
            jIKTasksFileTextField.setText(ikTasksFilename);
       }
// TODO add your handling code here:
    }//GEN-LAST:event_jBrowseForIKTasksButtonActionPerformed
    
    private void jBrowse4SetupButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBrowse4SetupButtonActionPerformed
// TODO add your handling code here:
        String defaultDir="";
        defaultDir = Preferences.userNodeForPackage(TheApp.class).get("WorkDirectory", defaultDir);
        final JFileChooser dlog = new JFileChooser(defaultDir);
        dlog.setFileFilter(FileUtils.getFileFilter(".xml", "Setup for IK"));
        
        String setupFile=null;
        
        if (dlog.showOpenDialog((JFrame) WindowManager.getDefault().getMainWindow()) == JFileChooser.APPROVE_OPTION && dlog.getSelectedFile() != null) {
            setupFile= dlog.getSelectedFile().getAbsolutePath();
            jSetupFilenameTextField.setText(setupFile);
            Preferences.userNodeForPackage(TheApp.class).put("WorkDirectory", dlog.getSelectedFile().getParent());
            // create an investigation and fill in the fields
            ik = new IKTool(jSetupFilenameTextField.getText(), logicPanel.descriptor.getIKModel()); 
            AbstractModel mdl = ik.getModel();
            SingleModelVisuals visModel = ViewDB.getInstance().getModelVisuals(mdl);
            
            logicPanel.descriptor.setSetupIKFilename(jSetupFilenameTextField.getText());
            jMessageTextArea.setText("");
            updatePanel(logicPanel.descriptor);
        }
       
    }//GEN-LAST:event_jBrowse4SetupButtonActionPerformed

    private void jOutputMotionTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jOutputMotionTextFieldActionPerformed
// TODO add your handling code here:
        checkValidForm();
    }//GEN-LAST:event_jOutputMotionTextFieldActionPerformed

    private void jBrowse4OutputMotionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBrowse4OutputMotionButtonActionPerformed
       final JFileChooser dlog = new JFileChooser("");
       dlog.setFileFilter(FileUtils.getFileFilter(".mot", "Motion file to initialize static pose solution"));

       if (dlog.showOpenDialog(null) == JFileChooser.APPROVE_OPTION && dlog.getSelectedFile() != null) {
            jOutputMotionTextField.setText(dlog.getSelectedFile().getAbsolutePath());
            Preferences.userNodeForPackage(TheApp.class).put("WorkDirectory", dlog.getSelectedFile().getParent());
       }
// TODO add your handling code here:
    }//GEN-LAST:event_jBrowse4OutputMotionButtonActionPerformed

    private void jBrowse4TRCButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBrowse4TRCButton5ActionPerformed
       final JFileChooser dlog = new JFileChooser("");
       dlog.setFileFilter(FileUtils.getFileFilter(".trc", "Static trial file"));

       if (dlog.showOpenDialog(null) == JFileChooser.APPROVE_OPTION && dlog.getSelectedFile() != null) {
            jTrialFileTextField.setText(dlog.getSelectedFile().getAbsolutePath());
            Preferences.userNodeForPackage(TheApp.class).put("WorkDirectory", dlog.getSelectedFile().getParent());
       }
       // TODO add your handling code here:
    }//GEN-LAST:event_jBrowse4TRCButton5ActionPerformed

    private void jTrialSelectComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTrialSelectComboBoxActionPerformed
// TODO add your handling code here:
        JComboBox trialSelect = (JComboBox)evt.getSource();
       makeTrialCurrent((SimmIKTrial) trialSelect.getSelectedItem());
    }//GEN-LAST:event_jTrialSelectComboBoxActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBrowse4OutputMotionButton;
    private javax.swing.JButton jBrowse4SetupButton;
    private javax.swing.JButton jBrowse4TRCButton5;
    private javax.swing.JButton jBrowseForIKTasksButton;
    private javax.swing.JButton jEditIKTasksButton;
    private javax.swing.JTextField jFromTextField;
    private javax.swing.JTextField jIKTasksFileTextField;
    private javax.swing.JCheckBox jIncludeMarkersInOutputCheckBox;
    private javax.swing.JCheckBox jIncludeUserDataCheckBox;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextArea jMessageTextArea;
    private javax.swing.JTextField jOutputMotionTextField;
    private javax.swing.JPanel jOutputPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jSetupFilenameTextField;
    private javax.swing.JTextField jToTextField;
    private javax.swing.JTextField jTrialFileTextField;
    private javax.swing.JComboBox jTrialSelectComboBox;
    private javax.swing.JPanel jTrialSelectionPanel;
    // End of variables declaration//GEN-END:variables
    void updateWorkflow(WorkflowDescriptor descriptor) {
      
       // model file, markers, coords, trial-name, trial-file, from, to, motfile, inc markers, inc-others
       SimmIKTrialSet trialSet = ik.getIKTrialSet();
       if (trialSet.getSize()>0){
           trialSet.get(0).setEndTime(Double.parseDouble(jToTextField.getText()));
           trialSet.get(0).setStartTime(Double.parseDouble(jFromTextField.getText()));
           trialSet.get(0).setOutputMotionFilename(jOutputMotionTextField.getText());
       }
        descriptor.setIKoutfilename(jOutputMotionTextField.getText());
    }

    void updatePanel(WorkflowDescriptor aDescriptor) {
        initialize(aDescriptor);    // Tooltip
        String filename = aDescriptor.getSetupIKFilename();
        if (filename != null){
            IKTool.registerTypes();
            ik = new IKTool(filename, aDescriptor.getIKModel());
        }
        String modelFile = ik.getModelFilename();
       numTrials = ik.getIKTrialSet().getSize();
        if (numTrials==0){
           jTrialSelectComboBox.setEnabled(false);
           appendMessage("No trials are available");
       } else { // at least one
          availableTrials = new SimmIKTrial[numTrials];
            for(int i=0; i < numTrials; i++){
             availableTrials[i] = ik.getIKTrialSet().get(i);
            }
            if (jTrialSelectComboBox.getModel().getSize()==0){
                for(int i=0; i < numTrials; i++){
                    jTrialSelectComboBox.setModel(new DefaultComboBoxModel(availableTrials));
                }                
            
            }
             // Get data for first trial and populate the dialog.
            makeTrialCurrent(availableTrials[0]);
        }
       checkConsistentPanel();
    }
    /**
     * Mark one of the trials as current and update the GUI accordingly
     */
    private void makeTrialCurrent(SimmIKTrial simmIKTrialParams) {
        String trialName = simmIKTrialParams.getName();
        jTrialFileTextField.setText(simmIKTrialParams.getMarkerDataFilename());  //.trc
        jFromTextField.setText(String.valueOf(simmIKTrialParams.getStartTime()));
        jToTextField.setText(String.valueOf(simmIKTrialParams.getEndTime()));
        jOutputMotionTextField.setText(simmIKTrialParams.getOutputMotionFilename());
       try {
        jOutputMotionTextField.setToolTipText(simmIKTrialParams.getPropertySet().get("output_motion_file").getComment());
       } catch (IOException ex) {
          TheApp.exitApp("Internal Error:Property output_motion_file does not exist in SimmIKTrial");
       }
        jIncludeMarkersInOutputCheckBox.setSelected(simmIKTrialParams.getIncludeMarkers());
    }

    private void initialize(WorkflowDescriptor aDescriptor) {
     }
    /**
     * @returns trial selected by the user 
     */
    public SimmIKTrial getSelectedTrial() {
       return ((SimmIKTrial)jTrialSelectComboBox.getSelectedItem());
    }

    public void appendMessage(String message) {
        jMessageTextArea.setText(message); 
    }

    protected boolean checkValidForm() {
        return (jOutputMotionTextField.getText().length()!=0);
    }
    
    public IKTool getSimulationTool() {
        return ik;
    }
    /**
     * checkConsistentPanel of various GUI elements based on context/current selections
     */
    public void checkConsistentPanel() {
       boolean emptySetupFile = jSetupFilenameTextField.getText().equals("");
       setGuiCanAdvance(!emptySetupFile);
}
}

