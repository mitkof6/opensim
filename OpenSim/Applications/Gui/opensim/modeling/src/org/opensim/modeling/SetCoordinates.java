/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.31
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.opensim.modeling;

public class SetCoordinates extends OpenSimObject {
  private long swigCPtr;

  public SetCoordinates(long cPtr, boolean cMemoryOwn) {
    super(opensimModelJNI.SWIGStorageUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  public static long getCPtr(SetCoordinates obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if(swigCPtr != 0 && swigCMemOwn) {
      swigCMemOwn = false;
      opensimModelJNI.delete_SetCoordinates(swigCPtr);
    }
    swigCPtr = 0;
    super.delete();
  }

  public SetCoordinates() {
    this(opensimModelJNI.new_SetCoordinates__SWIG_0(), true);
  }

  public SetCoordinates(String aFileName, boolean aUpdateFromXMLNode) {
    this(opensimModelJNI.new_SetCoordinates__SWIG_1(aFileName, aUpdateFromXMLNode), true);
  }

  public SetCoordinates(String aFileName) {
    this(opensimModelJNI.new_SetCoordinates__SWIG_2(aFileName), true);
  }

  public SetCoordinates(SetCoordinates aSet) {
    this(opensimModelJNI.new_SetCoordinates__SWIG_3(SetCoordinates.getCPtr(aSet), aSet), true);
  }

  public OpenSimObject copy() {
    long cPtr = opensimModelJNI.SetCoordinates_copy(swigCPtr, this);
    return (cPtr == 0) ? null : new OpenSimObject(cPtr, false);
  }

  public void setup() {
    opensimModelJNI.SetCoordinates_setup(swigCPtr, this);
  }

  public void setMemoryOwner(boolean aTrueFalse) {
    opensimModelJNI.SetCoordinates_setMemoryOwner(swigCPtr, this, aTrueFalse);
  }

  public boolean getMemoryOwner() {
    return opensimModelJNI.SetCoordinates_getMemoryOwner(swigCPtr, this);
  }

  public boolean computeNewCapacity(int aMinCapacity, SWIGTYPE_p_int rNewCapacity) {
    return opensimModelJNI.SetCoordinates_computeNewCapacity(swigCPtr, this, aMinCapacity, SWIGTYPE_p_int.getCPtr(rNewCapacity));
  }

  public boolean ensureCapacity(int aCapacity) {
    return opensimModelJNI.SetCoordinates_ensureCapacity(swigCPtr, this, aCapacity);
  }

  public void trim() {
    opensimModelJNI.SetCoordinates_trim(swigCPtr, this);
  }

  public int getCapacity() {
    return opensimModelJNI.SetCoordinates_getCapacity(swigCPtr, this);
  }

  public void setCapacityIncrement(int aIncrement) {
    opensimModelJNI.SetCoordinates_setCapacityIncrement(swigCPtr, this, aIncrement);
  }

  public int getCapacityIncrement() {
    return opensimModelJNI.SetCoordinates_getCapacityIncrement(swigCPtr, this);
  }

  public boolean setSize(int aSize) {
    return opensimModelJNI.SetCoordinates_setSize(swigCPtr, this, aSize);
  }

  public int getSize() {
    return opensimModelJNI.SetCoordinates_getSize(swigCPtr, this);
  }

  public int getIndex(Coordinate aObject, int aStartIndex) {
    return opensimModelJNI.SetCoordinates_getIndex__SWIG_0(swigCPtr, this, Coordinate.getCPtr(aObject), aObject, aStartIndex);
  }

  public int getIndex(Coordinate aObject) {
    return opensimModelJNI.SetCoordinates_getIndex__SWIG_1(swigCPtr, this, Coordinate.getCPtr(aObject), aObject);
  }

  public int getIndex(String aName, int aStartIndex) {
    return opensimModelJNI.SetCoordinates_getIndex__SWIG_2(swigCPtr, this, aName, aStartIndex);
  }

  public int getIndex(String aName) {
    return opensimModelJNI.SetCoordinates_getIndex__SWIG_3(swigCPtr, this, aName);
  }

  public void getGroupNamesContaining(String aObjectName, ArrayStr rGroupNames) {
    opensimModelJNI.SetCoordinates_getGroupNamesContaining(swigCPtr, this, aObjectName, ArrayStr.getCPtr(rGroupNames), rGroupNames);
  }

  public boolean append(Coordinate aObject) {
    return opensimModelJNI.SetCoordinates_append__SWIG_0(swigCPtr, this, Coordinate.getCPtr(aObject), aObject);
  }

  public boolean insert(int aIndex, Coordinate aObject) {
    return opensimModelJNI.SetCoordinates_insert__SWIG_0(swigCPtr, this, aIndex, Coordinate.getCPtr(aObject), aObject);
  }

  public boolean remove(int aIndex) {
    return opensimModelJNI.SetCoordinates_remove__SWIG_0(swigCPtr, this, aIndex);
  }

  public boolean remove(Coordinate aObject) {
    return opensimModelJNI.SetCoordinates_remove__SWIG_1(swigCPtr, this, Coordinate.getCPtr(aObject), aObject);
  }

  public void clearAndDestroy() {
    opensimModelJNI.SetCoordinates_clearAndDestroy(swigCPtr, this);
  }

  public boolean set(int aIndex, Coordinate aObject, boolean preserveGroups) {
    return opensimModelJNI.SetCoordinates_set__SWIG_0(swigCPtr, this, aIndex, Coordinate.getCPtr(aObject), aObject, preserveGroups);
  }

  public boolean set(int aIndex, Coordinate aObject) {
    return opensimModelJNI.SetCoordinates_set__SWIG_1(swigCPtr, this, aIndex, Coordinate.getCPtr(aObject), aObject);
  }

  public Coordinate get(int aIndex) {
    return new Coordinate(opensimModelJNI.SetCoordinates_get__SWIG_0(swigCPtr, this, aIndex), false);
  }

  public Coordinate get(String aName) {
    return new Coordinate(opensimModelJNI.SetCoordinates_get__SWIG_1(swigCPtr, this, aName), false);
  }

  public boolean contains(String aName) {
    return opensimModelJNI.SetCoordinates_contains(swigCPtr, this, aName);
  }

  public void getNames(ArrayStr rNames) {
    opensimModelJNI.SetCoordinates_getNames(swigCPtr, this, ArrayStr.getCPtr(rNames), rNames);
  }

  public Coordinate getLast() {
    long cPtr = opensimModelJNI.SetCoordinates_getLast(swigCPtr, this);
    return (cPtr == 0) ? null : new Coordinate(cPtr, false);
  }

  public int searchBinary(Coordinate aObject, boolean aFindFirst, int aLo, int aHi) {
    return opensimModelJNI.SetCoordinates_searchBinary__SWIG_0(swigCPtr, this, Coordinate.getCPtr(aObject), aObject, aFindFirst, aLo, aHi);
  }

  public int searchBinary(Coordinate aObject, boolean aFindFirst, int aLo) {
    return opensimModelJNI.SetCoordinates_searchBinary__SWIG_1(swigCPtr, this, Coordinate.getCPtr(aObject), aObject, aFindFirst, aLo);
  }

  public int searchBinary(Coordinate aObject, boolean aFindFirst) {
    return opensimModelJNI.SetCoordinates_searchBinary__SWIG_2(swigCPtr, this, Coordinate.getCPtr(aObject), aObject, aFindFirst);
  }

  public int searchBinary(Coordinate aObject) {
    return opensimModelJNI.SetCoordinates_searchBinary__SWIG_3(swigCPtr, this, Coordinate.getCPtr(aObject), aObject);
  }

  public int getNumGroups() {
    return opensimModelJNI.SetCoordinates_getNumGroups(swigCPtr, this);
  }

  public void addGroup(String aGroupName) {
    opensimModelJNI.SetCoordinates_addGroup(swigCPtr, this, aGroupName);
  }

  public void removeGroup(String aGroupName) {
    opensimModelJNI.SetCoordinates_removeGroup(swigCPtr, this, aGroupName);
  }

  public void renameGroup(String oldGroupName, String newGroupName) {
    opensimModelJNI.SetCoordinates_renameGroup(swigCPtr, this, oldGroupName, newGroupName);
  }

  public void addObjectToGroup(String aGroupName, String aObjectName) {
    opensimModelJNI.SetCoordinates_addObjectToGroup(swigCPtr, this, aGroupName, aObjectName);
  }

  public void getGroupNames(ArrayStr rGroupNames) {
    opensimModelJNI.SetCoordinates_getGroupNames(swigCPtr, this, ArrayStr.getCPtr(rGroupNames), rGroupNames);
  }

  public ObjectGroup getGroup(String aGroupName) {
    long cPtr = opensimModelJNI.SetCoordinates_getGroup__SWIG_0(swigCPtr, this, aGroupName);
    return (cPtr == 0) ? null : new ObjectGroup(cPtr, false);
  }

  public ObjectGroup getGroup(int aIndex) {
    long cPtr = opensimModelJNI.SetCoordinates_getGroup__SWIG_1(swigCPtr, this, aIndex);
    return (cPtr == 0) ? null : new ObjectGroup(cPtr, false);
  }

}
