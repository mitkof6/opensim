/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.29
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.opensim.modeling;

public class SetSimmMusclePoint extends OpenSimObject {
  private long swigCPtr;

  public SetSimmMusclePoint(long cPtr, boolean cMemoryOwn) {
    super(opensimModelJNI.SWIGStorageUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  public static long getCPtr(SetSimmMusclePoint obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public void delete() {
    if(swigCPtr != 0 && swigCMemOwn) {
      swigCMemOwn = false;
      opensimModelJNI.delete_SetSimmMusclePoint(swigCPtr);
    }
    swigCPtr = 0;
    super.delete();
  }

  public SetSimmMusclePoint() {
    this(opensimModelJNI.new_SetSimmMusclePoint__SWIG_0(), true);
  }

  public SetSimmMusclePoint(String aFileName) {
    this(opensimModelJNI.new_SetSimmMusclePoint__SWIG_1(aFileName), true);
  }

  public SetSimmMusclePoint(SWIGTYPE_p_DOMElement aElement) {
    this(opensimModelJNI.new_SetSimmMusclePoint__SWIG_2(SWIGTYPE_p_DOMElement.getCPtr(aElement)), true);
  }

  public SetSimmMusclePoint(SetSimmMusclePoint aSet) {
    this(opensimModelJNI.new_SetSimmMusclePoint__SWIG_3(SetSimmMusclePoint.getCPtr(aSet)), true);
  }

  public OpenSimObject copy() {
    long cPtr = opensimModelJNI.SetSimmMusclePoint_copy(swigCPtr);
    return (cPtr == 0) ? null : new OpenSimObject(cPtr, false);
  }

  public void setMemoryOwner(boolean aTrueFalse) {
    opensimModelJNI.SetSimmMusclePoint_setMemoryOwner(swigCPtr, aTrueFalse);
  }

  public boolean getMemoryOwner() {
    return opensimModelJNI.SetSimmMusclePoint_getMemoryOwner(swigCPtr);
  }

  public boolean computeNewCapacity(int aMinCapacity, SWIGTYPE_p_int rNewCapacity) {
    return opensimModelJNI.SetSimmMusclePoint_computeNewCapacity(swigCPtr, aMinCapacity, SWIGTYPE_p_int.getCPtr(rNewCapacity));
  }

  public boolean ensureCapacity(int aCapacity) {
    return opensimModelJNI.SetSimmMusclePoint_ensureCapacity(swigCPtr, aCapacity);
  }

  public void trim() {
    opensimModelJNI.SetSimmMusclePoint_trim(swigCPtr);
  }

  public int getCapacity() {
    return opensimModelJNI.SetSimmMusclePoint_getCapacity(swigCPtr);
  }

  public void setCapacityIncrement(int aIncrement) {
    opensimModelJNI.SetSimmMusclePoint_setCapacityIncrement(swigCPtr, aIncrement);
  }

  public int getCapacityIncrement() {
    return opensimModelJNI.SetSimmMusclePoint_getCapacityIncrement(swigCPtr);
  }

  public boolean setSize(int aSize) {
    return opensimModelJNI.SetSimmMusclePoint_setSize(swigCPtr, aSize);
  }

  public int getSize() {
    return opensimModelJNI.SetSimmMusclePoint_getSize(swigCPtr);
  }

  public int getIndex(SimmMusclePoint aObject, int aStartIndex) {
    return opensimModelJNI.SetSimmMusclePoint_getIndex__SWIG_0(swigCPtr, SimmMusclePoint.getCPtr(aObject), aStartIndex);
  }

  public int getIndex(SimmMusclePoint aObject) {
    return opensimModelJNI.SetSimmMusclePoint_getIndex__SWIG_1(swigCPtr, SimmMusclePoint.getCPtr(aObject));
  }

  public int getIndex(String aName, int aStartIndex) {
    return opensimModelJNI.SetSimmMusclePoint_getIndex__SWIG_2(swigCPtr, aName, aStartIndex);
  }

  public int getIndex(String aName) {
    return opensimModelJNI.SetSimmMusclePoint_getIndex__SWIG_3(swigCPtr, aName);
  }

  public boolean append(SimmMusclePoint aObject) {
    return opensimModelJNI.SetSimmMusclePoint_append__SWIG_0(swigCPtr, SimmMusclePoint.getCPtr(aObject));
  }

  public boolean append(SWIGTYPE_p_OpenSim__ArrayPtrsTOpenSim__SimmMusclePoint_t aArray) {
    return opensimModelJNI.SetSimmMusclePoint_append__SWIG_1(swigCPtr, SWIGTYPE_p_OpenSim__ArrayPtrsTOpenSim__SimmMusclePoint_t.getCPtr(aArray));
  }

  public boolean insert(int aIndex, SimmMusclePoint aObject) {
    return opensimModelJNI.SetSimmMusclePoint_insert(swigCPtr, aIndex, SimmMusclePoint.getCPtr(aObject));
  }

  public boolean remove(int aIndex) {
    return opensimModelJNI.SetSimmMusclePoint_remove__SWIG_0(swigCPtr, aIndex);
  }

  public boolean remove(SimmMusclePoint aObject) {
    return opensimModelJNI.SetSimmMusclePoint_remove__SWIG_1(swigCPtr, SimmMusclePoint.getCPtr(aObject));
  }

  public boolean set(int aIndex, SimmMusclePoint aObject) {
    return opensimModelJNI.SetSimmMusclePoint_set(swigCPtr, aIndex, SimmMusclePoint.getCPtr(aObject));
  }

  public SimmMusclePoint get(int aIndex) {
    long cPtr = opensimModelJNI.SetSimmMusclePoint_get__SWIG_0(swigCPtr, aIndex);
    return (cPtr == 0) ? null : new SimmMusclePoint(cPtr, false);
  }

  public SimmMusclePoint get(String aName) {
    long cPtr = opensimModelJNI.SetSimmMusclePoint_get__SWIG_1(swigCPtr, aName);
    return (cPtr == 0) ? null : new SimmMusclePoint(cPtr, false);
  }

  public SimmMusclePoint getLast() {
    long cPtr = opensimModelJNI.SetSimmMusclePoint_getLast(swigCPtr);
    return (cPtr == 0) ? null : new SimmMusclePoint(cPtr, false);
  }

  public int searchBinary(SimmMusclePoint aObject, boolean aFindFirst, int aLo, int aHi) {
    return opensimModelJNI.SetSimmMusclePoint_searchBinary__SWIG_0(swigCPtr, SimmMusclePoint.getCPtr(aObject), aFindFirst, aLo, aHi);
  }

  public int searchBinary(SimmMusclePoint aObject, boolean aFindFirst, int aLo) {
    return opensimModelJNI.SetSimmMusclePoint_searchBinary__SWIG_1(swigCPtr, SimmMusclePoint.getCPtr(aObject), aFindFirst, aLo);
  }

  public int searchBinary(SimmMusclePoint aObject, boolean aFindFirst) {
    return opensimModelJNI.SetSimmMusclePoint_searchBinary__SWIG_2(swigCPtr, SimmMusclePoint.getCPtr(aObject), aFindFirst);
  }

  public int searchBinary(SimmMusclePoint aObject) {
    return opensimModelJNI.SetSimmMusclePoint_searchBinary__SWIG_3(swigCPtr, SimmMusclePoint.getCPtr(aObject));
  }

}
