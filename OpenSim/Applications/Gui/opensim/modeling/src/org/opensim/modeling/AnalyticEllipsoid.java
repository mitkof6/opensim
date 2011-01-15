/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.37
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.opensim.modeling;

public class AnalyticEllipsoid extends AnalyticGeometry {
  private long swigCPtr;

  public AnalyticEllipsoid(long cPtr, boolean cMemoryOwn) {
    super(opensimModelJNI.SWIGStorageUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  public static long getCPtr(AnalyticEllipsoid obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if(swigCPtr != 0 && swigCMemOwn) {
      swigCMemOwn = false;
      opensimModelJNI.delete_AnalyticEllipsoid(swigCPtr);
    }
    swigCPtr = 0;
    super.delete();
  }

  public AnalyticEllipsoid() {
    this(opensimModelJNI.new_AnalyticEllipsoid__SWIG_0(), true);
  }

  public AnalyticEllipsoid(double radius1, double radius2, double radius3) {
    this(opensimModelJNI.new_AnalyticEllipsoid__SWIG_1(radius1, radius2, radius3), true);
  }

  public void setEllipsoidParams(double radius1, double radius2, double radius3) {
    opensimModelJNI.AnalyticEllipsoid_setEllipsoidParams(swigCPtr, this, radius1, radius2, radius3);
  }

  public void getEllipsoidParams(double[] params) {
    opensimModelJNI.AnalyticEllipsoid_getEllipsoidParams(swigCPtr, this, params);
  }

  public static AnalyticEllipsoid dynamic_cast(Geometry geometry) {
    long cPtr = opensimModelJNI.AnalyticEllipsoid_dynamic_cast(Geometry.getCPtr(geometry), geometry);
    return (cPtr == 0) ? null : new AnalyticEllipsoid(cPtr, false);
  }

}
