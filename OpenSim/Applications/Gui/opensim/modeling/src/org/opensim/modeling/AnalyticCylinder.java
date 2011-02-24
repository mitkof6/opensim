/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.40
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.opensim.modeling;

public class AnalyticCylinder extends AnalyticGeometry {
  private long swigCPtr;

  public AnalyticCylinder(long cPtr, boolean cMemoryOwn) {
    super(opensimModelJNI.SWIGStorageUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  public static long getCPtr(AnalyticCylinder obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        opensimModelJNI.delete_AnalyticCylinder(swigCPtr);
      }
      swigCPtr = 0;
    }
    super.delete();
  }

  public AnalyticCylinder() {
    this(opensimModelJNI.new_AnalyticCylinder__SWIG_0(), true);
  }

  public AnalyticCylinder(double radius, double height) {
    this(opensimModelJNI.new_AnalyticCylinder__SWIG_1(radius, height), true);
  }

  public void getCylinderParams(double[] params) {
    opensimModelJNI.AnalyticCylinder_getCylinderParams(swigCPtr, this, params);
  }

  public static AnalyticCylinder dynamic_cast(Geometry geometry) {
    long cPtr = opensimModelJNI.AnalyticCylinder_dynamic_cast(Geometry.getCPtr(geometry), geometry);
    return (cPtr == 0) ? null : new AnalyticCylinder(cPtr, false);
  }

}
