/*
 * AddInputSliderPanel.java
 *
 * Created on September 7, 2010, 12:59 AM
 */

package org.opensim.k12utils;

import org.opensim.k12.*;

/**
 *
 * @author  ayman
 */
public class EditInputPanel extends javax.swing.JPanel {
    
    private LabParameter parm;
    /**
     * Creates new form AddInputSliderPanel
     */
    public EditInputPanel(LabParameter parm) {
        this.parm = parm;
        initComponents();
        populateGUIFromParm();
    }

    public LabParameter getParm() {
        populateParameterFromGUI();
        return parm;
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        objectTypeTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        objectNameTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        displayNameTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jLabel7 = new javax.swing.JLabel();
        minTextField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        maxTextField = new javax.swing.JTextField();
        propertyNameTextField = new javax.swing.JTextField();

        jLabel1.setText("Object Type");

        jLabel2.setText("Object Name");

        jLabel3.setText("Property Name");

        jLabel4.setText("Display Name");

        jLabel5.setText("User Interface");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Slider" }));

        jLabel6.setText("Component");

        jLabel7.setText("Range: min.");

        jLabel8.setText("max.");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(jLabel1)
                        .add(17, 17, 17)
                        .add(objectTypeTextField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE))
                    .add(layout.createSequentialGroup()
                        .add(jLabel2)
                        .add(14, 14, 14)
                        .add(objectNameTextField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE))
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel3)
                            .add(jLabel6))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jSpinner1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 42, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(propertyNameTextField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)))
                    .add(layout.createSequentialGroup()
                        .add(jLabel4)
                        .add(8, 8, 8)
                        .add(displayNameTextField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE))
                    .add(layout.createSequentialGroup()
                        .add(jLabel5)
                        .add(6, 6, 6)
                        .add(jComboBox2, 0, 157, Short.MAX_VALUE))
                    .add(layout.createSequentialGroup()
                        .add(jLabel7)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(minTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 45, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(19, 19, 19)
                        .add(jLabel8)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(maxTextField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .add(20, 20, 20)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(objectTypeTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel2)
                    .add(objectNameTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel3)
                    .add(propertyNameTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel6)
                    .add(jSpinner1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(21, 21, 21)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(jLabel4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(27, 27, 27)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel5)
                            .add(jComboBox2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(24, 24, 24)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel7)
                            .add(minTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel8)
                            .add(maxTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(60, 60, 60))
                    .add(layout.createSequentialGroup()
                        .add(displayNameTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void populateParameterFromGUI() {
        parm.setOpenSimType(objectTypeTextField.getText());
        parm.setObjectName(objectNameTextField.getText());
        parm.setPropertyName(propertyNameTextField.getText());
        parm.setPropertyDisplayName(displayNameTextField.getText());
        parm.setUserInterface((String) jComboBox2.getSelectedItem());
        parm.setPropertyComponent((Integer)jSpinner1.getValue());
        if (minTextField.getText().trim().length()>0 && maxTextField.getText().trim().length()>0){
            parm.setRangeMin(Double.parseDouble(minTextField.getText()));
            parm.setRangeMax(Double.parseDouble(maxTextField.getText()));
            
        }
        else {
            parm.setRangeMin(Double.NaN);
            parm.setRangeMax(Double.NaN);
        }
    }

    private void populateGUIFromParm() {
        objectTypeTextField.setText(parm.getOpenSimType());
        objectNameTextField.setText(parm.getObjectName());
        propertyNameTextField.setText(parm.getPropertyName());
        displayNameTextField.setText(parm.getPropertyDisplayName());
        jSpinner1.setValue(parm.getPropertyComponent());
        jComboBox2.setSelectedItem(parm.getUserInterface());
        double pmin = parm.getRangeMin();
        double pmax = parm.getRangeMax();
        if (!(Double.isNaN(pmin)||Double.isNaN(pmax))){
            minTextField.setText(String.valueOf(pmin));
            maxTextField.setText(String.valueOf(pmax));
        }
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField displayNameTextField;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTextField maxTextField;
    private javax.swing.JTextField minTextField;
    private javax.swing.JTextField objectNameTextField;
    private javax.swing.JTextField objectTypeTextField;
    private javax.swing.JTextField propertyNameTextField;
    // End of variables declaration//GEN-END:variables
    
}
