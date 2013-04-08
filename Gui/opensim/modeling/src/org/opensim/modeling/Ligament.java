/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.9
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.opensim.modeling;

public class Ligament extends Force {
  private long swigCPtr;

  public Ligament(long cPtr, boolean cMemoryOwn) {
    super(opensimModelJNI.Ligament_SWIGUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  public static long getCPtr(Ligament obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        opensimModelJNI.delete_Ligament(swigCPtr);
      }
      swigCPtr = 0;
    }
    super.delete();
  }

  public static Ligament safeDownCast(OpenSimObject obj) {
    long cPtr = opensimModelJNI.Ligament_safeDownCast(OpenSimObject.getCPtr(obj), obj);
    return (cPtr == 0) ? null : new Ligament(cPtr, false);
  }

  public void assign(OpenSimObject aObject) {
    opensimModelJNI.Ligament_assign(swigCPtr, this, OpenSimObject.getCPtr(aObject), aObject);
  }

  public static String getClassName() {
    return opensimModelJNI.Ligament_getClassName();
  }

  public OpenSimObject clone() {
    long cPtr = opensimModelJNI.Ligament_clone(swigCPtr, this);
    return (cPtr == 0) ? null : new Ligament(cPtr, false);
  }

  public String getConcreteClassName() {
    return opensimModelJNI.Ligament_getConcreteClassName(swigCPtr, this);
  }

  public void setPropertyIndex_GeometryPath(SWIGTYPE_p_PropertyIndex value) {
    opensimModelJNI.Ligament_PropertyIndex_GeometryPath_set(swigCPtr, this, SWIGTYPE_p_PropertyIndex.getCPtr(value));
  }

  public SWIGTYPE_p_PropertyIndex getPropertyIndex_GeometryPath() {
    return new SWIGTYPE_p_PropertyIndex(opensimModelJNI.Ligament_PropertyIndex_GeometryPath_get(swigCPtr, this), true);
  }

  public void copyProperty_GeometryPath(Ligament source) {
    opensimModelJNI.Ligament_copyProperty_GeometryPath(swigCPtr, this, Ligament.getCPtr(source), source);
  }

  public SWIGTYPE_p_OpenSim__PropertyT_OpenSim__GeometryPath_t getProperty_GeometryPath() {
    return new SWIGTYPE_p_OpenSim__PropertyT_OpenSim__GeometryPath_t(opensimModelJNI.Ligament_getProperty_GeometryPath(swigCPtr, this), false);
  }

  public SWIGTYPE_p_OpenSim__PropertyT_OpenSim__GeometryPath_t updProperty_GeometryPath() {
    return new SWIGTYPE_p_OpenSim__PropertyT_OpenSim__GeometryPath_t(opensimModelJNI.Ligament_updProperty_GeometryPath(swigCPtr, this), false);
  }

  public GeometryPath get_GeometryPath(int i) {
    return new GeometryPath(opensimModelJNI.Ligament_get_GeometryPath__SWIG_0(swigCPtr, this, i), false);
  }

  public GeometryPath upd_GeometryPath(int i) {
    return new GeometryPath(opensimModelJNI.Ligament_upd_GeometryPath__SWIG_0(swigCPtr, this, i), false);
  }

  public void set_GeometryPath(int i, GeometryPath value) {
    opensimModelJNI.Ligament_set_GeometryPath__SWIG_0(swigCPtr, this, i, GeometryPath.getCPtr(value), value);
  }

  public int append_GeometryPath(GeometryPath value) {
    return opensimModelJNI.Ligament_append_GeometryPath(swigCPtr, this, GeometryPath.getCPtr(value), value);
  }

  public void constructProperty_GeometryPath(GeometryPath initValue) {
    opensimModelJNI.Ligament_constructProperty_GeometryPath(swigCPtr, this, GeometryPath.getCPtr(initValue), initValue);
  }

  public GeometryPath get_GeometryPath() {
    return new GeometryPath(opensimModelJNI.Ligament_get_GeometryPath__SWIG_1(swigCPtr, this), false);
  }

