/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.37
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.opensim.modeling;

public class ArrayStorage {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  public ArrayStorage(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  public static long getCPtr(ArrayStorage obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if(swigCPtr != 0 && swigCMemOwn) {
      swigCMemOwn = false;
      opensimModelJNI.delete_ArrayStorage(swigCPtr);
    }
    swigCPtr = 0;
  }

  public ArrayStorage(int aCapacity) {
    this(opensimModelJNI.new_ArrayStorage__SWIG_0(aCapacity), true);
  }

  public ArrayStorage() {
    this(opensimModelJNI.new_ArrayStorage__SWIG_1(), true);
  }

  public ArrayStorage(ArrayStorage aArray) {
    this(opensimModelJNI.new_ArrayStorage__SWIG_2(ArrayStorage.getCPtr(aArray), aArray), true);
  }

  public void clearAndDestroy() {
    opensimModelJNI.ArrayStorage_clearAndDestroy(swigCPtr, this);
  }

  public void setMemoryOwner(boolean aTrueFalse) {
    opensimModelJNI.ArrayStorage_setMemoryOwner(swigCPtr, this, aTrueFalse);
  }

  public boolean getMemoryOwner() {
    return opensimModelJNI.ArrayStorage_getMemoryOwner(swigCPtr, this);
  }

  public boolean computeNewCapacity(int aMinCapacity, SWIGTYPE_p_int rNewCapacity) {
    return opensimModelJNI.ArrayStorage_computeNewCapacity(swigCPtr, this, aMinCapacity, SWIGTYPE_p_int.getCPtr(rNewCapacity));
  }

  public boolean ensureCapacity(int aCapacity) {
    return opensimModelJNI.ArrayStorage_ensureCapacity(swigCPtr, this, aCapacity);
  }

  public void trim() {
    opensimModelJNI.ArrayStorage_trim(swigCPtr, this);
  }

  public int getCapacity() {
    return opensimModelJNI.ArrayStorage_getCapacity(swigCPtr, this);
  }

  public void setCapacityIncrement(int aIncrement) {
    opensimModelJNI.ArrayStorage_setCapacityIncrement(swigCPtr, this, aIncrement);
  }

  public int getCapacityIncrement() {
    return opensimModelJNI.ArrayStorage_getCapacityIncrement(swigCPtr, this);
  }

  public boolean setSize(int aSize) {
    return opensimModelJNI.ArrayStorage_setSize(swigCPtr, this, aSize);
  }

  public int getSize() {
    return opensimModelJNI.ArrayStorage_getSize(swigCPtr, this);
  }

  public int getIndex(Storage aObject, int aStartIndex) {
    return opensimModelJNI.ArrayStorage_getIndex__SWIG_0(swigCPtr, this, Storage.getCPtr(aObject), aObject, aStartIndex);
  }

  public int getIndex(Storage aObject) {
    return opensimModelJNI.ArrayStorage_getIndex__SWIG_1(swigCPtr, this, Storage.getCPtr(aObject), aObject);
  }

  public int getIndex(String aName, int aStartIndex) {
    return opensimModelJNI.ArrayStorage_getIndex__SWIG_2(swigCPtr, this, aName, aStartIndex);
  }

  public int getIndex(String aName) {
    return opensimModelJNI.ArrayStorage_getIndex__SWIG_3(swigCPtr, this, aName);
  }

  public boolean append(Storage aObject) {
    return opensimModelJNI.ArrayStorage_append__SWIG_0(swigCPtr, this, Storage.getCPtr(aObject), aObject);
  }

  public boolean append(ArrayStorage aArray) {
    return opensimModelJNI.ArrayStorage_append__SWIG_1(swigCPtr, this, ArrayStorage.getCPtr(aArray), aArray);
  }

  public boolean insert(int aIndex, Storage aObject) {
    return opensimModelJNI.ArrayStorage_insert(swigCPtr, this, aIndex, Storage.getCPtr(aObject), aObject);
  }

  public boolean remove(int aIndex) {
    return opensimModelJNI.ArrayStorage_remove__SWIG_0(swigCPtr, this, aIndex);
  }

  public boolean remove(Storage aObject) {
    return opensimModelJNI.ArrayStorage_remove__SWIG_1(swigCPtr, this, Storage.getCPtr(aObject), aObject);
  }

  public boolean set(int aIndex, Storage aObject) {
    return opensimModelJNI.ArrayStorage_set(swigCPtr, this, aIndex, Storage.getCPtr(aObject), aObject);
  }

  public Storage get(int aIndex) {
    long cPtr = opensimModelJNI.ArrayStorage_get__SWIG_0(swigCPtr, this, aIndex);
    return (cPtr == 0) ? null : new Storage(cPtr, false);
  }

  public Storage get(String aName) {
    long cPtr = opensimModelJNI.ArrayStorage_get__SWIG_1(swigCPtr, this, aName);
    return (cPtr == 0) ? null : new Storage(cPtr, false);
  }

  public Storage getLast() {
    long cPtr = opensimModelJNI.ArrayStorage_getLast(swigCPtr, this);
    return (cPtr == 0) ? null : new Storage(cPtr, false);
  }

  public int searchBinary(Storage aObject, boolean aFindFirst, int aLo, int aHi) {
    return opensimModelJNI.ArrayStorage_searchBinary__SWIG_0(swigCPtr, this, Storage.getCPtr(aObject), aObject, aFindFirst, aLo, aHi);
  }

  public int searchBinary(Storage aObject, boolean aFindFirst, int aLo) {
    return opensimModelJNI.ArrayStorage_searchBinary__SWIG_1(swigCPtr, this, Storage.getCPtr(aObject), aObject, aFindFirst, aLo);
  }

  public int searchBinary(Storage aObject, boolean aFindFirst) {
    return opensimModelJNI.ArrayStorage_searchBinary__SWIG_2(swigCPtr, this, Storage.getCPtr(aObject), aObject, aFindFirst);
  }

  public int searchBinary(Storage aObject) {
    return opensimModelJNI.ArrayStorage_searchBinary__SWIG_3(swigCPtr, this, Storage.getCPtr(aObject), aObject);
  }

}
