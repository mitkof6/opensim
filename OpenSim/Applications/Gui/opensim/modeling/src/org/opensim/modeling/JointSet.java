/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.31
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.opensim.modeling;

public class JointSet extends ModelComponentSetJoints {
  private long swigCPtr;

  public JointSet(long cPtr, boolean cMemoryOwn) {
    super(opensimModelJNI.SWIGStorageUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  public static long getCPtr(JointSet obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if(swigCPtr != 0 && swigCMemOwn) {
      swigCMemOwn = false;
      opensimModelJNI.delete_JointSet(swigCPtr);
    }
    swigCPtr = 0;
    super.delete();
  }

  public JointSet() {
    this(opensimModelJNI.new_JointSet__SWIG_0(), true);
  }

  public JointSet(Model model) {
    this(opensimModelJNI.new_JointSet__SWIG_1(Model.getCPtr(model), model), true);
  }

  public JointSet(JointSet aJointSet) {
    this(opensimModelJNI.new_JointSet__SWIG_2(JointSet.getCPtr(aJointSet), aJointSet), true);
  }

  public void setup(Model aModel) {
    opensimModelJNI.JointSet_setup(swigCPtr, this, Model.getCPtr(aModel), aModel);
  }

  public JointSet(Model model, String aFileName, boolean aUpdateFromXMLNode) {
    this(opensimModelJNI.new_JointSet__SWIG_3(Model.getCPtr(model), model, aFileName, aUpdateFromXMLNode), true);
  }

  public JointSet(Model model, String aFileName) {
    this(opensimModelJNI.new_JointSet__SWIG_4(Model.getCPtr(model), model, aFileName), true);
  }

  public void scale(ScaleSet aScaleSet) {
    opensimModelJNI.JointSet_scale(swigCPtr, this, ScaleSet.getCPtr(aScaleSet), aScaleSet);
  }

}
