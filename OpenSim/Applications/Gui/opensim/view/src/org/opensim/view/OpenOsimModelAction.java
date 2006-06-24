package org.opensim.view;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import javax.swing.JFileChooser;
import org.openide.util.HelpCtx;
import org.openide.util.NbBundle;
import org.opensim.common.OpenSimDB;
import org.opensim.modeling.SimmModel;
import org.opensim.view.base.OpensimAction;

public final class OpenOsimModelAction extends OpensimAction {
    
    private String fileName;
    
    public void performAction() {
        // TODO implement action body
        // Browse for model file
        final JFileChooser dlog = new JFileChooser();
        
        if (dlog.showOpenDialog(null) == JFileChooser.APPROVE_OPTION && dlog.getSelectedFile() != null) {
            fileName = dlog.getSelectedFile().getAbsolutePath();
           // Make the model
            SimmModel aModel = new SimmModel(fileName);
            aModel.setup();
            // Make the window
            ModelWindowVTKTopComponent modelWindow = new ModelWindowVTKTopComponent(aModel);
            modelWindow.open();
            
            OpenSimDB.getInstance().addObserver(modelWindow);
            OpenSimDB.getInstance().addModel(aModel);
            BottomPanelTopComponent.showLogMessage("Model has been created from file "+dlog.getSelectedFile().getAbsolutePath()+"\n");
            
            logSelf();
        }

    }
    
    public String getName() {
        return NbBundle.getMessage(OpenOsimModelAction.class, "CTL_OpenOsimModel");
    }
    
    protected String iconResource() {
        return null;
    }
    
    public HelpCtx getHelpCtx() {
        return HelpCtx.DEFAULT_HELP;
    }
    
    protected boolean asynchronous() {
        return false;
    }

    public void logSelf() {
        System.out.println("!'"+getName()+"' file='"+fileName+"'\n");
    }
    
    public void writeExternal(ObjectOutput out) throws IOException {
    }

    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
    }
}
