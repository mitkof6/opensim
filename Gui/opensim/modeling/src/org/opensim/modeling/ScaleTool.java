/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.4
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.opensim.modeling;

public class ScaleTool extends OpenSimObject {
  private long swigCPtr;

  public ScaleTool(long cPtr, boolean cMemoryOwn) {
    super(opensimModelJNI.ScaleTool_SWIGUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  public static long getCPtr(ScaleTool obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        opensimModelJNI.delete_ScaleTool(swigCPtr);
      }
      swigCPtr = 0;
    }
    super.delete();
  }

  public static ScaleTool safeDownCast(OpenSimObject obj) {
    long cPtr = opensimModelJNI.ScaleTool_safeDownCast(OpenSimObject.getCPtr(obj), obj);
    return (cPtr == 0) ? null : new ScaleTool(cPtr, false);
  }

  public void assign(OpenSimObject aObject) {
    opensimModelJNI.ScaleTool_assign(swigCPtr, this, OpenSimObject.getCPtr(aObject), aObject);
  }

  public static String getClassName() {
    return opensimModelJNI.ScaleTool_getClassName();
  }

  public OpenSimObject clone() {
    long cPtr = opensimModelJNI.ScaleTool_clone(swigCPtr, this);
    return (cPtr == 0) ? null : new ScaleTool(cPtr, false);
  }

  public String getConcreteClassName() {
    return opensimModelJNI.ScaleTool_getConcreteClassName(swigCPtr, this);
  }

  public ScaleTool() {
    this(opensimModelJNI.new_ScaleTool__SWIG_0(), true);
  }

  public ScaleTool(String aFileName) throws java.io.IOException {
    this(opensimModelJNI.new_ScaleTool__SWIG_1(aFileName), true);
  }

  public ScaleTool(ScaleTool aSubject) {
    this(opensimModelJNI.new_ScaleTool__SWIG_2(ScaleTool.getCPtr(aSubject), aSubject), true);
  }

  public void copyData(ScaleTool aSubject) {
    opensimModelJNI.ScaleTool_copyData(swigCPtr, this, ScaleTool.getCPtr(aSubject), aSubject);
  }

  public Model createModel() {
    long cPtr = opensimModelJNI.ScaleTool_createModel(swigCPtr, this);
    return (cPtr == 0) ? null : new Model(cPtr, false);
  }

  public GenericModelMaker getGenericModelMaker() {
    return new GenericModelMaker(opensimModelJNI.ScaleTool_getGenericModelMaker(swigCPtr, this), false);
  }

  public ModelScaler getModelScaler() {
    return new ModelScaler(opensimModelJNI.ScaleTool_getModelScaler(swigCPtr, this), false);
  }

  public MarkerPlacer getMarkerPlacer() {
    return new MarkerPlacer(opensimModelJNI.ScaleTool_getMarkerPlacer(swigCPtr, this), false);
  }

  public boolean isDefaultGenericModelMaker() {
    return opensimModelJNI.ScaleTool_isDefaultGenericModelMaker(swigCPtr, this);
  }

  public boolean isDefaultModelScaler() {
    return opensimModelJNI.ScaleTool_isDefaultModelScaler(swigCPtr, this);
  }

  public boolean isDefaultMarkerPlacer() {
    return opensimModelJNI.ScaleTool_isDefaultMarkerPlacer(swigCPtr, this);
  }

  public static void registerTypes() {
    opensimModelJNI.ScaleTool_registerTypes();
  }

  public double getSubjectMass() {
    return opensimModelJNI.ScaleTool_getSubjectMass(swigCPtr, this);
  }

  public double getSubjectAge() {
    return opensimModelJNI.ScaleTool_getSubjectAge(swigCPtr, this);
  }

  public double getSubjectHeight() {
    return opensimModelJNI.ScaleTool_getSubjectHeight(swigCPtr, this);
  }

  public void setSubjectMass(double mass) {
    opensimModelJNI.ScaleTool_setSubjectMass(swigCPtr, this, mass);
  }

  public void setSubjectAge(double age) {
    opensimModelJNI.ScaleTool_setSubjectAge(swigCPtr, this, age);
  }

  public void setSubjectHeight(double height) {
    opensimModelJNI.ScaleTool_setSubjectHeight(swigCPtr, this, height);
  }

  public String getPathToSubject() {
    return opensimModelJNI.ScaleTool_getPathToSubject(swigCPtr, this);
  }

  public void setPathToSubject(String aPath) {
    opensimModelJNI.ScaleTool_setPathToSubject(swigCPtr, this, aPath);
  }

  public void setPrintResultFiles(boolean aToWrite) {
    opensimModelJNI.ScaleTool_setPrintResultFiles(swigCPtr, this, aToWrite);
  }

}
