/*
 * MultiFileSelectorPanel.java
 *
 * Created on July 27, 2007, 4:10 PM
 */

package org.opensim.swingui;

import org.openide.DialogDescriptor;
import org.openide.DialogDisplayer;

/**
 *
 * @author  erang
 */
public class MultiFileSelectorPanel extends javax.swing.JPanel {
   
   /** Creates new form MultiFileSelectorPanel */
   public MultiFileSelectorPanel() {
      initComponents();
   }

   static public void showDialog() {
      MultiFileSelectorPanel panel = new MultiFileSelectorPanel();
      DialogDescriptor dlg = new DialogDescriptor(panel, "Edit File List");
      Object answer = DialogDisplayer.getDefault().notify(dlg);
   }
   
   /** This method is called from within the constructor to
    * initialize the form.
    * WARNING: Do NOT modify this code. The content of this method is
    * always regenerated by the Form Editor.
    */
   // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
   private void initComponents() {
      jScrollPane1 = new javax.swing.JScrollPane();
      fileList = new javax.swing.JList();
      fileName = new org.opensim.swingui.FileTextFieldAndChooser();
      addButton = new javax.swing.JButton();
      deleteButton = new javax.swing.JButton();

      fileList.setModel(new javax.swing.AbstractListModel() {
         String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
         public int getSize() { return strings.length; }
         public Object getElementAt(int i) { return strings[i]; }
      });
      jScrollPane1.setViewportView(fileList);

      addButton.setText("Add");

      deleteButton.setText("Delete");

      org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
      this.setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
         .add(layout.createSequentialGroup()
            .addContainerGap()
            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
               .add(layout.createSequentialGroup()
                  .add(addButton, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                  .add(327, 327, 327))
               .add(layout.createSequentialGroup()
                  .add(deleteButton)
                  .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                  .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                     .add(org.jdesktop.layout.GroupLayout.TRAILING, fileName, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
                     .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE))
                  .addContainerGap())))
      );

      layout.linkSize(new java.awt.Component[] {addButton, deleteButton}, org.jdesktop.layout.GroupLayout.HORIZONTAL);

      layout.setVerticalGroup(
         layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
         .add(layout.createSequentialGroup()
            .addContainerGap()
            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
               .add(layout.createSequentialGroup()
                  .add(addButton)
                  .add(0, 0, 0)
                  .add(deleteButton))
               .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
            .add(fileName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      );
   }// </editor-fold>//GEN-END:initComponents
   
   
   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JButton addButton;
   private javax.swing.JButton deleteButton;
   private javax.swing.JList fileList;
   private org.opensim.swingui.FileTextFieldAndChooser fileName;
   private javax.swing.JScrollPane jScrollPane1;
   // End of variables declaration//GEN-END:variables
   
}
