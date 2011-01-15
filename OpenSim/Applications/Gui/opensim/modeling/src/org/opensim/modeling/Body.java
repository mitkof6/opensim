/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.37
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.opensim.modeling;

public class Body extends ModelComponent {
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

  public synchronized void delete() {
    if(swigCPtr != 0 && swigCMemOwn) {
      swigCMemOwn = false;
      opensimModelJNI.delete_Body(swigCPtr);
    }
    swigCPtr = 0;
    super.delete();
  }

  public Body() {
    this(opensimModelJNI.new_Body__SWIG_0(), true);
  }

  public Body(String aName, double aMass, SWIGTYPE_p_SimTK__Vec3 aMassCenter, SWIGTYPE_p_SimTK__Inertia aInertia) {
    this(opensimModelJNI.new_Body__SWIG_1(aName, aMass, SWIGTYPE_p_SimTK__Vec3.getCPtr(aMassCenter), SWIGTYPE_p_SimTK__Inertia.getCPtr(aInertia)), true);
  }

  public Body(Body aBody) {
    this(opensimModelJNI.new_Body__SWIG_2(Body.getCPtr(aBody), aBody), true);
  }

  public OpenSimObject copy() {
    long cPtr = opensimModelJNI.Body_copy__SWIG_0(swigCPtr, this);
    return (cPtr == 0) ? null : new OpenSimObject(cPtr, false);
  }

  public void copyData(Body aBody) {
    opensimModelJNI.Body_copyData(swigCPtr, this, Body.getCPtr(aBody), aBody);
  }

  public void addDisplayGeometry(String aGeometryFileName) {
    opensimModelJNI.Body_addDisplayGeometry(swigCPtr, this, aGeometryFileName);
  }

  public double getMass() {
    return opensimModelJNI.Body_getMass(swigCPtr, this);
  }

  public boolean setMass(double aMass) {
    return opensimModelJNI.Body_setMass(swigCPtr, this, aMass);
  }

  public void getMassCenter(SWIGTYPE_p_SimTK__Vec3 rVec) {
    opensimModelJNI.Body_getMassCenter(swigCPtr, this, SWIGTYPE_p_SimTK__Vec3.getCPtr(rVec));
  }

  public boolean setMassCenter(SWIGTYPE_p_SimTK__Vec3 aVec) {
    return opensimModelJNI.Body_setMassCenter(swigCPtr, this, SWIGTYPE_p_SimTK__Vec3.getCPtr(aVec));
  }

  public void getInertia(SWIGTYPE_p_SimTK__Mat33 rInertia) {
    opensimModelJNI.Body_getInertia(swigCPtr, this, SWIGTYPE_p_SimTK__Mat33.getCPtr(rInertia));
  }

  public boolean setInertia(SWIGTYPE_p_SimTK__Inertia aInertia) {
    return opensimModelJNI.Body_setInertia(swigCPtr, this, SWIGTYPE_p_SimTK__Inertia.getCPtr(aInertia));
  }

  public boolean hasJoint() {
    return opensimModelJNI.Body_hasJoint(swigCPtr, this);
  }

  public Joint getJoint() {
    return new Joint(opensimModelJNI.Body_getJoint(swigCPtr, this), false);
  }

  public void setJoint(Joint aJoint) {
    opensimModelJNI.Body_setJoint(swigCPtr, this, Joint.getCPtr(aJoint), aJoint);
  }

  public void scale(SWIGTYPE_p_SimTK__Vec3 aScaleFactors, boolean aScaleMass) {
    opensimModelJNI.Body_scale__SWIG_0(swigCPtr, this, SWIGTYPE_p_SimTK__Vec3.getCPtr(aScaleFactors), aScaleMass);
  }

  public void scale(SWIGTYPE_p_SimTK__Vec3 aScaleFactors) {
    opensimModelJNI.Body_scale__SWIG_1(swigCPtr, this, SWIGTYPE_p_SimTK__Vec3.getCPtr(aScaleFactors));
  }

  public void scaleInertialProperties(SWIGTYPE_p_SimTK__Vec3 aScaleFactors, boolean aScaleMass) {
    opensimModelJNI.Body_scaleInertialProperties__SWIG_0(swigCPtr, this, SWIGTYPE_p_SimTK__Vec3.getCPtr(aScaleFactors), aScaleMass);
  }

  public void scaleInertialProperties(SWIGTYPE_p_SimTK__Vec3 aScaleFactors) {
    opensimModelJNI.Body_scaleInertialProperties__SWIG_1(swigCPtr, this, SWIGTYPE_p_SimTK__Vec3.getCPtr(aScaleFactors));
  }

  public void scaleMass(double aScaleFactor) {
    opensimModelJNI.Body_scaleMass(swigCPtr, this, aScaleFactor);
  }

  public VisibleObject getDisplayer() {
    long cPtr = opensimModelJNI.Body_getDisplayer(swigCPtr, this);
    return (cPtr == 0) ? null : new VisibleObject(cPtr, false);
  }

  public VisibleObject updDisplayer() {
    long cPtr = opensimModelJNI.Body_updDisplayer(swigCPtr, this);
    return (cPtr == 0) ? null : new VisibleObject(cPtr, false);
  }

  public SWIGTYPE_p_SimTK__MobilizedBodyIndex getIndex() {
    return new SWIGTYPE_p_SimTK__MobilizedBodyIndex(opensimModelJNI.Body_getIndex(swigCPtr, this), true);
  }

  public void getScaleFactors(SWIGTYPE_p_SimTK__Vec3 aScaleFactors) {
    opensimModelJNI.Body_getScaleFactors(swigCPtr, this, SWIGTYPE_p_SimTK__Vec3.getCPtr(aScaleFactors));
  }

  public WrapObject getWrapObject(String aName) {
    long cPtr = opensimModelJNI.Body_getWrapObject(swigCPtr, this, aName);
    return (cPtr == 0) ? null : new WrapObject(cPtr, false);
  }

  public WrapObjectSet getWrapObjectSet() {
    return new WrapObjectSet(opensimModelJNI.Body_getWrapObjectSet(swigCPtr, this), false);
  }

  public static boolean isKindOf(String type) {
    return opensimModelJNI.Body_isKindOf(type);
  }

  public boolean isA(String type) {
    return opensimModelJNI.Body_isA(swigCPtr, this, type);
  }

  public static Body safeDownCast(OpenSimObject obj) {
    long cPtr = opensimModelJNI.Body_safeDownCast(OpenSimObject.getCPtr(obj), obj);
    return (cPtr == 0) ? null : new Body(cPtr, false);
  }

  public void copy(OpenSimObject aObject) {
    opensimModelJNI.Body_copy__SWIG_1(swigCPtr, this, OpenSimObject.getCPtr(aObject), aObject);
  }

  public SWIGTYPE_p_SimTK__MassProperties getMassProperties() {
    return new SWIGTYPE_p_SimTK__MassProperties(opensimModelJNI.Body_getMassProperties(swigCPtr, this), true);
  }

  public int getNumStateVariables() {
    return opensimModelJNI.Body_getNumStateVariables(swigCPtr, this);
  }

}
