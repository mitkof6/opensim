/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.31
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.opensim.modeling;

public class PropertySet {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  public PropertySet(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  public static long getCPtr(PropertySet obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if(swigCPtr != 0 && swigCMemOwn) {
      swigCMemOwn = false;
      opensimModelJNI.delete_PropertySet(swigCPtr);
    }
    swigCPtr = 0;
  }

  public void set_array(SWIGTYPE_p_OpenSim__ArrayPtrsTOpenSim__Property_t value) {
    opensimModelJNI.PropertySet__array_set(swigCPtr, this, SWIGTYPE_p_OpenSim__ArrayPtrsTOpenSim__Property_t.getCPtr(value));
  }

  public SWIGTYPE_p_OpenSim__ArrayPtrsTOpenSim__Property_t get_array() {
    long cPtr = opensimModelJNI.PropertySet__array_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_OpenSim__ArrayPtrsTOpenSim__Property_t(cPtr, false);
  }

  public PropertySet() {
    this(opensimModelJNI.new_PropertySet__SWIG_0(), true);
  }

  public PropertySet(PropertySet aSet) {
    this(opensimModelJNI.new_PropertySet__SWIG_1(PropertySet.getCPtr(aSet), aSet), true);
  }

  public boolean isEmpty() {
    return opensimModelJNI.PropertySet_isEmpty(swigCPtr, this);
  }

  public int getSize() {
    return opensimModelJNI.PropertySet_getSize(swigCPtr, this);
  }

  public Property get(int i) throws java.io.IOException {
    long cPtr = opensimModelJNI.PropertySet_get__SWIG_0(swigCPtr, this, i);
    return (cPtr == 0) ? null : new Property(cPtr, false);
  }

  public Property get(String aName) throws java.io.IOException {
    long cPtr = opensimModelJNI.PropertySet_get__SWIG_1(swigCPtr, this, aName);
    return (cPtr == 0) ? null : new Property(cPtr, false);
  }

  public void append(Property aProperty) {
    opensimModelJNI.PropertySet_append(swigCPtr, this, Property.getCPtr(aProperty), aProperty);
  }

  public void remove(String aName) {
    opensimModelJNI.PropertySet_remove(swigCPtr, this, aName);
  }

  public void clear() {
    opensimModelJNI.PropertySet_clear(swigCPtr, this);
  }

}
