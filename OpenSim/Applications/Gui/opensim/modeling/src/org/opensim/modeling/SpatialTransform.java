/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.31
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.opensim.modeling;

public class SpatialTransform extends OpenSimObject {
  private long swigCPtr;

  public SpatialTransform(long cPtr, boolean cMemoryOwn) {
    super(opensimModelJNI.SWIGStorageUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  public static long getCPtr(SpatialTransform obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if(swigCPtr != 0 && swigCMemOwn) {
      swigCMemOwn = false;
      opensimModelJNI.delete_SpatialTransform(swigCPtr);
    }
    swigCPtr = 0;
    super.delete();
  }

  public SpatialTransform() {
    this(opensimModelJNI.new_SpatialTransform__SWIG_0(), true);
  }

  public SpatialTransform(SpatialTransform aSpatialTransform) {
    this(opensimModelJNI.new_SpatialTransform__SWIG_1(SpatialTransform.getCPtr(aSpatialTransform), aSpatialTransform), true);
  }

  public OpenSimObject copy() {
    long cPtr = opensimModelJNI.SpatialTransform_copy(swigCPtr, this);
    return (cPtr == 0) ? null : new OpenSimObject(cPtr, false);
  }

  public void copyData(SpatialTransform aSpatialTransform) {
    opensimModelJNI.SpatialTransform_copyData(swigCPtr, this, SpatialTransform.getCPtr(aSpatialTransform), aSpatialTransform);
  }

  public void setup(CustomJoint aJoint) {
    opensimModelJNI.SpatialTransform_setup(swigCPtr, this, CustomJoint.getCPtr(aJoint), aJoint);
  }

  public ArrayStr getCoordinateNames() {
    return new ArrayStr(opensimModelJNI.SpatialTransform_getCoordinateNames(swigCPtr, this), true);
  }

  public SWIGTYPE_p_std__vectorTstd__vectorTint_t_t getCooridinateIndices() {
    return new SWIGTYPE_p_std__vectorTstd__vectorTint_t_t(opensimModelJNI.SpatialTransform_getCooridinateIndices(swigCPtr, this), true);
  }

  public SWIGTYPE_p_std__vectorTSimTK__Function_const_p_t getFunctions() {
    return new SWIGTYPE_p_std__vectorTSimTK__Function_const_p_t(opensimModelJNI.SpatialTransform_getFunctions(swigCPtr, this), true);
  }

  public SWIGTYPE_p_std__vectorTSimTK__Vec3_t getAxes() {
    return new SWIGTYPE_p_std__vectorTSimTK__Vec3_t(opensimModelJNI.SpatialTransform_getAxes(swigCPtr, this), true);
  }

  public void scale(SWIGTYPE_p_SimTK__Vec3 scaleFactors) {
    opensimModelJNI.SpatialTransform_scale(swigCPtr, this, SWIGTYPE_p_SimTK__Vec3.getCPtr(scaleFactors));
  }

  public TransformAxis getTransformAxis(int aIndex) {
    return new TransformAxis(opensimModelJNI.SpatialTransform_getTransformAxis(swigCPtr, this, aIndex), false);
  }

}
