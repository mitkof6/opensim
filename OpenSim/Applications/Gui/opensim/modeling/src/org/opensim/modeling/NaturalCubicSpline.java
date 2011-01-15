/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.37
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.opensim.modeling;

public class NaturalCubicSpline extends Function {
  private long swigCPtr;

  public NaturalCubicSpline(long cPtr, boolean cMemoryOwn) {
    super(opensimModelJNI.SWIGStorageUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  public static long getCPtr(NaturalCubicSpline obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if(swigCPtr != 0 && swigCMemOwn) {
      swigCMemOwn = false;
      opensimModelJNI.delete_NaturalCubicSpline(swigCPtr);
    }
    swigCPtr = 0;
    super.delete();
  }

  public NaturalCubicSpline() {
    this(opensimModelJNI.new_NaturalCubicSpline__SWIG_0(), true);
  }

  public NaturalCubicSpline(int aN, SWIGTYPE_p_double aTimes, SWIGTYPE_p_double aValues, String aName) {
    this(opensimModelJNI.new_NaturalCubicSpline__SWIG_1(aN, SWIGTYPE_p_double.getCPtr(aTimes), SWIGTYPE_p_double.getCPtr(aValues), aName), true);
  }

  public NaturalCubicSpline(int aN, SWIGTYPE_p_double aTimes, SWIGTYPE_p_double aValues) {
    this(opensimModelJNI.new_NaturalCubicSpline__SWIG_2(aN, SWIGTYPE_p_double.getCPtr(aTimes), SWIGTYPE_p_double.getCPtr(aValues)), true);
  }

  public NaturalCubicSpline(NaturalCubicSpline aSpline) {
    this(opensimModelJNI.new_NaturalCubicSpline__SWIG_3(NaturalCubicSpline.getCPtr(aSpline), aSpline), true);
  }

  public OpenSimObject copy() {
    long cPtr = opensimModelJNI.NaturalCubicSpline_copy__SWIG_0(swigCPtr, this);
    return (cPtr == 0) ? null : new OpenSimObject(cPtr, false);
  }

  public void init(Function aFunction) {
    opensimModelJNI.NaturalCubicSpline_init(swigCPtr, this, Function.getCPtr(aFunction), aFunction);
  }

  public int getSize() {
    return opensimModelJNI.NaturalCubicSpline_getSize(swigCPtr, this);
  }

  public ArrayDouble getX() {
    return new ArrayDouble(opensimModelJNI.NaturalCubicSpline_getX__SWIG_0(swigCPtr, this), false);
  }

  public ArrayDouble getY() {
    return new ArrayDouble(opensimModelJNI.NaturalCubicSpline_getY__SWIG_0(swigCPtr, this), false);
  }

  public SWIGTYPE_p_double getXValues() {
    long cPtr = opensimModelJNI.NaturalCubicSpline_getXValues(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_double(cPtr, false);
  }

  public SWIGTYPE_p_double getYValues() {
    long cPtr = opensimModelJNI.NaturalCubicSpline_getYValues(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_double(cPtr, false);
  }

  public int getNumberOfPoints() {
    return opensimModelJNI.NaturalCubicSpline_getNumberOfPoints(swigCPtr, this);
  }

  public double getX(int aIndex) {
    return opensimModelJNI.NaturalCubicSpline_getX__SWIG_1(swigCPtr, this, aIndex);
  }

  public double getY(int aIndex) {
    return opensimModelJNI.NaturalCubicSpline_getY__SWIG_1(swigCPtr, this, aIndex);
  }

  public double getZ(int aIndex) {
    return opensimModelJNI.NaturalCubicSpline_getZ(swigCPtr, this, aIndex);
  }

  public void setX(int aIndex, double aValue) {
    opensimModelJNI.NaturalCubicSpline_setX(swigCPtr, this, aIndex, aValue);
  }

  public void setY(int aIndex, double aValue) {
    opensimModelJNI.NaturalCubicSpline_setY(swigCPtr, this, aIndex, aValue);
  }

  public boolean deletePoint(int aIndex) {
    return opensimModelJNI.NaturalCubicSpline_deletePoint(swigCPtr, this, aIndex);
  }

  public boolean deletePoints(ArrayInt indices) {
    return opensimModelJNI.NaturalCubicSpline_deletePoints(swigCPtr, this, ArrayInt.getCPtr(indices), indices);
  }

  public int addPoint(double aX, double aY) {
    return opensimModelJNI.NaturalCubicSpline_addPoint(swigCPtr, this, aX, aY);
  }

  public double calcValue(SWIGTYPE_p_SimTK__Vector x) {
    return opensimModelJNI.NaturalCubicSpline_calcValue(swigCPtr, this, SWIGTYPE_p_SimTK__Vector.getCPtr(x));
  }

  public double calcDerivative(SWIGTYPE_p_std__vectorT_int_t derivComponents, SWIGTYPE_p_SimTK__Vector x) {
    return opensimModelJNI.NaturalCubicSpline_calcDerivative(swigCPtr, this, SWIGTYPE_p_std__vectorT_int_t.getCPtr(derivComponents), SWIGTYPE_p_SimTK__Vector.getCPtr(x));
  }

  public int getArgumentSize() {
    return opensimModelJNI.NaturalCubicSpline_getArgumentSize(swigCPtr, this);
  }

  public int getMaxDerivativeOrder() {
    return opensimModelJNI.NaturalCubicSpline_getMaxDerivativeOrder(swigCPtr, this);
  }

  public SWIGTYPE_p_SimTK__Function createSimTKFunction() {
    long cPtr = opensimModelJNI.NaturalCubicSpline_createSimTKFunction(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_SimTK__Function(cPtr, false);
  }

  public void updateFromXMLNode() {
    opensimModelJNI.NaturalCubicSpline_updateFromXMLNode(swigCPtr, this);
  }

  public static boolean isKindOf(String type) {
    return opensimModelJNI.NaturalCubicSpline_isKindOf(type);
  }

  public boolean isA(String type) {
    return opensimModelJNI.NaturalCubicSpline_isA(swigCPtr, this, type);
  }

  public static NaturalCubicSpline safeDownCast(OpenSimObject obj) {
    long cPtr = opensimModelJNI.NaturalCubicSpline_safeDownCast(OpenSimObject.getCPtr(obj), obj);
    return (cPtr == 0) ? null : new NaturalCubicSpline(cPtr, false);
  }

  public void copy(OpenSimObject aObject) {
    opensimModelJNI.NaturalCubicSpline_copy__SWIG_1(swigCPtr, this, OpenSimObject.getCPtr(aObject), aObject);
  }

}
