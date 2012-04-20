/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.4
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.opensim.modeling;

public class WrapSphere extends WrapObject {
  private long swigCPtr;

  public WrapSphere(long cPtr, boolean cMemoryOwn) {
    super(opensimModelJNI.WrapSphere_SWIGUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  public static long getCPtr(WrapSphere obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        opensimModelJNI.delete_WrapSphere(swigCPtr);
      }
      swigCPtr = 0;
    }
    super.delete();
  }

  public static WrapSphere safeDownCast(OpenSimObject obj) {
    long cPtr = opensimModelJNI.WrapSphere_safeDownCast(OpenSimObject.getCPtr(obj), obj);
    return (cPtr == 0) ? null : new WrapSphere(cPtr, false);
  }

  public void assign(OpenSimObject aObject) {
    opensimModelJNI.WrapSphere_assign(swigCPtr, this, OpenSimObject.getCPtr(aObject), aObject);
  }

  public static String getClassName() {
    return opensimModelJNI.WrapSphere_getClassName();
  }

  public OpenSimObject clone() {
    long cPtr = opensimModelJNI.WrapSphere_clone(swigCPtr, this);
    return (cPtr == 0) ? null : new WrapSphere(cPtr, false);
  }

  public String getConcreteClassName() {
    return opensimModelJNI.WrapSphere_getConcreteClassName(swigCPtr, this);
  }

  public WrapSphere() {
    this(opensimModelJNI.new_WrapSphere__SWIG_0(), true);
  }

  public WrapSphere(WrapSphere aWrapSphere) {
    this(opensimModelJNI.new_WrapSphere__SWIG_1(WrapSphere.getCPtr(aWrapSphere), aWrapSphere), true);
  }

  public void copyData(WrapSphere aWrapSphere) {
    opensimModelJNI.WrapSphere_copyData(swigCPtr, this, WrapSphere.getCPtr(aWrapSphere), aWrapSphere);
  }

  public String getWrapTypeName() {
    return opensimModelJNI.WrapSphere_getWrapTypeName(swigCPtr, this);
  }

  public String getDimensionsString() {
    return opensimModelJNI.WrapSphere_getDimensionsString(swigCPtr, this);
  }

  public double getRadius() {
    return opensimModelJNI.WrapSphere_getRadius(swigCPtr, this);
  }

  public void scale(SWIGTYPE_p_SimTK__Vec3 aScaleFactors) {
    opensimModelJNI.WrapSphere_scale(swigCPtr, this, SWIGTYPE_p_SimTK__Vec3.getCPtr(aScaleFactors));
  }

  public void setup(Model aModel, Body aBody) {
    opensimModelJNI.WrapSphere_setup(swigCPtr, this, Model.getCPtr(aModel), aModel, Body.getCPtr(aBody), aBody);
  }

}
