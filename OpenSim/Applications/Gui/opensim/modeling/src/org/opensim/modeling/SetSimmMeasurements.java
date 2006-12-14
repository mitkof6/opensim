/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.29
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.opensim.modeling;

public class SetSimmMeasurements extends OpenSimObject {
  private long swigCPtr;

  public SetSimmMeasurements(long cPtr, boolean cMemoryOwn) {
    super(opensimModelJNI.SWIGStorageUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  public static long getCPtr(SetSimmMeasurements obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public void delete() {
    if(swigCPtr != 0 && swigCMemOwn) {
      swigCMemOwn = false;
      opensimModelJNI.delete_SetSimmMeasurements(swigCPtr);
    }
    swigCPtr = 0;
    super.delete();
  }

  public SetSimmMeasurements() {
    this(opensimModelJNI.new_SetSimmMeasurements__SWIG_0(), true);
  }

  public SetSimmMeasurements(String aFileName) {
    this(opensimModelJNI.new_SetSimmMeasurements__SWIG_1(aFileName), true);
  }

  public SetSimmMeasurements(SWIGTYPE_p_DOMElement aElement) {
    this(opensimModelJNI.new_SetSimmMeasurements__SWIG_2(SWIGTYPE_p_DOMElement.getCPtr(aElement)), true);
  }

  public SetSimmMeasurements(SetSimmMeasurements aSet) {
    this(opensimModelJNI.new_SetSimmMeasurements__SWIG_3(SetSimmMeasurements.getCPtr(aSet)), true);
  }

  public OpenSimObject copy() {
    long cPtr = opensimModelJNI.SetSimmMeasurements_copy(swigCPtr);
    return (cPtr == 0) ? null : new OpenSimObject(cPtr, false);
  }

  public void setMemoryOwner(boolean aTrueFalse) {
    opensimModelJNI.SetSimmMeasurements_setMemoryOwner(swigCPtr, aTrueFalse);
  }

  public boolean getMemoryOwner() {
    return opensimModelJNI.SetSimmMeasurements_getMemoryOwner(swigCPtr);
  }

  public boolean computeNewCapacity(int aMinCapacity, SWIGTYPE_p_int rNewCapacity) {
    return opensimModelJNI.SetSimmMeasurements_computeNewCapacity(swigCPtr, aMinCapacity, SWIGTYPE_p_int.getCPtr(rNewCapacity));
  }

  public boolean ensureCapacity(int aCapacity) {
    return opensimModelJNI.SetSimmMeasurements_ensureCapacity(swigCPtr, aCapacity);
  }

  public void trim() {
    opensimModelJNI.SetSimmMeasurements_trim(swigCPtr);
  }

  public int getCapacity() {
    return opensimModelJNI.SetSimmMeasurements_getCapacity(swigCPtr);
  }

  public void setCapacityIncrement(int aIncrement) {
    opensimModelJNI.SetSimmMeasurements_setCapacityIncrement(swigCPtr, aIncrement);
  }

  public int getCapacityIncrement() {
    return opensimModelJNI.SetSimmMeasurements_getCapacityIncrement(swigCPtr);
  }

  public boolean setSize(int aSize) {
    return opensimModelJNI.SetSimmMeasurements_setSize(swigCPtr, aSize);
  }

  public int getSize() {
    return opensimModelJNI.SetSimmMeasurements_getSize(swigCPtr);
  }

  public int getIndex(SimmMeasurement aObject, int aStartIndex) {
    return opensimModelJNI.SetSimmMeasurements_getIndex__SWIG_0(swigCPtr, SimmMeasurement.getCPtr(aObject), aStartIndex);
  }

  public int getIndex(SimmMeasurement aObject) {
    return opensimModelJNI.SetSimmMeasurements_getIndex__SWIG_1(swigCPtr, SimmMeasurement.getCPtr(aObject));
  }

  public int getIndex(String aName, int aStartIndex) {
    return opensimModelJNI.SetSimmMeasurements_getIndex__SWIG_2(swigCPtr, aName, aStartIndex);
  }

  public int getIndex(String aName) {
    return opensimModelJNI.SetSimmMeasurements_getIndex__SWIG_3(swigCPtr, aName);
  }

  public boolean append(SimmMeasurement aObject) {
    return opensimModelJNI.SetSimmMeasurements_append__SWIG_0(swigCPtr, SimmMeasurement.getCPtr(aObject));
  }

  public boolean append(SWIGTYPE_p_OpenSim__ArrayPtrsTOpenSim__SimmMeasurement_t aArray) {
    return opensimModelJNI.SetSimmMeasurements_append__SWIG_1(swigCPtr, SWIGTYPE_p_OpenSim__ArrayPtrsTOpenSim__SimmMeasurement_t.getCPtr(aArray));
  }

  public boolean insert(int aIndex, SimmMeasurement aObject) {
    return opensimModelJNI.SetSimmMeasurements_insert(swigCPtr, aIndex, SimmMeasurement.getCPtr(aObject));
  }

  public boolean remove(int aIndex) {
    return opensimModelJNI.SetSimmMeasurements_remove__SWIG_0(swigCPtr, aIndex);
  }

  public boolean remove(SimmMeasurement aObject) {
    return opensimModelJNI.SetSimmMeasurements_remove__SWIG_1(swigCPtr, SimmMeasurement.getCPtr(aObject));
  }

  public void clearAndDestroy() {
    opensimModelJNI.SetSimmMeasurements_clearAndDestroy(swigCPtr);
  }

  public boolean set(int aIndex, SimmMeasurement aObject) {
    return opensimModelJNI.SetSimmMeasurements_set(swigCPtr, aIndex, SimmMeasurement.getCPtr(aObject));
  }

  public SimmMeasurement get(int aIndex) {
    long cPtr = opensimModelJNI.SetSimmMeasurements_get__SWIG_0(swigCPtr, aIndex);
    return (cPtr == 0) ? null : new SimmMeasurement(cPtr, false);
  }

  public SimmMeasurement get(String aName) {
    long cPtr = opensimModelJNI.SetSimmMeasurements_get__SWIG_1(swigCPtr, aName);
    return (cPtr == 0) ? null : new SimmMeasurement(cPtr, false);
  }

  public void getNames(ArrayStr rNames) {
    opensimModelJNI.SetSimmMeasurements_getNames(swigCPtr, ArrayStr.getCPtr(rNames));
  }

  public SimmMeasurement getLast() {
    long cPtr = opensimModelJNI.SetSimmMeasurements_getLast(swigCPtr);
    return (cPtr == 0) ? null : new SimmMeasurement(cPtr, false);
  }

  public int searchBinary(SimmMeasurement aObject, boolean aFindFirst, int aLo, int aHi) {
    return opensimModelJNI.SetSimmMeasurements_searchBinary__SWIG_0(swigCPtr, SimmMeasurement.getCPtr(aObject), aFindFirst, aLo, aHi);
  }

  public int searchBinary(SimmMeasurement aObject, boolean aFindFirst, int aLo) {
    return opensimModelJNI.SetSimmMeasurements_searchBinary__SWIG_1(swigCPtr, SimmMeasurement.getCPtr(aObject), aFindFirst, aLo);
  }

  public int searchBinary(SimmMeasurement aObject, boolean aFindFirst) {
    return opensimModelJNI.SetSimmMeasurements_searchBinary__SWIG_2(swigCPtr, SimmMeasurement.getCPtr(aObject), aFindFirst);
  }

  public int searchBinary(SimmMeasurement aObject) {
    return opensimModelJNI.SetSimmMeasurements_searchBinary__SWIG_3(swigCPtr, SimmMeasurement.getCPtr(aObject));
  }

}
