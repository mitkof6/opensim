/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.31
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.opensim.modeling;

public class Actuator extends Force {
  private long swigCPtr;

  public Actuator(long cPtr, boolean cMemoryOwn) {
    super(opensimModelJNI.SWIGStorageUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  public static long getCPtr(Actuator obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if(swigCPtr != 0 && swigCMemOwn) {
      swigCMemOwn = false;
      opensimModelJNI.delete_Actuator(swigCPtr);
    }
    swigCPtr = 0;
    super.delete();
  }

  public static double getLARGE() {
    return opensimModelJNI.Actuator_LARGE_get();
  }

  public OpenSimObject copy() {
    long cPtr = opensimModelJNI.Actuator_copy__SWIG_0(swigCPtr, this);
    return (cPtr == 0) ? null : new OpenSimObject(cPtr, false);
  }

  public void copyPropertyValues(Actuator aActuator) {
    opensimModelJNI.Actuator_copyPropertyValues(swigCPtr, this, Actuator.getCPtr(aActuator), aActuator);
  }

  public static void deleteActuator(Actuator aActuator) {
    opensimModelJNI.Actuator_deleteActuator(Actuator.getCPtr(aActuator), aActuator);
  }

  public void initStateCache(SWIGTYPE_p_SimTK__State s, SWIGTYPE_p_SimTK__SubsystemIndex subsystemIndex, Model model) {
    opensimModelJNI.Actuator_initStateCache(swigCPtr, this, SWIGTYPE_p_SimTK__State.getCPtr(s), SWIGTYPE_p_SimTK__SubsystemIndex.getCPtr(subsystemIndex), Model.getCPtr(model), model);
  }

  public void setup(Model aModel) {
    opensimModelJNI.Actuator_setup(swigCPtr, this, Model.getCPtr(aModel), aModel);
  }

  public void setModel(Model aModel) {
    opensimModelJNI.Actuator_setModel(swigCPtr, this, Model.getCPtr(aModel), aModel);
  }

  public Model getModel() {
    return new Model(opensimModelJNI.Actuator_getModel(swigCPtr, this), false);
  }

  public int getControlIndex() {
    return opensimModelJNI.Actuator_getControlIndex(swigCPtr, this);
  }

  public void setControlIndex(int index) {
    opensimModelJNI.Actuator_setControlIndex(swigCPtr, this, index);
  }

  public void setController(Controller arg0) {
    opensimModelJNI.Actuator_setController(swigCPtr, this, Controller.getCPtr(arg0), arg0);
  }

  public Controller getController() {
    return new Controller(opensimModelJNI.Actuator_getController(swigCPtr, this), false);
  }

  public double getControl(SWIGTYPE_p_SimTK__State s) {
    return opensimModelJNI.Actuator_getControl(swigCPtr, this, SWIGTYPE_p_SimTK__State.getCPtr(s));
  }

  public String getStateVariableName(int aIndex) {
    return opensimModelJNI.Actuator_getStateVariableName(swigCPtr, this, aIndex);
  }

  public int getStateVariableIndex(String aName) {
    return opensimModelJNI.Actuator_getStateVariableIndex(swigCPtr, this, aName);
  }

  public void setStateVariable(SWIGTYPE_p_SimTK__State s, int aIndex, double aValue) {
    opensimModelJNI.Actuator_setStateVariable(swigCPtr, this, SWIGTYPE_p_SimTK__State.getCPtr(s), aIndex, aValue);
  }

  public void setStateVariables(SWIGTYPE_p_SimTK__State s, double[] aY) {
    opensimModelJNI.Actuator_setStateVariables(swigCPtr, this, SWIGTYPE_p_SimTK__State.getCPtr(s), aY);
  }

  public double getStateVariable(SWIGTYPE_p_SimTK__State s, int aIndex) {
    return opensimModelJNI.Actuator_getStateVariable(swigCPtr, this, SWIGTYPE_p_SimTK__State.getCPtr(s), aIndex);
  }

  public void getStateVariables(SWIGTYPE_p_SimTK__State s, double[] rY) {
    opensimModelJNI.Actuator_getStateVariables(swigCPtr, this, SWIGTYPE_p_SimTK__State.getCPtr(s), rY);
  }

  public int getNumStateVariables() {
    return opensimModelJNI.Actuator_getNumStateVariables(swigCPtr, this);
  }

  public void setStateVariableDeriv(SWIGTYPE_p_SimTK__State s, int aIndex, double aValue) {
    opensimModelJNI.Actuator_setStateVariableDeriv(swigCPtr, this, SWIGTYPE_p_SimTK__State.getCPtr(s), aIndex, aValue);
  }

  public void setStateVariableDerivs(SWIGTYPE_p_SimTK__State s, double[] aY) {
    opensimModelJNI.Actuator_setStateVariableDerivs(swigCPtr, this, SWIGTYPE_p_SimTK__State.getCPtr(s), aY);
  }

  public double getStateVariableDeriv(SWIGTYPE_p_SimTK__State s, int aIndex) {
    return opensimModelJNI.Actuator_getStateVariableDeriv(swigCPtr, this, SWIGTYPE_p_SimTK__State.getCPtr(s), aIndex);
  }

  public void getStateVariableDerivs(SWIGTYPE_p_SimTK__State s, double[] rY) {
    opensimModelJNI.Actuator_getStateVariableDerivs(swigCPtr, this, SWIGTYPE_p_SimTK__State.getCPtr(s), rY);
  }

  public void updateDisplayer(SWIGTYPE_p_SimTK__State s) {
    opensimModelJNI.Actuator_updateDisplayer(swigCPtr, this, SWIGTYPE_p_SimTK__State.getCPtr(s));
  }

  public void replacePropertyFunction(Function aOldFunction, Function aNewFunction) {
    opensimModelJNI.Actuator_replacePropertyFunction(swigCPtr, this, Function.getCPtr(aOldFunction), aOldFunction, Function.getCPtr(aNewFunction), aNewFunction);
  }

  public static boolean isKindOf(String type) {
    return opensimModelJNI.Actuator_isKindOf(type);
  }

  public boolean isA(String type) {
    return opensimModelJNI.Actuator_isA(swigCPtr, this, type);
  }

  public static Actuator safeDownCast(OpenSimObject obj) {
    long cPtr = opensimModelJNI.Actuator_safeDownCast(OpenSimObject.getCPtr(obj), obj);
    return (cPtr == 0) ? null : new Actuator(cPtr, false);
  }

  public void copy(OpenSimObject aObject) {
    opensimModelJNI.Actuator_copy__SWIG_1(swigCPtr, this, OpenSimObject.getCPtr(aObject), aObject);
  }

  public boolean getAppliesForce() {
    return opensimModelJNI.Actuator_getAppliesForce(swigCPtr, this);
  }

  public void setForce(SWIGTYPE_p_SimTK__State s, double aForce) {
    opensimModelJNI.Actuator_setForce(swigCPtr, this, SWIGTYPE_p_SimTK__State.getCPtr(s), aForce);
  }

  public double getForce(SWIGTYPE_p_SimTK__State s) {
    return opensimModelJNI.Actuator_getForce(swigCPtr, this, SWIGTYPE_p_SimTK__State.getCPtr(s));
  }

  public double getAppliedForce(SWIGTYPE_p_SimTK__State s) {
    return opensimModelJNI.Actuator_getAppliedForce(swigCPtr, this, SWIGTYPE_p_SimTK__State.getCPtr(s));
  }

  public void setSpeed(SWIGTYPE_p_SimTK__State s, double aspeed) {
    opensimModelJNI.Actuator_setSpeed(swigCPtr, this, SWIGTYPE_p_SimTK__State.getCPtr(s), aspeed);
  }

  public double getSpeed(SWIGTYPE_p_SimTK__State s) {
    return opensimModelJNI.Actuator_getSpeed(swigCPtr, this, SWIGTYPE_p_SimTK__State.getCPtr(s));
  }

  public double getPower(SWIGTYPE_p_SimTK__State s) {
    return opensimModelJNI.Actuator_getPower(swigCPtr, this, SWIGTYPE_p_SimTK__State.getCPtr(s));
  }

  public double getStress(SWIGTYPE_p_SimTK__State s) {
    return opensimModelJNI.Actuator_getStress(swigCPtr, this, SWIGTYPE_p_SimTK__State.getCPtr(s));
  }

  public double getOptimalForce() {
    return opensimModelJNI.Actuator_getOptimalForce(swigCPtr, this);
  }

  public void setIsControlled(boolean flag) {
    opensimModelJNI.Actuator_setIsControlled(swigCPtr, this, flag);
  }

  public boolean isControlled() {
    return opensimModelJNI.Actuator_isControlled(swigCPtr, this);
  }

  public void promoteControlsToStates(SWIGTYPE_p_SimTK__State s, int index) {
    opensimModelJNI.Actuator_promoteControlsToStates(swigCPtr, this, SWIGTYPE_p_SimTK__State.getCPtr(s), index);
  }

  public double computeActuation(SWIGTYPE_p_SimTK__State s) {
    return opensimModelJNI.Actuator_computeActuation(swigCPtr, this, SWIGTYPE_p_SimTK__State.getCPtr(s));
  }

  public void computeStateDerivatives(SWIGTYPE_p_SimTK__State s) {
    opensimModelJNI.Actuator_computeStateDerivatives(swigCPtr, this, SWIGTYPE_p_SimTK__State.getCPtr(s));
  }

  public void computeEquilibrium(SWIGTYPE_p_SimTK__State s) {
    opensimModelJNI.Actuator_computeEquilibrium(swigCPtr, this, SWIGTYPE_p_SimTK__State.getCPtr(s));
  }

  public boolean check() {
    return opensimModelJNI.Actuator_check(swigCPtr, this);
  }

  public void preScale(SWIGTYPE_p_SimTK__State s, ScaleSet aScaleSet) {
    opensimModelJNI.Actuator_preScale(swigCPtr, this, SWIGTYPE_p_SimTK__State.getCPtr(s), ScaleSet.getCPtr(aScaleSet), aScaleSet);
  }

  public void scale(SWIGTYPE_p_SimTK__State s, ScaleSet aScaleSet) {
    opensimModelJNI.Actuator_scale(swigCPtr, this, SWIGTYPE_p_SimTK__State.getCPtr(s), ScaleSet.getCPtr(aScaleSet), aScaleSet);
  }

  public void postScale(SWIGTYPE_p_SimTK__State s, ScaleSet aScaleSet) {
    opensimModelJNI.Actuator_postScale(swigCPtr, this, SWIGTYPE_p_SimTK__State.getCPtr(s), ScaleSet.getCPtr(aScaleSet), aScaleSet);
  }

  public int getNumControls() {
    return opensimModelJNI.Actuator_getNumControls(swigCPtr, this);
  }

}