  public GeometryPath upd_GeometryPath() {
    return new GeometryPath(opensimModelJNI.Ligament_upd_GeometryPath__SWIG_1(swigCPtr, this), false);
  }

  public void set_GeometryPath(GeometryPath value) {
    opensimModelJNI.Ligament_set_GeometryPath__SWIG_1(swigCPtr, this, GeometryPath.getCPtr(value), value);
  }

  public void setPropertyIndex_resting_length(SWIGTYPE_p_PropertyIndex value) {
    opensimModelJNI.Ligament_PropertyIndex_resting_length_set(swigCPtr, this, SWIGTYPE_p_PropertyIndex.getCPtr(value));
  }

  public SWIGTYPE_p_PropertyIndex getPropertyIndex_resting_length() {
    return new SWIGTYPE_p_PropertyIndex(opensimModelJNI.Ligament_PropertyIndex_resting_length_get(swigCPtr, this), true);
  }

  public void copyProperty_resting_length(Ligament source) {
    opensimModelJNI.Ligament_copyProperty_resting_length(swigCPtr, this, Ligament.getCPtr(source), source);
  }

  public SWIGTYPE_p_OpenSim__PropertyT_double_t getProperty_resting_length() {
    return new SWIGTYPE_p_OpenSim__PropertyT_double_t(opensimModelJNI.Ligament_getProperty_resting_length(swigCPtr, this), false);
  }

  public SWIGTYPE_p_OpenSim__PropertyT_double_t updProperty_resting_length() {
    return new SWIGTYPE_p_OpenSim__PropertyT_double_t(opensimModelJNI.Ligament_updProperty_resting_length(swigCPtr, this), false);
  }

  public double get_resting_length(int i) {
    return opensimModelJNI.Ligament_get_resting_length__SWIG_0(swigCPtr, this, i);
  }

  public SWIGTYPE_p_double upd_resting_length(int i) {
    return new SWIGTYPE_p_double(opensimModelJNI.Ligament_upd_resting_length__SWIG_0(swigCPtr, this, i), false);
  }

  public void set_resting_length(int i, double value) {
    opensimModelJNI.Ligament_set_resting_length__SWIG_0(swigCPtr, this, i, value);
  }

  public int append_resting_length(double value) {
    return opensimModelJNI.Ligament_append_resting_length(swigCPtr, this, value);
  }

  public void constructProperty_resting_length(double initValue) {
    opensimModelJNI.Ligament_constructProperty_resting_length(swigCPtr, this, initValue);
  }

  public double get_resting_length() {
    return opensimModelJNI.Ligament_get_resting_length__SWIG_1(swigCPtr, this);
  }

  public SWIGTYPE_p_double upd_resting_length() {
    return new SWIGTYPE_p_double(opensimModelJNI.Ligament_upd_resting_length__SWIG_1(swigCPtr, this), false);
  }

  public void set_resting_length(double value) {
    opensimModelJNI.Ligament_set_resting_length__SWIG_1(swigCPtr, this, value);
  }

  public void setPropertyIndex_pcsa_force(SWIGTYPE_p_PropertyIndex value) {
    opensimModelJNI.Ligament_PropertyIndex_pcsa_force_set(swigCPtr, this, SWIGTYPE_p_PropertyIndex.getCPtr(value));
  }

  public SWIGTYPE_p_PropertyIndex getPropertyIndex_pcsa_force() {
    return new SWIGTYPE_p_PropertyIndex(opensimModelJNI.Ligament_PropertyIndex_pcsa_force_get(swigCPtr, this), true);
  }

  public void copyProperty_pcsa_force(Ligament source) {
    opensimModelJNI.Ligament_copyProperty_pcsa_force(swigCPtr, this, Ligament.getCPtr(source), source);
  }

  public SWIGTYPE_p_OpenSim__PropertyT_double_t getProperty_pcsa_force() {
    return new SWIGTYPE_p_OpenSim__PropertyT_double_t(opensimModelJNI.Ligament_getProperty_pcsa_force(swigCPtr, this), false);
  }

