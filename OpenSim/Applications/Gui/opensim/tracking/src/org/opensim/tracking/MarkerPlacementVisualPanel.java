package org.opensim.tracking;

import java.io.IOException;
import org.opensim.modeling.ArrayDouble;
import org.opensim.modeling.IKTaskSet;
import org.opensim.modeling.MarkerData;
import org.opensim.modeling.MarkerPlacer;
import org.opensim.utils.FileUtils;
import org.opensim.utils.TheApp;
import org.opensim.view.editors.ObjectEditDialogMaker;

public final class MarkerPlacementVisualPanel extends workflowVisualPanelBase {
    
    /**
     * Creates new form MarkerPlacementVisualPanel
     */
    public MarkerPlacementVisualPanel(workflowWizardPanelBase basePanel) {
        super(basePanel);
        initComponents();
        putClientProperty("WizardPanel_helpURL",this.getClass().getResource("help/html/SubjectSpecificWorkflow.htm")); 
    }
    
    public String getName() {
        return "Place markers based on trial";
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jSolveStaticPosePanel = new javax.swing.JPanel();
        jStaticTrialTextField = new javax.swing.JTextField();
        jBrowse4TrcButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jStaticFromTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jStaticToTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jIKTasksFileTextField = new javax.swing.JTextField();
        jBrowseForIKTasksButton = new javax.swing.JButton();
        jEditIKTasksButton = new javax.swing.JButton();
        jOutputFilesPanel = new javax.swing.JPanel();
        jOutputMarkersFileNameTextField = new javax.swing.JTextField();
        jSimmJntCheckBox = new javax.swing.JCheckBox();
        iSaveMarkersCheckBox = new javax.swing.JCheckBox();
        jSaveMotionCheckBox = new javax.swing.JCheckBox();
        jOutputMotionTextField = new javax.swing.JTextField();
        jOutputJntTextField = new javax.swing.JTextField();
        jSaveOsimCheckBox = new javax.swing.JCheckBox();
        jOsimFilenameTextField = new javax.swing.JTextField();
        jBrowseOsimButton = new javax.swing.JButton();
        jBrowseMarkersButton = new javax.swing.JButton();
        jBrowseMotionButton = new javax.swing.JButton();
        jBrowseJntButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jMessageTextArea = new javax.swing.JTextArea();

        jSolveStaticPosePanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Static pose"));

        jBrowse4TrcButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/opensim/swingui/FolderOpen.gif")));
        jBrowse4TrcButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBrowse4TrcButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, "Static trial file");

        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, "use time from");

        jStaticFromTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jStaticFromTextFieldActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel3, "to");

        org.openide.awt.Mnemonics.setLocalizedText(jLabel4, "IK Tasks file");

        jIKTasksFileTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jIKTasksFileTextFieldActionPerformed(evt);
            }
        });

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

        org.jdesktop.layout.GroupLayout jSolveStaticPosePanelLayout = new org.jdesktop.layout.GroupLayout(jSolveStaticPosePanel);
        jSolveStaticPosePanel.setLayout(jSolveStaticPosePanelLayout);
        jSolveStaticPosePanelLayout.setHorizontalGroup(
            jSolveStaticPosePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jSolveStaticPosePanelLayout.createSequentialGroup()
                .add(jSolveStaticPosePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jSolveStaticPosePanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .add(jLabel2)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jStaticFromTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 52, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jLabel3)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jStaticToTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 46, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jSolveStaticPosePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                        .add(org.jdesktop.layout.GroupLayout.LEADING, jSolveStaticPosePanelLayout.createSequentialGroup()
                            .add(jLabel1)
                            .add(13, 13, 13)
                            .add(jStaticTrialTextField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE))
                        .add(org.jdesktop.layout.GroupLayout.LEADING, jSolveStaticPosePanelLayout.createSequentialGroup()
                            .add(jLabel4)
                            .add(20, 20, 20)
                            .add(jIKTasksFileTextField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE))))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jSolveStaticPosePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(jBrowseForIKTasksButton, 0, 0, Short.MAX_VALUE)
                    .add(jBrowse4TrcButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 35, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jEditIKTasksButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 32, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jSolveStaticPosePanelLayout.setVerticalGroup(
            jSolveStaticPosePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jSolveStaticPosePanelLayout.createSequentialGroup()
                .add(jSolveStaticPosePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(jStaticTrialTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jBrowse4TrcButton))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jSolveStaticPosePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel2)
                    .add(jLabel3)
                    .add(jStaticToTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jStaticFromTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(15, 15, 15)
                .add(jSolveStaticPosePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel4)
                    .add(jBrowseForIKTasksButton)
                    .add(jEditIKTasksButton)
                    .add(jIKTasksFileTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jOutputFilesPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Output files"));
        jOutputMarkersFileNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jOutputMarkersFileNameTextFieldActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jSimmJntCheckBox, "SIMM .jnt");
        jSimmJntCheckBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jSimmJntCheckBox.setMargin(new java.awt.Insets(0, 0, 0, 0));

        org.openide.awt.Mnemonics.setLocalizedText(iSaveMarkersCheckBox, "Markers");
        iSaveMarkersCheckBox.setActionCommand("Markers.xml");
        iSaveMarkersCheckBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        iSaveMarkersCheckBox.setMargin(new java.awt.Insets(0, 0, 0, 0));

        org.openide.awt.Mnemonics.setLocalizedText(jSaveMotionCheckBox, "Save.mot");
        jSaveMotionCheckBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jSaveMotionCheckBox.setMargin(new java.awt.Insets(0, 0, 0, 0));

        org.openide.awt.Mnemonics.setLocalizedText(jSaveOsimCheckBox, "OpenSim");
        jSaveOsimCheckBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jSaveOsimCheckBox.setMargin(new java.awt.Insets(0, 0, 0, 0));

        jBrowseOsimButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/opensim/swingui/FolderOpen.gif")));
        jBrowseOsimButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBrowseOsimButtonActionPerformed(evt);
            }
        });

        jBrowseMarkersButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/opensim/swingui/FolderOpen.gif")));
        jBrowseMarkersButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBrowseMarkersButtonActionPerformed(evt);
            }
        });

        jBrowseMotionButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/opensim/swingui/FolderOpen.gif")));
        jBrowseMotionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBrowseMotionButtonActionPerformed(evt);
            }
        });

        jBrowseJntButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/opensim/swingui/FolderOpen.gif")));
        jBrowseJntButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBrowseJntButtonActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jOutputFilesPanelLayout = new org.jdesktop.layout.GroupLayout(jOutputFilesPanel);
        jOutputFilesPanel.setLayout(jOutputFilesPanelLayout);
        jOutputFilesPanelLayout.setHorizontalGroup(
            jOutputFilesPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jOutputFilesPanelLayout.createSequentialGroup()
                .add(jOutputFilesPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jSaveMotionCheckBox)
                    .add(jSimmJntCheckBox)
                    .add(iSaveMarkersCheckBox)
                    .add(jSaveOsimCheckBox))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jOutputFilesPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jOutputJntTextField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                    .add(jOutputMotionTextField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                    .add(jOutputMarkersFileNameTextField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                    .add(jOutputFilesPanelLayout.createSequentialGroup()
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jOsimFilenameTextField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jOutputFilesPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(jBrowseJntButton, 0, 0, Short.MAX_VALUE)
                    .add(jBrowseMotionButton, 0, 0, Short.MAX_VALUE)
                    .add(jBrowseMarkersButton, 0, 0, Short.MAX_VALUE)
                    .add(jBrowseOsimButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 35, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jOutputFilesPanelLayout.setVerticalGroup(
            jOutputFilesPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jOutputFilesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(jOutputFilesPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jSaveOsimCheckBox)
                    .add(jBrowseOsimButton)
                    .add(jOsimFilenameTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jOutputFilesPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jOutputMarkersFileNameTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(iSaveMarkersCheckBox)
                    .add(jBrowseMarkersButton))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jOutputFilesPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jOutputMotionTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jSaveMotionCheckBox)
                    .add(jBrowseMotionButton))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jOutputFilesPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jOutputJntTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jSimmJntCheckBox)
                    .add(jBrowseJntButton))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
            .add(jSolveStaticPosePanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(jOutputFilesPanel, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(jSolveStaticPosePanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jOutputFilesPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(34, 34, 34)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jIKTasksFileTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jIKTasksFileTextFieldActionPerformed
// TODO add your handling code here:
    }//GEN-LAST:event_jIKTasksFileTextFieldActionPerformed

    private void jEditIKTasksButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jEditIKTasksButtonActionPerformed
        String ikTasksFilename = jIKTasksFileTextField.getText();
        IKTaskSet taskSet = new IKTaskSet(jIKTasksFileTextField.getText());
        new ObjectEditDialogMaker(taskSet, true).process();
        taskSet.print(ikTasksFilename);
// TODO add your handling code here:
    }//GEN-LAST:event_jEditIKTasksButtonActionPerformed

    private void jOutputMarkersFileNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jOutputMarkersFileNameTextFieldActionPerformed
// TODO add your handling code here:
    }//GEN-LAST:event_jOutputMarkersFileNameTextFieldActionPerformed

    private void jBrowseJntButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBrowseJntButtonActionPerformed
     String jntFilename = FileUtils.getInstance().browseForFilename(".jnt", "Output SIMM jnt file", false);
       if (jntFilename != null) {
            jOutputJntTextField.setText(jntFilename);
       }
// TODO add your handling code here:
    }//GEN-LAST:event_jBrowseJntButtonActionPerformed

    private void jBrowseMotionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBrowseMotionButtonActionPerformed
       String motFilename = FileUtils.getInstance().browseForFilename(".mot", "Output Motion file", false);
       if (motFilename != null) {
            jOutputMotionTextField.setText(motFilename);
       }
