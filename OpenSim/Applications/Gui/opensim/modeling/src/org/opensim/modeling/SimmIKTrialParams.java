/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.29
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.opensim.modeling;

public class SimmIKTrialParams extends OpenSimObject {
  private long swigCPtr;

  protected SimmIKTrialParams(long cPtr, boolean cMemoryOwn) {
    super(opensimModelJNI.SWIGSimmIKTrialParamsUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  protected static long getCPtr(SimmIKTrialParams obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public void delete() {
    if(swigCPtr != 0 && swigCMemOwn) {
      swigCMemOwn = false;
      opensimModelJNI.delete_SimmIKTrialParams(swigCPtr);
    }
    swigCPtr = 0;
    super.delete();
  }

  public SimmIKTrialParams() {
    this(opensimModelJNI.new_SimmIKTrialParams__SWIG_0(), true);
  }

  public SimmIKTrialParams(SWIGTYPE_p_DOMElement aElement) {
    this(opensimModelJNI.new_SimmIKTrialParams__SWIG_1(SWIGTYPE_p_DOMElement.getCPtr(aElement)), true);
  }

  public SimmIKTrialParams(SimmIKTrialParams aIKTrialParams) {
    this(opensimModelJNI.new_SimmIKTrialParams__SWIG_2(SimmIKTrialParams.getCPtr(aIKTrialParams)), true);
  }

  public OpenSimObject copy() {
    long cPtr = opensimModelJNI.SimmIKTrialParams_copy__SWIG_0(swigCPtr);
    return (cPtr == 0) ? null : new OpenSimObject(cPtr, false);
  }

  public OpenSimObject copy(SWIGTYPE_p_DOMElement aElement) {
    long cPtr = opensimModelJNI.SimmIKTrialParams_copy__SWIG_1(swigCPtr, SWIGTYPE_p_DOMElement.getCPtr(aElement));
    return (cPtr == 0) ? null : new OpenSimObject(cPtr, false);
  }

  public void copyData(SimmIKTrialParams aIKTrialParams) {
    opensimModelJNI.SimmIKTrialParams_copyData(swigCPtr, SimmIKTrialParams.getCPtr(aIKTrialParams));
  }

  public double getStartTime() {
    return opensimModelJNI.SimmIKTrialParams_getStartTime(swigCPtr);
  }

  public double getEndTime() {
    return opensimModelJNI.SimmIKTrialParams_getEndTime(swigCPtr);
  }

  public double getKinematicsSmoothing() {
    return opensimModelJNI.SimmIKTrialParams_getKinematicsSmoothing(swigCPtr);
  }

  public double getGroundReactionSmoothing() {
    return opensimModelJNI.SimmIKTrialParams_getGroundReactionSmoothing(swigCPtr);
  }

  public boolean getIncludeMarkers() {
    return opensimModelJNI.SimmIKTrialParams_getIncludeMarkers(swigCPtr);
  }

  public void setStartTime(double aTime) {
    opensimModelJNI.SimmIKTrialParams_setStartTime(swigCPtr, aTime);
  }

  public void setEndTime(double aTime) {
    opensimModelJNI.SimmIKTrialParams_setEndTime(swigCPtr, aTime);
  }

  public void setIncludeMarkers(boolean aValue) {
    opensimModelJNI.SimmIKTrialParams_setIncludeMarkers(swigCPtr, aValue);
  }

  public void findFrameRange(Storage aData, SWIGTYPE_p_int oStartFrame, SWIGTYPE_p_int oEndFrame) {
    opensimModelJNI.SimmIKTrialParams_findFrameRange(swigCPtr, Storage.getCPtr(aData), SWIGTYPE_p_int.getCPtr(oStartFrame), SWIGTYPE_p_int.getCPtr(oEndFrame));
  }

  public SimmMotionData getCoordinateValues(SimmModel aModel) {
    long cPtr = opensimModelJNI.SimmIKTrialParams_getCoordinateValues(swigCPtr, SimmModel.getCPtr(aModel));
    return (cPtr == 0) ? null : new SimmMotionData(cPtr, false);
  }

  public void peteTest() {
    opensimModelJNI.SimmIKTrialParams_peteTest(swigCPtr);
  }

  public String getMarkerDataFilename() {
    return opensimModelJNI.SimmIKTrialParams_getMarkerDataFilename(swigCPtr);
  }

  public String getOutputMotionFilename() {
    return opensimModelJNI.SimmIKTrialParams_getOutputMotionFilename(swigCPtr);
  }

}
