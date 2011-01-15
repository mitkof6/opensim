/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.37
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.opensim.modeling;

public class LineGeometry extends Geometry {
  private long swigCPtr;

  public LineGeometry(long cPtr, boolean cMemoryOwn) {
    super(opensimModelJNI.SWIGStorageUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  public static long getCPtr(LineGeometry obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if(swigCPtr != 0 && swigCMemOwn) {
      swigCMemOwn = false;
      opensimModelJNI.delete_LineGeometry(swigCPtr);
    }
    swigCPtr = 0;
    super.delete();
  }

  public LineGeometry(SWIGTYPE_p_SimTK__Vec3 aPoint1, SWIGTYPE_p_SimTK__Vec3 aPoint2) {
    this(opensimModelJNI.new_LineGeometry__SWIG_0(SWIGTYPE_p_SimTK__Vec3.getCPtr(aPoint1), SWIGTYPE_p_SimTK__Vec3.getCPtr(aPoint2)), true);
  }

  public LineGeometry() {
    this(opensimModelJNI.new_LineGeometry__SWIG_1(), true);
  }

  public void getPoints(SWIGTYPE_p_SimTK__Vec3 rPoint1, SWIGTYPE_p_SimTK__Vec3 rPoint2) {
    opensimModelJNI.LineGeometry_getPoints__SWIG_0(swigCPtr, this, SWIGTYPE_p_SimTK__Vec3.getCPtr(rPoint1), SWIGTYPE_p_SimTK__Vec3.getCPtr(rPoint2));
  }

  public void getPoints(double[] rPoint1, double[] rPoint2) {
    opensimModelJNI.LineGeometry_getPoints__SWIG_1(swigCPtr, this, rPoint1, rPoint2);
  }

  public void setPoints(SWIGTYPE_p_SimTK__Vec3 aPoint1, SWIGTYPE_p_SimTK__Vec3 aPoint2) {
    opensimModelJNI.LineGeometry_setPoints__SWIG_0(swigCPtr, this, SWIGTYPE_p_SimTK__Vec3.getCPtr(aPoint1), SWIGTYPE_p_SimTK__Vec3.getCPtr(aPoint2));
  }

  public void setPoints(double[] aPoint1, double[] aPoint2) {
    opensimModelJNI.LineGeometry_setPoints__SWIG_1(swigCPtr, this, aPoint1, aPoint2);
  }

  public static LineGeometry dynamic_cast(Geometry geometry) {
    long cPtr = opensimModelJNI.LineGeometry_dynamic_cast(Geometry.getCPtr(geometry), geometry);
    return (cPtr == 0) ? null : new LineGeometry(cPtr, false);
  }

}
