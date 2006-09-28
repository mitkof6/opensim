/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.29
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.opensim.modeling;

public class SimmMuscle extends Actuator {
  private long swigCPtr;

  public SimmMuscle(long cPtr, boolean cMemoryOwn) {
    super(opensimModelJNI.SWIGStorageUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  public static long getCPtr(SimmMuscle obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public void delete() {
    if(swigCPtr != 0 && swigCMemOwn) {
      swigCMemOwn = false;
      opensimModelJNI.delete_SimmMuscle(swigCPtr);
    }
    swigCPtr = 0;
    super.delete();
  }

  public SimmMuscle() {
    this(opensimModelJNI.new_SimmMuscle__SWIG_0(), true);
  }

  public SimmMuscle(SWIGTYPE_p_DOMElement aElement) {
    this(opensimModelJNI.new_SimmMuscle__SWIG_1(SWIGTYPE_p_DOMElement.getCPtr(aElement)), true);
  }

  public SimmMuscle(SimmMuscle aMuscle) {
    this(opensimModelJNI.new_SimmMuscle__SWIG_2(SimmMuscle.getCPtr(aMuscle)), true);
  }

  public OpenSimObject copy() {
    long cPtr = opensimModelJNI.SimmMuscle_copy__SWIG_0(swigCPtr);
    return (cPtr == 0) ? null : new OpenSimObject(cPtr, false);
  }

  public OpenSimObject copy(SWIGTYPE_p_DOMElement aElement) {
    long cPtr = opensimModelJNI.SimmMuscle_copy__SWIG_1(swigCPtr, SWIGTYPE_p_DOMElement.getCPtr(aElement));
    return (cPtr == 0) ? null : new OpenSimObject(cPtr, false);
  }

  public void copyData(SimmMuscle aMuscle) {
    opensimModelJNI.SimmMuscle_copyData(swigCPtr, SimmMuscle.getCPtr(aMuscle));
  }

  public SimmMusclePointSet getAttachmentSet() {
    return new SimmMusclePointSet(opensimModelJNI.SimmMuscle_getAttachmentSet(swigCPtr), false);
  }

  public void computeActuation() {
    opensimModelJNI.SimmMuscle_computeActuation(swigCPtr);
  }

  public void apply() {
    opensimModelJNI.SimmMuscle_apply(swigCPtr);
  }

  public double getLength() {
    return opensimModelJNI.SimmMuscle_getLength(swigCPtr);
  }

  public ArrayStr getGroupNames() {
    return new ArrayStr(opensimModelJNI.SimmMuscle_getGroupNames(swigCPtr), false);
  }

  public VisibleObject getDisplayer() {
    long cPtr = opensimModelJNI.SimmMuscle_getDisplayer(swigCPtr);
    return (cPtr == 0) ? null : new VisibleObject(cPtr, false);
  }

  public static void registerTypes() {
    opensimModelJNI.SimmMuscle_registerTypes();
  }

  public void preScale(ScaleSet aScaleSet) {
    opensimModelJNI.SimmMuscle_preScale(swigCPtr, ScaleSet.getCPtr(aScaleSet));
  }

  public void scale(ScaleSet aScaleSet) {
    opensimModelJNI.SimmMuscle_scale(swigCPtr, ScaleSet.getCPtr(aScaleSet));
  }

  public void postScale(ScaleSet aScaleSet) {
    opensimModelJNI.SimmMuscle_postScale(swigCPtr, ScaleSet.getCPtr(aScaleSet));
  }

  public void setup(SimmModel model, SimmKinematicsEngine ke) {
    opensimModelJNI.SimmMuscle_setup(swigCPtr, SimmModel.getCPtr(model), SimmKinematicsEngine.getCPtr(ke));
  }

  public void writeSIMM(SWIGTYPE_p_std__ofstream out) {
    opensimModelJNI.SimmMuscle_writeSIMM(swigCPtr, SWIGTYPE_p_std__ofstream.getCPtr(out));
  }

  public void peteTest(SimmKinematicsEngine ke) {
    opensimModelJNI.SimmMuscle_peteTest(swigCPtr, SimmKinematicsEngine.getCPtr(ke));
  }

}
