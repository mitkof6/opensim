package org.opensim.view;

import java.awt.Color;
import java.awt.event.InputEvent;
import java.util.prefs.Preferences;
import javax.swing.Action;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import org.openide.util.NbBundle;
import org.openide.util.SharedClassObject;
import org.openide.windows.TopComponent;
import org.opensim.utils.FileUtils;
import org.opensim.utils.TheApp;
import org.opensim.view.pub.ViewDB;
import vtk.vtkFileOutputWindow;

/**
 * Top component which displays something.
 */
public class ModelWindowVTKTopComponent extends TopComponent
{
    
    private static final long serialVersionUID = 1L;
    private static int ct = 0; //A counter used to provide names for new models
    private String tabDisplayName;
    Preferences prefs;
    /** path to the icon used by the component and its open action */
//    static final String ICON_PATH = "SET/PATH/TO/ICON/HERE";
    public ModelWindowVTKTopComponent() {
        initComponents();
        setTabDisplayName(NbBundle.getMessage(
                        ModelWindowVTKTopComponent.class,
                        "UnsavedModelNameFormat",
                        new Object[] { new Integer(ct++) }
                ));
//        SwingUtilities.invokeLater(new Runnable(){
 //           public void run() {
                 setName(tabDisplayName);
//            }});

        // Set preferred directory for the TopComponent (to be used for all saving, loading, ...
        prefs = Preferences.userNodeForPackage(TheApp.class);
        
        vtkFileOutputWindow fow = new vtkFileOutputWindow();
        fow.SetFileName("vtklog.log");
        if (fow != null)
           fow.SetInstance(fow);
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jRefitModelButton = new javax.swing.JButton();
        jModelWindowToolBar = new javax.swing.JToolBar();
        jBackgroundColorButton = new javax.swing.JButton();
        jAxesToggleButton = new javax.swing.JToggleButton();
        jMinusXViewButton = new javax.swing.JButton();
        jPlusXViewButton = new javax.swing.JButton();
        jMinusYViewButton = new javax.swing.JButton();
        jPlusYViewButton = new javax.swing.JButton();
        jMinusZViewButton = new javax.swing.JButton();
        jPlusZViewButton = new javax.swing.JButton();
        jTakeSnapshotButton = new javax.swing.JButton();
        jStartStopMovieToggleButton = new javax.swing.JToggleButton();
        openSimCanvas1 = new org.opensim.view.OpenSimCanvas();

        org.openide.awt.Mnemonics.setLocalizedText(jRefitModelButton, "Refit");
        jRefitModelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRefitModelButtonActionPerformed(evt);
            }
        });

        setLayout(new java.awt.BorderLayout());

        //String defaultBackgroundColor="0.0, 0.0, 0.0";
        //defaultBackgroundColor = Preferences.userNodeForPackage(TheApp.class).get("BackgroundColor", defaultBackgroundColor);
        //double[] background = Prefs.getInstance().parseColor(defaultBackgroundColor);
        //jModelWindowToolBar.setBackground(new java.awt.Color((int) (background[0]*255), (int) (background[1]*255), (int) (background[2]*255)));

        jModelWindowToolBar.setBorder(null);
        jModelWindowToolBar.setOrientation(1);
        jModelWindowToolBar.setToolTipText("Drag to Preferred Edge or Float");
        jModelWindowToolBar.setMaximumSize(new java.awt.Dimension(200, 200));
        jModelWindowToolBar.setMinimumSize(new java.awt.Dimension(20, 20));
        jModelWindowToolBar.setPreferredSize(new java.awt.Dimension(20, 20));
        jBackgroundColorButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/opensim/view/backgroundColor.png")));
        jBackgroundColorButton.setToolTipText("Set View Background Color");
        jBackgroundColorButton.setAlignmentX(0.5F);
        jBackgroundColorButton.setBorderPainted(false);
        jBackgroundColorButton.setContentAreaFilled(false);
        jBackgroundColorButton.setFocusPainted(false);
        jBackgroundColorButton.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jBackgroundColorButton.setMaximumSize(new java.awt.Dimension(20, 20));
        jBackgroundColorButton.setMinimumSize(new java.awt.Dimension(20, 20));
        jBackgroundColorButton.setPreferredSize(new java.awt.Dimension(20, 20));
        jBackgroundColorButton.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/org/opensim/view/backgroundColor_selected.png")));
        jBackgroundColorButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/org/opensim/view/backgroundColor_rollover.png")));
        jBackgroundColorButton.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/org/opensim/view/backgroundColor_rollover_selected.png")));
        jBackgroundColorButton.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/org/opensim/view/backgroundColor_selected.png")));
        jBackgroundColorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBackgroundColorButtonActionPerformed(evt);
            }
        });

        jModelWindowToolBar.add(jBackgroundColorButton);

        jAxesToggleButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/opensim/view/axes.png")));
        jAxesToggleButton.setToolTipText("Show/Hide View Axes");
        jAxesToggleButton.setAlignmentX(0.5F);
        jAxesToggleButton.setBorderPainted(false);
        jAxesToggleButton.setContentAreaFilled(false);
        jAxesToggleButton.setFocusPainted(false);
        jAxesToggleButton.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jAxesToggleButton.setMaximumSize(new java.awt.Dimension(20, 20));
        jAxesToggleButton.setMinimumSize(new java.awt.Dimension(20, 20));
        jAxesToggleButton.setPreferredSize(new java.awt.Dimension(20, 20));
        jAxesToggleButton.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/org/opensim/view/axes_selected.png")));
        jAxesToggleButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/org/opensim/view/axes_rollover.png")));
        jAxesToggleButton.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/org/opensim/view/axes_rollover_selected.png")));
        jAxesToggleButton.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/org/opensim/view/axes_selected.png")));
        jAxesToggleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAxesToggleButtonActionPerformed(evt);
            }
        });

        jModelWindowToolBar.add(jAxesToggleButton);

        jMinusXViewButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/opensim/view/frontView_axes.png")));
        jMinusXViewButton.setToolTipText("-X View");
        jMinusXViewButton.setAlignmentX(0.5F);
        jMinusXViewButton.setBorderPainted(false);
        jMinusXViewButton.setContentAreaFilled(false);
        jMinusXViewButton.setFocusPainted(false);
        jMinusXViewButton.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jMinusXViewButton.setMaximumSize(new java.awt.Dimension(20, 20));
        jMinusXViewButton.setMinimumSize(new java.awt.Dimension(20, 20));
        jMinusXViewButton.setPreferredSize(new java.awt.Dimension(20, 20));
        jMinusXViewButton.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/org/opensim/view/frontView_axes_selected.png")));
        jMinusXViewButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/org/opensim/view/frontView_axes_rollover.png")));
        jMinusXViewButton.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/org/opensim/view/frontView_axes_rollover_selected.png")));
        jMinusXViewButton.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/org/opensim/view/frontView_axes_selected.png")));
        jMinusXViewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMinusXViewButtonActionPerformed(evt);
            }
        });

        jModelWindowToolBar.add(jMinusXViewButton);

        jPlusXViewButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/opensim/view/backView_axes.png")));
        jPlusXViewButton.setToolTipText("+X View");
        jPlusXViewButton.setAlignmentX(0.5F);
        jPlusXViewButton.setBorderPainted(false);
        jPlusXViewButton.setContentAreaFilled(false);
        jPlusXViewButton.setFocusPainted(false);
        jPlusXViewButton.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jPlusXViewButton.setMaximumSize(new java.awt.Dimension(20, 20));
        jPlusXViewButton.setMinimumSize(new java.awt.Dimension(20, 20));
        jPlusXViewButton.setPreferredSize(new java.awt.Dimension(20, 20));
        jPlusXViewButton.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/org/opensim/view/backView_axes_selected.png")));
        jPlusXViewButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/org/opensim/view/backView_axes_rollover.png")));
        jPlusXViewButton.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/org/opensim/view/backView_axes_rollover_selected.png")));
        jPlusXViewButton.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/org/opensim/view/backView_axes_selected.png")));
        jPlusXViewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPlusXViewButtonActionPerformed(evt);
            }
        });

        jModelWindowToolBar.add(jPlusXViewButton);

        jMinusYViewButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/opensim/view/topView_axes.png")));
        jMinusYViewButton.setToolTipText("-Y View");
        jMinusYViewButton.setAlignmentX(0.5F);
        jMinusYViewButton.setBorderPainted(false);
        jMinusYViewButton.setContentAreaFilled(false);
        jMinusYViewButton.setFocusPainted(false);
        jMinusYViewButton.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jMinusYViewButton.setMaximumSize(new java.awt.Dimension(20, 20));
        jMinusYViewButton.setMinimumSize(new java.awt.Dimension(20, 20));
        jMinusYViewButton.setPreferredSize(new java.awt.Dimension(20, 20));
        jMinusYViewButton.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/org/opensim/view/topView_axes_selected.png")));
        jMinusYViewButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/org/opensim/view/topView_axes_rollover.png")));
        jMinusYViewButton.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/org/opensim/view/topView_axes_rollover_selected.png")));
        jMinusYViewButton.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/org/opensim/view/topView_axes_selected.png")));
        jMinusYViewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMinusYViewButtonActionPerformed(evt);
            }
        });

        jModelWindowToolBar.add(jMinusYViewButton);

        jPlusYViewButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/opensim/view/bottomView_axes.png")));
        jPlusYViewButton.setToolTipText("+Y View");
        jPlusYViewButton.setAlignmentX(0.5F);
        jPlusYViewButton.setBorderPainted(false);
        jPlusYViewButton.setContentAreaFilled(false);
        jPlusYViewButton.setFocusPainted(false);
        jPlusYViewButton.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jPlusYViewButton.setMaximumSize(new java.awt.Dimension(20, 20));
        jPlusYViewButton.setMinimumSize(new java.awt.Dimension(20, 20));
        jPlusYViewButton.setPreferredSize(new java.awt.Dimension(20, 20));
        jPlusYViewButton.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/org/opensim/view/bottomView_axes_selected.png")));
        jPlusYViewButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/org/opensim/view/bottomView_axes_rollover.png")));
        jPlusYViewButton.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/org/opensim/view/bottomView_axes_rollover_selected.png")));
        jPlusYViewButton.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/org/opensim/view/bottomView_axes_selected.png")));
        jPlusYViewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPlusYViewButtonActionPerformed(evt);
            }
        });

        jModelWindowToolBar.add(jPlusYViewButton);

        jMinusZViewButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/opensim/view/rightView_axes.png")));
        jMinusZViewButton.setToolTipText("-Z View");
        jMinusZViewButton.setAlignmentX(0.5F);
        jMinusZViewButton.setBorderPainted(false);
        jMinusZViewButton.setContentAreaFilled(false);
        jMinusZViewButton.setFocusPainted(false);
        jMinusZViewButton.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jMinusZViewButton.setMaximumSize(new java.awt.Dimension(20, 20));
        jMinusZViewButton.setMinimumSize(new java.awt.Dimension(20, 20));
        jMinusZViewButton.setPreferredSize(new java.awt.Dimension(20, 20));
        jMinusZViewButton.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/org/opensim/view/rightView_axes_selected.png")));
        jMinusZViewButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/org/opensim/view/rightView_axes_rollover.png")));
        jMinusZViewButton.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/org/opensim/view/rightView_axes_rollover_selected.png")));
        jMinusZViewButton.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/org/opensim/view/rightView_axes_selected.png")));
        jMinusZViewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMinusZViewButtonActionPerformed(evt);
            }
        });

        jModelWindowToolBar.add(jMinusZViewButton);

        jPlusZViewButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/opensim/view/leftView_axes.png")));
        jPlusZViewButton.setToolTipText("+Z View");
        jPlusZViewButton.setAlignmentX(0.5F);
        jPlusZViewButton.setBorderPainted(false);
        jPlusZViewButton.setContentAreaFilled(false);
        jPlusZViewButton.setFocusPainted(false);
        jPlusZViewButton.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jPlusZViewButton.setMaximumSize(new java.awt.Dimension(20, 20));
        jPlusZViewButton.setMinimumSize(new java.awt.Dimension(20, 20));
        jPlusZViewButton.setPreferredSize(new java.awt.Dimension(20, 20));
        jPlusZViewButton.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/org/opensim/view/leftView_axes_selected.png")));
        jPlusZViewButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/org/opensim/view/leftView_axes_rollover.png")));
        jPlusZViewButton.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/org/opensim/view/leftView_axes_rollover_selected.png")));
        jPlusZViewButton.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/org/opensim/view/leftView_axes_selected.png")));
        jPlusZViewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPlusZViewButtonActionPerformed(evt);
            }
        });

        jModelWindowToolBar.add(jPlusZViewButton);

        jTakeSnapshotButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/opensim/view/stillCamera.png")));
        jTakeSnapshotButton.setToolTipText("Save View as Image");
        jTakeSnapshotButton.setAlignmentX(0.5F);
        jTakeSnapshotButton.setBorderPainted(false);
        jTakeSnapshotButton.setContentAreaFilled(false);
        jTakeSnapshotButton.setFocusPainted(false);
        jTakeSnapshotButton.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jTakeSnapshotButton.setMaximumSize(new java.awt.Dimension(20, 20));
        jTakeSnapshotButton.setMinimumSize(new java.awt.Dimension(20, 20));
        jTakeSnapshotButton.setPreferredSize(new java.awt.Dimension(20, 20));
        jTakeSnapshotButton.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/org/opensim/view/stillCamera_selected.png")));
        jTakeSnapshotButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/org/opensim/view/stillCamera_rollover.png")));
        jTakeSnapshotButton.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/org/opensim/view/stillCamera_rollover_selected.png")));
        jTakeSnapshotButton.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/org/opensim/view/stillCamera_selected.png")));
        jTakeSnapshotButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTakeSnapshotButtonActionPerformed(evt);
            }
        });

        jModelWindowToolBar.add(jTakeSnapshotButton);

        jStartStopMovieToggleButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/opensim/view/movieCamera.png")));
        jStartStopMovieToggleButton.setToolTipText("Start/Stop Save Animation as Movie");
        jStartStopMovieToggleButton.setAlignmentX(0.5F);
        jStartStopMovieToggleButton.setBorderPainted(false);
        jStartStopMovieToggleButton.setContentAreaFilled(false);
        jStartStopMovieToggleButton.setFocusPainted(false);
        jStartStopMovieToggleButton.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jStartStopMovieToggleButton.setMaximumSize(new java.awt.Dimension(20, 20));
        jStartStopMovieToggleButton.setMinimumSize(new java.awt.Dimension(20, 20));
        jStartStopMovieToggleButton.setPreferredSize(new java.awt.Dimension(20, 20));
        jStartStopMovieToggleButton.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/org/opensim/view/movieCamera_selected.png")));
        jStartStopMovieToggleButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/org/opensim/view/movieCamera_rollover.png")));
        jStartStopMovieToggleButton.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/org/opensim/view/movieCamera_rollover_selected.png")));
        jStartStopMovieToggleButton.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/org/opensim/view/movieCamera_selected.png")));
        jStartStopMovieToggleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jStartStopMovieToggleButtonActionPerformed(evt);
                jToggleButton1ActionPerformed(evt);
            }
        });

        jModelWindowToolBar.add(jStartStopMovieToggleButton);

        add(jModelWindowToolBar, java.awt.BorderLayout.EAST);

        openSimCanvas1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                openSimCanvas1MouseReleased(evt);
            }
        });
        openSimCanvas1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                openSimCanvas1FocusGained(evt);
            }
        });

        add(openSimCanvas1, java.awt.BorderLayout.CENTER);

    }// </editor-fold>//GEN-END:initComponents

    private void openSimCanvas1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_openSimCanvas1MouseReleased
