/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.40
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.opensim.modeling;

public class SetModelComponents extends OpenSimObject {
  private long swigCPtr;

  public SetModelComponents(long cPtr, boolean cMemoryOwn) {
    super(opensimModelJNI.SWIGStorageUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  public static long getCPtr(SetModelComponents obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        opensimModelJNI.delete_SetModelComponents(swigCPtr);
      }
      swigCPtr = 0;
    }
    super.delete();
  }

  public SetModelComponents() {
    this(opensimModelJNI.new_SetModelComponents__SWIG_0(), true);
  }

  public SetModelComponents(String aFileName, boolean aUpdateFromXMLNode) {
    this(opensimModelJNI.new_SetModelComponents__SWIG_1(aFileName, aUpdateFromXMLNode), true);
  }

  public SetModelComponents(String aFileName) {
    this(opensimModelJNI.new_SetModelComponents__SWIG_2(aFileName), true);
  }

  public SetModelComponents(SetModelComponents aSet) {
    this(opensimModelJNI.new_SetModelComponents__SWIG_3(SetModelComponents.getCPtr(aSet), aSet), true);
  }

  public OpenSimObject copy() {
    long cPtr = opensimModelJNI.SetModelComponents_copy(swigCPtr, this);
    return (cPtr == 0) ? null : new OpenSimObject(cPtr, false);
  }

  public void setup() {
    opensimModelJNI.SetModelComponents_setup(swigCPtr, this);
  }

  public void setMemoryOwner(boolean aTrueFalse) {
    opensimModelJNI.SetModelComponents_setMemoryOwner(swigCPtr, this, aTrueFalse);
  }

  public boolean getMemoryOwner() {
    return opensimModelJNI.SetModelComponents_getMemoryOwner(swigCPtr, this);
  }

  public boolean computeNewCapacity(int aMinCapacity, SWIGTYPE_p_int rNewCapacity) {
    return opensimModelJNI.SetModelComponents_computeNewCapacity(swigCPtr, this, aMinCapacity, SWIGTYPE_p_int.getCPtr(rNewCapacity));
  }

  public boolean ensureCapacity(int aCapacity) {
    return opensimModelJNI.SetModelComponents_ensureCapacity(swigCPtr, this, aCapacity);
  }

  public void trim() {
    opensimModelJNI.SetModelComponents_trim(swigCPtr, this);
  }

  public int getCapacity() {
    return opensimModelJNI.SetModelComponents_getCapacity(swigCPtr, this);
  }

  public void setCapacityIncrement(int aIncrement) {
    opensimModelJNI.SetModelComponents_setCapacityIncrement(swigCPtr, this, aIncrement);
  }

  public int getCapacityIncrement() {
    return opensimModelJNI.SetModelComponents_getCapacityIncrement(swigCPtr, this);
  }

  public boolean setSize(int aSize) {
    return opensimModelJNI.SetModelComponents_setSize(swigCPtr, this, aSize);
  }

  public int getSize() {
    return opensimModelJNI.SetModelComponents_getSize(swigCPtr, this);
  }

  public int getIndex(ModelComponent aObject, int aStartIndex) {
    return opensimModelJNI.SetModelComponents_getIndex__SWIG_0(swigCPtr, this, ModelComponent.getCPtr(aObject), aObject, aStartIndex);
  }

  public int getIndex(ModelComponent aObject) {
    return opensimModelJNI.SetModelComponents_getIndex__SWIG_1(swigCPtr, this, ModelComponent.getCPtr(aObject), aObject);
  }

  public int getIndex(String aName, int aStartIndex) {
    return opensimModelJNI.SetModelComponents_getIndex__SWIG_2(swigCPtr, this, aName, aStartIndex);
  }

  public int getIndex(String aName) {
    return opensimModelJNI.SetModelComponents_getIndex__SWIG_3(swigCPtr, this, aName);
  }

  public void getGroupNamesContaining(String aObjectName, ArrayStr rGroupNames) {
    opensimModelJNI.SetModelComponents_getGroupNamesContaining(swigCPtr, this, aObjectName, ArrayStr.getCPtr(rGroupNames), rGroupNames);
  }

  public boolean append(ModelComponent aObject) {
    return opensimModelJNI.SetModelComponents_append(swigCPtr, this, ModelComponent.getCPtr(aObject), aObject);
  }

  public boolean insert(int aIndex, ModelComponent aObject) {
    return opensimModelJNI.SetModelComponents_insert(swigCPtr, this, aIndex, ModelComponent.getCPtr(aObject), aObject);
  }

