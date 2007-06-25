/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.31
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.opensim.modeling;

public class Measurement extends OpenSimObject {
  private long swigCPtr;

  public Measurement(long cPtr, boolean cMemoryOwn) {
    super(opensimModelJNI.SWIGStorageUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  public static long getCPtr(Measurement obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if(swigCPtr != 0 && swigCMemOwn) {
      swigCMemOwn = false;
      opensimModelJNI.delete_Measurement(swigCPtr);
    }
    swigCPtr = 0;
    super.delete();
  }

  public Measurement() {
    this(opensimModelJNI.new_Measurement__SWIG_0(), true);
  }

  public Measurement(Measurement aMeasurement) {
    this(opensimModelJNI.new_Measurement__SWIG_1(Measurement.getCPtr(aMeasurement), aMeasurement), true);
  }

  public OpenSimObject copy() {
    long cPtr = opensimModelJNI.Measurement_copy(swigCPtr, this);
    return (cPtr == 0) ? null : new OpenSimObject(cPtr, false);
  }

  public void copyData(Measurement aMeasurement) {
    opensimModelJNI.Measurement_copyData(swigCPtr, this, Measurement.getCPtr(aMeasurement), aMeasurement);
  }

  public int getNumMarkerPairs() {
    return opensimModelJNI.Measurement_getNumMarkerPairs(swigCPtr, this);
  }

  public SWIGTYPE_p_MarkerPair getMarkerPair(int aIndex) {
    return new SWIGTYPE_p_MarkerPair(opensimModelJNI.Measurement_getMarkerPair(swigCPtr, this, aIndex), false);
  }

  public boolean getApply() {
    return opensimModelJNI.Measurement_getApply(swigCPtr, this);
  }

  public void applyScaleFactor(double aFactor, ScaleSet aScaleSet) {
    opensimModelJNI.Measurement_applyScaleFactor(swigCPtr, this, aFactor, ScaleSet.getCPtr(aScaleSet), aScaleSet);
  }

  public static void registerTypes() {
    opensimModelJNI.Measurement_registerTypes();
  }

}
