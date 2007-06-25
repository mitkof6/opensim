/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.31
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

  public synchronized void delete() {
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

  public SimmCoordinate(SimmCoordinate aCoordinate) {
    this(opensimModelJNI.new_SimmCoordinate__SWIG_1(SimmCoordinate.getCPtr(aCoordinate), aCoordinate), true);
  }

  public OpenSimObject copy() {
    long cPtr = opensimModelJNI.SimmCoordinate_copy(swigCPtr, this);
    return (cPtr == 0) ? null : new OpenSimObject(cPtr, false);
  }

  public void copyData(SimmCoordinate aCoordinate) {
    opensimModelJNI.SimmCoordinate_copyData(swigCPtr, this, SimmCoordinate.getCPtr(aCoordinate), aCoordinate);
  }

  public void setup(AbstractDynamicsEngine aEngine) {
    opensimModelJNI.SimmCoordinate_setup(swigCPtr, this, AbstractDynamicsEngine.getCPtr(aEngine), aEngine);
  }

  public void updateFromCoordinate(AbstractCoordinate aCoordinate) {
    opensimModelJNI.SimmCoordinate_updateFromCoordinate(swigCPtr, this, AbstractCoordinate.getCPtr(aCoordinate), aCoordinate);
  }

  public double getValue() {
    return opensimModelJNI.SimmCoordinate_getValue(swigCPtr, this);
  }

  public boolean setValue(double aValue) {
    return opensimModelJNI.SimmCoordinate_setValue(swigCPtr, this, aValue);
  }

  public boolean getValueUseDefault() {
    return opensimModelJNI.SimmCoordinate_getValueUseDefault(swigCPtr, this);
  }

  public void getRange(double[] rRange) {
    opensimModelJNI.SimmCoordinate_getRange(swigCPtr, this, rRange);
  }

  public boolean setRange(double[] aRange) {
    return opensimModelJNI.SimmCoordinate_setRange(swigCPtr, this, aRange);
  }

  public double getRangeMin() {
    return opensimModelJNI.SimmCoordinate_getRangeMin(swigCPtr, this);
  }

  public double getRangeMax() {
    return opensimModelJNI.SimmCoordinate_getRangeMax(swigCPtr, this);
  }

  public boolean setRangeMin(double aMin) {
    return opensimModelJNI.SimmCoordinate_setRangeMin(swigCPtr, this, aMin);
  }

  public boolean setRangeMax(double aMax) {
    return opensimModelJNI.SimmCoordinate_setRangeMax(swigCPtr, this, aMax);
  }

  public boolean getRangeUseDefault() {
    return opensimModelJNI.SimmCoordinate_getRangeUseDefault(swigCPtr, this);
  }

  public double getTolerance() {
    return opensimModelJNI.SimmCoordinate_getTolerance(swigCPtr, this);
  }

  public boolean setTolerance(double aTolerance) {
    return opensimModelJNI.SimmCoordinate_setTolerance(swigCPtr, this, aTolerance);
  }

  public boolean getToleranceUseDefault() {
    return opensimModelJNI.SimmCoordinate_getToleranceUseDefault(swigCPtr, this);
  }

  public double getStiffness() {
    return opensimModelJNI.SimmCoordinate_getStiffness(swigCPtr, this);
  }

  public boolean setStiffness(double aStiffness) {
    return opensimModelJNI.SimmCoordinate_setStiffness(swigCPtr, this, aStiffness);
  }

  public boolean getStiffnessUseDefault() {
    return opensimModelJNI.SimmCoordinate_getStiffnessUseDefault(swigCPtr, this);
  }

  public double getDefaultValue() {
    return opensimModelJNI.SimmCoordinate_getDefaultValue(swigCPtr, this);
  }

  public boolean setDefaultValue(double aDefaultValue) {
    return opensimModelJNI.SimmCoordinate_setDefaultValue(swigCPtr, this, aDefaultValue);
  }

  public boolean getDefaultValueUseDefault() {
    return opensimModelJNI.SimmCoordinate_getDefaultValueUseDefault(swigCPtr, this);
  }

  public boolean getClamped() {
    return opensimModelJNI.SimmCoordinate_getClamped(swigCPtr, this);
  }

  public boolean setClamped(boolean aClamped) {
    return opensimModelJNI.SimmCoordinate_setClamped(swigCPtr, this, aClamped);
  }

  public boolean getClampedUseDefault() {
    return opensimModelJNI.SimmCoordinate_getClampedUseDefault(swigCPtr, this);
  }

  public boolean getLocked() {
    return opensimModelJNI.SimmCoordinate_getLocked(swigCPtr, this);
  }

  public boolean setLocked(boolean aLocked) {
    return opensimModelJNI.SimmCoordinate_setLocked(swigCPtr, this, aLocked);
  }

  public boolean getLockedUseDefault() {
    return opensimModelJNI.SimmCoordinate_getLockedUseDefault(swigCPtr, this);
  }

  public void addJointToList(AbstractJoint aJoint) {
    opensimModelJNI.SimmCoordinate_addJointToList(swigCPtr, this, AbstractJoint.getCPtr(aJoint), aJoint);
  }

  public void addPathToList(SWIGTYPE_p_OpenSim__SimmPath aPath) {
    opensimModelJNI.SimmCoordinate_addPathToList(swigCPtr, this, SWIGTYPE_p_OpenSim__SimmPath.getCPtr(aPath));
  }

  public boolean isUsedInModel() {
    return opensimModelJNI.SimmCoordinate_isUsedInModel(swigCPtr, this);
  }

  public boolean isRestraintActive() {
    return opensimModelJNI.SimmCoordinate_isRestraintActive(swigCPtr, this);
  }

  public Function getRestraintFunction() {
    long cPtr = opensimModelJNI.SimmCoordinate_getRestraintFunction(swigCPtr, this);
    return (cPtr == 0) ? null : new Function(cPtr, false);
  }

  public Function getMinRestraintFunction() {
    long cPtr = opensimModelJNI.SimmCoordinate_getMinRestraintFunction(swigCPtr, this);
    return (cPtr == 0) ? null : new Function(cPtr, false);
  }

  public Function getMaxRestraintFunction() {
    long cPtr = opensimModelJNI.SimmCoordinate_getMaxRestraintFunction(swigCPtr, this);
    return (cPtr == 0) ? null : new Function(cPtr, false);
  }

  public AbstractDof.DofType getMotionType() {
    return AbstractDof.DofType.swigToEnum(opensimModelJNI.SimmCoordinate_getMotionType(swigCPtr, this));
  }

  public void getKeys(SWIGTYPE_p_std__string rKeys) {
    opensimModelJNI.SimmCoordinate_getKeys__SWIG_0(swigCPtr, this, SWIGTYPE_p_std__string.getCPtr(rKeys));
  }

  public ArrayStr getKeys() {
    return new ArrayStr(opensimModelJNI.SimmCoordinate_getKeys__SWIG_1(swigCPtr, this), false);
  }

  public SWIGTYPE_p_OpenSim__ArrayTOpenSim__AbstractJoint_p_t getJointList() {
    return new SWIGTYPE_p_OpenSim__ArrayTOpenSim__AbstractJoint_p_t(opensimModelJNI.SimmCoordinate_getJointList(swigCPtr, this), false);
  }

  public SWIGTYPE_p_OpenSim__ArrayTOpenSim__SimmPath_p_t getPathList() {
    return new SWIGTYPE_p_OpenSim__ArrayTOpenSim__SimmPath_p_t(opensimModelJNI.SimmCoordinate_getPathList(swigCPtr, this), false);
  }

  public void determineType() {
    opensimModelJNI.SimmCoordinate_determineType(swigCPtr, this);
  }

}
