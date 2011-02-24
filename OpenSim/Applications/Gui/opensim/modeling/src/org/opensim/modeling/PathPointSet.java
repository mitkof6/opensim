/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.40
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.opensim.modeling;

public class PathPointSet extends SetPathPoint {
  private long swigCPtr;

  public PathPointSet(long cPtr, boolean cMemoryOwn) {
    super(opensimModelJNI.SWIGStorageUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  public static long getCPtr(PathPointSet obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        opensimModelJNI.delete_PathPointSet(swigCPtr);
      }
      swigCPtr = 0;
    }
    super.delete();
  }

  public PathPointSet() {
    this(opensimModelJNI.new_PathPointSet__SWIG_0(), true);
  }

  public PathPointSet(PathPointSet aPathPointSet) {
    this(opensimModelJNI.new_PathPointSet__SWIG_1(PathPointSet.getCPtr(aPathPointSet), aPathPointSet), true);
  }

}
