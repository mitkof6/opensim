/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.4
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.opensim.modeling;

public class ForceReporter extends Analysis {
  private long swigCPtr;

  public ForceReporter(long cPtr, boolean cMemoryOwn) {
    super(opensimModelJNI.ForceReporter_SWIGUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  public static long getCPtr(ForceReporter obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        opensimModelJNI.delete_ForceReporter(swigCPtr);
      }
      swigCPtr = 0;
    }
    super.delete();
  }

  public ForceReporter(Model aModel) {
    this(opensimModelJNI.new_ForceReporter__SWIG_0(Model.getCPtr(aModel), aModel), true);
  }

  public ForceReporter() {
    this(opensimModelJNI.new_ForceReporter__SWIG_1(), true);
  }

  public ForceReporter(String aFileName) {
    this(opensimModelJNI.new_ForceReporter__SWIG_2(aFileName), true);
  }

  public ForceReporter(ForceReporter aObject) {
    this(opensimModelJNI.new_ForceReporter__SWIG_3(ForceReporter.getCPtr(aObject), aObject), true);
  }

  public OpenSimObject copy() {
    long cPtr = opensimModelJNI.ForceReporter_copy(swigCPtr, this);
    return (cPtr == 0) ? null : new OpenSimObject(cPtr, false);
  }

  public Storage getForceStorage() {
    return new Storage(opensimModelJNI.ForceReporter_getForceStorage(swigCPtr, this), false);
  }

  public Storage updForceStorage() {
    return new Storage(opensimModelJNI.ForceReporter_updForceStorage(swigCPtr, this), false);
  }

  public void setModel(Model aModel) {
    opensimModelJNI.ForceReporter_setModel(swigCPtr, this, Model.getCPtr(aModel), aModel);
  }

  public void includeConstraintForces(boolean flag) {
    opensimModelJNI.ForceReporter_includeConstraintForces(swigCPtr, this, flag);
  }

  public int printResults(String aBaseName, String aDir, double aDT, String aExtension) {
    return opensimModelJNI.ForceReporter_printResults__SWIG_0(swigCPtr, this, aBaseName, aDir, aDT, aExtension);
  }

  public int printResults(String aBaseName, String aDir, double aDT) {
    return opensimModelJNI.ForceReporter_printResults__SWIG_1(swigCPtr, this, aBaseName, aDir, aDT);
  }

  public int printResults(String aBaseName, String aDir) {
    return opensimModelJNI.ForceReporter_printResults__SWIG_2(swigCPtr, this, aBaseName, aDir);
  }

  public int printResults(String aBaseName) {
    return opensimModelJNI.ForceReporter_printResults__SWIG_3(swigCPtr, this, aBaseName);
  }

}
