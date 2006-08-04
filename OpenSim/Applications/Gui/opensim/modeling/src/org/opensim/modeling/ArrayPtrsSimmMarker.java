/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.29
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.opensim.modeling;

public class ArrayPtrsSimmMarker {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected ArrayPtrsSimmMarker(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(ArrayPtrsSimmMarker obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public void delete() {
    if(swigCPtr != 0 && swigCMemOwn) {
      swigCMemOwn = false;
      opensimModelJNI.delete_ArrayPtrsSimmMarker(swigCPtr);
    }
    swigCPtr = 0;
  }

  public ArrayPtrsSimmMarker(int aCapacity) {
    this(opensimModelJNI.new_ArrayPtrsSimmMarker__SWIG_0(aCapacity), true);
  }

  public ArrayPtrsSimmMarker() {
    this(opensimModelJNI.new_ArrayPtrsSimmMarker__SWIG_1(), true);
  }

  public ArrayPtrsSimmMarker(ArrayPtrsSimmMarker aArray) {
    this(opensimModelJNI.new_ArrayPtrsSimmMarker__SWIG_2(ArrayPtrsSimmMarker.getCPtr(aArray)), true);
  }

  public void clearAndDestroy() {
    opensimModelJNI.ArrayPtrsSimmMarker_clearAndDestroy(swigCPtr);
  }

  public void setMemoryOwner(boolean aTrueFalse) {
    opensimModelJNI.ArrayPtrsSimmMarker_setMemoryOwner(swigCPtr, aTrueFalse);
  }

  public boolean getMemoryOwner() {
    return opensimModelJNI.ArrayPtrsSimmMarker_getMemoryOwner(swigCPtr);
  }

  public boolean computeNewCapacity(int aMinCapacity, SWIGTYPE_p_int rNewCapacity) {
    return opensimModelJNI.ArrayPtrsSimmMarker_computeNewCapacity(swigCPtr, aMinCapacity, SWIGTYPE_p_int.getCPtr(rNewCapacity));
  }

  public boolean ensureCapacity(int aCapacity) {
    return opensimModelJNI.ArrayPtrsSimmMarker_ensureCapacity(swigCPtr, aCapacity);
  }

  public void trim() {
    opensimModelJNI.ArrayPtrsSimmMarker_trim(swigCPtr);
  }

  public int getCapacity() {
    return opensimModelJNI.ArrayPtrsSimmMarker_getCapacity(swigCPtr);
  }

  public void setCapacityIncrement(int aIncrement) {
    opensimModelJNI.ArrayPtrsSimmMarker_setCapacityIncrement(swigCPtr, aIncrement);
  }

  public int getCapacityIncrement() {
    return opensimModelJNI.ArrayPtrsSimmMarker_getCapacityIncrement(swigCPtr);
  }

  public boolean setSize(int aSize) {
    return opensimModelJNI.ArrayPtrsSimmMarker_setSize(swigCPtr, aSize);
  }

  public int getSize() {
    return opensimModelJNI.ArrayPtrsSimmMarker_getSize(swigCPtr);
  }

  public int getIndex(SimmMarker aObject, int aStartIndex) {
    return opensimModelJNI.ArrayPtrsSimmMarker_getIndex__SWIG_0(swigCPtr, SimmMarker.getCPtr(aObject), aStartIndex);
  }

  public int getIndex(SimmMarker aObject) {
    return opensimModelJNI.ArrayPtrsSimmMarker_getIndex__SWIG_1(swigCPtr, SimmMarker.getCPtr(aObject));
  }

  public int getIndex(String aName, int aStartIndex) {
    return opensimModelJNI.ArrayPtrsSimmMarker_getIndex__SWIG_2(swigCPtr, aName, aStartIndex);
  }

  public int getIndex(String aName) {
    return opensimModelJNI.ArrayPtrsSimmMarker_getIndex__SWIG_3(swigCPtr, aName);
  }

  public boolean append(SimmMarker aObject) {
    return opensimModelJNI.ArrayPtrsSimmMarker_append__SWIG_0(swigCPtr, SimmMarker.getCPtr(aObject));
  }

  public boolean append(ArrayPtrsSimmMarker aArray) {
    return opensimModelJNI.ArrayPtrsSimmMarker_append__SWIG_1(swigCPtr, ArrayPtrsSimmMarker.getCPtr(aArray));
  }

  public boolean insert(int aIndex, SimmMarker aObject) {
    return opensimModelJNI.ArrayPtrsSimmMarker_insert(swigCPtr, aIndex, SimmMarker.getCPtr(aObject));
  }

  public boolean remove(int aIndex) {
    return opensimModelJNI.ArrayPtrsSimmMarker_remove__SWIG_0(swigCPtr, aIndex);
  }

  public boolean remove(SimmMarker aObject) {
    return opensimModelJNI.ArrayPtrsSimmMarker_remove__SWIG_1(swigCPtr, SimmMarker.getCPtr(aObject));
  }

  public boolean set(int aIndex, SimmMarker aObject) {
    return opensimModelJNI.ArrayPtrsSimmMarker_set(swigCPtr, aIndex, SimmMarker.getCPtr(aObject));
  }

  public SimmMarker get(int aIndex) {
    long cPtr = opensimModelJNI.ArrayPtrsSimmMarker_get__SWIG_0(swigCPtr, aIndex);
    return (cPtr == 0) ? null : new SimmMarker(cPtr, false);
  }

  public SimmMarker get(String aName) {
    long cPtr = opensimModelJNI.ArrayPtrsSimmMarker_get__SWIG_1(swigCPtr, aName);
    return (cPtr == 0) ? null : new SimmMarker(cPtr, false);
  }

  public SimmMarker getLast() {
    long cPtr = opensimModelJNI.ArrayPtrsSimmMarker_getLast(swigCPtr);
    return (cPtr == 0) ? null : new SimmMarker(cPtr, false);
  }

  public int searchBinary(SimmMarker aObject, boolean aFindFirst, int aLo, int aHi) {
    return opensimModelJNI.ArrayPtrsSimmMarker_searchBinary__SWIG_0(swigCPtr, SimmMarker.getCPtr(aObject), aFindFirst, aLo, aHi);
  }

  public int searchBinary(SimmMarker aObject, boolean aFindFirst, int aLo) {
    return opensimModelJNI.ArrayPtrsSimmMarker_searchBinary__SWIG_1(swigCPtr, SimmMarker.getCPtr(aObject), aFindFirst, aLo);
  }

  public int searchBinary(SimmMarker aObject, boolean aFindFirst) {
    return opensimModelJNI.ArrayPtrsSimmMarker_searchBinary__SWIG_2(swigCPtr, SimmMarker.getCPtr(aObject), aFindFirst);
  }

  public int searchBinary(SimmMarker aObject) {
    return opensimModelJNI.ArrayPtrsSimmMarker_searchBinary__SWIG_3(swigCPtr, SimmMarker.getCPtr(aObject));
  }

}
