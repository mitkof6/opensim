/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.4
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.opensim.modeling;

public class AbstractProperty {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  public AbstractProperty(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  public static long getCPtr(AbstractProperty obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        opensimModelJNI.delete_AbstractProperty(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setAllowableListSize(int aMin, int aMax) {
    opensimModelJNI.AbstractProperty_setAllowableListSize__SWIG_0(swigCPtr, this, aMin, aMax);
  }

  public void setAllowableListSize(int aNum) {
    opensimModelJNI.AbstractProperty_setAllowableListSize__SWIG_1(swigCPtr, this, aNum);
  }

  public AbstractProperty clone() {
    long cPtr = opensimModelJNI.AbstractProperty_clone(swigCPtr, this);
    return (cPtr == 0) ? null : new AbstractProperty(cPtr, false);
  }

  public String toString() {
    return opensimModelJNI.AbstractProperty_toString(swigCPtr, this);
  }

  public boolean isObjectProperty() {
    return opensimModelJNI.AbstractProperty_isObjectProperty(swigCPtr, this);
  }

  public boolean isUnnamedProperty() {
    return opensimModelJNI.AbstractProperty_isUnnamedProperty(swigCPtr, this);
  }

  public boolean equals(AbstractProperty other) {
    return opensimModelJNI.AbstractProperty_equals(swigCPtr, this, AbstractProperty.getCPtr(other), other);
  }

  public boolean isSamePropertyClass(AbstractProperty other) {
    return opensimModelJNI.AbstractProperty_isSamePropertyClass(swigCPtr, this, AbstractProperty.getCPtr(other), other);
  }

  public int size() {
    return opensimModelJNI.AbstractProperty_size(swigCPtr, this);
  }

  public boolean empty() {
    return opensimModelJNI.AbstractProperty_empty(swigCPtr, this);
  }

  public void clear() {
    opensimModelJNI.AbstractProperty_clear(swigCPtr, this);
  }

  public OpenSimObject getValueAsObject(int index) {
    return new OpenSimObject(opensimModelJNI.AbstractProperty_getValueAsObject__SWIG_0(swigCPtr, this, index), false);
  }

  public OpenSimObject getValueAsObject() {
    return new OpenSimObject(opensimModelJNI.AbstractProperty_getValueAsObject__SWIG_1(swigCPtr, this), false);
  }

  public OpenSimObject updValueAsObject(int index) {
    return new OpenSimObject(opensimModelJNI.AbstractProperty_updValueAsObject__SWIG_0(swigCPtr, this, index), false);
  }

  public OpenSimObject updValueAsObject() {
    return new OpenSimObject(opensimModelJNI.AbstractProperty_updValueAsObject__SWIG_1(swigCPtr, this), false);
  }

  public void setValueAsObject(OpenSimObject obj, int index) {
    opensimModelJNI.AbstractProperty_setValueAsObject__SWIG_0(swigCPtr, this, OpenSimObject.getCPtr(obj), obj, index);
  }

  public void setValueAsObject(OpenSimObject obj) {
    opensimModelJNI.AbstractProperty_setValueAsObject__SWIG_1(swigCPtr, this, OpenSimObject.getCPtr(obj), obj);
  }

  public void setAllPropertiesUseDefault(boolean shouldUseDefault) {
    opensimModelJNI.AbstractProperty_setAllPropertiesUseDefault(swigCPtr, this, shouldUseDefault);
  }

  public void readFromXMLParentElement(SWIGTYPE_p_SimTK__Xml__Element parent, int versionNumber) {
    opensimModelJNI.AbstractProperty_readFromXMLParentElement(swigCPtr, this, SWIGTYPE_p_SimTK__Xml__Element.getCPtr(parent), versionNumber);
  }

  public void writeToXMLParentElement(SWIGTYPE_p_SimTK__Xml__Element parent) {
    opensimModelJNI.AbstractProperty_writeToXMLParentElement(swigCPtr, this, SWIGTYPE_p_SimTK__Xml__Element.getCPtr(parent));
  }

  public void setName(String name) {
    opensimModelJNI.AbstractProperty_setName(swigCPtr, this, name);
  }

  public void setComment(String aComment) {
    opensimModelJNI.AbstractProperty_setComment(swigCPtr, this, aComment);
  }

  public void setUseDefault(boolean aTrueFalse) {
    opensimModelJNI.AbstractProperty_setUseDefault(swigCPtr, this, aTrueFalse);
  }

  public String getName() {
    return opensimModelJNI.AbstractProperty_getName(swigCPtr, this);
  }

  public String getComment() {
    return opensimModelJNI.AbstractProperty_getComment(swigCPtr, this);
  }

  public boolean getUseDefault() {
    return opensimModelJNI.AbstractProperty_getUseDefault(swigCPtr, this);
  }

  public int getMinListSize() {
    return opensimModelJNI.AbstractProperty_getMinListSize(swigCPtr, this);
  }

  public int getMaxListSize() {
    return opensimModelJNI.AbstractProperty_getMaxListSize(swigCPtr, this);
  }

  public boolean isOptionalProperty() {
    return opensimModelJNI.AbstractProperty_isOptionalProperty(swigCPtr, this);
  }

  public boolean isListProperty() {
    return opensimModelJNI.AbstractProperty_isListProperty(swigCPtr, this);
  }

  public boolean isOneValueProperty() {
    return opensimModelJNI.AbstractProperty_isOneValueProperty(swigCPtr, this);
  }

  public boolean isOneObjectProperty() {
    return opensimModelJNI.AbstractProperty_isOneObjectProperty(swigCPtr, this);
  }

}
