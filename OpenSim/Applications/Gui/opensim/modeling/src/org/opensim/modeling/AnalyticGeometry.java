/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.31
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.opensim.modeling;

public class AnalyticGeometry extends Geometry {
  private long swigCPtr;

  public AnalyticGeometry(long cPtr, boolean cMemoryOwn) {
    super(opensimModelJNI.SWIGStorageUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  public static long getCPtr(AnalyticGeometry obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if(swigCPtr != 0 && swigCMemOwn) {
      swigCMemOwn = false;
      opensimModelJNI.delete_AnalyticGeometry(swigCPtr);
    }
    swigCPtr = 0;
    super.delete();
  }

  public AnalyticGeometry(Geometry.GeometryType aGeometricType) {
    this(opensimModelJNI.new_AnalyticGeometry(aGeometricType.swigValue()), true);
  }

  public double getSphereRadius() {
    return opensimModelJNI.AnalyticGeometry_getSphereRadius(swigCPtr, this);
  }

  public void setSphereRadius(double radius) {
    opensimModelJNI.AnalyticGeometry_setSphereRadius(swigCPtr, this, radius);
  }

  public void getCylinderParams(SWIGTYPE_p_double radius, SWIGTYPE_p_double height) {
    opensimModelJNI.AnalyticGeometry_getCylinderParams(swigCPtr, this, SWIGTYPE_p_double.getCPtr(radius), SWIGTYPE_p_double.getCPtr(height));
  }

  public void getConeParams(SWIGTYPE_p_double baseRadius, SWIGTYPE_p_double topRadius, SWIGTYPE_p_double height) {
    opensimModelJNI.AnalyticGeometry_getConeParams(swigCPtr, this, SWIGTYPE_p_double.getCPtr(baseRadius), SWIGTYPE_p_double.getCPtr(topRadius), SWIGTYPE_p_double.getCPtr(height));
  }

  public void getEllipsoidParams(SWIGTYPE_p_double radiusX, SWIGTYPE_p_double radiusY, SWIGTYPE_p_double radiusZ) {
    opensimModelJNI.AnalyticGeometry_getEllipsoidParams(swigCPtr, this, SWIGTYPE_p_double.getCPtr(radiusX), SWIGTYPE_p_double.getCPtr(radiusY), SWIGTYPE_p_double.getCPtr(radiusZ));
  }

  public static AnalyticGeometry createSphere(double radius) {
    long cPtr = opensimModelJNI.AnalyticGeometry_createSphere(radius);
    return (cPtr == 0) ? null : new AnalyticGeometry(cPtr, false);
  }

  public static AnalyticGeometry dynamic_cast(Geometry geometry) {
    long cPtr = opensimModelJNI.AnalyticGeometry_dynamic_cast(Geometry.getCPtr(geometry), geometry);
    return (cPtr == 0) ? null : new AnalyticGeometry(cPtr, false);
  }

}
