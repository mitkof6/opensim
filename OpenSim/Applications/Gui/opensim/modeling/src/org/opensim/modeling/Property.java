/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.31
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.opensim.modeling;

public class Property {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  public Property(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  public static long getCPtr(Property obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if(swigCPtr != 0 && swigCMemOwn) {
      swigCMemOwn = false;
      opensimModelJNI.delete_Property(swigCPtr);
    }
    swigCPtr = 0;
  }

  public Property copy() {
    long cPtr = opensimModelJNI.Property_copy(swigCPtr, this);
    return (cPtr == 0) ? null : new Property(cPtr, false);
  }

  public void setNull() {
    opensimModelJNI.Property_setNull(swigCPtr, this);
  }

  public void setType(Property.PropertyType aType) {
    opensimModelJNI.Property_setType(swigCPtr, this, aType.swigValue());
  }

  public Property.PropertyType getType() {
    return Property.PropertyType.swigToEnum(opensimModelJNI.Property_getType(swigCPtr, this));
  }

  public String getTypeAsString() {
    return opensimModelJNI.Property_getTypeAsString(swigCPtr, this);
  }

  public void setName(String aName) {
    opensimModelJNI.Property_setName(swigCPtr, this, aName);
  }

  public String getName() {
    return opensimModelJNI.Property_getName(swigCPtr, this);
  }

  public void setComment(String aComment) {
    opensimModelJNI.Property_setComment(swigCPtr, this, aComment);
  }

  public String getComment() {
    return opensimModelJNI.Property_getComment(swigCPtr, this);
  }

  public String toString() {
    return opensimModelJNI.Property_toString(swigCPtr, this);
  }

  public void setAllowableArraySize(int aMin, int aMax) {
    opensimModelJNI.Property_setAllowableArraySize__SWIG_0(swigCPtr, this, aMin, aMax);
  }

  public void setAllowableArraySize(int aNum) {
    opensimModelJNI.Property_setAllowableArraySize__SWIG_1(swigCPtr, this, aNum);
  }

  public int getMinArraySize() {
    return opensimModelJNI.Property_getMinArraySize(swigCPtr, this);
  }

  public int getMaxArraySize() {
    return opensimModelJNI.Property_getMaxArraySize(swigCPtr, this);
  }

  public void setValue(boolean aValue) {
    opensimModelJNI.Property_setValue__SWIG_0(swigCPtr, this, aValue);
  }

  public boolean getValueBool() {
    return opensimModelJNI.Property_getValueBool(swigCPtr, this);
  }

  public void setValue(int aValue) {
    opensimModelJNI.Property_setValue__SWIG_1(swigCPtr, this, aValue);
  }

  public int getValueInt() {
    return opensimModelJNI.Property_getValueInt(swigCPtr, this);
  }

  public void setValue(double aValue) {
    opensimModelJNI.Property_setValue__SWIG_2(swigCPtr, this, aValue);
  }

  public double getValueDbl() {
    return opensimModelJNI.Property_getValueDbl(swigCPtr, this);
  }

  public void setValue(String aValue) {
    opensimModelJNI.Property_setValue__SWIG_3(swigCPtr, this, aValue);
  }

  public String getValueStr() {
    return opensimModelJNI.Property_getValueStr(swigCPtr, this);
  }

  public void setValue(int aSize, boolean[] aArray) {
    opensimModelJNI.Property_setValue__SWIG_4(swigCPtr, this, aSize, aArray);
  }

  public void setValue(ArrayBool aArray) {
    opensimModelJNI.Property_setValue__SWIG_5(swigCPtr, this, ArrayBool.getCPtr(aArray), aArray);
  }

  public ArrayBool getValueBoolArray() {
    return new ArrayBool(opensimModelJNI.Property_getValueBoolArray(swigCPtr, this), false);
  }

  public void setValue(int aSize, int[] aArray) {
    opensimModelJNI.Property_setValue__SWIG_6(swigCPtr, this, aSize, aArray);
  }

  public void setValue(ArrayInt aArray) {
    opensimModelJNI.Property_setValue__SWIG_7(swigCPtr, this, ArrayInt.getCPtr(aArray), aArray);
  }

  public ArrayInt getValueIntArray() {
    return new ArrayInt(opensimModelJNI.Property_getValueIntArray(swigCPtr, this), false);
  }

  public void setValue(int aSize, double[] aArray) {
    opensimModelJNI.Property_setValue__SWIG_8(swigCPtr, this, aSize, aArray);
  }

  public void setValue(ArrayDouble aArray) {
    opensimModelJNI.Property_setValue__SWIG_9(swigCPtr, this, ArrayDouble.getCPtr(aArray), aArray);
  }

  public ArrayDouble getValueDblArray() {
    return new ArrayDouble(opensimModelJNI.Property_getValueDblArray(swigCPtr, this), false);
  }

  public void setValue(int aSize, SWIGTYPE_p_std__string aArray) {
    opensimModelJNI.Property_setValue__SWIG_10(swigCPtr, this, aSize, SWIGTYPE_p_std__string.getCPtr(aArray));
  }

  public void setValue(ArrayStr aArray) {
    opensimModelJNI.Property_setValue__SWIG_11(swigCPtr, this, ArrayStr.getCPtr(aArray), aArray);
  }

  public ArrayStr getValueStrArray() {
    return new ArrayStr(opensimModelJNI.Property_getValueStrArray(swigCPtr, this), false);
  }

  public boolean isValidObject(OpenSimObject aValue) {
    return opensimModelJNI.Property_isValidObject(swigCPtr, this, OpenSimObject.getCPtr(aValue), aValue);
  }

  public OpenSimObject getValueObj() {
    return new OpenSimObject(opensimModelJNI.Property_getValueObj(swigCPtr, this), false);
  }

  public void setValue(OpenSimObject aValue) {
    opensimModelJNI.Property_setValue__SWIG_12(swigCPtr, this, OpenSimObject.getCPtr(aValue), aValue);
  }

  public OpenSimObject getValueObjPtr() {
    long cPtr = opensimModelJNI.Property_getValueObjPtr__SWIG_0(swigCPtr, this);
    return (cPtr == 0) ? null : new OpenSimObject(cPtr, false);
  }

  public OpenSimObject getValueObjPtr(int index) {
    long cPtr = opensimModelJNI.Property_getValueObjPtr__SWIG_1(swigCPtr, this, index);
    return (cPtr == 0) ? null : new OpenSimObject(cPtr, false);
  }

  public void appendValue(OpenSimObject obj) {
    opensimModelJNI.Property_appendValue(swigCPtr, this, OpenSimObject.getCPtr(obj), obj);
  }

  public void clearObjArray() {
    opensimModelJNI.Property_clearObjArray(swigCPtr, this);
  }

  public void setUseDefault(boolean aTrueFalse) {
    opensimModelJNI.Property_setUseDefault(swigCPtr, this, aTrueFalse);
  }

  public boolean getUseDefault() {
    return opensimModelJNI.Property_getUseDefault(swigCPtr, this);
  }

  public int getArraySize() {
    return opensimModelJNI.Property_getArraySize(swigCPtr, this);
  }

  public final static class PropertyType {
    public final static PropertyType None = new PropertyType("None", opensimModelJNI.Property_None_get());
    public final static PropertyType Bool = new PropertyType("Bool");
    public final static PropertyType Int = new PropertyType("Int");
    public final static PropertyType Dbl = new PropertyType("Dbl");
    public final static PropertyType Str = new PropertyType("Str");
    public final static PropertyType Obj = new PropertyType("Obj");
    public final static PropertyType ObjPtr = new PropertyType("ObjPtr");
    public final static PropertyType BoolArray = new PropertyType("BoolArray");
    public final static PropertyType IntArray = new PropertyType("IntArray");
    public final static PropertyType DblArray = new PropertyType("DblArray");
    public final static PropertyType StrArray = new PropertyType("StrArray");
    public final static PropertyType ObjArray = new PropertyType("ObjArray");
    public final static PropertyType DblVec3 = new PropertyType("DblVec3");
    public final static PropertyType Transform = new PropertyType("Transform");

    public final int swigValue() {
      return swigValue;
    }

    public String toString() {
      return swigName;
    }

    public static PropertyType swigToEnum(int swigValue) {
      if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
        return swigValues[swigValue];
      for (int i = 0; i < swigValues.length; i++)
        if (swigValues[i].swigValue == swigValue)
          return swigValues[i];
      throw new IllegalArgumentException("No enum " + PropertyType.class + " with value " + swigValue);
    }

    private PropertyType(String swigName) {
      this.swigName = swigName;
      this.swigValue = swigNext++;
    }

    private PropertyType(String swigName, int swigValue) {
      this.swigName = swigName;
      this.swigValue = swigValue;
      swigNext = swigValue+1;
    }

    private PropertyType(String swigName, PropertyType swigEnum) {
      this.swigName = swigName;
      this.swigValue = swigEnum.swigValue;
      swigNext = this.swigValue+1;
    }

    private static PropertyType[] swigValues = { None, Bool, Int, Dbl, Str, Obj, ObjPtr, BoolArray, IntArray, DblArray, StrArray, ObjArray, DblVec3, Transform };
    private static int swigNext = 0;
    private final int swigValue;
    private final String swigName;
  }

  public final static class PropertyCategory {
    public final static PropertyCategory NoCategory = new PropertyCategory("NoCategory");
    public final static PropertyCategory Display = new PropertyCategory("Display");
    public final static PropertyCategory System = new PropertyCategory("System");
    public final static PropertyCategory Dynamics = new PropertyCategory("Dynamics");

    public final int swigValue() {
      return swigValue;
    }

    public String toString() {
      return swigName;
    }

    public static PropertyCategory swigToEnum(int swigValue) {
      if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
        return swigValues[swigValue];
      for (int i = 0; i < swigValues.length; i++)
        if (swigValues[i].swigValue == swigValue)
          return swigValues[i];
      throw new IllegalArgumentException("No enum " + PropertyCategory.class + " with value " + swigValue);
    }

    private PropertyCategory(String swigName) {
      this.swigName = swigName;
      this.swigValue = swigNext++;
    }

    private PropertyCategory(String swigName, int swigValue) {
      this.swigName = swigName;
      this.swigValue = swigValue;
      swigNext = swigValue+1;
    }

    private PropertyCategory(String swigName, PropertyCategory swigEnum) {
      this.swigName = swigName;
      this.swigValue = swigEnum.swigValue;
      swigNext = this.swigValue+1;
    }

    private static PropertyCategory[] swigValues = { NoCategory, Display, System, Dynamics };
    private static int swigNext = 0;
    private final int swigValue;
    private final String swigName;
  }

}
