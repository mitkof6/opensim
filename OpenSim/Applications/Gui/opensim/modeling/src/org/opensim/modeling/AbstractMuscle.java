/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.31
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.opensim.modeling;

public class AbstractMuscle extends AbstractActuator {
  private long swigCPtr;

  public AbstractMuscle(long cPtr, boolean cMemoryOwn) {
    super(opensimModelJNI.SWIGStorageUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  public static long getCPtr(AbstractMuscle obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if(swigCPtr != 0 && swigCMemOwn) {
      swigCMemOwn = false;
      opensimModelJNI.delete_AbstractMuscle(swigCPtr);
    }
    swigCPtr = 0;
    super.delete();
  }

  public OpenSimObject copy() {
    long cPtr = opensimModelJNI.AbstractMuscle_copy__SWIG_0(swigCPtr, this);
    return (cPtr == 0) ? null : new OpenSimObject(cPtr, false);
  }

  public void setup(Model aModel) {
    opensimModelJNI.AbstractMuscle_setup(swigCPtr, this, Model.getCPtr(aModel), aModel);
  }

  public void setName(String aName) {
    opensimModelJNI.AbstractMuscle_setName(swigCPtr, this, aName);
  }

  public void copyData(AbstractMuscle aMuscle) {
    opensimModelJNI.AbstractMuscle_copyData(swigCPtr, this, AbstractMuscle.getCPtr(aMuscle), aMuscle);
  }

  public MusclePointSet getAttachmentSet() {
    return new MusclePointSet(opensimModelJNI.AbstractMuscle_getAttachmentSet(swigCPtr, this), false);
  }

  public ArrayMusclePoint getCurrentPath() {
    return new ArrayMusclePoint(opensimModelJNI.AbstractMuscle_getCurrentPath(swigCPtr, this), true);
  }

  public int getMuscleModelIndex() {
    return opensimModelJNI.AbstractMuscle_getMuscleModelIndex(swigCPtr, this);
  }

  public boolean getMuscleModelIndexUseDefault() {
    return opensimModelJNI.AbstractMuscle_getMuscleModelIndexUseDefault(swigCPtr, this);
  }

  public MuscleWrapSet getWrapSet() {
    return new MuscleWrapSet(opensimModelJNI.AbstractMuscle_getWrapSet(swigCPtr, this), false);
  }

  public MusclePoint addAttachmentPoint(int aIndex, AbstractBody aBody) {
    long cPtr = opensimModelJNI.AbstractMuscle_addAttachmentPoint(swigCPtr, this, aIndex, AbstractBody.getCPtr(aBody), aBody);
    return (cPtr == 0) ? null : new MusclePoint(cPtr, false);
  }

  public boolean canDeleteAttachmentPoint(int aIndex) {
    return opensimModelJNI.AbstractMuscle_canDeleteAttachmentPoint(swigCPtr, this, aIndex);
  }

  public boolean deleteAttachmentPoint(int aIndex) {
    return opensimModelJNI.AbstractMuscle_deleteAttachmentPoint(swigCPtr, this, aIndex);
  }

  public void addMuscleWrap(AbstractWrapObject aWrapObject) {
    opensimModelJNI.AbstractMuscle_addMuscleWrap(swigCPtr, this, AbstractWrapObject.getCPtr(aWrapObject), aWrapObject);
  }

  public void moveUpMuscleWrap(int aIndex) {
    opensimModelJNI.AbstractMuscle_moveUpMuscleWrap(swigCPtr, this, aIndex);
  }

  public void moveDownMuscleWrap(int aIndex) {
    opensimModelJNI.AbstractMuscle_moveDownMuscleWrap(swigCPtr, this, aIndex);
  }

  public void deleteMuscleWrap(int aIndex) {
    opensimModelJNI.AbstractMuscle_deleteMuscleWrap(swigCPtr, this, aIndex);
  }

  public double getPennationAngle() {
    return opensimModelJNI.AbstractMuscle_getPennationAngle(swigCPtr, this);
  }

  public double getPennationAngleAtOptimalFiberLength() {
    return opensimModelJNI.AbstractMuscle_getPennationAngleAtOptimalFiberLength(swigCPtr, this);
  }

  public double getLength() {
    return opensimModelJNI.AbstractMuscle_getLength(swigCPtr, this);
  }

  public double getTendonLength() {
    return opensimModelJNI.AbstractMuscle_getTendonLength(swigCPtr, this);
  }

  public double getFiberLength() {
    return opensimModelJNI.AbstractMuscle_getFiberLength(swigCPtr, this);
  }

  public double getNormalizedFiberLength() {
    return opensimModelJNI.AbstractMuscle_getNormalizedFiberLength(swigCPtr, this);
  }

  public double getFiberLengthAlongTendon() {
    return opensimModelJNI.AbstractMuscle_getFiberLengthAlongTendon(swigCPtr, this);
  }

  public double getShorteningSpeed() {
    return opensimModelJNI.AbstractMuscle_getShorteningSpeed(swigCPtr, this);
  }

  public double getFiberForce() {
    return opensimModelJNI.AbstractMuscle_getFiberForce(swigCPtr, this);
  }

  public double getActiveFiberForce() {
    return opensimModelJNI.AbstractMuscle_getActiveFiberForce(swigCPtr, this);
  }

  public double getPassiveFiberForce() {
    return opensimModelJNI.AbstractMuscle_getPassiveFiberForce(swigCPtr, this);
  }

  public double getActiveFiberForceAlongTendon() {
    return opensimModelJNI.AbstractMuscle_getActiveFiberForceAlongTendon(swigCPtr, this);
  }

  public double getPassiveFiberForceAlongTendon() {
    return opensimModelJNI.AbstractMuscle_getPassiveFiberForceAlongTendon(swigCPtr, this);
  }

  public double getMaxIsometricForce() {
    return opensimModelJNI.AbstractMuscle_getMaxIsometricForce(swigCPtr, this);
  }

  public double getActivation() {
    return opensimModelJNI.AbstractMuscle_getActivation(swigCPtr, this);
  }

  public void computeActuation() {
    opensimModelJNI.AbstractMuscle_computeActuation(swigCPtr, this);
  }

  public double computeIsometricForce(double activation) {
    return opensimModelJNI.AbstractMuscle_computeIsometricForce(swigCPtr, this, activation);
  }

  public double computeIsokineticForceAssumingInfinitelyStiffTendon(double aActivation) {
    return opensimModelJNI.AbstractMuscle_computeIsokineticForceAssumingInfinitelyStiffTendon(swigCPtr, this, aActivation);
  }

  public double computeMomentArm(AbstractCoordinate aCoord) {
    return opensimModelJNI.AbstractMuscle_computeMomentArm(swigCPtr, this, AbstractCoordinate.getCPtr(aCoord), aCoord);
  }

  public void computeMomentArms(ArrayDouble rMomentArms) {
    opensimModelJNI.AbstractMuscle_computeMomentArms(swigCPtr, this, ArrayDouble.getCPtr(rMomentArms), rMomentArms);
  }

  public double evaluateForceLengthVelocityCurve(double aActivation, double aNormalizedLength, double aNormalizedVelocity) {
    return opensimModelJNI.AbstractMuscle_evaluateForceLengthVelocityCurve(swigCPtr, this, aActivation, aNormalizedLength, aNormalizedVelocity);
  }

  public void computePath() {
    opensimModelJNI.AbstractMuscle_computePath(swigCPtr, this);
  }

  public void applyWrapObjects() {
    opensimModelJNI.AbstractMuscle_applyWrapObjects(swigCPtr, this);
  }

  public double _calc_muscle_length_change(AbstractWrapObject wo, SWIGTYPE_p_OpenSim__WrapResult wr) {
    return opensimModelJNI.AbstractMuscle__calc_muscle_length_change(swigCPtr, this, AbstractWrapObject.getCPtr(wo), wo, SWIGTYPE_p_OpenSim__WrapResult.getCPtr(wr));
  }

  public void calcLengthAfterPathComputation() {
    opensimModelJNI.AbstractMuscle_calcLengthAfterPathComputation(swigCPtr, this);
  }

  public double calcPennation(double aFiberLength, double aOptimalFiberLength, double aInitialPennationAngle) {
    return opensimModelJNI.AbstractMuscle_calcPennation(swigCPtr, this, aFiberLength, aOptimalFiberLength, aInitialPennationAngle);
  }

  public void invalidatePath() {
    opensimModelJNI.AbstractMuscle_invalidatePath(swigCPtr, this);
  }

  public void preScale(ScaleSet aScaleSet) {
    opensimModelJNI.AbstractMuscle_preScale(swigCPtr, this, ScaleSet.getCPtr(aScaleSet), aScaleSet);
  }

  public void scale(ScaleSet aScaleSet) {
    opensimModelJNI.AbstractMuscle_scale(swigCPtr, this, ScaleSet.getCPtr(aScaleSet), aScaleSet);
  }

  public void postScale(ScaleSet aScaleSet) {
    opensimModelJNI.AbstractMuscle_postScale(swigCPtr, this, ScaleSet.getCPtr(aScaleSet), aScaleSet);
  }

  public void apply() {
    opensimModelJNI.AbstractMuscle_apply(swigCPtr, this);
  }

  public VisibleObject getDisplayer() {
    long cPtr = opensimModelJNI.AbstractMuscle_getDisplayer(swigCPtr, this);
    return (cPtr == 0) ? null : new VisibleObject(cPtr, false);
  }

  public void updateDisplayer() {
    opensimModelJNI.AbstractMuscle_updateDisplayer(swigCPtr, this);
  }

  public static boolean isKindOf(String type) {
    return opensimModelJNI.AbstractMuscle_isKindOf(type);
  }

  public boolean isA(String type) {
    return opensimModelJNI.AbstractMuscle_isA(swigCPtr, this, type);
  }

  public static AbstractMuscle safeDownCast(OpenSimObject obj) {
    long cPtr = opensimModelJNI.AbstractMuscle_safeDownCast(OpenSimObject.getCPtr(obj), obj);
    return (cPtr == 0) ? null : new AbstractMuscle(cPtr, false);
  }

  public void copy(OpenSimObject aObject) {
    opensimModelJNI.AbstractMuscle_copy__SWIG_1(swigCPtr, this, OpenSimObject.getCPtr(aObject), aObject);
  }

}
