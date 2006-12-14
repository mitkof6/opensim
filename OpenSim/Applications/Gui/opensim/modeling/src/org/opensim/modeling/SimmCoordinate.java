/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.29
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.opensim.modeling;

public class SimmCoordinate extends AbstractCoordinate {
  private long swigCPtr;

  public SimmCoordinate(long cPtr, boolean cMemoryOwn) {
    super(opensimModelJNI.SWIGStorageUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  public static long getCPtr(SimmCoordinate obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public void delete() {
    if(swigCPtr != 0 && swigCMemOwn) {
      swigCMemOwn = false;
      opensimModelJNI.delete_SimmCoordinate(swigCPtr);
    }
    swigCPtr = 0;
    super.delete();
  }

  public SimmCoordinate() {
    this(opensimModelJNI.new_SimmCoordinate__SWIG_0(), true);
  }

  public SimmCoordinate(SWIGTYPE_p_DOMElement aElement) {
    this(opensimModelJNI.new_SimmCoordinate__SWIG_1(SWIGTYPE_p_DOMElement.getCPtr(aElement)), true);
  }

  public SimmCoordinate(SimmCoordinate aCoordinate) {
    this(opensimModelJNI.new_SimmCoordinate__SWIG_2(SimmCoordinate.getCPtr(aCoordinate)), true);
  }

  public OpenSimObject copy() {
    long cPtr = opensimModelJNI.SimmCoordinate_copy__SWIG_0(swigCPtr);
    return (cPtr == 0) ? null : new OpenSimObject(cPtr, false);
  }

  public OpenSimObject copy(SWIGTYPE_p_DOMElement aElement) {
    long cPtr = opensimModelJNI.SimmCoordinate_copy__SWIG_1(swigCPtr, SWIGTYPE_p_DOMElement.getCPtr(aElement));
    return (cPtr == 0) ? null : new OpenSimObject(cPtr, false);
  }

  public void copyData(SimmCoordinate aCoordinate) {
    opensimModelJNI.SimmCoordinate_copyData(swigCPtr, SimmCoordinate.getCPtr(aCoordinate));
  }

  public void setup(AbstractDynamicsEngine aEngine) {
    opensimModelJNI.SimmCoordinate_setup(swigCPtr, AbstractDynamicsEngine.getCPtr(aEngine));
  }

  public void updateFromCoordinate(AbstractCoordinate aCoordinate) {
    opensimModelJNI.SimmCoordinate_updateFromCoordinate(swigCPtr, AbstractCoordinate.getCPtr(aCoordinate));
  }

  public double getValue() {
    return opensimModelJNI.SimmCoordinate_getValue(swigCPtr);
  }

  public boolean setValue(double aValue) {
    return opensimModelJNI.SimmCoordinate_setValue(swigCPtr, aValue);
  }

  public boolean getValueUseDefault() {
    return opensimModelJNI.SimmCoordinate_getValueUseDefault(swigCPtr);
  }

  public void getRange(double[] rRange) {
    opensimModelJNI.SimmCoordinate_getRange(swigCPtr, rRange);
  }

  public boolean setRange(double[] aRange) {
    return opensimModelJNI.SimmCoordinate_setRange(swigCPtr, aRange);
  }

  public double getRangeMin() {
    return opensimModelJNI.SimmCoordinate_getRangeMin(swigCPtr);
  }

  public double getRangeMax() {
    return opensimModelJNI.SimmCoordinate_getRangeMax(swigCPtr);
  }

  public boolean setRangeMin(double aMin) {
    return opensimModelJNI.SimmCoordinate_setRangeMin(swigCPtr, aMin);
  }

  public boolean setRangeMax(double aMax) {
    return opensimModelJNI.SimmCoordinate_setRangeMax(swigCPtr, aMax);
  }

  public boolean getRangeUseDefault() {
    return opensimModelJNI.SimmCoordinate_getRangeUseDefault(swigCPtr);
  }

  public double getTolerance() {
    return opensimModelJNI.SimmCoordinate_getTolerance(swigCPtr);
  }

  public boolean setTolerance(double aTolerance) {
    return opensimModelJNI.SimmCoordinate_setTolerance(swigCPtr, aTolerance);
  }

  public boolean getToleranceUseDefault() {
    return opensimModelJNI.SimmCoordinate_getToleranceUseDefault(swigCPtr);
  }

  public double getWeight() {
    return opensimModelJNI.SimmCoordinate_getWeight(swigCPtr);
  }

  public boolean setWeight(double aWeight) {
    return opensimModelJNI.SimmCoordinate_setWeight(swigCPtr, aWeight);
  }

  public boolean getWeightUseDefault() {
    return opensimModelJNI.SimmCoordinate_getWeightUseDefault(swigCPtr);
  }

  public double getStiffness() {
    return opensimModelJNI.SimmCoordinate_getStiffness(swigCPtr);
  }

  public boolean setStiffness(double aStiffness) {
    return opensimModelJNI.SimmCoordinate_setStiffness(swigCPtr, aStiffness);
  }

  public boolean getStiffnessUseDefault() {
    return opensimModelJNI.SimmCoordinate_getStiffnessUseDefault(swigCPtr);
  }

  public double getDefaultValue() {
    return opensimModelJNI.SimmCoordinate_getDefaultValue(swigCPtr);
  }

  public boolean setDefaultValue(double aDefaultValue) {
    return opensimModelJNI.SimmCoordinate_setDefaultValue(swigCPtr, aDefaultValue);
  }

  public boolean getDefaultValueUseDefault() {
    return opensimModelJNI.SimmCoordinate_getDefaultValueUseDefault(swigCPtr);
  }

  public boolean getClamped() {
    return opensimModelJNI.SimmCoordinate_getClamped(swigCPtr);
  }

  public boolean setClamped(boolean aClamped) {
    return opensimModelJNI.SimmCoordinate_setClamped(swigCPtr, aClamped);
  }

  public boolean getClampedUseDefault() {
    return opensimModelJNI.SimmCoordinate_getClampedUseDefault(swigCPtr);
  }

  public boolean getLocked() {
    return opensimModelJNI.SimmCoordinate_getLocked(swigCPtr);
  }

  public boolean setLocked(boolean aLocked) {
    return opensimModelJNI.SimmCoordinate_setLocked(swigCPtr, aLocked);
  }

  public boolean getLockedUseDefault() {
    return opensimModelJNI.SimmCoordinate_getLockedUseDefault(swigCPtr);
  }

  public void addJointToList(AbstractJoint aJoint) {
    opensimModelJNI.SimmCoordinate_addJointToList(swigCPtr, AbstractJoint.getCPtr(aJoint));
  }

  public void addPathToList(SWIGTYPE_p_OpenSim__SimmPath aPath) {
    opensimModelJNI.SimmCoordinate_addPathToList(swigCPtr, SWIGTYPE_p_OpenSim__SimmPath.getCPtr(aPath));
  }

  public boolean isUsedInModel() {
    return opensimModelJNI.SimmCoordinate_isUsedInModel(swigCPtr);
  }

  public boolean isRestraintActive() {
    return opensimModelJNI.SimmCoordinate_isRestraintActive(swigCPtr);
  }

  public Function getRestraintFunction() {
    long cPtr = opensimModelJNI.SimmCoordinate_getRestraintFunction(swigCPtr);
    return (cPtr == 0) ? null : new Function(cPtr, false);
  }

  public Function getMinRestraintFunction() {
    long cPtr = opensimModelJNI.SimmCoordinate_getMinRestraintFunction(swigCPtr);
    return (cPtr == 0) ? null : new Function(cPtr, false);
  }

  public Function getMaxRestraintFunction() {
    long cPtr = opensimModelJNI.SimmCoordinate_getMaxRestraintFunction(swigCPtr);
    return (cPtr == 0) ? null : new Function(cPtr, false);
  }

  public AbstractDof.DofType getMotionType() {
    return AbstractDof.DofType.swigToEnum(opensimModelJNI.SimmCoordinate_getMotionType(swigCPtr));
  }

  public void getKeys(SWIGTYPE_p_std__string rKeys) {
    opensimModelJNI.SimmCoordinate_getKeys__SWIG_0(swigCPtr, SWIGTYPE_p_std__string.getCPtr(rKeys));
  }

  public ArrayStr getKeys() {
    return new ArrayStr(opensimModelJNI.SimmCoordinate_getKeys__SWIG_1(swigCPtr), false);
  }

  public SWIGTYPE_p_OpenSim__ArrayTOpenSim__AbstractJoint_p_t getJointList() {
    return new SWIGTYPE_p_OpenSim__ArrayTOpenSim__AbstractJoint_p_t(opensimModelJNI.SimmCoordinate_getJointList(swigCPtr), false);
  }

  public SWIGTYPE_p_OpenSim__ArrayTOpenSim__SimmPath_p_t getPathList() {
    return new SWIGTYPE_p_OpenSim__ArrayTOpenSim__SimmPath_p_t(opensimModelJNI.SimmCoordinate_getPathList(swigCPtr), false);
  }

  public void determineType() {
    opensimModelJNI.SimmCoordinate_determineType(swigCPtr);
  }

  public void peteTest() {
    opensimModelJNI.SimmCoordinate_peteTest(swigCPtr);
  }

}
