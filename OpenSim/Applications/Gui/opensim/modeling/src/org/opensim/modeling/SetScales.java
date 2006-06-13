/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.29
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.opensim.modeling;

public class SetScales extends OpenSimObject {
  private long swigCPtr;

  protected SetScales(long cPtr, boolean cMemoryOwn) {
    super(opensimModelJNI.SWIGSetScalesUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  protected static long getCPtr(SetScales obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public void delete() {
    if(swigCPtr != 0 && swigCMemOwn) {
      swigCMemOwn = false;
      opensimModelJNI.delete_SetScales(swigCPtr);
    }
    swigCPtr = 0;
    super.delete();
  }

  public SetScales() {
    this(opensimModelJNI.new_SetScales__SWIG_0(), true);
  }

  public SetScales(String aFileName) {
    this(opensimModelJNI.new_SetScales__SWIG_1(aFileName), true);
  }

  public SetScales(SWIGTYPE_p_DOMElement aElement) {
    this(opensimModelJNI.new_SetScales__SWIG_2(SWIGTYPE_p_DOMElement.getCPtr(aElement)), true);
  }

  public SetScales(SetScales aSet) {
    this(opensimModelJNI.new_SetScales__SWIG_3(SetScales.getCPtr(aSet)), true);
  }

  public OpenSimObject copy() {
    long cPtr = opensimModelJNI.SetScales_copy(swigCPtr);
    return (cPtr == 0) ? null : new OpenSimObject(cPtr, false);
  }

  public void setMemoryOwner(boolean aTrueFalse) {
    opensimModelJNI.SetScales_setMemoryOwner(swigCPtr, aTrueFalse);
  }

  public boolean getMemoryOwner() {
    return opensimModelJNI.SetScales_getMemoryOwner(swigCPtr);
  }

  public boolean computeNewCapacity(int aMinCapacity, SWIGTYPE_p_int rNewCapacity) {
    return opensimModelJNI.SetScales_computeNewCapacity(swigCPtr, aMinCapacity, SWIGTYPE_p_int.getCPtr(rNewCapacity));
  }

  public boolean ensureCapacity(int aCapacity) {
    return opensimModelJNI.SetScales_ensureCapacity(swigCPtr, aCapacity);
  }

  public void trim() {
    opensimModelJNI.SetScales_trim(swigCPtr);
  }

  public int getCapacity() {
    return opensimModelJNI.SetScales_getCapacity(swigCPtr);
  }

  public void setCapacityIncrement(int aIncrement) {
    opensimModelJNI.SetScales_setCapacityIncrement(swigCPtr, aIncrement);
  }

  public int getCapacityIncrement() {
    return opensimModelJNI.SetScales_getCapacityIncrement(swigCPtr);
  }

  public boolean setSize(int aSize) {
    return opensimModelJNI.SetScales_setSize(swigCPtr, aSize);
  }

  public int getSize() {
    return opensimModelJNI.SetScales_getSize(swigCPtr);
  }

  public int getIndex(Scale aObject, int aStartIndex) {
    return opensimModelJNI.SetScales_getIndex__SWIG_0(swigCPtr, Scale.getCPtr(aObject), aStartIndex);
  }

  public int getIndex(Scale aObject) {
    return opensimModelJNI.SetScales_getIndex__SWIG_1(swigCPtr, Scale.getCPtr(aObject));
  }

  public int getIndex(String aName, int aStartIndex) {
    return opensimModelJNI.SetScales_getIndex__SWIG_2(swigCPtr, aName, aStartIndex);
  }

  public int getIndex(String aName) {
    return opensimModelJNI.SetScales_getIndex__SWIG_3(swigCPtr, aName);
  }

  public boolean append(Scale aObject) {
    return opensimModelJNI.SetScales_append__SWIG_0(swigCPtr, Scale.getCPtr(aObject));
  }

  public boolean append(SWIGTYPE_p_OpenSim__ArrayPtrsTOpenSim__Scale_t aArray) {
    return opensimModelJNI.SetScales_append__SWIG_1(swigCPtr, SWIGTYPE_p_OpenSim__ArrayPtrsTOpenSim__Scale_t.getCPtr(aArray));
  }

  public boolean insert(int aIndex, Scale aObject) {
    return opensimModelJNI.SetScales_insert(swigCPtr, aIndex, Scale.getCPtr(aObject));
  }

  public boolean remove(int aIndex) {
    return opensimModelJNI.SetScales_remove__SWIG_0(swigCPtr, aIndex);
  }

  public boolean remove(Scale aObject) {
    return opensimModelJNI.SetScales_remove__SWIG_1(swigCPtr, Scale.getCPtr(aObject));
  }

  public boolean set(int aIndex, Scale aObject) {
    return opensimModelJNI.SetScales_set(swigCPtr, aIndex, Scale.getCPtr(aObject));
  }

  public Scale get(int aIndex) {
    long cPtr = opensimModelJNI.SetScales_get__SWIG_0(swigCPtr, aIndex);
    return (cPtr == 0) ? null : new Scale(cPtr, false);
  }

  public Scale get(String aName) {
    long cPtr = opensimModelJNI.SetScales_get__SWIG_1(swigCPtr, aName);
    return (cPtr == 0) ? null : new Scale(cPtr, false);
  }

  public Scale getLast() {
    long cPtr = opensimModelJNI.SetScales_getLast(swigCPtr);
    return (cPtr == 0) ? null : new Scale(cPtr, false);
  }

  public int searchBinary(Scale aObject, boolean aFindFirst, int aLo, int aHi) {
    return opensimModelJNI.SetScales_searchBinary__SWIG_0(swigCPtr, Scale.getCPtr(aObject), aFindFirst, aLo, aHi);
  }

  public int searchBinary(Scale aObject, boolean aFindFirst, int aLo) {
    return opensimModelJNI.SetScales_searchBinary__SWIG_1(swigCPtr, Scale.getCPtr(aObject), aFindFirst, aLo);
  }

  public int searchBinary(Scale aObject, boolean aFindFirst) {
    return opensimModelJNI.SetScales_searchBinary__SWIG_2(swigCPtr, Scale.getCPtr(aObject), aFindFirst);
  }

  public int searchBinary(Scale aObject) {
    return opensimModelJNI.SetScales_searchBinary__SWIG_3(swigCPtr, Scale.getCPtr(aObject));
  }

}
