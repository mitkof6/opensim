/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.29
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.opensim.modeling;

public class Body extends VisibleObject {
  private long swigCPtr;

  public Body(long cPtr, boolean cMemoryOwn) {
    super(opensimModelJNI.SWIGStorageUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  public static long getCPtr(Body obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public void delete() {
    if(swigCPtr != 0 && swigCMemOwn) {
      swigCMemOwn = false;
      opensimModelJNI.delete_Body(swigCPtr);
    }
    swigCPtr = 0;
    super.delete();
  }

  public Body(double aM, SWIGTYPE_p_double aI) {
    this(opensimModelJNI.new_Body__SWIG_0(aM, SWIGTYPE_p_double.getCPtr(aI)), true);
  }

  public Body(double aM) {
    this(opensimModelJNI.new_Body__SWIG_1(aM), true);
  }

  public Body() {
    this(opensimModelJNI.new_Body__SWIG_2(), true);
  }

  public Body(Body aBody) {
    this(opensimModelJNI.new_Body__SWIG_3(Body.getCPtr(aBody)), true);
  }

  public Body(String aFileName) {
    this(opensimModelJNI.new_Body__SWIG_4(aFileName), true);
  }

  public Body(SWIGTYPE_p_DOMElement aElement) {
    this(opensimModelJNI.new_Body__SWIG_5(SWIGTYPE_p_DOMElement.getCPtr(aElement)), true);
  }

  public OpenSimObject copy() {
    long cPtr = opensimModelJNI.Body_copy__SWIG_0(swigCPtr);
    return (cPtr == 0) ? null : new OpenSimObject(cPtr, false);
  }

  public OpenSimObject copy(SWIGTYPE_p_DOMElement aElement) {
    long cPtr = opensimModelJNI.Body_copy__SWIG_1(swigCPtr, SWIGTYPE_p_DOMElement.getCPtr(aElement));
    return (cPtr == 0) ? null : new OpenSimObject(cPtr, false);
  }

  public void setMass(double aM) {
    opensimModelJNI.Body_setMass(swigCPtr, aM);
  }

  public double getMass() {
    return opensimModelJNI.Body_getMass(swigCPtr);
  }

  public void setInertia(SWIGTYPE_p_double aI) {
    opensimModelJNI.Body_setInertia__SWIG_0(swigCPtr, SWIGTYPE_p_double.getCPtr(aI));
  }

  public void setInertia(double I1, double I2, double I3) {
    opensimModelJNI.Body_setInertia__SWIG_1(swigCPtr, I1, I2, I3);
  }

  public void setInertia(double I1, double I2, double I3, double I12, double I23, double I31) {
    opensimModelJNI.Body_setInertia__SWIG_2(swigCPtr, I1, I2, I3, I12, I23, I31);
  }

  public void getInertia(double[] aI) {
    opensimModelJNI.Body_getInertia__SWIG_0(swigCPtr, aI);
  }

  public void getInertia(SWIGTYPE_p_a_3__double aI) {
    opensimModelJNI.Body_getInertia__SWIG_1(swigCPtr, SWIGTYPE_p_a_3__double.getCPtr(aI));
  }

  public void setCenterOfMass(double[] aCenterOfMass) {
    opensimModelJNI.Body_setCenterOfMass(swigCPtr, aCenterOfMass);
  }

  public void getCenterOfMass(double[] aCenterOfMass) {
    opensimModelJNI.Body_getCenterOfMass(swigCPtr, aCenterOfMass);
  }

  public void scaleBy(double[] aScaleFactors) {
    opensimModelJNI.Body_scaleBy(swigCPtr, aScaleFactors);
  }

  public void setNull() {
    opensimModelJNI.Body_setNull(swigCPtr);
  }

  public void setupProperties() {
    opensimModelJNI.Body_setupProperties(swigCPtr);
  }

}
