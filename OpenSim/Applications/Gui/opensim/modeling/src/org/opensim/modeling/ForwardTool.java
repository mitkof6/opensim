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

  public void updateFromXMLNode() {
    opensimModelJNI.ForwardTool_updateFromXMLNode(swigCPtr, this);
  }

  public void setManager(Manager m) {
    opensimModelJNI.ForwardTool_setManager(swigCPtr, this, Manager.getCPtr(m), m);
  }

  public Manager getManager() {
    return new Manager(opensimModelJNI.ForwardTool_getManager(swigCPtr, this), false);
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

  public double getLowpassCutoffFrequencyForLoadKinematics() {
    return opensimModelJNI.ForwardTool_getLowpassCutoffFrequencyForLoadKinematics(swigCPtr, this);
  }

  public void setLowpassCutoffFrequencyForLoadKinematics(double aLowpassCutoffFrequency) {
    opensimModelJNI.ForwardTool_setLowpassCutoffFrequencyForLoadKinematics(swigCPtr, this, aLowpassCutoffFrequency);
  }

  public void setPrintResultFiles(boolean aToWrite) {
    opensimModelJNI.ForwardTool_setPrintResultFiles(swigCPtr, this, aToWrite);
  }

  public boolean run() throws java.io.IOException {
    return opensimModelJNI.ForwardTool_run(swigCPtr, this);
  }

  public void printResults() {
    opensimModelJNI.ForwardTool_printResults(swigCPtr, this);
  }

  public static double Step(double t, double t0, double t1) {
    return opensimModelJNI.ForwardTool_Step(t, t0, t1);
  }

  public static double SigmaUp(double tau, double to, double t) {
    return opensimModelJNI.ForwardTool_SigmaUp(tau, to, t);
  }

  public static double SigmaDn(double tau, double to, double t) {
    return opensimModelJNI.ForwardTool_SigmaDn(tau, to, t);
  }

  public void loadStatesStorage(SWIGTYPE_p_std__string statesFileName, Storage rYStore) {
    opensimModelJNI.ForwardTool_loadStatesStorage(swigCPtr, this, SWIGTYPE_p_std__string.getCPtr(statesFileName), Storage.getCPtr(rYStore));
  }

  public String getParsingLog() {
    return opensimModelJNI.ForwardTool_getParsingLog(swigCPtr, this);
  }

}
