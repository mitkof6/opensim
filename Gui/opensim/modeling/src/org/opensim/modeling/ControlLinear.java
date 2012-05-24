/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.4
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.opensim.modeling;

public class ControlLinear extends Control {
  private long swigCPtr;

  public ControlLinear(long cPtr, boolean cMemoryOwn) {
    super(opensimModelJNI.ControlLinear_SWIGUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  public static long getCPtr(ControlLinear obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        opensimModelJNI.delete_ControlLinear(swigCPtr);
      }
      swigCPtr = 0;
    }
    super.delete();
  }

  public static ControlLinear safeDownCast(OpenSimObject obj) {
    long cPtr = opensimModelJNI.ControlLinear_safeDownCast(OpenSimObject.getCPtr(obj), obj);
    return (cPtr == 0) ? null : new ControlLinear(cPtr, false);
  }

  public void assign(OpenSimObject aObject) {
    opensimModelJNI.ControlLinear_assign(swigCPtr, this, OpenSimObject.getCPtr(aObject), aObject);
  }

  public static String getClassName() {
    return opensimModelJNI.ControlLinear_getClassName();
  }

  public OpenSimObject clone() {
    long cPtr = opensimModelJNI.ControlLinear_clone(swigCPtr, this);
    return (cPtr == 0) ? null : new ControlLinear(cPtr, false);
  }

  public String getConcreteClassName() {
    return opensimModelJNI.ControlLinear_getConcreteClassName(swigCPtr, this);
  }

  public ControlLinear() {
    this(opensimModelJNI.new_ControlLinear__SWIG_0(), true);
  }

  public ControlLinear(ControlLinear aControl) {
    this(opensimModelJNI.new_ControlLinear__SWIG_1(ControlLinear.getCPtr(aControl), aControl), true);
  }

  public void copyData(ControlLinear aControl) {
    opensimModelJNI.ControlLinear_copyData(swigCPtr, this, ControlLinear.getCPtr(aControl), aControl);
  }

  public void setUseSteps(boolean aTrueFalse) {
    opensimModelJNI.ControlLinear_setUseSteps(swigCPtr, this, aTrueFalse);
  }

  public boolean getUseSteps() {
    return opensimModelJNI.ControlLinear_getUseSteps(swigCPtr, this);
  }

  public void setKp(double aKp) {
    opensimModelJNI.ControlLinear_setKp(swigCPtr, this, aKp);
  }

  public double getKp() {
    return opensimModelJNI.ControlLinear_getKp(swigCPtr, this);
  }

  public void setKv(double aKv) {
    opensimModelJNI.ControlLinear_setKv(swigCPtr, this, aKv);
  }

  public double getKv() {
    return opensimModelJNI.ControlLinear_getKv(swigCPtr, this);
  }

  public int getNumParameters() {
    return opensimModelJNI.ControlLinear_getNumParameters(swigCPtr, this);
  }

  public void setParameterMin(int aI, double aMin) {
    opensimModelJNI.ControlLinear_setParameterMin(swigCPtr, this, aI, aMin);
  }

  public double getParameterMin(int aI) {
    return opensimModelJNI.ControlLinear_getParameterMin(swigCPtr, this, aI);
  }

  public void setParameterMax(int aI, double aMax) {
    opensimModelJNI.ControlLinear_setParameterMax(swigCPtr, this, aI, aMax);
  }

  public double getParameterMax(int aI) {
    return opensimModelJNI.ControlLinear_getParameterMax(swigCPtr, this, aI);
  }

  public double getParameterTime(int aI) {
    return opensimModelJNI.ControlLinear_getParameterTime(swigCPtr, this, aI);
  }

  public void getParameterNeighborhood(int aI, SWIGTYPE_p_double rTLower, SWIGTYPE_p_double rTUpper) {
    opensimModelJNI.ControlLinear_getParameterNeighborhood(swigCPtr, this, aI, SWIGTYPE_p_double.getCPtr(rTLower), SWIGTYPE_p_double.getCPtr(rTUpper));
  }

  public int getParameterList(double aT, ArrayInt rList) {
    return opensimModelJNI.ControlLinear_getParameterList__SWIG_0(swigCPtr, this, aT, ArrayInt.getCPtr(rList), rList);
  }

