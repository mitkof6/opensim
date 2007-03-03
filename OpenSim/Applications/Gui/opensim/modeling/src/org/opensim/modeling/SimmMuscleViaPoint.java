/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.31
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.opensim.modeling;

public class SimmMuscleViaPoint extends SimmMusclePoint {
  private long swigCPtr;

  public SimmMuscleViaPoint(long cPtr, boolean cMemoryOwn) {
    super(opensimModelJNI.SWIGStorageUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  public static long getCPtr(SimmMuscleViaPoint obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if(swigCPtr != 0 && swigCMemOwn) {
      swigCMemOwn = false;
      opensimModelJNI.delete_SimmMuscleViaPoint(swigCPtr);
    }
    swigCPtr = 0;
    super.delete();
  }

  public SimmMuscleViaPoint() {
    this(opensimModelJNI.new_SimmMuscleViaPoint__SWIG_0(), true);
  }

  public SimmMuscleViaPoint(SimmMuscleViaPoint aPoint) {
    this(opensimModelJNI.new_SimmMuscleViaPoint__SWIG_1(SimmMuscleViaPoint.getCPtr(aPoint), aPoint), true);
  }

  public OpenSimObject copy() {
    long cPtr = opensimModelJNI.SimmMuscleViaPoint_copy(swigCPtr, this);
    return (cPtr == 0) ? null : new OpenSimObject(cPtr, false);
  }

  public void copyData(SimmMuscleViaPoint aPoint) {
    opensimModelJNI.SimmMuscleViaPoint_copyData(swigCPtr, this, SimmMuscleViaPoint.getCPtr(aPoint), aPoint);
  }

  public ArrayDouble getRange() {
    return new ArrayDouble(opensimModelJNI.SimmMuscleViaPoint_getRange(swigCPtr, this), false);
  }

  public AbstractCoordinate getCoordinate() {
    long cPtr = opensimModelJNI.SimmMuscleViaPoint_getCoordinate(swigCPtr, this);
    return (cPtr == 0) ? null : new AbstractCoordinate(cPtr, false);
  }

  public SWIGTYPE_p_std__string getCoordinateName() {
    return new SWIGTYPE_p_std__string(opensimModelJNI.SimmMuscleViaPoint_getCoordinateName(swigCPtr, this), false);
  }

  public boolean isActive() {
    return opensimModelJNI.SimmMuscleViaPoint_isActive(swigCPtr, this);
  }

  public void setup(AbstractModel aModel, AbstractSimmMuscle aMuscle) {
    opensimModelJNI.SimmMuscleViaPoint_setup(swigCPtr, this, AbstractModel.getCPtr(aModel), aModel, AbstractSimmMuscle.getCPtr(aMuscle), aMuscle);
  }

  public void peteTest() {
    opensimModelJNI.SimmMuscleViaPoint_peteTest(swigCPtr, this);
  }

}
