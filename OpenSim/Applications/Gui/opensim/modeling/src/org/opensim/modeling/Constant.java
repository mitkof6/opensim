/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.37
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.opensim.modeling;

public class Constant extends Function {
  private long swigCPtr;

  public Constant(long cPtr, boolean cMemoryOwn) {
    super(opensimModelJNI.SWIGStorageUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  public static long getCPtr(Constant obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if(swigCPtr != 0 && swigCMemOwn) {
      swigCMemOwn = false;
      opensimModelJNI.delete_Constant(swigCPtr);
    }
    swigCPtr = 0;
    super.delete();
  }

  public Constant() {
    this(opensimModelJNI.new_Constant__SWIG_0(), true);
  }

  public Constant(double value) {
    this(opensimModelJNI.new_Constant__SWIG_1(value), true);
  }

  public Constant(Constant aSpline) {
    this(opensimModelJNI.new_Constant__SWIG_2(Constant.getCPtr(aSpline), aSpline), true);
  }

  public OpenSimObject copy() {
    long cPtr = opensimModelJNI.Constant_copy__SWIG_0(swigCPtr, this);
    return (cPtr == 0) ? null : new OpenSimObject(cPtr, false);
  }

  public void setValue(double aValue) {
    opensimModelJNI.Constant_setValue(swigCPtr, this, aValue);
  }

  public double calcValue(SWIGTYPE_p_SimTK__Vector xUnused) {
    return opensimModelJNI.Constant_calcValue(swigCPtr, this, SWIGTYPE_p_SimTK__Vector.getCPtr(xUnused));
  }

  public double getValue() {
    return opensimModelJNI.Constant_getValue(swigCPtr, this);
  }

  public SWIGTYPE_p_SimTK__Function createSimTKFunction() {
    long cPtr = opensimModelJNI.Constant_createSimTKFunction(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_SimTK__Function(cPtr, false);
  }

  public static boolean isKindOf(String type) {
    return opensimModelJNI.Constant_isKindOf(type);
  }

  public boolean isA(String type) {
    return opensimModelJNI.Constant_isA(swigCPtr, this, type);
  }

  public static Constant safeDownCast(OpenSimObject obj) {
    long cPtr = opensimModelJNI.Constant_safeDownCast(OpenSimObject.getCPtr(obj), obj);
    return (cPtr == 0) ? null : new Constant(cPtr, false);
  }

  public void copy(OpenSimObject aObject) {
    opensimModelJNI.Constant_copy__SWIG_1(swigCPtr, this, OpenSimObject.getCPtr(aObject), aObject);
  }

}
