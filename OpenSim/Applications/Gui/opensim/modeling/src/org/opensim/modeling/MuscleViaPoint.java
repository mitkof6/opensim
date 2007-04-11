/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.31
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.opensim.modeling;

public class MuscleViaPoint extends MusclePoint {
  private long swigCPtr;

  public MuscleViaPoint(long cPtr, boolean cMemoryOwn) {
    super(opensimModelJNI.SWIGStorageUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  public static long getCPtr(MuscleViaPoint obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if(swigCPtr != 0 && swigCMemOwn) {
      swigCMemOwn = false;
      opensimModelJNI.delete_MuscleViaPoint(swigCPtr);
    }
    swigCPtr = 0;
    super.delete();
  }

  public MuscleViaPoint() {
    this(opensimModelJNI.new_MuscleViaPoint__SWIG_0(), true);
  }

  public MuscleViaPoint(MuscleViaPoint aPoint) {
    this(opensimModelJNI.new_MuscleViaPoint__SWIG_1(MuscleViaPoint.getCPtr(aPoint), aPoint), true);
  }

  public OpenSimObject copy() {
    long cPtr = opensimModelJNI.MuscleViaPoint_copy(swigCPtr, this);
    return (cPtr == 0) ? null : new OpenSimObject(cPtr, false);
  }

  public void copyData(MuscleViaPoint aPoint) {
    opensimModelJNI.MuscleViaPoint_copyData(swigCPtr, this, MuscleViaPoint.getCPtr(aPoint), aPoint);
  }

  public ArrayDouble getRange() {
    return new ArrayDouble(opensimModelJNI.MuscleViaPoint_getRange(swigCPtr, this), false);
  }

  public AbstractCoordinate getCoordinate() {
    long cPtr = opensimModelJNI.MuscleViaPoint_getCoordinate(swigCPtr, this);
    return (cPtr == 0) ? null : new AbstractCoordinate(cPtr, false);
  }

  public void setCoordinate(AbstractCoordinate aCoordinate) {
    opensimModelJNI.MuscleViaPoint_setCoordinate(swigCPtr, this, AbstractCoordinate.getCPtr(aCoordinate), aCoordinate);
  }

  public String getCoordinateName() {
    return opensimModelJNI.MuscleViaPoint_getCoordinateName(swigCPtr, this);
  }

  public void setRangeMin(double aMin) {
    opensimModelJNI.MuscleViaPoint_setRangeMin(swigCPtr, this, aMin);
  }

  public void setRangeMax(double aMax) {
    opensimModelJNI.MuscleViaPoint_setRangeMax(swigCPtr, this, aMax);
  }

  public boolean isActive() {
    return opensimModelJNI.MuscleViaPoint_isActive(swigCPtr, this);
  }

  public void setup(Model aModel, AbstractMuscle aMuscle) {
    opensimModelJNI.MuscleViaPoint_setup(swigCPtr, this, Model.getCPtr(aModel), aModel, AbstractMuscle.getCPtr(aMuscle), aMuscle);
  }

  public void peteTest() {
    opensimModelJNI.MuscleViaPoint_peteTest(swigCPtr, this);
  }

  public static boolean isKindOf(String type) {
    return opensimModelJNI.MuscleViaPoint_isKindOf(type);
  }

  public boolean isA(String type) {
    return opensimModelJNI.MuscleViaPoint_isA(swigCPtr, this, type);
  }

  public static MuscleViaPoint safeDownCast(OpenSimObject obj) {
    long cPtr = opensimModelJNI.MuscleViaPoint_safeDownCast(OpenSimObject.getCPtr(obj), obj);
    return (cPtr == 0) ? null : new MuscleViaPoint(cPtr, false);
  }

}