  public boolean remove(int aIndex) {
    return opensimModelJNI.SetModelComponents_remove__SWIG_0(swigCPtr, this, aIndex);
  }

  public boolean remove(ModelComponent aObject) {
    return opensimModelJNI.SetModelComponents_remove__SWIG_1(swigCPtr, this, ModelComponent.getCPtr(aObject), aObject);
  }

  public void clearAndDestroy() {
    opensimModelJNI.SetModelComponents_clearAndDestroy(swigCPtr, this);
  }

  public boolean set(int aIndex, ModelComponent aObject, boolean preserveGroups) {
    return opensimModelJNI.SetModelComponents_set__SWIG_0(swigCPtr, this, aIndex, ModelComponent.getCPtr(aObject), aObject, preserveGroups);
  }

  public boolean set(int aIndex, ModelComponent aObject) {
    return opensimModelJNI.SetModelComponents_set__SWIG_1(swigCPtr, this, aIndex, ModelComponent.getCPtr(aObject), aObject);
  }

  public ModelComponent get(int aIndex) {
    return new ModelComponent(opensimModelJNI.SetModelComponents_get__SWIG_0(swigCPtr, this, aIndex), false);
  }

  public ModelComponent get(String aName) {
    return new ModelComponent(opensimModelJNI.SetModelComponents_get__SWIG_1(swigCPtr, this, aName), false);
  }

  public boolean contains(String aName) {
    return opensimModelJNI.SetModelComponents_contains(swigCPtr, this, aName);
  }

  public void getNames(ArrayStr rNames) {
    opensimModelJNI.SetModelComponents_getNames(swigCPtr, this, ArrayStr.getCPtr(rNames), rNames);
  }

  public ModelComponent getLast() {
    long cPtr = opensimModelJNI.SetModelComponents_getLast(swigCPtr, this);
    return (cPtr == 0) ? null : new ModelComponent(cPtr, false);
  }

  public int searchBinary(ModelComponent aObject, boolean aFindFirst, int aLo, int aHi) {
    return opensimModelJNI.SetModelComponents_searchBinary__SWIG_0(swigCPtr, this, ModelComponent.getCPtr(aObject), aObject, aFindFirst, aLo, aHi);
  }

  public int searchBinary(ModelComponent aObject, boolean aFindFirst, int aLo) {
    return opensimModelJNI.SetModelComponents_searchBinary__SWIG_1(swigCPtr, this, ModelComponent.getCPtr(aObject), aObject, aFindFirst, aLo);
  }

  public int searchBinary(ModelComponent aObject, boolean aFindFirst) {
    return opensimModelJNI.SetModelComponents_searchBinary__SWIG_2(swigCPtr, this, ModelComponent.getCPtr(aObject), aObject, aFindFirst);
  }

  public int searchBinary(ModelComponent aObject) {
    return opensimModelJNI.SetModelComponents_searchBinary__SWIG_3(swigCPtr, this, ModelComponent.getCPtr(aObject), aObject);
  }

  public int getNumGroups() {
    return opensimModelJNI.SetModelComponents_getNumGroups(swigCPtr, this);
  }

  public void addGroup(String aGroupName) {
    opensimModelJNI.SetModelComponents_addGroup(swigCPtr, this, aGroupName);
  }

  public void removeGroup(String aGroupName) {
    opensimModelJNI.SetModelComponents_removeGroup(swigCPtr, this, aGroupName);
  }

  public void renameGroup(String oldGroupName, String newGroupName) {
    opensimModelJNI.SetModelComponents_renameGroup(swigCPtr, this, oldGroupName, newGroupName);
  }

  public void addObjectToGroup(String aGroupName, String aObjectName) {
    opensimModelJNI.SetModelComponents_addObjectToGroup(swigCPtr, this, aGroupName, aObjectName);
  }

  public void getGroupNames(ArrayStr rGroupNames) {
    opensimModelJNI.SetModelComponents_getGroupNames(swigCPtr, this, ArrayStr.getCPtr(rGroupNames), rGroupNames);
  }

  public ObjectGroup getGroup(String aGroupName) {
    long cPtr = opensimModelJNI.SetModelComponents_getGroup__SWIG_0(swigCPtr, this, aGroupName);
    return (cPtr == 0) ? null : new ObjectGroup(cPtr, false);
  }

  public ObjectGroup getGroup(int aIndex) {
    long cPtr = opensimModelJNI.SetModelComponents_getGroup__SWIG_1(swigCPtr, this, aIndex);
    return (cPtr == 0) ? null : new ObjectGroup(cPtr, false);
  }

}
