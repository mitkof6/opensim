/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.29
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.opensim.modeling;

public class AbstractDynamicsEngine extends OpenSimObject {
  private long swigCPtr;

  protected AbstractDynamicsEngine(long cPtr, boolean cMemoryOwn) {
    super(opensimModelJNI.SWIGAbstractDynamicsEngineUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  protected static long getCPtr(AbstractDynamicsEngine obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public void delete() {
    if(swigCPtr != 0 && swigCMemOwn) {
      swigCMemOwn = false;
      opensimModelJNI.delete_AbstractDynamicsEngine(swigCPtr);
    }
    swigCPtr = 0;
    super.delete();
  }

  public int getNumBodies() {
    return opensimModelJNI.AbstractDynamicsEngine_getNumBodies(swigCPtr);
  }

  public int getNumJoints() {
    return opensimModelJNI.AbstractDynamicsEngine_getNumJoints(swigCPtr);
  }

  public int getNumCoordinates() {
    return opensimModelJNI.AbstractDynamicsEngine_getNumCoordinates(swigCPtr);
  }

  public int getNumSpeeds() {
    return opensimModelJNI.AbstractDynamicsEngine_getNumSpeeds(swigCPtr);
  }

  public int getNumControls() {
    return opensimModelJNI.AbstractDynamicsEngine_getNumControls(swigCPtr);
  }

  public int getNumContacts() {
    return opensimModelJNI.AbstractDynamicsEngine_getNumContacts(swigCPtr);
  }

  public int getNumStates() {
    return opensimModelJNI.AbstractDynamicsEngine_getNumStates(swigCPtr);
  }

  public int getNumPseudoStates() {
    return opensimModelJNI.AbstractDynamicsEngine_getNumPseudoStates(swigCPtr);
  }

  public void setBodyName(int aIndex, String aName) {
    opensimModelJNI.AbstractDynamicsEngine_setBodyName(swigCPtr, aIndex, aName);
  }

  public String getBodyName(int aIndex) {
    return opensimModelJNI.AbstractDynamicsEngine_getBodyName(swigCPtr, aIndex);
  }

  public String getCoordinateName(int aIndex) {
    return opensimModelJNI.AbstractDynamicsEngine_getCoordinateName(swigCPtr, aIndex);
  }

  public String getSpeedName(int aIndex) {
    return opensimModelJNI.AbstractDynamicsEngine_getSpeedName(swigCPtr, aIndex);
  }

  public String getControlName(int aIndex) {
    return opensimModelJNI.AbstractDynamicsEngine_getControlName(swigCPtr, aIndex);
  }

  public String getStateName(int aIndex) {
    return opensimModelJNI.AbstractDynamicsEngine_getStateName(swigCPtr, aIndex);
  }

  public String getPseudoStateName(int aIndex) {
    return opensimModelJNI.AbstractDynamicsEngine_getPseudoStateName(swigCPtr, aIndex);
  }

  public int getBodyIndex(String aName) {
    return opensimModelJNI.AbstractDynamicsEngine_getBodyIndex(swigCPtr, aName);
  }

  public int getCoordinateIndex(String aName) {
    return opensimModelJNI.AbstractDynamicsEngine_getCoordinateIndex(swigCPtr, aName);
  }

  public int getSpeedIndex(String aName) {
    return opensimModelJNI.AbstractDynamicsEngine_getSpeedIndex(swigCPtr, aName);
  }

  public int getControlIndex(String aName) {
    return opensimModelJNI.AbstractDynamicsEngine_getControlIndex(swigCPtr, aName);
  }

  public int getStateIndex(String aName) {
    return opensimModelJNI.AbstractDynamicsEngine_getStateIndex(swigCPtr, aName);
  }

  public int getPseudoStateIndex(String aName) {
    return opensimModelJNI.AbstractDynamicsEngine_getPseudoStateIndex(swigCPtr, aName);
  }

  public Coordinate getCoordinate(String aName) {
    long cPtr = opensimModelJNI.AbstractDynamicsEngine_getCoordinate(swigCPtr, aName);
    return (cPtr == 0) ? null : new Coordinate(cPtr, false);
  }

  public void set(double aT, double[] aX, double[] aY) {
    opensimModelJNI.AbstractDynamicsEngine_set(swigCPtr, aT, aX, aY);
  }

  public void setInitialStates(double[] aYI) {
    opensimModelJNI.AbstractDynamicsEngine_setInitialStates(swigCPtr, aYI);
  }

  public void getInitialStates(double[] rYI) {
    opensimModelJNI.AbstractDynamicsEngine_getInitialStates(swigCPtr, rYI);
  }

  public double getInitialState(int aIndex) {
    return opensimModelJNI.AbstractDynamicsEngine_getInitialState__SWIG_0(swigCPtr, aIndex);
  }

  public double getInitialState(String aName) {
    return opensimModelJNI.AbstractDynamicsEngine_getInitialState__SWIG_1(swigCPtr, aName);
  }

  public void setStates(double[] aY) {
    opensimModelJNI.AbstractDynamicsEngine_setStates(swigCPtr, aY);
  }

  public void getStates(double[] rY) {
    opensimModelJNI.AbstractDynamicsEngine_getStates(swigCPtr, rY);
  }

  public double getState(int aIndex) {
    return opensimModelJNI.AbstractDynamicsEngine_getState__SWIG_0(swigCPtr, aIndex);
  }

  public double getState(String aName) {
    return opensimModelJNI.AbstractDynamicsEngine_getState__SWIG_1(swigCPtr, aName);
  }

  public void setInitialPseudoStates(double[] aYPI) {
    opensimModelJNI.AbstractDynamicsEngine_setInitialPseudoStates(swigCPtr, aYPI);
  }

  public void getInitialPseudoStates(double[] rYPI) {
    opensimModelJNI.AbstractDynamicsEngine_getInitialPseudoStates(swigCPtr, rYPI);
  }

  public double getInitialPseudoState(int aIndex) {
    return opensimModelJNI.AbstractDynamicsEngine_getInitialPseudoState__SWIG_0(swigCPtr, aIndex);
  }

  public double getInitialPseudoState(String aName) {
    return opensimModelJNI.AbstractDynamicsEngine_getInitialPseudoState__SWIG_1(swigCPtr, aName);
  }

  public void setPseudoStates(double[] aYP) {
    opensimModelJNI.AbstractDynamicsEngine_setPseudoStates(swigCPtr, aYP);
  }

  public void getPseudoStates(double[] rYP) {
    opensimModelJNI.AbstractDynamicsEngine_getPseudoStates(swigCPtr, rYP);
  }

  public double getPseudoState(int aIndex) {
    return opensimModelJNI.AbstractDynamicsEngine_getPseudoState(swigCPtr, aIndex);
  }

  public void setConfiguration(double[] aY) {
    opensimModelJNI.AbstractDynamicsEngine_setConfiguration__SWIG_0(swigCPtr, aY);
  }

  public void setConfiguration(double[] aQ, double[] aU) {
    opensimModelJNI.AbstractDynamicsEngine_setConfiguration__SWIG_1(swigCPtr, aQ, aU);
  }

  public void getCoordinateValues(double[] rQ) {
    opensimModelJNI.AbstractDynamicsEngine_getCoordinateValues(swigCPtr, rQ);
  }

  public double getCoordinateValue(int aIndex) {
    return opensimModelJNI.AbstractDynamicsEngine_getCoordinateValue__SWIG_0(swigCPtr, aIndex);
  }

  public double getCoordinateValue(String aName) {
    return opensimModelJNI.AbstractDynamicsEngine_getCoordinateValue__SWIG_1(swigCPtr, aName);
  }

  public void getSpeeds(double[] rU) {
    opensimModelJNI.AbstractDynamicsEngine_getSpeeds(swigCPtr, rU);
  }

  public double getSpeed(int aIndex) {
    return opensimModelJNI.AbstractDynamicsEngine_getSpeed__SWIG_0(swigCPtr, aIndex);
  }

  public double getSpeed(String aName) {
    return opensimModelJNI.AbstractDynamicsEngine_getSpeed__SWIG_1(swigCPtr, aName);
  }

  public void getAccelerations(double[] rDUDT) {
    opensimModelJNI.AbstractDynamicsEngine_getAccelerations(swigCPtr, rDUDT);
  }

  public double getAcceleration(int aIndex) {
    return opensimModelJNI.AbstractDynamicsEngine_getAcceleration__SWIG_0(swigCPtr, aIndex);
  }

  public double getAcceleration(String aSpeedName) {
    return opensimModelJNI.AbstractDynamicsEngine_getAcceleration__SWIG_1(swigCPtr, aSpeedName);
  }

  public void extractConfiguration(double[] aY, double[] rQ, double[] rU) {
    opensimModelJNI.AbstractDynamicsEngine_extractConfiguration(swigCPtr, aY, rQ, rU);
  }

  public int assemble(double aTime, SWIGTYPE_p_double rState, SWIGTYPE_p_int aLock, double aTol, int aMaxevals, SWIGTYPE_p_int rFcnt, SWIGTYPE_p_int rErr) {
    return opensimModelJNI.AbstractDynamicsEngine_assemble(swigCPtr, aTime, SWIGTYPE_p_double.getCPtr(rState), SWIGTYPE_p_int.getCPtr(aLock), aTol, aMaxevals, SWIGTYPE_p_int.getCPtr(rFcnt), SWIGTYPE_p_int.getCPtr(rErr));
  }

  public boolean scale(ScaleSet aScaleSet) {
    return opensimModelJNI.AbstractDynamicsEngine_scale__SWIG_0(swigCPtr, ScaleSet.getCPtr(aScaleSet));
  }

  public boolean scale(ScaleSet aScaleSet, boolean aPreserveMassDist, double aFinalMass) {
    return opensimModelJNI.AbstractDynamicsEngine_scale__SWIG_1(swigCPtr, ScaleSet.getCPtr(aScaleSet), aPreserveMassDist, aFinalMass);
  }

  public void getGravity(double[] rGrav) {
    opensimModelJNI.AbstractDynamicsEngine_getGravity(swigCPtr, rGrav);
  }

  public void setGravity(double[] aGrav) {
    opensimModelJNI.AbstractDynamicsEngine_setGravity(swigCPtr, aGrav);
  }

  public int getGroundBodyIndex() {
    return opensimModelJNI.AbstractDynamicsEngine_getGroundBodyIndex(swigCPtr);
  }

  public void setBodyToJointBodyLocal(int abody, double[] aBTJ) {
    opensimModelJNI.AbstractDynamicsEngine_setBodyToJointBodyLocal(swigCPtr, abody, aBTJ);
  }

  public void getBodyToJointBodyLocal(int aBody, double[] rBTJ) {
    opensimModelJNI.AbstractDynamicsEngine_getBodyToJointBodyLocal(swigCPtr, aBody, rBTJ);
  }

  public void setInboardToJointBodyLocal(int aBody, double[] aBTJ) {
    opensimModelJNI.AbstractDynamicsEngine_setInboardToJointBodyLocal(swigCPtr, aBody, aBTJ);
  }

  public void getInboardToJointBodyLocal(int aBody, double[] rBTJ) {
    opensimModelJNI.AbstractDynamicsEngine_getInboardToJointBodyLocal(swigCPtr, aBody, rBTJ);
  }

  public double getMass() {
    return opensimModelJNI.AbstractDynamicsEngine_getMass__SWIG_0(swigCPtr);
  }

  public double getMass(int aBody) {
    return opensimModelJNI.AbstractDynamicsEngine_getMass__SWIG_1(swigCPtr, aBody);
  }

  public int getInertiaBodyLocal(int aBody, SWIGTYPE_p_a_3__double rI) {
    return opensimModelJNI.AbstractDynamicsEngine_getInertiaBodyLocal__SWIG_0(swigCPtr, aBody, SWIGTYPE_p_a_3__double.getCPtr(rI));
  }

  public int getInertiaBodyLocal(int aBody, SWIGTYPE_p_double rI) {
    return opensimModelJNI.AbstractDynamicsEngine_getInertiaBodyLocal__SWIG_1(swigCPtr, aBody, SWIGTYPE_p_double.getCPtr(rI));
  }

  public void getSystemInertia(SWIGTYPE_p_double rM, double[] rCOM, SWIGTYPE_p_a_3__double rI) {
    opensimModelJNI.AbstractDynamicsEngine_getSystemInertia__SWIG_0(swigCPtr, SWIGTYPE_p_double.getCPtr(rM), rCOM, SWIGTYPE_p_a_3__double.getCPtr(rI));
  }

  public void getSystemInertia(SWIGTYPE_p_double rM, SWIGTYPE_p_double rCOM, SWIGTYPE_p_double rI) {
    opensimModelJNI.AbstractDynamicsEngine_getSystemInertia__SWIG_1(swigCPtr, SWIGTYPE_p_double.getCPtr(rM), SWIGTYPE_p_double.getCPtr(rCOM), SWIGTYPE_p_double.getCPtr(rI));
  }

  public void getPosition(int aBody, double[] aPoint, double[] rPos) {
    opensimModelJNI.AbstractDynamicsEngine_getPosition(swigCPtr, aBody, aPoint, rPos);
  }

  public void getVelocity(int aBody, double[] aPoint, double[] rVel) {
    opensimModelJNI.AbstractDynamicsEngine_getVelocity(swigCPtr, aBody, aPoint, rVel);
  }

  public void getAcceleration(int aBody, double[] aPoint, double[] rAcc) {
    opensimModelJNI.AbstractDynamicsEngine_getAcceleration__SWIG_2(swigCPtr, aBody, aPoint, rAcc);
  }

  public void getDirectionCosines(int aBody, SWIGTYPE_p_a_3__double rDirCos) {
    opensimModelJNI.AbstractDynamicsEngine_getDirectionCosines__SWIG_0(swigCPtr, aBody, SWIGTYPE_p_a_3__double.getCPtr(rDirCos));
  }

  public void getDirectionCosines(int aBody, SWIGTYPE_p_double rDirCos) {
    opensimModelJNI.AbstractDynamicsEngine_getDirectionCosines__SWIG_1(swigCPtr, aBody, SWIGTYPE_p_double.getCPtr(rDirCos));
  }

  public void getAngularVelocity(int aBody, double[] rAngVel) {
    opensimModelJNI.AbstractDynamicsEngine_getAngularVelocity(swigCPtr, aBody, rAngVel);
  }

  public void getAngularVelocityBodyLocal(int aBody, double[] rAngVel) {
    opensimModelJNI.AbstractDynamicsEngine_getAngularVelocityBodyLocal(swigCPtr, aBody, rAngVel);
  }

  public void getAngularAcceleration(int aBody, double[] rAngAcc) {
    opensimModelJNI.AbstractDynamicsEngine_getAngularAcceleration(swigCPtr, aBody, rAngAcc);
  }

  public void getAngularAccelerationBodyLocal(int aBody, double[] rAngAcc) {
    opensimModelJNI.AbstractDynamicsEngine_getAngularAccelerationBodyLocal(swigCPtr, aBody, rAngAcc);
  }

  public void applyForce(int aBody, double[] aPoint, double[] aForce) {
    opensimModelJNI.AbstractDynamicsEngine_applyForce(swigCPtr, aBody, aPoint, aForce);
  }

  public void applyForces(int aN, int[] aBodies, SWIGTYPE_p_a_3__double aPoints, SWIGTYPE_p_a_3__double aForces) {
    opensimModelJNI.AbstractDynamicsEngine_applyForces__SWIG_0(swigCPtr, aN, aBodies, SWIGTYPE_p_a_3__double.getCPtr(aPoints), SWIGTYPE_p_a_3__double.getCPtr(aForces));
  }

  public void applyForces(int aN, int[] aBodies, SWIGTYPE_p_double aPoints, SWIGTYPE_p_double aForces) {
    opensimModelJNI.AbstractDynamicsEngine_applyForces__SWIG_1(swigCPtr, aN, aBodies, SWIGTYPE_p_double.getCPtr(aPoints), SWIGTYPE_p_double.getCPtr(aForces));
  }

  public void applyForceBodyLocal(int aBody, double[] aPoint, double[] aForce) {
    opensimModelJNI.AbstractDynamicsEngine_applyForceBodyLocal(swigCPtr, aBody, aPoint, aForce);
  }

  public void applyForcesBodyLocal(int aN, int[] aBodies, SWIGTYPE_p_a_3__double aPoints, SWIGTYPE_p_a_3__double aForces) {
    opensimModelJNI.AbstractDynamicsEngine_applyForcesBodyLocal__SWIG_0(swigCPtr, aN, aBodies, SWIGTYPE_p_a_3__double.getCPtr(aPoints), SWIGTYPE_p_a_3__double.getCPtr(aForces));
  }

  public void applyForcesBodyLocal(int aN, int[] aBodies, SWIGTYPE_p_double aPoints, SWIGTYPE_p_double aForces) {
    opensimModelJNI.AbstractDynamicsEngine_applyForcesBodyLocal__SWIG_1(swigCPtr, aN, aBodies, SWIGTYPE_p_double.getCPtr(aPoints), SWIGTYPE_p_double.getCPtr(aForces));
  }

  public void applyTorque(int aBody, double[] aTorque) {
    opensimModelJNI.AbstractDynamicsEngine_applyTorque(swigCPtr, aBody, aTorque);
  }

  public void applyTorques(int aN, int[] aBodies, SWIGTYPE_p_a_3__double aTorques) {
    opensimModelJNI.AbstractDynamicsEngine_applyTorques__SWIG_0(swigCPtr, aN, aBodies, SWIGTYPE_p_a_3__double.getCPtr(aTorques));
  }

  public void applyTorques(int aN, int[] aBodies, SWIGTYPE_p_double aTorques) {
    opensimModelJNI.AbstractDynamicsEngine_applyTorques__SWIG_1(swigCPtr, aN, aBodies, SWIGTYPE_p_double.getCPtr(aTorques));
  }

  public void applyTorqueBodyLocal(int aBody, double[] aTorque) {
    opensimModelJNI.AbstractDynamicsEngine_applyTorqueBodyLocal(swigCPtr, aBody, aTorque);
  }

  public void applyTorquesBodyLocal(int aN, int[] aBodies, SWIGTYPE_p_a_3__double aTorques) {
    opensimModelJNI.AbstractDynamicsEngine_applyTorquesBodyLocal__SWIG_0(swigCPtr, aN, aBodies, SWIGTYPE_p_a_3__double.getCPtr(aTorques));
  }

  public void applyTorquesBodyLocal(int aN, int[] aBodies, SWIGTYPE_p_double aTorques) {
    opensimModelJNI.AbstractDynamicsEngine_applyTorquesBodyLocal__SWIG_1(swigCPtr, aN, aBodies, SWIGTYPE_p_double.getCPtr(aTorques));
  }

  public void applyGeneralizedForce(int aU, double aF) {
    opensimModelJNI.AbstractDynamicsEngine_applyGeneralizedForce(swigCPtr, aU, aF);
  }

  public void applyGeneralizedForces(double[] aF) {
    opensimModelJNI.AbstractDynamicsEngine_applyGeneralizedForces__SWIG_0(swigCPtr, aF);
  }

  public void applyGeneralizedForces(int aN, int[] aU, double[] aF) {
    opensimModelJNI.AbstractDynamicsEngine_applyGeneralizedForces__SWIG_1(swigCPtr, aN, aU, aF);
  }

  public double getNetAppliedGeneralizedForce(int aU) {
    return opensimModelJNI.AbstractDynamicsEngine_getNetAppliedGeneralizedForce(swigCPtr, aU);
  }

  public void computeGeneralizedForces(double[] aDUDT, double[] rF) {
    opensimModelJNI.AbstractDynamicsEngine_computeGeneralizedForces(swigCPtr, aDUDT, rF);
  }

  public void computeReactions(SWIGTYPE_p_a_3__double rForces, SWIGTYPE_p_a_3__double rTorques) {
    opensimModelJNI.AbstractDynamicsEngine_computeReactions(swigCPtr, SWIGTYPE_p_a_3__double.getCPtr(rForces), SWIGTYPE_p_a_3__double.getCPtr(rTorques));
  }

  public void formMassMatrix(SWIGTYPE_p_double rI) {
    opensimModelJNI.AbstractDynamicsEngine_formMassMatrix(swigCPtr, SWIGTYPE_p_double.getCPtr(rI));
  }

  public void formEulerTransform(int aBody, SWIGTYPE_p_double rE) {
    opensimModelJNI.AbstractDynamicsEngine_formEulerTransform(swigCPtr, aBody, SWIGTYPE_p_double.getCPtr(rE));
  }

  public void formJacobianTranslation(int aBody, double[] aPoint, SWIGTYPE_p_double rJ, int aRefBody) {
    opensimModelJNI.AbstractDynamicsEngine_formJacobianTranslation__SWIG_0(swigCPtr, aBody, aPoint, SWIGTYPE_p_double.getCPtr(rJ), aRefBody);
  }

  public void formJacobianTranslation(int aBody, double[] aPoint, SWIGTYPE_p_double rJ) {
    opensimModelJNI.AbstractDynamicsEngine_formJacobianTranslation__SWIG_1(swigCPtr, aBody, aPoint, SWIGTYPE_p_double.getCPtr(rJ));
  }

  public void formJacobianOrientation(int aBody, SWIGTYPE_p_double rJ0, int aRefBody) {
    opensimModelJNI.AbstractDynamicsEngine_formJacobianOrientation__SWIG_0(swigCPtr, aBody, SWIGTYPE_p_double.getCPtr(rJ0), aRefBody);
  }

  public void formJacobianOrientation(int aBody, SWIGTYPE_p_double rJ0) {
    opensimModelJNI.AbstractDynamicsEngine_formJacobianOrientation__SWIG_1(swigCPtr, aBody, SWIGTYPE_p_double.getCPtr(rJ0));
  }

  public void formJacobianEuler(int aBody, SWIGTYPE_p_double rJE, int aRefBody) {
    opensimModelJNI.AbstractDynamicsEngine_formJacobianEuler__SWIG_0(swigCPtr, aBody, SWIGTYPE_p_double.getCPtr(rJE), aRefBody);
  }

  public void formJacobianEuler(int aBody, SWIGTYPE_p_double rJE) {
    opensimModelJNI.AbstractDynamicsEngine_formJacobianEuler__SWIG_1(swigCPtr, aBody, SWIGTYPE_p_double.getCPtr(rJE));
  }

  public int computeAccelerations(SWIGTYPE_p_double dqdt, SWIGTYPE_p_double dudt) {
    return opensimModelJNI.AbstractDynamicsEngine_computeAccelerations(swigCPtr, SWIGTYPE_p_double.getCPtr(dqdt), SWIGTYPE_p_double.getCPtr(dudt));
  }

  public void computeAuxiliaryDerivatives(SWIGTYPE_p_double dydt) {
    opensimModelJNI.AbstractDynamicsEngine_computeAuxiliaryDerivatives(swigCPtr, SWIGTYPE_p_double.getCPtr(dydt));
  }

  public void transform(int aBody1, double[] aVec1, int aBody2, double[] rVec2) {
    opensimModelJNI.AbstractDynamicsEngine_transform(swigCPtr, aBody1, aVec1, aBody2, rVec2);
  }

  public void transformPosition(int aBody, double[] aPos, double[] rPos) {
    opensimModelJNI.AbstractDynamicsEngine_transformPosition(swigCPtr, aBody, aPos, rPos);
  }

  public void convertQuaternionsToAngles(SWIGTYPE_p_double aQ, SWIGTYPE_p_double rQAng) {
    opensimModelJNI.AbstractDynamicsEngine_convertQuaternionsToAngles__SWIG_0(swigCPtr, SWIGTYPE_p_double.getCPtr(aQ), SWIGTYPE_p_double.getCPtr(rQAng));
  }

  public void convertQuaternionsToAngles(Storage rQStore) {
    opensimModelJNI.AbstractDynamicsEngine_convertQuaternionsToAngles__SWIG_1(swigCPtr, Storage.getCPtr(rQStore));
  }

  public void convertAnglesToQuaternions(SWIGTYPE_p_double aQAng, SWIGTYPE_p_double rQ) {
    opensimModelJNI.AbstractDynamicsEngine_convertAnglesToQuaternions__SWIG_0(swigCPtr, SWIGTYPE_p_double.getCPtr(aQAng), SWIGTYPE_p_double.getCPtr(rQ));
  }

  public void convertAnglesToQuaternions(Storage rQStore) {
    opensimModelJNI.AbstractDynamicsEngine_convertAnglesToQuaternions__SWIG_1(swigCPtr, Storage.getCPtr(rQStore));
  }

  public void convertRadiansToDegrees(SWIGTYPE_p_double aQRad, SWIGTYPE_p_double rQDeg) {
    opensimModelJNI.AbstractDynamicsEngine_convertRadiansToDegrees__SWIG_0(swigCPtr, SWIGTYPE_p_double.getCPtr(aQRad), SWIGTYPE_p_double.getCPtr(rQDeg));
  }

  public void convertRadiansToDegrees(Storage rQStore) {
    opensimModelJNI.AbstractDynamicsEngine_convertRadiansToDegrees__SWIG_1(swigCPtr, Storage.getCPtr(rQStore));
  }

  public void convertDegreesToRadians(SWIGTYPE_p_double aQDeg, SWIGTYPE_p_double rQRad) {
    opensimModelJNI.AbstractDynamicsEngine_convertDegreesToRadians__SWIG_0(swigCPtr, SWIGTYPE_p_double.getCPtr(aQDeg), SWIGTYPE_p_double.getCPtr(rQRad));
  }

  public void convertDegreesToRadians(Storage rQStore) {
    opensimModelJNI.AbstractDynamicsEngine_convertDegreesToRadians__SWIG_1(swigCPtr, Storage.getCPtr(rQStore));
  }

  public void convertAnglesToDirectionCosines(double aE1, double aE2, double aE3, SWIGTYPE_p_a_3__double rDirCos) {
    opensimModelJNI.AbstractDynamicsEngine_convertAnglesToDirectionCosines__SWIG_0(swigCPtr, aE1, aE2, aE3, SWIGTYPE_p_a_3__double.getCPtr(rDirCos));
  }

  public void convertAnglesToDirectionCosines(double aE1, double aE2, double aE3, SWIGTYPE_p_double rDirCos) {
    opensimModelJNI.AbstractDynamicsEngine_convertAnglesToDirectionCosines__SWIG_1(swigCPtr, aE1, aE2, aE3, SWIGTYPE_p_double.getCPtr(rDirCos));
  }

  public void convertDirectionCosinesToAngles(SWIGTYPE_p_a_3__double aDirCos, SWIGTYPE_p_double rE1, SWIGTYPE_p_double rE2, SWIGTYPE_p_double rE3) {
    opensimModelJNI.AbstractDynamicsEngine_convertDirectionCosinesToAngles__SWIG_0(swigCPtr, SWIGTYPE_p_a_3__double.getCPtr(aDirCos), SWIGTYPE_p_double.getCPtr(rE1), SWIGTYPE_p_double.getCPtr(rE2), SWIGTYPE_p_double.getCPtr(rE3));
  }

  public void convertDirectionCosinesToAngles(SWIGTYPE_p_double aDirCos, SWIGTYPE_p_double rE1, SWIGTYPE_p_double rE2, SWIGTYPE_p_double rE3) {
    opensimModelJNI.AbstractDynamicsEngine_convertDirectionCosinesToAngles__SWIG_1(swigCPtr, SWIGTYPE_p_double.getCPtr(aDirCos), SWIGTYPE_p_double.getCPtr(rE1), SWIGTYPE_p_double.getCPtr(rE2), SWIGTYPE_p_double.getCPtr(rE3));
  }

  public void convertDirectionCosinesToQuaternions(SWIGTYPE_p_a_3__double aDirCos, SWIGTYPE_p_double rQ1, SWIGTYPE_p_double rQ2, SWIGTYPE_p_double rQ3, SWIGTYPE_p_double rQ4) {
    opensimModelJNI.AbstractDynamicsEngine_convertDirectionCosinesToQuaternions__SWIG_0(swigCPtr, SWIGTYPE_p_a_3__double.getCPtr(aDirCos), SWIGTYPE_p_double.getCPtr(rQ1), SWIGTYPE_p_double.getCPtr(rQ2), SWIGTYPE_p_double.getCPtr(rQ3), SWIGTYPE_p_double.getCPtr(rQ4));
  }

  public void convertDirectionCosinesToQuaternions(SWIGTYPE_p_double aDirCos, SWIGTYPE_p_double rQ1, SWIGTYPE_p_double rQ2, SWIGTYPE_p_double rQ3, SWIGTYPE_p_double rQ4) {
    opensimModelJNI.AbstractDynamicsEngine_convertDirectionCosinesToQuaternions__SWIG_1(swigCPtr, SWIGTYPE_p_double.getCPtr(aDirCos), SWIGTYPE_p_double.getCPtr(rQ1), SWIGTYPE_p_double.getCPtr(rQ2), SWIGTYPE_p_double.getCPtr(rQ3), SWIGTYPE_p_double.getCPtr(rQ4));
  }

  public void convertQuaternionsToDirectionCosines(double aQ1, double aQ2, double aQ3, double aQ4, SWIGTYPE_p_a_3__double rDirCos) {
    opensimModelJNI.AbstractDynamicsEngine_convertQuaternionsToDirectionCosines__SWIG_0(swigCPtr, aQ1, aQ2, aQ3, aQ4, SWIGTYPE_p_a_3__double.getCPtr(rDirCos));
  }

  public void convertQuaternionsToDirectionCosines(double aQ1, double aQ2, double aQ3, double aQ4, SWIGTYPE_p_double rDirCos) {
    opensimModelJNI.AbstractDynamicsEngine_convertQuaternionsToDirectionCosines__SWIG_1(swigCPtr, aQ1, aQ2, aQ3, aQ4, SWIGTYPE_p_double.getCPtr(rDirCos));
  }

  public void computeContact() {
    opensimModelJNI.AbstractDynamicsEngine_computeContact(swigCPtr);
  }

  public void applyContactForce(int aID) {
    opensimModelJNI.AbstractDynamicsEngine_applyContactForce(swigCPtr, aID);
  }

  public void applyContactForces() {
    opensimModelJNI.AbstractDynamicsEngine_applyContactForces(swigCPtr);
  }

  public int getContactBodyA(int aID) {
    return opensimModelJNI.AbstractDynamicsEngine_getContactBodyA(swigCPtr, aID);
  }

  public int getContactBodyB(int aID) {
    return opensimModelJNI.AbstractDynamicsEngine_getContactBodyB(swigCPtr, aID);
  }

  public void setContactPointA(int aID, double[] aPoint) {
    opensimModelJNI.AbstractDynamicsEngine_setContactPointA(swigCPtr, aID, aPoint);
  }

  public void getContactPointA(int aID, double[] rPoint) {
    opensimModelJNI.AbstractDynamicsEngine_getContactPointA(swigCPtr, aID, rPoint);
  }

  public void setContactPointB(int aID, double[] aPoint) {
    opensimModelJNI.AbstractDynamicsEngine_setContactPointB(swigCPtr, aID, aPoint);
  }

  public void getContactPointB(int aID, double[] rPoint) {
    opensimModelJNI.AbstractDynamicsEngine_getContactPointB(swigCPtr, aID, rPoint);
  }

  public void getContactForce(int aID, double[] rF) {
    opensimModelJNI.AbstractDynamicsEngine_getContactForce__SWIG_0(swigCPtr, aID, rF);
  }

  public void getContactNormalForce(int aID, double[] rFP, double[] rFV, double[] rF) {
    opensimModelJNI.AbstractDynamicsEngine_getContactNormalForce(swigCPtr, aID, rFP, rFV, rF);
  }

  public void getContactTangentForce(int aID, double[] rFP, double[] rFV, double[] rF) {
    opensimModelJNI.AbstractDynamicsEngine_getContactTangentForce(swigCPtr, aID, rFP, rFV, rF);
  }

  public void getContactStiffness(int aID, double[] aDX, double[] rDF) {
    opensimModelJNI.AbstractDynamicsEngine_getContactStiffness(swigCPtr, aID, aDX, rDF);
  }

  public void getContactViscosity(int aID, double[] aDV, double[] rDF) {
    opensimModelJNI.AbstractDynamicsEngine_getContactViscosity(swigCPtr, aID, aDV, rDF);
  }

  public void getContactFrictionCorrection(int aID, double[] aDFFric) {
    opensimModelJNI.AbstractDynamicsEngine_getContactFrictionCorrection(swigCPtr, aID, aDFFric);
  }

  public double getContactForce(int aID) {
    return opensimModelJNI.AbstractDynamicsEngine_getContactForce__SWIG_1(swigCPtr, aID);
  }

  public double getContactSpeed(int aID) {
    return opensimModelJNI.AbstractDynamicsEngine_getContactSpeed(swigCPtr, aID);
  }

  public double getContactPower(int aID) {
    return opensimModelJNI.AbstractDynamicsEngine_getContactPower(swigCPtr, aID);
  }

}
