/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.29
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.opensim.modeling;

public class SetAnalysis extends OpenSimObject {
  private long swigCPtr;

  public SetAnalysis(long cPtr, boolean cMemoryOwn) {
    super(opensimModelJNI.SWIGStorageUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  public static long getCPtr(SetAnalysis obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public void delete() {
    if(swigCPtr != 0 && swigCMemOwn) {
      swigCMemOwn = false;
      opensimModelJNI.delete_SetAnalysis(swigCPtr);
    }
    swigCPtr = 0;
    super.delete();
  }

  public SetAnalysis() {
    this(opensimModelJNI.new_SetAnalysis__SWIG_0(), true);
  }

  public SetAnalysis(String aFileName) {
    this(opensimModelJNI.new_SetAnalysis__SWIG_1(aFileName), true);
  }

  public SetAnalysis(SWIGTYPE_p_DOMElement aElement) {
    this(opensimModelJNI.new_SetAnalysis__SWIG_2(SWIGTYPE_p_DOMElement.getCPtr(aElement)), true);
  }

  public SetAnalysis(SetAnalysis aSet) {
    this(opensimModelJNI.new_SetAnalysis__SWIG_3(SetAnalysis.getCPtr(aSet)), true);
  }

  public OpenSimObject copy() {
    long cPtr = opensimModelJNI.SetAnalysis_copy(swigCPtr);
    return (cPtr == 0) ? null : new OpenSimObject(cPtr, false);
  }

  public void setMemoryOwner(boolean aTrueFalse) {
    opensimModelJNI.SetAnalysis_setMemoryOwner(swigCPtr, aTrueFalse);
  }

  public boolean getMemoryOwner() {
    return opensimModelJNI.SetAnalysis_getMemoryOwner(swigCPtr);
  }

  public boolean computeNewCapacity(int aMinCapacity, SWIGTYPE_p_int rNewCapacity) {
    return opensimModelJNI.SetAnalysis_computeNewCapacity(swigCPtr, aMinCapacity, SWIGTYPE_p_int.getCPtr(rNewCapacity));
  }

  public boolean ensureCapacity(int aCapacity) {
    return opensimModelJNI.SetAnalysis_ensureCapacity(swigCPtr, aCapacity);
  }

  public void trim() {
    opensimModelJNI.SetAnalysis_trim(swigCPtr);
  }

  public int getCapacity() {
    return opensimModelJNI.SetAnalysis_getCapacity(swigCPtr);
  }

  public void setCapacityIncrement(int aIncrement) {
    opensimModelJNI.SetAnalysis_setCapacityIncrement(swigCPtr, aIncrement);
  }

  public int getCapacityIncrement() {
    return opensimModelJNI.SetAnalysis_getCapacityIncrement(swigCPtr);
  }

  public boolean setSize(int aSize) {
    return opensimModelJNI.SetAnalysis_setSize(swigCPtr, aSize);
  }

  public int getSize() {
    return opensimModelJNI.SetAnalysis_getSize(swigCPtr);
  }

  public int getIndex(Analysis aObject, int aStartIndex) {
    return opensimModelJNI.SetAnalysis_getIndex__SWIG_0(swigCPtr, Analysis.getCPtr(aObject), aStartIndex);
  }

  public int getIndex(Analysis aObject) {
    return opensimModelJNI.SetAnalysis_getIndex__SWIG_1(swigCPtr, Analysis.getCPtr(aObject));
  }

  public int getIndex(String aName, int aStartIndex) {
    return opensimModelJNI.SetAnalysis_getIndex__SWIG_2(swigCPtr, aName, aStartIndex);
  }

  public int getIndex(String aName) {
    return opensimModelJNI.SetAnalysis_getIndex__SWIG_3(swigCPtr, aName);
  }

  public boolean append(Analysis aObject) {
    return opensimModelJNI.SetAnalysis_append__SWIG_0(swigCPtr, Analysis.getCPtr(aObject));
  }

  public boolean append(SWIGTYPE_p_OpenSim__ArrayPtrsTOpenSim__Analysis_t aArray) {
    return opensimModelJNI.SetAnalysis_append__SWIG_1(swigCPtr, SWIGTYPE_p_OpenSim__ArrayPtrsTOpenSim__Analysis_t.getCPtr(aArray));
  }

  public boolean insert(int aIndex, Analysis aObject) {
    return opensimModelJNI.SetAnalysis_insert(swigCPtr, aIndex, Analysis.getCPtr(aObject));
  }

  public boolean remove(int aIndex) {
    return opensimModelJNI.SetAnalysis_remove__SWIG_0(swigCPtr, aIndex);
  }

  public boolean remove(Analysis aObject) {
    return opensimModelJNI.SetAnalysis_remove__SWIG_1(swigCPtr, Analysis.getCPtr(aObject));
  }

  public void clearAndDestroy() {
    opensimModelJNI.SetAnalysis_clearAndDestroy(swigCPtr);
  }

  public boolean set(int aIndex, Analysis aObject) {
    return opensimModelJNI.SetAnalysis_set(swigCPtr, aIndex, Analysis.getCPtr(aObject));
  }

  public Analysis get(int aIndex) {
    long cPtr = opensimModelJNI.SetAnalysis_get__SWIG_0(swigCPtr, aIndex);
    return (cPtr == 0) ? null : new Analysis(cPtr, false);
  }

  public Analysis get(String aName) {
    long cPtr = opensimModelJNI.SetAnalysis_get__SWIG_1(swigCPtr, aName);
    return (cPtr == 0) ? null : new Analysis(cPtr, false);
  }

  public void getNames(ArrayStr rNames) {
    opensimModelJNI.SetAnalysis_getNames(swigCPtr, ArrayStr.getCPtr(rNames));
  }

  public Analysis getLast() {
    long cPtr = opensimModelJNI.SetAnalysis_getLast(swigCPtr);
    return (cPtr == 0) ? null : new Analysis(cPtr, false);
  }

  public int searchBinary(Analysis aObject, boolean aFindFirst, int aLo, int aHi) {
    return opensimModelJNI.SetAnalysis_searchBinary__SWIG_0(swigCPtr, Analysis.getCPtr(aObject), aFindFirst, aLo, aHi);
  }

  public int searchBinary(Analysis aObject, boolean aFindFirst, int aLo) {
    return opensimModelJNI.SetAnalysis_searchBinary__SWIG_1(swigCPtr, Analysis.getCPtr(aObject), aFindFirst, aLo);
  }

  public int searchBinary(Analysis aObject, boolean aFindFirst) {
    return opensimModelJNI.SetAnalysis_searchBinary__SWIG_2(swigCPtr, Analysis.getCPtr(aObject), aFindFirst);
  }

  public int searchBinary(Analysis aObject) {
    return opensimModelJNI.SetAnalysis_searchBinary__SWIG_3(swigCPtr, Analysis.getCPtr(aObject));
  }

}
