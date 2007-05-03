/*
 * PlotterQuantityNameFilterJPanel.java Filtering dialog for Quantity name  invoked by Plotter
 *
 * Created on April 30, 2007, 1:14 PM
 */

package org.opensim.plotter;

import java.util.regex.PatternSyntaxException;

/**
 *
 * @author  Ayman
 */
public class PlotterQuantityNameFilterJPanel extends javax.swing.JPanel {
   
   PlotterQuantityNameFilterTableModel tableModel;
   /**
    * Creates new form PlotterQuantityNameFilterJPanel
    */
   public PlotterQuantityNameFilterJPanel(PlotterSourceInterface src) {
      initComponents();
      jFilename.setText(src.getDisplayName());
      tableModel = new PlotterQuantityNameFilterTableModel(src);
      jTable1.setModel(tableModel);
   }
   
   /** This method is called from within the constructor to
    * initialize the form.
    * WARNING: Do NOT modify this code. The content of this method is
    * always regenerated by the Form Editor.
    */
   // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
   private void initComponents() {
      FilterTextField = new javax.swing.JTextField();
      jLabel1 = new javax.swing.JLabel();
      jLabel2 = new javax.swing.JLabel();
      jFilenameLabel = new javax.swing.JLabel();
      jScrollPane1 = new javax.swing.JScrollPane();
      jTable1 = new javax.swing.JTable();

      jApplyFilterButton = new javax.swing.JButton();
      jLabel4 = new javax.swing.JLabel();
      jFilename = new javax.swing.JLabel();

      FilterTextField.addKeyListener(new java.awt.event.KeyAdapter() {
         public void keyTyped(java.awt.event.KeyEvent evt) {
            FilterTextFieldKeyTyped(evt);
         }
      });
      FilterTextField.addMouseListener(new java.awt.event.MouseAdapter() {
         public void mouseClicked(java.awt.event.MouseEvent evt) {
            FilterTextFieldMouseClicked(evt);
         }
      });

      jLabel1.setText("Filter By:");

      jLabel2.setText("Source:");

      jFilenameLabel.setText("File:");

      jTable1.setModel(new javax.swing.table.DefaultTableModel(
         new Object [][] {
            {null, null},
            {null, null},
            {null, null}
         },
         new String [] {
            "Title 1", "Title 2"
         }
      ));
      jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN);
      jScrollPane1.setViewportView(jTable1);

      jApplyFilterButton.setText("Apply");
      jApplyFilterButton.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jApplyFilterButtonActionPerformed(evt);
         }
      });

      jLabel4.setText("jLabel4");

      org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
      this.setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
         .add(layout.createSequentialGroup()
            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
               .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
               .add(layout.createSequentialGroup()
                  .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                     .add(jLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 59, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                     .add(jLabel2))
                  .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                  .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                     .add(layout.createSequentialGroup()
                        .add(jFilenameLabel)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jFilename, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                     .add(FilterTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 152, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                  .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 20, Short.MAX_VALUE)
                  .add(jApplyFilterButton))
               .add(jLabel4))
            .addContainerGap())
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
         .add(layout.createSequentialGroup()
            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
               .add(jLabel2)
               .add(jFilenameLabel)
               .add(jFilename))
            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
               .add(jLabel1)
               .add(FilterTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
               .add(jApplyFilterButton))
            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
            .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
            .add(jLabel4))
      );
   }// </editor-fold>//GEN-END:initComponents

   private void FilterTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FilterTextFieldKeyTyped
// TODO add your handling code here:
      // Get regex from textfield and if valid filter on the fly!
      String regex = FilterTextField.getText()+evt.getKeyChar();
      try{
         tableModel.applyFilter(regex);
         jLabel4.setText(regex);
         tableModel.fireTableDataChanged();
      }
      catch(PatternSyntaxException ex){
         // Shouldn't complain here'
         jLabel4.setText(regex+".*"+"wont complain");
      }
   }//GEN-LAST:event_FilterTextFieldKeyTyped

   private void jApplyFilterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jApplyFilterButtonActionPerformed
      String regex = FilterTextField.getText();
      // Replace * with .* ?with .? as it's more common
      int idx = regex.indexOf("*", 0);
      if (idx !=-1 && regex.indexOf(".*", 0)==-1){
         regex.replaceAll("*", ".*");
      }
      try{
         tableModel.applyFilter(regex);
         tableModel.fireTableDataChanged();
      }
      catch(PatternSyntaxException ex){
         // Should complain here'
         jLabel4.setText(regex+".*"+"will complain");
      }
// TODO add your handling code here:
   }//GEN-LAST:event_jApplyFilterButtonActionPerformed

   private void FilterTextFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FilterTextFieldMouseClicked
// TODO add your handling code here:
      // Get regex and appluyit to select quantities
      String regex = FilterTextField.getText();
      tableModel.applyFilter(regex);
   }//GEN-LAST:event_FilterTextFieldMouseClicked
   
   
   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JTextField FilterTextField;
   private javax.swing.JButton jApplyFilterButton;
   private javax.swing.JLabel jFilename;
   private javax.swing.JLabel jFilenameLabel;
   private javax.swing.JLabel jLabel1;
   private javax.swing.JLabel jLabel2;
   private javax.swing.JLabel jLabel4;
   private javax.swing.JScrollPane jScrollPane1;
   private javax.swing.JTable jTable1;
   // End of variables declaration//GEN-END:variables
   
}
