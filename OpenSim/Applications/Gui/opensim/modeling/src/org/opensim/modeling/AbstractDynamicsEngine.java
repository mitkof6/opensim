/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.31
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.opensim.modeling;

public class AbstractDynamicsEngine extends OpenSimObject {
  private long swigCPtr;

  public AbstractDynamicsEngine(long cPtr, boolean cMemoryOwn) {
    super(opensimModelJNI.SWIGStorageUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  public static long getCPtr(AbstractDynamicsEngine obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if(swigCPtr != 0 && swigCMemOwn) {
      swigCMemOwn = false;
      opensimModelJNI.delete_AbstractDynamicsEngine(swigCPtr);
    }
    swigCPtr = 0;
    super.delete();
  }

  public OpenSimObject copy() {
    long cPtr = opensimModelJNI.AbstractDynamicsEngine_copy(swigCPtr, this);
    return (cPtr == 0) ? null : new OpenSimObject(cPtr, false);
  }

  public void setup(Model aModel) {
    opensimModelJNI.AbstractDynamicsEngine_setup(swigCPtr, this, Model.getCPtr(aModel), aModel);
  }

  public int getNumBodies() {
    return opensimModelJNI.AbstractDynamicsEngine_getNumBodies(swigCPtr, this);
  }

  public int getNumJoints() {
    return opensimModelJNI.AbstractDynamicsEngine_getNumJoints(swigCPtr, this);
  }

  public int getNumCoordinates() {
    return opensimModelJNI.AbstractDynamicsEngine_getNumCoordinates(swigCPtr, this);
  }

  public int getNumSpeeds() {
    return opensimModelJNI.AbstractDynamicsEngine_getNumSpeeds(swigCPtr, this);
  }

  public int getNumMarkers() {
    return opensimModelJNI.AbstractDynamicsEngine_getNumMarkers(swigCPtr, this);
  }

  public Model getModel() {
    long cPtr = opensimModelJNI.AbstractDynamicsEngine_getModel(swigCPtr, this);
    return (cPtr == 0) ? null : new Model(cPtr, false);
  }

  public void getGravity(double[] rGrav) {
    opensimModelJNI.AbstractDynamicsEngine_getGravity(swigCPtr, this, rGrav);
  }

  public boolean setGravity(double[] aGrav) {
    return opensimModelJNI.AbstractDynamicsEngine_setGravity(swigCPtr, this, aGrav);
  }

  public BodySet getBodySet() {
    long cPtr = opensimModelJNI.AbstractDynamicsEngine_getBodySet(swigCPtr, this);
    return (cPtr == 0) ? null : new BodySet(cPtr, false);
  }

  public AbstractBody getGroundBody() {
    return new AbstractBody(opensimModelJNI.AbstractDynamicsEngine_getGroundBody(swigCPtr, this), false);
  }

  public AbstractBody getLeafBody(AbstractJoint aJoint) {
    long cPtr = opensimModelJNI.AbstractDynamicsEngine_getLeafBody(swigCPtr, this, AbstractJoint.getCPtr(aJoint), aJoint);
    return (cPtr == 0) ? null : new AbstractBody(cPtr, false);
  }

  public AbstractWrapObject getWrapObject(String aName) {
    long cPtr = opensimModelJNI.AbstractDynamicsEngine_getWrapObject(swigCPtr, this, aName);
    return (cPtr == 0) ? null : new AbstractWrapObject(cPtr, false);
  }

  public JointSet getJointSet() {
    long cPtr = opensimModelJNI.AbstractDynamicsEngine_getJointSet(swigCPtr, this);
    return (cPtr == 0) ? null : new JointSet(cPtr, false);
  }

  public CoordinateSet getCoordinateSet() {
    long cPtr = opensimModelJNI.AbstractDynamicsEngine_getCoordinateSet(swigCPtr, this);
    return (cPtr == 0) ? null : new CoordinateSet(cPtr, false);
  }

  public void updateCoordinateSet(CoordinateSet aCoordinateSet) {
    opensimModelJNI.AbstractDynamicsEngine_updateCoordinateSet(swigCPtr, this, CoordinateSet.getCPtr(aCoordinateSet), aCoordinateSet);
  }

  public void getUnlockedCoordinates(CoordinateSet aUnlockedCoordinates) {
    opensimModelJNI.AbstractDynamicsEngine_getUnlockedCoordinates(swigCPtr, this, CoordinateSet.getCPtr(aUnlockedCoordinates), aUnlockedCoordinates);
  }

  public AbstractDof findUnconstrainedDof(AbstractCoordinate aCoordinate, AbstractJoint rJoint) {
    long cPtr = opensimModelJNI.AbstractDynamicsEngine_findUnconstrainedDof(swigCPtr, this, AbstractCoordinate.getCPtr(aCoordinate), aCoordinate, AbstractJoint.getCPtr(rJoint));
    return (cPtr == 0) ? null : new AbstractDof(cPtr, false);
  }

  public SWIGTYPE_p_OpenSim__SpeedSet getSpeedSet() {
    long cPtr = opensimModelJNI.AbstractDynamicsEngine_getSpeedSet(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_OpenSim__SpeedSet(cPtr, false);
  }

  public MarkerSet getMarkerSet() {
    long cPtr = opensimModelJNI.AbstractDynamicsEngine_getMarkerSet(swigCPtr, this);
    return (cPtr == 0) ? null : new MarkerSet(cPtr, false);
  }

  public void writeMarkerFile(String aFileName) {
    opensimModelJNI.AbstractDynamicsEngine_writeMarkerFile(swigCPtr, this, aFileName);
  }

  public int replaceMarkerSet(MarkerSet aMarkerSet) {
    return opensimModelJNI.AbstractDynamicsEngine_replaceMarkerSet(swigCPtr, this, MarkerSet.getCPtr(aMarkerSet), aMarkerSet);
  }

  public void updateMarkerSet(MarkerSet aMarkerSet) {
    opensimModelJNI.AbstractDynamicsEngine_updateMarkerSet(swigCPtr, this, MarkerSet.getCPtr(aMarkerSet), aMarkerSet);
  }

  public int deleteUnusedMarkers(ArrayStr aMarkerNames) {
    return opensimModelJNI.AbstractDynamicsEngine_deleteUnusedMarkers(swigCPtr, this, ArrayStr.getCPtr(aMarkerNames), aMarkerNames);
  }

  public void setConfiguration(double[] aY) {
    opensimModelJNI.AbstractDynamicsEngine_setConfiguration__SWIG_0(swigCPtr, this, aY);
  }

  public void getConfiguration(double[] rY) {
    opensimModelJNI.AbstractDynamicsEngine_getConfiguration__SWIG_0(swigCPtr, this, rY);
  }

  public void setConfiguration(double[] aQ, double[] aU) {
    opensimModelJNI.AbstractDynamicsEngine_setConfiguration__SWIG_1(swigCPtr, this, aQ, aU);
  }

  public void getConfiguration(double[] rQ, double[] rU) {
    opensimModelJNI.AbstractDynamicsEngine_getConfiguration__SWIG_1(swigCPtr, this, rQ, rU);
  }

  public void getCoordinates(double[] rQ) {
    opensimModelJNI.AbstractDynamicsEngine_getCoordinates(swigCPtr, this, rQ);
  }

  public void getSpeeds(double[] rU) {
    opensimModelJNI.AbstractDynamicsEngine_getSpeeds(swigCPtr, this, rU);
  }

  public void getAccelerations(double[] rDUDT) {
    opensimModelJNI.AbstractDynamicsEngine_getAccelerations(swigCPtr, this, rDUDT);
  }

  public void extractConfiguration(double[] aY, double[] rQ, double[] rU) {
    opensimModelJNI.AbstractDynamicsEngine_extractConfiguration(swigCPtr, this, aY, rQ, rU);
  }

  public void applyDefaultConfiguration() {
    opensimModelJNI.AbstractDynamicsEngine_applyDefaultConfiguration(swigCPtr, this);
  }

  public int assemble(double aTime, SWIGTYPE_p_double rState, SWIGTYPE_p_int aLock, double aTol, int aMaxevals, SWIGTYPE_p_int rFcnt, SWIGTYPE_p_int rErr) {
    return opensimModelJNI.AbstractDynamicsEngine_assemble(swigCPtr, this, aTime, SWIGTYPE_p_double.getCPtr(rState), SWIGTYPE_p_int.getCPtr(aLock), aTol, aMaxevals, SWIGTYPE_p_int.getCPtr(rFcnt), SWIGTYPE_p_int.getCPtr(rErr));
  }

  public boolean scale(ScaleSet aScaleSet, double aFinalMass, boolean aPreserveMassDist) {
    return opensimModelJNI.AbstractDynamicsEngine_scale__SWIG_0(swigCPtr, this, ScaleSet.getCPtr(aScaleSet), aScaleSet, aFinalMass, aPreserveMassDist);
  }

  public boolean scale(ScaleSet aScaleSet, double aFinalMass) {
    return opensimModelJNI.AbstractDynamicsEngine_scale__SWIG_1(swigCPtr, this, ScaleSet.getCPtr(aScaleSet), aScaleSet, aFinalMass);
  }

  public boolean scale(ScaleSet aScaleSet) {
    return opensimModelJNI.AbstractDynamicsEngine_scale__SWIG_2(swigCPtr, this, ScaleSet.getCPtr(aScaleSet), aScaleSet);
  }

  public double getMass() {
    return opensimModelJNI.AbstractDynamicsEngine_getMass(swigCPtr, this);
  }

  public void getSystemInertia(SWIGTYPE_p_double rM, double[] rCOM, SWIGTYPE_p_a_3__double rI) {
    opensimModelJNI.AbstractDynamicsEngine_getSystemInertia__SWIG_0(swigCPtr, this, SWIGTYPE_p_double.getCPtr(rM), rCOM, SWIGTYPE_p_a_3__double.getCPtr(rI));
  }

  public void getSystemInertia(SWIGTYPE_p_double rM, SWIGTYPE_p_double rCOM, SWIGTYPE_p_double rI) {
    opensimModelJNI.AbstractDynamicsEngine_getSystemInertia__SWIG_1(swigCPtr, this, SWIGTYPE_p_double.getCPtr(rM), SWIGTYPE_p_double.getCPtr(rCOM), SWIGTYPE_p_double.getCPtr(rI));
  }

  public void getPosition(AbstractBody aBody, double[] aPoint, double[] rPos) {
    opensimModelJNI.AbstractDynamicsEngine_getPosition(swigCPtr, this, AbstractBody.getCPtr(aBody), aBody, aPoint, rPos);
  }

  public void getVelocity(AbstractBody aBody, double[] aPoint, double[] rVel) {
    opensimModelJNI.AbstractDynamicsEngine_getVelocity(swigCPtr, this, AbstractBody.getCPtr(aBody), aBody, aPoint, rVel);
  }

  public void getAcceleration(AbstractBody aBody, double[] aPoint, double[] rAcc) {
    opensimModelJNI.AbstractDynamicsEngine_getAcceleration(swigCPtr, this, AbstractBody.getCPtr(aBody), aBody, aPoint, rAcc);
  }

  public void getDirectionCosines(AbstractBody aBody, SWIGTYPE_p_a_3__double rDirCos) {
    opensimModelJNI.AbstractDynamicsEngine_getDirectionCosines__SWIG_0(swigCPtr, this, AbstractBody.getCPtr(aBody), aBody, SWIGTYPE_p_a_3__double.getCPtr(rDirCos));
  }

  public void getDirectionCosines(AbstractBody aBody, SWIGTYPE_p_double rDirCos) {
    opensimModelJNI.AbstractDynamicsEngine_getDirectionCosines__SWIG_1(swigCPtr, this, AbstractBody.getCPtr(aBody), aBody, SWIGTYPE_p_double.getCPtr(rDirCos));
  }

  public void getAngularVelocity(AbstractBody aBody, double[] rAngVel) {
    opensimModelJNI.AbstractDynamicsEngine_getAngularVelocity(swigCPtr, this, AbstractBody.getCPtr(aBody), aBody, rAngVel);
  }

  public void getAngularVelocityBodyLocal(AbstractBody aBody, double[] rAngVel) {
    opensimModelJNI.AbstractDynamicsEngine_getAngularVelocityBodyLocal(swigCPtr, this, AbstractBody.getCPtr(aBody), aBody, rAngVel);
  }

  public void getAngularAcceleration(AbstractBody aBody, double[] rAngAcc) {
    opensimModelJNI.AbstractDynamicsEngine_getAngularAcceleration(swigCPtr, this, AbstractBody.getCPtr(aBody), aBody, rAngAcc);
  }

  public void getAngularAccelerationBodyLocal(AbstractBody aBody, double[] rAngAcc) {
    opensimModelJNI.AbstractDynamicsEngine_getAngularAccelerationBodyLocal(swigCPtr, this, AbstractBody.getCPtr(aBody), aBody, rAngAcc);
  }

  public Transform getTransform(AbstractBody aBody) {
    return new Transform(opensimModelJNI.AbstractDynamicsEngine_getTransform(swigCPtr, this, AbstractBody.getCPtr(aBody), aBody), true);
  }

  public void applyForce(AbstractBody aBody, double[] aPoint, double[] aForce) {
    opensimModelJNI.AbstractDynamicsEngine_applyForce(swigCPtr, this, AbstractBody.getCPtr(aBody), aBody, aPoint, aForce);
  }

  public void applyForces(int aN, SWIGTYPE_p_p_OpenSim__AbstractBody aBodies, SWIGTYPE_p_a_3__double aPoints, SWIGTYPE_p_a_3__double aForces) {
    opensimModelJNI.AbstractDynamicsEngine_applyForces__SWIG_0(swigCPtr, this, aN, SWIGTYPE_p_p_OpenSim__AbstractBody.getCPtr(aBodies), SWIGTYPE_p_a_3__double.getCPtr(aPoints), SWIGTYPE_p_a_3__double.getCPtr(aForces));
  }

  public void applyForces(int aN, SWIGTYPE_p_p_OpenSim__AbstractBody aBodies, SWIGTYPE_p_double aPoints, SWIGTYPE_p_double aForces) {
    opensimModelJNI.AbstractDynamicsEngine_applyForces__SWIG_1(swigCPtr, this, aN, SWIGTYPE_p_p_OpenSim__AbstractBody.getCPtr(aBodies), SWIGTYPE_p_double.getCPtr(aPoints), SWIGTYPE_p_double.getCPtr(aForces));
  }

  public void applyForceBodyLocal(AbstractBody aBody, double[] aPoint, double[] aForce) {
    opensimModelJNI.AbstractDynamicsEngine_applyForceBodyLocal(swigCPtr, this, AbstractBody.getCPtr(aBody), aBody, aPoint, aForce);
  }

  public void applyForcesBodyLocal(int aN, SWIGTYPE_p_p_OpenSim__AbstractBody aBodies, SWIGTYPE_p_a_3__double aPoints, SWIGTYPE_p_a_3__double aForces) {
    opensimModelJNI.AbstractDynamicsEngine_applyForcesBodyLocal__SWIG_0(swigCPtr, this, aN, SWIGTYPE_p_p_OpenSim__AbstractBody.getCPtr(aBodies), SWIGTYPE_p_a_3__double.getCPtr(aPoints), SWIGTYPE_p_a_3__double.getCPtr(aForces));
  }

  public void applyForcesBodyLocal(int aN, SWIGTYPE_p_p_OpenSim__AbstractBody aBodies, SWIGTYPE_p_double aPoints, SWIGTYPE_p_double aForces) {
    opensimModelJNI.AbstractDynamicsEngine_applyForcesBodyLocal__SWIG_1(swigCPtr, this, aN, SWIGTYPE_p_p_OpenSim__AbstractBody.getCPtr(aBodies), SWIGTYPE_p_double.getCPtr(aPoints), SWIGTYPE_p_double.getCPtr(aForces));
  }

  public void applyTorque(AbstractBody aBody, double[] aTorque) {
    opensimModelJNI.AbstractDynamicsEngine_applyTorque(swigCPtr, this, AbstractBody.getCPtr(aBody), aBody, aTorque);
  }

  public void applyTorques(int aN, SWIGTYPE_p_p_OpenSim__AbstractBody aBodies, SWIGTYPE_p_a_3__double aTorques) {
    opensimModelJNI.AbstractDynamicsEngine_applyTorques__SWIG_0(swigCPtr, this, aN, SWIGTYPE_p_p_OpenSim__AbstractBody.getCPtr(aBodies), SWIGTYPE_p_a_3__double.getCPtr(aTorques));
  }

  public void applyTorques(int aN, SWIGTYPE_p_p_OpenSim__AbstractBody aBodies, SWIGTYPE_p_double aTorques) {
    opensimModelJNI.AbstractDynamicsEngine_applyTorques__SWIG_1(swigCPtr, this, aN, SWIGTYPE_p_p_OpenSim__AbstractBody.getCPtr(aBodies), SWIGTYPE_p_double.getCPtr(aTorques));
  }

  public void applyTorqueBodyLocal(AbstractBody aBody, double[] aTorque) {
    opensimModelJNI.AbstractDynamicsEngine_applyTorqueBodyLocal(swigCPtr, this, AbstractBody.getCPtr(aBody), aBody, aTorque);
  }

  public void applyTorquesBodyLocal(int aN, SWIGTYPE_p_p_OpenSim__AbstractBody aBodies, SWIGTYPE_p_a_3__double aTorques) {
    opensimModelJNI.AbstractDynamicsEngine_applyTorquesBodyLocal__SWIG_0(swigCPtr, this, aN, SWIGTYPE_p_p_OpenSim__AbstractBody.getCPtr(aBodies), SWIGTYPE_p_a_3__double.getCPtr(aTorques));
  }

  public void applyTorquesBodyLocal(int aN, SWIGTYPE_p_p_OpenSim__AbstractBody aBodies, SWIGTYPE_p_double aTorques) {
    opensimModelJNI.AbstractDynamicsEngine_applyTorquesBodyLocal__SWIG_1(swigCPtr, this, aN, SWIGTYPE_p_p_OpenSim__AbstractBody.getCPtr(aBodies), SWIGTYPE_p_double.getCPtr(aTorques));
  }

  public void applyGeneralizedForce(AbstractCoordinate aU, double aF) {
    opensimModelJNI.AbstractDynamicsEngine_applyGeneralizedForce(swigCPtr, this, AbstractCoordinate.getCPtr(aU), aU, aF);
  }

  public void applyGeneralizedForces(double[] aF) {
    opensimModelJNI.AbstractDynamicsEngine_applyGeneralizedForces__SWIG_0(swigCPtr, this, aF);
  }

  public void applyGeneralizedForces(int aN, SWIGTYPE_p_p_OpenSim__AbstractCoordinate aU, double[] aF) {
    opensimModelJNI.AbstractDynamicsEngine_applyGeneralizedForces__SWIG_1(swigCPtr, this, aN, SWIGTYPE_p_p_OpenSim__AbstractCoordinate.getCPtr(aU), aF);
  }

  public double getNetAppliedGeneralizedForce(AbstractCoordinate aU) {
    return opensimModelJNI.AbstractDynamicsEngine_getNetAppliedGeneralizedForce(swigCPtr, this, AbstractCoordinate.getCPtr(aU), aU);
  }

  public void computeGeneralizedForces(double[] aDUDT, double[] rF) {
    opensimModelJNI.AbstractDynamicsEngine_computeGeneralizedForces(swigCPtr, this, aDUDT, rF);
  }

  public void computeReactions(SWIGTYPE_p_a_3__double rForces, SWIGTYPE_p_a_3__double rTorques) {
    opensimModelJNI.AbstractDynamicsEngine_computeReactions(swigCPtr, this, SWIGTYPE_p_a_3__double.getCPtr(rForces), SWIGTYPE_p_a_3__double.getCPtr(rTorques));
  }

  public void computeConstrainedCoordinates(SWIGTYPE_p_double rQ) {
    opensimModelJNI.AbstractDynamicsEngine_computeConstrainedCoordinates(swigCPtr, this, SWIGTYPE_p_double.getCPtr(rQ));
  }

  public void formCompleteStorages(Storage aQIn, Storage rQComplete, Storage rUComplete) {
    opensimModelJNI.AbstractDynamicsEngine_formCompleteStorages(swigCPtr, this, Storage.getCPtr(aQIn), aQIn, Storage.getCPtr(rQComplete), Storage.getCPtr(rUComplete));
  }

  public void formMassMatrix(SWIGTYPE_p_double rI) {
    opensimModelJNI.AbstractDynamicsEngine_formMassMatrix(swigCPtr, this, SWIGTYPE_p_double.getCPtr(rI));
  }

  public void formEulerTransform(AbstractBody aBody, SWIGTYPE_p_double rE) {
    opensimModelJNI.AbstractDynamicsEngine_formEulerTransform(swigCPtr, this, AbstractBody.getCPtr(aBody), aBody, SWIGTYPE_p_double.getCPtr(rE));
  }

  public void formJacobianTranslation(AbstractBody aBody, double[] aPoint, SWIGTYPE_p_double rJ, AbstractBody aRefBody) {
    opensimModelJNI.AbstractDynamicsEngine_formJacobianTranslation__SWIG_0(swigCPtr, this, AbstractBody.getCPtr(aBody), aBody, aPoint, SWIGTYPE_p_double.getCPtr(rJ), AbstractBody.getCPtr(aRefBody), aRefBody);
  }

  public void formJacobianTranslation(AbstractBody aBody, double[] aPoint, SWIGTYPE_p_double rJ) {
    opensimModelJNI.AbstractDynamicsEngine_formJacobianTranslation__SWIG_1(swigCPtr, this, AbstractBody.getCPtr(aBody), aBody, aPoint, SWIGTYPE_p_double.getCPtr(rJ));
  }

  public void formJacobianOrientation(AbstractBody aBody, SWIGTYPE_p_double rJ0, AbstractBody aRefBody) {
    opensimModelJNI.AbstractDynamicsEngine_formJacobianOrientation__SWIG_0(swigCPtr, this, AbstractBody.getCPtr(aBody), aBody, SWIGTYPE_p_double.getCPtr(rJ0), AbstractBody.getCPtr(aRefBody), aRefBody);
  }

  public void formJacobianOrientation(AbstractBody aBody, SWIGTYPE_p_double rJ0) {
    opensimModelJNI.AbstractDynamicsEngine_formJacobianOrientation__SWIG_1(swigCPtr, this, AbstractBody.getCPtr(aBody), aBody, SWIGTYPE_p_double.getCPtr(rJ0));
  }

  public void formJacobianEuler(AbstractBody aBody, SWIGTYPE_p_double rJE, AbstractBody aRefBody) {
    opensimModelJNI.AbstractDynamicsEngine_formJacobianEuler__SWIG_0(swigCPtr, this, AbstractBody.getCPtr(aBody), aBody, SWIGTYPE_p_double.getCPtr(rJE), AbstractBody.getCPtr(aRefBody), aRefBody);
  }

  public void formJacobianEuler(AbstractBody aBody, SWIGTYPE_p_double rJE) {
    opensimModelJNI.AbstractDynamicsEngine_formJacobianEuler__SWIG_1(swigCPtr, this, AbstractBody.getCPtr(aBody), aBody, SWIGTYPE_p_double.getCPtr(rJE));
  }

  public void computeDerivatives(SWIGTYPE_p_double dqdt, SWIGTYPE_p_double dudt) {
    opensimModelJNI.AbstractDynamicsEngine_computeDerivatives(swigCPtr, this, SWIGTYPE_p_double.getCPtr(dqdt), SWIGTYPE_p_double.getCPtr(dudt));
  }

  public void transform(AbstractBody aBodyFrom, double[] aVec, AbstractBody aBodyTo, double[] rVec) {
    opensimModelJNI.AbstractDynamicsEngine_transform__SWIG_0(swigCPtr, this, AbstractBody.getCPtr(aBodyFrom), aBodyFrom, aVec, AbstractBody.getCPtr(aBodyTo), aBodyTo, rVec);
  }

  public void transform(AbstractBody aBodyFrom, ArrayDouble aVec, AbstractBody aBodyTo, ArrayDouble rVec) {
    opensimModelJNI.AbstractDynamicsEngine_transform__SWIG_1(swigCPtr, this, AbstractBody.getCPtr(aBodyFrom), aBodyFrom, ArrayDouble.getCPtr(aVec), aVec, AbstractBody.getCPtr(aBodyTo), aBodyTo, ArrayDouble.getCPtr(rVec), rVec);
  }

  public void transformPosition(AbstractBody aBodyFrom, double[] aPos, AbstractBody aBodyTo, double[] rPos) {
    opensimModelJNI.AbstractDynamicsEngine_transformPosition__SWIG_0(swigCPtr, this, AbstractBody.getCPtr(aBodyFrom), aBodyFrom, aPos, AbstractBody.getCPtr(aBodyTo), aBodyTo, rPos);
  }

  public void transformPosition(AbstractBody aBodyFrom, ArrayDouble aPos, AbstractBody aBodyTo, ArrayDouble rPos) {
    opensimModelJNI.AbstractDynamicsEngine_transformPosition__SWIG_1(swigCPtr, this, AbstractBody.getCPtr(aBodyFrom), aBodyFrom, ArrayDouble.getCPtr(aPos), aPos, AbstractBody.getCPtr(aBodyTo), aBodyTo, ArrayDouble.getCPtr(rPos), rPos);
  }

  public void transformPosition(AbstractBody aBodyFrom, double[] aPos, double[] rPos) {
    opensimModelJNI.AbstractDynamicsEngine_transformPosition__SWIG_2(swigCPtr, this, AbstractBody.getCPtr(aBodyFrom), aBodyFrom, aPos, rPos);
  }

  public void transformPosition(AbstractBody aBodyFrom, ArrayDouble aPos, ArrayDouble rPos) {
    opensimModelJNI.AbstractDynamicsEngine_transformPosition__SWIG_3(swigCPtr, this, AbstractBody.getCPtr(aBodyFrom), aBodyFrom, ArrayDouble.getCPtr(aPos), aPos, ArrayDouble.getCPtr(rPos), rPos);
  }

  public double calcDistance(AbstractBody aBody1, double[] aPoint1, AbstractBody aBody2, double[] aPoint2) {
    return opensimModelJNI.AbstractDynamicsEngine_calcDistance__SWIG_0(swigCPtr, this, AbstractBody.getCPtr(aBody1), aBody1, aPoint1, AbstractBody.getCPtr(aBody2), aBody2, aPoint2);
  }

  public double calcDistance(AbstractBody aBody1, ArrayDouble aPoint1, AbstractBody aBody2, ArrayDouble aPoint2) {
    return opensimModelJNI.AbstractDynamicsEngine_calcDistance__SWIG_1(swigCPtr, this, AbstractBody.getCPtr(aBody1), aBody1, ArrayDouble.getCPtr(aPoint1), aPoint1, AbstractBody.getCPtr(aBody2), aBody2, ArrayDouble.getCPtr(aPoint2), aPoint2);
  }

  public void convertQuaternionsToAngles(SWIGTYPE_p_double aQ, SWIGTYPE_p_double rQAng) {
    opensimModelJNI.AbstractDynamicsEngine_convertQuaternionsToAngles__SWIG_0(swigCPtr, this, SWIGTYPE_p_double.getCPtr(aQ), SWIGTYPE_p_double.getCPtr(rQAng));
  }

  public void convertQuaternionsToAngles(Storage rQStore) {
    opensimModelJNI.AbstractDynamicsEngine_convertQuaternionsToAngles__SWIG_1(swigCPtr, this, Storage.getCPtr(rQStore), rQStore);
  }

  public void convertAnglesToQuaternions(SWIGTYPE_p_double aQAng, SWIGTYPE_p_double rQ) {
    opensimModelJNI.AbstractDynamicsEngine_convertAnglesToQuaternions__SWIG_0(swigCPtr, this, SWIGTYPE_p_double.getCPtr(aQAng), SWIGTYPE_p_double.getCPtr(rQ));
  }

  public void convertAnglesToQuaternions(Storage rQStore) {
    opensimModelJNI.AbstractDynamicsEngine_convertAnglesToQuaternions__SWIG_1(swigCPtr, this, Storage.getCPtr(rQStore), rQStore);
  }

  public void convertRadiansToDegrees(Storage rStorage) {
    opensimModelJNI.AbstractDynamicsEngine_convertRadiansToDegrees__SWIG_0(swigCPtr, this, Storage.getCPtr(rStorage), rStorage);
  }

  public void convertDegreesToRadians(Storage rStorage) {
    opensimModelJNI.AbstractDynamicsEngine_convertDegreesToRadians__SWIG_0(swigCPtr, this, Storage.getCPtr(rStorage), rStorage);
  }

  public void convertDegreesToRadians(SWIGTYPE_p_double aQDeg, SWIGTYPE_p_double rQRad) {
    opensimModelJNI.AbstractDynamicsEngine_convertDegreesToRadians__SWIG_1(swigCPtr, this, SWIGTYPE_p_double.getCPtr(aQDeg), SWIGTYPE_p_double.getCPtr(rQRad));
  }

  public void convertRadiansToDegrees(SWIGTYPE_p_double aQRad, SWIGTYPE_p_double rQDeg) {
    opensimModelJNI.AbstractDynamicsEngine_convertRadiansToDegrees__SWIG_1(swigCPtr, this, SWIGTYPE_p_double.getCPtr(aQRad), SWIGTYPE_p_double.getCPtr(rQDeg));
  }

  public void convertAnglesToDirectionCosines(double aE1, double aE2, double aE3, SWIGTYPE_p_a_3__double rDirCos) {
    opensimModelJNI.AbstractDynamicsEngine_convertAnglesToDirectionCosines__SWIG_0(swigCPtr, this, aE1, aE2, aE3, SWIGTYPE_p_a_3__double.getCPtr(rDirCos));
  }

  public void convertAnglesToDirectionCosines(double aE1, double aE2, double aE3, SWIGTYPE_p_double rDirCos) {
    opensimModelJNI.AbstractDynamicsEngine_convertAnglesToDirectionCosines__SWIG_1(swigCPtr, this, aE1, aE2, aE3, SWIGTYPE_p_double.getCPtr(rDirCos));
  }

  public void convertDirectionCosinesToAngles(SWIGTYPE_p_a_3__double aDirCos, SWIGTYPE_p_double rE1, SWIGTYPE_p_double rE2, SWIGTYPE_p_double rE3) {
    opensimModelJNI.AbstractDynamicsEngine_convertDirectionCosinesToAngles__SWIG_0(swigCPtr, this, SWIGTYPE_p_a_3__double.getCPtr(aDirCos), SWIGTYPE_p_double.getCPtr(rE1), SWIGTYPE_p_double.getCPtr(rE2), SWIGTYPE_p_double.getCPtr(rE3));
  }

  public void convertDirectionCosinesToAngles(SWIGTYPE_p_double aDirCos, SWIGTYPE_p_double rE1, SWIGTYPE_p_double rE2, SWIGTYPE_p_double rE3) {
    opensimModelJNI.AbstractDynamicsEngine_convertDirectionCosinesToAngles__SWIG_1(swigCPtr, this, SWIGTYPE_p_double.getCPtr(aDirCos), SWIGTYPE_p_double.getCPtr(rE1), SWIGTYPE_p_double.getCPtr(rE2), SWIGTYPE_p_double.getCPtr(rE3));
  }

  public void convertDirectionCosinesToQuaternions(SWIGTYPE_p_a_3__double aDirCos, SWIGTYPE_p_double rQ1, SWIGTYPE_p_double rQ2, SWIGTYPE_p_double rQ3, SWIGTYPE_p_double rQ4) {
    opensimModelJNI.AbstractDynamicsEngine_convertDirectionCosinesToQuaternions__SWIG_0(swigCPtr, this, SWIGTYPE_p_a_3__double.getCPtr(aDirCos), SWIGTYPE_p_double.getCPtr(rQ1), SWIGTYPE_p_double.getCPtr(rQ2), SWIGTYPE_p_double.getCPtr(rQ3), SWIGTYPE_p_double.getCPtr(rQ4));
  }

  public void convertDirectionCosinesToQuaternions(SWIGTYPE_p_double aDirCos, SWIGTYPE_p_double rQ1, SWIGTYPE_p_double rQ2, SWIGTYPE_p_double rQ3, SWIGTYPE_p_double rQ4) {
    opensimModelJNI.AbstractDynamicsEngine_convertDirectionCosinesToQuaternions__SWIG_1(swigCPtr, this, SWIGTYPE_p_double.getCPtr(aDirCos), SWIGTYPE_p_double.getCPtr(rQ1), SWIGTYPE_p_double.getCPtr(rQ2), SWIGTYPE_p_double.getCPtr(rQ3), SWIGTYPE_p_double.getCPtr(rQ4));
  }

  public void convertQuaternionsToDirectionCosines(double aQ1, double aQ2, double aQ3, double aQ4, SWIGTYPE_p_a_3__double rDirCos) {
    opensimModelJNI.AbstractDynamicsEngine_convertQuaternionsToDirectionCosines__SWIG_0(swigCPtr, this, aQ1, aQ2, aQ3, aQ4, SWIGTYPE_p_a_3__double.getCPtr(rDirCos));
  }

  public void convertQuaternionsToDirectionCosines(double aQ1, double aQ2, double aQ3, double aQ4, SWIGTYPE_p_double rDirCos) {
    opensimModelJNI.AbstractDynamicsEngine_convertQuaternionsToDirectionCosines__SWIG_1(swigCPtr, this, aQ1, aQ2, aQ3, aQ4, SWIGTYPE_p_double.getCPtr(rDirCos));
  }

}