  public SWIGTYPE_p_OpenSim__PropertyT_double_t updProperty_pcsa_force() {
    return new SWIGTYPE_p_OpenSim__PropertyT_double_t(opensimModelJNI.Ligament_updProperty_pcsa_force(swigCPtr, this), false);
  }

  public double get_pcsa_force(int i) {
    return opensimModelJNI.Ligament_get_pcsa_force__SWIG_0(swigCPtr, this, i);
  }

  public SWIGTYPE_p_double upd_pcsa_force(int i) {
    return new SWIGTYPE_p_double(opensimModelJNI.Ligament_upd_pcsa_force__SWIG_0(swigCPtr, this, i), false);
  }

  public void set_pcsa_force(int i, double value) {
    opensimModelJNI.Ligament_set_pcsa_force__SWIG_0(swigCPtr, this, i, value);
  }

  public int append_pcsa_force(double value) {
    return opensimModelJNI.Ligament_append_pcsa_force(swigCPtr, this, value);
  }

  public void constructProperty_pcsa_force(double initValue) {
    opensimModelJNI.Ligament_constructProperty_pcsa_force(swigCPtr, this, initValue);
  }

  public double get_pcsa_force() {
    return opensimModelJNI.Ligament_get_pcsa_force__SWIG_1(swigCPtr, this);
  }

  public SWIGTYPE_p_double upd_pcsa_force() {
    return new SWIGTYPE_p_double(opensimModelJNI.Ligament_upd_pcsa_force__SWIG_1(swigCPtr, this), false);
  }

  public void set_pcsa_force(double value) {
    opensimModelJNI.Ligament_set_pcsa_force__SWIG_1(swigCPtr, this, value);
  }

  public void setPropertyIndex_force_length_curve(SWIGTYPE_p_PropertyIndex value) {
    opensimModelJNI.Ligament_PropertyIndex_force_length_curve_set(swigCPtr, this, SWIGTYPE_p_PropertyIndex.getCPtr(value));
  }

  public SWIGTYPE_p_PropertyIndex getPropertyIndex_force_length_curve() {
    return new SWIGTYPE_p_PropertyIndex(opensimModelJNI.Ligament_PropertyIndex_force_length_curve_get(swigCPtr, this), true);
  }

  public void copyProperty_force_length_curve(Ligament source) {
    opensimModelJNI.Ligament_copyProperty_force_length_curve(swigCPtr, this, Ligament.getCPtr(source), source);
  }

  public SWIGTYPE_p_OpenSim__PropertyT_OpenSim__Function_t getProperty_force_length_curve() {
    return new SWIGTYPE_p_OpenSim__PropertyT_OpenSim__Function_t(opensimModelJNI.Ligament_getProperty_force_length_curve(swigCPtr, this), false);
  }

  public SWIGTYPE_p_OpenSim__PropertyT_OpenSim__Function_t updProperty_force_length_curve() {
    return new SWIGTYPE_p_OpenSim__PropertyT_OpenSim__Function_t(opensimModelJNI.Ligament_updProperty_force_length_curve(swigCPtr, this), false);
  }

  public Function get_force_length_curve(int i) {
    return new Function(opensimModelJNI.Ligament_get_force_length_curve__SWIG_0(swigCPtr, this, i), false);
  }

  public Function upd_force_length_curve(int i) {
    return new Function(opensimModelJNI.Ligament_upd_force_length_curve__SWIG_0(swigCPtr, this, i), false);
  }

  public void set_force_length_curve(int i, Function value) {
    opensimModelJNI.Ligament_set_force_length_curve__SWIG_0(swigCPtr, this, i, Function.getCPtr(value), value);
  }

  public int append_force_length_curve(Function value) {
    return opensimModelJNI.Ligament_append_force_length_curve(swigCPtr, this, Function.getCPtr(value), value);
  }

  public void constructProperty_force_length_curve(Function initValue) {
    opensimModelJNI.Ligament_constructProperty_force_length_curve(swigCPtr, this, Function.getCPtr(initValue), initValue);
  }

  public Function get_force_length_curve() {
    return new Function(opensimModelJNI.Ligament_get_force_length_curve__SWIG_1(swigCPtr, this), false);
  }

