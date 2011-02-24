/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.40
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.opensim.modeling;

public class MultiplierFunction extends Function {
  private long swigCPtr;

  public MultiplierFunction(long cPtr, boolean cMemoryOwn) {
    super(opensimModelJNI.SWIGStorageUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  public static long getCPtr(MultiplierFunction obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        opensimModelJNI.delete_MultiplierFunction(swigCPtr);
      }
      swigCPtr = 0;
    }
    super.delete();
  }

  public MultiplierFunction() {
    this(opensimModelJNI.new_MultiplierFunction__SWIG_0(), true);
  }

  public MultiplierFunction(Function aFunction) {
    this(opensimModelJNI.new_MultiplierFunction__SWIG_1(Function.getCPtr(aFunction), aFunction), true);
  }

  public MultiplierFunction(Function aFunction, double aScaleFactor) {
    this(opensimModelJNI.new_MultiplierFunction__SWIG_2(Function.getCPtr(aFunction), aFunction, aScaleFactor), true);
  }

  public MultiplierFunction(MultiplierFunction aFunction) {
    this(opensimModelJNI.new_MultiplierFunction__SWIG_3(MultiplierFunction.getCPtr(aFunction), aFunction), true);
  }

  public OpenSimObject copy() {
    long cPtr = opensimModelJNI.MultiplierFunction_copy__SWIG_0(swigCPtr, this);
    return (cPtr == 0) ? null : new OpenSimObject(cPtr, false);
  }

  public void init(Function aFunction) {
    opensimModelJNI.MultiplierFunction_init(swigCPtr, this, Function.getCPtr(aFunction), aFunction);
  }

  public void setFunction(Function aFunction) {
    opensimModelJNI.MultiplierFunction_setFunction(swigCPtr, this, Function.getCPtr(aFunction), aFunction);
  }

  public void setScale(double aScaleFactor) {
    opensimModelJNI.MultiplierFunction_setScale(swigCPtr, this, aScaleFactor);
  }

  public Function getFunction() {
    long cPtr = opensimModelJNI.MultiplierFunction_getFunction(swigCPtr, this);
    return (cPtr == 0) ? null : new Function(cPtr, false);
  }

  public double getScale() {
    return opensimModelJNI.MultiplierFunction_getScale(swigCPtr, this);
  }

  public double calcValue(SWIGTYPE_p_SimTK__Vector x) {
    return opensimModelJNI.MultiplierFunction_calcValue(swigCPtr, this, SWIGTYPE_p_SimTK__Vector.getCPtr(x));
  }

  public double calcDerivative(SWIGTYPE_p_std__vectorT_int_t derivComponents, SWIGTYPE_p_SimTK__Vector x) {
    return opensimModelJNI.MultiplierFunction_calcDerivative(swigCPtr, this, SWIGTYPE_p_std__vectorT_int_t.getCPtr(derivComponents), SWIGTYPE_p_SimTK__Vector.getCPtr(x));
  }

  public int getArgumentSize() {
    return opensimModelJNI.MultiplierFunction_getArgumentSize(swigCPtr, this);
  }

  public int getMaxDerivativeOrder() {
    return opensimModelJNI.MultiplierFunction_getMaxDerivativeOrder(swigCPtr, this);
  }

  public SWIGTYPE_p_SimTK__Function createSimTKFunction() {
    long cPtr = opensimModelJNI.MultiplierFunction_createSimTKFunction(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_SimTK__Function(cPtr, false);
  }

  public void updateFromXMLNode() {
    opensimModelJNI.MultiplierFunction_updateFromXMLNode(swigCPtr, this);
  }

  public static boolean isKindOf(String type) {
    return opensimModelJNI.MultiplierFunction_isKindOf(type);
  }

  public boolean isA(String type) {
    return opensimModelJNI.MultiplierFunction_isA(swigCPtr, this, type);
  }

  public static MultiplierFunction safeDownCast(OpenSimObject obj) {
    long cPtr = opensimModelJNI.MultiplierFunction_safeDownCast(OpenSimObject.getCPtr(obj), obj);
    return (cPtr == 0) ? null : new MultiplierFunction(cPtr, false);
  }

  public void copy(OpenSimObject aObject) {
    opensimModelJNI.MultiplierFunction_copy__SWIG_1(swigCPtr, this, OpenSimObject.getCPtr(aObject), aObject);
  }

}
