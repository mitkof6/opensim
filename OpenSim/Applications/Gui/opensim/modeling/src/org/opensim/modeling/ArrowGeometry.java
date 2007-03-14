/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.31
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.opensim.modeling;

public class ArrowGeometry extends LineGeometry {
  private long swigCPtr;

  public ArrowGeometry(long cPtr, boolean cMemoryOwn) {
    super(opensimModelJNI.SWIGStorageUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  public static long getCPtr(ArrowGeometry obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if(swigCPtr != 0 && swigCMemOwn) {
      swigCMemOwn = false;
      opensimModelJNI.delete_ArrowGeometry(swigCPtr);
    }
    swigCPtr = 0;
    super.delete();
  }

  public ArrowGeometry(double[] aPoint1, double[] aUnitDirTo, double aLength) {
    this(opensimModelJNI.new_ArrowGeometry(aPoint1, aUnitDirTo, aLength), true);
  }

}
