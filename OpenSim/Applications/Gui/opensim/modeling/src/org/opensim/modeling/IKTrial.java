/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.31
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.opensim.modeling;

public class IKTrial extends OpenSimObject {
  private long swigCPtr;

  public IKTrial(long cPtr, boolean cMemoryOwn) {
    super(opensimModelJNI.SWIGStorageUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  public static long getCPtr(IKTrial obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if(swigCPtr != 0 && swigCMemOwn) {
      swigCMemOwn = false;
      opensimModelJNI.delete_IKTrial(swigCPtr);
    }
    swigCPtr = 0;
    super.delete();
  }

  public IKTrial() {
    this(opensimModelJNI.new_IKTrial__SWIG_0(), true);
  }

  public IKTrial(IKTrial aIKTrialParams) {
    this(opensimModelJNI.new_IKTrial__SWIG_1(IKTrial.getCPtr(aIKTrialParams), aIKTrialParams), true);
  }

  public OpenSimObject copy() {
    long cPtr = opensimModelJNI.IKTrial_copy(swigCPtr, this);
    return (cPtr == 0) ? null : new OpenSimObject(cPtr, false);
  }

  public void copyData(IKTrial aIKTrialParams) {
    opensimModelJNI.IKTrial_copyData(swigCPtr, this, IKTrial.getCPtr(aIKTrialParams), aIKTrialParams);
  }

  public double getKinematicsSmoothing() {
    return opensimModelJNI.IKTrial_getKinematicsSmoothing(swigCPtr, this);
  }

  public double getGroundReactionSmoothing() {
    return opensimModelJNI.IKTrial_getGroundReactionSmoothing(swigCPtr, this);
  }

  public boolean initializeTrialCommon(Model aModel, IKTaskSet aIKTaskSet, MarkerData aMarkerData) {
    return opensimModelJNI.IKTrial_initializeTrialCommon(swigCPtr, this, Model.getCPtr(aModel), aModel, IKTaskSet.getCPtr(aIKTaskSet), aIKTaskSet, MarkerData.getCPtr(aMarkerData), aMarkerData);
  }

  public boolean initializeTrial(Model aModel, IKTaskSet aIKTaskSet) {
    return opensimModelJNI.IKTrial_initializeTrial(swigCPtr, this, Model.getCPtr(aModel), aModel, IKTaskSet.getCPtr(aIKTaskSet), aIKTaskSet);
  }

  public boolean solveTrial(Model aModel, IKTaskSet aIKTaskSet) {
    return opensimModelJNI.IKTrial_solveTrial(swigCPtr, this, Model.getCPtr(aModel), aModel, IKTaskSet.getCPtr(aIKTaskSet), aIKTaskSet);
  }

  public void interrupt() {
    opensimModelJNI.IKTrial_interrupt(swigCPtr, this);
  }

  public double getStartTime() {
    return opensimModelJNI.IKTrial_getStartTime(swigCPtr, this);
  }

  public double getEndTime() {
    return opensimModelJNI.IKTrial_getEndTime(swigCPtr, this);
  }

  public void setStartTime(double aTime) {
    opensimModelJNI.IKTrial_setStartTime(swigCPtr, this, aTime);
  }

  public void setEndTime(double aTime) {
    opensimModelJNI.IKTrial_setEndTime(swigCPtr, this, aTime);
  }

  public int getStartFrame() {
    return opensimModelJNI.IKTrial_getStartFrame(swigCPtr, this);
  }

  public int getEndFrame() {
    return opensimModelJNI.IKTrial_getEndFrame(swigCPtr, this);
  }

  public boolean getIncludeMarkers() {
    return opensimModelJNI.IKTrial_getIncludeMarkers(swigCPtr, this);
  }

  public void setIncludeMarkers(boolean aValue) {
    opensimModelJNI.IKTrial_setIncludeMarkers(swigCPtr, this, aValue);
  }

  public String getMarkerDataFileName() {
    return opensimModelJNI.IKTrial_getMarkerDataFileName(swigCPtr, this);
  }

  public void setMarkerDataFileName(String aMarkerFileName) {
    opensimModelJNI.IKTrial_setMarkerDataFileName(swigCPtr, this, aMarkerFileName);
  }

  public String getOutputMotionFileName() {
    return opensimModelJNI.IKTrial_getOutputMotionFileName(swigCPtr, this);
  }

  public void setOutputMotionFileName(String aOutputMotionFileName) {
    opensimModelJNI.IKTrial_setOutputMotionFileName(swigCPtr, this, aOutputMotionFileName);
  }

  public String getCoordinateFileName() {
    return opensimModelJNI.IKTrial_getCoordinateFileName(swigCPtr, this);
  }

  public void setCoordinateFileName(String aFileName) {
    opensimModelJNI.IKTrial_setCoordinateFileName(swigCPtr, this, aFileName);
  }

  public void setOptimizerAlgorithm(String aOptimizerAlgorithm) {
    opensimModelJNI.IKTrial_setOptimizerAlgorithm(swigCPtr, this, aOptimizerAlgorithm);
  }

  public String getOptimizerAlgorithm() {
    return opensimModelJNI.IKTrial_getOptimizerAlgorithm(swigCPtr, this);
  }

  public Storage getOutputStorage() {
    long cPtr = opensimModelJNI.IKTrial_getOutputStorage(swigCPtr, this);
    return (cPtr == 0) ? null : new Storage(cPtr, false);
  }

  public void setPrintResultFiles(boolean aToWrite) {
    opensimModelJNI.IKTrial_setPrintResultFiles(swigCPtr, this, aToWrite);
  }

}
