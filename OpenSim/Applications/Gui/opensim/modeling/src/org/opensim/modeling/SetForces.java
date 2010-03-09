/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.31
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.opensim.modeling;

public class SetForces extends OpenSimObject {
  private long swigCPtr;

  public SetForces(long cPtr, boolean cMemoryOwn) {
    super(opensimModelJNI.SWIGStorageUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  public static long getCPtr(SetForces obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if(swigCPtr != 0 && swigCMemOwn) {
      swigCMemOwn = false;
      opensimModelJNI.delete_SetForces(swigCPtr);
    }
    swigCPtr = 0;
    super.delete();
  }

  public SetForces() {
    this(opensimModelJNI.new_SetForces__SWIG_0(), true);
  }

  public SetForces(String aFileName, boolean aUpdateFromXMLNode) {
    this(opensimModelJNI.new_SetForces__SWIG_1(aFileName, aUpdateFromXMLNode), true);
  }

  public SetForces(String aFileName) {
    this(opensimModelJNI.new_SetForces__SWIG_2(aFileName), true);
  }

  public SetForces(SetForces aSet) {
    this(opensimModelJNI.new_SetForces__SWIG_3(SetForces.getCPtr(aSet), aSet), true);
  }

  public OpenSimObject copy() {
    long cPtr = opensimModelJNI.SetForces_copy(swigCPtr, this);
    return (cPtr == 0) ? null : new OpenSimObject(cPtr, false);
  }

  public void setup() {
    opensimModelJNI.SetForces_setup(swigCPtr, this);
  }

  public void setMemoryOwner(boolean aTrueFalse) {
    opensimModelJNI.SetForces_setMemoryOwner(swigCPtr, this, aTrueFalse);
  }

  public boolean getMemoryOwner() {
    return opensimModelJNI.SetForces_getMemoryOwner(swigCPtr, this);
  }

  public boolean computeNewCapacity(int aMinCapacity, SWIGTYPE_p_int rNewCapacity) {
    return opensimModelJNI.SetForces_computeNewCapacity(swigCPtr, this, aMinCapacity, SWIGTYPE_p_int.getCPtr(rNewCapacity));
  }

  public boolean ensureCapacity(int aCapacity) {
    return opensimModelJNI.SetForces_ensureCapacity(swigCPtr, this, aCapacity);
  }

  public void trim() {
    opensimModelJNI.SetForces_trim(swigCPtr, this);
  }

  public int getCapacity() {
    return opensimModelJNI.SetForces_getCapacity(swigCPtr, this);
  }

  public void setCapacityIncrement(int aIncrement) {
    opensimModelJNI.SetForces_setCapacityIncrement(swigCPtr, this, aIncrement);
  }

  public int getCapacityIncrement() {
    return opensimModelJNI.SetForces_getCapacityIncrement(swigCPtr, this);
  }

  public boolean setSize(int aSize) {
    return opensimModelJNI.SetForces_setSize(swigCPtr, this, aSize);
  }

  public int getSize() {
    return opensimModelJNI.SetForces_getSize(swigCPtr, this);
  }

  public int getIndex(Force aObject, int aStartIndex) {
    return opensimModelJNI.SetForces_getIndex__SWIG_0(swigCPtr, this, Force.getCPtr(aObject), aObject, aStartIndex);
  }

  public int getIndex(Force aObject) {
    return opensimModelJNI.SetForces_getIndex__SWIG_1(swigCPtr, this, Force.getCPtr(aObject), aObject);
  }

  public int getIndex(String aName, int aStartIndex) {
    return opensimModelJNI.SetForces_getIndex__SWIG_2(swigCPtr, this, aName, aStartIndex);
  }

  public int getIndex(String aName) {
    return opensimModelJNI.SetForces_getIndex__SWIG_3(swigCPtr, this, aName);
  }

  public void getGroupNamesContaining(String aObjectName, ArrayStr rGroupNames) {
    opensimModelJNI.SetForces_getGroupNamesContaining(swigCPtr, this, aObjectName, ArrayStr.getCPtr(rGroupNames), rGroupNames);
  }

  public boolean append(Force aObject) {
    return opensimModelJNI.SetForces_append__SWIG_0(swigCPtr, this, Force.getCPtr(aObject), aObject);
  }

  public boolean insert(int aIndex, Force aObject) {
    return opensimModelJNI.SetForces_insert__SWIG_0(swigCPtr, this, aIndex, Force.getCPtr(aObject), aObject);
  }

  public boolean remove(int aIndex) {
    return opensimModelJNI.SetForces_remove__SWIG_0(swigCPtr, this, aIndex);
  }

  public boolean remove(Force aObject) {
    return opensimModelJNI.SetForces_remove__SWIG_1(swigCPtr, this, Force.getCPtr(aObject), aObject);
  }

  public void clearAndDestroy() {
    opensimModelJNI.SetForces_clearAndDestroy(swigCPtr, this);
  }

  public boolean set(int aIndex, Force aObject, boolean preserveGroups) {
    return opensimModelJNI.SetForces_set__SWIG_0(swigCPtr, this, aIndex, Force.getCPtr(aObject), aObject, preserveGroups);
  }

  public boolean set(int aIndex, Force aObject) {
    return opensimModelJNI.SetForces_set__SWIG_1(swigCPtr, this, aIndex, Force.getCPtr(aObject), aObject);
  }

  public Force get(int aIndex) {
    return new Force(opensimModelJNI.SetForces_get__SWIG_0(swigCPtr, this, aIndex), false);
  }

  public Force get(String aName) {
    return new Force(opensimModelJNI.SetForces_get__SWIG_1(swigCPtr, this, aName), false);
  }

  public boolean contains(String aName) {
    return opensimModelJNI.SetForces_contains(swigCPtr, this, aName);
  }

  public void getNames(ArrayStr rNames) {
    opensimModelJNI.SetForces_getNames(swigCPtr, this, ArrayStr.getCPtr(rNames), rNames);
  }

  public Force getLast() {
    long cPtr = opensimModelJNI.SetForces_getLast(swigCPtr, this);
    return (cPtr == 0) ? null : new Force(cPtr, false);
  }

  public int searchBinary(Force aObject, boolean aFindFirst, int aLo, int aHi) {
    return opensimModelJNI.SetForces_searchBinary__SWIG_0(swigCPtr, this, Force.getCPtr(aObject), aObject, aFindFirst, aLo, aHi);
  }

  public int searchBinary(Force aObject, boolean aFindFirst, int aLo) {
    return opensimModelJNI.SetForces_searchBinary__SWIG_1(swigCPtr, this, Force.getCPtr(aObject), aObject, aFindFirst, aLo);
  }

  public int searchBinary(Force aObject, boolean aFindFirst) {
    return opensimModelJNI.SetForces_searchBinary__SWIG_2(swigCPtr, this, Force.getCPtr(aObject), aObject, aFindFirst);
  }

  public int searchBinary(Force aObject) {
    return opensimModelJNI.SetForces_searchBinary__SWIG_3(swigCPtr, this, Force.getCPtr(aObject), aObject);
  }

  public int getNumGroups() {
    return opensimModelJNI.SetForces_getNumGroups(swigCPtr, this);
  }

  public void addGroup(String aGroupName) {
    opensimModelJNI.SetForces_addGroup(swigCPtr, this, aGroupName);
  }

  public void removeGroup(String aGroupName) {
    opensimModelJNI.SetForces_removeGroup(swigCPtr, this, aGroupName);
  }

  public void renameGroup(String oldGroupName, String newGroupName) {
    opensimModelJNI.SetForces_renameGroup(swigCPtr, this, oldGroupName, newGroupName);
  }

  public void addObjectToGroup(String aGroupName, String aObjectName) {
    opensimModelJNI.SetForces_addObjectToGroup(swigCPtr, this, aGroupName, aObjectName);
  }

  public void getGroupNames(ArrayStr rGroupNames) {
    opensimModelJNI.SetForces_getGroupNames(swigCPtr, this, ArrayStr.getCPtr(rGroupNames), rGroupNames);
  }

  public ObjectGroup getGroup(String aGroupName) {
    long cPtr = opensimModelJNI.SetForces_getGroup__SWIG_0(swigCPtr, this, aGroupName);
    return (cPtr == 0) ? null : new ObjectGroup(cPtr, false);
  }

  public ObjectGroup getGroup(int aIndex) {
    long cPtr = opensimModelJNI.SetForces_getGroup__SWIG_1(swigCPtr, this, aIndex);
    return (cPtr == 0) ? null : new ObjectGroup(cPtr, false);
  }

}