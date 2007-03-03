/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.31
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.opensim.modeling;

public class SetCoordinates extends OpenSimObject {
  private long swigCPtr;

  public SetCoordinates(long cPtr, boolean cMemoryOwn) {
    super(opensimModelJNI.SWIGStorageUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  public static long getCPtr(SetCoordinates obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if(swigCPtr != 0 && swigCMemOwn) {
      swigCMemOwn = false;
      opensimModelJNI.delete_SetCoordinates(swigCPtr);
    }
    swigCPtr = 0;
    super.delete();
  }

  public SetCoordinates() {
    this(opensimModelJNI.new_SetCoordinates__SWIG_0(), true);
  }

  public SetCoordinates(String aFileName) {
    this(opensimModelJNI.new_SetCoordinates__SWIG_1(aFileName), true);
  }

  public SetCoordinates(SetCoordinates aSet) {
    this(opensimModelJNI.new_SetCoordinates__SWIG_2(SetCoordinates.getCPtr(aSet), aSet), true);
  }

  public OpenSimObject copy() {
    long cPtr = opensimModelJNI.SetCoordinates_copy(swigCPtr, this);
    return (cPtr == 0) ? null : new OpenSimObject(cPtr, false);
  }

  public void setMemoryOwner(boolean aTrueFalse) {
    opensimModelJNI.SetCoordinates_setMemoryOwner(swigCPtr, this, aTrueFalse);
  }

  public boolean getMemoryOwner() {
    return opensimModelJNI.SetCoordinates_getMemoryOwner(swigCPtr, this);
  }

  public boolean computeNewCapacity(int aMinCapacity, SWIGTYPE_p_int rNewCapacity) {
    return opensimModelJNI.SetCoordinates_computeNewCapacity(swigCPtr, this, aMinCapacity, SWIGTYPE_p_int.getCPtr(rNewCapacity));
  }

  public boolean ensureCapacity(int aCapacity) {
    return opensimModelJNI.SetCoordinates_ensureCapacity(swigCPtr, this, aCapacity);
  }

  public void trim() {
    opensimModelJNI.SetCoordinates_trim(swigCPtr, this);
  }

  public int getCapacity() {
    return opensimModelJNI.SetCoordinates_getCapacity(swigCPtr, this);
  }

  public void setCapacityIncrement(int aIncrement) {
    opensimModelJNI.SetCoordinates_setCapacityIncrement(swigCPtr, this, aIncrement);
  }

  public int getCapacityIncrement() {
    return opensimModelJNI.SetCoordinates_getCapacityIncrement(swigCPtr, this);
  }

  public boolean setSize(int aSize) {
    return opensimModelJNI.SetCoordinates_setSize(swigCPtr, this, aSize);
  }

  public int getSize() {
    return opensimModelJNI.SetCoordinates_getSize(swigCPtr, this);
  }

  public int getIndex(AbstractCoordinate aObject, int aStartIndex) {
    return opensimModelJNI.SetCoordinates_getIndex__SWIG_0(swigCPtr, this, AbstractCoordinate.getCPtr(aObject), aObject, aStartIndex);
  }

  public int getIndex(AbstractCoordinate aObject) {
    return opensimModelJNI.SetCoordinates_getIndex__SWIG_1(swigCPtr, this, AbstractCoordinate.getCPtr(aObject), aObject);
  }

  public int getIndex(String aName, int aStartIndex) {
    return opensimModelJNI.SetCoordinates_getIndex__SWIG_2(swigCPtr, this, aName, aStartIndex);
  }

  public int getIndex(String aName) {
    return opensimModelJNI.SetCoordinates_getIndex__SWIG_3(swigCPtr, this, aName);
  }

  public boolean append(AbstractCoordinate aObject) {
    return opensimModelJNI.SetCoordinates_append__SWIG_0(swigCPtr, this, AbstractCoordinate.getCPtr(aObject), aObject);
  }

  public boolean append(SWIGTYPE_p_OpenSim__ArrayPtrsTOpenSim__AbstractCoordinate_t aArray) {
    return opensimModelJNI.SetCoordinates_append__SWIG_1(swigCPtr, this, SWIGTYPE_p_OpenSim__ArrayPtrsTOpenSim__AbstractCoordinate_t.getCPtr(aArray));
  }

  public boolean insert(int aIndex, AbstractCoordinate aObject) {
    return opensimModelJNI.SetCoordinates_insert(swigCPtr, this, aIndex, AbstractCoordinate.getCPtr(aObject), aObject);
  }

  public boolean remove(int aIndex) {
    return opensimModelJNI.SetCoordinates_remove__SWIG_0(swigCPtr, this, aIndex);
  }

  public boolean remove(AbstractCoordinate aObject) {
    return opensimModelJNI.SetCoordinates_remove__SWIG_1(swigCPtr, this, AbstractCoordinate.getCPtr(aObject), aObject);
  }

  public void clearAndDestroy() {
    opensimModelJNI.SetCoordinates_clearAndDestroy(swigCPtr, this);
  }

  public boolean set(int aIndex, AbstractCoordinate aObject) {
    return opensimModelJNI.SetCoordinates_set(swigCPtr, this, aIndex, AbstractCoordinate.getCPtr(aObject), aObject);
  }

  public AbstractCoordinate get(int aIndex) {
    long cPtr = opensimModelJNI.SetCoordinates_get__SWIG_0(swigCPtr, this, aIndex);
    return (cPtr == 0) ? null : new AbstractCoordinate(cPtr, false);
  }

  public AbstractCoordinate get(String aName) {
    long cPtr = opensimModelJNI.SetCoordinates_get__SWIG_1(swigCPtr, this, aName);
    return (cPtr == 0) ? null : new AbstractCoordinate(cPtr, false);
  }

  public void getNames(ArrayStr rNames) {
    opensimModelJNI.SetCoordinates_getNames(swigCPtr, this, ArrayStr.getCPtr(rNames), rNames);
  }

  public AbstractCoordinate getLast() {
    long cPtr = opensimModelJNI.SetCoordinates_getLast(swigCPtr, this);
    return (cPtr == 0) ? null : new AbstractCoordinate(cPtr, false);
  }

  public int searchBinary(AbstractCoordinate aObject, boolean aFindFirst, int aLo, int aHi) {
    return opensimModelJNI.SetCoordinates_searchBinary__SWIG_0(swigCPtr, this, AbstractCoordinate.getCPtr(aObject), aObject, aFindFirst, aLo, aHi);
  }

  public int searchBinary(AbstractCoordinate aObject, boolean aFindFirst, int aLo) {
    return opensimModelJNI.SetCoordinates_searchBinary__SWIG_1(swigCPtr, this, AbstractCoordinate.getCPtr(aObject), aObject, aFindFirst, aLo);
  }

  public int searchBinary(AbstractCoordinate aObject, boolean aFindFirst) {
    return opensimModelJNI.SetCoordinates_searchBinary__SWIG_2(swigCPtr, this, AbstractCoordinate.getCPtr(aObject), aObject, aFindFirst);
  }

  public int searchBinary(AbstractCoordinate aObject) {
    return opensimModelJNI.SetCoordinates_searchBinary__SWIG_3(swigCPtr, this, AbstractCoordinate.getCPtr(aObject), aObject);
  }

}
