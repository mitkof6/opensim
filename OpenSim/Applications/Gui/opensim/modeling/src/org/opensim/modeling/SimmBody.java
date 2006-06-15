/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.29
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.opensim.modeling;

public class SimmBody extends OpenSimObject {
  private long swigCPtr;

  protected SimmBody(long cPtr, boolean cMemoryOwn) {
    super(opensimModelJNI.SWIGSimmBodyUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  protected static long getCPtr(SimmBody obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public void delete() {
    if(swigCPtr != 0 && swigCMemOwn) {
      swigCMemOwn = false;
      opensimModelJNI.delete_SimmBody(swigCPtr);
    }
    swigCPtr = 0;
    super.delete();
  }

  public SimmBody() {
    this(opensimModelJNI.new_SimmBody__SWIG_0(), true);
  }

  public SimmBody(SWIGTYPE_p_DOMElement aElement) {
    this(opensimModelJNI.new_SimmBody__SWIG_1(SWIGTYPE_p_DOMElement.getCPtr(aElement)), true);
  }

  public SimmBody(SimmBody aBody) {
    this(opensimModelJNI.new_SimmBody__SWIG_2(SimmBody.getCPtr(aBody)), true);
  }

  public OpenSimObject copy() {
    long cPtr = opensimModelJNI.SimmBody_copy__SWIG_0(swigCPtr);
    return (cPtr == 0) ? null : new OpenSimObject(cPtr, false);
  }

  public OpenSimObject copy(SWIGTYPE_p_DOMElement aElement) {
    long cPtr = opensimModelJNI.SimmBody_copy__SWIG_1(swigCPtr, SWIGTYPE_p_DOMElement.getCPtr(aElement));
    return (cPtr == 0) ? null : new OpenSimObject(cPtr, false);
  }

  public void copyData(SimmBody aBody) {
    opensimModelJNI.SimmBody_copyData(swigCPtr, SimmBody.getCPtr(aBody));
  }

  public void setup(SimmKinematicsEngine aEngine) {
    opensimModelJNI.SimmBody_setup(swigCPtr, SimmKinematicsEngine.getCPtr(aEngine));
  }

  public double getMass() {
    return opensimModelJNI.SimmBody_getMass(swigCPtr);
  }

  public void getMassCenter(double[] vec) {
    opensimModelJNI.SimmBody_getMassCenter(swigCPtr, vec);
  }

  public ArrayDouble getInertia() {
    return new ArrayDouble(opensimModelJNI.SimmBody_getInertia(swigCPtr), false);
  }

  public SWIGTYPE_p_OpenSim__ArrayPtrsTOpenSim__VisibleObject_t getBones() {
    return new SWIGTYPE_p_OpenSim__ArrayPtrsTOpenSim__VisibleObject_t(opensimModelJNI.SimmBody_getBones(swigCPtr), false);
  }

  public int getNumBones() {
    return opensimModelJNI.SimmBody_getNumBones(swigCPtr);
  }

  public SimmBone getBone(int index) {
    long cPtr = opensimModelJNI.SimmBody_getBone(swigCPtr, index);
    return (cPtr == 0) ? null : new SimmBone(cPtr, false);
  }

  public int getNumMarkers() {
    return opensimModelJNI.SimmBody_getNumMarkers(swigCPtr);
  }

  public SWIGTYPE_p_SimmMarker getMarker(int index) {
    long cPtr = opensimModelJNI.SimmBody_getMarker(swigCPtr, index);
    return (cPtr == 0) ? null : new SWIGTYPE_p_SimmMarker(cPtr, false);
  }

  public int deleteAllMarkers() {
    return opensimModelJNI.SimmBody_deleteAllMarkers(swigCPtr);
  }

  public void deleteMarker(SWIGTYPE_p_SimmMarker aMarker) {
    opensimModelJNI.SimmBody_deleteMarker(swigCPtr, SWIGTYPE_p_SimmMarker.getCPtr(aMarker));
  }

  public int deleteUnusedMarkers(ArrayStr aMarkerNames) {
    return opensimModelJNI.SimmBody_deleteUnusedMarkers(swigCPtr, ArrayStr.getCPtr(aMarkerNames));
  }

  public void scale(ArrayDouble aScaleFactors, boolean aPreserveMassDist) {
    opensimModelJNI.SimmBody_scale__SWIG_0(swigCPtr, ArrayDouble.getCPtr(aScaleFactors), aPreserveMassDist);
  }

  public void scale(ArrayDouble aScaleFactors) {
    opensimModelJNI.SimmBody_scale__SWIG_1(swigCPtr, ArrayDouble.getCPtr(aScaleFactors));
  }

  public void scaleInertialProperties(ArrayDouble aScaleFactors) {
    opensimModelJNI.SimmBody_scaleInertialProperties(swigCPtr, ArrayDouble.getCPtr(aScaleFactors));
  }

  public void addMarker(SWIGTYPE_p_SimmMarker aMarker) {
    opensimModelJNI.SimmBody_addMarker(swigCPtr, SWIGTYPE_p_SimmMarker.getCPtr(aMarker));
  }

  public void writeSIMM(SWIGTYPE_p_std__ofstream out) {
    opensimModelJNI.SimmBody_writeSIMM(swigCPtr, SWIGTYPE_p_std__ofstream.getCPtr(out));
  }

  public void writeMarkers(SWIGTYPE_p_std__ofstream out) {
    opensimModelJNI.SimmBody_writeMarkers(swigCPtr, SWIGTYPE_p_std__ofstream.getCPtr(out));
  }

  public void peteTest() {
    opensimModelJNI.SimmBody_peteTest(swigCPtr);
  }

}
