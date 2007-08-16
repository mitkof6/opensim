/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.31
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.opensim.modeling;

public class IKSolverInterface {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  public IKSolverInterface(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  public static long getCPtr(IKSolverInterface obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if(swigCPtr != 0 && swigCMemOwn) {
      swigCMemOwn = false;
      opensimModelJNI.delete_IKSolverInterface(swigCPtr);
    }
    swigCPtr = 0;
  }

  public IKSolverInterface(SWIGTYPE_p_OpenSim__IKTarget aOptimizationTarget) {
    this(opensimModelJNI.new_IKSolverInterface(SWIGTYPE_p_OpenSim__IKTarget.getCPtr(aOptimizationTarget)), true);
  }

  public void initializeSolver(IKTrial aIKOptions, Storage inputData, Storage outputData) {
    opensimModelJNI.IKSolverInterface_initializeSolver(swigCPtr, this, IKTrial.getCPtr(aIKOptions), aIKOptions, Storage.getCPtr(inputData), inputData, Storage.getCPtr(outputData), outputData);
  }

  public void solveFrames(IKTrial aIKOptions, Storage inputData, Storage outputData) {
    opensimModelJNI.IKSolverInterface_solveFrames(swigCPtr, this, IKTrial.getCPtr(aIKOptions), aIKOptions, Storage.getCPtr(inputData), inputData, Storage.getCPtr(outputData), outputData);
  }

  public void interrupt() {
    opensimModelJNI.IKSolverInterface_interrupt(swigCPtr, this);
  }

}
