/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.37
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.opensim.modeling;

public class WrapTorus extends WrapObject {
  private long swigCPtr;

  public WrapTorus(long cPtr, boolean cMemoryOwn) {
    super(opensimModelJNI.SWIGStorageUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  public static long getCPtr(WrapTorus obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if(swigCPtr != 0 && swigCMemOwn) {
      swigCMemOwn = false;
      opensimModelJNI.delete_WrapTorus(swigCPtr);
    }
    swigCPtr = 0;
    super.delete();
  }

  public WrapTorus() {
    this(opensimModelJNI.new_WrapTorus__SWIG_0(), true);
  }

  public WrapTorus(WrapTorus aWrapTorus) {
    this(opensimModelJNI.new_WrapTorus__SWIG_1(WrapTorus.getCPtr(aWrapTorus), aWrapTorus), true);
  }

  public OpenSimObject copy() {
    long cPtr = opensimModelJNI.WrapTorus_copy(swigCPtr, this);
    return (cPtr == 0) ? null : new OpenSimObject(cPtr, false);
  }

  public void copyData(WrapTorus aWrapTorus) {
    opensimModelJNI.WrapTorus_copyData(swigCPtr, this, WrapTorus.getCPtr(aWrapTorus), aWrapTorus);
  }

  public String getWrapTypeName() {
    return opensimModelJNI.WrapTorus_getWrapTypeName(swigCPtr, this);
  }

  public String getDimensionsString() {
    return opensimModelJNI.WrapTorus_getDimensionsString(swigCPtr, this);
  }

  public void scale(SWIGTYPE_p_SimTK__Vec3 aScaleFactors) {
    opensimModelJNI.WrapTorus_scale(swigCPtr, this, SWIGTYPE_p_SimTK__Vec3.getCPtr(aScaleFactors));
  }

  public void setup(Model aModel, Body aBody) {
    opensimModelJNI.WrapTorus_setup(swigCPtr, this, Model.getCPtr(aModel), aModel, Body.getCPtr(aBody), aBody);
  }

}
