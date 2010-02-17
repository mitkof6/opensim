/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.31
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.opensim.modeling;

public class ModelComponentSetContactGeometry extends SetContactGeometry {
  private long swigCPtr;

  public ModelComponentSetContactGeometry(long cPtr, boolean cMemoryOwn) {
    super(opensimModelJNI.SWIGStorageUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  public static long getCPtr(ModelComponentSetContactGeometry obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if(swigCPtr != 0 && swigCMemOwn) {
      swigCMemOwn = false;
      opensimModelJNI.delete_ModelComponentSetContactGeometry(swigCPtr);
    }
    swigCPtr = 0;
    super.delete();
  }

  public ModelComponentSetContactGeometry() {
    this(opensimModelJNI.new_ModelComponentSetContactGeometry__SWIG_0(), true);
  }

  public ModelComponentSetContactGeometry(Model model) {
    this(opensimModelJNI.new_ModelComponentSetContactGeometry__SWIG_1(Model.getCPtr(model), model), true);
  }

  public ModelComponentSetContactGeometry(Model model, String aFileName, boolean aUpdateFromXMLNode) {
    this(opensimModelJNI.new_ModelComponentSetContactGeometry__SWIG_2(Model.getCPtr(model), model, aFileName, aUpdateFromXMLNode), true);
  }

  public ModelComponentSetContactGeometry(Model model, String aFileName) {
    this(opensimModelJNI.new_ModelComponentSetContactGeometry__SWIG_3(Model.getCPtr(model), model, aFileName), true);
  }

  public ModelComponentSetContactGeometry(ModelComponentSetContactGeometry aSet) {
    this(opensimModelJNI.new_ModelComponentSetContactGeometry__SWIG_4(ModelComponentSetContactGeometry.getCPtr(aSet), aSet), true);
  }

  public OpenSimObject copy() {
    long cPtr = opensimModelJNI.ModelComponentSetContactGeometry_copy(swigCPtr, this);
    return (cPtr == 0) ? null : new OpenSimObject(cPtr, false);
  }

  public boolean append(ContactGeometry aObject) {
    return opensimModelJNI.ModelComponentSetContactGeometry_append__SWIG_0(swigCPtr, this, ContactGeometry.getCPtr(aObject), aObject);
  }

  public boolean insert(int aIndex, ContactGeometry aObject) {
    return opensimModelJNI.ModelComponentSetContactGeometry_insert(swigCPtr, this, aIndex, ContactGeometry.getCPtr(aObject), aObject);
  }

  public boolean set(int aIndex, ContactGeometry aObject, boolean preserveGroups) {
    return opensimModelJNI.ModelComponentSetContactGeometry_set__SWIG_0(swigCPtr, this, aIndex, ContactGeometry.getCPtr(aObject), aObject, preserveGroups);
  }

  public boolean set(int aIndex, ContactGeometry aObject) {
    return opensimModelJNI.ModelComponentSetContactGeometry_set__SWIG_1(swigCPtr, this, aIndex, ContactGeometry.getCPtr(aObject), aObject);
  }

}
