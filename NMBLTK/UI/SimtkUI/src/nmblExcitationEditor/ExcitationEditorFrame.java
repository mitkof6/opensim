package nmblExcitationEditor;

import java.util.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.tree.*;

import ptolemy.plot.*;
import simtkModel.*;
import simtkUtils.*;
import simtkui.*;
import simtkui.guiUtilities.*;

public class ExcitationEditorFrame extends JFrame{

  // MenuBar
  JMenuBar jMenuBar1 = SimtkJMenuFactory.createTopMenuBar();

  JPanel jEditPlotControlPanel = new JPanel();
  JButton jRedoButton = new JButton();
  BorderLayout borderLayout2 = new BorderLayout();
  JPanel jEditQtySelectionPanel = new JPanel();
  DefaultComboBoxModel editQtyComboBoxModel = new DefaultComboBoxModel();

  JLabel jEditQtyLabel = new JLabel();
  JButton jUndoLastEditButton = new JButton();
  JPanel jPlotPanel = new JPanel();
  EditablePlot plot = new EditablePlot();
  JComboBox jEditQtyComboBox = new JComboBox();
  BorderLayout borderLayout1 = new BorderLayout();
  BorderLayout borderLayout3 = new BorderLayout();
  JMenu jMenu1 = new JMenu();
  JMenuItem jLoadControlMenuItem = new JMenuItem();
  JMenuItem jSaveControlMenuItem = new JMenuItem();
  JScrollPane jScrollPane1 = new JScrollPane();
  JPanel jPanel1 = new JPanel();
  DlgTreeModel editableQtyTreeModel = new DlgTreeModel();
  Hashtable mapControlSetsToFiles = new Hashtable();
  JControlsTree jTree1 = new JControlsTree(editableQtyTreeModel, mapControlSetsToFiles);
  BorderLayout borderLayout4 = new BorderLayout();
  JSplitPane jSplitPane1 = new JSplitPane();
  JButton jResetAxesBtn = new JButton();
  double[] xRange= new double[]{1e30, -1e30};
  double[] yRange= new double[]{1e30, -1e30};
  BorderLayout borderLayout5 = new BorderLayout();
  JPanel jPanel2 = new JPanel();
  JPanel jStatusBar = new JPanel();
  BorderLayout borderLayout6 = new BorderLayout();
  JLabel jLeftStatusLabel = new JLabel();
  JLabel jRightStatusLabel = new JLabel();
  Hashtable mapComboBoxModel2PlotIndex = new Hashtable();
  JMenu jMenu2 = new JMenu();
  JMenuItem jMenuItemHowTo = new JMenuItem("How to use");

  private static String EDIT_MINIMUM = "Min.";
  private static String EDIT_MAXIMUM = "Max.";
  private static String EDIT_VALUE = "Val.";

