/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.29
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.opensim.modeling;

public class ArrayStr {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  public ArrayStr(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  public static long getCPtr(ArrayStr obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public void delete() {
    if(swigCPtr != 0 && swigCMemOwn) {
      swigCMemOwn = false;
      opensimModelJNI.delete_ArrayStr(swigCPtr);
    }
    swigCPtr = 0;
  }

  public ArrayStr(String aDefaultValue, int aSize, int aCapacity) {
    this(opensimModelJNI.new_ArrayStr__SWIG_0(aDefaultValue, aSize, aCapacity), true);
  }

  public ArrayStr(String aDefaultValue, int aSize) {
    this(opensimModelJNI.new_ArrayStr__SWIG_1(aDefaultValue, aSize), true);
  }

  public ArrayStr(String aDefaultValue) {
    this(opensimModelJNI.new_ArrayStr__SWIG_2(aDefaultValue), true);
  }

  public ArrayStr(ArrayStr aArray) {
    this(opensimModelJNI.new_ArrayStr__SWIG_3(ArrayStr.getCPtr(aArray)), true);
  }

  public boolean computeNewCapacity(int aMinCapacity, SWIGTYPE_p_int rNewCapacity) {
    return opensimModelJNI.ArrayStr_computeNewCapacity(swigCPtr, aMinCapacity, SWIGTYPE_p_int.getCPtr(rNewCapacity));
  }

  public boolean ensureCapacity(int aCapacity) {
    return opensimModelJNI.ArrayStr_ensureCapacity(swigCPtr, aCapacity);
  }

  public void trim() {
    opensimModelJNI.ArrayStr_trim(swigCPtr);
  }

  public int getCapacity() {
    return opensimModelJNI.ArrayStr_getCapacity(swigCPtr);
  }

  public void setCapacityIncrement(int aIncrement) {
    opensimModelJNI.ArrayStr_setCapacityIncrement(swigCPtr, aIncrement);
  }

  public int getCapacityIncrement() {
    return opensimModelJNI.ArrayStr_getCapacityIncrement(swigCPtr);
  }

  public boolean setSize(int aSize) {
    return opensimModelJNI.ArrayStr_setSize(swigCPtr, aSize);
  }

  public int getSize() {
    return opensimModelJNI.ArrayStr_getSize(swigCPtr);
  }

  public int append(String aValue) {
    return opensimModelJNI.ArrayStr_append__SWIG_0(swigCPtr, aValue);
  }

  public int append(ArrayStr aArray) {
    return opensimModelJNI.ArrayStr_append__SWIG_1(swigCPtr, ArrayStr.getCPtr(aArray));
  }

  public int append(int aSize, SWIGTYPE_p_std__string aArray) {
    return opensimModelJNI.ArrayStr_append__SWIG_2(swigCPtr, aSize, SWIGTYPE_p_std__string.getCPtr(aArray));
  }

  public int insert(int aIndex, String aValue) {
    return opensimModelJNI.ArrayStr_insert(swigCPtr, aIndex, aValue);
  }

  public int remove(int aIndex) {
    return opensimModelJNI.ArrayStr_remove(swigCPtr, aIndex);
  }

  public void set(int aIndex, String aValue) {
    opensimModelJNI.ArrayStr_set(swigCPtr, aIndex, aValue);
  }

  public SWIGTYPE_p_std__string get() {
    long cPtr = opensimModelJNI.ArrayStr_get__SWIG_0(swigCPtr);
    return (cPtr == 0) ? null : new SWIGTYPE_p_std__string(cPtr, false);
  }

  public SWIGTYPE_p_std__string get(int aIndex) {
    return new SWIGTYPE_p_std__string(opensimModelJNI.ArrayStr_get__SWIG_1(swigCPtr, aIndex), false);
  }

  public String getitem(int index) {
    return opensimModelJNI.ArrayStr_getitem(swigCPtr, index);
  }

  public void setitem(int index, String val) {
    opensimModelJNI.ArrayStr_setitem(swigCPtr, index, val);
  }

  public SWIGTYPE_p_std__string getLast() {
    return new SWIGTYPE_p_std__string(opensimModelJNI.ArrayStr_getLast(swigCPtr), false);
  }

  public int searchBinary(String aValue, boolean aFindFirst, int aLo, int aHi) {
    return opensimModelJNI.ArrayStr_searchBinary__SWIG_0(swigCPtr, aValue, aFindFirst, aLo, aHi);
  }

  public int searchBinary(String aValue, boolean aFindFirst, int aLo) {
    return opensimModelJNI.ArrayStr_searchBinary__SWIG_1(swigCPtr, aValue, aFindFirst, aLo);
  }

  public int searchBinary(String aValue, boolean aFindFirst) {
    return opensimModelJNI.ArrayStr_searchBinary__SWIG_2(swigCPtr, aValue, aFindFirst);
  }

  public int searchBinary(String aValue) {
    return opensimModelJNI.ArrayStr_searchBinary__SWIG_3(swigCPtr, aValue);
  }

}
