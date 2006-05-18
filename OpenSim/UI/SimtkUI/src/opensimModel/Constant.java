/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.29
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package opensimModel;

public class Constant extends Function {
  private long swigCPtr;

  protected Constant(long cPtr, boolean cMemoryOwn) {
    super(opensimModelJNI.SWIGConstantUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  protected static long getCPtr(Constant obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public void delete() {
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

  public Constant(int aN, SWIGTYPE_p_double aTimes, SWIGTYPE_p_double aValues, String aName) {
    this(opensimModelJNI.new_Constant__SWIG_1(aN, SWIGTYPE_p_double.getCPtr(aTimes), SWIGTYPE_p_double.getCPtr(aValues), aName), true);
  }

  public Constant(int aN, SWIGTYPE_p_double aTimes, SWIGTYPE_p_double aValues) {
    this(opensimModelJNI.new_Constant__SWIG_2(aN, SWIGTYPE_p_double.getCPtr(aTimes), SWIGTYPE_p_double.getCPtr(aValues)), true);
  }

  public Constant(SWIGTYPE_p_DOMElement aElement) {
    this(opensimModelJNI.new_Constant__SWIG_3(SWIGTYPE_p_DOMElement.getCPtr(aElement)), true);
  }

  public Constant(Constant aSpline) {
    this(opensimModelJNI.new_Constant__SWIG_4(Constant.getCPtr(aSpline)), true);
  }

  public OpenSimObject copy() {
    long cPtr = opensimModelJNI.Constant_copy__SWIG_0(swigCPtr);
    return (cPtr == 0) ? null : new OpenSimObject(cPtr, false);
  }

  public OpenSimObject copy(SWIGTYPE_p_DOMElement aElement) {
    long cPtr = opensimModelJNI.Constant_copy__SWIG_1(swigCPtr, SWIGTYPE_p_DOMElement.getCPtr(aElement));
    return (cPtr == 0) ? null : new OpenSimObject(cPtr, false);
  }

  public int getNumberOfPoints() {
    return opensimModelJNI.Constant_getNumberOfPoints(swigCPtr);
  }

  public void setValue(double aValue) {
    opensimModelJNI.Constant_setValue(swigCPtr, aValue);
  }

  public void peteTest() {
    opensimModelJNI.Constant_peteTest(swigCPtr);
  }

  public void updateBoundingBox() {
    opensimModelJNI.Constant_updateBoundingBox(swigCPtr);
  }

  public double evaluate(int aDerivOrder, double aX, double aY, double aZ) {
    return opensimModelJNI.Constant_evaluate__SWIG_0(swigCPtr, aDerivOrder, aX, aY, aZ);
  }

  public double evaluate(int aDerivOrder, double aX, double aY) {
    return opensimModelJNI.Constant_evaluate__SWIG_1(swigCPtr, aDerivOrder, aX, aY);
  }

  public double evaluate(int aDerivOrder, double aX) {
    return opensimModelJNI.Constant_evaluate__SWIG_2(swigCPtr, aDerivOrder, aX);
  }

  public double evaluate(int aDerivOrder) {
    return opensimModelJNI.Constant_evaluate__SWIG_3(swigCPtr, aDerivOrder);
  }

  public double evaluate() {
    return opensimModelJNI.Constant_evaluate__SWIG_4(swigCPtr);
  }

  public void scaleY(double aScaleFactor) {
    opensimModelJNI.Constant_scaleY(swigCPtr, aScaleFactor);
  }

  public void updateFromXMLNode() {
    opensimModelJNI.Constant_updateFromXMLNode(swigCPtr);
  }

  public void writeSIMM(SWIGTYPE_p_std__ofstream out, int aFunctionIndex) {
    opensimModelJNI.Constant_writeSIMM(swigCPtr, SWIGTYPE_p_std__ofstream.getCPtr(out), aFunctionIndex);
  }

}
