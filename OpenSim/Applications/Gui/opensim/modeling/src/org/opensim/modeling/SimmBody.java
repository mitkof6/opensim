/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.31
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.opensim.modeling;

public class SimmBody extends AbstractBody {
  private long swigCPtr;

  public SimmBody(long cPtr, boolean cMemoryOwn) {
    super(opensimModelJNI.SWIGStorageUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  public static long getCPtr(SimmBody obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if(swigCPtr != 0 && swigCMemOwn) {
      swigCMemOwn = false;
      opensimModelJNI.delete_SimmBody(swigCPtr);
    }
    swigCPtr = 0;
    super.delete();
  }

  public SimmBody() {
    this(opensimModelJNI.new_SimmBody__SWIG_0(), true);
  }

  public SimmBody(SimmBody aBody) {
    this(opensimModelJNI.new_SimmBody__SWIG_1(SimmBody.getCPtr(aBody), aBody), true);
  }

  public OpenSimObject copy() {
    long cPtr = opensimModelJNI.SimmBody_copy(swigCPtr, this);
    return (cPtr == 0) ? null : new OpenSimObject(cPtr, false);
  }

  public void copyData(SimmBody aBody) {
    opensimModelJNI.SimmBody_copyData(swigCPtr, this, SimmBody.getCPtr(aBody), aBody);
  }

  public void setup(AbstractDynamicsEngine aEngine) {
    opensimModelJNI.SimmBody_setup(swigCPtr, this, AbstractDynamicsEngine.getCPtr(aEngine), aEngine);
  }

  public double getMass() {
    return opensimModelJNI.SimmBody_getMass(swigCPtr, this);
  }

  public boolean setMass(double aMass) {
    return opensimModelJNI.SimmBody_setMass(swigCPtr, this, aMass);
  }

  public void getMassCenter(double[] rVec) {
    opensimModelJNI.SimmBody_getMassCenter(swigCPtr, this, rVec);
  }

  public boolean setMassCenter(double[] aVec) {
    return opensimModelJNI.SimmBody_setMassCenter(swigCPtr, this, aVec);
  }

  public void getInertia(SWIGTYPE_p_a_3__double rInertia) {
    opensimModelJNI.SimmBody_getInertia(swigCPtr, this, SWIGTYPE_p_a_3__double.getCPtr(rInertia));
  }

  public boolean setInertia(ArrayDouble aInertia) {
    return opensimModelJNI.SimmBody_setInertia(swigCPtr, this, ArrayDouble.getCPtr(aInertia), aInertia);
  }

  public void scale(ArrayDouble aScaleFactors, boolean aScaleMass) {
    opensimModelJNI.SimmBody_scale__SWIG_0(swigCPtr, this, ArrayDouble.getCPtr(aScaleFactors), aScaleFactors, aScaleMass);
  }

  public void scale(ArrayDouble aScaleFactors) {
    opensimModelJNI.SimmBody_scale__SWIG_1(swigCPtr, this, ArrayDouble.getCPtr(aScaleFactors), aScaleFactors);
  }

  public void scaleInertialProperties(ArrayDouble aScaleFactors, boolean aScaleMass) {
    opensimModelJNI.SimmBody_scaleInertialProperties__SWIG_0(swigCPtr, this, ArrayDouble.getCPtr(aScaleFactors), aScaleFactors, aScaleMass);
  }

  public void scaleInertialProperties(ArrayDouble aScaleFactors) {
    opensimModelJNI.SimmBody_scaleInertialProperties__SWIG_1(swigCPtr, this, ArrayDouble.getCPtr(aScaleFactors), aScaleFactors);
  }

  public void scaleMass(double aScaleFactor) {
    opensimModelJNI.SimmBody_scaleMass(swigCPtr, this, aScaleFactor);
  }

  public VisibleObject getDisplayer() {
    long cPtr = opensimModelJNI.SimmBody_getDisplayer(swigCPtr, this);
    return (cPtr == 0) ? null : new VisibleObject(cPtr, false);
  }

  public void getScaleFactors(ArrayDouble aScaleFactors) {
    opensimModelJNI.SimmBody_getScaleFactors(swigCPtr, this, ArrayDouble.getCPtr(aScaleFactors), aScaleFactors);
  }

}
