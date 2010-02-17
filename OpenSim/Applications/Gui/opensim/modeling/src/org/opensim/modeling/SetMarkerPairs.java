/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.31
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.opensim.modeling;

public class SetMarkerPairs extends OpenSimObject {
  private long swigCPtr;

  public SetMarkerPairs(long cPtr, boolean cMemoryOwn) {
    super(opensimModelJNI.SWIGStorageUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  public static long getCPtr(SetMarkerPairs obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if(swigCPtr != 0 && swigCMemOwn) {
      swigCMemOwn = false;
      opensimModelJNI.delete_SetMarkerPairs(swigCPtr);
    }
    swigCPtr = 0;
    super.delete();
  }

  public SetMarkerPairs() {
    this(opensimModelJNI.new_SetMarkerPairs__SWIG_0(), true);
  }

  public SetMarkerPairs(String aFileName, boolean aUpdateFromXMLNode) {
    this(opensimModelJNI.new_SetMarkerPairs__SWIG_1(aFileName, aUpdateFromXMLNode), true);
  }

  public SetMarkerPairs(String aFileName) {
    this(opensimModelJNI.new_SetMarkerPairs__SWIG_2(aFileName), true);
  }

  public SetMarkerPairs(SetMarkerPairs aSet) {
    this(opensimModelJNI.new_SetMarkerPairs__SWIG_3(SetMarkerPairs.getCPtr(aSet), aSet), true);
  }

  public OpenSimObject copy() {
    long cPtr = opensimModelJNI.SetMarkerPairs_copy(swigCPtr, this);
    return (cPtr == 0) ? null : new OpenSimObject(cPtr, false);
  }

  public void setup() {
    opensimModelJNI.SetMarkerPairs_setup(swigCPtr, this);
  }

  public void setMemoryOwner(boolean aTrueFalse) {
    opensimModelJNI.SetMarkerPairs_setMemoryOwner(swigCPtr, this, aTrueFalse);
  }

  public boolean getMemoryOwner() {
    return opensimModelJNI.SetMarkerPairs_getMemoryOwner(swigCPtr, this);
  }

  public boolean computeNewCapacity(int aMinCapacity, SWIGTYPE_p_int rNewCapacity) {
    return opensimModelJNI.SetMarkerPairs_computeNewCapacity(swigCPtr, this, aMinCapacity, SWIGTYPE_p_int.getCPtr(rNewCapacity));
  }

  public boolean ensureCapacity(int aCapacity) {
    return opensimModelJNI.SetMarkerPairs_ensureCapacity(swigCPtr, this, aCapacity);
  }

  public void trim() {
    opensimModelJNI.SetMarkerPairs_trim(swigCPtr, this);
  }

  public int getCapacity() {
    return opensimModelJNI.SetMarkerPairs_getCapacity(swigCPtr, this);
  }

  public void setCapacityIncrement(int aIncrement) {
    opensimModelJNI.SetMarkerPairs_setCapacityIncrement(swigCPtr, this, aIncrement);
  }

  public int getCapacityIncrement() {
    return opensimModelJNI.SetMarkerPairs_getCapacityIncrement(swigCPtr, this);
  }

  public boolean setSize(int aSize) {
    return opensimModelJNI.SetMarkerPairs_setSize(swigCPtr, this, aSize);
  }

  public int getSize() {
    return opensimModelJNI.SetMarkerPairs_getSize(swigCPtr, this);
  }

  public int getIndex(MarkerPair aObject, int aStartIndex) {
    return opensimModelJNI.SetMarkerPairs_getIndex__SWIG_0(swigCPtr, this, MarkerPair.getCPtr(aObject), aObject, aStartIndex);
  }

  public int getIndex(MarkerPair aObject) {
    return opensimModelJNI.SetMarkerPairs_getIndex__SWIG_1(swigCPtr, this, MarkerPair.getCPtr(aObject), aObject);
  }

  public int getIndex(String aName, int aStartIndex) {
    return opensimModelJNI.SetMarkerPairs_getIndex__SWIG_2(swigCPtr, this, aName, aStartIndex);
  }

  public int getIndex(String aName) {
    return opensimModelJNI.SetMarkerPairs_getIndex__SWIG_3(swigCPtr, this, aName);
  }

  public void getGroupNamesContaining(String aObjectName, ArrayStr rGroupNames) {
    opensimModelJNI.SetMarkerPairs_getGroupNamesContaining(swigCPtr, this, aObjectName, ArrayStr.getCPtr(rGroupNames), rGroupNames);
  }

  public boolean append(MarkerPair aObject) {
    return opensimModelJNI.SetMarkerPairs_append__SWIG_0(swigCPtr, this, MarkerPair.getCPtr(aObject), aObject);
  }

  public boolean insert(int aIndex, MarkerPair aObject) {
    return opensimModelJNI.SetMarkerPairs_insert__SWIG_0(swigCPtr, this, aIndex, MarkerPair.getCPtr(aObject), aObject);
  }

  public boolean remove(int aIndex) {
    return opensimModelJNI.SetMarkerPairs_remove__SWIG_0(swigCPtr, this, aIndex);
  }

  public boolean remove(MarkerPair aObject) {
    return opensimModelJNI.SetMarkerPairs_remove__SWIG_1(swigCPtr, this, MarkerPair.getCPtr(aObject), aObject);
  }

  public void clearAndDestroy() {
    opensimModelJNI.SetMarkerPairs_clearAndDestroy(swigCPtr, this);
  }

  public boolean set(int aIndex, MarkerPair aObject, boolean preserveGroups) {
    return opensimModelJNI.SetMarkerPairs_set__SWIG_0(swigCPtr, this, aIndex, MarkerPair.getCPtr(aObject), aObject, preserveGroups);
  }

  public boolean set(int aIndex, MarkerPair aObject) {
    return opensimModelJNI.SetMarkerPairs_set__SWIG_1(swigCPtr, this, aIndex, MarkerPair.getCPtr(aObject), aObject);
  }

  public MarkerPair get(int aIndex) {
    return new MarkerPair(opensimModelJNI.SetMarkerPairs_get__SWIG_0(swigCPtr, this, aIndex), false);
  }

  public MarkerPair get(String aName) {
    return new MarkerPair(opensimModelJNI.SetMarkerPairs_get__SWIG_1(swigCPtr, this, aName), false);
  }

  public boolean contains(String aName) {
    return opensimModelJNI.SetMarkerPairs_contains(swigCPtr, this, aName);
  }

  public void getNames(ArrayStr rNames) {
    opensimModelJNI.SetMarkerPairs_getNames(swigCPtr, this, ArrayStr.getCPtr(rNames), rNames);
  }

  public MarkerPair getLast() {
    long cPtr = opensimModelJNI.SetMarkerPairs_getLast(swigCPtr, this);
    return (cPtr == 0) ? null : new MarkerPair(cPtr, false);
  }

  public int searchBinary(MarkerPair aObject, boolean aFindFirst, int aLo, int aHi) {
    return opensimModelJNI.SetMarkerPairs_searchBinary__SWIG_0(swigCPtr, this, MarkerPair.getCPtr(aObject), aObject, aFindFirst, aLo, aHi);
  }

  public int searchBinary(MarkerPair aObject, boolean aFindFirst, int aLo) {
    return opensimModelJNI.SetMarkerPairs_searchBinary__SWIG_1(swigCPtr, this, MarkerPair.getCPtr(aObject), aObject, aFindFirst, aLo);
  }

  public int searchBinary(MarkerPair aObject, boolean aFindFirst) {
    return opensimModelJNI.SetMarkerPairs_searchBinary__SWIG_2(swigCPtr, this, MarkerPair.getCPtr(aObject), aObject, aFindFirst);
  }

  public int searchBinary(MarkerPair aObject) {
    return opensimModelJNI.SetMarkerPairs_searchBinary__SWIG_3(swigCPtr, this, MarkerPair.getCPtr(aObject), aObject);
  }

  public int getNumGroups() {
    return opensimModelJNI.SetMarkerPairs_getNumGroups(swigCPtr, this);
  }

  public void addGroup(String aGroupName) {
    opensimModelJNI.SetMarkerPairs_addGroup(swigCPtr, this, aGroupName);
  }

  public void removeGroup(String aGroupName) {
    opensimModelJNI.SetMarkerPairs_removeGroup(swigCPtr, this, aGroupName);
  }

  public void renameGroup(String oldGroupName, String newGroupName) {
    opensimModelJNI.SetMarkerPairs_renameGroup(swigCPtr, this, oldGroupName, newGroupName);
  }

  public void addObjectToGroup(String aGroupName, String aObjectName) {
    opensimModelJNI.SetMarkerPairs_addObjectToGroup(swigCPtr, this, aGroupName, aObjectName);
  }

  public void getGroupNames(ArrayStr rGroupNames) {
    opensimModelJNI.SetMarkerPairs_getGroupNames(swigCPtr, this, ArrayStr.getCPtr(rGroupNames), rGroupNames);
  }

  public ObjectGroup getGroup(String aGroupName) {
    long cPtr = opensimModelJNI.SetMarkerPairs_getGroup__SWIG_0(swigCPtr, this, aGroupName);
    return (cPtr == 0) ? null : new ObjectGroup(cPtr, false);
  }

  public ObjectGroup getGroup(int aIndex) {
    long cPtr = opensimModelJNI.SetMarkerPairs_getGroup__SWIG_1(swigCPtr, this, aIndex);
    return (cPtr == 0) ? null : new ObjectGroup(cPtr, false);
  }

}
