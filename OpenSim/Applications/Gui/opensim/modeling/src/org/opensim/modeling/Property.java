/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.29
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.opensim.modeling;

public class Property {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected Property(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(Property obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public void delete() {
    if(swigCPtr != 0 && swigCMemOwn) {
      swigCMemOwn = false;
      opensimModelJNI.delete_Property(swigCPtr);
    }
    swigCPtr = 0;
  }

  public Property copy() {
    long cPtr = opensimModelJNI.Property_copy(swigCPtr);
    return (cPtr == 0) ? null : new Property(cPtr, false);
  }

  public void setNull() {
    opensimModelJNI.Property_setNull(swigCPtr);
  }

  public void setType(Property.PropertyType aType) {
    opensimModelJNI.Property_setType(swigCPtr, aType.swigValue());
  }

  public Property.PropertyType getType() {
    return Property.PropertyType.swigToEnum(opensimModelJNI.Property_getType(swigCPtr));
  }

  public String getTypeAsString() {
    return opensimModelJNI.Property_getTypeAsString(swigCPtr);
  }

  public void setName(String aName) {
    opensimModelJNI.Property_setName(swigCPtr, aName);
  }

  public String getName() {
    return opensimModelJNI.Property_getName(swigCPtr);
  }

  public void setComment(String aComment) {
    opensimModelJNI.Property_setComment(swigCPtr, aComment);
  }

  public String getComment() {
    return opensimModelJNI.Property_getComment(swigCPtr);
  }

  public String toString() {
    return opensimModelJNI.Property_toString(swigCPtr);
  }

  public void setValue(boolean aValue) {
    opensimModelJNI.Property_setValue__SWIG_0(swigCPtr, aValue);
  }

  public SWIGTYPE_p_bool getValueBool() {
    return new SWIGTYPE_p_bool(opensimModelJNI.Property_getValueBool(swigCPtr), false);
  }

  public void setValue(int aValue) {
    opensimModelJNI.Property_setValue__SWIG_1(swigCPtr, aValue);
  }

  public SWIGTYPE_p_int getValueInt() {
    return new SWIGTYPE_p_int(opensimModelJNI.Property_getValueInt(swigCPtr), false);
  }

  public void setValue(double aValue) {
    opensimModelJNI.Property_setValue__SWIG_2(swigCPtr, aValue);
  }

  public SWIGTYPE_p_double getValueDbl() {
    return new SWIGTYPE_p_double(opensimModelJNI.Property_getValueDbl(swigCPtr), false);
  }

  public void setValue(String aValue) {
    opensimModelJNI.Property_setValue__SWIG_3(swigCPtr, aValue);
  }

  public SWIGTYPE_p_std__string getValueStr() {
    return new SWIGTYPE_p_std__string(opensimModelJNI.Property_getValueStr(swigCPtr), false);
  }

  public void setValue(OpenSimObject aValue) {
    opensimModelJNI.Property_setValue__SWIG_4(swigCPtr, OpenSimObject.getCPtr(aValue));
  }

  public OpenSimObject getValueObj() {
    return new OpenSimObject(opensimModelJNI.Property_getValueObj(swigCPtr), false);
  }

  public void setValue(int aSize, boolean[] aArray) {
    opensimModelJNI.Property_setValue__SWIG_5(swigCPtr, aSize, aArray);
  }

  public void setValue(ArrayBool aArray) {
    opensimModelJNI.Property_setValue__SWIG_6(swigCPtr, ArrayBool.getCPtr(aArray));
  }

  public ArrayBool getValueBoolArray() {
    return new ArrayBool(opensimModelJNI.Property_getValueBoolArray(swigCPtr), false);
  }

  public void setValue(int aSize, int[] aArray) {
    opensimModelJNI.Property_setValue__SWIG_7(swigCPtr, aSize, aArray);
  }

  public void setValue(ArrayInt aArray) {
    opensimModelJNI.Property_setValue__SWIG_8(swigCPtr, ArrayInt.getCPtr(aArray));
  }

  public ArrayInt getValueIntArray() {
    return new ArrayInt(opensimModelJNI.Property_getValueIntArray(swigCPtr), false);
  }

  public void setValue(int aSize, double[] aArray) {
    opensimModelJNI.Property_setValue__SWIG_9(swigCPtr, aSize, aArray);
  }

  public void setValue(ArrayDouble aArray) {
    opensimModelJNI.Property_setValue__SWIG_10(swigCPtr, ArrayDouble.getCPtr(aArray));
  }

  public ArrayDouble getValueDblArray() {
    return new ArrayDouble(opensimModelJNI.Property_getValueDblArray(swigCPtr), false);
  }

  public void setValue(int aSize, SWIGTYPE_p_std__string aArray) {
    opensimModelJNI.Property_setValue__SWIG_11(swigCPtr, aSize, SWIGTYPE_p_std__string.getCPtr(aArray));
  }

  public void setValue(ArrayStr aArray) {
    opensimModelJNI.Property_setValue__SWIG_12(swigCPtr, ArrayStr.getCPtr(aArray));
  }

  public ArrayStr getValueStrArray() {
    return new ArrayStr(opensimModelJNI.Property_getValueStrArray(swigCPtr), false);
  }

  public void setValue(int aSize, SWIGTYPE_p_p_OpenSim__Object aArray) {
    opensimModelJNI.Property_setValue__SWIG_13(swigCPtr, aSize, SWIGTYPE_p_p_OpenSim__Object.getCPtr(aArray));
  }

  public void setValue(ArrayPtrsObj aArray) {
    opensimModelJNI.Property_setValue__SWIG_14(swigCPtr, ArrayPtrsObj.getCPtr(aArray));
  }

  public ArrayPtrsObj getValueObjArray() {
    return new ArrayPtrsObj(opensimModelJNI.Property_getValueObjArray(swigCPtr), false);
  }

  public void setUseDefault(boolean aTrueFalse) {
    opensimModelJNI.Property_setUseDefault(swigCPtr, aTrueFalse);
  }

  public boolean getUseDefault() {
    return opensimModelJNI.Property_getUseDefault(swigCPtr);
  }

  public final static class PropertyType {
    public final static PropertyType None = new PropertyType("None", opensimModelJNI.Property_None_get());
    public final static PropertyType Bool = new PropertyType("Bool");
    public final static PropertyType Int = new PropertyType("Int");
    public final static PropertyType Flt = new PropertyType("Flt");
    public final static PropertyType Dbl = new PropertyType("Dbl");
    public final static PropertyType Str = new PropertyType("Str");
    public final static PropertyType Obj = new PropertyType("Obj");
    public final static PropertyType BoolArray = new PropertyType("BoolArray");
    public final static PropertyType IntArray = new PropertyType("IntArray");
    public final static PropertyType FltArray = new PropertyType("FltArray");
    public final static PropertyType DblArray = new PropertyType("DblArray");
    public final static PropertyType StrArray = new PropertyType("StrArray");
    public final static PropertyType ObjArray = new PropertyType("ObjArray");

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

    private static PropertyType[] swigValues = { None, Bool, Int, Flt, Dbl, Str, Obj, BoolArray, IntArray, FltArray, DblArray, StrArray, ObjArray };
    private static int swigNext = 0;
    private final int swigValue;
    private final String swigName;
  }

}
