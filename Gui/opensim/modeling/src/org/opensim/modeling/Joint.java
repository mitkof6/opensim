/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.9
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.opensim.modeling;

public class Joint extends ModelComponent {
  private long swigCPtr;

  public Joint(long cPtr, boolean cMemoryOwn) {
    super(opensimModelJNI.Joint_SWIGUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  public static long getCPtr(Joint obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        opensimModelJNI.delete_Joint(swigCPtr);
      }
      swigCPtr = 0;
    }
    super.delete();
  }

  public static Joint safeDownCast(OpenSimObject obj) {
    long cPtr = opensimModelJNI.Joint_safeDownCast(OpenSimObject.getCPtr(obj), obj);
    return (cPtr == 0) ? null : new Joint(cPtr, false);
  }

  public void assign(OpenSimObject aObject) {
    opensimModelJNI.Joint_assign(swigCPtr, this, OpenSimObject.getCPtr(aObject), aObject);
  }

  public static String getClassName() {
    return opensimModelJNI.Joint_getClassName();
  }

  public OpenSimObject clone() {
    long cPtr = opensimModelJNI.Joint_clone(swigCPtr, this);
    return (cPtr == 0) ? null : new Joint(cPtr, false);
  }

  public String getConcreteClassName() {
    return opensimModelJNI.Joint_getConcreteClassName(swigCPtr, this);
  }

  public void setPropertyIndex_parent_body(SWIGTYPE_p_PropertyIndex value) {
    opensimModelJNI.Joint_PropertyIndex_parent_body_set(swigCPtr, this, SWIGTYPE_p_PropertyIndex.getCPtr(value));
  }

  public SWIGTYPE_p_PropertyIndex getPropertyIndex_parent_body() {
    return new SWIGTYPE_p_PropertyIndex(opensimModelJNI.Joint_PropertyIndex_parent_body_get(swigCPtr, this), true);
  }

  public void copyProperty_parent_body(Joint source) {
    opensimModelJNI.Joint_copyProperty_parent_body(swigCPtr, this, Joint.getCPtr(source), source);
  }

  public SWIGTYPE_p_OpenSim__PropertyT_std__string_t getProperty_parent_body() {
    return new SWIGTYPE_p_OpenSim__PropertyT_std__string_t(opensimModelJNI.Joint_getProperty_parent_body(swigCPtr, this), false);
  }

  public SWIGTYPE_p_OpenSim__PropertyT_std__string_t updProperty_parent_body() {
    return new SWIGTYPE_p_OpenSim__PropertyT_std__string_t(opensimModelJNI.Joint_updProperty_parent_body(swigCPtr, this), false);
  }

  public String get_parent_body(int i) {
    return opensimModelJNI.Joint_get_parent_body__SWIG_0(swigCPtr, this, i);
  }

  public SWIGTYPE_p_std__string upd_parent_body(int i) {
    return new SWIGTYPE_p_std__string(opensimModelJNI.Joint_upd_parent_body__SWIG_0(swigCPtr, this, i), false);
  }

  public void set_parent_body(int i, String value) {
    opensimModelJNI.Joint_set_parent_body__SWIG_0(swigCPtr, this, i, value);
  }

  public int append_parent_body(String value) {
    return opensimModelJNI.Joint_append_parent_body(swigCPtr, this, value);
  }

  public void constructProperty_parent_body(String initValue) {
    opensimModelJNI.Joint_constructProperty_parent_body(swigCPtr, this, initValue);
  }

  public String get_parent_body() {
    return opensimModelJNI.Joint_get_parent_body__SWIG_1(swigCPtr, this);
  }

  public SWIGTYPE_p_std__string upd_parent_body() {
    return new SWIGTYPE_p_std__string(opensimModelJNI.Joint_upd_parent_body__SWIG_1(swigCPtr, this), false);
  }

  public void set_parent_body(String value) {
    opensimModelJNI.Joint_set_parent_body__SWIG_1(swigCPtr, this, value);
  }

  public void setPropertyIndex_location_in_parent(SWIGTYPE_p_PropertyIndex value) {
    opensimModelJNI.Joint_PropertyIndex_location_in_parent_set(swigCPtr, this, SWIGTYPE_p_PropertyIndex.getCPtr(value));
  }

  public SWIGTYPE_p_PropertyIndex getPropertyIndex_location_in_parent() {
    return new SWIGTYPE_p_PropertyIndex(opensimModelJNI.Joint_PropertyIndex_location_in_parent_get(swigCPtr, this), true);
  }

