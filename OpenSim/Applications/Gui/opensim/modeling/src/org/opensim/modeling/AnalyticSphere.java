/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.37
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.opensim.modeling;

public class AnalyticSphere extends AnalyticGeometry {
  private long swigCPtr;

  public AnalyticSphere(long cPtr, boolean cMemoryOwn) {
    super(opensimModelJNI.SWIGStorageUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  public static long getCPtr(AnalyticSphere obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if(swigCPtr != 0 && swigCMemOwn) {
      swigCMemOwn = false;
      opensimModelJNI.delete_AnalyticSphere(swigCPtr);
    }
    swigCPtr = 0;
    super.delete();
  }

  public AnalyticSphere() {
    this(opensimModelJNI.new_AnalyticSphere__SWIG_0(), true);
  }

  public AnalyticSphere(double radius) {
    this(opensimModelJNI.new_AnalyticSphere__SWIG_1(radius), true);
  }

  public double getRadius() {
    return opensimModelJNI.AnalyticSphere_getRadius(swigCPtr, this);
  }

  public void setSphereRadius(double radius) {
    opensimModelJNI.AnalyticSphere_setSphereRadius(swigCPtr, this, radius);
  }

  public static AnalyticGeometry createSphere(double radius) {
    long cPtr = opensimModelJNI.AnalyticSphere_createSphere(radius);
    return (cPtr == 0) ? null : new AnalyticGeometry(cPtr, false);
  }

  public static AnalyticSphere dynamic_cast(Geometry geometry) {
    long cPtr = opensimModelJNI.AnalyticSphere_dynamic_cast(Geometry.getCPtr(geometry), geometry);
    return (cPtr == 0) ? null : new AnalyticSphere(cPtr, false);
  }

}
