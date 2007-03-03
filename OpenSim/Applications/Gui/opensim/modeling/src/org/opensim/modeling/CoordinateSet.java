/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.31
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.opensim.modeling;

public class CoordinateSet extends SetCoordinates {
  private long swigCPtr;

  public CoordinateSet(long cPtr, boolean cMemoryOwn) {
    super(opensimModelJNI.SWIGStorageUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  public static long getCPtr(CoordinateSet obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if(swigCPtr != 0 && swigCMemOwn) {
      swigCMemOwn = false;
      opensimModelJNI.delete_CoordinateSet(swigCPtr);
    }
    swigCPtr = 0;
    super.delete();
  }

  public CoordinateSet() {
    this(opensimModelJNI.new_CoordinateSet__SWIG_0(), true);
  }

  public CoordinateSet(CoordinateSet aCoordinateSet) {
    this(opensimModelJNI.new_CoordinateSet__SWIG_1(CoordinateSet.getCPtr(aCoordinateSet), aCoordinateSet), true);
  }

}
