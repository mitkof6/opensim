/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.31
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.opensim.modeling;

public class IKSolverImpl extends IKSolverInterface {
  private long swigCPtr;

  public IKSolverImpl(long cPtr, boolean cMemoryOwn) {
    super(opensimModelJNI.SWIGStorageUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  public static long getCPtr(IKSolverImpl obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if(swigCPtr != 0 && swigCMemOwn) {
      swigCMemOwn = false;
      opensimModelJNI.delete_IKSolverImpl(swigCPtr);
    }
    swigCPtr = 0;
    super.delete();
  }

  public IKSolverImpl(SWIGTYPE_p_OpenSim__IKTarget aOptimizationTarget) {
    this(opensimModelJNI.new_IKSolverImpl(SWIGTYPE_p_OpenSim__IKTarget.getCPtr(aOptimizationTarget)), true);
  }

  public void initializeSolver(IKTrial aIKOptions, Storage inputData, Storage outputData) {
    opensimModelJNI.IKSolverImpl_initializeSolver(swigCPtr, this, IKTrial.getCPtr(aIKOptions), aIKOptions, Storage.getCPtr(inputData), inputData, Storage.getCPtr(outputData), outputData);
  }

  public void solveFrames(IKTrial aIKOptions, Storage inputData, Storage outputData) {
    opensimModelJNI.IKSolverImpl_solveFrames(swigCPtr, this, IKTrial.getCPtr(aIKOptions), aIKOptions, Storage.getCPtr(inputData), inputData, Storage.getCPtr(outputData), outputData);
  }

  public void interrupt() {
    opensimModelJNI.IKSolverImpl_interrupt(swigCPtr, this);
  }

}
