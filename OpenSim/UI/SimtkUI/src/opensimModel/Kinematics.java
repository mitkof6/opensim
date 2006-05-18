/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.29
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package opensimModel;

public class Kinematics extends Analysis {
  private long swigCPtr;

  protected Kinematics(long cPtr, boolean cMemoryOwn) {
    super(opensimModelJNI.SWIGKinematicsUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  protected static long getCPtr(Kinematics obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public void delete() {
    if(swigCPtr != 0 && swigCMemOwn) {
      swigCMemOwn = false;
      opensimModelJNI.delete_Kinematics(swigCPtr);
    }
    swigCPtr = 0;
    super.delete();
  }

  public Kinematics(Model aModel) {
    this(opensimModelJNI.new_Kinematics__SWIG_0(Model.getCPtr(aModel)), true);
  }

  public Kinematics() {
    this(opensimModelJNI.new_Kinematics__SWIG_1(), true);
  }

  public Kinematics(String aFileName) {
    this(opensimModelJNI.new_Kinematics__SWIG_2(aFileName), true);
  }

  public Kinematics(SWIGTYPE_p_DOMElement aElement) {
    this(opensimModelJNI.new_Kinematics__SWIG_3(SWIGTYPE_p_DOMElement.getCPtr(aElement)), true);
  }

  public Kinematics(Kinematics aObject) {
    this(opensimModelJNI.new_Kinematics__SWIG_4(Kinematics.getCPtr(aObject)), true);
  }

  public OpenSimObject copy() {
    long cPtr = opensimModelJNI.Kinematics_copy__SWIG_0(swigCPtr);
    return (cPtr == 0) ? null : new OpenSimObject(cPtr, false);
  }

  public OpenSimObject copy(SWIGTYPE_p_DOMElement aElement) {
    long cPtr = opensimModelJNI.Kinematics_copy__SWIG_1(swigCPtr, SWIGTYPE_p_DOMElement.getCPtr(aElement));
    return (cPtr == 0) ? null : new OpenSimObject(cPtr, false);
  }

  public void setStorageCapacityIncrements(int aIncrement) {
    opensimModelJNI.Kinematics_setStorageCapacityIncrements(swigCPtr, aIncrement);
  }

  public Storage getAccelerationStorage() {
    long cPtr = opensimModelJNI.Kinematics_getAccelerationStorage(swigCPtr);
    return (cPtr == 0) ? null : new Storage(cPtr, false);
  }

  public Storage getVelocityStorage() {
    long cPtr = opensimModelJNI.Kinematics_getVelocityStorage(swigCPtr);
    return (cPtr == 0) ? null : new Storage(cPtr, false);
  }

  public Storage getPositionStorage() {
    long cPtr = opensimModelJNI.Kinematics_getPositionStorage(swigCPtr);
    return (cPtr == 0) ? null : new Storage(cPtr, false);
  }

  public void setModel(Model aModel) {
    opensimModelJNI.Kinematics_setModel(swigCPtr, Model.getCPtr(aModel));
  }

  public int begin(int aStep, double aDT, double aT, SWIGTYPE_p_double aX, SWIGTYPE_p_double aY, SWIGTYPE_p_void aClientData) {
    return opensimModelJNI.Kinematics_begin__SWIG_0(swigCPtr, aStep, aDT, aT, SWIGTYPE_p_double.getCPtr(aX), SWIGTYPE_p_double.getCPtr(aY), SWIGTYPE_p_void.getCPtr(aClientData));
  }

  public int begin(int aStep, double aDT, double aT, SWIGTYPE_p_double aX, SWIGTYPE_p_double aY) {
    return opensimModelJNI.Kinematics_begin__SWIG_1(swigCPtr, aStep, aDT, aT, SWIGTYPE_p_double.getCPtr(aX), SWIGTYPE_p_double.getCPtr(aY));
  }

  public int step(SWIGTYPE_p_double aXPrev, SWIGTYPE_p_double aYPrev, int aStep, double aDT, double aT, SWIGTYPE_p_double aX, SWIGTYPE_p_double aY, SWIGTYPE_p_void aClientData) {
    return opensimModelJNI.Kinematics_step__SWIG_0(swigCPtr, SWIGTYPE_p_double.getCPtr(aXPrev), SWIGTYPE_p_double.getCPtr(aYPrev), aStep, aDT, aT, SWIGTYPE_p_double.getCPtr(aX), SWIGTYPE_p_double.getCPtr(aY), SWIGTYPE_p_void.getCPtr(aClientData));
  }

  public int step(SWIGTYPE_p_double aXPrev, SWIGTYPE_p_double aYPrev, int aStep, double aDT, double aT, SWIGTYPE_p_double aX, SWIGTYPE_p_double aY) {
    return opensimModelJNI.Kinematics_step__SWIG_1(swigCPtr, SWIGTYPE_p_double.getCPtr(aXPrev), SWIGTYPE_p_double.getCPtr(aYPrev), aStep, aDT, aT, SWIGTYPE_p_double.getCPtr(aX), SWIGTYPE_p_double.getCPtr(aY));
  }

  public int end(int aStep, double aDT, double aT, SWIGTYPE_p_double aX, SWIGTYPE_p_double aY, SWIGTYPE_p_void aClientData) {
    return opensimModelJNI.Kinematics_end__SWIG_0(swigCPtr, aStep, aDT, aT, SWIGTYPE_p_double.getCPtr(aX), SWIGTYPE_p_double.getCPtr(aY), SWIGTYPE_p_void.getCPtr(aClientData));
  }

  public int end(int aStep, double aDT, double aT, SWIGTYPE_p_double aX, SWIGTYPE_p_double aY) {
    return opensimModelJNI.Kinematics_end__SWIG_1(swigCPtr, aStep, aDT, aT, SWIGTYPE_p_double.getCPtr(aX), SWIGTYPE_p_double.getCPtr(aY));
  }

  public int printResults(String aBaseName, String aDir, double aDT, String aExtension) {
    return opensimModelJNI.Kinematics_printResults__SWIG_0(swigCPtr, aBaseName, aDir, aDT, aExtension);
  }

  public int printResults(String aBaseName, String aDir, double aDT) {
    return opensimModelJNI.Kinematics_printResults__SWIG_1(swigCPtr, aBaseName, aDir, aDT);
  }

  public int printResults(String aBaseName, String aDir) {
    return opensimModelJNI.Kinematics_printResults__SWIG_2(swigCPtr, aBaseName, aDir);
  }

  public int printResults(String aBaseName) {
    return opensimModelJNI.Kinematics_printResults__SWIG_3(swigCPtr, aBaseName);
  }

  public ArrayStorage getStorageList() {
    return new ArrayStorage(opensimModelJNI.Kinematics_getStorageList(swigCPtr), false);
  }

}
