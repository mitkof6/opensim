/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.31
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.opensim.modeling;

public class AbstractTool extends OpenSimObject {
  private long swigCPtr;

  public AbstractTool(long cPtr, boolean cMemoryOwn) {
    super(opensimModelJNI.SWIGStorageUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  public static long getCPtr(AbstractTool obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if(swigCPtr != 0 && swigCMemOwn) {
      swigCMemOwn = false;
      opensimModelJNI.delete_AbstractTool(swigCPtr);
    }
    swigCPtr = 0;
    super.delete();
  }

  public static boolean isKindOf(String type) {
    return opensimModelJNI.AbstractTool_isKindOf(type);
  }

  public boolean isA(String type) {
    return opensimModelJNI.AbstractTool_isA(swigCPtr, this, type);
  }

  public static AbstractTool safeDownCast(OpenSimObject obj) {
    long cPtr = opensimModelJNI.AbstractTool_safeDownCast(OpenSimObject.getCPtr(obj), obj);
    return (cPtr == 0) ? null : new AbstractTool(cPtr, false);
  }

  public void copy(OpenSimObject aObject) {
    opensimModelJNI.AbstractTool_copy(swigCPtr, this, OpenSimObject.getCPtr(aObject), aObject);
  }

  public void setModel(Model aModel) throws java.io.IOException {
    opensimModelJNI.AbstractTool_setModel(swigCPtr, this, Model.getCPtr(aModel), aModel);
  }

  public Model getModel() {
    return new Model(opensimModelJNI.AbstractTool_getModel(swigCPtr, this), false);
  }

  public boolean getReplaceForceSet() {
    return opensimModelJNI.AbstractTool_getReplaceForceSet(swigCPtr, this);
  }

  public void setReplaceForceSet(boolean aReplace) {
    opensimModelJNI.AbstractTool_setReplaceForceSet(swigCPtr, this, aReplace);
  }

  public String getNextAvailableForceName(String prefix) {
    return opensimModelJNI.AbstractTool_getNextAvailableForceName__SWIG_0(swigCPtr, this, prefix);
  }

  public String getNextAvailableForceName() {
    return opensimModelJNI.AbstractTool_getNextAvailableForceName__SWIG_1(swigCPtr, this);
  }

  public ForceSet getExternalForceSet() {
    return new ForceSet(opensimModelJNI.AbstractTool_getExternalForceSet(swigCPtr, this), false);
  }

  public ForceSet updExternalForceSet() {
    return new ForceSet(opensimModelJNI.AbstractTool_updExternalForceSet(swigCPtr, this), false);
  }

  public ArrayStr getForceSetFiles() {
    return new ArrayStr(opensimModelJNI.AbstractTool_getForceSetFiles(swigCPtr, this), false);
  }

  public void setForceSetFiles(ArrayStr aForceSetFiles) {
    opensimModelJNI.AbstractTool_setForceSetFiles(swigCPtr, this, ArrayStr.getCPtr(aForceSetFiles), aForceSetFiles);
  }

  public int getOutputPrecision() {
    return opensimModelJNI.AbstractTool_getOutputPrecision(swigCPtr, this);
  }

  public void setOutputPrecision(int aPrecision) {
    opensimModelJNI.AbstractTool_setOutputPrecision(swigCPtr, this, aPrecision);
  }

  public AnalysisSet getAnalysisSet() {
    return new AnalysisSet(opensimModelJNI.AbstractTool_getAnalysisSet(swigCPtr, this), false);
  }

  public String getResultsDir() {
    return opensimModelJNI.AbstractTool_getResultsDir(swigCPtr, this);
  }

  public void setResultsDir(String aString) {
    opensimModelJNI.AbstractTool_setResultsDir(swigCPtr, this, aString);
  }

  public double getInitialTime() {
    return opensimModelJNI.AbstractTool_getInitialTime(swigCPtr, this);
  }

  public double getFinalTime() {
    return opensimModelJNI.AbstractTool_getFinalTime(swigCPtr, this);
  }

  public void setInitialTime(double aInitialTime) {
    opensimModelJNI.AbstractTool_setInitialTime(swigCPtr, this, aInitialTime);
  }

  public void setFinalTime(double aFinalTime) {
    opensimModelJNI.AbstractTool_setFinalTime(swigCPtr, this, aFinalTime);
  }

  public double getStartTime() {
    return opensimModelJNI.AbstractTool_getStartTime(swigCPtr, this);
  }

  public void setStartTime(double aStartTime) {
    opensimModelJNI.AbstractTool_setStartTime(swigCPtr, this, aStartTime);
  }

  public int getMaximumNumberOfSteps() {
    return opensimModelJNI.AbstractTool_getMaximumNumberOfSteps(swigCPtr, this);
  }

  public void setMaximumNumberOfSteps(int aMaxSteps) {
    opensimModelJNI.AbstractTool_setMaximumNumberOfSteps(swigCPtr, this, aMaxSteps);
  }

  public double getMaxDT() {
    return opensimModelJNI.AbstractTool_getMaxDT(swigCPtr, this);
  }

  public void setMaxDT(double aMaxDT) {
    opensimModelJNI.AbstractTool_setMaxDT(swigCPtr, this, aMaxDT);
  }

  public double getMinDT() {
    return opensimModelJNI.AbstractTool_getMinDT(swigCPtr, this);
  }

  public void setMinDT(double aMinDT) {
    opensimModelJNI.AbstractTool_setMinDT(swigCPtr, this, aMinDT);
  }

  public double getErrorTolerance() {
    return opensimModelJNI.AbstractTool_getErrorTolerance(swigCPtr, this);
  }

  public void setErrorTolerance(double aErrorTolerance) {
    opensimModelJNI.AbstractTool_setErrorTolerance(swigCPtr, this, aErrorTolerance);
  }

  public String getModelFilename() {
    return opensimModelJNI.AbstractTool_getModelFilename(swigCPtr, this);
  }

  public void setModelFilename(String aModelFile) {
    opensimModelJNI.AbstractTool_setModelFilename(swigCPtr, this, aModelFile);
  }

  public boolean getSolveForEquilibrium() {
    return opensimModelJNI.AbstractTool_getSolveForEquilibrium(swigCPtr, this);
  }

  public void setSolveForEquilibrium(boolean aSolve) {
    opensimModelJNI.AbstractTool_setSolveForEquilibrium(swigCPtr, this, aSolve);
  }

  public void loadModel(String aToolSetupFileName, ForceSet rOriginalForceSet) {
    opensimModelJNI.AbstractTool_loadModel__SWIG_0(swigCPtr, this, aToolSetupFileName, ForceSet.getCPtr(rOriginalForceSet), rOriginalForceSet);
  }

  public void loadModel(String aToolSetupFileName) {
    opensimModelJNI.AbstractTool_loadModel__SWIG_1(swigCPtr, this, aToolSetupFileName);
  }

  public void updateModelForces(Model model, String aToolSetupFileName, ForceSet rOriginalForceSet) throws java.io.IOException {
    opensimModelJNI.AbstractTool_updateModelForces__SWIG_0(swigCPtr, this, Model.getCPtr(model), model, aToolSetupFileName, ForceSet.getCPtr(rOriginalForceSet), rOriginalForceSet);
  }

  public void updateModelForces(Model model, String aToolSetupFileName) throws java.io.IOException {
    opensimModelJNI.AbstractTool_updateModelForces__SWIG_1(swigCPtr, this, Model.getCPtr(model), model, aToolSetupFileName);
  }

  public void addAnalysisSetToModel() {
    opensimModelJNI.AbstractTool_addAnalysisSetToModel(swigCPtr, this);
  }

  public void addControllerSetToModel() {
    opensimModelJNI.AbstractTool_addControllerSetToModel(swigCPtr, this);
  }

  public void removeControllerSetFromModel() {
    opensimModelJNI.AbstractTool_removeControllerSetFromModel(swigCPtr, this);
  }

  public void removeAnalysisSetFromModel() {
    opensimModelJNI.AbstractTool_removeAnalysisSetFromModel(swigCPtr, this);
  }

  public void setToolOwnsModel(boolean trueFalse) {
    opensimModelJNI.AbstractTool_setToolOwnsModel(swigCPtr, this, trueFalse);
  }

  public boolean getToolOwnsModel() {
    return opensimModelJNI.AbstractTool_getToolOwnsModel(swigCPtr, this);
  }

  public String getControlsFileName() {
    return opensimModelJNI.AbstractTool_getControlsFileName(swigCPtr, this);
  }

  public void setControlsFileName(String controlsFilename) {
    opensimModelJNI.AbstractTool_setControlsFileName(swigCPtr, this, controlsFilename);
  }

  public boolean run() throws java.io.IOException {
    return opensimModelJNI.AbstractTool_run(swigCPtr, this);
  }

  public void printResults(String aBaseName, String aDir, double aDT, String aExtension) {
    opensimModelJNI.AbstractTool_printResults__SWIG_0(swigCPtr, this, aBaseName, aDir, aDT, aExtension);
  }

  public void printResults(String aBaseName, String aDir, double aDT) {
    opensimModelJNI.AbstractTool_printResults__SWIG_1(swigCPtr, this, aBaseName, aDir, aDT);
  }

  public void printResults(String aBaseName, String aDir) {
    opensimModelJNI.AbstractTool_printResults__SWIG_2(swigCPtr, this, aBaseName, aDir);
  }

  public void printResults(String aBaseName) {
    opensimModelJNI.AbstractTool_printResults__SWIG_3(swigCPtr, this, aBaseName);
  }

  public boolean createExternalLoads(String aExternalLoadsFileName, String aExternalLoadsModelKinematicsFileName, Model aModel) {
    return opensimModelJNI.AbstractTool_createExternalLoads(swigCPtr, this, aExternalLoadsFileName, aExternalLoadsModelKinematicsFileName, Model.getCPtr(aModel), aModel);
  }

  public void updateFromXMLNode() {
    opensimModelJNI.AbstractTool_updateFromXMLNode(swigCPtr, this);
  }

  public void loadQStorage(String statesFileName, Storage rQStore) {
    opensimModelJNI.AbstractTool_loadQStorage(swigCPtr, this, statesFileName, Storage.getCPtr(rQStore), rQStore);
  }

}
