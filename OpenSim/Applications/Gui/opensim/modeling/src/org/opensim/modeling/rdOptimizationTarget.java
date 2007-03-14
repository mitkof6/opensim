/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.31
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.opensim.modeling;

public class rdOptimizationTarget {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  public rdOptimizationTarget(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  public static long getCPtr(rdOptimizationTarget obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if(swigCPtr != 0 && swigCMemOwn) {
      swigCMemOwn = false;
      opensimModelJNI.delete_rdOptimizationTarget(swigCPtr);
    }
    swigCPtr = 0;
  }

  public static double getSMALLDX() {
    return opensimModelJNI.rdOptimizationTarget_SMALLDX_get();
  }

  public int compute(SWIGTYPE_p_double x, SWIGTYPE_p_double p, SWIGTYPE_p_double c) {
    return opensimModelJNI.rdOptimizationTarget_compute(swigCPtr, this, SWIGTYPE_p_double.getCPtr(x), SWIGTYPE_p_double.getCPtr(p), SWIGTYPE_p_double.getCPtr(c));
  }

  public int computeGradients(SWIGTYPE_p_double dx, SWIGTYPE_p_double x, SWIGTYPE_p_double dpdx, SWIGTYPE_p_double dcdx) {
    return opensimModelJNI.rdOptimizationTarget_computeGradients(swigCPtr, this, SWIGTYPE_p_double.getCPtr(dx), SWIGTYPE_p_double.getCPtr(x), SWIGTYPE_p_double.getCPtr(dpdx), SWIGTYPE_p_double.getCPtr(dcdx));
  }

  public int computePerformance(SWIGTYPE_p_double x, SWIGTYPE_p_double p) {
    return opensimModelJNI.rdOptimizationTarget_computePerformance(swigCPtr, this, SWIGTYPE_p_double.getCPtr(x), SWIGTYPE_p_double.getCPtr(p));
  }

  public int computePerformanceGradient(SWIGTYPE_p_double x, SWIGTYPE_p_double dpdx) {
    return opensimModelJNI.rdOptimizationTarget_computePerformanceGradient(swigCPtr, this, SWIGTYPE_p_double.getCPtr(x), SWIGTYPE_p_double.getCPtr(dpdx));
  }

  public int computeConstraint(SWIGTYPE_p_double x, int i, SWIGTYPE_p_double c) {
    return opensimModelJNI.rdOptimizationTarget_computeConstraint(swigCPtr, this, SWIGTYPE_p_double.getCPtr(x), i, SWIGTYPE_p_double.getCPtr(c));
  }

  public int computeConstraintGradient(SWIGTYPE_p_double x, int i, SWIGTYPE_p_double dcdx) {
    return opensimModelJNI.rdOptimizationTarget_computeConstraintGradient(swigCPtr, this, SWIGTYPE_p_double.getCPtr(x), i, SWIGTYPE_p_double.getCPtr(dcdx));
  }

  public void setNumControls(int aNX) {
    opensimModelJNI.rdOptimizationTarget_setNumControls(swigCPtr, this, aNX);
  }

  public int getNumControls() {
    return opensimModelJNI.rdOptimizationTarget_getNumControls(swigCPtr, this);
  }

  public void setDX(double aVal) {
    opensimModelJNI.rdOptimizationTarget_setDX__SWIG_0(swigCPtr, this, aVal);
  }

  public void setDX(int aIndex, double aVal) {
    opensimModelJNI.rdOptimizationTarget_setDX__SWIG_1(swigCPtr, this, aIndex, aVal);
  }

  public double getDX(int aIndex) {
    return opensimModelJNI.rdOptimizationTarget_getDX(swigCPtr, this, aIndex);
  }

  public SWIGTYPE_p_double getDXArray() {
    long cPtr = opensimModelJNI.rdOptimizationTarget_getDXArray(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_double(cPtr, false);
  }

  public void setNEvaluations(int aN) {
    opensimModelJNI.rdOptimizationTarget_setNEvaluations__SWIG_0(swigCPtr, this, aN);
  }

  public void setNEvaluations() {
    opensimModelJNI.rdOptimizationTarget_setNEvaluations__SWIG_1(swigCPtr, this);
  }

  public int getNEvaluations() {
    return opensimModelJNI.rdOptimizationTarget_getNEvaluations(swigCPtr, this);
  }

  public int getNumContacts() {
    return opensimModelJNI.rdOptimizationTarget_getNumContacts(swigCPtr, this);
  }

  public int getNC() {
    return opensimModelJNI.rdOptimizationTarget_getNC(swigCPtr, this);
  }

  public int getNCInequality() {
    return opensimModelJNI.rdOptimizationTarget_getNCInequality(swigCPtr, this);
  }

  public int getNCInequalityNonlinear() {
    return opensimModelJNI.rdOptimizationTarget_getNCInequalityNonlinear(swigCPtr, this);
  }

  public int getNCInequalityLinear() {
    return opensimModelJNI.rdOptimizationTarget_getNCInequalityLinear(swigCPtr, this);
  }

  public int getNCEquality() {
    return opensimModelJNI.rdOptimizationTarget_getNCEquality(swigCPtr, this);
  }

  public int getNCEqualityNonlinear() {
    return opensimModelJNI.rdOptimizationTarget_getNCEqualityNonlinear(swigCPtr, this);
  }

  public int getNCEqualityLinear() {
    return opensimModelJNI.rdOptimizationTarget_getNCEqualityLinear(swigCPtr, this);
  }

  public boolean isControlIndexValid(int aIndex) {
    return opensimModelJNI.rdOptimizationTarget_isControlIndexValid(swigCPtr, this, aIndex);
  }

  public void validatePerturbationSize(SWIGTYPE_p_double aSize) {
    opensimModelJNI.rdOptimizationTarget_validatePerturbationSize(swigCPtr, this, SWIGTYPE_p_double.getCPtr(aSize));
  }

}
