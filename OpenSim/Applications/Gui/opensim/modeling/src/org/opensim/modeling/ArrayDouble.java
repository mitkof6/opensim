/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.40
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.opensim.modeling;

public class ArrayDouble {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  public ArrayDouble(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  public static long getCPtr(ArrayDouble obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        opensimModelJNI.delete_ArrayDouble(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public ArrayDouble(double aDefaultValue, int aSize, int aCapacity) {
    this(opensimModelJNI.new_ArrayDouble__SWIG_0(aDefaultValue, aSize, aCapacity), true);
  }

  public ArrayDouble(double aDefaultValue, int aSize) {
    this(opensimModelJNI.new_ArrayDouble__SWIG_1(aDefaultValue, aSize), true);
  }

  public ArrayDouble(double aDefaultValue) {
    this(opensimModelJNI.new_ArrayDouble__SWIG_2(aDefaultValue), true);
  }

  public ArrayDouble() {
    this(opensimModelJNI.new_ArrayDouble__SWIG_3(), true);
  }

  public ArrayDouble(ArrayDouble aArray) {
    this(opensimModelJNI.new_ArrayDouble__SWIG_4(ArrayDouble.getCPtr(aArray), aArray), true);
  }

  public boolean arrayEquals(ArrayDouble aArray) {
    return opensimModelJNI.ArrayDouble_arrayEquals(swigCPtr, this, ArrayDouble.getCPtr(aArray), aArray);
  }

  public boolean computeNewCapacity(int aMinCapacity, SWIGTYPE_p_int rNewCapacity) {
    return opensimModelJNI.ArrayDouble_computeNewCapacity(swigCPtr, this, aMinCapacity, SWIGTYPE_p_int.getCPtr(rNewCapacity));
  }

  public boolean ensureCapacity(int aCapacity) {
    return opensimModelJNI.ArrayDouble_ensureCapacity(swigCPtr, this, aCapacity);
  }

  public void trim() {
    opensimModelJNI.ArrayDouble_trim(swigCPtr, this);
  }

  public int getCapacity() {
    return opensimModelJNI.ArrayDouble_getCapacity(swigCPtr, this);
  }

  public void setCapacityIncrement(int aIncrement) {
    opensimModelJNI.ArrayDouble_setCapacityIncrement(swigCPtr, this, aIncrement);
  }

  public int getCapacityIncrement() {
    return opensimModelJNI.ArrayDouble_getCapacityIncrement(swigCPtr, this);
  }

  public boolean setSize(int aSize) {
    return opensimModelJNI.ArrayDouble_setSize(swigCPtr, this, aSize);
  }

  public int getSize() {
    return opensimModelJNI.ArrayDouble_getSize(swigCPtr, this);
  }

  public int append(double aValue) {
    return opensimModelJNI.ArrayDouble_append__SWIG_0(swigCPtr, this, aValue);
  }

  public int append(ArrayDouble aArray) {
    return opensimModelJNI.ArrayDouble_append__SWIG_1(swigCPtr, this, ArrayDouble.getCPtr(aArray), aArray);
  }

  public int append(int aSize, SWIGTYPE_p_double aArray) {
    return opensimModelJNI.ArrayDouble_append__SWIG_2(swigCPtr, this, aSize, SWIGTYPE_p_double.getCPtr(aArray));
  }

  public int insert(int aIndex, double aValue) {
    return opensimModelJNI.ArrayDouble_insert(swigCPtr, this, aIndex, aValue);
  }

  public int remove(int aIndex) {
    return opensimModelJNI.ArrayDouble_remove(swigCPtr, this, aIndex);
  }

  public void set(int aIndex, double aValue) {
    opensimModelJNI.ArrayDouble_set(swigCPtr, this, aIndex, aValue);
  }

  public SWIGTYPE_p_double get() {
    long cPtr = opensimModelJNI.ArrayDouble_get__SWIG_0(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_double(cPtr, false);
  }

  public SWIGTYPE_p_double get(int aIndex) {
    return new SWIGTYPE_p_double(opensimModelJNI.ArrayDouble_get__SWIG_1(swigCPtr, this, aIndex), false);
  }

  public double getitem(int index) {
    return opensimModelJNI.ArrayDouble_getitem(swigCPtr, this, index);
  }

  public void setitem(int index, double val) {
    opensimModelJNI.ArrayDouble_setitem(swigCPtr, this, index, val);
  }

  public SWIGTYPE_p_double getLast() {
    return new SWIGTYPE_p_double(opensimModelJNI.ArrayDouble_getLast(swigCPtr, this), false);
  }

  public int findIndex(double aValue) {
    return opensimModelJNI.ArrayDouble_findIndex(swigCPtr, this, aValue);
  }

  public int rfindIndex(double aValue) {
    return opensimModelJNI.ArrayDouble_rfindIndex(swigCPtr, this, aValue);
  }

  public int searchBinary(double aValue, boolean aFindFirst, int aLo, int aHi) {
    return opensimModelJNI.ArrayDouble_searchBinary__SWIG_0(swigCPtr, this, aValue, aFindFirst, aLo, aHi);
  }

  public int searchBinary(double aValue, boolean aFindFirst, int aLo) {
    return opensimModelJNI.ArrayDouble_searchBinary__SWIG_1(swigCPtr, this, aValue, aFindFirst, aLo);
  }

  public int searchBinary(double aValue, boolean aFindFirst) {
    return opensimModelJNI.ArrayDouble_searchBinary__SWIG_2(swigCPtr, this, aValue, aFindFirst);
  }

  public int searchBinary(double aValue) {
    return opensimModelJNI.ArrayDouble_searchBinary__SWIG_3(swigCPtr, this, aValue);
  }

}
