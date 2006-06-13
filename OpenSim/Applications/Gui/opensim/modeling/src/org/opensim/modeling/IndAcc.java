/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.29
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.opensim.modeling;

public class IndAcc extends Analysis {
  private long swigCPtr;

  protected IndAcc(long cPtr, boolean cMemoryOwn) {
    super(opensimModelJNI.SWIGIndAccUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  protected static long getCPtr(IndAcc obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public void delete() {
    if(swigCPtr != 0 && swigCMemOwn) {
      swigCMemOwn = false;
      opensimModelJNI.delete_IndAcc(swigCPtr);
    }
    swigCPtr = 0;
    super.delete();
  }

  public IndAcc(Model aModel) {
    this(opensimModelJNI.new_IndAcc__SWIG_0(Model.getCPtr(aModel)), true);
  }

  public IndAcc(Model aModel, Storage aStates, Storage aControls, String aBaseName, String aDir, String aExtension) {
    this(opensimModelJNI.new_IndAcc__SWIG_1(Model.getCPtr(aModel), Storage.getCPtr(aStates), Storage.getCPtr(aControls), aBaseName, aDir, aExtension), true);
  }

  public IndAcc(Model aModel, Storage aStates, Storage aControls, String aBaseName, String aDir) {
    this(opensimModelJNI.new_IndAcc__SWIG_2(Model.getCPtr(aModel), Storage.getCPtr(aStates), Storage.getCPtr(aControls), aBaseName, aDir), true);
  }

  public IndAcc(Model aModel, Storage aStates, Storage aControls, String aBaseName) {
    this(opensimModelJNI.new_IndAcc__SWIG_3(Model.getCPtr(aModel), Storage.getCPtr(aStates), Storage.getCPtr(aControls), aBaseName), true);
  }

  public int getNumComponents() {
    return opensimModelJNI.IndAcc_getNumComponents(swigCPtr);
  }

  public int getNumIndependentComponents() {
    return opensimModelJNI.IndAcc_getNumIndependentComponents(swigCPtr);
  }

  public int getNumElements() {
    return opensimModelJNI.IndAcc_getNumElements(swigCPtr);
  }

  public int getLastActuatorIndex() {
    return opensimModelJNI.IndAcc_getLastActuatorIndex(swigCPtr);
  }

  public int getGravityIndex() {
    return opensimModelJNI.IndAcc_getGravityIndex(swigCPtr);
  }

  public int getVelocityIndex() {
    return opensimModelJNI.IndAcc_getVelocityIndex(swigCPtr);
  }

  public int getInertialIndex() {
    return opensimModelJNI.IndAcc_getInertialIndex(swigCPtr);
  }

  public int getAllActuatorsIndex() {
    return opensimModelJNI.IndAcc_getAllActuatorsIndex(swigCPtr);
  }

  public int getAllIndex() {
    return opensimModelJNI.IndAcc_getAllIndex(swigCPtr);
  }

  public void setContactThreshold(double aThreshold) {
    opensimModelJNI.IndAcc_setContactThreshold(swigCPtr, aThreshold);
  }

  public double getContactThreshold() {
    return opensimModelJNI.IndAcc_getContactThreshold(swigCPtr);
  }

  public String getComponentName(int aC) {
    return opensimModelJNI.IndAcc_getComponentName(swigCPtr, aC);
  }

  public void setStorageCapacityIncrements(int aIncrement) {
    opensimModelJNI.IndAcc_setStorageCapacityIncrements(swigCPtr, aIncrement);
  }

  public SWIGTYPE_p_p_OpenSim__Storage getForceStorage() {
    long cPtr = opensimModelJNI.IndAcc_getForceStorage(swigCPtr);
    return (cPtr == 0) ? null : new SWIGTYPE_p_p_OpenSim__Storage(cPtr, false);
  }

  public boolean getUseNullDecomposition() {
    return opensimModelJNI.IndAcc_getUseNullDecomposition(swigCPtr);
  }

  public void setComputeNormalizedAccelerations(boolean aBool) {
    opensimModelJNI.IndAcc_setComputeNormalizedAccelerations(swigCPtr, aBool);
  }

  public boolean getComputeNormalizedAccelerations() {
    return opensimModelJNI.IndAcc_getComputeNormalizedAccelerations(swigCPtr);
  }

  public int computeAccelerations() {
    return opensimModelJNI.IndAcc_computeAccelerations(swigCPtr);
  }

  public void sumForceResults() {
    opensimModelJNI.IndAcc_sumForceResults(swigCPtr);
  }

  public void sumAccelerationResults() {
    opensimModelJNI.IndAcc_sumAccelerationResults(swigCPtr);
  }

  public void sumDecomposition() {
    opensimModelJNI.IndAcc_sumDecomposition(swigCPtr);
  }

  public void store() {
    opensimModelJNI.IndAcc_store(swigCPtr);
  }

  public int printResults(String aBaseName, String aDir, double aDT, String aExtension) {
    return opensimModelJNI.IndAcc_printResults__SWIG_0(swigCPtr, aBaseName, aDir, aDT, aExtension);
  }

  public int printResults(String aBaseName, String aDir, double aDT) {
    return opensimModelJNI.IndAcc_printResults__SWIG_1(swigCPtr, aBaseName, aDir, aDT);
  }

  public int printResults(String aBaseName, String aDir) {
    return opensimModelJNI.IndAcc_printResults__SWIG_2(swigCPtr, aBaseName, aDir);
  }

  public int printResults(String aBaseName) {
    return opensimModelJNI.IndAcc_printResults__SWIG_3(swigCPtr, aBaseName);
  }

}
