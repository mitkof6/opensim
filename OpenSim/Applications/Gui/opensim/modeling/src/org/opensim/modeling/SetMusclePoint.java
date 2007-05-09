/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.31
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.opensim.modeling;

public class SetMusclePoint extends OpenSimObject {
  private long swigCPtr;

  public SetMusclePoint(long cPtr, boolean cMemoryOwn) {
    super(opensimModelJNI.SWIGStorageUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  public static long getCPtr(SetMusclePoint obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if(swigCPtr != 0 && swigCMemOwn) {
      swigCMemOwn = false;
      opensimModelJNI.delete_SetMusclePoint(swigCPtr);
    }
    swigCPtr = 0;
    super.delete();
  }

  public SetMusclePoint() {
    this(opensimModelJNI.new_SetMusclePoint__SWIG_0(), true);
  }

  public SetMusclePoint(String aFileName, boolean aUpdateFromXMLNode) {
    this(opensimModelJNI.new_SetMusclePoint__SWIG_1(aFileName, aUpdateFromXMLNode), true);
  }

  public SetMusclePoint(String aFileName) {
    this(opensimModelJNI.new_SetMusclePoint__SWIG_2(aFileName), true);
  }

  public SetMusclePoint(SetMusclePoint aSet) {
    this(opensimModelJNI.new_SetMusclePoint__SWIG_3(SetMusclePoint.getCPtr(aSet), aSet), true);
  }

  public OpenSimObject copy() {
    long cPtr = opensimModelJNI.SetMusclePoint_copy(swigCPtr, this);
    return (cPtr == 0) ? null : new OpenSimObject(cPtr, false);
  }

  public void setup() {
    opensimModelJNI.SetMusclePoint_setup(swigCPtr, this);
  }

  public void setMemoryOwner(boolean aTrueFalse) {
    opensimModelJNI.SetMusclePoint_setMemoryOwner(swigCPtr, this, aTrueFalse);
  }

  public boolean getMemoryOwner() {
    return opensimModelJNI.SetMusclePoint_getMemoryOwner(swigCPtr, this);
  }

  public boolean computeNewCapacity(int aMinCapacity, SWIGTYPE_p_int rNewCapacity) {
    return opensimModelJNI.SetMusclePoint_computeNewCapacity(swigCPtr, this, aMinCapacity, SWIGTYPE_p_int.getCPtr(rNewCapacity));
  }

  public boolean ensureCapacity(int aCapacity) {
    return opensimModelJNI.SetMusclePoint_ensureCapacity(swigCPtr, this, aCapacity);
  }

  public void trim() {
    opensimModelJNI.SetMusclePoint_trim(swigCPtr, this);
  }

  public int getCapacity() {
    return opensimModelJNI.SetMusclePoint_getCapacity(swigCPtr, this);
  }

  public void setCapacityIncrement(int aIncrement) {
    opensimModelJNI.SetMusclePoint_setCapacityIncrement(swigCPtr, this, aIncrement);
  }

  public int getCapacityIncrement() {
    return opensimModelJNI.SetMusclePoint_getCapacityIncrement(swigCPtr, this);
  }

  public boolean setSize(int aSize) {
    return opensimModelJNI.SetMusclePoint_setSize(swigCPtr, this, aSize);
  }

  public int getSize() {
    return opensimModelJNI.SetMusclePoint_getSize(swigCPtr, this);
  }

  public int getIndex(MusclePoint aObject, int aStartIndex) {
    return opensimModelJNI.SetMusclePoint_getIndex__SWIG_0(swigCPtr, this, MusclePoint.getCPtr(aObject), aObject, aStartIndex);
  }

  public int getIndex(MusclePoint aObject) {
    return opensimModelJNI.SetMusclePoint_getIndex__SWIG_1(swigCPtr, this, MusclePoint.getCPtr(aObject), aObject);
  }

  public int getIndex(String aName, int aStartIndex) {
    return opensimModelJNI.SetMusclePoint_getIndex__SWIG_2(swigCPtr, this, aName, aStartIndex);
  }

  public int getIndex(String aName) {
    return opensimModelJNI.SetMusclePoint_getIndex__SWIG_3(swigCPtr, this, aName);
  }

  public void getGroupNamesContaining(String aObjectName, ArrayStr rGroupNames) {
    opensimModelJNI.SetMusclePoint_getGroupNamesContaining(swigCPtr, this, aObjectName, ArrayStr.getCPtr(rGroupNames), rGroupNames);
  }

  public boolean append(MusclePoint aObject) {
    return opensimModelJNI.SetMusclePoint_append__SWIG_0(swigCPtr, this, MusclePoint.getCPtr(aObject), aObject);
  }

  public boolean append(SWIGTYPE_p_OpenSim__ArrayPtrsTOpenSim__MusclePoint_t aArray) {
    return opensimModelJNI.SetMusclePoint_append__SWIG_1(swigCPtr, this, SWIGTYPE_p_OpenSim__ArrayPtrsTOpenSim__MusclePoint_t.getCPtr(aArray));
  }

  public boolean insert(int aIndex, MusclePoint aObject) {
    return opensimModelJNI.SetMusclePoint_insert(swigCPtr, this, aIndex, MusclePoint.getCPtr(aObject), aObject);
  }

  public boolean remove(int aIndex) {
    return opensimModelJNI.SetMusclePoint_remove__SWIG_0(swigCPtr, this, aIndex);
  }

  public boolean remove(MusclePoint aObject) {
    return opensimModelJNI.SetMusclePoint_remove__SWIG_1(swigCPtr, this, MusclePoint.getCPtr(aObject), aObject);
  }

  public void clearAndDestroy() {
    opensimModelJNI.SetMusclePoint_clearAndDestroy(swigCPtr, this);
  }

  public boolean set(int aIndex, MusclePoint aObject) {
    return opensimModelJNI.SetMusclePoint_set(swigCPtr, this, aIndex, MusclePoint.getCPtr(aObject), aObject);
  }

  public MusclePoint get(int aIndex) {
    long cPtr = opensimModelJNI.SetMusclePoint_get__SWIG_0(swigCPtr, this, aIndex);
    return (cPtr == 0) ? null : new MusclePoint(cPtr, false);
  }

  public MusclePoint get(String aName) {
    long cPtr = opensimModelJNI.SetMusclePoint_get__SWIG_1(swigCPtr, this, aName);
    return (cPtr == 0) ? null : new MusclePoint(cPtr, false);
  }

  public void getNames(ArrayStr rNames) {
    opensimModelJNI.SetMusclePoint_getNames(swigCPtr, this, ArrayStr.getCPtr(rNames), rNames);
  }

  public MusclePoint getLast() {
    long cPtr = opensimModelJNI.SetMusclePoint_getLast(swigCPtr, this);
    return (cPtr == 0) ? null : new MusclePoint(cPtr, false);
  }

  public int searchBinary(MusclePoint aObject, boolean aFindFirst, int aLo, int aHi) {
    return opensimModelJNI.SetMusclePoint_searchBinary__SWIG_0(swigCPtr, this, MusclePoint.getCPtr(aObject), aObject, aFindFirst, aLo, aHi);
  }

  public int searchBinary(MusclePoint aObject, boolean aFindFirst, int aLo) {
    return opensimModelJNI.SetMusclePoint_searchBinary__SWIG_1(swigCPtr, this, MusclePoint.getCPtr(aObject), aObject, aFindFirst, aLo);
  }

  public int searchBinary(MusclePoint aObject, boolean aFindFirst) {
    return opensimModelJNI.SetMusclePoint_searchBinary__SWIG_2(swigCPtr, this, MusclePoint.getCPtr(aObject), aObject, aFindFirst);
  }

  public int searchBinary(MusclePoint aObject) {
    return opensimModelJNI.SetMusclePoint_searchBinary__SWIG_3(swigCPtr, this, MusclePoint.getCPtr(aObject), aObject);
  }

  public void addGroup(SWIGTYPE_p_std__string aGroupName) {
    opensimModelJNI.SetMusclePoint_addGroup(swigCPtr, this, SWIGTYPE_p_std__string.getCPtr(aGroupName));
  }

  public void addObjectToGroup(SWIGTYPE_p_std__string aGroupName, SWIGTYPE_p_std__string aObjectName) {
    opensimModelJNI.SetMusclePoint_addObjectToGroup(swigCPtr, this, SWIGTYPE_p_std__string.getCPtr(aGroupName), SWIGTYPE_p_std__string.getCPtr(aObjectName));
  }

}