  public void copyProperty_location_in_parent(Joint source) {
    opensimModelJNI.Joint_copyProperty_location_in_parent(swigCPtr, this, Joint.getCPtr(source), source);
  }

  public SWIGTYPE_p_OpenSim__PropertyT_SimTK__VecT_3_double_1_t_t getProperty_location_in_parent() {
    return new SWIGTYPE_p_OpenSim__PropertyT_SimTK__VecT_3_double_1_t_t(opensimModelJNI.Joint_getProperty_location_in_parent(swigCPtr, this), false);
  }

  public SWIGTYPE_p_OpenSim__PropertyT_SimTK__VecT_3_double_1_t_t updProperty_location_in_parent() {
    return new SWIGTYPE_p_OpenSim__PropertyT_SimTK__VecT_3_double_1_t_t(opensimModelJNI.Joint_updProperty_location_in_parent(swigCPtr, this), false);
  }

  public Vec3 get_location_in_parent(int i) {
    return new Vec3(opensimModelJNI.Joint_get_location_in_parent__SWIG_0(swigCPtr, this, i), false);
  }

  public Vec3 upd_location_in_parent(int i) {
    return new Vec3(opensimModelJNI.Joint_upd_location_in_parent__SWIG_0(swigCPtr, this, i), false);
  }

  public void set_location_in_parent(int i, Vec3 value) {
    opensimModelJNI.Joint_set_location_in_parent__SWIG_0(swigCPtr, this, i, Vec3.getCPtr(value), value);
  }

  public int append_location_in_parent(Vec3 value) {
    return opensimModelJNI.Joint_append_location_in_parent(swigCPtr, this, Vec3.getCPtr(value), value);
  }

  public void constructProperty_location_in_parent(Vec3 initValue) {
    opensimModelJNI.Joint_constructProperty_location_in_parent(swigCPtr, this, Vec3.getCPtr(initValue), initValue);
  }

  public Vec3 get_location_in_parent() {
    return new Vec3(opensimModelJNI.Joint_get_location_in_parent__SWIG_1(swigCPtr, this), false);
  }

  public Vec3 upd_location_in_parent() {
    return new Vec3(opensimModelJNI.Joint_upd_location_in_parent__SWIG_1(swigCPtr, this), false);
  }

  public void set_location_in_parent(Vec3 value) {
    opensimModelJNI.Joint_set_location_in_parent__SWIG_1(swigCPtr, this, Vec3.getCPtr(value), value);
  }

  public void setPropertyIndex_orientation_in_parent(SWIGTYPE_p_PropertyIndex value) {
    opensimModelJNI.Joint_PropertyIndex_orientation_in_parent_set(swigCPtr, this, SWIGTYPE_p_PropertyIndex.getCPtr(value));
  }

  public SWIGTYPE_p_PropertyIndex getPropertyIndex_orientation_in_parent() {
    return new SWIGTYPE_p_PropertyIndex(opensimModelJNI.Joint_PropertyIndex_orientation_in_parent_get(swigCPtr, this), true);
  }

  public void copyProperty_orientation_in_parent(Joint source) {
    opensimModelJNI.Joint_copyProperty_orientation_in_parent(swigCPtr, this, Joint.getCPtr(source), source);
  }

  public SWIGTYPE_p_OpenSim__PropertyT_SimTK__VecT_3_double_1_t_t getProperty_orientation_in_parent() {
    return new SWIGTYPE_p_OpenSim__PropertyT_SimTK__VecT_3_double_1_t_t(opensimModelJNI.Joint_getProperty_orientation_in_parent(swigCPtr, this), false);
  }

  public SWIGTYPE_p_OpenSim__PropertyT_SimTK__VecT_3_double_1_t_t updProperty_orientation_in_parent() {
    return new SWIGTYPE_p_OpenSim__PropertyT_SimTK__VecT_3_double_1_t_t(opensimModelJNI.Joint_updProperty_orientation_in_parent(swigCPtr, this), false);
  }

  public Vec3 get_orientation_in_parent(int i) {
    return new Vec3(opensimModelJNI.Joint_get_orientation_in_parent__SWIG_0(swigCPtr, this, i), false);
  }

  public Vec3 upd_orientation_in_parent(int i) {
    return new Vec3(opensimModelJNI.Joint_upd_orientation_in_parent__SWIG_0(swigCPtr, this, i), false);
  }

