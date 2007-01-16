/*
 * MotionSliderJPanel.java
 *
 * Created on January 12, 2007, 11:28 AM
 */

package org.opensim.motionviewer;

import java.util.Observable;
import java.util.Observer;
import org.opensim.view.pub.OpenSimDB;

/**
 *
 * @author  Ayman
 * The panel for motion playback in main toolbar.
 * The panel wil observer ViewDB so that it can respond to changes in current model, events ...
 */
public class MotionSliderJPanel extends javax.swing.JPanel implements Observer {
   
   /** Creates new form MotionSliderJPanel */
   public MotionSliderJPanel() {
      initComponents();
      OpenSimDB.getInstance().addObserver(this);
   }
   
   /** This method is called from within the constructor to
    * initialize the form.
    * WARNING: Do NOT modify this code. The content of this method is
    * always regenerated by the Form Editor.
    */
   // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
   private void initComponents() {
      jReverseButton = new javax.swing.JButton();
      jStopButton = new javax.swing.JButton();
      jPlayButton = new javax.swing.JButton();
      jMotionSlider = new javax.swing.JSlider();
      jLabel2 = new javax.swing.JLabel();
      jTextField1 = new javax.swing.JTextField();
      jSpinner1 = new javax.swing.JSpinner();
      jLabel1 = new javax.swing.JLabel();
      jButton1 = new javax.swing.JButton();
      jButton2 = new javax.swing.JButton();
      jLabel3 = new javax.swing.JLabel();
      jButton3 = new javax.swing.JButton();

      setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
      jReverseButton.setIcon(new javax.swing.ImageIcon("C:\\Projects\\NewTrunk\\OpenSim\\Applications\\Gui\\opensim\\motionViewer\\src\\org\\opensim\\motionviewer\\images\\reverse.gif"));
      jReverseButton.setPreferredSize(new java.awt.Dimension(50, 25));

      jStopButton.setIcon(new javax.swing.ImageIcon("C:\\Projects\\NewTrunk\\OpenSim\\Applications\\Gui\\opensim\\motionViewer\\src\\org\\opensim\\motionviewer\\images\\stop.gif"));

      jPlayButton.setIcon(new javax.swing.ImageIcon("C:\\Projects\\NewTrunk\\OpenSim\\Applications\\Gui\\opensim\\motionViewer\\src\\org\\opensim\\motionviewer\\images\\play.gif"));
      jPlayButton.setMaximumSize(new java.awt.Dimension(50, 25));
      jPlayButton.setMinimumSize(new java.awt.Dimension(50, 25));
      jPlayButton.setPreferredSize(new java.awt.Dimension(50, 25));

      jMotionSlider.setPaintLabels(true);
      jMotionSlider.setValue(30);

      jLabel2.setText("Motion:");

      jLabel1.setText("Speed");

      jButton1.setIcon(new javax.swing.ImageIcon("C:\\Projects\\NewTrunk\\OpenSim\\Applications\\Gui\\opensim\\motionViewer\\src\\org\\opensim\\motionviewer\\images\\step.gif"));
      jButton1.setMaximumSize(new java.awt.Dimension(50, 25));
      jButton1.setMinimumSize(new java.awt.Dimension(50, 25));
      jButton1.setPreferredSize(new java.awt.Dimension(50, 25));

      jButton2.setIcon(new javax.swing.ImageIcon("C:\\Projects\\NewTrunk\\OpenSim\\Applications\\Gui\\opensim\\motionViewer\\src\\org\\opensim\\motionviewer\\images\\reverseStep.gif"));

      jLabel3.setText("Name");

      jButton3.setText("Wrap");

      org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
      this.setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
         .add(layout.createSequentialGroup()
            .addContainerGap()
            .add(jLabel2)
            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
            .add(jLabel3)
            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
            .add(jTextField1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 32, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
            .add(13, 13, 13)
            .add(jMotionSlider, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 202, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
            .add(jPlayButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 30, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
            .add(jStopButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 30, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
            .add(42, 42, 42)
            .add(jButton2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 30, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
            .add(jReverseButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 30, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
            .add(jButton1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 30, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
            .add(jButton3)
            .add(2, 2, 2)
            .add(jLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 39, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
            .add(jSpinner1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(82, Short.MAX_VALUE))
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
         .add(layout.createSequentialGroup()
            .addContainerGap()
            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
               .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                  .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                     .add(jPlayButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                     .add(jStopButton))
                  .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                     .add(jButton2)
                     .add(jReverseButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                     .add(jButton1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                     .add(jButton3))
                  .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                     .add(jSpinner1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                     .add(jLabel1))
                  .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                     .add(jLabel2)
                     .add(jTextField1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                     .add(jLabel3)))
               .add(jMotionSlider, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
            .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      );
   }// </editor-fold>//GEN-END:initComponents
   // Observable is OpenSimDB
   public void update(Observable o, Object arg) {
      OpenSimDB db = (OpenSimDB)o;
      // Recover motion info, update toolbar accordingly
   }
   
   
   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JButton jButton1;
   private javax.swing.JButton jButton2;
   private javax.swing.JButton jButton3;
   private javax.swing.JLabel jLabel1;
   private javax.swing.JLabel jLabel2;
   private javax.swing.JLabel jLabel3;
   private javax.swing.JSlider jMotionSlider;
   private javax.swing.JButton jPlayButton;
   private javax.swing.JButton jReverseButton;
   private javax.swing.JSpinner jSpinner1;
   private javax.swing.JButton jStopButton;
   private javax.swing.JTextField jTextField1;
   // End of variables declaration//GEN-END:variables
   
}
