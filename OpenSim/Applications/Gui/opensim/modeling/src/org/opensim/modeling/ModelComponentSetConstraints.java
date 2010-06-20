/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.31
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.opensim.modeling;

public class ModelComponentSetConstraints extends SetConstraints {
  private long swigCPtr;

  public ModelComponentSetConstraints(long cPtr, boolean cMemoryOwn) {
    super(opensimModelJNI.SWIGStorageUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  public static long getCPtr(ModelComponentSetConstraints obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if(swigCPtr != 0 && swigCMemOwn) {
      swigCMemOwn = false;
      opensimModelJNI.delete_ModelComponentSetConstraints(swigCPtr);
    }
    swigCPtr = 0;
    super.delete();
  }

  public ModelComponentSetConstraints() {
    this(opensimModelJNI.new_ModelComponentSetConstraints__SWIG_0(), true);
  }

  public ModelComponentSetConstraints(Model model) {
    this(opensimModelJNI.new_ModelComponentSetConstraints__SWIG_1(Model.getCPtr(model), model), true);
  }

  public ModelComponentSetConstraints(Model model, String aFileName, boolean aUpdateFromXMLNode) {
    this(opensimModelJNI.new_ModelComponentSetConstraints__SWIG_2(Model.getCPtr(model), model, aFileName, aUpdateFromXMLNode), true);
  }

  public ModelComponentSetConstraints(Model model, String aFileName) {
    this(opensimModelJNI.new_ModelComponentSetConstraints__SWIG_3(Model.getCPtr(model), model, aFileName), true);
  }

  public ModelComponentSetConstraints(ModelComponentSetConstraints aSet) {
    this(opensimModelJNI.new_ModelComponentSetConstraints__SWIG_4(ModelComponentSetConstraints.getCPtr(aSet), aSet), true);
  }

  public OpenSimObject copy() {
    long cPtr = opensimModelJNI.ModelComponentSetConstraints_copy(swigCPtr, this);
    return (cPtr == 0) ? null : new OpenSimObject(cPtr, false);
  }

  public boolean append(Constraint aObject) {
    return opensimModelJNI.ModelComponentSetConstraints_append(swigCPtr, this, Constraint.getCPtr(aObject), aObject);
  }

  public boolean insert(int aIndex, Constraint aObject) {
    return opensimModelJNI.ModelComponentSetConstraints_insert(swigCPtr, this, aIndex, Constraint.getCPtr(aObject), aObject);
  }

  public boolean set(int aIndex, Constraint aObject, boolean preserveGroups) {
    return opensimModelJNI.ModelComponentSetConstraints_set__SWIG_0(swigCPtr, this, aIndex, Constraint.getCPtr(aObject), aObject, preserveGroups);
  }

  public boolean set(int aIndex, Constraint aObject) {
    return opensimModelJNI.ModelComponentSetConstraints_set__SWIG_1(swigCPtr, this, aIndex, Constraint.getCPtr(aObject), aObject);
  }

}