  public Function upd_force_length_curve() {
    return new Function(opensimModelJNI.Ligament_upd_force_length_curve__SWIG_1(swigCPtr, this), false);
  }

  public void set_force_length_curve(Function value) {
    opensimModelJNI.Ligament_set_force_length_curve__SWIG_1(swigCPtr, this, Function.getCPtr(value), value);
  }

  public Ligament() {
    this(opensimModelJNI.new_Ligament(), true);
  }

  public GeometryPath getGeometryPath() {
    return new GeometryPath(opensimModelJNI.Ligament_getGeometryPath(swigCPtr, this), false);
  }

  public GeometryPath updGeometryPath() {
    return new GeometryPath(opensimModelJNI.Ligament_updGeometryPath(swigCPtr, this), false);
  }

  public boolean hasGeometryPath() {
    return opensimModelJNI.Ligament_hasGeometryPath(swigCPtr, this);
  }

  public double getLength(State s) {
    return opensimModelJNI.Ligament_getLength(swigCPtr, this, State.getCPtr(s), s);
  }

  public double getRestingLength() {
    return opensimModelJNI.Ligament_getRestingLength(swigCPtr, this);
  }

  public boolean setRestingLength(double aRestingLength) {
    return opensimModelJNI.Ligament_setRestingLength(swigCPtr, this, aRestingLength);
  }

  public double getMaxIsometricForce() {
    return opensimModelJNI.Ligament_getMaxIsometricForce(swigCPtr, this);
  }

  public boolean setMaxIsometricForce(double aMaxIsometricForce) {
    return opensimModelJNI.Ligament_setMaxIsometricForce(swigCPtr, this, aMaxIsometricForce);
  }

  public Function getForceLengthCurve() {
    return new Function(opensimModelJNI.Ligament_getForceLengthCurve(swigCPtr, this), false);
  }

  public boolean setForceLengthCurve(Function aForceLengthCurve) {
    return opensimModelJNI.Ligament_setForceLengthCurve(swigCPtr, this, Function.getCPtr(aForceLengthCurve), aForceLengthCurve);
  }

  public double getTension(State s) {
    return opensimModelJNI.Ligament_getTension(swigCPtr, this, State.getCPtr(s), s);
  }

  public double computeMomentArm(State s, Coordinate aCoord) {
    return opensimModelJNI.Ligament_computeMomentArm(swigCPtr, this, State.getCPtr(s), s, Coordinate.getCPtr(aCoord), aCoord);
  }

  public void computeForce(State s, SWIGTYPE_p_SimTK__Vector_T_SimTK__VecT_2_SimTK__Vec3_1_t_t bodyForces, Vector generalizedForces) {
    opensimModelJNI.Ligament_computeForce(swigCPtr, this, State.getCPtr(s), s, SWIGTYPE_p_SimTK__Vector_T_SimTK__VecT_2_SimTK__Vec3_1_t_t.getCPtr(bodyForces), Vector.getCPtr(generalizedForces), generalizedForces);
  }

  public void preScale(State s, ScaleSet aScaleSet) {
    opensimModelJNI.Ligament_preScale(swigCPtr, this, State.getCPtr(s), s, ScaleSet.getCPtr(aScaleSet), aScaleSet);
  }

  public void scale(State s, ScaleSet aScaleSet) {
    opensimModelJNI.Ligament_scale(swigCPtr, this, State.getCPtr(s), s, ScaleSet.getCPtr(aScaleSet), aScaleSet);
  }

  public void postScale(State s, ScaleSet aScaleSet) {
    opensimModelJNI.Ligament_postScale(swigCPtr, this, State.getCPtr(s), s, ScaleSet.getCPtr(aScaleSet), aScaleSet);
  }

  public VisibleObject getDisplayer() {
    long cPtr = opensimModelJNI.Ligament_getDisplayer(swigCPtr, this);
    return (cPtr == 0) ? null : new VisibleObject(cPtr, false);
  }

  public void updateDisplayer(State s) {
    opensimModelJNI.Ligament_updateDisplayer(swigCPtr, this, State.getCPtr(s), s);
  }

}
