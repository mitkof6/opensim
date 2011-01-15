/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.37
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.opensim.modeling;

public class StateVector {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  public StateVector(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  public static long getCPtr(StateVector obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if(swigCPtr != 0 && swigCMemOwn) {
      swigCMemOwn = false;
      opensimModelJNI.delete_StateVector(swigCPtr);
    }
    swigCPtr = 0;
  }

  public StateVector(double aT, int aN, SWIGTYPE_p_double aData) {
    this(opensimModelJNI.new_StateVector__SWIG_0(aT, aN, SWIGTYPE_p_double.getCPtr(aData)), true);
  }

  public StateVector(double aT, int aN) {
    this(opensimModelJNI.new_StateVector__SWIG_1(aT, aN), true);
  }

  public StateVector(double aT) {
    this(opensimModelJNI.new_StateVector__SWIG_2(aT), true);
  }

  public StateVector() {
    this(opensimModelJNI.new_StateVector__SWIG_3(), true);
  }

  public StateVector(StateVector aVector) {
    this(opensimModelJNI.new_StateVector__SWIG_4(StateVector.getCPtr(aVector), aVector), true);
  }

  public void setStates(double aT, int aN, double[] aY) {
    opensimModelJNI.StateVector_setStates(swigCPtr, this, aT, aN, aY);
  }

  public int getSize() {
    return opensimModelJNI.StateVector_getSize(swigCPtr, this);
  }

  public void setTime(double aT) {
    opensimModelJNI.StateVector_setTime(swigCPtr, this, aT);
  }

  public double getTime() {
    return opensimModelJNI.StateVector_getTime(swigCPtr, this);
  }

  public int getDataValue(int aIndex, SWIGTYPE_p_double rValue) {
    return opensimModelJNI.StateVector_getDataValue(swigCPtr, this, aIndex, SWIGTYPE_p_double.getCPtr(rValue));
  }

  public void setDataValue(int aIndex, SWIGTYPE_p_double aValue) {
    opensimModelJNI.StateVector_setDataValue(swigCPtr, this, aIndex, SWIGTYPE_p_double.getCPtr(aValue));
  }

  public ArrayDouble getData() {
    return new ArrayDouble(opensimModelJNI.StateVector_getData(swigCPtr, this), false);
  }

  public void shiftTime(double aValue) {
    opensimModelJNI.StateVector_shiftTime(swigCPtr, this, aValue);
  }

  public void scaleTime(double aValue) {
    opensimModelJNI.StateVector_scaleTime(swigCPtr, this, aValue);
  }

  public void add(double aValue) {
    opensimModelJNI.StateVector_add__SWIG_0(swigCPtr, this, aValue);
  }

  public void add(int aN, double[] aY) {
    opensimModelJNI.StateVector_add__SWIG_1(swigCPtr, this, aN, aY);
  }

  public void add(int aN, double aValue) {
    opensimModelJNI.StateVector_add__SWIG_2(swigCPtr, this, aN, aValue);
  }

  public void add(StateVector aStateVector) {
    opensimModelJNI.StateVector_add__SWIG_3(swigCPtr, this, StateVector.getCPtr(aStateVector), aStateVector);
  }

  public void subtract(double aValue) {
    opensimModelJNI.StateVector_subtract__SWIG_0(swigCPtr, this, aValue);
  }

  public void subtract(int aN, double[] aY) {
    opensimModelJNI.StateVector_subtract__SWIG_1(swigCPtr, this, aN, aY);
  }

  public void subtract(StateVector aStateVector) {
    opensimModelJNI.StateVector_subtract__SWIG_2(swigCPtr, this, StateVector.getCPtr(aStateVector), aStateVector);
  }

  public void multiply(double aValue) {
    opensimModelJNI.StateVector_multiply__SWIG_0(swigCPtr, this, aValue);
  }

  public void multiply(int aN, double[] aY) {
    opensimModelJNI.StateVector_multiply__SWIG_1(swigCPtr, this, aN, aY);
  }

  public void multiply(StateVector aStateVector) {
    opensimModelJNI.StateVector_multiply__SWIG_2(swigCPtr, this, StateVector.getCPtr(aStateVector), aStateVector);
  }

  public void divide(double aValue) {
    opensimModelJNI.StateVector_divide__SWIG_0(swigCPtr, this, aValue);
  }

  public void divide(int aN, double[] aY) {
    opensimModelJNI.StateVector_divide__SWIG_1(swigCPtr, this, aN, aY);
  }

  public void divide(StateVector aStateVector) {
    opensimModelJNI.StateVector_divide__SWIG_2(swigCPtr, this, StateVector.getCPtr(aStateVector), aStateVector);
  }

  public void print() {
    opensimModelJNI.StateVector_print__SWIG_0(swigCPtr, this);
  }

  public int print(SWIGTYPE_p_FILE fp) {
    return opensimModelJNI.StateVector_print__SWIG_1(swigCPtr, this, SWIGTYPE_p_FILE.getCPtr(fp));
  }

}
