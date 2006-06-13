/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.29
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.opensim.modeling;

public class SimmMuscleViaPoint extends SimmMusclePoint {
  private long swigCPtr;

  protected SimmMuscleViaPoint(long cPtr, boolean cMemoryOwn) {
    super(opensimModelJNI.SWIGSimmMuscleViaPointUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  protected static long getCPtr(SimmMuscleViaPoint obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public void delete() {
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

  public SimmMuscleViaPoint(SWIGTYPE_p_DOMElement aElement) {
    this(opensimModelJNI.new_SimmMuscleViaPoint__SWIG_1(SWIGTYPE_p_DOMElement.getCPtr(aElement)), true);
  }

  public SimmMuscleViaPoint(SimmMuscleViaPoint aPoint) {
    this(opensimModelJNI.new_SimmMuscleViaPoint__SWIG_2(SimmMuscleViaPoint.getCPtr(aPoint)), true);
  }

  public OpenSimObject copy() {
    long cPtr = opensimModelJNI.SimmMuscleViaPoint_copy__SWIG_0(swigCPtr);
    return (cPtr == 0) ? null : new OpenSimObject(cPtr, false);
  }

  public OpenSimObject copy(SWIGTYPE_p_DOMElement aElement) {
    long cPtr = opensimModelJNI.SimmMuscleViaPoint_copy__SWIG_1(swigCPtr, SWIGTYPE_p_DOMElement.getCPtr(aElement));
    return (cPtr == 0) ? null : new OpenSimObject(cPtr, false);
  }

  public void copyData(SimmMuscleViaPoint aPoint) {
    opensimModelJNI.SimmMuscleViaPoint_copyData(swigCPtr, SimmMuscleViaPoint.getCPtr(aPoint));
  }

  public ArrayDouble getRange() {
    return new ArrayDouble(opensimModelJNI.SimmMuscleViaPoint_getRange(swigCPtr), false);
  }

  public SWIGTYPE_p_std__string getCoordinateName() {
    return new SWIGTYPE_p_std__string(opensimModelJNI.SimmMuscleViaPoint_getCoordinateName(swigCPtr), false);
  }

  public void writeSIMM(SWIGTYPE_p_std__ofstream out) {
    opensimModelJNI.SimmMuscleViaPoint_writeSIMM(swigCPtr, SWIGTYPE_p_std__ofstream.getCPtr(out));
  }

  public void setup(SimmModel model, SimmKinematicsEngine ke) {
    opensimModelJNI.SimmMuscleViaPoint_setup(swigCPtr, SimmModel.getCPtr(model), SimmKinematicsEngine.getCPtr(ke));
  }

  public void peteTest() {
    opensimModelJNI.SimmMuscleViaPoint_peteTest(swigCPtr);
  }

}
