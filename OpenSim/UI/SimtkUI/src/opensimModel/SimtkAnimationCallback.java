/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.29
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package opensimModel;

public class SimtkAnimationCallback extends IntegCallback {
  private long swigCPtr;

  protected SimtkAnimationCallback(long cPtr, boolean cMemoryOwn) {
    super(opensimModelJNI.SWIGSimtkAnimationCallbackUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  protected static long getCPtr(SimtkAnimationCallback obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public void delete() {
    if(swigCPtr != 0 && swigCMemOwn) {
      swigCMemOwn = false;
      opensimModelJNI.delete_SimtkAnimationCallback(swigCPtr);
    }
    swigCPtr = 0;
    super.delete();
  }

  public SimtkAnimationCallback(Model aModel) {
    this(opensimModelJNI.new_SimtkAnimationCallback(Model.getCPtr(aModel)), true);
  }

  public double getCurrentTime() {
    return opensimModelJNI.SimtkAnimationCallback_getCurrentTime(swigCPtr);
  }

  public int step(SWIGTYPE_p_double aXPrev, SWIGTYPE_p_double aYPrev, int aStep, double aDT, double aT, SWIGTYPE_p_double aX, SWIGTYPE_p_double aY, SWIGTYPE_p_void aClientData) {
    return opensimModelJNI.SimtkAnimationCallback_step__SWIG_0(swigCPtr, SWIGTYPE_p_double.getCPtr(aXPrev), SWIGTYPE_p_double.getCPtr(aYPrev), aStep, aDT, aT, SWIGTYPE_p_double.getCPtr(aX), SWIGTYPE_p_double.getCPtr(aY), SWIGTYPE_p_void.getCPtr(aClientData));
  }

  public int step(SWIGTYPE_p_double aXPrev, SWIGTYPE_p_double aYPrev, int aStep, double aDT, double aT, SWIGTYPE_p_double aX, SWIGTYPE_p_double aY) {
    return opensimModelJNI.SimtkAnimationCallback_step__SWIG_1(swigCPtr, SWIGTYPE_p_double.getCPtr(aXPrev), SWIGTYPE_p_double.getCPtr(aYPrev), aStep, aDT, aT, SWIGTYPE_p_double.getCPtr(aX), SWIGTYPE_p_double.getCPtr(aY));
  }

  public void getMutex() {
    opensimModelJNI.SimtkAnimationCallback_getMutex(swigCPtr);
  }

  public void releaseMutex() {
    opensimModelJNI.SimtkAnimationCallback_releaseMutex(swigCPtr);
  }

}
