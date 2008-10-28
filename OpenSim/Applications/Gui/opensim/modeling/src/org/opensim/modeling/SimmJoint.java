/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.31
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.opensim.modeling;

public class SimmJoint extends AbstractJoint {
  private long swigCPtr;

  public SimmJoint(long cPtr, boolean cMemoryOwn) {
    super(opensimModelJNI.SWIGStorageUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  public static long getCPtr(SimmJoint obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if(swigCPtr != 0 && swigCMemOwn) {
      swigCMemOwn = false;
      opensimModelJNI.delete_SimmJoint(swigCPtr);
    }
    swigCPtr = 0;
    super.delete();
  }

  public SimmJoint() {
    this(opensimModelJNI.new_SimmJoint__SWIG_0(), true);
  }

  public SimmJoint(SimmJoint aJoint) {
    this(opensimModelJNI.new_SimmJoint__SWIG_1(SimmJoint.getCPtr(aJoint), aJoint), true);
  }

  public OpenSimObject copy() {
    long cPtr = opensimModelJNI.SimmJoint_copy(swigCPtr, this);
    return (cPtr == 0) ? null : new OpenSimObject(cPtr, false);
  }

  public void setup(AbstractDynamicsEngine aEngine) {
    opensimModelJNI.SimmJoint_setup(swigCPtr, this, AbstractDynamicsEngine.getCPtr(aEngine), aEngine);
  }

  public void copyData(SimmJoint aJoint) {
    opensimModelJNI.SimmJoint_copyData(swigCPtr, this, SimmJoint.getCPtr(aJoint), aJoint);
  }

  public SWIGTYPE_p_DofSet01_05 getDofSet() {
    long cPtr = opensimModelJNI.SimmJoint_getDofSet(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_DofSet01_05(cPtr, false);
  }

  public AbstractBody getBody() {
    long cPtr = opensimModelJNI.SimmJoint_getBody(swigCPtr, this);
    return (cPtr == 0) ? null : new AbstractBody(cPtr, false);
  }

  public String getBodyName() {
    return opensimModelJNI.SimmJoint_getBodyName(swigCPtr, this);
  }

  public AbstractBody getParentBody() {
    long cPtr = opensimModelJNI.SimmJoint_getParentBody(swigCPtr, this);
    return (cPtr == 0) ? null : new AbstractBody(cPtr, false);
  }

  public String getParentBodyName() {
    return opensimModelJNI.SimmJoint_getParentBodyName(swigCPtr, this);
  }

  public void setLocationInParent(SWIGTYPE_p_SimTK__Vec3 aLocation) {
    opensimModelJNI.SimmJoint_setLocationInParent(swigCPtr, this, SWIGTYPE_p_SimTK__Vec3.getCPtr(aLocation));
  }

  public void getLocationInParent(SWIGTYPE_p_SimTK__Vec3 rLocation) {
    opensimModelJNI.SimmJoint_getLocationInParent__SWIG_0(swigCPtr, this, SWIGTYPE_p_SimTK__Vec3.getCPtr(rLocation));
  }

  public void getLocationInParent(double[] rLocation) {
    opensimModelJNI.SimmJoint_getLocationInParent__SWIG_1(swigCPtr, this, rLocation);
  }

  public void setLocationInChild(SWIGTYPE_p_SimTK__Vec3 aLocation) {
    opensimModelJNI.SimmJoint_setLocationInChild(swigCPtr, this, SWIGTYPE_p_SimTK__Vec3.getCPtr(aLocation));
  }

  public void getLocationInChild(SWIGTYPE_p_SimTK__Vec3 rLocation) {
    opensimModelJNI.SimmJoint_getLocationInChild__SWIG_0(swigCPtr, this, SWIGTYPE_p_SimTK__Vec3.getCPtr(rLocation));
  }

  public void getLocationInChild(double[] rLocation) {
    opensimModelJNI.SimmJoint_getLocationInChild__SWIG_1(swigCPtr, this, rLocation);
  }

  public Transform getForwardTransform() {
    return new Transform(opensimModelJNI.SimmJoint_getForwardTransform(swigCPtr, this), false);
  }

  public Transform getInverseTransform() {
    return new Transform(opensimModelJNI.SimmJoint_getInverseTransform(swigCPtr, this), false);
  }

  public void invalidate() {
    opensimModelJNI.SimmJoint_invalidate(swigCPtr, this);
  }

  public boolean isCoordinateUsed(AbstractCoordinate aCoordinate) {
    return opensimModelJNI.SimmJoint_isCoordinateUsed(swigCPtr, this, AbstractCoordinate.getCPtr(aCoordinate), aCoordinate);
  }

  public boolean hasXYZAxes() {
    return opensimModelJNI.SimmJoint_hasXYZAxes(swigCPtr, this);
  }

  public void scale(ScaleSet aScaleSet) {
    opensimModelJNI.SimmJoint_scale__SWIG_0(swigCPtr, this, ScaleSet.getCPtr(aScaleSet), aScaleSet);
  }

  public void scale(SWIGTYPE_p_SimTK__Vec3 aScaleFactors) {
    opensimModelJNI.SimmJoint_scale__SWIG_1(swigCPtr, this, SWIGTYPE_p_SimTK__Vec3.getCPtr(aScaleFactors));
  }

  public void addPathToList(SWIGTYPE_p_OpenSim__SimmPath aPath) {
    opensimModelJNI.SimmJoint_addPathToList(swigCPtr, this, SWIGTYPE_p_OpenSim__SimmPath.getCPtr(aPath));
  }

  public void clearPathList() {
    opensimModelJNI.SimmJoint_clearPathList(swigCPtr, this);
  }

}
