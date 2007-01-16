/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.29
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

  public void delete() {
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

  public SetCoordinates(SWIGTYPE_p_DOMElement aElement) {
    this(opensimModelJNI.new_SetCoordinates__SWIG_2(SWIGTYPE_p_DOMElement.getCPtr(aElement)), true);
  }

  public SetCoordinates(SetCoordinates aSet) {
    this(opensimModelJNI.new_SetCoordinates__SWIG_3(SetCoordinates.getCPtr(aSet)), true);
  }

  public OpenSimObject copy() {
    long cPtr = opensimModelJNI.SetCoordinates_copy(swigCPtr);
    return (cPtr == 0) ? null : new OpenSimObject(cPtr, false);
  }

  public void setMemoryOwner(boolean aTrueFalse) {
    opensimModelJNI.SetCoordinates_setMemoryOwner(swigCPtr, aTrueFalse);
  }

  public boolean getMemoryOwner() {
    return opensimModelJNI.SetCoordinates_getMemoryOwner(swigCPtr);
  }

  public boolean computeNewCapacity(int aMinCapacity, SWIGTYPE_p_int rNewCapacity) {
    return opensimModelJNI.SetCoordinates_computeNewCapacity(swigCPtr, aMinCapacity, SWIGTYPE_p_int.getCPtr(rNewCapacity));
  }

  public boolean ensureCapacity(int aCapacity) {
    return opensimModelJNI.SetCoordinates_ensureCapacity(swigCPtr, aCapacity);
  }

  public void trim() {
    opensimModelJNI.SetCoordinates_trim(swigCPtr);
  }

  public int getCapacity() {
    return opensimModelJNI.SetCoordinates_getCapacity(swigCPtr);
  }

  public void setCapacityIncrement(int aIncrement) {
    opensimModelJNI.SetCoordinates_setCapacityIncrement(swigCPtr, aIncrement);
  }

  public int getCapacityIncrement() {
    return opensimModelJNI.SetCoordinates_getCapacityIncrement(swigCPtr);
  }

  public boolean setSize(int aSize) {
    return opensimModelJNI.SetCoordinates_setSize(swigCPtr, aSize);
  }

  public int getSize() {
    return opensimModelJNI.SetCoordinates_getSize(swigCPtr);
  }

  public int getIndex(AbstractCoordinate aObject, int aStartIndex) {
    return opensimModelJNI.SetCoordinates_getIndex__SWIG_0(swigCPtr, AbstractCoordinate.getCPtr(aObject), aStartIndex);
  }

  public int getIndex(AbstractCoordinate aObject) {
    return opensimModelJNI.SetCoordinates_getIndex__SWIG_1(swigCPtr, AbstractCoordinate.getCPtr(aObject));
  }

  public int getIndex(String aName, int aStartIndex) {
    return opensimModelJNI.SetCoordinates_getIndex__SWIG_2(swigCPtr, aName, aStartIndex);
  }

  public int getIndex(String aName) {
    return opensimModelJNI.SetCoordinates_getIndex__SWIG_3(swigCPtr, aName);
  }

  public boolean append(AbstractCoordinate aObject) {
    return opensimModelJNI.SetCoordinates_append__SWIG_0(swigCPtr, AbstractCoordinate.getCPtr(aObject));
  }

  public boolean append(SWIGTYPE_p_OpenSim__ArrayPtrsTOpenSim__AbstractCoordinate_t aArray) {
    return opensimModelJNI.SetCoordinates_append__SWIG_1(swigCPtr, SWIGTYPE_p_OpenSim__ArrayPtrsTOpenSim__AbstractCoordinate_t.getCPtr(aArray));
  }

  public boolean insert(int aIndex, AbstractCoordinate aObject) {
    return opensimModelJNI.SetCoordinates_insert(swigCPtr, aIndex, AbstractCoordinate.getCPtr(aObject));
  }

  public boolean remove(int aIndex) {
    return opensimModelJNI.SetCoordinates_remove__SWIG_0(swigCPtr, aIndex);
  }

  public boolean remove(AbstractCoordinate aObject) {
    return opensimModelJNI.SetCoordinates_remove__SWIG_1(swigCPtr, AbstractCoordinate.getCPtr(aObject));
  }

  public void clearAndDestroy() {
    opensimModelJNI.SetCoordinates_clearAndDestroy(swigCPtr);
  }

  public boolean set(int aIndex, AbstractCoordinate aObject) {
    return opensimModelJNI.SetCoordinates_set(swigCPtr, aIndex, AbstractCoordinate.getCPtr(aObject));
  }

  public AbstractCoordinate get(int aIndex) {
    long cPtr = opensimModelJNI.SetCoordinates_get__SWIG_0(swigCPtr, aIndex);
    return (cPtr == 0) ? null : new AbstractCoordinate(cPtr, false);
  }

  public AbstractCoordinate get(String aName) {
    long cPtr = opensimModelJNI.SetCoordinates_get__SWIG_1(swigCPtr, aName);
    return (cPtr == 0) ? null : new AbstractCoordinate(cPtr, false);
  }

  public void getNames(ArrayStr rNames) {
    opensimModelJNI.SetCoordinates_getNames(swigCPtr, ArrayStr.getCPtr(rNames));
  }

  public AbstractCoordinate getLast() {
    long cPtr = opensimModelJNI.SetCoordinates_getLast(swigCPtr);
    return (cPtr == 0) ? null : new AbstractCoordinate(cPtr, false);
  }

  public int searchBinary(AbstractCoordinate aObject, boolean aFindFirst, int aLo, int aHi) {
    return opensimModelJNI.SetCoordinates_searchBinary__SWIG_0(swigCPtr, AbstractCoordinate.getCPtr(aObject), aFindFirst, aLo, aHi);
  }

  public int searchBinary(AbstractCoordinate aObject, boolean aFindFirst, int aLo) {
    return opensimModelJNI.SetCoordinates_searchBinary__SWIG_1(swigCPtr, AbstractCoordinate.getCPtr(aObject), aFindFirst, aLo);
  }

  public int searchBinary(AbstractCoordinate aObject, boolean aFindFirst) {
    return opensimModelJNI.SetCoordinates_searchBinary__SWIG_2(swigCPtr, AbstractCoordinate.getCPtr(aObject), aFindFirst);
  }

  public int searchBinary(AbstractCoordinate aObject) {
    return opensimModelJNI.SetCoordinates_searchBinary__SWIG_3(swigCPtr, AbstractCoordinate.getCPtr(aObject));
  }

}
