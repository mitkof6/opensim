/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.31
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.opensim.modeling;

public class AnalysisSet extends SetAnalysis {
  private long swigCPtr;

  public AnalysisSet(long cPtr, boolean cMemoryOwn) {
    super(opensimModelJNI.SWIGStorageUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  public static long getCPtr(AnalysisSet obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if(swigCPtr != 0 && swigCMemOwn) {
      swigCMemOwn = false;
      opensimModelJNI.delete_AnalysisSet(swigCPtr);
    }
    swigCPtr = 0;
    super.delete();
  }

  public AnalysisSet(AbstractModel aModel) {
    this(opensimModelJNI.new_AnalysisSet__SWIG_0(AbstractModel.getCPtr(aModel), aModel), true);
  }

  public AnalysisSet() {
    this(opensimModelJNI.new_AnalysisSet__SWIG_1(), true);
  }

  public AnalysisSet(String aFileName) {
    this(opensimModelJNI.new_AnalysisSet__SWIG_2(aFileName), true);
  }

  public AnalysisSet(AnalysisSet aSet) {
    this(opensimModelJNI.new_AnalysisSet__SWIG_3(AnalysisSet.getCPtr(aSet), aSet), true);
  }

  public OpenSimObject copy() {
    long cPtr = opensimModelJNI.AnalysisSet_copy(swigCPtr, this);
    return (cPtr == 0) ? null : new OpenSimObject(cPtr, false);
  }

  public void setModel(AbstractModel aModel) {
    opensimModelJNI.AnalysisSet_setModel(swigCPtr, this, AbstractModel.getCPtr(aModel), aModel);
  }

  public AbstractModel getModel() {
    long cPtr = opensimModelJNI.AnalysisSet_getModel(swigCPtr, this);
    return (cPtr == 0) ? null : new AbstractModel(cPtr, false);
  }

  public void setOn(boolean aTrueFalse) {
    opensimModelJNI.AnalysisSet_setOn(swigCPtr, this, aTrueFalse);
  }

  public void begin(int aStep, double aDT, double aT, SWIGTYPE_p_double aX, SWIGTYPE_p_double aY, SWIGTYPE_p_void aClientData) {
    opensimModelJNI.AnalysisSet_begin__SWIG_0(swigCPtr, this, aStep, aDT, aT, SWIGTYPE_p_double.getCPtr(aX), SWIGTYPE_p_double.getCPtr(aY), SWIGTYPE_p_void.getCPtr(aClientData));
  }

  public void begin(int aStep, double aDT, double aT, SWIGTYPE_p_double aX, SWIGTYPE_p_double aY) {
    opensimModelJNI.AnalysisSet_begin__SWIG_1(swigCPtr, this, aStep, aDT, aT, SWIGTYPE_p_double.getCPtr(aX), SWIGTYPE_p_double.getCPtr(aY));
  }

  public void step(SWIGTYPE_p_double aXPrev, SWIGTYPE_p_double aYPrev, int aStep, double aDT, double aT, SWIGTYPE_p_double aX, SWIGTYPE_p_double aY, SWIGTYPE_p_void aClientData) {
    opensimModelJNI.AnalysisSet_step__SWIG_0(swigCPtr, this, SWIGTYPE_p_double.getCPtr(aXPrev), SWIGTYPE_p_double.getCPtr(aYPrev), aStep, aDT, aT, SWIGTYPE_p_double.getCPtr(aX), SWIGTYPE_p_double.getCPtr(aY), SWIGTYPE_p_void.getCPtr(aClientData));
  }

  public void step(SWIGTYPE_p_double aXPrev, SWIGTYPE_p_double aYPrev, int aStep, double aDT, double aT, SWIGTYPE_p_double aX, SWIGTYPE_p_double aY) {
    opensimModelJNI.AnalysisSet_step__SWIG_1(swigCPtr, this, SWIGTYPE_p_double.getCPtr(aXPrev), SWIGTYPE_p_double.getCPtr(aYPrev), aStep, aDT, aT, SWIGTYPE_p_double.getCPtr(aX), SWIGTYPE_p_double.getCPtr(aY));
  }

  public void end(int aStep, double aDT, double aT, SWIGTYPE_p_double aX, SWIGTYPE_p_double aY, SWIGTYPE_p_void aClientData) {
    opensimModelJNI.AnalysisSet_end__SWIG_0(swigCPtr, this, aStep, aDT, aT, SWIGTYPE_p_double.getCPtr(aX), SWIGTYPE_p_double.getCPtr(aY), SWIGTYPE_p_void.getCPtr(aClientData));
  }

  public void end(int aStep, double aDT, double aT, SWIGTYPE_p_double aX, SWIGTYPE_p_double aY) {
    opensimModelJNI.AnalysisSet_end__SWIG_1(swigCPtr, this, aStep, aDT, aT, SWIGTYPE_p_double.getCPtr(aX), SWIGTYPE_p_double.getCPtr(aY));
  }

  public void printResults(String aBaseName, String aPath, double aDT, String aExtension) {
    opensimModelJNI.AnalysisSet_printResults__SWIG_0(swigCPtr, this, aBaseName, aPath, aDT, aExtension);
  }

  public void printResults(String aBaseName, String aPath, double aDT) {
    opensimModelJNI.AnalysisSet_printResults__SWIG_1(swigCPtr, this, aBaseName, aPath, aDT);
  }

  public void printResults(String aBaseName, String aPath) {
    opensimModelJNI.AnalysisSet_printResults__SWIG_2(swigCPtr, this, aBaseName, aPath);
  }

  public void printResults(String aBaseName) {
    opensimModelJNI.AnalysisSet_printResults__SWIG_3(swigCPtr, this, aBaseName);
  }

}
