/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.40
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.opensim.modeling;

public class SetContactGeometry extends OpenSimObject {
  private long swigCPtr;

  public SetContactGeometry(long cPtr, boolean cMemoryOwn) {
    super(opensimModelJNI.SWIGStorageUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  public static long getCPtr(SetContactGeometry obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        opensimModelJNI.delete_SetContactGeometry(swigCPtr);
      }
      swigCPtr = 0;
    }
    super.delete();
  }

  public SetContactGeometry() {
    this(opensimModelJNI.new_SetContactGeometry__SWIG_0(), true);
  }

  public SetContactGeometry(String aFileName, boolean aUpdateFromXMLNode) {
    this(opensimModelJNI.new_SetContactGeometry__SWIG_1(aFileName, aUpdateFromXMLNode), true);
  }

  public SetContactGeometry(String aFileName) {
    this(opensimModelJNI.new_SetContactGeometry__SWIG_2(aFileName), true);
  }

  public SetContactGeometry(SetContactGeometry aSet) {
    this(opensimModelJNI.new_SetContactGeometry__SWIG_3(SetContactGeometry.getCPtr(aSet), aSet), true);
  }

  public OpenSimObject copy() {
    long cPtr = opensimModelJNI.SetContactGeometry_copy(swigCPtr, this);
    return (cPtr == 0) ? null : new OpenSimObject(cPtr, false);
  }

  public void setup() {
    opensimModelJNI.SetContactGeometry_setup(swigCPtr, this);
  }

  public void setMemoryOwner(boolean aTrueFalse) {
    opensimModelJNI.SetContactGeometry_setMemoryOwner(swigCPtr, this, aTrueFalse);
  }

  public boolean getMemoryOwner() {
    return opensimModelJNI.SetContactGeometry_getMemoryOwner(swigCPtr, this);
  }

  public boolean computeNewCapacity(int aMinCapacity, SWIGTYPE_p_int rNewCapacity) {
    return opensimModelJNI.SetContactGeometry_computeNewCapacity(swigCPtr, this, aMinCapacity, SWIGTYPE_p_int.getCPtr(rNewCapacity));
  }

  public boolean ensureCapacity(int aCapacity) {
    return opensimModelJNI.SetContactGeometry_ensureCapacity(swigCPtr, this, aCapacity);
  }

  public void trim() {
    opensimModelJNI.SetContactGeometry_trim(swigCPtr, this);
  }

  public int getCapacity() {
    return opensimModelJNI.SetContactGeometry_getCapacity(swigCPtr, this);
  }

  public void setCapacityIncrement(int aIncrement) {
    opensimModelJNI.SetContactGeometry_setCapacityIncrement(swigCPtr, this, aIncrement);
  }

  public int getCapacityIncrement() {
    return opensimModelJNI.SetContactGeometry_getCapacityIncrement(swigCPtr, this);
  }

  public boolean setSize(int aSize) {
    return opensimModelJNI.SetContactGeometry_setSize(swigCPtr, this, aSize);
  }

  public int getSize() {
    return opensimModelJNI.SetContactGeometry_getSize(swigCPtr, this);
  }

  public int getIndex(ContactGeometry aObject, int aStartIndex) {
    return opensimModelJNI.SetContactGeometry_getIndex__SWIG_0(swigCPtr, this, ContactGeometry.getCPtr(aObject), aObject, aStartIndex);
  }

  public int getIndex(ContactGeometry aObject) {
    return opensimModelJNI.SetContactGeometry_getIndex__SWIG_1(swigCPtr, this, ContactGeometry.getCPtr(aObject), aObject);
  }

  public int getIndex(String aName, int aStartIndex) {
    return opensimModelJNI.SetContactGeometry_getIndex__SWIG_2(swigCPtr, this, aName, aStartIndex);
  }

  public int getIndex(String aName) {
    return opensimModelJNI.SetContactGeometry_getIndex__SWIG_3(swigCPtr, this, aName);
  }

  public void getGroupNamesContaining(String aObjectName, ArrayStr rGroupNames) {
    opensimModelJNI.SetContactGeometry_getGroupNamesContaining(swigCPtr, this, aObjectName, ArrayStr.getCPtr(rGroupNames), rGroupNames);
  }

  public boolean append(ContactGeometry aObject) {
    return opensimModelJNI.SetContactGeometry_append(swigCPtr, this, ContactGeometry.getCPtr(aObject), aObject);
  }

  public boolean insert(int aIndex, ContactGeometry aObject) {
    return opensimModelJNI.SetContactGeometry_insert(swigCPtr, this, aIndex, ContactGeometry.getCPtr(aObject), aObject);
  }

