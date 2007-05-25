/*
 * PoseSelectionJPanel.java
 *
 * Created on May 24, 2007, 9:57 AM
 */

package org.opensim.coordinateviewer;

import java.util.Vector;
import javax.swing.DefaultListModel;
import javax.swing.ListSelectionModel;
import org.opensim.view.ModelPose;

/**
 *
 * @author  Ayman
 */
public class PoseSelectionJPanel extends javax.swing.JPanel {
   
   private DefaultListModel posesList = new DefaultListModel();
   
   /** Creates new form PoseSelectionJPanel */
   public PoseSelectionJPanel() {
      initComponents();
      jList1.setModel(posesList);
   }

   public void setPoses(Vector<ModelPose> poses) {
         posesList.removeAllElements();
      for(int i=0; i<poses.size(); i++){
           posesList.add(i, poses.get(i)) ;
      }
   }
   
   /** This method is called from within the constructor to
    * initialize the form.
    * WARNING: Do NOT modify this code. The content of this method is
    * always regenerated by the Form Editor.
    */
   // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
   private void initComponents() {
      jScrollPane1 = new javax.swing.JScrollPane();
      jList1 = new javax.swing.JList();

      setBorder(javax.swing.BorderFactory.createTitledBorder("Available Poses"));
      jList1.setModel(new javax.swing.AbstractListModel() {
         String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
         public int getSize() { return strings.length; }
         public Object getElementAt(int i) { return strings[i]; }
      });
      jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
      jScrollPane1.setViewportView(jList1);

      org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
      this.setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
         .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 94, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
         .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
      );
   }// </editor-fold>//GEN-END:initComponents

   Vector<ModelPose> getSelectedPoses() {
      Vector<ModelPose> selected = new Vector<ModelPose>(2);
      ListSelectionModel selectionModel=jList1.getSelectionModel();
      int startIndex=selectionModel.getMinSelectionIndex();
      int endIndex=selectionModel.getMaxSelectionIndex();
      for(int i=startIndex; i<=endIndex;i++){
         if (selectionModel.isSelectedIndex(i))
            selected.add((ModelPose)posesList.elementAt(i));
      }
      return selected;
   }
   
   
   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JList jList1;
   private javax.swing.JScrollPane jScrollPane1;
   // End of variables declaration//GEN-END:variables
   
   public void allowMultipleSelection()
   {
      jList1.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
   }
}
