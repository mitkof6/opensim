/*
 * PlotterQuantityNameFilterJPanel.java Filtering dialog for Quantity name  invoked by Plotter
 *
 * Created on April 30, 2007, 1:14 PM
 */

package org.opensim.plotter;

import java.util.ArrayList;
import java.util.Vector;
import java.util.regex.PatternSyntaxException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import org.openide.DialogDisplayer;
import org.openide.NotifyDescriptor;
import org.opensim.modeling.ActuatorSet;
import org.opensim.modeling.ArrayObjPtr;
import org.opensim.modeling.Model;
import org.opensim.modeling.ObjectGroup;
import org.opensim.view.pub.OpenSimDB;
import org.opensim.view.pub.ViewDB;

/**
 *
 * @author  Ayman
 */

public class PlotterQuantityNameFilterJPanel extends javax.swing.JPanel 
                                            implements TableModelListener,
                                                       DocumentListener
{
   
   private PlotterQuantityNameFilterTableModel tableModel;
   public enum FilterBy {RegularExpression, ModelGroup};
   private FilterBy currentFilter = FilterBy.RegularExpression;
   private String   pattern="";
   private Model currentModel=null;
   ArrayList<String> metaCharacters=new ArrayList<String>();
   private boolean sumOnly=false;
   private static boolean filterByModel;
   /**
    * Creates new form PlotterQuantityNameFilterJPanel
    */
   public PlotterQuantityNameFilterJPanel(PlotterSourceInterface src) {
      initComponents();
      metaCharacters.add("*");
      metaCharacters.add("+");
      metaCharacters.add("?");
      FilterTextField.getDocument().addDocumentListener(this);
      FilterTextField.setText(getPattern());
      jFilename.setText(src.getDisplayName());
      tableModel = new PlotterQuantityNameFilterTableModel(src);
      jTable1.setModel(tableModel);
      jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      tableModel.addTableModelListener(this);
      //Don't track selection jTable1.getSelectionModel().addListSelectionListener(this);
      setFilter(currentFilter);
      updateSelected();
   }
   
   /** This method is called from within the constructor to
    * initialize the form.
    * WARNING: Do NOT modify this code. The content of this method is
    * always regenerated by the Form Editor.
    */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jPanel1 = new javax.swing.JPanel();
        jNumSelectedLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jFilename = new javax.swing.JLabel();
        FilterTextField = new javax.swing.JFormattedTextField();
        jMuscleGroupComboBox = new javax.swing.JComboBox();
        jModelComboBox = new javax.swing.JComboBox();
        jPatternRadioButton = new javax.swing.JRadioButton();
        jModelGroupRadioButton = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jShowAllButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jSelectAllCheckBox = new javax.swing.JCheckBox();
        jDeselectAllCheckBox = new javax.swing.JCheckBox();
        jSumCheckBox = new javax.swing.JCheckBox();

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

        jNumSelectedLabel.setText("0 items selected");

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(73, Short.MAX_VALUE)
                .add(jNumSelectedLabel)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(jNumSelectedLabel)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jFilename.setText("filename");

        FilterTextField.setToolTipText("use '.*' for wildcard, add patterns with '|' and press Apply");

        jMuscleGroupComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select Muscle Group" }));
        jMuscleGroupComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMuscleGroupComboBoxActionPerformed(evt);
            }
        });

        jModelComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select Model" }));
        jModelComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jModelComboBoxActionPerformed(evt);
            }
        });

        buttonGroup1.add(jPatternRadioButton);
        jPatternRadioButton.setSelected(true);
        jPatternRadioButton.setText("pattern");
        jPatternRadioButton.setToolTipText("Select by typing regular expression in box");
        jPatternRadioButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jPatternRadioButton.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jPatternRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPatternRadioButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(jModelGroupRadioButton);
        jModelGroupRadioButton.setText("model");
        jModelGroupRadioButton.setToolTipText("use names from a model");
        jModelGroupRadioButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jModelGroupRadioButton.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jModelGroupRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jModelGroupRadioButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Filter By");

        jLabel2.setText("Source:");

        jShowAllButton.setText("Show All");
        jShowAllButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jShowAllButtonActionPerformed(evt);
            }
        });

        jLabel3.setText("group");

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel2Layout.createSequentialGroup()
                        .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(jPanel2Layout.createSequentialGroup()
                                .add(jLabel1)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(jPatternRadioButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 72, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(jModelGroupRadioButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 64, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                            .add(jLabel3))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(jMuscleGroupComboBox, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(jModelComboBox, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(jPanel2Layout.createSequentialGroup()
                                .add(FilterTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 80, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jShowAllButton)))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 32, Short.MAX_VALUE))
                    .add(jPanel2Layout.createSequentialGroup()
                        .add(jLabel2)
                        .add(54, 54, 54)
                        .add(jFilename, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .add(20, 20, 20)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel2)
                    .add(jFilename))
                .add(15, 15, 15)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(jPatternRadioButton)
                    .add(FilterTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jShowAllButton))
                .add(7, 7, 7)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jModelGroupRadioButton)
                    .add(jModelComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel3)
                    .add(jMuscleGroupComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jSelectAllCheckBox.setText("select all shown");
        jSelectAllCheckBox.setToolTipText("select all shown quantities");
        jSelectAllCheckBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jSelectAllCheckBox.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jSelectAllCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSelectAllCheckBoxActionPerformed(evt);
            }
        });

        jDeselectAllCheckBox.setText("deselect all shown");
        jDeselectAllCheckBox.setToolTipText("deselect all shown quantities");
        jDeselectAllCheckBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jDeselectAllCheckBox.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jDeselectAllCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jDeselectAllCheckBoxActionPerformed(evt);
            }
        });

        jSumCheckBox.setText("sum only");
        jSumCheckBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jSumCheckBox.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jSumCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSumCheckBoxActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jSelectAllCheckBox)
                    .add(jDeselectAllCheckBox))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jSumCheckBox)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jScrollPane1, 0, 0, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jSelectAllCheckBox)
                            .add(jSumCheckBox))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(jDeselectAllCheckBox)
                        .addContainerGap())
                    .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jSumCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSumCheckBoxActionPerformed
// TODO add your handling code here:
        sumOnly=((JCheckBox)evt.getSource()).isSelected();
    }//GEN-LAST:event_jSumCheckBoxActionPerformed

    private void jMuscleGroupComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMuscleGroupComboBoxActionPerformed
// TODO add your handling code here:
        JComboBox cb = (JComboBox)evt.getSource();
        String groupName = (String) cb.getSelectedItem();
       // get members and use them to filter
        ActuatorSet acts=currentModel.getActuatorSet();
        ObjectGroup gp=acts.getGroup(groupName);
        ArrayObjPtr members=gp.getMembers();
        // Form a vector of muscle names
        String tempPattern="";
        for(int i=0;i<members.getSize();i++){
            tempPattern +=members.get(i).getName();
            if (i<members.getSize()-1)
               tempPattern += "|"; 
        }
        // Filter visible items by musclesInGroup
        tableModel.restrictNamesBy(tempPattern);
    }//GEN-LAST:event_jMuscleGroupComboBoxActionPerformed

    private void jModelComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jModelComboBoxActionPerformed
// TODO add your handling code here:
        JComboBox cb = (JComboBox)evt.getSource();
        currentModel = (Model) cb.getSelectedItem();
        // Find model's muscle groups and fill in drop down'
        Vector<String> groups=ViewDB.getInstance().getModelGuiElements(currentModel).getActuatorGroupNames();
        jMuscleGroupComboBox.setModel(new DefaultComboBoxModel(groups));

    }//GEN-LAST:event_jModelComboBoxActionPerformed

    private void jDeselectAllCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jDeselectAllCheckBoxActionPerformed
