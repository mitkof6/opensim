/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.4
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.opensim.modeling;

public class GeometrySet extends SetGeometry {
  private long swigCPtr;

  public GeometrySet(long cPtr, boolean cMemoryOwn) {
    super(opensimModelJNI.GeometrySet_SWIGUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  public static long getCPtr(GeometrySet obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        opensimModelJNI.delete_GeometrySet(swigCPtr);
      }
      swigCPtr = 0;
    }
    super.delete();
  }

  public static GeometrySet safeDownCast(OpenSimObject obj) {
    long cPtr = opensimModelJNI.GeometrySet_safeDownCast(OpenSimObject.getCPtr(obj), obj);
    return (cPtr == 0) ? null : new GeometrySet(cPtr, false);
  }

  public void assign(OpenSimObject aObject) {
    opensimModelJNI.GeometrySet_assign(swigCPtr, this, OpenSimObject.getCPtr(aObject), aObject);
  }

  public static String getClassName() {
    return opensimModelJNI.GeometrySet_getClassName();
  }

  public OpenSimObject clone() {
    long cPtr = opensimModelJNI.GeometrySet_clone(swigCPtr, this);
    return (cPtr == 0) ? null : new GeometrySet(cPtr, false);
  }

  public String getConcreteClassName() {
    return opensimModelJNI.GeometrySet_getConcreteClassName(swigCPtr, this);
  }

  public GeometrySet() {
    this(opensimModelJNI.new_GeometrySet(), true);
  }

}
