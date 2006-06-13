/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.29
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.opensim.modeling;

public class IntegCallback extends Callback {
  private long swigCPtr;

  protected IntegCallback(long cPtr, boolean cMemoryOwn) {
    super(opensimModelJNI.SWIGIntegCallbackUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  protected static long getCPtr(IntegCallback obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public void delete() {
    if(swigCPtr != 0 && swigCMemOwn) {
      swigCMemOwn = false;
      opensimModelJNI.delete_IntegCallback(swigCPtr);
    }
    swigCPtr = 0;
    super.delete();
  }

  public IntegCallback(Model aModel) {
    this(opensimModelJNI.new_IntegCallback__SWIG_0(Model.getCPtr(aModel)), true);
  }

  public IntegCallback() {
    this(opensimModelJNI.new_IntegCallback__SWIG_1(), true);
  }

  public IntegCallback(String aFileName) {
    this(opensimModelJNI.new_IntegCallback__SWIG_2(aFileName), true);
  }

  public IntegCallback(SWIGTYPE_p_DOMElement aElement) {
    this(opensimModelJNI.new_IntegCallback__SWIG_3(SWIGTYPE_p_DOMElement.getCPtr(aElement)), true);
  }

  public IntegCallback(IntegCallback aIntegCallback) {
    this(opensimModelJNI.new_IntegCallback__SWIG_4(IntegCallback.getCPtr(aIntegCallback)), true);
  }

  public OpenSimObject copy() {
    long cPtr = opensimModelJNI.IntegCallback_copy__SWIG_0(swigCPtr);
    return (cPtr == 0) ? null : new OpenSimObject(cPtr, false);
  }

  public OpenSimObject copy(SWIGTYPE_p_DOMElement aElement) {
    long cPtr = opensimModelJNI.IntegCallback_copy__SWIG_1(swigCPtr, SWIGTYPE_p_DOMElement.getCPtr(aElement));
    return (cPtr == 0) ? null : new OpenSimObject(cPtr, false);
  }

  public void setStepInterval(int aStepInterval) {
    opensimModelJNI.IntegCallback_setStepInterval(swigCPtr, aStepInterval);
  }

  public int getStepInterval() {
    return opensimModelJNI.IntegCallback_getStepInterval(swigCPtr);
  }

  public int begin(int aStep, double aDT, double aT, SWIGTYPE_p_double aX, SWIGTYPE_p_double aY, SWIGTYPE_p_void aClientData) {
    return opensimModelJNI.IntegCallback_begin__SWIG_0(swigCPtr, aStep, aDT, aT, SWIGTYPE_p_double.getCPtr(aX), SWIGTYPE_p_double.getCPtr(aY), SWIGTYPE_p_void.getCPtr(aClientData));
  }

  public int begin(int aStep, double aDT, double aT, SWIGTYPE_p_double aX, SWIGTYPE_p_double aY) {
    return opensimModelJNI.IntegCallback_begin__SWIG_1(swigCPtr, aStep, aDT, aT, SWIGTYPE_p_double.getCPtr(aX), SWIGTYPE_p_double.getCPtr(aY));
  }

  public int step(SWIGTYPE_p_double aXPrev, SWIGTYPE_p_double aYPrev, int aStep, double aDT, double aT, SWIGTYPE_p_double aX, SWIGTYPE_p_double aY, SWIGTYPE_p_void aClientData) {
    return opensimModelJNI.IntegCallback_step__SWIG_0(swigCPtr, SWIGTYPE_p_double.getCPtr(aXPrev), SWIGTYPE_p_double.getCPtr(aYPrev), aStep, aDT, aT, SWIGTYPE_p_double.getCPtr(aX), SWIGTYPE_p_double.getCPtr(aY), SWIGTYPE_p_void.getCPtr(aClientData));
  }

  public int step(SWIGTYPE_p_double aXPrev, SWIGTYPE_p_double aYPrev, int aStep, double aDT, double aT, SWIGTYPE_p_double aX, SWIGTYPE_p_double aY) {
    return opensimModelJNI.IntegCallback_step__SWIG_1(swigCPtr, SWIGTYPE_p_double.getCPtr(aXPrev), SWIGTYPE_p_double.getCPtr(aYPrev), aStep, aDT, aT, SWIGTYPE_p_double.getCPtr(aX), SWIGTYPE_p_double.getCPtr(aY));
  }

  public int end(int aStep, double aDT, double aT, SWIGTYPE_p_double aX, SWIGTYPE_p_double aY, SWIGTYPE_p_void aClientData) {
    return opensimModelJNI.IntegCallback_end__SWIG_0(swigCPtr, aStep, aDT, aT, SWIGTYPE_p_double.getCPtr(aX), SWIGTYPE_p_double.getCPtr(aY), SWIGTYPE_p_void.getCPtr(aClientData));
  }

  public int end(int aStep, double aDT, double aT, SWIGTYPE_p_double aX, SWIGTYPE_p_double aY) {
    return opensimModelJNI.IntegCallback_end__SWIG_1(swigCPtr, aStep, aDT, aT, SWIGTYPE_p_double.getCPtr(aX), SWIGTYPE_p_double.getCPtr(aY));
  }

}
