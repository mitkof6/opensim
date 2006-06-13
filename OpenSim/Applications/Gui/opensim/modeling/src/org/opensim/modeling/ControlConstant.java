/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.29
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.opensim.modeling;

public class ControlConstant extends Control {
  private long swigCPtr;

  protected ControlConstant(long cPtr, boolean cMemoryOwn) {
    super(opensimModelJNI.SWIGControlConstantUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  protected static long getCPtr(ControlConstant obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public void delete() {
    if(swigCPtr != 0 && swigCMemOwn) {
      swigCMemOwn = false;
      opensimModelJNI.delete_ControlConstant(swigCPtr);
    }
    swigCPtr = 0;
    super.delete();
  }

  public ControlConstant(double aX, String aName) {
    this(opensimModelJNI.new_ControlConstant__SWIG_0(aX, aName), true);
  }

  public ControlConstant(double aX) {
    this(opensimModelJNI.new_ControlConstant__SWIG_1(aX), true);
  }

  public ControlConstant() {
    this(opensimModelJNI.new_ControlConstant__SWIG_2(), true);
  }

  public ControlConstant(SWIGTYPE_p_DOMElement aElement) {
    this(opensimModelJNI.new_ControlConstant__SWIG_3(SWIGTYPE_p_DOMElement.getCPtr(aElement)), true);
  }

  public ControlConstant(ControlConstant aControl) {
    this(opensimModelJNI.new_ControlConstant__SWIG_4(ControlConstant.getCPtr(aControl)), true);
  }

  public OpenSimObject copy() {
    long cPtr = opensimModelJNI.ControlConstant_copy__SWIG_0(swigCPtr);
    return (cPtr == 0) ? null : new OpenSimObject(cPtr, false);
  }

  public OpenSimObject copy(SWIGTYPE_p_DOMElement aElement) {
    long cPtr = opensimModelJNI.ControlConstant_copy__SWIG_1(swigCPtr, SWIGTYPE_p_DOMElement.getCPtr(aElement));
    return (cPtr == 0) ? null : new OpenSimObject(cPtr, false);
  }

  public int getNumParameters() {
    return opensimModelJNI.ControlConstant_getNumParameters(swigCPtr);
  }

  public void setParameterMin(int aI, double aMin) {
    opensimModelJNI.ControlConstant_setParameterMin(swigCPtr, aI, aMin);
  }

  public double getParameterMin(int aI) {
    return opensimModelJNI.ControlConstant_getParameterMin(swigCPtr, aI);
  }

  public void setParameterMax(int aI, double aMax) {
    opensimModelJNI.ControlConstant_setParameterMax(swigCPtr, aI, aMax);
  }

  public double getParameterMax(int aI) {
    return opensimModelJNI.ControlConstant_getParameterMax(swigCPtr, aI);
  }

  public double getParameterTime(int aI) {
    return opensimModelJNI.ControlConstant_getParameterTime(swigCPtr, aI);
  }

  public void getParameterNeighborhood(int aI, SWIGTYPE_p_double rTLower, SWIGTYPE_p_double rTUpper) {
    opensimModelJNI.ControlConstant_getParameterNeighborhood(swigCPtr, aI, SWIGTYPE_p_double.getCPtr(rTLower), SWIGTYPE_p_double.getCPtr(rTUpper));
  }

  public int getParameterList(double aT, ArrayInt rList) {
    return opensimModelJNI.ControlConstant_getParameterList__SWIG_0(swigCPtr, aT, ArrayInt.getCPtr(rList));
  }

  public int getParameterList(double aT1, double aT2, ArrayInt rList) {
    return opensimModelJNI.ControlConstant_getParameterList__SWIG_1(swigCPtr, aT1, aT2, ArrayInt.getCPtr(rList));
  }

  public void setParameterValue(int aI, double aP) {
    opensimModelJNI.ControlConstant_setParameterValue(swigCPtr, aI, aP);
  }

  public double getParameterValue(int aI) {
    return opensimModelJNI.ControlConstant_getParameterValue(swigCPtr, aI);
  }

  public void setControlValue(double aT, double aX) {
    opensimModelJNI.ControlConstant_setControlValue(swigCPtr, aT, aX);
  }

  public double getControlValue(double aT) {
    return opensimModelJNI.ControlConstant_getControlValue(swigCPtr, aT);
  }

  public double getControlValueMin(double aT) {
    return opensimModelJNI.ControlConstant_getControlValueMin__SWIG_0(swigCPtr, aT);
  }

  public double getControlValueMin() {
    return opensimModelJNI.ControlConstant_getControlValueMin__SWIG_1(swigCPtr);
  }

  public void setControlValueMin(double aT, double aX) {
    opensimModelJNI.ControlConstant_setControlValueMin(swigCPtr, aT, aX);
  }

  public double getControlValueMax(double aT) {
    return opensimModelJNI.ControlConstant_getControlValueMax__SWIG_0(swigCPtr, aT);
  }

  public double getControlValueMax() {
    return opensimModelJNI.ControlConstant_getControlValueMax__SWIG_1(swigCPtr);
  }

  public void setControlValueMax(double aT, double aX) {
    opensimModelJNI.ControlConstant_setControlValueMax(swigCPtr, aT, aX);
  }

  public static boolean isA(Control p) {
    return opensimModelJNI.ControlConstant_isA(Control.getCPtr(p));
  }

  public static ControlConstant downcast(Control p) {
    return new ControlConstant(opensimModelJNI.ControlConstant_downcast__SWIG_0(Control.getCPtr(p)), false);
  }

}
