/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.37
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

  public synchronized void delete() {
    if(swigCPtr != 0 && swigCMemOwn) {
      swigCMemOwn = false;
      opensimModelJNI.delete_ArrayStr(swigCPtr);
    }
    swigCPtr = 0;
  }

   public java.util.Vector<String> toVector() {
      java.util.Vector<String> vector = new java.util.Vector<String>();
      vector.setSize(getSize());
      for(int i=0; i<getSize(); i++) vector.set(i, getitem(i));
      return vector;
   }
   public void append(java.util.Vector<String> vector) {
      for(int i=0; i<vector.size(); i++) append(vector.get(i));
   }
   public static ArrayStr fromVector(java.util.Vector<String> vector) {
      ArrayStr array = new ArrayStr();
      array.append(vector);
      return array;
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

  public ArrayStr() {
    this(opensimModelJNI.new_ArrayStr__SWIG_3(), true);
  }

  public ArrayStr(ArrayStr aArray) {
    this(opensimModelJNI.new_ArrayStr__SWIG_4(ArrayStr.getCPtr(aArray), aArray), true);
  }

  public boolean arrayEquals(ArrayStr aArray) {
    return opensimModelJNI.ArrayStr_arrayEquals(swigCPtr, this, ArrayStr.getCPtr(aArray), aArray);
  }

  public boolean computeNewCapacity(int aMinCapacity, SWIGTYPE_p_int rNewCapacity) {
    return opensimModelJNI.ArrayStr_computeNewCapacity(swigCPtr, this, aMinCapacity, SWIGTYPE_p_int.getCPtr(rNewCapacity));
  }

  public boolean ensureCapacity(int aCapacity) {
    return opensimModelJNI.ArrayStr_ensureCapacity(swigCPtr, this, aCapacity);
  }

  public void trim() {
    opensimModelJNI.ArrayStr_trim(swigCPtr, this);
  }

  public int getCapacity() {
    return opensimModelJNI.ArrayStr_getCapacity(swigCPtr, this);
  }

  public void setCapacityIncrement(int aIncrement) {
    opensimModelJNI.ArrayStr_setCapacityIncrement(swigCPtr, this, aIncrement);
  }

  public int getCapacityIncrement() {
    return opensimModelJNI.ArrayStr_getCapacityIncrement(swigCPtr, this);
  }

  public boolean setSize(int aSize) {
    return opensimModelJNI.ArrayStr_setSize(swigCPtr, this, aSize);
  }

  public int getSize() {
    return opensimModelJNI.ArrayStr_getSize(swigCPtr, this);
  }

  public int append(String aValue) {
    return opensimModelJNI.ArrayStr_append__SWIG_0(swigCPtr, this, aValue);
  }

  public int append(ArrayStr aArray) {
    return opensimModelJNI.ArrayStr_append__SWIG_1(swigCPtr, this, ArrayStr.getCPtr(aArray), aArray);
  }

  public int append(int aSize, SWIGTYPE_p_std__string aArray) {
    return opensimModelJNI.ArrayStr_append__SWIG_2(swigCPtr, this, aSize, SWIGTYPE_p_std__string.getCPtr(aArray));
  }

  public int insert(int aIndex, String aValue) {
    return opensimModelJNI.ArrayStr_insert(swigCPtr, this, aIndex, aValue);
  }

  public int remove(int aIndex) {
    return opensimModelJNI.ArrayStr_remove(swigCPtr, this, aIndex);
  }

  public void set(int aIndex, String aValue) {
    opensimModelJNI.ArrayStr_set(swigCPtr, this, aIndex, aValue);
  }

  public SWIGTYPE_p_std__string get() {
    long cPtr = opensimModelJNI.ArrayStr_get__SWIG_0(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_std__string(cPtr, false);
  }

  public SWIGTYPE_p_std__string get(int aIndex) {
    return new SWIGTYPE_p_std__string(opensimModelJNI.ArrayStr_get__SWIG_1(swigCPtr, this, aIndex), false);
  }

  public String getitem(int index) {
    return opensimModelJNI.ArrayStr_getitem(swigCPtr, this, index);
  }

  public void setitem(int index, String val) {
    opensimModelJNI.ArrayStr_setitem(swigCPtr, this, index, val);
  }

  public SWIGTYPE_p_std__string getLast() {
    return new SWIGTYPE_p_std__string(opensimModelJNI.ArrayStr_getLast(swigCPtr, this), false);
  }

  public int findIndex(String aValue) {
    return opensimModelJNI.ArrayStr_findIndex(swigCPtr, this, aValue);
  }

  public int rfindIndex(String aValue) {
    return opensimModelJNI.ArrayStr_rfindIndex(swigCPtr, this, aValue);
  }

  public int searchBinary(String aValue, boolean aFindFirst, int aLo, int aHi) {
    return opensimModelJNI.ArrayStr_searchBinary__SWIG_0(swigCPtr, this, aValue, aFindFirst, aLo, aHi);
  }

  public int searchBinary(String aValue, boolean aFindFirst, int aLo) {
    return opensimModelJNI.ArrayStr_searchBinary__SWIG_1(swigCPtr, this, aValue, aFindFirst, aLo);
  }

  public int searchBinary(String aValue, boolean aFindFirst) {
    return opensimModelJNI.ArrayStr_searchBinary__SWIG_2(swigCPtr, this, aValue, aFindFirst);
  }

  public int searchBinary(String aValue) {
    return opensimModelJNI.ArrayStr_searchBinary__SWIG_3(swigCPtr, this, aValue);
  }

}
