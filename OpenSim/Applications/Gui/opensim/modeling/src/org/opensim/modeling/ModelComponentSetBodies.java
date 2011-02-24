/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.40
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.opensim.modeling;

public class ModelComponentSetBodies extends SetBodies {
  private long swigCPtr;

  public ModelComponentSetBodies(long cPtr, boolean cMemoryOwn) {
    super(opensimModelJNI.SWIGStorageUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  public static long getCPtr(ModelComponentSetBodies obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        opensimModelJNI.delete_ModelComponentSetBodies(swigCPtr);
      }
      swigCPtr = 0;
    }
    super.delete();
  }

  public ModelComponentSetBodies() {
    this(opensimModelJNI.new_ModelComponentSetBodies__SWIG_0(), true);
  }

  public ModelComponentSetBodies(Model model) {
    this(opensimModelJNI.new_ModelComponentSetBodies__SWIG_1(Model.getCPtr(model), model), true);
  }

  public ModelComponentSetBodies(Model model, String aFileName, boolean aUpdateFromXMLNode) {
    this(opensimModelJNI.new_ModelComponentSetBodies__SWIG_2(Model.getCPtr(model), model, aFileName, aUpdateFromXMLNode), true);
  }

  public ModelComponentSetBodies(Model model, String aFileName) {
    this(opensimModelJNI.new_ModelComponentSetBodies__SWIG_3(Model.getCPtr(model), model, aFileName), true);
  }

  public ModelComponentSetBodies(ModelComponentSetBodies aSet) {
    this(opensimModelJNI.new_ModelComponentSetBodies__SWIG_4(ModelComponentSetBodies.getCPtr(aSet), aSet), true);
  }

  public OpenSimObject copy() {
    long cPtr = opensimModelJNI.ModelComponentSetBodies_copy(swigCPtr, this);
    return (cPtr == 0) ? null : new OpenSimObject(cPtr, false);
  }

  public boolean append(Body aObject) {
    return opensimModelJNI.ModelComponentSetBodies_append(swigCPtr, this, Body.getCPtr(aObject), aObject);
  }

  public boolean insert(int aIndex, Body aObject) {
    return opensimModelJNI.ModelComponentSetBodies_insert(swigCPtr, this, aIndex, Body.getCPtr(aObject), aObject);
  }

  public boolean set(int aIndex, Body aObject, boolean preserveGroups) {
    return opensimModelJNI.ModelComponentSetBodies_set__SWIG_0(swigCPtr, this, aIndex, Body.getCPtr(aObject), aObject, preserveGroups);
  }

  public boolean set(int aIndex, Body aObject) {
    return opensimModelJNI.ModelComponentSetBodies_set__SWIG_1(swigCPtr, this, aIndex, Body.getCPtr(aObject), aObject);
  }

}
