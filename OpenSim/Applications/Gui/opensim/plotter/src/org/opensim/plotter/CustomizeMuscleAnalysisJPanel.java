/*
 * CustomizeMuscleAnalysisJPanel.java
 *
 * Created on June 23, 2007, 10:30 PM
 */

package org.opensim.plotter;

import javax.swing.DefaultComboBoxModel;
import org.opensim.modeling.Analysis;
import org.opensim.modeling.ArrayStorage;

/**
 *
 * @author  Ayman
 */
public class CustomizeMuscleAnalysisJPanel extends javax.swing.JPanel {
   Analysis analysis;
   private PlotterSourceInterface selectedSource;
   /**
    * Creates new form CustomizeMuscleAnalysisJPanel
    */
   public CustomizeMuscleAnalysisJPanel(Analysis analysis, PlotterModel plotterModel) {
      this.analysis = analysis;
      initComponents();
      ArrayStorage quantities = analysis.getStorageList();
      PlotterSourceInterface[] availableQuantities = new PlotterSourceInterface[quantities.getSize()];
      for(int i=0;i<quantities.getSize();i++){
         availableQuantities[i]=plotterModel.findSource(analysis.getName()+"."+quantities.get(i).getName());
      }
      jComboBox1.setModel(new DefaultComboBoxModel(availableQuantities));

   }

   public PlotterSourceInterface getSelectedSource() {
      return selectedSource;
   }

   public void setSelectedSource(PlotterSourceInterface selectedSource) {
      this.selectedSource = selectedSource;
   }
   
   /** This method is called from within the constructor to
    * initialize the form.
    * WARNING: Do NOT modify this code. The content of this method is
    * always regenerated by the Form Editor.
    */
   // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
   private void initComponents() {
      jLabel1 = new javax.swing.JLabel();
      jComboBox1 = new javax.swing.JComboBox();

      jLabel1.setText("Analyze");

      jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
      jComboBox1.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jComboBox1ActionPerformed(evt);
         }
      });

      org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
      this.setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
         .add(layout.createSequentialGroup()
            .add(jLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 46, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
            .add(jComboBox1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 144, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
         .add(layout.createSequentialGroup()
            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
               .add(jLabel1)
               .add(jComboBox1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
            .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      );
   }// </editor-fold>//GEN-END:initComponents

   private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
// TODO add your handling code here:
      setSelectedSource((PlotterSourceInterface)jComboBox1.getSelectedItem());
   }//GEN-LAST:event_jComboBox1ActionPerformed
   
   
   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JComboBox jComboBox1;
   private javax.swing.JLabel jLabel1;
   // End of variables declaration//GEN-END:variables
   
}