  public void set_orientation_in_parent(int i, Vec3 value) {
    opensimModelJNI.Joint_set_orientation_in_parent__SWIG_0(swigCPtr, this, i, Vec3.getCPtr(value), value);
  }

  public int append_orientation_in_parent(Vec3 value) {
    return opensimModelJNI.Joint_append_orientation_in_parent(swigCPtr, this, Vec3.getCPtr(value), value);
  }

  public void constructProperty_orientation_in_parent(Vec3 initValue) {
    opensimModelJNI.Joint_constructProperty_orientation_in_parent(swigCPtr, this, Vec3.getCPtr(initValue), initValue);
  }

  public Vec3 get_orientation_in_parent() {
    return new Vec3(opensimModelJNI.Joint_get_orientation_in_parent__SWIG_1(swigCPtr, this), false);
  }

  public Vec3 upd_orientation_in_parent() {
    return new Vec3(opensimModelJNI.Joint_upd_orientation_in_parent__SWIG_1(swigCPtr, this), false);
  }

  public void set_orientation_in_parent(Vec3 value) {
    opensimModelJNI.Joint_set_orientation_in_parent__SWIG_1(swigCPtr, this, Vec3.getCPtr(value), value);
  }

  public void setPropertyIndex_location(SWIGTYPE_p_PropertyIndex value) {
    opensimModelJNI.Joint_PropertyIndex_location_set(swigCPtr, this, SWIGTYPE_p_PropertyIndex.getCPtr(value));
  }

  public SWIGTYPE_p_PropertyIndex getPropertyIndex_location() {
    return new SWIGTYPE_p_PropertyIndex(opensimModelJNI.Joint_PropertyIndex_location_get(swigCPtr, this), true);
  }

  public void copyProperty_location(Joint source) {
    opensimModelJNI.Joint_copyProperty_location(swigCPtr, this, Joint.getCPtr(source), source);
  }

  public SWIGTYPE_p_OpenSim__PropertyT_SimTK__VecT_3_double_1_t_t getProperty_location() {
    return new SWIGTYPE_p_OpenSim__PropertyT_SimTK__VecT_3_double_1_t_t(opensimModelJNI.Joint_getProperty_location(swigCPtr, this), false);
  }

  public SWIGTYPE_p_OpenSim__PropertyT_SimTK__VecT_3_double_1_t_t updProperty_location() {
    return new SWIGTYPE_p_OpenSim__PropertyT_SimTK__VecT_3_double_1_t_t(opensimModelJNI.Joint_updProperty_location(swigCPtr, this), false);
  }

  public Vec3 get_location(int i) {
    return new Vec3(opensimModelJNI.Joint_get_location__SWIG_0(swigCPtr, this, i), false);
  }

  public Vec3 upd_location(int i) {
    return new Vec3(opensimModelJNI.Joint_upd_location__SWIG_0(swigCPtr, this, i), false);
  }

  public void set_location(int i, Vec3 value) {
    opensimModelJNI.Joint_set_location__SWIG_0(swigCPtr, this, i, Vec3.getCPtr(value), value);
  }

  public int append_location(Vec3 value) {
    return opensimModelJNI.Joint_append_location(swigCPtr, this, Vec3.getCPtr(value), value);
  }

  public void constructProperty_location(Vec3 initValue) {
    opensimModelJNI.Joint_constructProperty_location(swigCPtr, this, Vec3.getCPtr(initValue), initValue);
  }

  public Vec3 get_location() {
    return new Vec3(opensimModelJNI.Joint_get_location__SWIG_1(swigCPtr, this), false);
  }

  public Vec3 upd_location() {
    return new Vec3(opensimModelJNI.Joint_upd_location__SWIG_1(swigCPtr, this), false);
  }

  public void set_location(Vec3 value) {
    opensimModelJNI.Joint_set_location__SWIG_1(swigCPtr, this, Vec3.getCPtr(value), value);
  }

  public void setPropertyIndex_orientation(SWIGTYPE_p_PropertyIndex value) {
    opensimModelJNI.Joint_PropertyIndex_orientation_set(swigCPtr, this, SWIGTYPE_p_PropertyIndex.getCPtr(value));
  }

  public SWIGTYPE_p_PropertyIndex getPropertyIndex_orientation() {
    return new SWIGTYPE_p_PropertyIndex(opensimModelJNI.Joint_PropertyIndex_orientation_get(swigCPtr, this), true);
  }

