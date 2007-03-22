/*
 * ModelEvent.java
 *
 * Created on June 16, 2006, 8:59 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.opensim.view;

import java.util.EventObject;
import org.opensim.modeling.Model;

/**
 *
 * @author Ayman Habib
 */
public class ModelEvent extends EventObject {
    
    public enum Operation{Open, Close, Save, ObjectOperation, SetCurrent};
    
    Operation op= Operation.Open;
    /**
     * Creates a new instance of ModelEvent
     */
    public ModelEvent(Model source, Operation op) {
        super(source);
        this.op = op;
    }
    
    public Model getModel()
    {
        return (Model) source;
    }
    
    public ModelEvent.Operation getOperation()
    {
        return op;
    }
    
}
