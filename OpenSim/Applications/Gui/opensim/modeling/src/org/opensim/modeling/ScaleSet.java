/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.29
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.opensim.modeling;

public class ScaleSet extends SetScales {
  private long swigCPtr;

  public ScaleSet(long cPtr, boolean cMemoryOwn) {
    super(opensimModelJNI.SWIGStorageUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  public static long getCPtr(ScaleSet obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public void delete() {
    if(swigCPtr != 0 && swigCMemOwn) {
      swigCMemOwn = false;
      opensimModelJNI.delete_ScaleSet(swigCPtr);
    }
    swigCPtr = 0;
    super.delete();
  }

  public ScaleSet() {
    this(opensimModelJNI.new_ScaleSet__SWIG_0(), true);
  }

  public ScaleSet(String scalesFileName) {
    this(opensimModelJNI.new_ScaleSet__SWIG_1(scalesFileName), true);
  }

}
