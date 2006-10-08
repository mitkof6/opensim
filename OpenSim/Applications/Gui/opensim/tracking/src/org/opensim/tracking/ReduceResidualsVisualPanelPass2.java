package org.opensim.tracking;

import java.util.prefs.Preferences;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import org.openide.windows.WindowManager;
import org.opensim.swingui.SwingWorker;
import org.opensim.utils.FileUtils;
import com.realisticDynamics.InvestigationRRA;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import org.netbeans.api.progress.ProgressHandle;
import org.netbeans.api.progress.ProgressHandleFactory;
import org.openide.awt.StatusDisplayer;
import org.opensim.modeling.Analysis;
import org.opensim.modeling.Model;
import org.opensim.utils.TheApp;
import org.opensim.view.editors.ObjectEditDialogMaker;

public final class ReduceResidualsVisualPanelPass2 extends workflowVisualPanelBase {
    
    /**
     * Creates new form ReduceResidualsVisualPanelPass2
     */
    public ReduceResidualsVisualPanelPass2(workflowWizardPanelBase basePanel) {
        super(basePanel);
        initComponents();
        putClientProperty("WizardPanel_helpURL",this.getClass().getResource("help/html/SubjectSpecificWorkflow.htm")); 
    }
    
    public String getName() {
        return "Reduce residuals";
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jRRAParamsPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jRRAPass2SetupFileTextField = new javax.swing.JTextField();
        jBrowse4RRA2SetupButton = new javax.swing.JButton();
        jEditRRA2SetupButton = new javax.swing.JButton();

        jRRAParamsPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Pass 2, alter motion to reduce residuals"));
        org.openide.awt.Mnemonics.setLocalizedText(jLabel3, "Pass 2 settings file:");

        jBrowse4RRA2SetupButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/opensim/swingui/FolderOpen.gif")));
        jBrowse4RRA2SetupButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBrowse4RRA2SetupButtonActionPerformed(evt);
            }
        });

        jEditRRA2SetupButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/opensim/swingui/editor.gif")));
        jEditRRA2SetupButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jEditRRA2SetupButtonActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jRRAParamsPanel1Layout = new org.jdesktop.layout.GroupLayout(jRRAParamsPanel1);
        jRRAParamsPanel1.setLayout(jRRAParamsPanel1Layout);
        jRRAParamsPanel1Layout.setHorizontalGroup(
            jRRAParamsPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jRRAParamsPanel1Layout.createSequentialGroup()
                .add(jLabel3)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jRRAPass2SetupFileTextField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jBrowse4RRA2SetupButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 32, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jEditRRA2SetupButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 32, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jRRAParamsPanel1Layout.setVerticalGroup(
            jRRAParamsPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jRRAParamsPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jRRAParamsPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel3)
                    .add(jEditRRA2SetupButton)
                    .add(jBrowse4RRA2SetupButton)
                    .add(jRRAPass2SetupFileTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(jRRAParamsPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(jRRAParamsPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(251, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jEditRRA2SetupButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jEditRRA2SetupButtonActionPerformed
          String setupFilename = jRRAPass2SetupFileTextField.getText();
          InvestigationRRA rra = new InvestigationRRA(setupFilename);
          new ObjectEditDialogMaker(rra, true).process();
          rra.print(setupFilename);
// TODO add your handling code here:
    }//GEN-LAST:event_jEditRRA2SetupButtonActionPerformed

    private void jBrowse4RRA2SetupButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBrowse4RRA2SetupButtonActionPerformed
        String defaultDir="";
        defaultDir = Preferences.userNodeForPackage(TheApp.class).get("WorkDirectory", defaultDir);
        final JFileChooser dlog = new JFileChooser(defaultDir);
        dlog.setFileFilter(FileUtils.getFileFilter(".xml", "RRA Pass2 settings file"));
        if (dlog.showOpenDialog((JFrame) WindowManager.getDefault().getMainWindow()) == JFileChooser.APPROVE_OPTION && dlog.getSelectedFile() != null) {
           String setupFilename = dlog.getSelectedFile().getAbsolutePath();
            jRRAPass2SetupFileTextField.setText(setupFilename);
         }
// TODO add your handling code here:
    }//GEN-LAST:event_jBrowse4RRA2SetupButtonActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBrowse4RRA2SetupButton;
    private javax.swing.JButton jEditRRA2SetupButton;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jRRAParamsPanel1;
    private javax.swing.JTextField jRRAPass2SetupFileTextField;
    // End of variables declaration//GEN-END:variables
    void updateWorkflow(WorkflowDescriptor descriptor) {
        descriptor.setSetupRRA_pass2Filename(jRRAPass2SetupFileTextField.getText());
        
    }

    void updatePanel(WorkflowDescriptor aDescriptor) {
        jRRAPass2SetupFileTextField.setText(aDescriptor.getSetupRRA_pass2Filename());
    }

    public void appendMessage(String message) {
        
    }
    protected boolean checkValidForm() {
        return true;
    }
    
}