// TODO add your handling code here:
    }//GEN-LAST:event_jBrowseMotionButtonActionPerformed

    private void jBrowseMarkersButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBrowseMarkersButtonActionPerformed
       String motFilename = FileUtils.getInstance().browseForFilename(".xml", "Output Markers", false);
       if (motFilename != null) {
            jOutputMarkersFileNameTextField.setText(motFilename);
       }
// TODO add your handling code here:
    }//GEN-LAST:event_jBrowseMarkersButtonActionPerformed

    private void jBrowseOsimButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBrowseOsimButtonActionPerformed
       String osimFilename = FileUtils.getInstance().browseForFilename(".xml, .osim", "Output OpenSim model", false);
       if (osimFilename != null) {
            jOsimFilenameTextField.setText(osimFilename);
       }
// TODO add your handling code here:
    }//GEN-LAST:event_jBrowseOsimButtonActionPerformed

    private void jStaticFromTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jStaticFromTextFieldActionPerformed
// TODO add your handling code here:
    }//GEN-LAST:event_jStaticFromTextFieldActionPerformed

    private void jBrowseForIKTasksButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBrowseForIKTasksButtonActionPerformed
       String ikTasksFilename = FileUtils.getInstance().
               browseForFilename(".xml", "File specifying IK tasks");
       if (ikTasksFilename != null) {
            jIKTasksFileTextField.setText(ikTasksFilename);
       }
