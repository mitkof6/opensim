/*
 * Copyright (c)  2005-2008, Stanford University
 * Use of the OpenSim software in source form is permitted provided that the following
 * conditions are met:
 * 	1. The software is used only for non-commercial research and education. It may not
 *     be used in relation to any commercial activity.
 * 	2. The software is not distributed or redistributed.  Software distribution is allowed 
 *     only through https://simtk.org/home/opensim.
 * 	3. Use of the OpenSim software or derivatives must be acknowledged in all publications,
 *      presentations, or documents describing work in which OpenSim or derivatives are used.
 * 	4. Credits to developers may not be removed from executables
 *     created from modifications of the source.
 * 	5. Modifications of source code must retain the above copyright notice, this list of
 *     conditions and the following disclaimer. 
 * 
 *  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY
 *  EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 *  OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT
 *  SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT,
 *  INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED
 *  TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; 
 *  HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 *  OR BUSINESS INTERRUPTION) OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY
 *  WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
/*
 * ExcitationEditorJFrame.java
 *
 * Created on January 29, 2008, 4:49 PM
 */

package org.opensim.view.excitationEditor;
import java.awt.BorderLayout;
import org.openide.DialogDisplayer;
import org.openide.NotifyDescriptor;
import org.opensim.modeling.ControlLinear;
import org.opensim.modeling.ControlSet;
import org.opensim.modeling.Model;
import org.opensim.utils.FileUtils;
import org.opensim.utils.TheApp;
import org.opensim.view.pub.OpenSimDB;

/**
 *
 * @author  Ayman
 */
public class ExcitationEditorJFrame extends javax.swing.JFrame {
    ExcitationEditorJPanel dPanel;
    /** Creates new form ExcitationEditorJFrame */
    public ExcitationEditorJFrame() {
        initComponents();
        getContentPane().setLayout(new BorderLayout());
        dPanel=new ExcitationEditorJPanel(this, null);
        getContentPane().add(dPanel, BorderLayout.CENTER);
        setIconImage(TheApp.getAppImage());
        setTitle("Excitation Editor");
        pack();
    }
    /**
     * Constructor that takes a control set
     */
    public ExcitationEditorJFrame(ControlSet controls) {
        initComponents();
        getContentPane().setLayout(new BorderLayout());
        dPanel=new ExcitationEditorJPanel(this, controls);
        getContentPane().add(dPanel, BorderLayout.CENTER);
        setIconImage(TheApp.getAppImage());
        setTitle("Excitation Editor");
        pack();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jMenuBar1 = new javax.swing.JMenuBar();
        jFileMenu = new javax.swing.JMenu();
        jLoadMenuItem = new javax.swing.JMenuItem();
        jSaveMenuItem = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JSeparator();
        jCreateDefaultMenuItem = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        jFileMenu.setText("File");
        jLoadMenuItem.setText("Load...");
        jLoadMenuItem.setToolTipText("Load Excitations from an XML file");
        jLoadMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLoadMenuItemActionPerformed(evt);
            }
        });

        jFileMenu.add(jLoadMenuItem);

        jSaveMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jSaveMenuItem.setText("Save...");
        jSaveMenuItem.setToolTipText("Store excitations into an XML file");
        jSaveMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSaveMenuItemActionPerformed(evt);
            }
        });

        jFileMenu.add(jSaveMenuItem);

        jFileMenu.add(jSeparator1);

        jCreateDefaultMenuItem.setText("New (current model)");
        jCreateDefaultMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCreateDefaultMenuItemActionPerformed(evt);
            }
        });

        jFileMenu.add(jCreateDefaultMenuItem);

        jMenuBar1.add(jFileMenu);

        jMenu1.setText("Template");
        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 392, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 245, Short.MAX_VALUE)
        );
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-400)/2, (screenSize.height-300)/2, 400, 300);
    }// </editor-fold>//GEN-END:initComponents

    private void jCreateDefaultMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCreateDefaultMenuItemActionPerformed
// TODO add your handling code here:
        Model currentModel = OpenSimDB.getInstance().getCurrentModel();
        if (currentModel==null){
            DialogDisplayer.getDefault().notify(
               new NotifyDescriptor.Message("You need a current model to use this functionality."));
            return;
        }
        // Create a blank control set
        ControlSet controlSet = new ControlSet();
        // Cycle thru Actuators and create a Control for it with default min=0, max=1, val=0
        int nx = currentModel.getNumControls();
	controlSet.setName(currentModel.getName()+"_Default");

	for(int i=0;i<nx;i++) {
		ControlLinear control = new ControlLinear(0L, false);
                control.setControlValue(0.0, 0.0);
                control.setControlValue(1.0, 0.0);
                control.setControlValueMin(0.0, 0.0);
                control.setControlValueMin(1.0, 0.0);
                control.setControlValueMax(0.0, 1.0);
                control.setControlValueMax(1.0, 1.0);
		control.setName(currentModel.getControlName(i));
		controlSet.append(control);
	}
        dPanel.populate(controlSet);

    }//GEN-LAST:event_jCreateDefaultMenuItemActionPerformed

    private void jSaveMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSaveMenuItemActionPerformed
// TODO add your handling code here:
        ControlSet obj = dPanel.getControlSet();
        if (obj!=null)
            obj.print(obj.getDocumentFileName());
    }//GEN-LAST:event_jSaveMenuItemActionPerformed

    private void jLoadMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLoadMenuItemActionPerformed
// TODO add your handling code here:
        //Browse for existing xml file
         String fileName = FileUtils.getInstance().browseForFilename(".osim,.xml", "OpenSim model or XML file", this);
         if(fileName!=null) {
         ControlSet obj = new ControlSet(fileName);
         if (obj != null){
             dPanel.populate(obj);
          } else {
            DialogDisplayer.getDefault().notify(
               new NotifyDescriptor.Message("Could not construct excitations from the specified file."));
         }
      }
   
    }//GEN-LAST:event_jLoadMenuItemActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ExcitationEditorJFrame().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem jCreateDefaultMenuItem;
    private javax.swing.JMenu jFileMenu;
    private javax.swing.JMenuItem jLoadMenuItem;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jSaveMenuItem;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
    
}
