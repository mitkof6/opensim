/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.29
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.opensim.modeling;

public class SimmSubject extends OpenSimObject {
  private long swigCPtr;

  public SimmSubject(long cPtr, boolean cMemoryOwn) {
    super(opensimModelJNI.SWIGStorageUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  public static long getCPtr(SimmSubject obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public void delete() {
    if(swigCPtr != 0 && swigCMemOwn) {
      swigCMemOwn = false;
      opensimModelJNI.delete_SimmSubject(swigCPtr);
    }
    swigCPtr = 0;
    super.delete();
  }

  public SimmSubject() {
    this(opensimModelJNI.new_SimmSubject__SWIG_0(), true);
  }

  public SimmSubject(String aFileName) {
    this(opensimModelJNI.new_SimmSubject__SWIG_1(aFileName), true);
  }

  public SimmSubject(SWIGTYPE_p_DOMElement aElement) {
    this(opensimModelJNI.new_SimmSubject__SWIG_2(SWIGTYPE_p_DOMElement.getCPtr(aElement)), true);
  }

  public SimmSubject(SimmSubject aSubject) {
    this(opensimModelJNI.new_SimmSubject__SWIG_3(SimmSubject.getCPtr(aSubject)), true);
  }

  public OpenSimObject copy() {
    long cPtr = opensimModelJNI.SimmSubject_copy__SWIG_0(swigCPtr);
    return (cPtr == 0) ? null : new OpenSimObject(cPtr, false);
  }

  public OpenSimObject copy(SWIGTYPE_p_DOMElement aElement) {
    long cPtr = opensimModelJNI.SimmSubject_copy__SWIG_1(swigCPtr, SWIGTYPE_p_DOMElement.getCPtr(aElement));
    return (cPtr == 0) ? null : new OpenSimObject(cPtr, false);
  }

  public void copyData(SimmSubject aSubject) {
    opensimModelJNI.SimmSubject_copyData(swigCPtr, SimmSubject.getCPtr(aSubject));
  }

  public SimmModel createModel() {
    long cPtr = opensimModelJNI.SimmSubject_createModel(swigCPtr);
    return (cPtr == 0) ? null : new SimmModel(cPtr, false);
  }

  public SimmGenericModelParams getGenericModelParams() {
    return new SimmGenericModelParams(opensimModelJNI.SimmSubject_getGenericModelParams(swigCPtr), false);
  }

  public SimmScalingParams getScalingParams() {
    return new SimmScalingParams(opensimModelJNI.SimmSubject_getScalingParams(swigCPtr), false);
  }

  public SimmMarkerPlacementParams getMarkerPlacementParams() {
    return new SimmMarkerPlacementParams(opensimModelJNI.SimmSubject_getMarkerPlacementParams(swigCPtr), false);
  }

  public SimmIKParams getIKParams() {
    return new SimmIKParams(opensimModelJNI.SimmSubject_getIKParams(swigCPtr), false);
  }

  public double getMass() {
    return opensimModelJNI.SimmSubject_getMass(swigCPtr);
  }

  public boolean isDefaultGenericModelParams() {
    return opensimModelJNI.SimmSubject_isDefaultGenericModelParams(swigCPtr);
  }

  public boolean isDefaultScalingParams() {
    return opensimModelJNI.SimmSubject_isDefaultScalingParams(swigCPtr);
  }

  public boolean isDefaultMarkerPlacementParams() {
    return opensimModelJNI.SimmSubject_isDefaultMarkerPlacementParams(swigCPtr);
  }

  public boolean isDefaultIKParams() {
    return opensimModelJNI.SimmSubject_isDefaultIKParams(swigCPtr);
  }

  public static void registerTypes() {
    opensimModelJNI.SimmSubject_registerTypes();
  }

  public double getSubjectMass() {
    return opensimModelJNI.SimmSubject_getSubjectMass(swigCPtr);
  }

  public double getSubjectAge() {
    return opensimModelJNI.SimmSubject_getSubjectAge(swigCPtr);
  }

  public double getSubjectHeight() {
    return opensimModelJNI.SimmSubject_getSubjectHeight(swigCPtr);
  }

  public String getPathToSubject() {
    return opensimModelJNI.SimmSubject_getPathToSubject(swigCPtr);
  }

  public void setPathToSubject(String aPath) {
    opensimModelJNI.SimmSubject_setPathToSubject(swigCPtr, aPath);
  }

  public void peteTest() {
    opensimModelJNI.SimmSubject_peteTest(swigCPtr);
  }

  public static double getDefaultMass() {
    return opensimModelJNI.SimmSubject_DefaultMass_get();
  }

}
