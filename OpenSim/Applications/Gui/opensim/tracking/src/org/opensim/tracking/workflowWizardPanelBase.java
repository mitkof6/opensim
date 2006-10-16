/*
 *
 * workflowWizardPanelBase
 * Author(s): Ayman Habib
 * Copyright (c) 2005-2006, Stanford University, Ayman Habib
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject
 * to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included
 * in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS
 * OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
 * IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY
 * CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT,
 * TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE
 * SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package org.opensim.tracking;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.openide.WizardDescriptor;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import org.netbeans.api.progress.ProgressHandle;
import org.netbeans.api.progress.ProgressHandleFactory;
import org.openide.DialogDisplayer;
import org.openide.NotifyDescriptor;
import org.opensim.modeling.Investigation;
import org.opensim.modeling.Model;
import org.opensim.modeling.SimmModel;
import org.opensim.modeling.SimtkAnimationCallback;
import org.opensim.view.ModelWindowVTKTopComponent;
import org.opensim.view.ViewDB;

/**
 *
 * @author Ayman Habib
 *
 * Base class for all Tracking Workflow panels 
 */
abstract class workflowWizardPanelBase implements WizardDescriptor.Panel {
    
     public WorkflowDescriptor descriptor;
     private boolean valid=true; // Can proceed to next
     protected boolean needProgress=false;  // The task will need to show some progress info
     protected final int UPDATE_FREQUENCY=100; // How often we update the display in milliseconds
    /**
     * Creates a new instance of workflowWizardPanelBase
     */
    public workflowWizardPanelBase() {
    }
    
    /** Execute the step (normally when Execute button is pushed */
    abstract boolean executeStep();   
    
    public void markValid(boolean valid){
        this.valid = valid;
        fireChangeEvent();
    }

     final public boolean isValid() {
        // If it is always OK to press Next or Finish, then:
        return valid;
        // If it depends on some condition (form filled out...), then:
        // return someCondition();
        // and when this condition changes (last form field filled in...) then:
        // fireChangeEvent();
        // and uncomment the complicated stuff below.
    }
     
    private final Set<ChangeListener> listeners = new HashSet<ChangeListener>(1);
    public final void addChangeListener(ChangeListener l) {
        synchronized (listeners) {
            listeners.add(l);
        }
    }
    public final void removeChangeListener(ChangeListener l) {
        synchronized (listeners) {
            listeners.remove(l);
        }
    }
    protected final void fireChangeEvent() {
        Iterator<ChangeListener> it;
        synchronized (listeners) {
            it = new HashSet<ChangeListener>(listeners).iterator();
        }
        ChangeEvent ev = new ChangeEvent(this);
        while (it.hasNext()) {
            it.next().stateChanged(ev);
        }
    }
    abstract public void updateVisibility();

    public boolean isNeedProgress() {
        return needProgress;
    }

    public void setNeedProgress(boolean needProgress) {
        this.needProgress = needProgress;
    }
    /**
     * runDynamicInvestigation does all the leg work of setting up the GUI, callback to run
     * a Dynamic investigation and update display with the resulting animation
     */
    protected void runDynamicInvestigation(final Investigation dInvestigation, final Boolean isDeterministic) {
 
        final Model model = dInvestigation.getModel();
        SimmModel visModel=null;     // model used for visualization only
        final ProgressHandle progressHandle = ProgressHandleFactory.createHandle("Run Investigation "+dInvestigation.getName());
        final double investigationDuration = (dInvestigation.getFinalTime() - dInvestigation.getStartTime());
        final double startTime = dInvestigation.getStartTime();
        final SimtkAnimationCallback animationCallback = new SimtkAnimationCallback(model);
        
        dInvestigation.getModel().addIntegCallback(animationCallback);  
        
        // show model in new window if possible
         final ModelWindowVTKTopComponent modelWindow = ViewDB.getCurrentModelWindow();
         if (modelWindow==null){
             // Show warning and proceed thatno animation will be done
             DialogDisplayer.getDefault().notify(new NotifyDescriptor.Message("No model is currently open. Results will not be visualized"));
         }
         else {
             animationCallback.extractOffsets(modelWindow.getModel());
         }
         
        progressHandle.start();
        if (isDeterministic)
            progressHandle.switchToDeterminate(100);
        
            int delay = 100; //milliseconds
            ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
              //...Perform a task...
                if (modelWindow!=null){
                        modelWindow.getCanvas().updateDisplayFromDynamicModel(animationCallback, false);
                        modelWindow.getCanvas().repaint();
                }
                }};
                
             Timer timer = new Timer(delay, taskPerformer);
/*        Timer timer = new Timer();
        timer.scheduleAtFixedRate(
            new TimerTask(){
                public void run() {
                    final double simulationTime=animationCallback.getCurrentTime();
                    double percentComplete = (animationCallback.getCurrentTime()-startTime)/investigationDuration*100.0;
                    int intPercent =(int)percentComplete;
                    if (intPercent < 0) intPercent = 0;
                    if (intPercent > 100) intPercent = 100;
                    if(modelWindow==null) System.out.println("*** modelWindow is null!");
                    if (modelWindow!=null)
                        modelWindow.getCanvas().updateDisplayFromDynamicModel(animationCallback, false);
                        SwingUtilities.invokeLater(
                            new Runnable(){
                                public void run() { modelWindow.getCanvas().repaint(); }
                            });
                }
            },0,500);
        
*/
        timer.start();
        dInvestigation.run();
        
        timer.stop();

        if (isDeterministic)
            progressHandle.progress(100);
        progressHandle.finish();
        dInvestigation.getModel().removeIntegCallback(animationCallback);
    }

}