  public boolean remove(int aIndex) {
    return opensimModelJNI.SetContactGeometry_remove__SWIG_0(swigCPtr, this, aIndex);
  }

  public boolean remove(ContactGeometry aObject) {
    return opensimModelJNI.SetContactGeometry_remove__SWIG_1(swigCPtr, this, ContactGeometry.getCPtr(aObject), aObject);
  }

  public void clearAndDestroy() {
    opensimModelJNI.SetContactGeometry_clearAndDestroy(swigCPtr, this);
  }

  public boolean set(int aIndex, ContactGeometry aObject, boolean preserveGroups) {
    return opensimModelJNI.SetContactGeometry_set__SWIG_0(swigCPtr, this, aIndex, ContactGeometry.getCPtr(aObject), aObject, preserveGroups);
  }

  public boolean set(int aIndex, ContactGeometry aObject) {
    return opensimModelJNI.SetContactGeometry_set__SWIG_1(swigCPtr, this, aIndex, ContactGeometry.getCPtr(aObject), aObject);
  }

  public ContactGeometry get(int aIndex) {
    return new ContactGeometry(opensimModelJNI.SetContactGeometry_get__SWIG_0(swigCPtr, this, aIndex), false);
  }

  public ContactGeometry get(String aName) {
    return new ContactGeometry(opensimModelJNI.SetContactGeometry_get__SWIG_1(swigCPtr, this, aName), false);
  }

  public boolean contains(String aName) {
    return opensimModelJNI.SetContactGeometry_contains(swigCPtr, this, aName);
  }

  public void getNames(ArrayStr rNames) {
    opensimModelJNI.SetContactGeometry_getNames(swigCPtr, this, ArrayStr.getCPtr(rNames), rNames);
  }

  public ContactGeometry getLast() {
    long cPtr = opensimModelJNI.SetContactGeometry_getLast(swigCPtr, this);
    return (cPtr == 0) ? null : new ContactGeometry(cPtr, false);
  }

  public int searchBinary(ContactGeometry aObject, boolean aFindFirst, int aLo, int aHi) {
    return opensimModelJNI.SetContactGeometry_searchBinary__SWIG_0(swigCPtr, this, ContactGeometry.getCPtr(aObject), aObject, aFindFirst, aLo, aHi);
  }

  public int searchBinary(ContactGeometry aObject, boolean aFindFirst, int aLo) {
    return opensimModelJNI.SetContactGeometry_searchBinary__SWIG_1(swigCPtr, this, ContactGeometry.getCPtr(aObject), aObject, aFindFirst, aLo);
  }

  public int searchBinary(ContactGeometry aObject, boolean aFindFirst) {
    return opensimModelJNI.SetContactGeometry_searchBinary__SWIG_2(swigCPtr, this, ContactGeometry.getCPtr(aObject), aObject, aFindFirst);
  }

  public int searchBinary(ContactGeometry aObject) {
    return opensimModelJNI.SetContactGeometry_searchBinary__SWIG_3(swigCPtr, this, ContactGeometry.getCPtr(aObject), aObject);
  }

  public int getNumGroups() {
    return opensimModelJNI.SetContactGeometry_getNumGroups(swigCPtr, this);
  }

  public void addGroup(String aGroupName) {
    opensimModelJNI.SetContactGeometry_addGroup(swigCPtr, this, aGroupName);
  }

  public void removeGroup(String aGroupName) {
    opensimModelJNI.SetContactGeometry_removeGroup(swigCPtr, this, aGroupName);
  }

  public void renameGroup(String oldGroupName, String newGroupName) {
    opensimModelJNI.SetContactGeometry_renameGroup(swigCPtr, this, oldGroupName, newGroupName);
  }

  public void addObjectToGroup(String aGroupName, String aObjectName) {
    opensimModelJNI.SetContactGeometry_addObjectToGroup(swigCPtr, this, aGroupName, aObjectName);
  }

  public void getGroupNames(ArrayStr rGroupNames) {
    opensimModelJNI.SetContactGeometry_getGroupNames(swigCPtr, this, ArrayStr.getCPtr(rGroupNames), rGroupNames);
  }

  public ObjectGroup getGroup(String aGroupName) {
    long cPtr = opensimModelJNI.SetContactGeometry_getGroup__SWIG_0(swigCPtr, this, aGroupName);
    return (cPtr == 0) ? null : new ObjectGroup(cPtr, false);
  }

  public ObjectGroup getGroup(int aIndex) {
    long cPtr = opensimModelJNI.SetContactGeometry_getGroup__SWIG_1(swigCPtr, this, aIndex);
    return (cPtr == 0) ? null : new ObjectGroup(cPtr, false);
  }

}