// TODO add your handling code here:
        if ((evt.getModifiers() == (InputEvent.BUTTON1_MASK))) {
            jMinusZViewButton.setSelected(false);
            jPlusZViewButton.setSelected(false);
            jPlusYViewButton.setSelected(false);
            jMinusYViewButton.setSelected(false);
            jPlusXViewButton.setSelected(false);
            jMinusXViewButton.setSelected(false);
        }
    }//GEN-LAST:event_openSimCanvas1MouseReleased

    private void jBackgroundColorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBackgroundColorButtonActionPerformed
// TODO add your handling code here:
        JColorChooser backgroundColorChooser = new JColorChooser();
        OpenSimCanvas dCanvas = ViewDB.getInstance().getCurrenWindow().getCanvas();
        Color newColor = backgroundColorChooser.showDialog(dCanvas, "Select new background color", dCanvas.getBackground());
        if (newColor != null){
             float[] colorComponents = newColor.getRGBComponents(null);
             dCanvas.GetRenderer().SetBackground(colorComponents[0], colorComponents[1], colorComponents[2]);
             String defaultBackgroundColor=String.valueOf(colorComponents[0])+", "+
                     String.valueOf(colorComponents[1])+", "+
                     String.valueOf(colorComponents[2]);
             Preferences.userNodeForPackage(TheApp.class).put("BackgroundColor", defaultBackgroundColor);

             dCanvas.repaint();
        }
    }//GEN-LAST:event_jBackgroundColorButtonActionPerformed

    private void jAxesToggleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAxesToggleButtonActionPerformed
