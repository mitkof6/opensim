/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.29
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.opensim.modeling;

public class SimmMarker extends OpenSimObject {
  private long swigCPtr;

  public SimmMarker(long cPtr, boolean cMemoryOwn) {
    super(opensimModelJNI.SWIGStorageUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  public static long getCPtr(SimmMarker obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public void delete() {
    if(swigCPtr != 0 && swigCMemOwn) {
      swigCMemOwn = false;
      opensimModelJNI.delete_SimmMarker(swigCPtr);
    }
    swigCPtr = 0;
    super.delete();
  }

  public SimmMarker() {
    this(opensimModelJNI.new_SimmMarker__SWIG_0(), true);
  }

  public SimmMarker(SWIGTYPE_p_DOMElement aElement) {
    this(opensimModelJNI.new_SimmMarker__SWIG_1(SWIGTYPE_p_DOMElement.getCPtr(aElement)), true);
  }

  public SimmMarker(SimmMarker aMarker) {
    this(opensimModelJNI.new_SimmMarker__SWIG_2(SimmMarker.getCPtr(aMarker)), true);
  }

  public OpenSimObject copy() {
    long cPtr = opensimModelJNI.SimmMarker_copy__SWIG_0(swigCPtr);
    return (cPtr == 0) ? null : new OpenSimObject(cPtr, false);
  }

  public OpenSimObject copy(SWIGTYPE_p_DOMElement aElement) {
    long cPtr = opensimModelJNI.SimmMarker_copy__SWIG_1(swigCPtr, SWIGTYPE_p_DOMElement.getCPtr(aElement));
    return (cPtr == 0) ? null : new OpenSimObject(cPtr, false);
  }

  public void copyData(SimmMarker aMarker) {
    opensimModelJNI.SimmMarker_copyData(swigCPtr, SimmMarker.getCPtr(aMarker));
  }

  public void updateFromMarker(SimmMarker aMarker) {
    opensimModelJNI.SimmMarker_updateFromMarker(swigCPtr, SimmMarker.getCPtr(aMarker));
  }

  public void getOffset(SWIGTYPE_p_double aOffset) {
    opensimModelJNI.SimmMarker_getOffset__SWIG_0(swigCPtr, SWIGTYPE_p_double.getCPtr(aOffset));
  }

  public SWIGTYPE_p_double getOffset() {
    long cPtr = opensimModelJNI.SimmMarker_getOffset__SWIG_1(swigCPtr);
    return (cPtr == 0) ? null : new SWIGTYPE_p_double(cPtr, false);
  }

  public void setOffset(double[] pt) {
    opensimModelJNI.SimmMarker_setOffset(swigCPtr, pt);
  }

  public boolean getFixed() {
    return opensimModelJNI.SimmMarker_getFixed(swigCPtr);
  }

  public double getWeight() {
    return opensimModelJNI.SimmMarker_getWeight(swigCPtr);
  }

  public SWIGTYPE_p_std__string getBodyName() {
    long cPtr = opensimModelJNI.SimmMarker_getBodyName(swigCPtr);
    return (cPtr == 0) ? null : new SWIGTYPE_p_std__string(cPtr, false);
  }

  public void setup(SimmKinematicsEngine aEngine) {
    opensimModelJNI.SimmMarker_setup(swigCPtr, SimmKinematicsEngine.getCPtr(aEngine));
  }

  public void scale(ArrayDouble aScaleFactors) {
    opensimModelJNI.SimmMarker_scale(swigCPtr, ArrayDouble.getCPtr(aScaleFactors));
  }

  public void writeSIMM(SWIGTYPE_p_std__ofstream out) {
    opensimModelJNI.SimmMarker_writeSIMM(swigCPtr, SWIGTYPE_p_std__ofstream.getCPtr(out));
  }

  public void peteTest() {
    opensimModelJNI.SimmMarker_peteTest(swigCPtr);
  }

  public VisibleObject getDisplayer() {
    long cPtr = opensimModelJNI.SimmMarker_getDisplayer(swigCPtr);
    return (cPtr == 0) ? null : new VisibleObject(cPtr, false);
  }

}
