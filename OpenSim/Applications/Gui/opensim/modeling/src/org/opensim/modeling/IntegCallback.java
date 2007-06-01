/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.31
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.opensim.modeling;

public class IntegCallback extends Callback {
  private long swigCPtr;

  public IntegCallback(long cPtr, boolean cMemoryOwn) {
    super(opensimModelJNI.SWIGStorageUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  public static long getCPtr(IntegCallback obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if(swigCPtr != 0 && swigCMemOwn) {
      swigCMemOwn = false;
      opensimModelJNI.delete_IntegCallback(swigCPtr);
    }
    swigCPtr = 0;
    super.delete();
  }

  public IntegCallback(Model aModel) {
    this(opensimModelJNI.new_IntegCallback__SWIG_0(Model.getCPtr(aModel), aModel), true);
  }

  public IntegCallback() {
    this(opensimModelJNI.new_IntegCallback__SWIG_1(), true);
  }

  public IntegCallback(String aFileName, boolean aUpdateFromXMLNode) {
    this(opensimModelJNI.new_IntegCallback__SWIG_2(aFileName, aUpdateFromXMLNode), true);
  }

  public IntegCallback(String aFileName) {
    this(opensimModelJNI.new_IntegCallback__SWIG_3(aFileName), true);
  }

  public IntegCallback(IntegCallback aIntegCallback) {
    this(opensimModelJNI.new_IntegCallback__SWIG_4(IntegCallback.getCPtr(aIntegCallback), aIntegCallback), true);
  }

  public OpenSimObject copy() {
    long cPtr = opensimModelJNI.IntegCallback_copy(swigCPtr, this);
    return (cPtr == 0) ? null : new OpenSimObject(cPtr, false);
  }

  public void setStepInterval(int aStepInterval) {
    opensimModelJNI.IntegCallback_setStepInterval(swigCPtr, this, aStepInterval);
  }

  public int getStepInterval() {
    return opensimModelJNI.IntegCallback_getStepInterval(swigCPtr, this);
  }

  public int begin(int aStep, double aDT, double aT, SWIGTYPE_p_double aX, SWIGTYPE_p_double aY, SWIGTYPE_p_double aYP, SWIGTYPE_p_double aDYDT, SWIGTYPE_p_void aClientData) {
    return opensimModelJNI.IntegCallback_begin__SWIG_0(swigCPtr, this, aStep, aDT, aT, SWIGTYPE_p_double.getCPtr(aX), SWIGTYPE_p_double.getCPtr(aY), SWIGTYPE_p_double.getCPtr(aYP), SWIGTYPE_p_double.getCPtr(aDYDT), SWIGTYPE_p_void.getCPtr(aClientData));
  }

  public int begin(int aStep, double aDT, double aT, SWIGTYPE_p_double aX, SWIGTYPE_p_double aY, SWIGTYPE_p_double aYP, SWIGTYPE_p_double aDYDT) {
    return opensimModelJNI.IntegCallback_begin__SWIG_1(swigCPtr, this, aStep, aDT, aT, SWIGTYPE_p_double.getCPtr(aX), SWIGTYPE_p_double.getCPtr(aY), SWIGTYPE_p_double.getCPtr(aYP), SWIGTYPE_p_double.getCPtr(aDYDT));
  }

  public int begin(int aStep, double aDT, double aT, SWIGTYPE_p_double aX, SWIGTYPE_p_double aY, SWIGTYPE_p_double aYP) {
    return opensimModelJNI.IntegCallback_begin__SWIG_2(swigCPtr, this, aStep, aDT, aT, SWIGTYPE_p_double.getCPtr(aX), SWIGTYPE_p_double.getCPtr(aY), SWIGTYPE_p_double.getCPtr(aYP));
  }

  public int begin(int aStep, double aDT, double aT, SWIGTYPE_p_double aX, SWIGTYPE_p_double aY) {
    return opensimModelJNI.IntegCallback_begin__SWIG_3(swigCPtr, this, aStep, aDT, aT, SWIGTYPE_p_double.getCPtr(aX), SWIGTYPE_p_double.getCPtr(aY));
  }

  public int step(SWIGTYPE_p_double aXPrev, SWIGTYPE_p_double aYPrev, SWIGTYPE_p_double aYPPrev, int aStep, double aDT, double aT, SWIGTYPE_p_double aX, SWIGTYPE_p_double aY, SWIGTYPE_p_double aYP, SWIGTYPE_p_double aDYDT, SWIGTYPE_p_void aClientData) {
    return opensimModelJNI.IntegCallback_step__SWIG_0(swigCPtr, this, SWIGTYPE_p_double.getCPtr(aXPrev), SWIGTYPE_p_double.getCPtr(aYPrev), SWIGTYPE_p_double.getCPtr(aYPPrev), aStep, aDT, aT, SWIGTYPE_p_double.getCPtr(aX), SWIGTYPE_p_double.getCPtr(aY), SWIGTYPE_p_double.getCPtr(aYP), SWIGTYPE_p_double.getCPtr(aDYDT), SWIGTYPE_p_void.getCPtr(aClientData));
  }

  public int step(SWIGTYPE_p_double aXPrev, SWIGTYPE_p_double aYPrev, SWIGTYPE_p_double aYPPrev, int aStep, double aDT, double aT, SWIGTYPE_p_double aX, SWIGTYPE_p_double aY, SWIGTYPE_p_double aYP, SWIGTYPE_p_double aDYDT) {
    return opensimModelJNI.IntegCallback_step__SWIG_1(swigCPtr, this, SWIGTYPE_p_double.getCPtr(aXPrev), SWIGTYPE_p_double.getCPtr(aYPrev), SWIGTYPE_p_double.getCPtr(aYPPrev), aStep, aDT, aT, SWIGTYPE_p_double.getCPtr(aX), SWIGTYPE_p_double.getCPtr(aY), SWIGTYPE_p_double.getCPtr(aYP), SWIGTYPE_p_double.getCPtr(aDYDT));
  }

  public int step(SWIGTYPE_p_double aXPrev, SWIGTYPE_p_double aYPrev, SWIGTYPE_p_double aYPPrev, int aStep, double aDT, double aT, SWIGTYPE_p_double aX, SWIGTYPE_p_double aY, SWIGTYPE_p_double aYP) {
    return opensimModelJNI.IntegCallback_step__SWIG_2(swigCPtr, this, SWIGTYPE_p_double.getCPtr(aXPrev), SWIGTYPE_p_double.getCPtr(aYPrev), SWIGTYPE_p_double.getCPtr(aYPPrev), aStep, aDT, aT, SWIGTYPE_p_double.getCPtr(aX), SWIGTYPE_p_double.getCPtr(aY), SWIGTYPE_p_double.getCPtr(aYP));
  }

  public int step(SWIGTYPE_p_double aXPrev, SWIGTYPE_p_double aYPrev, SWIGTYPE_p_double aYPPrev, int aStep, double aDT, double aT, SWIGTYPE_p_double aX, SWIGTYPE_p_double aY) {
    return opensimModelJNI.IntegCallback_step__SWIG_3(swigCPtr, this, SWIGTYPE_p_double.getCPtr(aXPrev), SWIGTYPE_p_double.getCPtr(aYPrev), SWIGTYPE_p_double.getCPtr(aYPPrev), aStep, aDT, aT, SWIGTYPE_p_double.getCPtr(aX), SWIGTYPE_p_double.getCPtr(aY));
  }

  public int end(int aStep, double aDT, double aT, SWIGTYPE_p_double aX, SWIGTYPE_p_double aY, SWIGTYPE_p_double aYP, SWIGTYPE_p_double aDYDT, SWIGTYPE_p_void aClientData) {
    return opensimModelJNI.IntegCallback_end__SWIG_0(swigCPtr, this, aStep, aDT, aT, SWIGTYPE_p_double.getCPtr(aX), SWIGTYPE_p_double.getCPtr(aY), SWIGTYPE_p_double.getCPtr(aYP), SWIGTYPE_p_double.getCPtr(aDYDT), SWIGTYPE_p_void.getCPtr(aClientData));
  }

  public int end(int aStep, double aDT, double aT, SWIGTYPE_p_double aX, SWIGTYPE_p_double aY, SWIGTYPE_p_double aYP, SWIGTYPE_p_double aDYDT) {
    return opensimModelJNI.IntegCallback_end__SWIG_1(swigCPtr, this, aStep, aDT, aT, SWIGTYPE_p_double.getCPtr(aX), SWIGTYPE_p_double.getCPtr(aY), SWIGTYPE_p_double.getCPtr(aYP), SWIGTYPE_p_double.getCPtr(aDYDT));
  }

  public int end(int aStep, double aDT, double aT, SWIGTYPE_p_double aX, SWIGTYPE_p_double aY, SWIGTYPE_p_double aYP) {
    return opensimModelJNI.IntegCallback_end__SWIG_2(swigCPtr, this, aStep, aDT, aT, SWIGTYPE_p_double.getCPtr(aX), SWIGTYPE_p_double.getCPtr(aY), SWIGTYPE_p_double.getCPtr(aYP));
  }

  public int end(int aStep, double aDT, double aT, SWIGTYPE_p_double aX, SWIGTYPE_p_double aY) {
    return opensimModelJNI.IntegCallback_end__SWIG_3(swigCPtr, this, aStep, aDT, aT, SWIGTYPE_p_double.getCPtr(aX), SWIGTYPE_p_double.getCPtr(aY));
  }

}
