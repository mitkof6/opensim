/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.37
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.opensim.modeling;

public class SetIKTrial extends OpenSimObject {
  private long swigCPtr;

  public SetIKTrial(long cPtr, boolean cMemoryOwn) {
    super(opensimModelJNI.SWIGStorageUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  public static long getCPtr(SetIKTrial obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if(swigCPtr != 0 && swigCMemOwn) {
      swigCMemOwn = false;
      opensimModelJNI.delete_SetIKTrial(swigCPtr);
    }
    swigCPtr = 0;
    super.delete();
  }

  public SetIKTrial() {
    this(opensimModelJNI.new_SetIKTrial__SWIG_0(), true);
  }

  public SetIKTrial(String aFileName, boolean aUpdateFromXMLNode) {
    this(opensimModelJNI.new_SetIKTrial__SWIG_1(aFileName, aUpdateFromXMLNode), true);
  }

  public SetIKTrial(String aFileName) {
    this(opensimModelJNI.new_SetIKTrial__SWIG_2(aFileName), true);
  }

  public SetIKTrial(SetIKTrial aSet) {
    this(opensimModelJNI.new_SetIKTrial__SWIG_3(SetIKTrial.getCPtr(aSet), aSet), true);
  }

  public OpenSimObject copy() {
    long cPtr = opensimModelJNI.SetIKTrial_copy(swigCPtr, this);
    return (cPtr == 0) ? null : new OpenSimObject(cPtr, false);
  }

  public void setup() {
    opensimModelJNI.SetIKTrial_setup(swigCPtr, this);
  }

  public void setMemoryOwner(boolean aTrueFalse) {
    opensimModelJNI.SetIKTrial_setMemoryOwner(swigCPtr, this, aTrueFalse);
  }

  public boolean getMemoryOwner() {
    return opensimModelJNI.SetIKTrial_getMemoryOwner(swigCPtr, this);
  }

  public boolean computeNewCapacity(int aMinCapacity, SWIGTYPE_p_int rNewCapacity) {
    return opensimModelJNI.SetIKTrial_computeNewCapacity(swigCPtr, this, aMinCapacity, SWIGTYPE_p_int.getCPtr(rNewCapacity));
  }

  public boolean ensureCapacity(int aCapacity) {
    return opensimModelJNI.SetIKTrial_ensureCapacity(swigCPtr, this, aCapacity);
  }

  public void trim() {
    opensimModelJNI.SetIKTrial_trim(swigCPtr, this);
  }

  public int getCapacity() {
    return opensimModelJNI.SetIKTrial_getCapacity(swigCPtr, this);
  }

  public void setCapacityIncrement(int aIncrement) {
    opensimModelJNI.SetIKTrial_setCapacityIncrement(swigCPtr, this, aIncrement);
  }

  public int getCapacityIncrement() {
    return opensimModelJNI.SetIKTrial_getCapacityIncrement(swigCPtr, this);
  }

  public boolean setSize(int aSize) {
    return opensimModelJNI.SetIKTrial_setSize(swigCPtr, this, aSize);
  }

  public int getSize() {
    return opensimModelJNI.SetIKTrial_getSize(swigCPtr, this);
  }

  public int getIndex(IKTrial aObject, int aStartIndex) {
    return opensimModelJNI.SetIKTrial_getIndex__SWIG_0(swigCPtr, this, IKTrial.getCPtr(aObject), aObject, aStartIndex);
  }

  public int getIndex(IKTrial aObject) {
    return opensimModelJNI.SetIKTrial_getIndex__SWIG_1(swigCPtr, this, IKTrial.getCPtr(aObject), aObject);
  }

  public int getIndex(String aName, int aStartIndex) {
    return opensimModelJNI.SetIKTrial_getIndex__SWIG_2(swigCPtr, this, aName, aStartIndex);
  }

  public int getIndex(String aName) {
    return opensimModelJNI.SetIKTrial_getIndex__SWIG_3(swigCPtr, this, aName);
  }

  public void getGroupNamesContaining(String aObjectName, ArrayStr rGroupNames) {
    opensimModelJNI.SetIKTrial_getGroupNamesContaining(swigCPtr, this, aObjectName, ArrayStr.getCPtr(rGroupNames), rGroupNames);
  }

  public boolean append(IKTrial aObject) {
    return opensimModelJNI.SetIKTrial_append(swigCPtr, this, IKTrial.getCPtr(aObject), aObject);
  }

  public boolean insert(int aIndex, IKTrial aObject) {
    return opensimModelJNI.SetIKTrial_insert(swigCPtr, this, aIndex, IKTrial.getCPtr(aObject), aObject);
  }

  public boolean remove(int aIndex) {
    return opensimModelJNI.SetIKTrial_remove__SWIG_0(swigCPtr, this, aIndex);
  }

  public boolean remove(IKTrial aObject) {
    return opensimModelJNI.SetIKTrial_remove__SWIG_1(swigCPtr, this, IKTrial.getCPtr(aObject), aObject);
  }

  public void clearAndDestroy() {
    opensimModelJNI.SetIKTrial_clearAndDestroy(swigCPtr, this);
  }

  public boolean set(int aIndex, IKTrial aObject, boolean preserveGroups) {
    return opensimModelJNI.SetIKTrial_set__SWIG_0(swigCPtr, this, aIndex, IKTrial.getCPtr(aObject), aObject, preserveGroups);
  }

  public boolean set(int aIndex, IKTrial aObject) {
    return opensimModelJNI.SetIKTrial_set__SWIG_1(swigCPtr, this, aIndex, IKTrial.getCPtr(aObject), aObject);
  }

  public IKTrial get(int aIndex) {
    return new IKTrial(opensimModelJNI.SetIKTrial_get__SWIG_0(swigCPtr, this, aIndex), false);
  }

  public IKTrial get(String aName) {
    return new IKTrial(opensimModelJNI.SetIKTrial_get__SWIG_1(swigCPtr, this, aName), false);
  }

  public boolean contains(String aName) {
    return opensimModelJNI.SetIKTrial_contains(swigCPtr, this, aName);
  }

  public void getNames(ArrayStr rNames) {
    opensimModelJNI.SetIKTrial_getNames(swigCPtr, this, ArrayStr.getCPtr(rNames), rNames);
  }

  public IKTrial getLast() {
    long cPtr = opensimModelJNI.SetIKTrial_getLast(swigCPtr, this);
    return (cPtr == 0) ? null : new IKTrial(cPtr, false);
  }

  public int searchBinary(IKTrial aObject, boolean aFindFirst, int aLo, int aHi) {
    return opensimModelJNI.SetIKTrial_searchBinary__SWIG_0(swigCPtr, this, IKTrial.getCPtr(aObject), aObject, aFindFirst, aLo, aHi);
  }

  public int searchBinary(IKTrial aObject, boolean aFindFirst, int aLo) {
    return opensimModelJNI.SetIKTrial_searchBinary__SWIG_1(swigCPtr, this, IKTrial.getCPtr(aObject), aObject, aFindFirst, aLo);
  }

  public int searchBinary(IKTrial aObject, boolean aFindFirst) {
    return opensimModelJNI.SetIKTrial_searchBinary__SWIG_2(swigCPtr, this, IKTrial.getCPtr(aObject), aObject, aFindFirst);
  }

  public int searchBinary(IKTrial aObject) {
    return opensimModelJNI.SetIKTrial_searchBinary__SWIG_3(swigCPtr, this, IKTrial.getCPtr(aObject), aObject);
  }

  public int getNumGroups() {
    return opensimModelJNI.SetIKTrial_getNumGroups(swigCPtr, this);
  }

  public void addGroup(String aGroupName) {
    opensimModelJNI.SetIKTrial_addGroup(swigCPtr, this, aGroupName);
  }

  public void removeGroup(String aGroupName) {
    opensimModelJNI.SetIKTrial_removeGroup(swigCPtr, this, aGroupName);
  }

  public void renameGroup(String oldGroupName, String newGroupName) {
    opensimModelJNI.SetIKTrial_renameGroup(swigCPtr, this, oldGroupName, newGroupName);
  }

  public void addObjectToGroup(String aGroupName, String aObjectName) {
    opensimModelJNI.SetIKTrial_addObjectToGroup(swigCPtr, this, aGroupName, aObjectName);
  }

  public void getGroupNames(ArrayStr rGroupNames) {
    opensimModelJNI.SetIKTrial_getGroupNames(swigCPtr, this, ArrayStr.getCPtr(rGroupNames), rGroupNames);
  }

  public ObjectGroup getGroup(String aGroupName) {
    long cPtr = opensimModelJNI.SetIKTrial_getGroup__SWIG_0(swigCPtr, this, aGroupName);
    return (cPtr == 0) ? null : new ObjectGroup(cPtr, false);
  }

  public ObjectGroup getGroup(int aIndex) {
    long cPtr = opensimModelJNI.SetIKTrial_getGroup__SWIG_1(swigCPtr, this, aIndex);
    return (cPtr == 0) ? null : new ObjectGroup(cPtr, false);
  }

}
