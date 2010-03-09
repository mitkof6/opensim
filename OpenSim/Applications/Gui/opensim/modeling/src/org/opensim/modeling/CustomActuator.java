/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.31
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.opensim.modeling;

public class CustomActuator extends Actuator {
  private long swigCPtr;

  public CustomActuator(long cPtr, boolean cMemoryOwn) {
    super(opensimModelJNI.SWIGStorageUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  public static long getCPtr(CustomActuator obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if(swigCPtr != 0 && swigCMemOwn) {
      swigCMemOwn = false;
      opensimModelJNI.delete_CustomActuator(swigCPtr);
    }
    swigCPtr = 0;
    super.delete();
  }

  public static boolean isKindOf(String type) {
    return opensimModelJNI.CustomActuator_isKindOf(type);
  }

  public boolean isA(String type) {
    return opensimModelJNI.CustomActuator_isA(swigCPtr, this, type);
  }

  public static CustomActuator safeDownCast(OpenSimObject obj) {
    long cPtr = opensimModelJNI.CustomActuator_safeDownCast(OpenSimObject.getCPtr(obj), obj);
    return (cPtr == 0) ? null : new CustomActuator(cPtr, false);
  }

  public void copy(OpenSimObject aObject) {
    opensimModelJNI.CustomActuator_copy(swigCPtr, this, OpenSimObject.getCPtr(aObject), aObject);
  }

  public void createSystem(SWIGTYPE_p_SimTK__MultibodySystem system) {
    opensimModelJNI.CustomActuator_createSystem(swigCPtr, this, SWIGTYPE_p_SimTK__MultibodySystem.getCPtr(system));
  }

}