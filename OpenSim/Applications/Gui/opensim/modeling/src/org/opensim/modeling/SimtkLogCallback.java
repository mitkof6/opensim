/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.31
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.opensim.modeling;

public class SimtkLogCallback {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  public SimtkLogCallback(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  public static long getCPtr(SimtkLogCallback obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if(swigCPtr != 0 && swigCMemOwn) {
      swigCMemOwn = false;
      opensimModelJNI.delete_SimtkLogCallback(swigCPtr);
    }
    swigCPtr = 0;
  }

  protected void swigDirectorDisconnect() {
    swigCMemOwn = false;
    delete();
  }

  public void swigReleaseOwnership() {
    swigCMemOwn = false;
    opensimModelJNI.SimtkLogCallback_change_ownership(this, swigCPtr, false);
  }

  public void swigTakeOwnership() {
    swigCMemOwn = true;
    opensimModelJNI.SimtkLogCallback_change_ownership(this, swigCPtr, true);
  }

  public void log(String str) {
    if (getClass() == SimtkLogCallback.class) opensimModelJNI.SimtkLogCallback_log(swigCPtr, this, str); else opensimModelJNI.SimtkLogCallback_logSwigExplicitSimtkLogCallback(swigCPtr, this, str);
  }

  public void addToLogManager() {
    opensimModelJNI.SimtkLogCallback_addToLogManager(swigCPtr, this);
  }

  public void removeFromLogManager() {
    opensimModelJNI.SimtkLogCallback_removeFromLogManager(swigCPtr, this);
  }

  public SimtkLogCallback() {
    this(opensimModelJNI.new_SimtkLogCallback(), true);
    opensimModelJNI.SimtkLogCallback_director_connect(this, swigCPtr, swigCMemOwn, true);
  }

}