// TODO add your handling code here:
         tableModel.selectShown(false);
         updateSelected();
        ((JCheckBox)evt.getSource()).setSelected(false);

    }//GEN-LAST:event_jDeselectAllCheckBoxActionPerformed

    private void jSelectAllCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSelectAllCheckBoxActionPerformed
        tableModel.selectShown(true);
        updateSelected();
        ((JCheckBox)evt.getSource()).setSelected(false);
// TODO add your handling code here:
    }//GEN-LAST:event_jSelectAllCheckBoxActionPerformed

    private void jShowAllButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jShowAllButtonActionPerformed
        pattern = ".*";
        tableModel.restrictNamesBy(getPattern());
// TODO add your handling code here:
    }//GEN-LAST:event_jShowAllButtonActionPerformed

    private void jModelGroupRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jModelGroupRadioButtonActionPerformed
        currentFilter=FilterBy.ModelGroup;
        // Populate combobox for models with available models
        Object[] models=OpenSimDB.getInstance().getAllModels();
        if (models.length==0){
            DialogDisplayer.getDefault().notify(new NotifyDescriptor.Message("No models to select from."));
            jPatternRadioButton.setSelected(true);
            jPatternRadioButtonActionPerformed(evt);
            return;
        }
        jModelComboBox.setModel(new DefaultComboBoxModel(models));
        currentModel = (Model)models[0];
        
        Vector<String> groups=ViewDB.getInstance().getModelGuiElements(currentModel).getActuatorGroupNames();
        jMuscleGroupComboBox.setModel(new DefaultComboBoxModel(groups));
        setFilter(currentFilter);
        
// TODO add your handling code here:
    }//GEN-LAST:event_jModelGroupRadioButtonActionPerformed

    private void jPatternRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPatternRadioButtonActionPerformed
// TODO add your handling code here:
        currentFilter=FilterBy.RegularExpression;
        setFilter(currentFilter);
    }//GEN-LAST:event_jPatternRadioButtonActionPerformed

   public void applyPattern(String regex)
{
      pattern = regex;
      FilterTextField.setText(getPattern());
      if (jPatternRadioButton.isSelected()){
         regex=convertToJavaRegex(FilterTextField);
         FilterTextField.setText(regex);
         pattern = regex;
         try{
            tableModel.applyFilter(regex);
            tableModel.fireTableDataChanged();
         } catch(PatternSyntaxException ex){
            // Should complain here'
            //jLabel4.setText(regex+".*"+"will complain");
         }
      } else {
         // update names form model, muscle goup selection
         String muscleGroup = (String)jMuscleGroupComboBox.getSelectedItem();
         Model model = (Model)jModelComboBox.getSelectedItem();
         Vector<String> names = ViewDB.getInstance().getModelGuiElements(model).getActuatorNamesForGroup(muscleGroup);
         tableModel.markSelectedNames(names);
      }
      updateSelected();
   }
    private void updateSelected() {
        int n = tableModel.getNumSelected();
        jNumSelectedLabel.setText(String.valueOf(n)+" items selected");
        int nShownSelected = tableModel.getNumShownAndSelected();
        if (nShownSelected==0){
            // enable select all, disable deselect all
            jSelectAllCheckBox.setEnabled(true);
            jDeselectAllCheckBox.setEnabled(false);
        }
        else if (nShownSelected==tableModel.getRowCount()){
            jSelectAllCheckBox.setEnabled(false);
            jDeselectAllCheckBox.setEnabled(true);
        }
        else {
            jSelectAllCheckBox.setEnabled(true);
            jDeselectAllCheckBox.setEnabled(true);
            
        }
        
    }

    public void tableChanged(TableModelEvent e) {
        int type=e.getType();
        updateSelected();
    }
   
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField FilterTextField;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox jDeselectAllCheckBox;
    private javax.swing.JLabel jFilename;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JComboBox jModelComboBox;
    private javax.swing.JRadioButton jModelGroupRadioButton;
    private javax.swing.JComboBox jMuscleGroupComboBox;
    private javax.swing.JLabel jNumSelectedLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jPatternRadioButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JCheckBox jSelectAllCheckBox;
    private javax.swing.JButton jShowAllButton;
    private javax.swing.JCheckBox jSumCheckBox;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

     /**
     * Convert string to canonical regular expression syntax
     * in particular convert * -> .*, ?->.?
     *
     */
    private String convertToJavaRegex(JTextField field)
    {
      String regex = FilterTextField.getText();
      // Replace * with .* ?with .? as it's more common
      // There appears to be a bug where the replacement cant be done inplace
      int idx = regex.indexOf("*", 0);
      //System.out.println("Regex=["+regex+"]");
      String test="";
      while(getPattern().matches(".*[^\\.]\\*")){
         test=regex.replaceAll("\\*", "\\.\\*");
         regex=test;
      }
      idx = regex.indexOf("?", 0);
      if (idx !=-1 && regex.indexOf(".?", 0)==-1){
         test=regex.replaceAll("\\?", "\\.\\?");
         regex=test;
      }
      return regex;
    }

     String getSelectedAsString() {
        if (isSumOnly()){
           String temp = tableModel.getSelectedAsString();
           return temp.replace(", ","+");
        }
        else
            return tableModel.getSelectedAsString();
    }

    String[] getSelected() {
        if (isSumOnly())
           return new String[]{getSelectedAsString()};
        
        return tableModel.getSelected();
    }
    private void setFilter(PlotterQuantityNameFilterJPanel.FilterBy currentFilter) {
        // Disable model, group selection when doing regular expression and vice versa
        boolean usePattern= (currentFilter == PlotterQuantityNameFilterJPanel.FilterBy.RegularExpression);
        jModelComboBox.setEnabled(!usePattern);
        jMuscleGroupComboBox.setEnabled(!usePattern);
        FilterTextField.setEnabled(usePattern);
    }

    public String getPattern() {
        return pattern;
        /**/

    }
    // DocumentListener implementation for changes in the pattern text field
    // to avoid working with individual key strokes that may correspond
    // to Ctrl characters, delete, paste text, ..
    public void insertUpdate(DocumentEvent e) {
        handlePatternChange();
    }
    
    public void removeUpdate(DocumentEvent e) {
        handlePatternChange();
    }

    public void changedUpdate(DocumentEvent e) {
        handlePatternChange();
    }
    /**
     * Handle changes to the text in the FilterTextField
     * a leading and a trailing .* are pre/appended for matching any substring
     */
    private void handlePatternChange()
    {
       String rawPattern = FilterTextField.getText();
       // Remove leading and trailing special characters that may interfere
       if (rawPattern.length()>0){
          // remove leading and trailing special characters
          int index=0;
          String newPattern=rawPattern;
          while(index < rawPattern.length()){
            String letter=rawPattern.substring(index, index+1);
            if (metaCharacters.contains(letter))
               newPattern=rawPattern.substring(index);
            else
               break;
            index++;
          }
          rawPattern=newPattern;
          // start from the end and repeat
          index = rawPattern.length()-1;
           while(index >= 0){
            String letter=rawPattern.substring(index, index+1);
            if (metaCharacters.contains(letter))
               newPattern=rawPattern.substring(0, index);
            else
               break;
            index--;
          }
          rawPattern=newPattern;
      }
       
       tableModel.restrictNamesBy(".*"+rawPattern+".*");
    }    

    int getNumSelected() {
       if (isSumOnly())
          return 1;
       else
         return tableModel.getNumSelected();
    }

    public boolean isSumOnly() {
        return sumOnly;
    }

    public void setSumOnly(boolean sumOnly) {
        this.sumOnly = sumOnly;
    }
}