  public void copyProperty_orientation(Joint source) {
    opensimModelJNI.Joint_copyProperty_orientation(swigCPtr, this, Joint.getCPtr(source), source);
  }

  public SWIGTYPE_p_OpenSim__PropertyT_SimTK__VecT_3_double_1_t_t getProperty_orientation() {
    return new SWIGTYPE_p_OpenSim__PropertyT_SimTK__VecT_3_double_1_t_t(opensimModelJNI.Joint_getProperty_orientation(swigCPtr, this), false);
  }

  public SWIGTYPE_p_OpenSim__PropertyT_SimTK__VecT_3_double_1_t_t updProperty_orientation() {
    return new SWIGTYPE_p_OpenSim__PropertyT_SimTK__VecT_3_double_1_t_t(opensimModelJNI.Joint_updProperty_orientation(swigCPtr, this), false);
  }

  public Vec3 get_orientation(int i) {
    return new Vec3(opensimModelJNI.Joint_get_orientation__SWIG_0(swigCPtr, this, i), false);
  }

  public Vec3 upd_orientation(int i) {
    return new Vec3(opensimModelJNI.Joint_upd_orientation__SWIG_0(swigCPtr, this, i), false);
  }

  public void set_orientation(int i, Vec3 value) {
    opensimModelJNI.Joint_set_orientation__SWIG_0(swigCPtr, this, i, Vec3.getCPtr(value), value);
  }

  public int append_orientation(Vec3 value) {
    return opensimModelJNI.Joint_append_orientation(swigCPtr, this, Vec3.getCPtr(value), value);
  }

  public void constructProperty_orientation(Vec3 initValue) {
    opensimModelJNI.Joint_constructProperty_orientation(swigCPtr, this, Vec3.getCPtr(initValue), initValue);
  }

  public Vec3 get_orientation() {
    return new Vec3(opensimModelJNI.Joint_get_orientation__SWIG_1(swigCPtr, this), false);
  }

  public Vec3 upd_orientation() {
    return new Vec3(opensimModelJNI.Joint_upd_orientation__SWIG_1(swigCPtr, this), false);
  }

  public void set_orientation(Vec3 value) {
    opensimModelJNI.Joint_set_orientation__SWIG_1(swigCPtr, this, Vec3.getCPtr(value), value);
  }

  public void setPropertyIndex_CoordinateSet(SWIGTYPE_p_PropertyIndex value) {
    opensimModelJNI.Joint_PropertyIndex_CoordinateSet_set(swigCPtr, this, SWIGTYPE_p_PropertyIndex.getCPtr(value));
  }

  public SWIGTYPE_p_PropertyIndex getPropertyIndex_CoordinateSet() {
    return new SWIGTYPE_p_PropertyIndex(opensimModelJNI.Joint_PropertyIndex_CoordinateSet_get(swigCPtr, this), true);
  }

  public void copyProperty_CoordinateSet(Joint source) {
    opensimModelJNI.Joint_copyProperty_CoordinateSet(swigCPtr, this, Joint.getCPtr(source), source);
  }

  public SWIGTYPE_p_OpenSim__PropertyT_OpenSim__CoordinateSet_t getProperty_CoordinateSet() {
    return new SWIGTYPE_p_OpenSim__PropertyT_OpenSim__CoordinateSet_t(opensimModelJNI.Joint_getProperty_CoordinateSet(swigCPtr, this), false);
  }

  public SWIGTYPE_p_OpenSim__PropertyT_OpenSim__CoordinateSet_t updProperty_CoordinateSet() {
    return new SWIGTYPE_p_OpenSim__PropertyT_OpenSim__CoordinateSet_t(opensimModelJNI.Joint_updProperty_CoordinateSet(swigCPtr, this), false);
  }

  public CoordinateSet get_CoordinateSet(int i) {
    return new CoordinateSet(opensimModelJNI.Joint_get_CoordinateSet__SWIG_0(swigCPtr, this, i), false);
  }

  public CoordinateSet upd_CoordinateSet(int i) {
    return new CoordinateSet(opensimModelJNI.Joint_upd_CoordinateSet__SWIG_0(swigCPtr, this, i), false);
  }

  public void set_CoordinateSet(int i, CoordinateSet value) {
    opensimModelJNI.Joint_set_CoordinateSet__SWIG_0(swigCPtr, this, i, CoordinateSet.getCPtr(value), value);
  }

