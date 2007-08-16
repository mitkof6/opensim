/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.31
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.opensim.modeling;

public class SimtkAnimationCallback extends IntegCallback {
  private long swigCPtr;

  public SimtkAnimationCallback(long cPtr, boolean cMemoryOwn) {
    super(opensimModelJNI.SWIGStorageUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  public static long getCPtr(SimtkAnimationCallback obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  public synchronized void delete() {
    if(swigCPtr != 0 && swigCMemOwn) {
      swigCMemOwn = false;
      throw new UnsupportedOperationException("C++ destructor does not have public access");
    }
    swigCPtr = 0;
    super.delete();
  }

  protected void swigDirectorDisconnect() {
    swigCMemOwn = false;
    delete();
  }

  public void swigReleaseOwnership() {
    swigCMemOwn = false;
    opensimModelJNI.SimtkAnimationCallback_change_ownership(this, swigCPtr, false);
  }

  public void swigTakeOwnership() {
    swigCMemOwn = true;
    opensimModelJNI.SimtkAnimationCallback_change_ownership(this, swigCPtr, true);
  }

  public static SimtkAnimationCallback CreateAnimationCallback(Model aModel) {
    long cPtr = opensimModelJNI.SimtkAnimationCallback_CreateAnimationCallback(Model.getCPtr(aModel), aModel);
    return (cPtr == 0) ? null : new SimtkAnimationCallback(cPtr, false);
  }

  protected SimtkAnimationCallback(Model aModel, Model aModelForDisplay) {
    this(opensimModelJNI.new_SimtkAnimationCallback__SWIG_0(Model.getCPtr(aModel), aModel, Model.getCPtr(aModelForDisplay), aModelForDisplay), true);
    opensimModelJNI.SimtkAnimationCallback_director_connect(this, swigCPtr, swigCMemOwn, true);
  }

  protected SimtkAnimationCallback(Model aModel) {
    this(opensimModelJNI.new_SimtkAnimationCallback__SWIG_1(Model.getCPtr(aModel), aModel), true);
    opensimModelJNI.SimtkAnimationCallback_director_connect(this, swigCPtr, swigCMemOwn, true);
  }

  public double getCurrentTime() {
    return opensimModelJNI.SimtkAnimationCallback_getCurrentTime(swigCPtr, this);
  }

  public int step(SWIGTYPE_p_double aXPrev, SWIGTYPE_p_double aYPrev, SWIGTYPE_p_double aYPPrev, int aStep, double aDT, double aT, SWIGTYPE_p_double aX, SWIGTYPE_p_double aY, SWIGTYPE_p_double aYP, SWIGTYPE_p_double aDYDT, SWIGTYPE_p_void aClientData) {
    return (getClass() == SimtkAnimationCallback.class) ? opensimModelJNI.SimtkAnimationCallback_step__SWIG_0(swigCPtr, this, SWIGTYPE_p_double.getCPtr(aXPrev), SWIGTYPE_p_double.getCPtr(aYPrev), SWIGTYPE_p_double.getCPtr(aYPPrev), aStep, aDT, aT, SWIGTYPE_p_double.getCPtr(aX), SWIGTYPE_p_double.getCPtr(aY), SWIGTYPE_p_double.getCPtr(aYP), SWIGTYPE_p_double.getCPtr(aDYDT), SWIGTYPE_p_void.getCPtr(aClientData)) : opensimModelJNI.SimtkAnimationCallback_stepSwigExplicitSimtkAnimationCallback__SWIG_0(swigCPtr, this, SWIGTYPE_p_double.getCPtr(aXPrev), SWIGTYPE_p_double.getCPtr(aYPrev), SWIGTYPE_p_double.getCPtr(aYPPrev), aStep, aDT, aT, SWIGTYPE_p_double.getCPtr(aX), SWIGTYPE_p_double.getCPtr(aY), SWIGTYPE_p_double.getCPtr(aYP), SWIGTYPE_p_double.getCPtr(aDYDT), SWIGTYPE_p_void.getCPtr(aClientData));
  }

  public int step(SWIGTYPE_p_double aXPrev, SWIGTYPE_p_double aYPrev, SWIGTYPE_p_double aYPPrev, int aStep, double aDT, double aT, SWIGTYPE_p_double aX, SWIGTYPE_p_double aY, SWIGTYPE_p_double aYP, SWIGTYPE_p_double aDYDT) {
    return (getClass() == SimtkAnimationCallback.class) ? opensimModelJNI.SimtkAnimationCallback_step__SWIG_1(swigCPtr, this, SWIGTYPE_p_double.getCPtr(aXPrev), SWIGTYPE_p_double.getCPtr(aYPrev), SWIGTYPE_p_double.getCPtr(aYPPrev), aStep, aDT, aT, SWIGTYPE_p_double.getCPtr(aX), SWIGTYPE_p_double.getCPtr(aY), SWIGTYPE_p_double.getCPtr(aYP), SWIGTYPE_p_double.getCPtr(aDYDT)) : opensimModelJNI.SimtkAnimationCallback_stepSwigExplicitSimtkAnimationCallback__SWIG_1(swigCPtr, this, SWIGTYPE_p_double.getCPtr(aXPrev), SWIGTYPE_p_double.getCPtr(aYPrev), SWIGTYPE_p_double.getCPtr(aYPPrev), aStep, aDT, aT, SWIGTYPE_p_double.getCPtr(aX), SWIGTYPE_p_double.getCPtr(aY), SWIGTYPE_p_double.getCPtr(aYP), SWIGTYPE_p_double.getCPtr(aDYDT));
  }

  public int step(SWIGTYPE_p_double aXPrev, SWIGTYPE_p_double aYPrev, SWIGTYPE_p_double aYPPrev, int aStep, double aDT, double aT, SWIGTYPE_p_double aX, SWIGTYPE_p_double aY, SWIGTYPE_p_double aYP) {
    return (getClass() == SimtkAnimationCallback.class) ? opensimModelJNI.SimtkAnimationCallback_step__SWIG_2(swigCPtr, this, SWIGTYPE_p_double.getCPtr(aXPrev), SWIGTYPE_p_double.getCPtr(aYPrev), SWIGTYPE_p_double.getCPtr(aYPPrev), aStep, aDT, aT, SWIGTYPE_p_double.getCPtr(aX), SWIGTYPE_p_double.getCPtr(aY), SWIGTYPE_p_double.getCPtr(aYP)) : opensimModelJNI.SimtkAnimationCallback_stepSwigExplicitSimtkAnimationCallback__SWIG_2(swigCPtr, this, SWIGTYPE_p_double.getCPtr(aXPrev), SWIGTYPE_p_double.getCPtr(aYPrev), SWIGTYPE_p_double.getCPtr(aYPPrev), aStep, aDT, aT, SWIGTYPE_p_double.getCPtr(aX), SWIGTYPE_p_double.getCPtr(aY), SWIGTYPE_p_double.getCPtr(aYP));
  }

  public int step(SWIGTYPE_p_double aXPrev, SWIGTYPE_p_double aYPrev, SWIGTYPE_p_double aYPPrev, int aStep, double aDT, double aT, SWIGTYPE_p_double aX, SWIGTYPE_p_double aY) {
    return (getClass() == SimtkAnimationCallback.class) ? opensimModelJNI.SimtkAnimationCallback_step__SWIG_3(swigCPtr, this, SWIGTYPE_p_double.getCPtr(aXPrev), SWIGTYPE_p_double.getCPtr(aYPrev), SWIGTYPE_p_double.getCPtr(aYPPrev), aStep, aDT, aT, SWIGTYPE_p_double.getCPtr(aX), SWIGTYPE_p_double.getCPtr(aY)) : opensimModelJNI.SimtkAnimationCallback_stepSwigExplicitSimtkAnimationCallback__SWIG_3(swigCPtr, this, SWIGTYPE_p_double.getCPtr(aXPrev), SWIGTYPE_p_double.getCPtr(aYPrev), SWIGTYPE_p_double.getCPtr(aYPPrev), aStep, aDT, aT, SWIGTYPE_p_double.getCPtr(aX), SWIGTYPE_p_double.getCPtr(aY));
  }

  public int begin(int aStep, double aDT, double aT, SWIGTYPE_p_double aX, SWIGTYPE_p_double aY, SWIGTYPE_p_double aYP, SWIGTYPE_p_double aDYDT, SWIGTYPE_p_void aClientData) {
    return (getClass() == SimtkAnimationCallback.class) ? opensimModelJNI.SimtkAnimationCallback_begin__SWIG_0(swigCPtr, this, aStep, aDT, aT, SWIGTYPE_p_double.getCPtr(aX), SWIGTYPE_p_double.getCPtr(aY), SWIGTYPE_p_double.getCPtr(aYP), SWIGTYPE_p_double.getCPtr(aDYDT), SWIGTYPE_p_void.getCPtr(aClientData)) : opensimModelJNI.SimtkAnimationCallback_beginSwigExplicitSimtkAnimationCallback__SWIG_0(swigCPtr, this, aStep, aDT, aT, SWIGTYPE_p_double.getCPtr(aX), SWIGTYPE_p_double.getCPtr(aY), SWIGTYPE_p_double.getCPtr(aYP), SWIGTYPE_p_double.getCPtr(aDYDT), SWIGTYPE_p_void.getCPtr(aClientData));
  }

  public int begin(int aStep, double aDT, double aT, SWIGTYPE_p_double aX, SWIGTYPE_p_double aY, SWIGTYPE_p_double aYP, SWIGTYPE_p_double aDYDT) {
    return (getClass() == SimtkAnimationCallback.class) ? opensimModelJNI.SimtkAnimationCallback_begin__SWIG_1(swigCPtr, this, aStep, aDT, aT, SWIGTYPE_p_double.getCPtr(aX), SWIGTYPE_p_double.getCPtr(aY), SWIGTYPE_p_double.getCPtr(aYP), SWIGTYPE_p_double.getCPtr(aDYDT)) : opensimModelJNI.SimtkAnimationCallback_beginSwigExplicitSimtkAnimationCallback__SWIG_1(swigCPtr, this, aStep, aDT, aT, SWIGTYPE_p_double.getCPtr(aX), SWIGTYPE_p_double.getCPtr(aY), SWIGTYPE_p_double.getCPtr(aYP), SWIGTYPE_p_double.getCPtr(aDYDT));
  }

  public int begin(int aStep, double aDT, double aT, SWIGTYPE_p_double aX, SWIGTYPE_p_double aY, SWIGTYPE_p_double aYP) {
    return (getClass() == SimtkAnimationCallback.class) ? opensimModelJNI.SimtkAnimationCallback_begin__SWIG_2(swigCPtr, this, aStep, aDT, aT, SWIGTYPE_p_double.getCPtr(aX), SWIGTYPE_p_double.getCPtr(aY), SWIGTYPE_p_double.getCPtr(aYP)) : opensimModelJNI.SimtkAnimationCallback_beginSwigExplicitSimtkAnimationCallback__SWIG_2(swigCPtr, this, aStep, aDT, aT, SWIGTYPE_p_double.getCPtr(aX), SWIGTYPE_p_double.getCPtr(aY), SWIGTYPE_p_double.getCPtr(aYP));
  }

  public int begin(int aStep, double aDT, double aT, SWIGTYPE_p_double aX, SWIGTYPE_p_double aY) {
    return (getClass() == SimtkAnimationCallback.class) ? opensimModelJNI.SimtkAnimationCallback_begin__SWIG_3(swigCPtr, this, aStep, aDT, aT, SWIGTYPE_p_double.getCPtr(aX), SWIGTYPE_p_double.getCPtr(aY)) : opensimModelJNI.SimtkAnimationCallback_beginSwigExplicitSimtkAnimationCallback__SWIG_3(swigCPtr, this, aStep, aDT, aT, SWIGTYPE_p_double.getCPtr(aX), SWIGTYPE_p_double.getCPtr(aY));
  }

  public Transform getBodyTransform(int bodyIndex) {
    long cPtr = opensimModelJNI.SimtkAnimationCallback_getBodyTransform(swigCPtr, this, bodyIndex);
    return (cPtr == 0) ? null : new Transform(cPtr, false);
  }

  public void extractOffsets(Model displayModel) {
    opensimModelJNI.SimtkAnimationCallback_extractOffsets(swigCPtr, this, Model.getCPtr(displayModel), displayModel);
  }

  public Model getModelForDisplay() {
    long cPtr = opensimModelJNI.SimtkAnimationCallback_getModelForDisplay(swigCPtr, this);
    return (cPtr == 0) ? null : new Model(cPtr, false);
  }

  public void setModelForDisplaySetConfiguration(boolean aSetConfiguration) {
    opensimModelJNI.SimtkAnimationCallback_setModelForDisplaySetConfiguration(swigCPtr, this, aSetConfiguration);
  }

  public boolean getModelForDisplayCompatibleStates() {
    return opensimModelJNI.SimtkAnimationCallback_getModelForDisplayCompatibleStates(swigCPtr, this);
  }

  public void getTransformsFromKinematicsEngine(Model simmModel) {
    opensimModelJNI.SimtkAnimationCallback_getTransformsFromKinematicsEngine(swigCPtr, this, Model.getCPtr(simmModel), simmModel);
  }

}
