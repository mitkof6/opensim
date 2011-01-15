/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.37
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.opensim.modeling;

public class AnalyticTorus extends AnalyticGeometry {
  private long swigCPtr;

  public AnalyticTorus(long cPtr, boolean cMemoryOwn) {
    super(opensimModelJNI.SWIGStorageUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  public static long getCPtr(AnalyticTorus obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if(swigCPtr != 0 && swigCMemOwn) {
      swigCMemOwn = false;
      opensimModelJNI.delete_AnalyticTorus(swigCPtr);
    }
    swigCPtr = 0;
    super.delete();
  }

  public AnalyticTorus() {
    this(opensimModelJNI.new_AnalyticTorus__SWIG_0(), true);
  }

  public AnalyticTorus(double ringRadius, double crossSectionRadius) {
    this(opensimModelJNI.new_AnalyticTorus__SWIG_1(ringRadius, crossSectionRadius), true);
  }

  public void getTorusParams(double[] params) {
    opensimModelJNI.AnalyticTorus_getTorusParams(swigCPtr, this, params);
  }

  public static AnalyticTorus dynamic_cast(Geometry geometry) {
    long cPtr = opensimModelJNI.AnalyticTorus_dynamic_cast(Geometry.getCPtr(geometry), geometry);
    return (cPtr == 0) ? null : new AnalyticTorus(cPtr, false);
  }

}