  public int append_CoordinateSet(CoordinateSet value) {
    return opensimModelJNI.Joint_append_CoordinateSet(swigCPtr, this, CoordinateSet.getCPtr(value), value);
  }

  public void constructProperty_CoordinateSet(CoordinateSet initValue) {
    opensimModelJNI.Joint_constructProperty_CoordinateSet(swigCPtr, this, CoordinateSet.getCPtr(initValue), initValue);
  }

  public CoordinateSet get_CoordinateSet() {
    return new CoordinateSet(opensimModelJNI.Joint_get_CoordinateSet__SWIG_1(swigCPtr, this), false);
  }

  public CoordinateSet upd_CoordinateSet() {
    return new CoordinateSet(opensimModelJNI.Joint_upd_CoordinateSet__SWIG_1(swigCPtr, this), false);
  }

  public void set_CoordinateSet(CoordinateSet value) {
    opensimModelJNI.Joint_set_CoordinateSet__SWIG_1(swigCPtr, this, CoordinateSet.getCPtr(value), value);
  }

  public void setPropertyIndex_reverse(SWIGTYPE_p_PropertyIndex value) {
    opensimModelJNI.Joint_PropertyIndex_reverse_set(swigCPtr, this, SWIGTYPE_p_PropertyIndex.getCPtr(value));
  }

  public SWIGTYPE_p_PropertyIndex getPropertyIndex_reverse() {
    return new SWIGTYPE_p_PropertyIndex(opensimModelJNI.Joint_PropertyIndex_reverse_get(swigCPtr, this), true);
  }

  public void copyProperty_reverse(Joint source) {
    opensimModelJNI.Joint_copyProperty_reverse(swigCPtr, this, Joint.getCPtr(source), source);
  }

  public SWIGTYPE_p_OpenSim__PropertyT_bool_t getProperty_reverse() {
    return new SWIGTYPE_p_OpenSim__PropertyT_bool_t(opensimModelJNI.Joint_getProperty_reverse(swigCPtr, this), false);
  }

  public SWIGTYPE_p_OpenSim__PropertyT_bool_t updProperty_reverse() {
    return new SWIGTYPE_p_OpenSim__PropertyT_bool_t(opensimModelJNI.Joint_updProperty_reverse(swigCPtr, this), false);
  }

  public boolean get_reverse(int i) {
    return opensimModelJNI.Joint_get_reverse__SWIG_0(swigCPtr, this, i);
  }

  public SWIGTYPE_p_bool upd_reverse(int i) {
    return new SWIGTYPE_p_bool(opensimModelJNI.Joint_upd_reverse__SWIG_0(swigCPtr, this, i), false);
  }

  public void set_reverse(int i, boolean value) {
    opensimModelJNI.Joint_set_reverse__SWIG_0(swigCPtr, this, i, value);
  }

  public int append_reverse(boolean value) {
    return opensimModelJNI.Joint_append_reverse(swigCPtr, this, value);
  }

  public void constructProperty_reverse(boolean initValue) {
    opensimModelJNI.Joint_constructProperty_reverse(swigCPtr, this, initValue);
  }

  public boolean get_reverse() {
    return opensimModelJNI.Joint_get_reverse__SWIG_1(swigCPtr, this);
  }

  public SWIGTYPE_p_bool upd_reverse() {
    return new SWIGTYPE_p_bool(opensimModelJNI.Joint_upd_reverse__SWIG_1(swigCPtr, this), false);
  }

  public void set_reverse(boolean value) {
    opensimModelJNI.Joint_set_reverse__SWIG_1(swigCPtr, this, value);
  }

  public void setBody(Body aBody) {
    opensimModelJNI.Joint_setBody(swigCPtr, this, Body.getCPtr(aBody), aBody);
  }

  public Body getBody() {
    return new Body(opensimModelJNI.Joint_getBody(swigCPtr, this), false);
  }

  public Body updBody() {
    return new Body(opensimModelJNI.Joint_updBody(swigCPtr, this), false);
  }

  public void setLocation(Vec3 aLocation) {
    opensimModelJNI.Joint_setLocation(swigCPtr, this, Vec3.getCPtr(aLocation), aLocation);
  }

  public void getLocation(Vec3 rLocation) {
    opensimModelJNI.Joint_getLocation(swigCPtr, this, Vec3.getCPtr(rLocation), rLocation);
  }

  public void setOrientation(Vec3 aOrientation) {
    opensimModelJNI.Joint_setOrientation(swigCPtr, this, Vec3.getCPtr(aOrientation), aOrientation);
  }