  public int getParameterList(double aT1, double aT2, ArrayInt rList) {
    return opensimModelJNI.ControlLinear_getParameterList__SWIG_1(swigCPtr, this, aT1, aT2, ArrayInt.getCPtr(rList), rList);
  }

  public void setParameterValue(int aI, double aP) {
    opensimModelJNI.ControlLinear_setParameterValue(swigCPtr, this, aI, aP);
  }

  public double getParameterValue(int aI) {
    return opensimModelJNI.ControlLinear_getParameterValue(swigCPtr, this, aI);
  }

  public void setControlValue(double aT, double aX) {
    opensimModelJNI.ControlLinear_setControlValue(swigCPtr, this, aT, aX);
  }

  public double getControlValue(double aT) {
    return opensimModelJNI.ControlLinear_getControlValue(swigCPtr, this, aT);
  }

  public double getControlValueMin(double aT) {
    return opensimModelJNI.ControlLinear_getControlValueMin__SWIG_0(swigCPtr, this, aT);
  }

  public double getControlValueMin() {
    return opensimModelJNI.ControlLinear_getControlValueMin__SWIG_1(swigCPtr, this);
  }

  public void setControlValueMin(double aT, double aX) {
    opensimModelJNI.ControlLinear_setControlValueMin(swigCPtr, this, aT, aX);
  }

  public double getControlValueMax(double aT) {
    return opensimModelJNI.ControlLinear_getControlValueMax__SWIG_0(swigCPtr, this, aT);
  }

  public double getControlValueMax() {
    return opensimModelJNI.ControlLinear_getControlValueMax__SWIG_1(swigCPtr, this);
  }

  public void setControlValueMax(double aT, double aX) {
    opensimModelJNI.ControlLinear_setControlValueMax(swigCPtr, this, aT, aX);
  }

  public void clearControlNodes() {
    opensimModelJNI.ControlLinear_clearControlNodes(swigCPtr, this);
  }

  public SetControlNodes getControlValues() {
    return new SetControlNodes(opensimModelJNI.ControlLinear_getControlValues(swigCPtr, this), false);
  }

  public SetControlNodes getControlMinValues() {
    return new SetControlNodes(opensimModelJNI.ControlLinear_getControlMinValues(swigCPtr, this), false);
  }

  public SetControlNodes getControlMaxValues() {
    return new SetControlNodes(opensimModelJNI.ControlLinear_getControlMaxValues(swigCPtr, this), false);
  }

  public void insertNewValueNode(int index, ControlLinearNode newNode) {
    opensimModelJNI.ControlLinear_insertNewValueNode(swigCPtr, this, index, ControlLinearNode.getCPtr(newNode), newNode);
  }

  public void insertNewMinNode(int index, ControlLinearNode newNode) {
    opensimModelJNI.ControlLinear_insertNewMinNode(swigCPtr, this, index, ControlLinearNode.getCPtr(newNode), newNode);
  }

  public void insertNewMaxNode(int index, ControlLinearNode newNode) {
    opensimModelJNI.ControlLinear_insertNewMaxNode(swigCPtr, this, index, ControlLinearNode.getCPtr(newNode), newNode);
  }

  public double getFirstTime() {
    return opensimModelJNI.ControlLinear_getFirstTime(swigCPtr, this);
  }

  public double getLastTime() {
    return opensimModelJNI.ControlLinear_getLastTime(swigCPtr, this);
  }

  public void simplify(SWIGTYPE_p_PropertySet aProperties) {
    opensimModelJNI.ControlLinear_simplify__SWIG_0(swigCPtr, this, SWIGTYPE_p_PropertySet.getCPtr(aProperties));
  }

  public boolean simplify(double cutoffFrequency, double distance) {
    return opensimModelJNI.ControlLinear_simplify__SWIG_1(swigCPtr, this, cutoffFrequency, distance);
  }

  public void filter(double aT) {
    opensimModelJNI.ControlLinear_filter(swigCPtr, this, aT);
  }

  public static double Interpolate(double aX1, double aY1, double aX2, double aY2, double aX) {
    return opensimModelJNI.ControlLinear_Interpolate(aX1, aY1, aX2, aY2, aX);
  }

}
