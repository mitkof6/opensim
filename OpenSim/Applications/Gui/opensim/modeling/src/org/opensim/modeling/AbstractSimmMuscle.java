/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.31
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.opensim.modeling;

public class AbstractSimmMuscle extends AbstractActuator {
  private long swigCPtr;

  public AbstractSimmMuscle(long cPtr, boolean cMemoryOwn) {
    super(opensimModelJNI.SWIGStorageUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  public static long getCPtr(AbstractSimmMuscle obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if(swigCPtr != 0 && swigCMemOwn) {
      swigCMemOwn = false;
      opensimModelJNI.delete_AbstractSimmMuscle(swigCPtr);
    }
    swigCPtr = 0;
    super.delete();
  }

  public OpenSimObject copy() {
    long cPtr = opensimModelJNI.AbstractSimmMuscle_copy(swigCPtr, this);
    return (cPtr == 0) ? null : new OpenSimObject(cPtr, false);
  }

  public void setup(AbstractModel aModel) {
    opensimModelJNI.AbstractSimmMuscle_setup(swigCPtr, this, AbstractModel.getCPtr(aModel), aModel);
  }

  public static AbstractSimmMuscle safeDownCast(OpenSimObject aObject) {
    long cPtr = opensimModelJNI.AbstractSimmMuscle_safeDownCast(OpenSimObject.getCPtr(aObject), aObject);
    return (cPtr == 0) ? null : new AbstractSimmMuscle(cPtr, false);
  }

  public void copyData(AbstractSimmMuscle aMuscle) {
    opensimModelJNI.AbstractSimmMuscle_copyData(swigCPtr, this, AbstractSimmMuscle.getCPtr(aMuscle), aMuscle);
  }

  public SimmMusclePointSet getAttachmentSet() {
    return new SimmMusclePointSet(opensimModelJNI.AbstractSimmMuscle_getAttachmentSet(swigCPtr, this), false);
  }

  public int getMuscleModelIndex() {
    return opensimModelJNI.AbstractSimmMuscle_getMuscleModelIndex(swigCPtr, this);
  }

  public boolean getMuscleModelIndexUseDefault() {
    return opensimModelJNI.AbstractSimmMuscle_getMuscleModelIndexUseDefault(swigCPtr, this);
  }

  public ArrayStr getGroupNames() {
    long cPtr = opensimModelJNI.AbstractSimmMuscle_getGroupNames(swigCPtr, this);
    return (cPtr == 0) ? null : new ArrayStr(cPtr, false);
  }

  public void preScale(ScaleSet aScaleSet) {
    opensimModelJNI.AbstractSimmMuscle_preScale(swigCPtr, this, ScaleSet.getCPtr(aScaleSet), aScaleSet);
  }

  public void scale(ScaleSet aScaleSet) {
    opensimModelJNI.AbstractSimmMuscle_scale(swigCPtr, this, ScaleSet.getCPtr(aScaleSet), aScaleSet);
  }

  public void postScale(ScaleSet aScaleSet) {
    opensimModelJNI.AbstractSimmMuscle_postScale(swigCPtr, this, ScaleSet.getCPtr(aScaleSet), aScaleSet);
  }

  public void calculatePath() {
    opensimModelJNI.AbstractSimmMuscle_calculatePath(swigCPtr, this);
  }

  public void applyWrapObjects() {
    opensimModelJNI.AbstractSimmMuscle_applyWrapObjects(swigCPtr, this);
  }

  public double _calc_muscle_length_change(SWIGTYPE_p_OpenSim__AbstractWrapObject wo, SWIGTYPE_p_OpenSim__WrapResult wr) {
    return opensimModelJNI.AbstractSimmMuscle__calc_muscle_length_change(swigCPtr, this, SWIGTYPE_p_OpenSim__AbstractWrapObject.getCPtr(wo), SWIGTYPE_p_OpenSim__WrapResult.getCPtr(wr));
  }

  public void calculateLength() {
    opensimModelJNI.AbstractSimmMuscle_calculateLength(swigCPtr, this);
  }

  public double getLength() {
    return opensimModelJNI.AbstractSimmMuscle_getLength(swigCPtr, this);
  }

  public double getMomentArm(AbstractCoordinate aCoord) {
    return opensimModelJNI.AbstractSimmMuscle_getMomentArm(swigCPtr, this, AbstractCoordinate.getCPtr(aCoord), aCoord);
  }

  public double getSpeed() {
    return opensimModelJNI.AbstractSimmMuscle_getSpeed(swigCPtr, this);
  }

  public double calcPennation(double aFiberLength, double aOptimalFiberLength, double aInitialPennationAngle) {
    return opensimModelJNI.AbstractSimmMuscle_calcPennation(swigCPtr, this, aFiberLength, aOptimalFiberLength, aInitialPennationAngle);
  }

  public void computeActuation() {
    opensimModelJNI.AbstractSimmMuscle_computeActuation(swigCPtr, this);
  }

  public void invalidatePath() {
    opensimModelJNI.AbstractSimmMuscle_invalidatePath(swigCPtr, this);
  }

  public void apply() {
    opensimModelJNI.AbstractSimmMuscle_apply(swigCPtr, this);
  }

  public void peteTest() {
    opensimModelJNI.AbstractSimmMuscle_peteTest(swigCPtr, this);
  }

  public VisibleObject getDisplayer() {
    long cPtr = opensimModelJNI.AbstractSimmMuscle_getDisplayer(swigCPtr, this);
    return (cPtr == 0) ? null : new VisibleObject(cPtr, false);
  }

  public void updateGeometry() {
    opensimModelJNI.AbstractSimmMuscle_updateGeometry(swigCPtr, this);
  }

  public static void registerTypes() {
    opensimModelJNI.AbstractSimmMuscle_registerTypes();
  }

}
