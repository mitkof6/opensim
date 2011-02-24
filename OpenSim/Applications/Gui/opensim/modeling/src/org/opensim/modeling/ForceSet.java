/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.40
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.opensim.modeling;

public class ForceSet extends ModelComponentSetForces {
  private long swigCPtr;

  public ForceSet(long cPtr, boolean cMemoryOwn) {
    super(opensimModelJNI.SWIGStorageUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  public static long getCPtr(ForceSet obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        opensimModelJNI.delete_ForceSet(swigCPtr);
      }
      swigCPtr = 0;
    }
    super.delete();
  }

  public ForceSet() {
    this(opensimModelJNI.new_ForceSet__SWIG_0(), true);
  }

  public ForceSet(Model model) {
    this(opensimModelJNI.new_ForceSet__SWIG_1(Model.getCPtr(model), model), true);
  }

  public ForceSet(Model model, String aFileName, boolean aUpdateFromXMLNode) {
    this(opensimModelJNI.new_ForceSet__SWIG_2(Model.getCPtr(model), model, aFileName, aUpdateFromXMLNode), true);
  }

  public ForceSet(Model model, String aFileName) {
    this(opensimModelJNI.new_ForceSet__SWIG_3(Model.getCPtr(model), model, aFileName), true);
  }

  public ForceSet(ForceSet aForceSet) {
    this(opensimModelJNI.new_ForceSet__SWIG_4(ForceSet.getCPtr(aForceSet), aForceSet), true);
  }

  public OpenSimObject copy() {
    long cPtr = opensimModelJNI.ForceSet_copy(swigCPtr, this);
    return (cPtr == 0) ? null : new OpenSimObject(cPtr, false);
  }

  public void copyData(ForceSet aAbsForceSet) {
    opensimModelJNI.ForceSet_copyData(swigCPtr, this, ForceSet.getCPtr(aAbsForceSet), aAbsForceSet);
  }

  public void setup(Model aModel) {
    opensimModelJNI.ForceSet_setup(swigCPtr, this, Model.getCPtr(aModel), aModel);
  }

  public boolean remove(int aIndex) {
    return opensimModelJNI.ForceSet_remove(swigCPtr, this, aIndex);
  }

  public boolean append(Force aForce) {
    return opensimModelJNI.ForceSet_append__SWIG_0(swigCPtr, this, Force.getCPtr(aForce), aForce);
  }

  public boolean append(ForceSet aForceSet, boolean aAllowDuplicateNames) {
    return opensimModelJNI.ForceSet_append__SWIG_1(swigCPtr, this, ForceSet.getCPtr(aForceSet), aForceSet, aAllowDuplicateNames);
  }

  public boolean append(ForceSet aForceSet) {
    return opensimModelJNI.ForceSet_append__SWIG_2(swigCPtr, this, ForceSet.getCPtr(aForceSet), aForceSet);
  }

  public boolean set(int aIndex, Force aForce) {
    return opensimModelJNI.ForceSet_set(swigCPtr, this, aIndex, Force.getCPtr(aForce), aForce);
  }

  public boolean insert(int aIndex, Force aObject) {
    return opensimModelJNI.ForceSet_insert(swigCPtr, this, aIndex, Force.getCPtr(aObject), aObject);
  }

  public SetActuators getActuators() {
    return new SetActuators(opensimModelJNI.ForceSet_getActuators(swigCPtr, this), false);
  }

  public SetActuators updActuators() {
    return new SetActuators(opensimModelJNI.ForceSet_updActuators(swigCPtr, this), false);
  }

  public SWIGTYPE_p_OpenSim__SetT_OpenSim__Muscle_t getMuscles() {
    return new SWIGTYPE_p_OpenSim__SetT_OpenSim__Muscle_t(opensimModelJNI.ForceSet_getMuscles(swigCPtr, this), false);
  }

  public SWIGTYPE_p_OpenSim__SetT_OpenSim__Muscle_t updMuscles() {
    return new SWIGTYPE_p_OpenSim__SetT_OpenSim__Muscle_t(opensimModelJNI.ForceSet_updMuscles(swigCPtr, this), false);
  }

  public void getStateVariableNames(ArrayStr rNames) {
    opensimModelJNI.ForceSet_getStateVariableNames(swigCPtr, this, ArrayStr.getCPtr(rNames), rNames);
  }

  public void computeEquilibrium(SWIGTYPE_p_SimTK__State s) {
    opensimModelJNI.ForceSet_computeEquilibrium(swigCPtr, this, SWIGTYPE_p_SimTK__State.getCPtr(s));
  }

  public boolean check() {
    return opensimModelJNI.ForceSet_check(swigCPtr, this);
  }

}
