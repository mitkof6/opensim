/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.31
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.opensim.modeling;

public class SimmFileWriter {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  public SimmFileWriter(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  public static long getCPtr(SimmFileWriter obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if(swigCPtr != 0 && swigCMemOwn) {
      swigCMemOwn = false;
      opensimModelJNI.delete_SimmFileWriter(swigCPtr);
    }
    swigCPtr = 0;
  }

  public SimmFileWriter() {
    this(opensimModelJNI.new_SimmFileWriter__SWIG_0(), true);
  }

  public SimmFileWriter(AbstractModel aModel) {
    this(opensimModelJNI.new_SimmFileWriter__SWIG_1(AbstractModel.getCPtr(aModel), aModel), true);
  }

  public boolean writeJointFile(String aFileName) {
    return opensimModelJNI.SimmFileWriter_writeJointFile(swigCPtr, this, aFileName);
  }

  public boolean writeMuscleFile(String aFileName) {
    return opensimModelJNI.SimmFileWriter_writeMuscleFile(swigCPtr, this, aFileName);
  }

}
