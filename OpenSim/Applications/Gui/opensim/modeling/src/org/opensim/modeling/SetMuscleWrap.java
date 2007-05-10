/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.31
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.opensim.modeling;

public class SetMuscleWrap extends OpenSimObject {
  private long swigCPtr;

  public SetMuscleWrap(long cPtr, boolean cMemoryOwn) {
    super(opensimModelJNI.SWIGStorageUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  public static long getCPtr(SetMuscleWrap obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if(swigCPtr != 0 && swigCMemOwn) {
      swigCMemOwn = false;
      opensimModelJNI.delete_SetMuscleWrap(swigCPtr);
    }
    swigCPtr = 0;
    super.delete();
  }

  public SetMuscleWrap() {
    this(opensimModelJNI.new_SetMuscleWrap__SWIG_0(), true);
  }

  public SetMuscleWrap(String aFileName, boolean aUpdateFromXMLNode) {
    this(opensimModelJNI.new_SetMuscleWrap__SWIG_1(aFileName, aUpdateFromXMLNode), true);
  }

  public SetMuscleWrap(String aFileName) {
    this(opensimModelJNI.new_SetMuscleWrap__SWIG_2(aFileName), true);
  }

  public SetMuscleWrap(SetMuscleWrap aSet) {
    this(opensimModelJNI.new_SetMuscleWrap__SWIG_3(SetMuscleWrap.getCPtr(aSet), aSet), true);
  }

  public OpenSimObject copy() {
    long cPtr = opensimModelJNI.SetMuscleWrap_copy(swigCPtr, this);
    return (cPtr == 0) ? null : new OpenSimObject(cPtr, false);
  }

  public void setup() {
    opensimModelJNI.SetMuscleWrap_setup(swigCPtr, this);
  }

  public void setMemoryOwner(boolean aTrueFalse) {
    opensimModelJNI.SetMuscleWrap_setMemoryOwner(swigCPtr, this, aTrueFalse);
  }

  public boolean getMemoryOwner() {
    return opensimModelJNI.SetMuscleWrap_getMemoryOwner(swigCPtr, this);
  }

  public boolean computeNewCapacity(int aMinCapacity, SWIGTYPE_p_int rNewCapacity) {
    return opensimModelJNI.SetMuscleWrap_computeNewCapacity(swigCPtr, this, aMinCapacity, SWIGTYPE_p_int.getCPtr(rNewCapacity));
  }

  public boolean ensureCapacity(int aCapacity) {
    return opensimModelJNI.SetMuscleWrap_ensureCapacity(swigCPtr, this, aCapacity);
  }

  public void trim() {
    opensimModelJNI.SetMuscleWrap_trim(swigCPtr, this);
  }

  public int getCapacity() {
    return opensimModelJNI.SetMuscleWrap_getCapacity(swigCPtr, this);
  }

  public void setCapacityIncrement(int aIncrement) {
    opensimModelJNI.SetMuscleWrap_setCapacityIncrement(swigCPtr, this, aIncrement);
  }

  public int getCapacityIncrement() {
    return opensimModelJNI.SetMuscleWrap_getCapacityIncrement(swigCPtr, this);
  }

  public boolean setSize(int aSize) {
    return opensimModelJNI.SetMuscleWrap_setSize(swigCPtr, this, aSize);
  }

  public int getSize() {
    return opensimModelJNI.SetMuscleWrap_getSize(swigCPtr, this);
  }

  public int getIndex(MuscleWrap aObject, int aStartIndex) {
    return opensimModelJNI.SetMuscleWrap_getIndex__SWIG_0(swigCPtr, this, MuscleWrap.getCPtr(aObject), aObject, aStartIndex);
  }

  public int getIndex(MuscleWrap aObject) {
    return opensimModelJNI.SetMuscleWrap_getIndex__SWIG_1(swigCPtr, this, MuscleWrap.getCPtr(aObject), aObject);
  }

  public int getIndex(String aName, int aStartIndex) {
    return opensimModelJNI.SetMuscleWrap_getIndex__SWIG_2(swigCPtr, this, aName, aStartIndex);
  }

  public int getIndex(String aName) {
    return opensimModelJNI.SetMuscleWrap_getIndex__SWIG_3(swigCPtr, this, aName);
  }

  public void getGroupNamesContaining(String aObjectName, ArrayStr rGroupNames) {
    opensimModelJNI.SetMuscleWrap_getGroupNamesContaining(swigCPtr, this, aObjectName, ArrayStr.getCPtr(rGroupNames), rGroupNames);
  }

  public boolean append(MuscleWrap aObject) {
    return opensimModelJNI.SetMuscleWrap_append__SWIG_0(swigCPtr, this, MuscleWrap.getCPtr(aObject), aObject);
  }

  public boolean append(SWIGTYPE_p_OpenSim__ArrayPtrsTOpenSim__MuscleWrap_t aArray) {
    return opensimModelJNI.SetMuscleWrap_append__SWIG_1(swigCPtr, this, SWIGTYPE_p_OpenSim__ArrayPtrsTOpenSim__MuscleWrap_t.getCPtr(aArray));
  }

  public boolean insert(int aIndex, MuscleWrap aObject) {
    return opensimModelJNI.SetMuscleWrap_insert(swigCPtr, this, aIndex, MuscleWrap.getCPtr(aObject), aObject);
  }

  public boolean remove(int aIndex) {
    return opensimModelJNI.SetMuscleWrap_remove__SWIG_0(swigCPtr, this, aIndex);
  }

  public boolean remove(MuscleWrap aObject) {
    return opensimModelJNI.SetMuscleWrap_remove__SWIG_1(swigCPtr, this, MuscleWrap.getCPtr(aObject), aObject);
  }

  public void clearAndDestroy() {
    opensimModelJNI.SetMuscleWrap_clearAndDestroy(swigCPtr, this);
  }

  public boolean set(int aIndex, MuscleWrap aObject) {
    return opensimModelJNI.SetMuscleWrap_set(swigCPtr, this, aIndex, MuscleWrap.getCPtr(aObject), aObject);
  }

  public MuscleWrap get(int aIndex) {
    long cPtr = opensimModelJNI.SetMuscleWrap_get__SWIG_0(swigCPtr, this, aIndex);
    return (cPtr == 0) ? null : new MuscleWrap(cPtr, false);
  }

  public MuscleWrap get(String aName) {
    long cPtr = opensimModelJNI.SetMuscleWrap_get__SWIG_1(swigCPtr, this, aName);
    return (cPtr == 0) ? null : new MuscleWrap(cPtr, false);
  }

  public void getNames(ArrayStr rNames) {
    opensimModelJNI.SetMuscleWrap_getNames(swigCPtr, this, ArrayStr.getCPtr(rNames), rNames);
  }

  public MuscleWrap getLast() {
    long cPtr = opensimModelJNI.SetMuscleWrap_getLast(swigCPtr, this);
    return (cPtr == 0) ? null : new MuscleWrap(cPtr, false);
  }

  public int searchBinary(MuscleWrap aObject, boolean aFindFirst, int aLo, int aHi) {
    return opensimModelJNI.SetMuscleWrap_searchBinary__SWIG_0(swigCPtr, this, MuscleWrap.getCPtr(aObject), aObject, aFindFirst, aLo, aHi);
  }

  public int searchBinary(MuscleWrap aObject, boolean aFindFirst, int aLo) {
    return opensimModelJNI.SetMuscleWrap_searchBinary__SWIG_1(swigCPtr, this, MuscleWrap.getCPtr(aObject), aObject, aFindFirst, aLo);
  }

  public int searchBinary(MuscleWrap aObject, boolean aFindFirst) {
    return opensimModelJNI.SetMuscleWrap_searchBinary__SWIG_2(swigCPtr, this, MuscleWrap.getCPtr(aObject), aObject, aFindFirst);
  }

  public int searchBinary(MuscleWrap aObject) {
    return opensimModelJNI.SetMuscleWrap_searchBinary__SWIG_3(swigCPtr, this, MuscleWrap.getCPtr(aObject), aObject);
  }

  public void addGroup(SWIGTYPE_p_std__string aGroupName) {
    opensimModelJNI.SetMuscleWrap_addGroup(swigCPtr, this, SWIGTYPE_p_std__string.getCPtr(aGroupName));
  }

  public void addObjectToGroup(SWIGTYPE_p_std__string aGroupName, SWIGTYPE_p_std__string aObjectName) {
    opensimModelJNI.SetMuscleWrap_addObjectToGroup(swigCPtr, this, SWIGTYPE_p_std__string.getCPtr(aGroupName), SWIGTYPE_p_std__string.getCPtr(aObjectName));
  }

  public void getGroupNames(ArrayStr rGroupNames) {
    opensimModelJNI.SetMuscleWrap_getGroupNames(swigCPtr, this, ArrayStr.getCPtr(rGroupNames), rGroupNames);
  }

  public ObjectGroup getObjectGroup(String aGroupName) {
    long cPtr = opensimModelJNI.SetMuscleWrap_getObjectGroup(swigCPtr, this, aGroupName);
    return (cPtr == 0) ? null : new ObjectGroup(cPtr, false);
  }

}
