/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.4
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.opensim.modeling;

public class ModelComponentSetCoordinates extends SetCoordinates {
  private long swigCPtr;

  public ModelComponentSetCoordinates(long cPtr, boolean cMemoryOwn) {
    super(opensimModelJNI.ModelComponentSetCoordinates_SWIGUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  public static long getCPtr(ModelComponentSetCoordinates obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        opensimModelJNI.delete_ModelComponentSetCoordinates(swigCPtr);
      }
      swigCPtr = 0;
    }
    super.delete();
  }

  public ModelComponentSetCoordinates() {
    this(opensimModelJNI.new_ModelComponentSetCoordinates__SWIG_0(), true);
  }

  public ModelComponentSetCoordinates(Model model) {
    this(opensimModelJNI.new_ModelComponentSetCoordinates__SWIG_1(Model.getCPtr(model), model), true);
  }

  public ModelComponentSetCoordinates(Model model, String aFileName, boolean aUpdateFromXMLNode) {
    this(opensimModelJNI.new_ModelComponentSetCoordinates__SWIG_2(Model.getCPtr(model), model, aFileName, aUpdateFromXMLNode), true);
  }

  public ModelComponentSetCoordinates(Model model, String aFileName) {
    this(opensimModelJNI.new_ModelComponentSetCoordinates__SWIG_3(Model.getCPtr(model), model, aFileName), true);
  }

  public ModelComponentSetCoordinates(ModelComponentSetCoordinates aSet) {
    this(opensimModelJNI.new_ModelComponentSetCoordinates__SWIG_4(ModelComponentSetCoordinates.getCPtr(aSet), aSet), true);
  }

  public OpenSimObject copy() {
    long cPtr = opensimModelJNI.ModelComponentSetCoordinates_copy(swigCPtr, this);
    return (cPtr == 0) ? null : new OpenSimObject(cPtr, false);
  }

  public boolean append(Coordinate aObject) {
    return opensimModelJNI.ModelComponentSetCoordinates_append(swigCPtr, this, Coordinate.getCPtr(aObject), aObject);
  }

  public boolean insert(int aIndex, Coordinate aObject) {
    return opensimModelJNI.ModelComponentSetCoordinates_insert(swigCPtr, this, aIndex, Coordinate.getCPtr(aObject), aObject);
  }

  public boolean set(int aIndex, Coordinate aObject, boolean preserveGroups) {
    return opensimModelJNI.ModelComponentSetCoordinates_set__SWIG_0(swigCPtr, this, aIndex, Coordinate.getCPtr(aObject), aObject, preserveGroups);
  }

  public boolean set(int aIndex, Coordinate aObject) {
    return opensimModelJNI.ModelComponentSetCoordinates_set__SWIG_1(swigCPtr, this, aIndex, Coordinate.getCPtr(aObject), aObject);
  }

}