// TODO add your handling code here:
        if (ViewDB.getInstance().isAxesDisplayed()) {
            ViewDB.getInstance().showAxes(false);
            // correct selected mode
            jAxesToggleButton.setSelected(false);
        }
        else {
            ViewDB.getInstance().showAxes(true);
            // correct selected mode
            jAxesToggleButton.setSelected(true);
        }
    }//GEN-LAST:event_jAxesToggleButtonActionPerformed

    private void openSimCanvas1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_openSimCanvas1FocusGained
// TODO add your handling code here:
        ViewDB.getInstance().setCurrentModelWindow(this);
        double[] canvasBackgroundDouble = ViewDB.getInstance().getCurrenWindow().getCanvas().GetRenderer().GetBackground();
        Color canvasBackgroundColor = new java.awt.Color((int) (canvasBackgroundDouble[0]*255), (int) (canvasBackgroundDouble[1]*255), (int) (canvasBackgroundDouble[2]*255));
        Color toolBarBackgroundColor = jModelWindowToolBar.getBackground();
        if (toolBarBackgroundColor == canvasBackgroundColor) {
            // do nothing
        }
        else {
            jModelWindowToolBar.setBackground(canvasBackgroundColor);
        }
    }//GEN-LAST:event_openSimCanvas1FocusGained

    private void jPlusXViewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPlusXViewButtonActionPerformed
// TODO add your handling code here:
        openSimCanvas1.applyCameraPlusX();
        // correct selected modes
        jMinusZViewButton.setSelected(false);
        jPlusZViewButton.setSelected(false);
        jPlusYViewButton.setSelected(false);
        jMinusYViewButton.setSelected(false);
        jPlusXViewButton.setSelected(true);
        jMinusXViewButton.setSelected(false);
    }//GEN-LAST:event_jPlusXViewButtonActionPerformed

    private void jPlusYViewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPlusYViewButtonActionPerformed
// TODO add your handling code here:
        openSimCanvas1.applyCameraPlusY();
        // correct selected modes
        jMinusZViewButton.setSelected(false);
        jPlusZViewButton.setSelected(false);
        jPlusYViewButton.setSelected(true);
        jMinusYViewButton.setSelected(false);
        jPlusXViewButton.setSelected(false);
        jMinusXViewButton.setSelected(false);
    }//GEN-LAST:event_jPlusYViewButtonActionPerformed

    private void jMinusZViewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMinusZViewButtonActionPerformed
// TODO add your handling code here:
        openSimCanvas1.applyCameraMinusZ();
        // correct selected modes
        jMinusZViewButton.setSelected(true);
        jPlusZViewButton.setSelected(false);
        jPlusYViewButton.setSelected(false);
        jMinusYViewButton.setSelected(false);
        jPlusXViewButton.setSelected(false);
        jMinusXViewButton.setSelected(false);        
    }//GEN-LAST:event_jMinusZViewButtonActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