  public void getOrientation(Vec3 rOrientation) {
    opensimModelJNI.Joint_getOrientation(swigCPtr, this, Vec3.getCPtr(rOrientation), rOrientation);
  }

  public void setParentName(String aName) {
    opensimModelJNI.Joint_setParentName(swigCPtr, this, aName);
  }

  public String getParentName() {
    return opensimModelJNI.Joint_getParentName(swigCPtr, this);
  }

  public void setParentBody(Body aBody) {
    opensimModelJNI.Joint_setParentBody(swigCPtr, this, Body.getCPtr(aBody), aBody);
  }

  public Body getParentBody() {
    return new Body(opensimModelJNI.Joint_getParentBody(swigCPtr, this), false);
  }

  public Body updParentBody() {
    return new Body(opensimModelJNI.Joint_updParentBody(swigCPtr, this), false);
  }

  public void setLocationInParent(Vec3 aLocation) {
    opensimModelJNI.Joint_setLocationInParent(swigCPtr, this, Vec3.getCPtr(aLocation), aLocation);
  }

  public void getLocationInParent(Vec3 rLocation) {
    opensimModelJNI.Joint_getLocationInParent__SWIG_0(swigCPtr, this, Vec3.getCPtr(rLocation), rLocation);
  }

  public void setOrientationInParent(Vec3 aOrientation) {
    opensimModelJNI.Joint_setOrientationInParent(swigCPtr, this, Vec3.getCPtr(aOrientation), aOrientation);
  }

  public void getOrientationInParent(Vec3 rOrientation) {
    opensimModelJNI.Joint_getOrientationInParent__SWIG_0(swigCPtr, this, Vec3.getCPtr(rOrientation), rOrientation);
  }

  public void getOrientationInChild(double[] rOrientation) {
    opensimModelJNI.Joint_getOrientationInChild(swigCPtr, this, rOrientation);
  }

  public void getOrientationInParent(double[] rOrientation) {
    opensimModelJNI.Joint_getOrientationInParent__SWIG_1(swigCPtr, this, rOrientation);
  }

  public void getLocationInChild(double[] rLocation) {
    opensimModelJNI.Joint_getLocationInChild__SWIG_0(swigCPtr, this, rLocation);
  }

  public void getLocationInParent(double[] rLocation) {
    opensimModelJNI.Joint_getLocationInParent__SWIG_1(swigCPtr, this, rLocation);
  }

  public void setLocationInChild(Vec3 aLocation) {
    opensimModelJNI.Joint_setLocationInChild(swigCPtr, this, Vec3.getCPtr(aLocation), aLocation);
  }

  public Vec3 getLocationInChild() {
    return new Vec3(opensimModelJNI.Joint_getLocationInChild__SWIG_1(swigCPtr, this), false);
  }

  public CoordinateSet getCoordinateSet() {
    return new CoordinateSet(opensimModelJNI.Joint_getCoordinateSet(swigCPtr, this), false);
  }

  public boolean getReverse() {
    return opensimModelJNI.Joint_getReverse(swigCPtr, this);
  }

  public int numCoordinates() {
    return opensimModelJNI.Joint_numCoordinates(swigCPtr, this);
  }

  public void checkParentBody() {
    opensimModelJNI.Joint_checkParentBody(swigCPtr, this);
  }

  public boolean isCoordinateUsed(Coordinate aCoordinate) {
    return opensimModelJNI.Joint_isCoordinateUsed(swigCPtr, this, Coordinate.getCPtr(aCoordinate), aCoordinate);
  }

  public SpatialVec calcEquivalentSpatialForce(State s, Vector mobilityForces) {
    return new SpatialVec(opensimModelJNI.Joint_calcEquivalentSpatialForce(swigCPtr, this, State.getCPtr(s), s, Vector.getCPtr(mobilityForces), mobilityForces), true);
  }

  public double calcPower(State s) {
    return opensimModelJNI.Joint_calcPower(swigCPtr, this, State.getCPtr(s), s);
  }

  public void scale(ScaleSet aScaleSet) {
    opensimModelJNI.Joint_scale(swigCPtr, this, ScaleSet.getCPtr(aScaleSet), aScaleSet);
  }

  public void connectToModel(Model aModel) {
    opensimModelJNI.Joint_connectToModel(swigCPtr, this, Model.getCPtr(aModel), aModel);
  }

}
