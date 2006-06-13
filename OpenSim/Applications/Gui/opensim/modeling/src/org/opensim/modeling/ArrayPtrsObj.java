/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.29
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.opensim.modeling;

public class ArrayPtrsObj {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected ArrayPtrsObj(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(ArrayPtrsObj obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public void delete() {
    if(swigCPtr != 0 && swigCMemOwn) {
      swigCMemOwn = false;
      opensimModelJNI.delete_ArrayPtrsObj(swigCPtr);
    }
    swigCPtr = 0;
  }

  public ArrayPtrsObj(int aCapacity) {
    this(opensimModelJNI.new_ArrayPtrsObj__SWIG_0(aCapacity), true);
  }

  public ArrayPtrsObj() {
    this(opensimModelJNI.new_ArrayPtrsObj__SWIG_1(), true);
  }

  public ArrayPtrsObj(ArrayPtrsObj aArray) {
    this(opensimModelJNI.new_ArrayPtrsObj__SWIG_2(ArrayPtrsObj.getCPtr(aArray)), true);
  }

  public void clearAndDestroy() {
    opensimModelJNI.ArrayPtrsObj_clearAndDestroy(swigCPtr);
  }

  public void setMemoryOwner(boolean aTrueFalse) {
    opensimModelJNI.ArrayPtrsObj_setMemoryOwner(swigCPtr, aTrueFalse);
  }

  public boolean getMemoryOwner() {
    return opensimModelJNI.ArrayPtrsObj_getMemoryOwner(swigCPtr);
  }

  public boolean computeNewCapacity(int aMinCapacity, SWIGTYPE_p_int rNewCapacity) {
    return opensimModelJNI.ArrayPtrsObj_computeNewCapacity(swigCPtr, aMinCapacity, SWIGTYPE_p_int.getCPtr(rNewCapacity));
  }

  public boolean ensureCapacity(int aCapacity) {
    return opensimModelJNI.ArrayPtrsObj_ensureCapacity(swigCPtr, aCapacity);
  }

  public void trim() {
    opensimModelJNI.ArrayPtrsObj_trim(swigCPtr);
  }

  public int getCapacity() {
    return opensimModelJNI.ArrayPtrsObj_getCapacity(swigCPtr);
  }

  public void setCapacityIncrement(int aIncrement) {
    opensimModelJNI.ArrayPtrsObj_setCapacityIncrement(swigCPtr, aIncrement);
  }

  public int getCapacityIncrement() {
    return opensimModelJNI.ArrayPtrsObj_getCapacityIncrement(swigCPtr);
  }

  public boolean setSize(int aSize) {
    return opensimModelJNI.ArrayPtrsObj_setSize(swigCPtr, aSize);
  }

  public int getSize() {
    return opensimModelJNI.ArrayPtrsObj_getSize(swigCPtr);
  }

  public int getIndex(OpenSimObject aObject, int aStartIndex) {
    return opensimModelJNI.ArrayPtrsObj_getIndex__SWIG_0(swigCPtr, OpenSimObject.getCPtr(aObject), aStartIndex);
  }

  public int getIndex(OpenSimObject aObject) {
    return opensimModelJNI.ArrayPtrsObj_getIndex__SWIG_1(swigCPtr, OpenSimObject.getCPtr(aObject));
  }

  public int getIndex(String aName, int aStartIndex) {
    return opensimModelJNI.ArrayPtrsObj_getIndex__SWIG_2(swigCPtr, aName, aStartIndex);
  }

  public int getIndex(String aName) {
    return opensimModelJNI.ArrayPtrsObj_getIndex__SWIG_3(swigCPtr, aName);
  }

  public boolean append(OpenSimObject aObject) {
    return opensimModelJNI.ArrayPtrsObj_append__SWIG_0(swigCPtr, OpenSimObject.getCPtr(aObject));
  }

  public boolean append(ArrayPtrsObj aArray) {
    return opensimModelJNI.ArrayPtrsObj_append__SWIG_1(swigCPtr, ArrayPtrsObj.getCPtr(aArray));
  }

  public boolean insert(int aIndex, OpenSimObject aObject) {
    return opensimModelJNI.ArrayPtrsObj_insert(swigCPtr, aIndex, OpenSimObject.getCPtr(aObject));
  }

  public boolean remove(int aIndex) {
    return opensimModelJNI.ArrayPtrsObj_remove__SWIG_0(swigCPtr, aIndex);
  }

  public boolean remove(OpenSimObject aObject) {
    return opensimModelJNI.ArrayPtrsObj_remove__SWIG_1(swigCPtr, OpenSimObject.getCPtr(aObject));
  }

  public boolean set(int aIndex, OpenSimObject aObject) {
    return opensimModelJNI.ArrayPtrsObj_set(swigCPtr, aIndex, OpenSimObject.getCPtr(aObject));
  }

  public OpenSimObject get(int aIndex) {
    long cPtr = opensimModelJNI.ArrayPtrsObj_get__SWIG_0(swigCPtr, aIndex);
    return (cPtr == 0) ? null : new OpenSimObject(cPtr, false);
  }

  public OpenSimObject get(String aName) {
    long cPtr = opensimModelJNI.ArrayPtrsObj_get__SWIG_1(swigCPtr, aName);
    return (cPtr == 0) ? null : new OpenSimObject(cPtr, false);
  }

  public OpenSimObject getLast() {
    long cPtr = opensimModelJNI.ArrayPtrsObj_getLast(swigCPtr);
    return (cPtr == 0) ? null : new OpenSimObject(cPtr, false);
  }

  public int searchBinary(OpenSimObject aObject, boolean aFindFirst, int aLo, int aHi) {
    return opensimModelJNI.ArrayPtrsObj_searchBinary__SWIG_0(swigCPtr, OpenSimObject.getCPtr(aObject), aFindFirst, aLo, aHi);
  }

  public int searchBinary(OpenSimObject aObject, boolean aFindFirst, int aLo) {
    return opensimModelJNI.ArrayPtrsObj_searchBinary__SWIG_1(swigCPtr, OpenSimObject.getCPtr(aObject), aFindFirst, aLo);
  }

  public int searchBinary(OpenSimObject aObject, boolean aFindFirst) {
    return opensimModelJNI.ArrayPtrsObj_searchBinary__SWIG_2(swigCPtr, OpenSimObject.getCPtr(aObject), aFindFirst);
  }

  public int searchBinary(OpenSimObject aObject) {
    return opensimModelJNI.ArrayPtrsObj_searchBinary__SWIG_3(swigCPtr, OpenSimObject.getCPtr(aObject));
  }

}
