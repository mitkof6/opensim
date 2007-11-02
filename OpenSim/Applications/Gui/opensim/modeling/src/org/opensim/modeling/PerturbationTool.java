/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.31
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.opensim.modeling;

public class PerturbationTool extends ForwardTool {
  private long swigCPtr;

  public PerturbationTool(long cPtr, boolean cMemoryOwn) {
    super(opensimModelJNI.SWIGStorageUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  public static long getCPtr(PerturbationTool obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if(swigCPtr != 0 && swigCMemOwn) {
      swigCMemOwn = false;
      opensimModelJNI.delete_PerturbationTool(swigCPtr);
    }
    swigCPtr = 0;
    super.delete();
  }

  public PerturbationTool() {
    this(opensimModelJNI.new_PerturbationTool__SWIG_0(), true);
  }

  public PerturbationTool(String aFileName) {
    this(opensimModelJNI.new_PerturbationTool__SWIG_1(aFileName), true);
  }

  public PerturbationTool(PerturbationTool aObject) {
    this(opensimModelJNI.new_PerturbationTool__SWIG_2(PerturbationTool.getCPtr(aObject), aObject), true);
  }

  public OpenSimObject copy() {
    long cPtr = opensimModelJNI.PerturbationTool_copy(swigCPtr, this);
    return (cPtr == 0) ? null : new OpenSimObject(cPtr, false);
  }

  public boolean run() throws java.io.IOException {
    return opensimModelJNI.PerturbationTool_run(swigCPtr, this);
  }

  public void printResults(String aBaseName, String aDir, double aDT, String aExtension) {
    opensimModelJNI.PerturbationTool_printResults__SWIG_0(swigCPtr, this, aBaseName, aDir, aDT, aExtension);
  }

  public void printResults(String aBaseName, String aDir, double aDT) {
    opensimModelJNI.PerturbationTool_printResults__SWIG_1(swigCPtr, this, aBaseName, aDir, aDT);
  }

  public void printResults(String aBaseName, String aDir) {
    opensimModelJNI.PerturbationTool_printResults__SWIG_2(swigCPtr, this, aBaseName, aDir);
  }

  public void printResults(String aBaseName) {
    opensimModelJNI.PerturbationTool_printResults__SWIG_3(swigCPtr, this, aBaseName);
  }

}
