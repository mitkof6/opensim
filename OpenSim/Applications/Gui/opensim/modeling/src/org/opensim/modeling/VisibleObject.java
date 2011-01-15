/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.37
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.opensim.modeling;

public class VisibleObject extends OpenSimObject {
  private long swigCPtr;

  public VisibleObject(long cPtr, boolean cMemoryOwn) {
    super(opensimModelJNI.SWIGStorageUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  public static long getCPtr(VisibleObject obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if(swigCPtr != 0 && swigCMemOwn) {
      swigCMemOwn = false;
      opensimModelJNI.delete_VisibleObject(swigCPtr);
    }
    swigCPtr = 0;
    super.delete();
  }

  public VisibleObject() {
    this(opensimModelJNI.new_VisibleObject__SWIG_0(), true);
  }

  public VisibleObject(String aFileName) {
    this(opensimModelJNI.new_VisibleObject__SWIG_1(aFileName), true);
  }

  public VisibleObject(VisibleObject aVisibleObject) {
    this(opensimModelJNI.new_VisibleObject__SWIG_2(VisibleObject.getCPtr(aVisibleObject), aVisibleObject), true);
  }

  public OpenSimObject copy() {
    long cPtr = opensimModelJNI.VisibleObject_copy(swigCPtr, this);
    return (cPtr == 0) ? null : new OpenSimObject(cPtr, false);
  }

  public void setOwner(OpenSimObject aObject) {
    opensimModelJNI.VisibleObject_setOwner(swigCPtr, this, OpenSimObject.getCPtr(aObject), aObject);
  }

  public OpenSimObject getOwner() {
    long cPtr = opensimModelJNI.VisibleObject_getOwner(swigCPtr, this);
    return (cPtr == 0) ? null : new OpenSimObject(cPtr, false);
  }

  public void setNumGeometryFiles(int n) {
    opensimModelJNI.VisibleObject_setNumGeometryFiles(swigCPtr, this, n);
  }

  public void setGeometryFileName(int i, String aGeometryFileName) {
    opensimModelJNI.VisibleObject_setGeometryFileName(swigCPtr, this, i, aGeometryFileName);
  }

  public int getNumGeometryFiles() {
    return opensimModelJNI.VisibleObject_getNumGeometryFiles(swigCPtr, this);
  }

  public String getGeometryFileName(int i) {
    return opensimModelJNI.VisibleObject_getGeometryFileName(swigCPtr, this, i);
  }

  public GeometrySet getGeometrySet() {
    return new GeometrySet(opensimModelJNI.VisibleObject_getGeometrySet(swigCPtr, this), false);
  }

  public SWIGTYPE_p_SimTK__Transform getTransform() {
    return new SWIGTYPE_p_SimTK__Transform(opensimModelJNI.VisibleObject_getTransform(swigCPtr, this), false);
  }

  public SWIGTYPE_p_SimTK__Transform updTransform() {
    return new SWIGTYPE_p_SimTK__Transform(opensimModelJNI.VisibleObject_updTransform(swigCPtr, this), false);
  }

  public void getRotationsAndTranslationsAsArray6(double[] aArray) {
    opensimModelJNI.VisibleObject_getRotationsAndTranslationsAsArray6(swigCPtr, this, aArray);
  }

  public void getTransformAsDouble16(double[] flatList) {
    opensimModelJNI.VisibleObject_getTransformAsDouble16(swigCPtr, this, flatList);
  }

  public void setTransform(SWIGTYPE_p_SimTK__Transform aTransform) {
    opensimModelJNI.VisibleObject_setTransform(swigCPtr, this, SWIGTYPE_p_SimTK__Transform.getCPtr(aTransform));
  }

  public void translate(SWIGTYPE_p_SimTK__Vec3 t) {
    opensimModelJNI.VisibleObject_translate(swigCPtr, this, SWIGTYPE_p_SimTK__Vec3.getCPtr(t));
  }

  public void setScaleFactors(SWIGTYPE_p_SimTK__Vec3 aScaleFactors) {
    opensimModelJNI.VisibleObject_setScaleFactors__SWIG_0(swigCPtr, this, SWIGTYPE_p_SimTK__Vec3.getCPtr(aScaleFactors));
  }

  public void getScaleFactors(SWIGTYPE_p_SimTK__Vec3 aScaleFactors) {
    opensimModelJNI.VisibleObject_getScaleFactors__SWIG_0(swigCPtr, this, SWIGTYPE_p_SimTK__Vec3.getCPtr(aScaleFactors));
  }

  public void setScaleFactors(double[] aScaleFactors) {
    opensimModelJNI.VisibleObject_setScaleFactors__SWIG_1(swigCPtr, this, aScaleFactors);
  }

  public void getScaleFactors(double[] aScaleFactors) {
    opensimModelJNI.VisibleObject_getScaleFactors__SWIG_1(swigCPtr, this, aScaleFactors);
  }

  public boolean getShowAxes() {
    return opensimModelJNI.VisibleObject_getShowAxes(swigCPtr, this);
  }

  public void setShowAxes(boolean showAxes) {
    opensimModelJNI.VisibleObject_setShowAxes(swigCPtr, this, showAxes);
  }

  public DisplayGeometry.DisplayPreference getDisplayPreference() {
    return DisplayGeometry.DisplayPreference.swigToEnum(opensimModelJNI.VisibleObject_getDisplayPreference(swigCPtr, this));
  }

  public void setDisplayPreference(DisplayGeometry.DisplayPreference aPreference) {
    opensimModelJNI.VisibleObject_setDisplayPreference(swigCPtr, this, aPreference.swigValue());
  }

  public void addDependent(VisibleObject aChild) {
    opensimModelJNI.VisibleObject_addDependent(swigCPtr, this, VisibleObject.getCPtr(aChild), aChild);
  }

  public boolean hasDependent(VisibleObject aChild) {
    return opensimModelJNI.VisibleObject_hasDependent(swigCPtr, this, VisibleObject.getCPtr(aChild), aChild);
  }

  public void removeDependent(VisibleObject aChild) {
    opensimModelJNI.VisibleObject_removeDependent(swigCPtr, this, VisibleObject.getCPtr(aChild), aChild);
  }

  public int countDependents() {
    return opensimModelJNI.VisibleObject_countDependents(swigCPtr, this);
  }

  public VisibleObject getDependent(int i) {
    long cPtr = opensimModelJNI.VisibleObject_getDependent(swigCPtr, this, i);
    return (cPtr == 0) ? null : new VisibleObject(cPtr, false);
  }

  public void addGeometry(Geometry aGeometry) {
    opensimModelJNI.VisibleObject_addGeometry(swigCPtr, this, Geometry.getCPtr(aGeometry), aGeometry);
  }

  public void removeGeometry(Geometry aGeometry) {
    opensimModelJNI.VisibleObject_removeGeometry(swigCPtr, this, Geometry.getCPtr(aGeometry), aGeometry);
  }

  public void freeGeometry() {
    opensimModelJNI.VisibleObject_freeGeometry(swigCPtr, this);
  }

  public Geometry getGeometry(int i) {
    long cPtr = opensimModelJNI.VisibleObject_getGeometry(swigCPtr, this, i);
    return (cPtr == 0) ? null : new Geometry(cPtr, false);
  }

  public int countGeometry() {
    return opensimModelJNI.VisibleObject_countGeometry(swigCPtr, this);
  }

  public Geometry getDefaultGeometry() {
    long cPtr = opensimModelJNI.VisibleObject_getDefaultGeometry(swigCPtr, this);
    return (cPtr == 0) ? null : new Geometry(cPtr, false);
  }

  public void setupProperties() {
    opensimModelJNI.VisibleObject_setupProperties(swigCPtr, this);
  }

  public void updateFromXMLNode() {
    opensimModelJNI.VisibleObject_updateFromXMLNode(swigCPtr, this);
  }

}
