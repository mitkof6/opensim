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
 * SingleModelVisuals.java
 *
 * Created on November 14, 2006, 5:46 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.opensim.view;

import java.util.ArrayList;
import java.util.Vector;
import org.opensim.modeling.AbstractActuator;
import org.opensim.modeling.AbstractMuscle;
import org.opensim.modeling.ActuatorSet;
import org.opensim.modeling.ArrayObjPtr;
import org.opensim.modeling.ArrayStr;
import org.opensim.modeling.Model;
import org.opensim.modeling.BodySet;
import org.opensim.modeling.CoordinateSet;
import org.opensim.modeling.ObjectGroup;

/**
 *
 * @author Pete Loan & Ayman Habib
 */
public class SingleModelGuiElements {
    String preferredUnits; // Place holder for model specific Gui pref.
    Model model;   // model that Gui elements are created for
    
    private String[] bodyNames=null;
    private String[] coordinateNames=null;
    private String[] actuatorClassNames=null;
    private String[] actuatorNames=null;

    private boolean unsavedChanges = false;
    // Not a semaphore, just a flag to disallow the closing (and possibly editing)
    // of a model while in use.
    private boolean locked = false;
    private String lockOwner = null;

    public SingleModelGuiElements(Model model)
    {
       this.model=model;
    }

    /**
     * Turn on/off the flag for marking changes to the model.
     */
    public void setUnsavedChangesFlag(boolean state)
    {
       unsavedChanges = state;
    }

    /**
     * Get the flag for marking changes to the model.
     */
    public boolean getUnsavedChangesFlag()
    {
       return unsavedChanges;
    }

    /**
     * Get the flag for marking the model as locked.
     */
    public boolean isLocked()
    {
       return locked;
    }

    /**
     * Get the owner of the lock.
     */
    public String getLockOwner()
    {
       return lockOwner;
    }

    /**
     * Mark the model as locked. If it's already locked, return false.
     */
    public boolean lockModel(String owner)
    {
       if (locked == false) {
          locked = true;
          lockOwner = owner;
          return true;
       } else {
          return false;
       }
    }

    /**
     * Unlock the model.
     */
    public void unlockModel()
    {
       locked = false;
       lockOwner = "";
    }

    /**
     * Get a list of names for model bodies
     */
    public String[] getBodyNames()
    {
       if (bodyNames==null){
         BodySet bodies = model.getDynamicsEngine().getBodySet();
         bodyNames = new String[bodies.getSize()];
         for (int i = 0; i < bodies.getSize(); i++)
            bodyNames[i] = new String(bodies.get(i).getName());
           
       }
       return bodyNames;
    }
    
    /**
     * Get a list of names for model coordinates
     */
    public String[] getCoordinateNames()
    {
       if (coordinateNames==null){
         CoordinateSet coordinates = model.getDynamicsEngine().getCoordinateSet();
         coordinateNames = new String[coordinates.getSize()];
         for (int i = 0; i < coordinates.getSize(); i++)
            coordinateNames[i] = new String(coordinates.get(i).getName());
       }
       return coordinateNames;
    }
    /**
     * Get a list of names for actuator groups in model
     */
    public Vector<String> getActuatorGroupNames()
    {
        Vector<String> ret=new Vector<String>(4);
        ActuatorSet actuators = model.getActuatorSet();
        if (actuators !=null){
            ArrayStr muscleGroupNames = new ArrayStr();
            actuators.getGroupNames(muscleGroupNames);
            for(int i=0; i<muscleGroupNames.getSize();i++){
                ret.add(muscleGroupNames.getitem(i));
                AbstractActuator act = actuators.get(i);
            }
        }
       return ret;
    }
    /**
     * Get Actuators that belong to the passed in muscle group
     */
    public Vector<String> getActuatorNamesForGroup(String groupName)
    {
       Vector<String> ret = new Vector<String>(20);
        ActuatorSet actuators = model.getActuatorSet();
        if (actuators !=null){
           ObjectGroup group=actuators.getGroup(groupName);
           assert(group!=null);
           ArrayObjPtr objects = group.getMembers();
           for(int i=0; i<objects.getSize();i++){
                ret.add(objects.get(i).getName());
           }
        }
        return ret;
   }
    /**
     * Get a list of names for model actuators that are muscles
     */
    public Vector<String> getMuscleNames()
    {
       Vector<String> ret=new Vector<String>(20);
       ActuatorSet actuators = model.getActuatorSet();
       if (actuators !=null){
           for(int i=0; i<actuators.getSize();i++){
              if (AbstractMuscle.safeDownCast(actuators.get(i)) != null)
                 ret.add(actuators.get(i).getName());
           }
       }
       return ret;
    }

   /**
    * Get names of actuator classes
    */
   public String[] getActuatorClassNames()
   {
      if (actuatorClassNames==null) {
         actuatorClassNames = new String[5];
         actuatorClassNames[0] = new String("Schutte1993Muscle");
         actuatorClassNames[1] = new String("Thelen2003Muscle");
         actuatorClassNames[2] = new String("Force");
         actuatorClassNames[3] = new String("Torque");
         actuatorClassNames[4] = new String("GeneralizedForce");
      }
      return actuatorClassNames;
   }

   /**
    * Get names of actuators
    */
   public String[] getActuatorNames(boolean sort)
   {
        ArrayList<String> namesList=new ArrayList<String>(4);
        ActuatorSet actuators = model.getActuatorSet();
        if (actuators !=null){
            for(int i=0; i<actuators.getSize();i++){
                AbstractActuator act =actuators.get(i);
                AbstractMuscle muscle = AbstractMuscle.safeDownCast(act);
                if (muscle != null) {
                        namesList.add(muscle.getName());
                }
            }
        }
        String[] ret = new String[namesList.size()];
        System.arraycopy(namesList.toArray(), 0, ret, 0, namesList.size());
        if (sort)
           java.util.Arrays.sort(ret);
        return ret;
   }
}
