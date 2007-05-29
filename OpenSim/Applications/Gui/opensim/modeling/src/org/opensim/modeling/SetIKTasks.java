/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.31
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.opensim.modeling;

public class SetIKTasks extends OpenSimObject {
  private long swigCPtr;

  public SetIKTasks(long cPtr, boolean cMemoryOwn) {
    super(opensimModelJNI.SWIGStorageUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  public static long getCPtr(SetIKTasks obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if(swigCPtr != 0 && swigCMemOwn) {
      swigCMemOwn = false;
      opensimModelJNI.delete_SetIKTasks(swigCPtr);
    }
    swigCPtr = 0;
    super.delete();
  }

  public SetIKTasks() {
    this(opensimModelJNI.new_SetIKTasks__SWIG_0(), true);
  }

  public SetIKTasks(String aFileName, boolean aUpdateFromXMLNode) {
    this(opensimModelJNI.new_SetIKTasks__SWIG_1(aFileName, aUpdateFromXMLNode), true);
  }

  public SetIKTasks(String aFileName) {
    this(opensimModelJNI.new_SetIKTasks__SWIG_2(aFileName), true);
  }

  public SetIKTasks(SetIKTasks aSet) {
    this(opensimModelJNI.new_SetIKTasks__SWIG_3(SetIKTasks.getCPtr(aSet), aSet), true);
  }

  public OpenSimObject copy() {
    long cPtr = opensimModelJNI.SetIKTasks_copy(swigCPtr, this);
    return (cPtr == 0) ? null : new OpenSimObject(cPtr, false);
  }

  public void setup() {
    opensimModelJNI.SetIKTasks_setup(swigCPtr, this);
  }

  public void setMemoryOwner(boolean aTrueFalse) {
    opensimModelJNI.SetIKTasks_setMemoryOwner(swigCPtr, this, aTrueFalse);
  }

  public boolean getMemoryOwner() {
    return opensimModelJNI.SetIKTasks_getMemoryOwner(swigCPtr, this);
  }

  public boolean computeNewCapacity(int aMinCapacity, SWIGTYPE_p_int rNewCapacity) {
    return opensimModelJNI.SetIKTasks_computeNewCapacity(swigCPtr, this, aMinCapacity, SWIGTYPE_p_int.getCPtr(rNewCapacity));
  }

  public boolean ensureCapacity(int aCapacity) {
    return opensimModelJNI.SetIKTasks_ensureCapacity(swigCPtr, this, aCapacity);
  }

  public void trim() {
    opensimModelJNI.SetIKTasks_trim(swigCPtr, this);
  }

  public int getCapacity() {
    return opensimModelJNI.SetIKTasks_getCapacity(swigCPtr, this);
  }

  public void setCapacityIncrement(int aIncrement) {
    opensimModelJNI.SetIKTasks_setCapacityIncrement(swigCPtr, this, aIncrement);
  }

  public int getCapacityIncrement() {
    return opensimModelJNI.SetIKTasks_getCapacityIncrement(swigCPtr, this);
  }

  public boolean setSize(int aSize) {
    return opensimModelJNI.SetIKTasks_setSize(swigCPtr, this, aSize);
  }

  public int getSize() {
    return opensimModelJNI.SetIKTasks_getSize(swigCPtr, this);
  }

  public int getIndex(IKTask aObject, int aStartIndex) {
    return opensimModelJNI.SetIKTasks_getIndex__SWIG_0(swigCPtr, this, IKTask.getCPtr(aObject), aObject, aStartIndex);
  }

  public int getIndex(IKTask aObject) {
    return opensimModelJNI.SetIKTasks_getIndex__SWIG_1(swigCPtr, this, IKTask.getCPtr(aObject), aObject);
  }

  public int getIndex(String aName, int aStartIndex) {
    return opensimModelJNI.SetIKTasks_getIndex__SWIG_2(swigCPtr, this, aName, aStartIndex);
  }

  public int getIndex(String aName) {
    return opensimModelJNI.SetIKTasks_getIndex__SWIG_3(swigCPtr, this, aName);
  }

  public void getGroupNamesContaining(String aObjectName, ArrayStr rGroupNames) {
    opensimModelJNI.SetIKTasks_getGroupNamesContaining(swigCPtr, this, aObjectName, ArrayStr.getCPtr(rGroupNames), rGroupNames);
  }

  public boolean append(IKTask aObject) {
    return opensimModelJNI.SetIKTasks_append__SWIG_0(swigCPtr, this, IKTask.getCPtr(aObject), aObject);
  }

  public boolean append(SWIGTYPE_p_OpenSim__ArrayPtrsTOpenSim__IKTask_t aArray) {
    return opensimModelJNI.SetIKTasks_append__SWIG_1(swigCPtr, this, SWIGTYPE_p_OpenSim__ArrayPtrsTOpenSim__IKTask_t.getCPtr(aArray));
  }

  public boolean insert(int aIndex, IKTask aObject) {
    return opensimModelJNI.SetIKTasks_insert(swigCPtr, this, aIndex, IKTask.getCPtr(aObject), aObject);
  }

  public boolean remove(int aIndex) {
    return opensimModelJNI.SetIKTasks_remove__SWIG_0(swigCPtr, this, aIndex);
  }

  public boolean remove(IKTask aObject) {
    return opensimModelJNI.SetIKTasks_remove__SWIG_1(swigCPtr, this, IKTask.getCPtr(aObject), aObject);
  }

  public void clearAndDestroy() {
    opensimModelJNI.SetIKTasks_clearAndDestroy(swigCPtr, this);
  }

  public boolean set(int aIndex, IKTask aObject) {
    return opensimModelJNI.SetIKTasks_set(swigCPtr, this, aIndex, IKTask.getCPtr(aObject), aObject);
  }

  public IKTask get(int aIndex) {
    long cPtr = opensimModelJNI.SetIKTasks_get__SWIG_0(swigCPtr, this, aIndex);
    return (cPtr == 0) ? null : new IKTask(cPtr, false);
  }

  public IKTask get(String aName) {
    long cPtr = opensimModelJNI.SetIKTasks_get__SWIG_1(swigCPtr, this, aName);
    return (cPtr == 0) ? null : new IKTask(cPtr, false);
  }

  public void getNames(ArrayStr rNames) {
    opensimModelJNI.SetIKTasks_getNames(swigCPtr, this, ArrayStr.getCPtr(rNames), rNames);
  }

  public IKTask getLast() {
    long cPtr = opensimModelJNI.SetIKTasks_getLast(swigCPtr, this);
    return (cPtr == 0) ? null : new IKTask(cPtr, false);
  }

  public int searchBinary(IKTask aObject, boolean aFindFirst, int aLo, int aHi) {
    return opensimModelJNI.SetIKTasks_searchBinary__SWIG_0(swigCPtr, this, IKTask.getCPtr(aObject), aObject, aFindFirst, aLo, aHi);
  }

  public int searchBinary(IKTask aObject, boolean aFindFirst, int aLo) {
    return opensimModelJNI.SetIKTasks_searchBinary__SWIG_1(swigCPtr, this, IKTask.getCPtr(aObject), aObject, aFindFirst, aLo);
  }

  public int searchBinary(IKTask aObject, boolean aFindFirst) {
    return opensimModelJNI.SetIKTasks_searchBinary__SWIG_2(swigCPtr, this, IKTask.getCPtr(aObject), aObject, aFindFirst);
  }

  public int searchBinary(IKTask aObject) {
    return opensimModelJNI.SetIKTasks_searchBinary__SWIG_3(swigCPtr, this, IKTask.getCPtr(aObject), aObject);
  }

  public int getNumGroups() {
    return opensimModelJNI.SetIKTasks_getNumGroups(swigCPtr, this);
  }

  public void addGroup(String aGroupName) {
    opensimModelJNI.SetIKTasks_addGroup(swigCPtr, this, aGroupName);
  }

  public void removeGroup(String aGroupName) {
    opensimModelJNI.SetIKTasks_removeGroup(swigCPtr, this, aGroupName);
  }

  public void renameGroup(String oldGroupName, String newGroupName) {
    opensimModelJNI.SetIKTasks_renameGroup(swigCPtr, this, oldGroupName, newGroupName);
  }

  public void addObjectToGroup(String aGroupName, String aObjectName) {
    opensimModelJNI.SetIKTasks_addObjectToGroup(swigCPtr, this, aGroupName, aObjectName);
  }

  public void getGroupNames(ArrayStr rGroupNames) {
    opensimModelJNI.SetIKTasks_getGroupNames(swigCPtr, this, ArrayStr.getCPtr(rGroupNames), rGroupNames);
  }

  public ObjectGroup getGroup(String aGroupName) {
    long cPtr = opensimModelJNI.SetIKTasks_getGroup__SWIG_0(swigCPtr, this, aGroupName);
    return (cPtr == 0) ? null : new ObjectGroup(cPtr, false);
  }

  public ObjectGroup getGroup(int aIndex) {
    long cPtr = opensimModelJNI.SetIKTasks_getGroup__SWIG_1(swigCPtr, this, aIndex);
    return (cPtr == 0) ? null : new ObjectGroup(cPtr, false);
  }

}
