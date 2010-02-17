/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.31
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.opensim.modeling;

public class Muscle extends CustomActuator {
  private long swigCPtr;

  public Muscle(long cPtr, boolean cMemoryOwn) {
    super(opensimModelJNI.SWIGStorageUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  public static long getCPtr(Muscle obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if(swigCPtr != 0 && swigCMemOwn) {
      swigCMemOwn = false;
      opensimModelJNI.delete_Muscle(swigCPtr);
    }
    swigCPtr = 0;
    super.delete();
  }

  public OpenSimObject copy() {
    long cPtr = opensimModelJNI.Muscle_copy__SWIG_0(swigCPtr, this);
    return (cPtr == 0) ? null : new OpenSimObject(cPtr, false);
  }

  public void setup(Model aModel) {
    opensimModelJNI.Muscle_setup(swigCPtr, this, Model.getCPtr(aModel), aModel);
  }

  public void postInit(Model aModel) {
    opensimModelJNI.Muscle_postInit(swigCPtr, this, Model.getCPtr(aModel), aModel);
  }

  public void setName(String aName) {
    opensimModelJNI.Muscle_setName(swigCPtr, this, aName);
  }

  public void copyData(Muscle aMuscle) {
    opensimModelJNI.Muscle_copyData(swigCPtr, this, Muscle.getCPtr(aMuscle), aMuscle);
  }

  public void updateFromXMLNode() {
    opensimModelJNI.Muscle_updateFromXMLNode(swigCPtr, this);
  }

  public void initState(SWIGTYPE_p_SimTK__State s) {
    opensimModelJNI.Muscle_initState(swigCPtr, this, SWIGTYPE_p_SimTK__State.getCPtr(s));
  }

  public void setDefaultsFromState(SWIGTYPE_p_SimTK__State state) {
    opensimModelJNI.Muscle_setDefaultsFromState(swigCPtr, this, SWIGTYPE_p_SimTK__State.getCPtr(state));
  }

  public void initStateCache(SWIGTYPE_p_SimTK__State s, SWIGTYPE_p_SimTK__SubsystemIndex subsystemIndex, Model model) {
    opensimModelJNI.Muscle_initStateCache(swigCPtr, this, SWIGTYPE_p_SimTK__State.getCPtr(s), SWIGTYPE_p_SimTK__SubsystemIndex.getCPtr(subsystemIndex), Model.getCPtr(model), model);
  }

  public void equilibrate(SWIGTYPE_p_SimTK__State state) {
    opensimModelJNI.Muscle_equilibrate(swigCPtr, this, SWIGTYPE_p_SimTK__State.getCPtr(state));
  }

  public static void deleteMuscle(Muscle aMuscle) {
    opensimModelJNI.Muscle_deleteMuscle(Muscle.getCPtr(aMuscle), aMuscle);
  }

  public double getPennationAngleAtOptimalFiberLength() {
    return opensimModelJNI.Muscle_getPennationAngleAtOptimalFiberLength(swigCPtr, this);
  }

  public GeometryPath getGeometryPath() {
    return new GeometryPath(opensimModelJNI.Muscle_getGeometryPath(swigCPtr, this), false);
  }

  public void addNewPathPoint(String proposedName, Body aBody, SWIGTYPE_p_SimTK__Vec3 aPositionOnBody) {
    opensimModelJNI.Muscle_addNewPathPoint(swigCPtr, this, proposedName, Body.getCPtr(aBody), aBody, SWIGTYPE_p_SimTK__Vec3.getCPtr(aPositionOnBody));
  }

  public double getDefaultActivation() {
    return opensimModelJNI.Muscle_getDefaultActivation(swigCPtr, this);
  }

  public void setDefaultActivation(double activation) {
    opensimModelJNI.Muscle_setDefaultActivation(swigCPtr, this, activation);
  }

  public double getDefaultFiberLength() {
    return opensimModelJNI.Muscle_getDefaultFiberLength(swigCPtr, this);
  }

  public void setDefaultFiberLength(double length) {
    opensimModelJNI.Muscle_setDefaultFiberLength(swigCPtr, this, length);
  }

  public double getPennationAngle(SWIGTYPE_p_SimTK__State s) {
    return opensimModelJNI.Muscle_getPennationAngle(swigCPtr, this, SWIGTYPE_p_SimTK__State.getCPtr(s));
  }

  public double getLength(SWIGTYPE_p_SimTK__State s) {
    return opensimModelJNI.Muscle_getLength(swigCPtr, this, SWIGTYPE_p_SimTK__State.getCPtr(s));
  }

  public double getTendonLength(SWIGTYPE_p_SimTK__State s) {
    return opensimModelJNI.Muscle_getTendonLength(swigCPtr, this, SWIGTYPE_p_SimTK__State.getCPtr(s));
  }

  public double getFiberLength(SWIGTYPE_p_SimTK__State s) {
    return opensimModelJNI.Muscle_getFiberLength(swigCPtr, this, SWIGTYPE_p_SimTK__State.getCPtr(s));
  }

  public void setFiberLength(SWIGTYPE_p_SimTK__State s, double fiberLength) {
    opensimModelJNI.Muscle_setFiberLength(swigCPtr, this, SWIGTYPE_p_SimTK__State.getCPtr(s), fiberLength);
  }

  public double getNormalizedFiberLength(SWIGTYPE_p_SimTK__State s) {
    return opensimModelJNI.Muscle_getNormalizedFiberLength(swigCPtr, this, SWIGTYPE_p_SimTK__State.getCPtr(s));
  }

  public double getFiberLengthAlongTendon(SWIGTYPE_p_SimTK__State s) {
    return opensimModelJNI.Muscle_getFiberLengthAlongTendon(swigCPtr, this, SWIGTYPE_p_SimTK__State.getCPtr(s));
  }

  public double getShorteningSpeed(SWIGTYPE_p_SimTK__State s) {
    return opensimModelJNI.Muscle_getShorteningSpeed(swigCPtr, this, SWIGTYPE_p_SimTK__State.getCPtr(s));
  }

  public double getFiberForce(SWIGTYPE_p_SimTK__State s) {
    return opensimModelJNI.Muscle_getFiberForce(swigCPtr, this, SWIGTYPE_p_SimTK__State.getCPtr(s));
  }

  public double getActiveFiberForce(SWIGTYPE_p_SimTK__State s) {
    return opensimModelJNI.Muscle_getActiveFiberForce(swigCPtr, this, SWIGTYPE_p_SimTK__State.getCPtr(s));
  }

  public double getPassiveFiberForce(SWIGTYPE_p_SimTK__State s) {
    return opensimModelJNI.Muscle_getPassiveFiberForce(swigCPtr, this, SWIGTYPE_p_SimTK__State.getCPtr(s));
  }

  public double getActiveFiberForceAlongTendon(SWIGTYPE_p_SimTK__State s) {
    return opensimModelJNI.Muscle_getActiveFiberForceAlongTendon(swigCPtr, this, SWIGTYPE_p_SimTK__State.getCPtr(s));
  }

  public double getPassiveFiberForceAlongTendon(SWIGTYPE_p_SimTK__State s) {
    return opensimModelJNI.Muscle_getPassiveFiberForceAlongTendon(swigCPtr, this, SWIGTYPE_p_SimTK__State.getCPtr(s));
  }

  public double getMaxIsometricForce() {
    return opensimModelJNI.Muscle_getMaxIsometricForce(swigCPtr, this);
  }

  public double getActivation(SWIGTYPE_p_SimTK__State s) {
    return opensimModelJNI.Muscle_getActivation(swigCPtr, this, SWIGTYPE_p_SimTK__State.getCPtr(s));
  }

  public void setActivation(SWIGTYPE_p_SimTK__State s, double activation) {
    opensimModelJNI.Muscle_setActivation(swigCPtr, this, SWIGTYPE_p_SimTK__State.getCPtr(s), activation);
  }

  public double getExcitation(SWIGTYPE_p_SimTK__State s) {
    return opensimModelJNI.Muscle_getExcitation(swigCPtr, this, SWIGTYPE_p_SimTK__State.getCPtr(s));
  }

  public double computeActuation(SWIGTYPE_p_SimTK__State s) {
    return opensimModelJNI.Muscle_computeActuation(swigCPtr, this, SWIGTYPE_p_SimTK__State.getCPtr(s));
  }

  public double computeIsometricForce(SWIGTYPE_p_SimTK__State s, double activation) {
    return opensimModelJNI.Muscle_computeIsometricForce(swigCPtr, this, SWIGTYPE_p_SimTK__State.getCPtr(s), activation);
  }

  public double computeIsokineticForceAssumingInfinitelyStiffTendon(SWIGTYPE_p_SimTK__State s, double aActivation) {
    return opensimModelJNI.Muscle_computeIsokineticForceAssumingInfinitelyStiffTendon(swigCPtr, this, SWIGTYPE_p_SimTK__State.getCPtr(s), aActivation);
  }

  public double evaluateForceLengthVelocityCurve(double aActivation, double aNormalizedLength, double aNormalizedVelocity) {
    return opensimModelJNI.Muscle_evaluateForceLengthVelocityCurve(swigCPtr, this, aActivation, aNormalizedLength, aNormalizedVelocity);
  }

  public double calcPennation(double aFiberLength, double aOptimalFiberLength, double aInitialPennationAngle) {
    return opensimModelJNI.Muscle_calcPennation(swigCPtr, this, aFiberLength, aOptimalFiberLength, aInitialPennationAngle);
  }

  public static double EstimateActivation(double aTRise, double aTFall, double aA0, double aX, double aDT) {
    return opensimModelJNI.Muscle_EstimateActivation(aTRise, aTFall, aA0, aX, aDT);
  }

  public static double InvertActivation(double aTRise, double aTFall, double aA0, double aA, double aDT) {
    return opensimModelJNI.Muscle_InvertActivation(aTRise, aTFall, aA0, aA, aDT);
  }

  public static double DADT(double aTRise, double aTFall, double aX, double aA) {
    return opensimModelJNI.Muscle_DADT(aTRise, aTFall, aX, aA);
  }

  public static double DADTNonlinear(double aTRise, double aTFall, double aX, double aA) {
    return opensimModelJNI.Muscle_DADTNonlinear(aTRise, aTFall, aX, aA);
  }

  public static double f(double aFMax, double aA) {
    return opensimModelJNI.Muscle_f(aFMax, aA);
  }

  public ArrayStr getRecordLabels() {
    return new ArrayStr(opensimModelJNI.Muscle_getRecordLabels(swigCPtr, this), true);
  }

  public ArrayDouble getRecordValues(SWIGTYPE_p_SimTK__State state) {
    return new ArrayDouble(opensimModelJNI.Muscle_getRecordValues(swigCPtr, this, SWIGTYPE_p_SimTK__State.getCPtr(state)), true);
  }

  public VisibleObject getDisplayer() {
    long cPtr = opensimModelJNI.Muscle_getDisplayer(swigCPtr, this);
    return (cPtr == 0) ? null : new VisibleObject(cPtr, false);
  }

  public void updateDisplayer(SWIGTYPE_p_SimTK__State s) {
    opensimModelJNI.Muscle_updateDisplayer(swigCPtr, this, SWIGTYPE_p_SimTK__State.getCPtr(s));
  }

  public static boolean isKindOf(String type) {
    return opensimModelJNI.Muscle_isKindOf(type);
  }

  public boolean isA(String type) {
    return opensimModelJNI.Muscle_isA(swigCPtr, this, type);
  }

  public static Muscle safeDownCast(OpenSimObject obj) {
    long cPtr = opensimModelJNI.Muscle_safeDownCast(OpenSimObject.getCPtr(obj), obj);
    return (cPtr == 0) ? null : new Muscle(cPtr, false);
  }

  public void copy(OpenSimObject aObject) {
    opensimModelJNI.Muscle_copy__SWIG_1(swigCPtr, this, OpenSimObject.getCPtr(aObject), aObject);
  }

}
