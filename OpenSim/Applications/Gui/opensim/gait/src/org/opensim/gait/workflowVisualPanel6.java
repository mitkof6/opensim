package org.opensim.gait;

import javax.swing.JPanel;

public final class workflowVisualPanel6 extends JPanel {
    
    /** Creates new form workflowVisualPanel6 */
    public workflowVisualPanel6() {
        initComponents();
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
        jModelSpecPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jRRAParamsPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jOutputFilesPanel = new javax.swing.JPanel();
        jHelpPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();

        jModelSpecPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Model Specification"));
        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, "Shared Library");

        org.openide.awt.Mnemonics.setLocalizedText(jButton1, "Browse...");

        org.jdesktop.layout.GroupLayout jModelSpecPanelLayout = new org.jdesktop.layout.GroupLayout(jModelSpecPanel);
        jModelSpecPanel.setLayout(jModelSpecPanelLayout);
        jModelSpecPanelLayout.setHorizontalGroup(
            jModelSpecPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jModelSpecPanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel1)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jTextField1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 214, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jButton1)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jModelSpecPanelLayout.setVerticalGroup(
            jModelSpecPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jModelSpecPanelLayout.createSequentialGroup()
                .add(jModelSpecPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(jTextField1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jButton1))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jRRAParamsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("RRA Tune up parameters"));
        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, "Settings file");

        org.openide.awt.Mnemonics.setLocalizedText(jButton2, "Browse...");

        org.jdesktop.layout.GroupLayout jRRAParamsPanelLayout = new org.jdesktop.layout.GroupLayout(jRRAParamsPanel);
        jRRAParamsPanel.setLayout(jRRAParamsPanelLayout);
        jRRAParamsPanelLayout.setHorizontalGroup(
            jRRAParamsPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jRRAParamsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel2)
                .add(18, 18, 18)
                .add(jTextField2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 212, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jButton2)
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jRRAParamsPanelLayout.setVerticalGroup(
            jRRAParamsPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jRRAParamsPanelLayout.createSequentialGroup()
                .add(jRRAParamsPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel2)
                    .add(jTextField2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jButton2))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jOutputFilesPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Output files"));
        org.jdesktop.layout.GroupLayout jOutputFilesPanelLayout = new org.jdesktop.layout.GroupLayout(jOutputFilesPanel);
        jOutputFilesPanel.setLayout(jOutputFilesPanelLayout);
        jOutputFilesPanelLayout.setHorizontalGroup(
            jOutputFilesPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 393, Short.MAX_VALUE)
        );
        jOutputFilesPanelLayout.setVerticalGroup(
            jOutputFilesPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 61, Short.MAX_VALUE)
        );

        jHelpPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Instructions"));
        jScrollPane1.setViewportView(jEditorPane1);

        org.jdesktop.layout.GroupLayout jHelpPanelLayout = new org.jdesktop.layout.GroupLayout(jHelpPanel);
        jHelpPanel.setLayout(jHelpPanelLayout);
        jHelpPanelLayout.setHorizontalGroup(
            jHelpPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jHelpPanelLayout.createSequentialGroup()
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE)
                .addContainerGap())
        );
        jHelpPanelLayout.setVerticalGroup(
            jHelpPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jOutputFilesPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jRRAParamsPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jModelSpecPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jHelpPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(jModelSpecPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jRRAParamsPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jOutputFilesPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jHelpPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JPanel jHelpPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jModelSpecPanel;
    private javax.swing.JPanel jOutputFilesPanel;
    private javax.swing.JPanel jRRAParamsPanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
    
}

