/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.29
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.opensim.modeling;

public class Scale extends OpenSimObject {
  private long swigCPtr;

  protected Scale(long cPtr, boolean cMemoryOwn) {
    super(opensimModelJNI.SWIGScaleUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  protected static long getCPtr(Scale obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public void delete() {
    if(swigCPtr != 0 && swigCMemOwn) {
      swigCMemOwn = false;
      opensimModelJNI.delete_Scale(swigCPtr);
    }
    swigCPtr = 0;
    super.delete();
  }

  public Scale() {
    this(opensimModelJNI.new_Scale__SWIG_0(), true);
  }

  public Scale(Scale aMarker) {
    this(opensimModelJNI.new_Scale__SWIG_1(Scale.getCPtr(aMarker)), true);
  }

  public Scale(SWIGTYPE_p_DOMElement aElement) {
    this(opensimModelJNI.new_Scale__SWIG_2(SWIGTYPE_p_DOMElement.getCPtr(aElement)), true);
  }

  public Scale(String scaleFileName) {
    this(opensimModelJNI.new_Scale__SWIG_3(scaleFileName), true);
  }

  public OpenSimObject copy(SWIGTYPE_p_DOMElement aElement) {
    long cPtr = opensimModelJNI.Scale_copy__SWIG_0(swigCPtr, SWIGTYPE_p_DOMElement.getCPtr(aElement));
    return (cPtr == 0) ? null : new OpenSimObject(cPtr, false);
  }

  public OpenSimObject copy() {
    long cPtr = opensimModelJNI.Scale_copy__SWIG_1(swigCPtr);
    return (cPtr == 0) ? null : new OpenSimObject(cPtr, false);
  }

  public void getScaleFactors(ArrayDouble aScaleFactors) {
    opensimModelJNI.Scale_getScaleFactors(swigCPtr, ArrayDouble.getCPtr(aScaleFactors));
  }

  public String getSegmentName() {
    return opensimModelJNI.Scale_getSegmentName(swigCPtr);
  }

  public void setSegmentName(String aSegmentName) {
    opensimModelJNI.Scale_setSegmentName(swigCPtr, aSegmentName);
  }

  public void setScaleFactors(ArrayDouble aScaleFactors) {
    opensimModelJNI.Scale_setScaleFactors(swigCPtr, ArrayDouble.getCPtr(aScaleFactors));
  }

  public boolean getApply() {
    return opensimModelJNI.Scale_getApply(swigCPtr);
  }

  public void setApply(boolean state) {
    opensimModelJNI.Scale_setApply(swigCPtr, state);
  }

}
