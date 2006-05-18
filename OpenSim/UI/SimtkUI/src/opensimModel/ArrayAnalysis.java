/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.29
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package opensimModel;

public class ArrayAnalysis {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected ArrayAnalysis(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(ArrayAnalysis obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public void delete() {
    if(swigCPtr != 0 && swigCMemOwn) {
      swigCMemOwn = false;
      opensimModelJNI.delete_ArrayAnalysis(swigCPtr);
    }
    swigCPtr = 0;
  }

  public ArrayAnalysis(int aCapacity) {
    this(opensimModelJNI.new_ArrayAnalysis__SWIG_0(aCapacity), true);
  }

  public ArrayAnalysis() {
    this(opensimModelJNI.new_ArrayAnalysis__SWIG_1(), true);
  }

  public ArrayAnalysis(ArrayAnalysis aArray) {
    this(opensimModelJNI.new_ArrayAnalysis__SWIG_2(ArrayAnalysis.getCPtr(aArray)), true);
  }

  public void clearAndDestroy() {
    opensimModelJNI.ArrayAnalysis_clearAndDestroy(swigCPtr);
  }

  public void setMemoryOwner(boolean aTrueFalse) {
    opensimModelJNI.ArrayAnalysis_setMemoryOwner(swigCPtr, aTrueFalse);
  }

  public boolean getMemoryOwner() {
    return opensimModelJNI.ArrayAnalysis_getMemoryOwner(swigCPtr);
  }

  public boolean computeNewCapacity(int aMinCapacity, SWIGTYPE_p_int rNewCapacity) {
    return opensimModelJNI.ArrayAnalysis_computeNewCapacity(swigCPtr, aMinCapacity, SWIGTYPE_p_int.getCPtr(rNewCapacity));
  }

  public boolean ensureCapacity(int aCapacity) {
    return opensimModelJNI.ArrayAnalysis_ensureCapacity(swigCPtr, aCapacity);
  }

  public void trim() {
    opensimModelJNI.ArrayAnalysis_trim(swigCPtr);
  }

  public int getCapacity() {
    return opensimModelJNI.ArrayAnalysis_getCapacity(swigCPtr);
  }

  public void setCapacityIncrement(int aIncrement) {
    opensimModelJNI.ArrayAnalysis_setCapacityIncrement(swigCPtr, aIncrement);
  }

  public int getCapacityIncrement() {
    return opensimModelJNI.ArrayAnalysis_getCapacityIncrement(swigCPtr);
  }

  public boolean setSize(int aSize) {
    return opensimModelJNI.ArrayAnalysis_setSize(swigCPtr, aSize);
  }

  public int getSize() {
    return opensimModelJNI.ArrayAnalysis_getSize(swigCPtr);
  }

  public int getIndex(Analysis aObject, int aStartIndex) {
    return opensimModelJNI.ArrayAnalysis_getIndex__SWIG_0(swigCPtr, Analysis.getCPtr(aObject), aStartIndex);
  }

  public int getIndex(Analysis aObject) {
    return opensimModelJNI.ArrayAnalysis_getIndex__SWIG_1(swigCPtr, Analysis.getCPtr(aObject));
  }

  public int getIndex(String aName, int aStartIndex) {
    return opensimModelJNI.ArrayAnalysis_getIndex__SWIG_2(swigCPtr, aName, aStartIndex);
  }

  public int getIndex(String aName) {
    return opensimModelJNI.ArrayAnalysis_getIndex__SWIG_3(swigCPtr, aName);
  }

  public boolean append(Analysis aObject) {
    return opensimModelJNI.ArrayAnalysis_append__SWIG_0(swigCPtr, Analysis.getCPtr(aObject));
  }

  public boolean append(ArrayAnalysis aArray) {
    return opensimModelJNI.ArrayAnalysis_append__SWIG_1(swigCPtr, ArrayAnalysis.getCPtr(aArray));
  }

  public boolean insert(int aIndex, Analysis aObject) {
    return opensimModelJNI.ArrayAnalysis_insert(swigCPtr, aIndex, Analysis.getCPtr(aObject));
  }

  public boolean remove(int aIndex) {
    return opensimModelJNI.ArrayAnalysis_remove__SWIG_0(swigCPtr, aIndex);
  }

  public boolean remove(Analysis aObject) {
    return opensimModelJNI.ArrayAnalysis_remove__SWIG_1(swigCPtr, Analysis.getCPtr(aObject));
  }

  public boolean set(int aIndex, Analysis aObject) {
    return opensimModelJNI.ArrayAnalysis_set(swigCPtr, aIndex, Analysis.getCPtr(aObject));
  }

  public Analysis get(int aIndex) {
    long cPtr = opensimModelJNI.ArrayAnalysis_get__SWIG_0(swigCPtr, aIndex);
    return (cPtr == 0) ? null : new Analysis(cPtr, false);
  }

  public Analysis get(String aName) {
    long cPtr = opensimModelJNI.ArrayAnalysis_get__SWIG_1(swigCPtr, aName);
    return (cPtr == 0) ? null : new Analysis(cPtr, false);
  }

  public Analysis getLast() {
    long cPtr = opensimModelJNI.ArrayAnalysis_getLast(swigCPtr);
    return (cPtr == 0) ? null : new Analysis(cPtr, false);
  }

  public int searchBinary(Analysis aObject, boolean aFindFirst, int aLo, int aHi) {
    return opensimModelJNI.ArrayAnalysis_searchBinary__SWIG_0(swigCPtr, Analysis.getCPtr(aObject), aFindFirst, aLo, aHi);
  }

  public int searchBinary(Analysis aObject, boolean aFindFirst, int aLo) {
    return opensimModelJNI.ArrayAnalysis_searchBinary__SWIG_1(swigCPtr, Analysis.getCPtr(aObject), aFindFirst, aLo);
  }

  public int searchBinary(Analysis aObject, boolean aFindFirst) {
    return opensimModelJNI.ArrayAnalysis_searchBinary__SWIG_2(swigCPtr, Analysis.getCPtr(aObject), aFindFirst);
  }

  public int searchBinary(Analysis aObject) {
    return opensimModelJNI.ArrayAnalysis_searchBinary__SWIG_3(swigCPtr, Analysis.getCPtr(aObject));
  }

}
