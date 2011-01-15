/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.37
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.opensim.modeling;

public class SetPathWrap extends OpenSimObject {
  private long swigCPtr;

  public SetPathWrap(long cPtr, boolean cMemoryOwn) {
    super(opensimModelJNI.SWIGStorageUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  public static long getCPtr(SetPathWrap obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if(swigCPtr != 0 && swigCMemOwn) {
      swigCMemOwn = false;
      opensimModelJNI.delete_SetPathWrap(swigCPtr);
    }
    swigCPtr = 0;
    super.delete();
  }

  public SetPathWrap() {
    this(opensimModelJNI.new_SetPathWrap__SWIG_0(), true);
  }

  public SetPathWrap(String aFileName, boolean aUpdateFromXMLNode) {
    this(opensimModelJNI.new_SetPathWrap__SWIG_1(aFileName, aUpdateFromXMLNode), true);
  }

  public SetPathWrap(String aFileName) {
    this(opensimModelJNI.new_SetPathWrap__SWIG_2(aFileName), true);
  }

  public SetPathWrap(SetPathWrap aSet) {
    this(opensimModelJNI.new_SetPathWrap__SWIG_3(SetPathWrap.getCPtr(aSet), aSet), true);
  }

  public OpenSimObject copy() {
    long cPtr = opensimModelJNI.SetPathWrap_copy(swigCPtr, this);
    return (cPtr == 0) ? null : new OpenSimObject(cPtr, false);
  }

  public void setup() {
    opensimModelJNI.SetPathWrap_setup(swigCPtr, this);
  }

  public void setMemoryOwner(boolean aTrueFalse) {
    opensimModelJNI.SetPathWrap_setMemoryOwner(swigCPtr, this, aTrueFalse);
  }

  public boolean getMemoryOwner() {
    return opensimModelJNI.SetPathWrap_getMemoryOwner(swigCPtr, this);
  }

  public boolean computeNewCapacity(int aMinCapacity, SWIGTYPE_p_int rNewCapacity) {
    return opensimModelJNI.SetPathWrap_computeNewCapacity(swigCPtr, this, aMinCapacity, SWIGTYPE_p_int.getCPtr(rNewCapacity));
  }

  public boolean ensureCapacity(int aCapacity) {
    return opensimModelJNI.SetPathWrap_ensureCapacity(swigCPtr, this, aCapacity);
  }

  public void trim() {
    opensimModelJNI.SetPathWrap_trim(swigCPtr, this);
  }

  public int getCapacity() {
    return opensimModelJNI.SetPathWrap_getCapacity(swigCPtr, this);
  }

  public void setCapacityIncrement(int aIncrement) {
    opensimModelJNI.SetPathWrap_setCapacityIncrement(swigCPtr, this, aIncrement);
  }

  public int getCapacityIncrement() {
    return opensimModelJNI.SetPathWrap_getCapacityIncrement(swigCPtr, this);
  }

  public boolean setSize(int aSize) {
    return opensimModelJNI.SetPathWrap_setSize(swigCPtr, this, aSize);
  }

  public int getSize() {
    return opensimModelJNI.SetPathWrap_getSize(swigCPtr, this);
  }

  public int getIndex(PathWrap aObject, int aStartIndex) {
    return opensimModelJNI.SetPathWrap_getIndex__SWIG_0(swigCPtr, this, PathWrap.getCPtr(aObject), aObject, aStartIndex);
  }

  public int getIndex(PathWrap aObject) {
    return opensimModelJNI.SetPathWrap_getIndex__SWIG_1(swigCPtr, this, PathWrap.getCPtr(aObject), aObject);
  }

  public int getIndex(String aName, int aStartIndex) {
    return opensimModelJNI.SetPathWrap_getIndex__SWIG_2(swigCPtr, this, aName, aStartIndex);
  }

  public int getIndex(String aName) {
    return opensimModelJNI.SetPathWrap_getIndex__SWIG_3(swigCPtr, this, aName);
  }

  public void getGroupNamesContaining(String aObjectName, ArrayStr rGroupNames) {
    opensimModelJNI.SetPathWrap_getGroupNamesContaining(swigCPtr, this, aObjectName, ArrayStr.getCPtr(rGroupNames), rGroupNames);
  }

  public boolean append(PathWrap aObject) {
    return opensimModelJNI.SetPathWrap_append(swigCPtr, this, PathWrap.getCPtr(aObject), aObject);
  }

  public boolean insert(int aIndex, PathWrap aObject) {
    return opensimModelJNI.SetPathWrap_insert(swigCPtr, this, aIndex, PathWrap.getCPtr(aObject), aObject);
  }

  public boolean remove(int aIndex) {
    return opensimModelJNI.SetPathWrap_remove__SWIG_0(swigCPtr, this, aIndex);
  }

  public boolean remove(PathWrap aObject) {
    return opensimModelJNI.SetPathWrap_remove__SWIG_1(swigCPtr, this, PathWrap.getCPtr(aObject), aObject);
  }

  public void clearAndDestroy() {
    opensimModelJNI.SetPathWrap_clearAndDestroy(swigCPtr, this);
  }

  public boolean set(int aIndex, PathWrap aObject, boolean preserveGroups) {
    return opensimModelJNI.SetPathWrap_set__SWIG_0(swigCPtr, this, aIndex, PathWrap.getCPtr(aObject), aObject, preserveGroups);
  }

  public boolean set(int aIndex, PathWrap aObject) {
    return opensimModelJNI.SetPathWrap_set__SWIG_1(swigCPtr, this, aIndex, PathWrap.getCPtr(aObject), aObject);
  }

  public PathWrap get(int aIndex) {
    return new PathWrap(opensimModelJNI.SetPathWrap_get__SWIG_0(swigCPtr, this, aIndex), false);
  }

  public PathWrap get(String aName) {
    return new PathWrap(opensimModelJNI.SetPathWrap_get__SWIG_1(swigCPtr, this, aName), false);
  }

  public boolean contains(String aName) {
    return opensimModelJNI.SetPathWrap_contains(swigCPtr, this, aName);
  }

  public void getNames(ArrayStr rNames) {
    opensimModelJNI.SetPathWrap_getNames(swigCPtr, this, ArrayStr.getCPtr(rNames), rNames);
  }

  public PathWrap getLast() {
    long cPtr = opensimModelJNI.SetPathWrap_getLast(swigCPtr, this);
    return (cPtr == 0) ? null : new PathWrap(cPtr, false);
  }

  public int searchBinary(PathWrap aObject, boolean aFindFirst, int aLo, int aHi) {
    return opensimModelJNI.SetPathWrap_searchBinary__SWIG_0(swigCPtr, this, PathWrap.getCPtr(aObject), aObject, aFindFirst, aLo, aHi);
  }

  public int searchBinary(PathWrap aObject, boolean aFindFirst, int aLo) {
    return opensimModelJNI.SetPathWrap_searchBinary__SWIG_1(swigCPtr, this, PathWrap.getCPtr(aObject), aObject, aFindFirst, aLo);
  }

  public int searchBinary(PathWrap aObject, boolean aFindFirst) {
    return opensimModelJNI.SetPathWrap_searchBinary__SWIG_2(swigCPtr, this, PathWrap.getCPtr(aObject), aObject, aFindFirst);
  }

  public int searchBinary(PathWrap aObject) {
    return opensimModelJNI.SetPathWrap_searchBinary__SWIG_3(swigCPtr, this, PathWrap.getCPtr(aObject), aObject);
  }

  public int getNumGroups() {
    return opensimModelJNI.SetPathWrap_getNumGroups(swigCPtr, this);
  }

  public void addGroup(String aGroupName) {
    opensimModelJNI.SetPathWrap_addGroup(swigCPtr, this, aGroupName);
  }

  public void removeGroup(String aGroupName) {
    opensimModelJNI.SetPathWrap_removeGroup(swigCPtr, this, aGroupName);
  }

  public void renameGroup(String oldGroupName, String newGroupName) {
    opensimModelJNI.SetPathWrap_renameGroup(swigCPtr, this, oldGroupName, newGroupName);
  }

  public void addObjectToGroup(String aGroupName, String aObjectName) {
    opensimModelJNI.SetPathWrap_addObjectToGroup(swigCPtr, this, aGroupName, aObjectName);
  }

  public void getGroupNames(ArrayStr rGroupNames) {
    opensimModelJNI.SetPathWrap_getGroupNames(swigCPtr, this, ArrayStr.getCPtr(rGroupNames), rGroupNames);
  }

  public ObjectGroup getGroup(String aGroupName) {
    long cPtr = opensimModelJNI.SetPathWrap_getGroup__SWIG_0(swigCPtr, this, aGroupName);
    return (cPtr == 0) ? null : new ObjectGroup(cPtr, false);
  }

  public ObjectGroup getGroup(int aIndex) {
    long cPtr = opensimModelJNI.SetPathWrap_getGroup__SWIG_1(swigCPtr, this, aIndex);
    return (cPtr == 0) ? null : new ObjectGroup(cPtr, false);
  }

}
