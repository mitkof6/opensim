/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.4
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.opensim.modeling;

public class ArrowGeometry extends LineGeometry {
  private long swigCPtr;

  public ArrowGeometry(long cPtr, boolean cMemoryOwn) {
    super(opensimModelJNI.ArrowGeometry_SWIGUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  public static long getCPtr(ArrowGeometry obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        opensimModelJNI.delete_ArrowGeometry(swigCPtr);
      }
      swigCPtr = 0;
    }
    super.delete();
  }

  public ArrowGeometry(SWIGTYPE_p_SimTK__Vec3 aPoint1, SWIGTYPE_p_SimTK__Vec3 aUnitDirTo, double aLength) {
    this(opensimModelJNI.new_ArrowGeometry(SWIGTYPE_p_SimTK__Vec3.getCPtr(aPoint1), SWIGTYPE_p_SimTK__Vec3.getCPtr(aUnitDirTo), aLength), true);
  }

}
