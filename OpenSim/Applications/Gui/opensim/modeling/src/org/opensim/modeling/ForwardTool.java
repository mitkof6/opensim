/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.31
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.opensim.modeling;

public class ForwardTool extends AbstractTool {
  private long swigCPtr;

  public ForwardTool(long cPtr, boolean cMemoryOwn) {
    super(opensimModelJNI.SWIGStorageUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  public static long getCPtr(ForwardTool obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if(swigCPtr != 0 && swigCMemOwn) {
      swigCMemOwn = false;
      opensimModelJNI.delete_ForwardTool(swigCPtr);
    }
    swigCPtr = 0;
    super.delete();
  }

  public ForwardTool() {
    this(opensimModelJNI.new_ForwardTool__SWIG_0(), true);
  }

  public ForwardTool(String aFileName, boolean aUpdateFromXMLNode, boolean aLoadModel) throws java.io.IOException {
    this(opensimModelJNI.new_ForwardTool__SWIG_1(aFileName, aUpdateFromXMLNode, aLoadModel), true);
  }

  public ForwardTool(String aFileName, boolean aUpdateFromXMLNode) throws java.io.IOException {
    this(opensimModelJNI.new_ForwardTool__SWIG_2(aFileName, aUpdateFromXMLNode), true);
  }

  public ForwardTool(String aFileName) throws java.io.IOException {
    this(opensimModelJNI.new_ForwardTool__SWIG_3(aFileName), true);
  }

  public ForwardTool(ForwardTool aObject) {
    this(opensimModelJNI.new_ForwardTool__SWIG_4(ForwardTool.getCPtr(aObject), aObject), true);
  }

  public OpenSimObject copy() {
    long cPtr = opensimModelJNI.ForwardTool_copy(swigCPtr, this);
    return (cPtr == 0) ? null : new OpenSimObject(cPtr, false);
  }

  public String getControlsFileName() {
    return opensimModelJNI.ForwardTool_getControlsFileName(swigCPtr, this);
  }

  public void setControlsFileName(String aFileName) {
    opensimModelJNI.ForwardTool_setControlsFileName(swigCPtr, this, aFileName);
  }

  public String getStatesFileName() {
    return opensimModelJNI.ForwardTool_getStatesFileName(swigCPtr, this);
  }

  public void setStatesFileName(String aFileName) {
    opensimModelJNI.ForwardTool_setStatesFileName(swigCPtr, this, aFileName);
  }

  public boolean getUseSpecifiedDt() {
    return opensimModelJNI.ForwardTool_getUseSpecifiedDt(swigCPtr, this);
  }

  public void setUseSpecifiedDt(boolean aUseSpecifiedDt) {
    opensimModelJNI.ForwardTool_setUseSpecifiedDt(swigCPtr, this, aUseSpecifiedDt);
  }

  public String getExternalLoadsFileName() {
    return opensimModelJNI.ForwardTool_getExternalLoadsFileName(swigCPtr, this);
  }

  public void setExternalLoadsFileName(String aFileName) {
    opensimModelJNI.ForwardTool_setExternalLoadsFileName(swigCPtr, this, aFileName);
  }

  public String getExternalLoadsModelKinematicsFileName() {
    return opensimModelJNI.ForwardTool_getExternalLoadsModelKinematicsFileName(swigCPtr, this);
  }

  public void setExternalLoadsModelKinematicsFileName(String aFileName) {
    opensimModelJNI.ForwardTool_setExternalLoadsModelKinematicsFileName(swigCPtr, this, aFileName);
  }

  public String getExternalLoadsBody1() {
    return opensimModelJNI.ForwardTool_getExternalLoadsBody1(swigCPtr, this);
  }

  public void setExternalLoadsBody1(String aName) {
    opensimModelJNI.ForwardTool_setExternalLoadsBody1(swigCPtr, this, aName);
  }

  public String getExternalLoadsBody2() {
    return opensimModelJNI.ForwardTool_getExternalLoadsBody2(swigCPtr, this);
  }

  public void setExternalLoadsBody2(String aName) {
    opensimModelJNI.ForwardTool_setExternalLoadsBody2(swigCPtr, this, aName);
  }

  public double getLowpassCutoffFrequencyForLoadKinematics() {
    return opensimModelJNI.ForwardTool_getLowpassCutoffFrequencyForLoadKinematics(swigCPtr, this);
  }

  public void setLowpassCutoffFrequencyForLoadKinematics(double aLowpassCutoffFrequency) {
    opensimModelJNI.ForwardTool_setLowpassCutoffFrequencyForLoadKinematics(swigCPtr, this, aLowpassCutoffFrequency);
  }

  public void setPrintResultFiles(boolean aToWrite) {
    opensimModelJNI.ForwardTool_setPrintResultFiles(swigCPtr, this, aToWrite);
  }

  public Storage getStateStorage() {
    long cPtr = opensimModelJNI.ForwardTool_getStateStorage(swigCPtr, this);
    return (cPtr == 0) ? null : new Storage(cPtr, false);
  }

  public boolean run() throws java.io.IOException {
    return opensimModelJNI.ForwardTool_run(swigCPtr, this);
  }

  public void printResults() {
    opensimModelJNI.ForwardTool_printResults(swigCPtr, this);
  }

  public static void initializeExternalLoads(Model aModel, String aExternalLoadsFileName, String aExternalLoadsModelKinematicsFileName, String aExternalLoadsBody1, String aExternalLoadsBody2, double aLowpassCutoffFrequencyForLoadKinematics, SWIGTYPE_p_p_OpenSim__ForceApplier rRightForceApp, SWIGTYPE_p_p_OpenSim__ForceApplier rLeftForceApp, SWIGTYPE_p_p_OpenSim__TorqueApplier rRightTorqueApp, SWIGTYPE_p_p_OpenSim__TorqueApplier rLeftTorqueApp) {
    opensimModelJNI.ForwardTool_initializeExternalLoads__SWIG_0(Model.getCPtr(aModel), aModel, aExternalLoadsFileName, aExternalLoadsModelKinematicsFileName, aExternalLoadsBody1, aExternalLoadsBody2, aLowpassCutoffFrequencyForLoadKinematics, SWIGTYPE_p_p_OpenSim__ForceApplier.getCPtr(rRightForceApp), SWIGTYPE_p_p_OpenSim__ForceApplier.getCPtr(rLeftForceApp), SWIGTYPE_p_p_OpenSim__TorqueApplier.getCPtr(rRightTorqueApp), SWIGTYPE_p_p_OpenSim__TorqueApplier.getCPtr(rLeftTorqueApp));
  }

  public static void initializeExternalLoads(Model aModel, String aExternalLoadsFileName, String aExternalLoadsModelKinematicsFileName, String aExternalLoadsBody1, String aExternalLoadsBody2, double aLowpassCutoffFrequencyForLoadKinematics, SWIGTYPE_p_p_OpenSim__ForceApplier rRightForceApp, SWIGTYPE_p_p_OpenSim__ForceApplier rLeftForceApp, SWIGTYPE_p_p_OpenSim__TorqueApplier rRightTorqueApp) {
    opensimModelJNI.ForwardTool_initializeExternalLoads__SWIG_1(Model.getCPtr(aModel), aModel, aExternalLoadsFileName, aExternalLoadsModelKinematicsFileName, aExternalLoadsBody1, aExternalLoadsBody2, aLowpassCutoffFrequencyForLoadKinematics, SWIGTYPE_p_p_OpenSim__ForceApplier.getCPtr(rRightForceApp), SWIGTYPE_p_p_OpenSim__ForceApplier.getCPtr(rLeftForceApp), SWIGTYPE_p_p_OpenSim__TorqueApplier.getCPtr(rRightTorqueApp));
  }

  public static void initializeExternalLoads(Model aModel, String aExternalLoadsFileName, String aExternalLoadsModelKinematicsFileName, String aExternalLoadsBody1, String aExternalLoadsBody2, double aLowpassCutoffFrequencyForLoadKinematics, SWIGTYPE_p_p_OpenSim__ForceApplier rRightForceApp, SWIGTYPE_p_p_OpenSim__ForceApplier rLeftForceApp) {
    opensimModelJNI.ForwardTool_initializeExternalLoads__SWIG_2(Model.getCPtr(aModel), aModel, aExternalLoadsFileName, aExternalLoadsModelKinematicsFileName, aExternalLoadsBody1, aExternalLoadsBody2, aLowpassCutoffFrequencyForLoadKinematics, SWIGTYPE_p_p_OpenSim__ForceApplier.getCPtr(rRightForceApp), SWIGTYPE_p_p_OpenSim__ForceApplier.getCPtr(rLeftForceApp));
  }

  public static void initializeExternalLoads(Model aModel, String aExternalLoadsFileName, String aExternalLoadsModelKinematicsFileName, String aExternalLoadsBody1, String aExternalLoadsBody2, double aLowpassCutoffFrequencyForLoadKinematics, SWIGTYPE_p_p_OpenSim__ForceApplier rRightForceApp) {
    opensimModelJNI.ForwardTool_initializeExternalLoads__SWIG_3(Model.getCPtr(aModel), aModel, aExternalLoadsFileName, aExternalLoadsModelKinematicsFileName, aExternalLoadsBody1, aExternalLoadsBody2, aLowpassCutoffFrequencyForLoadKinematics, SWIGTYPE_p_p_OpenSim__ForceApplier.getCPtr(rRightForceApp));
  }

  public static void initializeExternalLoads(Model aModel, String aExternalLoadsFileName, String aExternalLoadsModelKinematicsFileName, String aExternalLoadsBody1, String aExternalLoadsBody2, double aLowpassCutoffFrequencyForLoadKinematics) {
    opensimModelJNI.ForwardTool_initializeExternalLoads__SWIG_4(Model.getCPtr(aModel), aModel, aExternalLoadsFileName, aExternalLoadsModelKinematicsFileName, aExternalLoadsBody1, aExternalLoadsBody2, aLowpassCutoffFrequencyForLoadKinematics);
  }

}