  public ExcitationEditorFrame() {
    try {
      jbInit();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
    this.setTitle("Excitation editor utility");
  }
  private void jbInit() throws Exception {
    jRedoButton.setText("Redo");
    jRedoButton.addActionListener(new ActionListener(){
      /**
       * actionPerformed
       *
       * @param e ActionEvent
       */
      public void actionPerformed(ActionEvent e) {
        plot.redo();
      }
    });

    jEditQtyLabel.setToolTipText("");
    jEditQtyLabel.setText("Edit:");
    jUndoLastEditButton.setToolTipText("");
    jUndoLastEditButton.setText("Undo");
    jUndoLastEditButton.addActionListener(new ActionListener(){
      /**
       * actionPerformed
       *
       * @param e ActionEvent
       */
      public void actionPerformed(ActionEvent e) {
        plot.undo();
      }
    });
    jPlotPanel.setLayout(borderLayout2);
    plot.setGrid(true);
    plot.setTitle("Excitation Editor");
    plot.setXLabel("time");
    plot.setXLog(false);
    plot.setYLabel("Excitation");
    jEditQtyComboBox.setMaximumRowCount(5);
    jEditQtyComboBox.setModel(editQtyComboBoxModel);
    jEditQtyComboBox.addActionListener(new ActionListener(){
      /**
       * actionPerformed
       *
       * @param e ActionEvent
       */
      public void actionPerformed(ActionEvent e) {
        // Get qty selected and find index in editQtyComboBoxModel, make corresponding plot editable
        JComboBox cb = (JComboBox)e.getSource();
        subControlSignal selectedControl = (subControlSignal)cb.getSelectedItem();
        if (selectedControl==null)
          return;
        // Find index
        int plotIndex = ((Integer)mapComboBoxModel2PlotIndex.get(selectedControl)).intValue();
        plot.setEditable(plotIndex);
      }
    });
    /*
    jOkButton.setText("Update");
    jOkButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e) {
        updateObjects();
      }
    });
    */
    this.getContentPane().setLayout(borderLayout3);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setJMenuBar(jMenuBar1);
    this.addWindowListener(new java.awt.event.WindowAdapter() {
      public void windowClosing(java.awt.event.WindowEvent e) {
        System.exit(0);
      }
    });

    jMenu1.setText("File");
    jLoadControlMenuItem.setText("Load");
    jLoadControlMenuItem.addActionListener(new ActionListener(){
      /**
       * actionPerformed
       *
       * @param e ActionEvent
       */
      public void actionPerformed(ActionEvent e) {

      String fileName = SimtkFileChooser.getFile("Select controls file to load", "ctr", "*.ctr");
      if (fileName == null)
        return;
      rdControlSet newSet = new rdControlSet(fileName);
      mapControlSetsToFiles.put(newSet, fileName);
      editableQtyTreeModel.addControlSet(newSet);
      }
    });
    jSaveControlMenuItem.setActionCommand("Save");
    jSaveControlMenuItem.setText("Save All");
    jSaveControlMenuItem.addActionListener(new ActionListener(){
      /**
       * actionPerformed
       *
       * @param e ActionEvent
       */
      public void actionPerformed(ActionEvent e) {
        updateObjects();
        // Cycle thru the list of control sets and write to corresponding files
        Enumeration controlSets = mapControlSetsToFiles.keys();
        while(controlSets.hasMoreElements()){
          rdControlSet nextSet = (rdControlSet) controlSets.nextElement();
          String fileName = (String) mapControlSetsToFiles.get(nextSet);
          nextSet.print(fileName);
        }
      }
    });

    jPanel1.setLayout(borderLayout4);
    jTree1.addMouseListener(new MouseAdapter() {
      public void mousePressed(MouseEvent e) {
        jTree1_mousePressed(e);
      }
      public void mouseReleased(MouseEvent e) {
        jTree1_mousePressed(e);
      }
    });
    jResetAxesBtn.setToolTipText("");
    jResetAxesBtn.setText("Reset Axes");
    jResetAxesBtn.addActionListener(new ActionListener(){
      /**
       * actionPerformed
       *
       * @param e ActionEvent
       */
      public void actionPerformed(ActionEvent e) {
        // pad bounds and reset axes
        resetPlotAxes();
      }
    });
    jEditPlotControlPanel.setLayout(borderLayout5);
    jLeftStatusLabel.setText("");
    jStatusBar.setLayout(borderLayout6);
    jLeftStatusLabel.setText("");
    jMenu2.setText("Help");
    jMenu2.add(jMenuItemHowTo);
    jEditPlotControlPanel.add(jPanel2,  BorderLayout.CENTER);
    jPanel2.add(jResetAxesBtn, null);
    jPanel2.add(jUndoLastEditButton, null);
    jPanel2.add(jRedoButton, null);
    jPanel2.add(jEditQtySelectionPanel, null);
    jPanel2.add(jEditQtyLabel, null);
    jPanel2.add(jEditQtyComboBox, null);
    jEditPlotControlPanel.add(jStatusBar,  BorderLayout.SOUTH);
    this.getContentPane().add(jSplitPane1,  BorderLayout.CENTER);
    jSplitPane1.add(jScrollPane1, JSplitPane.LEFT);
    jSplitPane1.add(jPlotPanel, JSplitPane.RIGHT);
    jPlotPanel.add(plot, BorderLayout.CENTER);
    jScrollPane1.getViewport().add(jPanel1, null);
    jPanel1.add(jTree1,  BorderLayout.CENTER);
    this.getContentPane().add(jEditPlotControlPanel,  BorderLayout.SOUTH);
    jMenuBar1.add(jMenu1);
    jMenuBar1.add(jMenu2);
    jMenu1.add(jLoadControlMenuItem);
    jMenu1.add(jSaveControlMenuItem);
    jStatusBar.add(jLeftStatusLabel,  BorderLayout.EAST);
    jStatusBar.add(jRightStatusLabel, BorderLayout.WEST);
//    jTree1.setSelectionModel(new LeafOnlyTreeSelectionModel());
    jMenuItemHowTo.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        jMenuItemHowTo_actionPerformed(e);
      }
    });
    jSplitPane1.setDividerLocation(80);

  }

  void jLoadControlMenuItem_actionPerformed(ActionEvent e) {
    // Bring dlg to browse for control file
  }

  void jSaveControlMenuItem_actionPerformed(ActionEvent e) {
    // iterate thru map and save controlSets to their corresponding file
  }

  private void updateObjects()
  {
    // Cycle thru plots thru editQtyComboBoxModel
    int numPlots = editQtyComboBoxModel.getSize();
    for (int i=0; i < numPlots; i++){
      subControlSignal subControl = (subControlSignal) editQtyComboBoxModel.getElementAt(i);
      int plotIndex = ((Integer)mapComboBoxModel2PlotIndex.get(subControl)).intValue();
      // get data for plot i and set it in control
      double[][] data = plot.getData(plotIndex);
      // Modify control from data, assume no change in number of nodes
      rdControl control = (rdControl) subControl.getControl();
      int numNodes = control.getNumParameters();
      if (subControl.getSub().equals(EDIT_VALUE)){
        for (int j = 0; j < numNodes; j++) {
          control.setParameterValue(j, data[1][j]);
        }
      }
      else if (subControl.getSub().equals(EDIT_MINIMUM)){
        for (int j = 0; j < numNodes; j++) {
          control.setParameterMin(j, data[1][j]);
        }
      }
      else {
        for (int j = 0; j < numNodes; j++) {
          control.setParameterMax(j, data[1][j]);
        }
      }
    }
  }
  /**
   * loadControlIntoPlot
   *
   * @param aControl is the control to be edited visually
   */
  private int loadControlIntoPlot(rdControl aControl, String sub) {
    plot.setMarksStyle("dots");
    int numNodes = aControl.getNumParameters();
    int availableIndex = getAvailablePlotIndex();
    subControlSignal sControl = new subControlSignal(aControl, sub);
    plot.addLegend(availableIndex, sControl.toString());
    for (int i=0; i < numNodes; i++){
      double x = aControl.getParameterTime(i);
      double y;
      if (sub.equals(EDIT_MINIMUM))
        y = aControl.getParameterMin(i);
      else if (sub.equals(EDIT_MAXIMUM))
        y = aControl.getParameterMax(i);
      else
        y = aControl.getParameterValue(i);
      plot.addPoint(availableIndex, x, y, true);
      // Maintain xRange and yRange for axes control
      if (x < xRange[0])
        xRange[0] = x;
      else if (x > xRange[1])
        xRange[1] = x;
      if (y < yRange[0])
         yRange[0] = y;
       else if (y > yRange[1])
         yRange[1] = y;
   }
   //plot.addPointWithErrorBars(numPlots, 0.5, .3, .2, .5, false);

    resetPlotAxes();

   return availableIndex;
  }

  /**
   * getAvailablePlotIndex
   * traverse the map to plot indices and find first available one
   * @return int
   */
  private int getAvailablePlotIndex() {
    Integer[] indexArray = new  Integer[mapComboBoxModel2PlotIndex.values().size()];
    Arrays.sort( mapComboBoxModel2PlotIndex.values().toArray( indexArray) ) ;
    for (int i=0; i < indexArray.length; i++){
      if (indexArray[i].intValue() > i)
        return i;
    }
    return indexArray.length;
  }

  private void resetPlotAxes() {
    double xmin = xRange[0] - (xRange[1] - xRange[0]) * 0.05;
    double xmax = xRange[1] + (xRange[1] - xRange[0]) * 0.05;
    double ymin = yRange[0] - (yRange[1] - yRange[0]) * 0.05;
    double ymax = yRange[1] + (yRange[1] - yRange[0]) * 0.05;
    plot.setXRange(xmin, xmax);
    plot.setYRange(ymin, ymax);
    plot.repaint();
  }
  public class DlgTreeModel extends DefaultTreeModel{

    DefaultMutableTreeNode _root = null;

    public DlgTreeModel() {
      super( new DefaultMutableTreeNode("Root", true));
      _root = (DefaultMutableTreeNode) getRoot();
      // Make sure being a leaf is not decided based on number of children as we have models without actuators
      // for example but we don't want the "Actuators" node to show as leaf.
      setAsksAllowsChildren(true);
    }

    /**
     * addControlSet
     *
     * @param newSet rdControlSet
     */
    public void addControlSet(rdControlSet newSet) {
     DefaultMutableTreeNode controlNode;
     if (newSet != null){
       controlNode = new DefaultMutableTreeNode(newSet, true);
       // Create nodes for individual controls
       int controlSetSize = newSet.getSize();
       for(int i=0; i < controlSetSize; i++){
         DefaultMutableTreeNode singleControlNode = new DefaultMutableTreeNode(newSet.get(i), false);
          insertNodeInto(singleControlNode, controlNode, i);
       }
       insertNodeInto(controlNode, _root, _root.getChildCount());
     }
     //reload();
   }
  }

  public class JControlsTree extends JTree
  {
    private JPopupMenu _popup = new JPopupMenu("Available operations");
    private Hashtable controls2Files;  //Keep a refernce to the hashtable that maps rdControlSet objects to filenames
    public JControlsTree(TreeModel model, Hashtable fileNames)
    {
      super(model);
      controls2Files = fileNames;
    }

    /**
     * handleMousePressed
     *
     * @param e MouseEvent
     */
    private void handleMousePressed(MouseEvent e) {
     TreePath selPath = getPathForLocation(e.getX(), e.getY());
     if (selPath==null)
       return;
     final TreePath[] selected = getSelectionPaths();
     if (selected==null)
       return;
     _popup.removeAll();
     if (selected.length==1){
       int pathlength = selected[0].getPathCount();
       DefaultMutableTreeNode selNode = (DefaultMutableTreeNode) selected[0].
           getPathComponent(pathlength - 1);
       final Object selObj = selNode.getUserObject();
       if (selObj instanceof rdControlSet){
         final rdControlSet selrdObj = (rdControlSet) selObj;
         final String fileName = getFilenameForControlSet(selrdObj);
         _popup.add(new AbstractAction("Save") {
           /**
            * actionPerformed
            *
            * @param e ActionEvent
            */
           public void actionPerformed(ActionEvent e) {
             updateObjects();
             selrdObj.print(fileName);
           }
         });
         _popup.add(new AbstractAction("Save As") {
          /**
           * actionPerformed
           *
           * @param e ActionEvent
           */
          public void actionPerformed(ActionEvent e) {
            String newFileName = getSaveAsFileName(fileName);
            if (newFileName != null){
              updateObjects();
              selrdObj.print(newFileName);
            }
          }
        });
      }
     }
     boolean controlSelected = false;
     for (int i = 0; i < selected.length; i++) {
       int pathlength = selected[i].getPathCount();
       DefaultMutableTreeNode selNode = (DefaultMutableTreeNode) selected[i].
           getPathComponent(pathlength - 1);
       Object selObj = selNode.getUserObject();
       if (selObj instanceof rdControl) {
         controlSelected = true;
         break;
       }
     }
     if (controlSelected) {// Show Edit & Remove only if at least one control was selected
       _popup.add(new AbstractAction("Edit") {
         public void actionPerformed(ActionEvent e) {
           for (int i = 0; i < selected.length; i++) {
             int pathlength = selected[i].getPathCount();
             DefaultMutableTreeNode selNode = (DefaultMutableTreeNode)
                 selected[i].
                 getPathComponent(pathlength - 1);
             Object selObj = selNode.getUserObject();
             if (selObj instanceof rdControl) {
               rdControl selrdObj = (rdControl) selObj;
               subControlSignal subControl = new subControlSignal(selrdObj,
                   EDIT_VALUE);
               // Don't add the same control more than once
               if (editQtyComboBoxModel.getIndexOf(subControl) == -1) {
                 int index = loadControlIntoPlot(selrdObj, EDIT_VALUE); // This has to be done first
                 mapComboBoxModel2PlotIndex.put(subControl, new Integer(index));
                 editQtyComboBoxModel.addElement(subControl);
                 // Repeat for min and max
                 index = loadControlIntoPlot(selrdObj, EDIT_MINIMUM);
                 subControl = new subControlSignal(selrdObj, EDIT_MINIMUM);
                 mapComboBoxModel2PlotIndex.put(subControl, new Integer(index));
                 editQtyComboBoxModel.addElement(subControl);
                 index = loadControlIntoPlot(selrdObj, EDIT_MAXIMUM);
                 subControl = new subControlSignal(selrdObj, EDIT_MAXIMUM);
                 mapComboBoxModel2PlotIndex.put(subControl, new Integer(index));
                 editQtyComboBoxModel.addElement(subControl);
               }
             }
           }
         }
       });
       _popup.add(new AbstractAction("Remove") {
         public void actionPerformed(ActionEvent e) {
           for (int i = 0; i < selected.length; i++) {
             int pathlength = selected[i].getPathCount();
             DefaultMutableTreeNode selNode = (DefaultMutableTreeNode)
                 selected[i].
                 getPathComponent(pathlength - 1);
             Object selObj = selNode.getUserObject();
             if (selObj instanceof rdControl) {
               rdControl selrdObj = (rdControl) selObj;
               // Don't add the same control more than once
               subControlSignal controlVal = new subControlSignal(selrdObj,
                   EDIT_VALUE);
               int index = editQtyComboBoxModel.getIndexOf(controlVal);
               if (index != -1) {
                 int plotIndex = ( (Integer) mapComboBoxModel2PlotIndex.get(
                     controlVal)).intValue();
                 plot.clear(plotIndex);
                 plot.removeLegend(plotIndex);
                 mapComboBoxModel2PlotIndex.remove(controlVal);
                 editQtyComboBoxModel.removeElementAt(index);
                 // Repeat for min and max
                 controlVal = new subControlSignal(selrdObj, EDIT_MINIMUM);
                 index = editQtyComboBoxModel.getIndexOf(controlVal);
                 plotIndex = ( (Integer) mapComboBoxModel2PlotIndex.get(
                     controlVal)).intValue();
                 plot.clear(plotIndex);
                 plot.removeLegend(plotIndex);
                 mapComboBoxModel2PlotIndex.remove(controlVal);
                 editQtyComboBoxModel.removeElementAt(index);
                 controlVal = new subControlSignal(selrdObj, EDIT_MAXIMUM);
                 index = editQtyComboBoxModel.getIndexOf(controlVal);
                 plotIndex = ( (Integer) mapComboBoxModel2PlotIndex.get(
                     controlVal)).intValue();
                 plot.clear(plotIndex);
                 plot.removeLegend(plotIndex);
                 mapComboBoxModel2PlotIndex.remove(controlVal);
                 editQtyComboBoxModel.removeElementAt(index);
               }
             }
           }
         }
       });
     }
     _popup.show((Component) e.getSource(), e.getX(), e.getY());
    }
    private String getSaveAsFileName(String oldName){
      SimDlgGetName getNameDlg = new SimDlgGetName("XML File ");
      getNameDlg.setVisible(true);
      if (!getNameDlg.userConfirmed())
        return null;
      // User confirmed
      String userFileName = new String(getNameDlg.getName());
    // Don't need the dialog anymore
      getNameDlg.dispose();

      return userFileName;
    }
    /**
     * getFilenameForControlSet
     *
     * @param selrdObj rdControlSet
     * @return String
     */
    private String getFilenameForControlSet(rdControlSet selrdObj) {
      return (String) controls2Files.get((Object) selrdObj);
    }
  }

  void jTree1_mousePressed(MouseEvent e) {
    if (e.isPopupTrigger()) {
      jTree1.handleMousePressed(e);
    }
  }

  void jMenuItemHowTo_actionPerformed(ActionEvent e) {
    // pop up a help dialog
    excitationEditortHelpDialog helpDlg = new excitationEditortHelpDialog(this);
    helpDlg.pack();
    helpDlg.show();
  }


  /*

  public class LeafOnlyTreeSelectionModel
      extends DefaultTreeSelectionModel {

    public void addSelectionPath(TreePath path)
    {
      DefaultMutableTreeNode lastComp =
          (DefaultMutableTreeNode) path.getLastPathComponent();
      if (lastComp.isLeaf()) {
        super.addSelectionPath(path);
      }
    }

    public void addSelectionPaths(TreePath[] paths)

    {
      for (int i = 0; i < paths.length; i++) {
        DefaultMutableTreeNode lastComp =
            (DefaultMutableTreeNode) paths[i].getLastPathComponent();
        if (!lastComp.isLeaf()) {
          return;
        }
      }
      super.addSelectionPaths(paths);
    }

    public void setSelectionPath(TreePath path)
    {
      DefaultMutableTreeNode lastComp =
          (DefaultMutableTreeNode) path.getLastPathComponent();
      if (lastComp.isLeaf()) {
        super.setSelectionPath(path);
      }
    }

    public void setSelectionPaths(TreePath[] paths)
    {
      for (int i = 0; i < paths.length; i++) {
        DefaultMutableTreeNode lastComp =
            (DefaultMutableTreeNode) paths[i].getLastPathComponent();
        if (!lastComp.isLeaf()) {
          return;
        }
      }
      super.setSelectionPaths(paths);
    }
}

*/
  private class subControlSignal
  {
    rdObject _control;
    String _sub;

    private subControlSignal()
    {};
    public subControlSignal(rdControl control, String sub)
    {
      _control = control;
      _sub = sub;
    }
    public String toString()
    {
      return _sub+_control.toString();
    }
    public rdObject getControl()
    {
      return _control;
    }
    public String getSub()
    {
      return _sub;
    }
    public boolean equals(Object obj)
    {
      boolean returnValue = false;
      if (obj instanceof subControlSignal){
        subControlSignal other = (subControlSignal) obj;
        returnValue = (other.getControl()==_control)&& _sub.equals(other.getSub());
      }
      return returnValue;
    }
    public int hashCode()
    {
      return _control.hashCode();
    }
  }
}
