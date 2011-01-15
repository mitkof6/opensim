/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.37
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.opensim.modeling;

public class GeometryPath extends ModelComponent {
  private long swigCPtr;

  public GeometryPath(long cPtr, boolean cMemoryOwn) {
    super(opensimModelJNI.SWIGStorageUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  public static long getCPtr(GeometryPath obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if(swigCPtr != 0 && swigCMemOwn) {
      swigCMemOwn = false;
      opensimModelJNI.delete_GeometryPath(swigCPtr);
    }
    swigCPtr = 0;
    super.delete();
  }

  public GeometryPath() {
    this(opensimModelJNI.new_GeometryPath__SWIG_0(), true);
  }

  public GeometryPath(GeometryPath aPath) {
    this(opensimModelJNI.new_GeometryPath__SWIG_1(GeometryPath.getCPtr(aPath), aPath), true);
  }

  public OpenSimObject copy() {
    long cPtr = opensimModelJNI.GeometryPath_copy__SWIG_0(swigCPtr, this);
    return (cPtr == 0) ? null : new OpenSimObject(cPtr, false);
  }

  public void setName(String aName) {
    opensimModelJNI.GeometryPath_setName(swigCPtr, this, aName);
  }

  public void copyData(GeometryPath aPath) {
    opensimModelJNI.GeometryPath_copyData(swigCPtr, this, GeometryPath.getCPtr(aPath), aPath);
  }

  public PathPointSet getPathPointSet() {
    return new PathPointSet(opensimModelJNI.GeometryPath_getPathPointSet(swigCPtr, this), false);
  }

  public PathPointSet updPathPointSet() {
    return new PathPointSet(opensimModelJNI.GeometryPath_updPathPointSet(swigCPtr, this), false);
  }

  public PathWrapSet getWrapSet() {
    return new PathWrapSet(opensimModelJNI.GeometryPath_getWrapSet(swigCPtr, this), false);
  }

  public PathPoint addPathPoint(SWIGTYPE_p_SimTK__State s, int aIndex, Body aBody) {
    long cPtr = opensimModelJNI.GeometryPath_addPathPoint(swigCPtr, this, SWIGTYPE_p_SimTK__State.getCPtr(s), aIndex, Body.getCPtr(aBody), aBody);
    return (cPtr == 0) ? null : new PathPoint(cPtr, false);
  }

  public PathPoint appendNewPathPoint(String proposedName, Body aBody, SWIGTYPE_p_SimTK__Vec3 aPositionOnBody) {
    long cPtr = opensimModelJNI.GeometryPath_appendNewPathPoint(swigCPtr, this, proposedName, Body.getCPtr(aBody), aBody, SWIGTYPE_p_SimTK__Vec3.getCPtr(aPositionOnBody));
    return (cPtr == 0) ? null : new PathPoint(cPtr, false);
  }

  public boolean canDeletePathPoint(int aIndex) {
    return opensimModelJNI.GeometryPath_canDeletePathPoint(swigCPtr, this, aIndex);
  }

  public boolean deletePathPoint(SWIGTYPE_p_SimTK__State s, int aIndex) {
    return opensimModelJNI.GeometryPath_deletePathPoint(swigCPtr, this, SWIGTYPE_p_SimTK__State.getCPtr(s), aIndex);
  }

  public void addPathWrap(SWIGTYPE_p_SimTK__State s, WrapObject aWrapObject) {
    opensimModelJNI.GeometryPath_addPathWrap(swigCPtr, this, SWIGTYPE_p_SimTK__State.getCPtr(s), WrapObject.getCPtr(aWrapObject), aWrapObject);
  }

  public void moveUpPathWrap(SWIGTYPE_p_SimTK__State s, int aIndex) {
    opensimModelJNI.GeometryPath_moveUpPathWrap(swigCPtr, this, SWIGTYPE_p_SimTK__State.getCPtr(s), aIndex);
  }

  public void moveDownPathWrap(SWIGTYPE_p_SimTK__State s, int aIndex) {
    opensimModelJNI.GeometryPath_moveDownPathWrap(swigCPtr, this, SWIGTYPE_p_SimTK__State.getCPtr(s), aIndex);
  }

  public void deletePathWrap(SWIGTYPE_p_SimTK__State s, int aIndex) {
    opensimModelJNI.GeometryPath_deletePathWrap(swigCPtr, this, SWIGTYPE_p_SimTK__State.getCPtr(s), aIndex);
  }

  public boolean replacePathPoint(SWIGTYPE_p_SimTK__State s, PathPoint aOldPathPoint, PathPoint aNewPathPoint) {
    return opensimModelJNI.GeometryPath_replacePathPoint(swigCPtr, this, SWIGTYPE_p_SimTK__State.getCPtr(s), PathPoint.getCPtr(aOldPathPoint), aOldPathPoint, PathPoint.getCPtr(aNewPathPoint), aNewPathPoint);
  }

  public OpenSimObject getOwner() {
    long cPtr = opensimModelJNI.GeometryPath_getOwner(swigCPtr, this);
    return (cPtr == 0) ? null : new OpenSimObject(cPtr, false);
  }

  public void setOwner(OpenSimObject anObject) {
    opensimModelJNI.GeometryPath_setOwner(swigCPtr, this, OpenSimObject.getCPtr(anObject), anObject);
  }

  public double getLength(SWIGTYPE_p_SimTK__State s) {
    return opensimModelJNI.GeometryPath_getLength(swigCPtr, this, SWIGTYPE_p_SimTK__State.getCPtr(s));
  }

  public void setLength(SWIGTYPE_p_SimTK__State s, double length) {
    opensimModelJNI.GeometryPath_setLength(swigCPtr, this, SWIGTYPE_p_SimTK__State.getCPtr(s), length);
  }

  public double getPreScaleLength(SWIGTYPE_p_SimTK__State s) {
    return opensimModelJNI.GeometryPath_getPreScaleLength(swigCPtr, this, SWIGTYPE_p_SimTK__State.getCPtr(s));
  }

  public void setPreScaleLength(SWIGTYPE_p_SimTK__State s, double preScaleLength) {
    opensimModelJNI.GeometryPath_setPreScaleLength(swigCPtr, this, SWIGTYPE_p_SimTK__State.getCPtr(s), preScaleLength);
  }

  public ArrayPathPoint getCurrentPath(SWIGTYPE_p_SimTK__State s) {
    return new ArrayPathPoint(opensimModelJNI.GeometryPath_getCurrentPath(swigCPtr, this, SWIGTYPE_p_SimTK__State.getCPtr(s)), false);
  }

  public ArrayPathPoint updCurrentPath(SWIGTYPE_p_SimTK__State s) {
    return new ArrayPathPoint(opensimModelJNI.GeometryPath_updCurrentPath(swigCPtr, this, SWIGTYPE_p_SimTK__State.getCPtr(s)), false);
  }

  public ArrayPathPoint getCurrentDisplayPath(SWIGTYPE_p_SimTK__State s) {
    return new ArrayPathPoint(opensimModelJNI.GeometryPath_getCurrentDisplayPath(swigCPtr, this, SWIGTYPE_p_SimTK__State.getCPtr(s)), false);
  }

  public ArrayPathPoint updCurrentDisplayPath(SWIGTYPE_p_SimTK__State s) {
    return new ArrayPathPoint(opensimModelJNI.GeometryPath_updCurrentDisplayPath(swigCPtr, this, SWIGTYPE_p_SimTK__State.getCPtr(s)), false);
  }

  public void getPointForceDirections(SWIGTYPE_p_SimTK__State s, SWIGTYPE_p_OpenSim__ArrayT_OpenSim__PointForceDirection_p_t rPFDs) {
    opensimModelJNI.GeometryPath_getPointForceDirections(swigCPtr, this, SWIGTYPE_p_SimTK__State.getCPtr(s), SWIGTYPE_p_OpenSim__ArrayT_OpenSim__PointForceDirection_p_t.getCPtr(rPFDs));
  }

  public double computeMomentArm(SWIGTYPE_p_SimTK__State s, Coordinate aCoord) {
    return opensimModelJNI.GeometryPath_computeMomentArm(swigCPtr, this, SWIGTYPE_p_SimTK__State.getCPtr(s), Coordinate.getCPtr(aCoord), aCoord);
  }

  public void preScale(SWIGTYPE_p_SimTK__State s, ScaleSet aScaleSet) {
    opensimModelJNI.GeometryPath_preScale(swigCPtr, this, SWIGTYPE_p_SimTK__State.getCPtr(s), ScaleSet.getCPtr(aScaleSet), aScaleSet);
  }

  public void scale(SWIGTYPE_p_SimTK__State s, ScaleSet aScaleSet) {
    opensimModelJNI.GeometryPath_scale(swigCPtr, this, SWIGTYPE_p_SimTK__State.getCPtr(s), ScaleSet.getCPtr(aScaleSet), aScaleSet);
  }

  public void postScale(SWIGTYPE_p_SimTK__State s, ScaleSet aScaleSet) {
    opensimModelJNI.GeometryPath_postScale(swigCPtr, this, SWIGTYPE_p_SimTK__State.getCPtr(s), ScaleSet.getCPtr(aScaleSet), aScaleSet);
  }

  public int getNumStateVariables() {
    return opensimModelJNI.GeometryPath_getNumStateVariables(swigCPtr, this);
  }

  public VisibleObject getDisplayer() {
    long cPtr = opensimModelJNI.GeometryPath_getDisplayer(swigCPtr, this);
    return (cPtr == 0) ? null : new VisibleObject(cPtr, false);
  }

  public void updateDisplayer(SWIGTYPE_p_SimTK__State s) {
    opensimModelJNI.GeometryPath_updateDisplayer(swigCPtr, this, SWIGTYPE_p_SimTK__State.getCPtr(s));
  }

  public static boolean isKindOf(String type) {
    return opensimModelJNI.GeometryPath_isKindOf(type);
  }

  public boolean isA(String type) {
    return opensimModelJNI.GeometryPath_isA(swigCPtr, this, type);
  }

  public static GeometryPath safeDownCast(OpenSimObject obj) {
    long cPtr = opensimModelJNI.GeometryPath_safeDownCast(OpenSimObject.getCPtr(obj), obj);
    return (cPtr == 0) ? null : new GeometryPath(cPtr, false);
  }

  public void copy(OpenSimObject aObject) {
    opensimModelJNI.GeometryPath_copy__SWIG_1(swigCPtr, this, OpenSimObject.getCPtr(aObject), aObject);
  }

  public void updateGeometry(SWIGTYPE_p_SimTK__State s) {
    opensimModelJNI.GeometryPath_updateGeometry(swigCPtr, this, SWIGTYPE_p_SimTK__State.getCPtr(s));
  }

}
