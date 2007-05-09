/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.31
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.opensim.modeling;

public class SetMeasurements extends OpenSimObject {
  private long swigCPtr;

  public SetMeasurements(long cPtr, boolean cMemoryOwn) {
    super(opensimModelJNI.SWIGStorageUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  public static long getCPtr(SetMeasurements obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if(swigCPtr != 0 && swigCMemOwn) {
      swigCMemOwn = false;
      opensimModelJNI.delete_SetMeasurements(swigCPtr);
    }
    swigCPtr = 0;
    super.delete();
  }

  public SetMeasurements() {
    this(opensimModelJNI.new_SetMeasurements__SWIG_0(), true);
  }

  public SetMeasurements(String aFileName, boolean aUpdateFromXMLNode) {
    this(opensimModelJNI.new_SetMeasurements__SWIG_1(aFileName, aUpdateFromXMLNode), true);
  }

  public SetMeasurements(String aFileName) {
    this(opensimModelJNI.new_SetMeasurements__SWIG_2(aFileName), true);
  }

  public SetMeasurements(SetMeasurements aSet) {
    this(opensimModelJNI.new_SetMeasurements__SWIG_3(SetMeasurements.getCPtr(aSet), aSet), true);
  }

  public OpenSimObject copy() {
    long cPtr = opensimModelJNI.SetMeasurements_copy(swigCPtr, this);
    return (cPtr == 0) ? null : new OpenSimObject(cPtr, false);
  }

  public void setup() {
    opensimModelJNI.SetMeasurements_setup(swigCPtr, this);
  }

  public void setMemoryOwner(boolean aTrueFalse) {
    opensimModelJNI.SetMeasurements_setMemoryOwner(swigCPtr, this, aTrueFalse);
  }

  public boolean getMemoryOwner() {
    return opensimModelJNI.SetMeasurements_getMemoryOwner(swigCPtr, this);
  }

  public boolean computeNewCapacity(int aMinCapacity, SWIGTYPE_p_int rNewCapacity) {
    return opensimModelJNI.SetMeasurements_computeNewCapacity(swigCPtr, this, aMinCapacity, SWIGTYPE_p_int.getCPtr(rNewCapacity));
  }

  public boolean ensureCapacity(int aCapacity) {
    return opensimModelJNI.SetMeasurements_ensureCapacity(swigCPtr, this, aCapacity);
  }

  public void trim() {
    opensimModelJNI.SetMeasurements_trim(swigCPtr, this);
  }

  public int getCapacity() {
    return opensimModelJNI.SetMeasurements_getCapacity(swigCPtr, this);
  }

  public void setCapacityIncrement(int aIncrement) {
    opensimModelJNI.SetMeasurements_setCapacityIncrement(swigCPtr, this, aIncrement);
  }

  public int getCapacityIncrement() {
    return opensimModelJNI.SetMeasurements_getCapacityIncrement(swigCPtr, this);
  }

  public boolean setSize(int aSize) {
    return opensimModelJNI.SetMeasurements_setSize(swigCPtr, this, aSize);
  }

  public int getSize() {
    return opensimModelJNI.SetMeasurements_getSize(swigCPtr, this);
  }

  public int getIndex(Measurement aObject, int aStartIndex) {
    return opensimModelJNI.SetMeasurements_getIndex__SWIG_0(swigCPtr, this, Measurement.getCPtr(aObject), aObject, aStartIndex);
  }

  public int getIndex(Measurement aObject) {
    return opensimModelJNI.SetMeasurements_getIndex__SWIG_1(swigCPtr, this, Measurement.getCPtr(aObject), aObject);
  }

  public int getIndex(String aName, int aStartIndex) {
    return opensimModelJNI.SetMeasurements_getIndex__SWIG_2(swigCPtr, this, aName, aStartIndex);
  }

  public int getIndex(String aName) {
    return opensimModelJNI.SetMeasurements_getIndex__SWIG_3(swigCPtr, this, aName);
  }

  public void getGroupNamesContaining(String aObjectName, ArrayStr rGroupNames) {
    opensimModelJNI.SetMeasurements_getGroupNamesContaining(swigCPtr, this, aObjectName, ArrayStr.getCPtr(rGroupNames), rGroupNames);
  }

  public boolean append(Measurement aObject) {
    return opensimModelJNI.SetMeasurements_append__SWIG_0(swigCPtr, this, Measurement.getCPtr(aObject), aObject);
  }

  public boolean append(SWIGTYPE_p_OpenSim__ArrayPtrsTOpenSim__Measurement_t aArray) {
    return opensimModelJNI.SetMeasurements_append__SWIG_1(swigCPtr, this, SWIGTYPE_p_OpenSim__ArrayPtrsTOpenSim__Measurement_t.getCPtr(aArray));
  }

  public boolean insert(int aIndex, Measurement aObject) {
    return opensimModelJNI.SetMeasurements_insert(swigCPtr, this, aIndex, Measurement.getCPtr(aObject), aObject);
  }

  public boolean remove(int aIndex) {
    return opensimModelJNI.SetMeasurements_remove__SWIG_0(swigCPtr, this, aIndex);
  }

  public boolean remove(Measurement aObject) {
    return opensimModelJNI.SetMeasurements_remove__SWIG_1(swigCPtr, this, Measurement.getCPtr(aObject), aObject);
  }

  public void clearAndDestroy() {
    opensimModelJNI.SetMeasurements_clearAndDestroy(swigCPtr, this);
  }

  public boolean set(int aIndex, Measurement aObject) {
    return opensimModelJNI.SetMeasurements_set(swigCPtr, this, aIndex, Measurement.getCPtr(aObject), aObject);
  }

  public Measurement get(int aIndex) {
    long cPtr = opensimModelJNI.SetMeasurements_get__SWIG_0(swigCPtr, this, aIndex);
    return (cPtr == 0) ? null : new Measurement(cPtr, false);
  }

  public Measurement get(String aName) {
    long cPtr = opensimModelJNI.SetMeasurements_get__SWIG_1(swigCPtr, this, aName);
    return (cPtr == 0) ? null : new Measurement(cPtr, false);
  }

  public void getNames(ArrayStr rNames) {
    opensimModelJNI.SetMeasurements_getNames(swigCPtr, this, ArrayStr.getCPtr(rNames), rNames);
  }

  public Measurement getLast() {
    long cPtr = opensimModelJNI.SetMeasurements_getLast(swigCPtr, this);
    return (cPtr == 0) ? null : new Measurement(cPtr, false);
  }

  public int searchBinary(Measurement aObject, boolean aFindFirst, int aLo, int aHi) {
    return opensimModelJNI.SetMeasurements_searchBinary__SWIG_0(swigCPtr, this, Measurement.getCPtr(aObject), aObject, aFindFirst, aLo, aHi);
  }

  public int searchBinary(Measurement aObject, boolean aFindFirst, int aLo) {
    return opensimModelJNI.SetMeasurements_searchBinary__SWIG_1(swigCPtr, this, Measurement.getCPtr(aObject), aObject, aFindFirst, aLo);
  }

  public int searchBinary(Measurement aObject, boolean aFindFirst) {
    return opensimModelJNI.SetMeasurements_searchBinary__SWIG_2(swigCPtr, this, Measurement.getCPtr(aObject), aObject, aFindFirst);
  }

  public int searchBinary(Measurement aObject) {
    return opensimModelJNI.SetMeasurements_searchBinary__SWIG_3(swigCPtr, this, Measurement.getCPtr(aObject), aObject);
  }

  public void addGroup(SWIGTYPE_p_std__string aGroupName) {
    opensimModelJNI.SetMeasurements_addGroup(swigCPtr, this, SWIGTYPE_p_std__string.getCPtr(aGroupName));
  }

  public void addObjectToGroup(SWIGTYPE_p_std__string aGroupName, SWIGTYPE_p_std__string aObjectName) {
    opensimModelJNI.SetMeasurements_addObjectToGroup(swigCPtr, this, SWIGTYPE_p_std__string.getCPtr(aGroupName), SWIGTYPE_p_std__string.getCPtr(aObjectName));
  }

}
