/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.37
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.opensim.modeling;

public class ArrayObjPtr {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  public ArrayObjPtr(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  public static long getCPtr(ArrayObjPtr obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if(swigCPtr != 0 && swigCMemOwn) {
      swigCMemOwn = false;
      opensimModelJNI.delete_ArrayObjPtr(swigCPtr);
    }
    swigCPtr = 0;
  }

  public ArrayObjPtr(OpenSimObject aDefaultValue, int aSize, int aCapacity) {
    this(opensimModelJNI.new_ArrayObjPtr__SWIG_0(OpenSimObject.getCPtr(aDefaultValue), aDefaultValue, aSize, aCapacity), true);
  }

  public ArrayObjPtr(OpenSimObject aDefaultValue, int aSize) {
    this(opensimModelJNI.new_ArrayObjPtr__SWIG_1(OpenSimObject.getCPtr(aDefaultValue), aDefaultValue, aSize), true);
  }

  public ArrayObjPtr(OpenSimObject aDefaultValue) {
    this(opensimModelJNI.new_ArrayObjPtr__SWIG_2(OpenSimObject.getCPtr(aDefaultValue), aDefaultValue), true);
  }

  public ArrayObjPtr() {
    this(opensimModelJNI.new_ArrayObjPtr__SWIG_3(), true);
  }

  public ArrayObjPtr(ArrayObjPtr aArray) {
    this(opensimModelJNI.new_ArrayObjPtr__SWIG_4(ArrayObjPtr.getCPtr(aArray), aArray), true);
  }

  public boolean arrayEquals(ArrayObjPtr aArray) {
    return opensimModelJNI.ArrayObjPtr_arrayEquals(swigCPtr, this, ArrayObjPtr.getCPtr(aArray), aArray);
  }

  public boolean computeNewCapacity(int aMinCapacity, SWIGTYPE_p_int rNewCapacity) {
    return opensimModelJNI.ArrayObjPtr_computeNewCapacity(swigCPtr, this, aMinCapacity, SWIGTYPE_p_int.getCPtr(rNewCapacity));
  }

  public boolean ensureCapacity(int aCapacity) {
    return opensimModelJNI.ArrayObjPtr_ensureCapacity(swigCPtr, this, aCapacity);
  }

  public void trim() {
    opensimModelJNI.ArrayObjPtr_trim(swigCPtr, this);
  }

  public int getCapacity() {
    return opensimModelJNI.ArrayObjPtr_getCapacity(swigCPtr, this);
  }

  public void setCapacityIncrement(int aIncrement) {
    opensimModelJNI.ArrayObjPtr_setCapacityIncrement(swigCPtr, this, aIncrement);
  }

  public int getCapacityIncrement() {
    return opensimModelJNI.ArrayObjPtr_getCapacityIncrement(swigCPtr, this);
  }

  public boolean setSize(int aSize) {
    return opensimModelJNI.ArrayObjPtr_setSize(swigCPtr, this, aSize);
  }

  public int getSize() {
    return opensimModelJNI.ArrayObjPtr_getSize(swigCPtr, this);
  }

  public int append(OpenSimObject aValue) {
    return opensimModelJNI.ArrayObjPtr_append__SWIG_0(swigCPtr, this, OpenSimObject.getCPtr(aValue), aValue);
  }

  public int append(ArrayObjPtr aArray) {
    return opensimModelJNI.ArrayObjPtr_append__SWIG_1(swigCPtr, this, ArrayObjPtr.getCPtr(aArray), aArray);
  }

  public int append(int aSize, SWIGTYPE_p_p_OpenSim__Object aArray) {
    return opensimModelJNI.ArrayObjPtr_append__SWIG_2(swigCPtr, this, aSize, SWIGTYPE_p_p_OpenSim__Object.getCPtr(aArray));
  }

  public int insert(int aIndex, OpenSimObject aValue) {
    return opensimModelJNI.ArrayObjPtr_insert(swigCPtr, this, aIndex, OpenSimObject.getCPtr(aValue), aValue);
  }

  public int remove(int aIndex) {
    return opensimModelJNI.ArrayObjPtr_remove(swigCPtr, this, aIndex);
  }

  public void set(int aIndex, OpenSimObject aValue) {
    opensimModelJNI.ArrayObjPtr_set(swigCPtr, this, aIndex, OpenSimObject.getCPtr(aValue), aValue);
  }

  public SWIGTYPE_p_p_OpenSim__Object get() {
    long cPtr = opensimModelJNI.ArrayObjPtr_get__SWIG_0(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_p_OpenSim__Object(cPtr, false);
  }

  public OpenSimObject get(int aIndex) {
    long cPtr = opensimModelJNI.ArrayObjPtr_get__SWIG_1(swigCPtr, this, aIndex);
    return (cPtr == 0) ? null : new OpenSimObject(cPtr, false);
  }

  public OpenSimObject getitem(int index) {
    long cPtr = opensimModelJNI.ArrayObjPtr_getitem(swigCPtr, this, index);
    return (cPtr == 0) ? null : new OpenSimObject(cPtr, false);
  }

  public void setitem(int index, OpenSimObject val) {
    opensimModelJNI.ArrayObjPtr_setitem(swigCPtr, this, index, OpenSimObject.getCPtr(val), val);
  }

  public OpenSimObject getLast() {
    long cPtr = opensimModelJNI.ArrayObjPtr_getLast(swigCPtr, this);
    return (cPtr == 0) ? null : new OpenSimObject(cPtr, false);
  }

  public int findIndex(OpenSimObject aValue) {
    return opensimModelJNI.ArrayObjPtr_findIndex(swigCPtr, this, OpenSimObject.getCPtr(aValue), aValue);
  }

  public int rfindIndex(OpenSimObject aValue) {
    return opensimModelJNI.ArrayObjPtr_rfindIndex(swigCPtr, this, OpenSimObject.getCPtr(aValue), aValue);
  }

  public int searchBinary(OpenSimObject aValue, boolean aFindFirst, int aLo, int aHi) {
    return opensimModelJNI.ArrayObjPtr_searchBinary__SWIG_0(swigCPtr, this, OpenSimObject.getCPtr(aValue), aValue, aFindFirst, aLo, aHi);
  }

  public int searchBinary(OpenSimObject aValue, boolean aFindFirst, int aLo) {
    return opensimModelJNI.ArrayObjPtr_searchBinary__SWIG_1(swigCPtr, this, OpenSimObject.getCPtr(aValue), aValue, aFindFirst, aLo);
  }

  public int searchBinary(OpenSimObject aValue, boolean aFindFirst) {
    return opensimModelJNI.ArrayObjPtr_searchBinary__SWIG_2(swigCPtr, this, OpenSimObject.getCPtr(aValue), aValue, aFindFirst);
  }

  public int searchBinary(OpenSimObject aValue) {
    return opensimModelJNI.ArrayObjPtr_searchBinary__SWIG_3(swigCPtr, this, OpenSimObject.getCPtr(aValue), aValue);
  }

}
