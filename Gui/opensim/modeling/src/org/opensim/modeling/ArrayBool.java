/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.4
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.opensim.modeling;

public class ArrayBool {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  public ArrayBool(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  public static long getCPtr(ArrayBool obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        opensimModelJNI.delete_ArrayBool(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public ArrayBool(boolean aDefaultValue, int aSize, int aCapacity) {
    this(opensimModelJNI.new_ArrayBool__SWIG_0(aDefaultValue, aSize, aCapacity), true);
  }

  public ArrayBool(boolean aDefaultValue, int aSize) {
    this(opensimModelJNI.new_ArrayBool__SWIG_1(aDefaultValue, aSize), true);
  }

  public ArrayBool(boolean aDefaultValue) {
    this(opensimModelJNI.new_ArrayBool__SWIG_2(aDefaultValue), true);
  }

  public ArrayBool() {
    this(opensimModelJNI.new_ArrayBool__SWIG_3(), true);
  }

  public ArrayBool(ArrayBool aArray) {
    this(opensimModelJNI.new_ArrayBool__SWIG_4(ArrayBool.getCPtr(aArray), aArray), true);
  }

  public boolean arrayEquals(ArrayBool aArray) {
    return opensimModelJNI.ArrayBool_arrayEquals(swigCPtr, this, ArrayBool.getCPtr(aArray), aArray);
  }

  public boolean computeNewCapacity(int aMinCapacity, SWIGTYPE_p_int rNewCapacity) {
    return opensimModelJNI.ArrayBool_computeNewCapacity(swigCPtr, this, aMinCapacity, SWIGTYPE_p_int.getCPtr(rNewCapacity));
  }

  public boolean ensureCapacity(int aCapacity) {
    return opensimModelJNI.ArrayBool_ensureCapacity(swigCPtr, this, aCapacity);
  }

  public void trim() {
    opensimModelJNI.ArrayBool_trim(swigCPtr, this);
  }

  public int getCapacity() {
    return opensimModelJNI.ArrayBool_getCapacity(swigCPtr, this);
  }

  public void setCapacityIncrement(int aIncrement) {
    opensimModelJNI.ArrayBool_setCapacityIncrement(swigCPtr, this, aIncrement);
  }

  public int getCapacityIncrement() {
    return opensimModelJNI.ArrayBool_getCapacityIncrement(swigCPtr, this);
  }

  public boolean setSize(int aSize) {
    return opensimModelJNI.ArrayBool_setSize(swigCPtr, this, aSize);
  }

  public int getSize() {
    return opensimModelJNI.ArrayBool_getSize(swigCPtr, this);
  }

  public int size() {
    return opensimModelJNI.ArrayBool_size(swigCPtr, this);
  }

  public int append(boolean aValue) {
    return opensimModelJNI.ArrayBool_append__SWIG_0(swigCPtr, this, aValue);
  }

  public int append(ArrayBool aArray) {
    return opensimModelJNI.ArrayBool_append__SWIG_1(swigCPtr, this, ArrayBool.getCPtr(aArray), aArray);
  }

  public int append(int aSize, SWIGTYPE_p_bool aArray) {
    return opensimModelJNI.ArrayBool_append__SWIG_2(swigCPtr, this, aSize, SWIGTYPE_p_bool.getCPtr(aArray));
  }

  public int insert(int aIndex, boolean aValue) {
    return opensimModelJNI.ArrayBool_insert(swigCPtr, this, aIndex, aValue);
  }

  public int remove(int aIndex) {
    return opensimModelJNI.ArrayBool_remove(swigCPtr, this, aIndex);
  }

  public void set(int aIndex, boolean aValue) {
    opensimModelJNI.ArrayBool_set(swigCPtr, this, aIndex, aValue);
  }

  public SWIGTYPE_p_bool get() {
    long cPtr = opensimModelJNI.ArrayBool_get__SWIG_0(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_bool(cPtr, false);
  }

  public SWIGTYPE_p_bool get(int aIndex) {
    return new SWIGTYPE_p_bool(opensimModelJNI.ArrayBool_get__SWIG_1(swigCPtr, this, aIndex), false);
  }

  public boolean getitem(int index) {
    return opensimModelJNI.ArrayBool_getitem(swigCPtr, this, index);
  }

  public void setitem(int index, boolean val) {
    opensimModelJNI.ArrayBool_setitem(swigCPtr, this, index, val);
  }

  public SWIGTYPE_p_bool getLast() {
    return new SWIGTYPE_p_bool(opensimModelJNI.ArrayBool_getLast(swigCPtr, this), false);
  }

  public int findIndex(boolean aValue) {
    return opensimModelJNI.ArrayBool_findIndex(swigCPtr, this, aValue);
  }

  public int rfindIndex(boolean aValue) {
    return opensimModelJNI.ArrayBool_rfindIndex(swigCPtr, this, aValue);
  }

  public int searchBinary(boolean aValue, boolean aFindFirst, int aLo, int aHi) {
    return opensimModelJNI.ArrayBool_searchBinary__SWIG_0(swigCPtr, this, aValue, aFindFirst, aLo, aHi);
  }

  public int searchBinary(boolean aValue, boolean aFindFirst, int aLo) {
    return opensimModelJNI.ArrayBool_searchBinary__SWIG_1(swigCPtr, this, aValue, aFindFirst, aLo);
  }

  public int searchBinary(boolean aValue, boolean aFindFirst) {
    return opensimModelJNI.ArrayBool_searchBinary__SWIG_2(swigCPtr, this, aValue, aFindFirst);
  }

  public int searchBinary(boolean aValue) {
    return opensimModelJNI.ArrayBool_searchBinary__SWIG_3(swigCPtr, this, aValue);
  }

}