// TODO add your handling code here:
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jStartStopMovieToggleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jStartStopMovieToggleButtonActionPerformed
// TODO add your handling code here:
        javax.swing.JToggleButton btn = (javax.swing.JToggleButton)(evt.getSource());
        if (btn.getModel().isSelected()){
            String fileName = FileUtils.getInstance().browseForFilename(".avi", "Movie file to create", false);
            //System.out.println("Create movie to file"+fileName);
            if (fileName!=null){
                // Append .avi to the end if not done by user
                if (!fileName.endsWith(".avi"))
                    fileName = fileName+".avi";
                getCanvas().createMovie(fileName);
            }
            else {
                btn.getModel().setSelected(false);
            }
            // correct selected mode
            jStartStopMovieToggleButton.setSelected(true);
        }
        else {
            getCanvas().finishMovie();
            //System.out.println("Finish movie");
            // correct selected mode
            jStartStopMovieToggleButton.setSelected(false);
        }
    }//GEN-LAST:event_jStartStopMovieToggleButtonActionPerformed

    private void jPlusZViewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPlusZViewButtonActionPerformed
// TODO add your handling code here:
        openSimCanvas1.applyCameraPlusZ();
        // correct selected modes
        jMinusZViewButton.setSelected(false);
        jPlusZViewButton.setSelected(true);
        jPlusYViewButton.setSelected(false);
        jMinusYViewButton.setSelected(false);
        jPlusXViewButton.setSelected(false);
        jMinusXViewButton.setSelected(false);
    }//GEN-LAST:event_jPlusZViewButtonActionPerformed

    private void jMinusXViewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMinusXViewButtonActionPerformed
// TODO add your handling code here:
        openSimCanvas1.applyCameraMinusX();
        // correct selected modes
        jMinusZViewButton.setSelected(false);
        jPlusZViewButton.setSelected(false);
        jPlusYViewButton.setSelected(false);
        jMinusYViewButton.setSelected(false);
        jPlusXViewButton.setSelected(false);
        jMinusXViewButton.setSelected(true);      
    }//GEN-LAST:event_jMinusXViewButtonActionPerformed

   private void jMinusYViewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMinusYViewButtonActionPerformed
// TODO add your handling code here:
        openSimCanvas1.applyCameraMinusY();
        // correct selected modes
        jMinusZViewButton.setSelected(false);
        jPlusZViewButton.setSelected(false);
        jPlusYViewButton.setSelected(false);
        jMinusYViewButton.setSelected(true);
        jPlusXViewButton.setSelected(false);
        jMinusXViewButton.setSelected(false);      
   }//GEN-LAST:event_jMinusYViewButtonActionPerformed

    private void jTakeSnapshotButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTakeSnapshotButtonActionPerformed
// TODO add your handling code here:
       String defaultDir="";
       defaultDir = Preferences.userNodeForPackage(TheApp.class).get("WorkDirectory", defaultDir);
        final JFileChooser dlog = new JFileChooser(defaultDir);
        
        if (dlog.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            String fullPath = dlog.getSelectedFile().getAbsolutePath();
            if (! fullPath.toLowerCase().endsWith(".tiff")){
                fullPath = dlog.getSelectedFile().getAbsolutePath()+".tiff";
            }
            getCanvas().HardCopy(fullPath, 1);
        }
    }//GEN-LAST:event_jTakeSnapshotButtonActionPerformed

    private void jRefitModelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRefitModelButtonActionPerformed
// TODO add your handling code here:
        getCanvas().resetCamera();
        getCanvas().Render();
    }//GEN-LAST:event_jRefitModelButtonActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton jAxesToggleButton;
    private javax.swing.JButton jBackgroundColorButton;
    private javax.swing.JButton jMinusXViewButton;
    private javax.swing.JButton jMinusYViewButton;
    private javax.swing.JButton jMinusZViewButton;
    private javax.swing.JToolBar jModelWindowToolBar;
    private javax.swing.JButton jPlusXViewButton;
    private javax.swing.JButton jPlusYViewButton;
    private javax.swing.JButton jPlusZViewButton;
    private javax.swing.JButton jRefitModelButton;
    private javax.swing.JToggleButton jStartStopMovieToggleButton;
    private javax.swing.JButton jTakeSnapshotButton;
    private org.opensim.view.OpenSimCanvas openSimCanvas1;
    // End of variables declaration//GEN-END:variables
    
    public int getPersistenceType() {
        return TopComponent.PERSISTENCE_NEVER;
    }
        
    public String preferredID() {
        return "Model";
    }     
    
    public String getDisplayName()
    {
        return tabDisplayName;
    }
    
    /**
     * Potentially there could be multiple canvases inserted into this top component,
     * Use an accessor method just incase 
     */
    public org.opensim.view.OpenSimCanvas getCanvas() {
        return openSimCanvas1;
    }
    
    public Action[] getActions(){
        // Note: seem to need to do it this way rather than just new ViewReplicateAction(), etc. because java complains otherwise
        // about creating multiple instances of a shared object.
        ViewReplicateAction act1 = (ViewReplicateAction) SharedClassObject.findObject(ViewReplicateAction.class, true);   // New...
        ViewEditAction act2 = (ViewEditAction) SharedClassObject.findObject(ViewEditAction.class, true); //Edit...
                         
        return (new Action[]{act1,act2});
    };

    protected void componentActivated() {
        super.componentActivated();
        ViewDB.getInstance().setCurrentModelWindow(this);
    }

    /**
     * Window closing, remove self from ViewDB
     **/
    protected void componentClosed() {
        super.componentClosed();
        ViewDB.getInstance().removeWindow(this);
    }

    public void setTabDisplayName(String tabDisplayName) {
        this.tabDisplayName = tabDisplayName;
    }

}