// TODO add your handling code here:
    }//GEN-LAST:event_jBrowseForIKTasksButtonActionPerformed

    private void jBrowse4TrcButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBrowse4TrcButtonActionPerformed
// TODO add your handling code here:
       String staticTrialFilename = FileUtils.getInstance().
               browseForFilename(".trc", "Static trial file");
       if (staticTrialFilename != null) {
            jStaticTrialTextField.setText(staticTrialFilename);
       }
       // Get times from file and populate GUI
       MarkerData trcData = new MarkerData(staticTrialFilename);
       jStaticFromTextField.setText(String.valueOf(trcData.getStartFrameTime()));
       jStaticToTextField.setText(String.valueOf(trcData.getLastFrameTime()));
        
    }//GEN-LAST:event_jBrowse4TrcButtonActionPerformed

    void updatePanel(WorkflowDescriptor aDescriptor) {
        MarkerPlacer params = aDescriptor.getSubject().getMarkerPlacer();
        jStaticTrialTextField.setText(params.getStaticPoseFilename());
         try {
            jStaticTrialTextField.setToolTipText(params.getPropertySet().get("marker_file").getComment());
           jIKTasksFileTextField.setToolTipText(params.getPropertySet().get("IKTaskSet").getComment());
        jOutputJntTextField.setToolTipText(params.getPropertySet().get("output_joint_file").getComment());
        jOsimFilenameTextField.setToolTipText(params.getPropertySet().get("output_model_file").getComment());
        jOutputMarkersFileNameTextField.setToolTipText(params.getPropertySet().get("output_marker_file").getComment());
        jOutputMotionTextField.setToolTipText(params.getPropertySet().get("output_motion_file").getComment());
         } catch (IOException ex) {
            TheApp.exitApp("Internal Error:Property does not exist in MarkerPlacer"+ex.getCause());
         }
        ArrayDouble timeRange = params.getTimeRange();
        if (timeRange.getSize()==2){
            jStaticFromTextField.setText(String.valueOf(timeRange.getitem(0)));  // from time in trc
            jStaticToTextField.setText(String.valueOf(timeRange.getitem(1)));  // to time in trc
        }

        // We need to make a name for output files (at least the xml file) for
        // our own sake so that we can open it later.
        String subjectPath = aDescriptor.dSubject.getPathToSubject();
        
        if (!params.getOutputModelFileName().equalsIgnoreCase("Unassigned")){
            jOsimFilenameTextField.setText(params.getOutputModelFileName());
            jSaveOsimCheckBox.setSelected(true);
        }
        else{
            // Make up a default name
            jOsimFilenameTextField.setText(aDescriptor.dSubject.getPathToSubject()+
                                            FileUtils.addSuffix(params.getOutputModelFileName(),"MP")+".osim");
        }
        // Joint file .jnt
        if (!params.getOutputJointFileName().equalsIgnoreCase("Unassigned")){
            jOutputJntTextField.setText(params.getOutputJointFileName());
            jSimmJntCheckBox.setSelected(true);
        }
        else{
            // Make up a default name
            jOutputJntTextField.setText(aDescriptor.dSubject.getPathToSubject()+
                                            FileUtils.addSuffix(params.getOutputJointFileName(),"MP")+".jnt");
        }
        // New markers
        String temp = params.getOutputMarkerFileName();
        if (params.getOutputMarkerFileName().equalsIgnoreCase("Unassigned")){
            // Make up a default name
            jOutputMarkersFileNameTextField.setText(aDescriptor.dSubject.getPathToSubject()+
                                            FileUtils.addSuffix(params.getOutputMarkerFileName(),"MP")+".xml");
        }
        else{
            jOutputMarkersFileNameTextField.setText(params.getOutputMarkerFileName());
            iSaveMarkersCheckBox.setSelected(true);
        }
        // Motion file
        if (!params.getOutputMotionFileName().equalsIgnoreCase("Unassigned")){
            jOutputMotionTextField.setText(params.getOutputMotionFileName());
            jSaveMotionCheckBox.setSelected(true);
        }
        else{
            // Make up a default name
            jOutputMotionTextField.setText(aDescriptor.dSubject.getPathToSubject()+
                                            FileUtils.addSuffix(params.getOutputMotionFileName(),"MP")+".osim");
        }
       checkConsistentPanel(); // enable/disable buttons, fields based on state
    }

    void updateWorkflow(WorkflowDescriptor descriptor) {
        MarkerPlacer params = descriptor.getSubject().getMarkerPlacer();
        params.setStaticPoseFilename(jStaticTrialTextField.getText());
        ArrayDouble timeRange = new ArrayDouble(2);
        timeRange.setitem(0, Double.parseDouble(jStaticFromTextField.getText()));
        timeRange.setitem(1, Double.parseDouble(jStaticToTextField.getText()));
        //params.setTimeRange(timeRange);
        //if (jCoordinatesFileTextField.getText()!="")
        //  params.setCoordinateFile(jCoordinatesFileTextField.getText());

        
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox iSaveMarkersCheckBox;
    private javax.swing.JButton jBrowse4TrcButton;
    private javax.swing.JButton jBrowseForIKTasksButton;
    private javax.swing.JButton jBrowseJntButton;
    private javax.swing.JButton jBrowseMarkersButton;
    private javax.swing.JButton jBrowseMotionButton;
    private javax.swing.JButton jBrowseOsimButton;
    private javax.swing.JButton jEditIKTasksButton;
    private javax.swing.JTextField jIKTasksFileTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextArea jMessageTextArea;
    private javax.swing.JTextField jOsimFilenameTextField;
    private javax.swing.JPanel jOutputFilesPanel;
    private javax.swing.JTextField jOutputJntTextField;
    private javax.swing.JTextField jOutputMarkersFileNameTextField;
    private javax.swing.JTextField jOutputMotionTextField;
    private javax.swing.JCheckBox jSaveMotionCheckBox;
    private javax.swing.JCheckBox jSaveOsimCheckBox;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JCheckBox jSimmJntCheckBox;
    private javax.swing.JPanel jSolveStaticPosePanel;
    private javax.swing.JTextField jStaticFromTextField;
    private javax.swing.JTextField jStaticToTextField;
    private javax.swing.JTextField jStaticTrialTextField;
    // End of variables declaration//GEN-END:variables
    public void appendMessage(String message)
    {
        jMessageTextArea.append(message);
        repaint();
    }

    public void checkConsistentPanel() {
       boolean canProceed =  true;
        setGuiCanAdvance(canProceed);
    }
    
    
}

