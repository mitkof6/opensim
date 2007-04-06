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
import java.io.IOException;
import javax.swing.SwingUtilities;
import org.openide.WizardDescriptor;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.swing.JComponent;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import org.netbeans.api.progress.ProgressHandle;
import org.netbeans.api.progress.ProgressHandleFactory;
import org.opensim.modeling.Model;
import org.opensim.modeling.AbstractTool;
import org.opensim.view.JavaAnimationCallback;
import org.opensim.view.SingleModelVisuals;
import org.opensim.view.pub.OpenSimDB;
import org.opensim.view.pub.ViewDB;

/**
 *
 * @author Ayman Habib
 *
 * Base class for all Tracking Workflow panels
 */
public abstract class workflowWizardPanelBase implements WizardDescriptor.Panel {
    
    public WorkflowDescriptor descriptor;
    private boolean canProceed=true; // Can proceed to next based on context only.
    protected final int UPDATE_FREQUENCY=100; // How often we update the display in milliseconds
    /**
     * Creates a new instance of workflowWizardPanelBase
     */
    public workflowWizardPanelBase() {
    }
    
    /** Execute the step  */
    public abstract boolean executeStep() throws IOException;
    
    public void updateValidity(boolean canProceed){
        if (this.canProceed != canProceed){
            this.canProceed = canProceed;
            fireChangeEvent();
        }
    }
    
    final public boolean isValid() {
        // If it is always OK to press Next or Finish, then:
        //System.out.println("Is Valid = "+canProceed+" Gui"+((workflowVisualPanelBase)getComponent()).isGuiCanAdvance());
        return (canProceed && ((workflowVisualPanelBase)getComponent()).isGuiCanAdvance());
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
    
    /**
     * runDynamicTool does all the leg work of setting up the GUI, callback to run
     * a Dynamic investigation and update display with the resulting animation
     */
    protected void runDynamicTool(final AbstractTool dTool, final Boolean isDeterministic) throws IOException {
        
        final Model model = dTool.getModel();
        try {
            model.setup();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        final ProgressHandle progressHandle = ProgressHandleFactory.createHandle("Run Tool "+dTool.getName());
        final double investigationDuration = (dTool.getFinalTime() - dTool.getStartTime());
        final double startTime = dTool.getStartTime();
        SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                OpenSimDB.getInstance().addModel(model);
            }});
            
        progressHandle.start();

        final JavaAnimationCallback animationCallback = new JavaAnimationCallback(model);
        model.addIntegCallback(animationCallback);
        animationCallback.setStepInterval(3);

        ViewDB viewdb = ViewDB.getInstance();
        SingleModelVisuals visModel = viewdb.getModelVisuals(model);
        while (visModel==null){
            visModel = viewdb.getModelVisuals(model);
        }
        viewdb.updateModelDisplay(model);

        dTool.run();

        viewdb.updateModelDisplay(model);

        progressHandle.finish();
        ((JComponent) getComponent()).putClientProperty("Step_executed", Boolean.TRUE);
        // Remove callback as it's owned by Java and we don't want it destroyed along with the model.
        model.removeIntegCallback(animationCallback);
        System.gc();
    }
    
}
