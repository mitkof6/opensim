/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.29
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package opensimModel;

public class SimmUnits {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected SimmUnits(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(SimmUnits obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public void delete() {
    if(swigCPtr != 0 && swigCMemOwn) {
      swigCMemOwn = false;
      opensimModelJNI.delete_SimmUnits(swigCPtr);
    }
    swigCPtr = 0;
  }

  public SimmUnits() {
    this(opensimModelJNI.new_SimmUnits__SWIG_0(), true);
  }

  public SimmUnits(SimmUnits aUnits) {
    this(opensimModelJNI.new_SimmUnits__SWIG_1(SimmUnits.getCPtr(aUnits)), true);
  }

  public SimmUnits(SWIGTYPE_p_std__string str) {
    this(opensimModelJNI.new_SimmUnits__SWIG_2(SWIGTYPE_p_std__string.getCPtr(str)), true);
  }

  public SimmUnits(SimmUnits.UnitType aType) {
    this(opensimModelJNI.new_SimmUnits__SWIG_3(aType.swigValue()), true);
  }

  public double convertTo(SimmUnits.UnitType aType, double aValue) {
    return opensimModelJNI.SimmUnits_convertTo__SWIG_0(swigCPtr, aType.swigValue(), aValue);
  }

  public double convertTo(SimmUnits.UnitType aType) {
    return opensimModelJNI.SimmUnits_convertTo__SWIG_1(swigCPtr, aType.swigValue());
  }

  public double convertTo(SimmUnits aUnit) {
    return opensimModelJNI.SimmUnits_convertTo__SWIG_2(swigCPtr, SimmUnits.getCPtr(aUnit));
  }

  public SimmUnits.UnitType getType() {
    return SimmUnits.UnitType.swigToEnum(opensimModelJNI.SimmUnits_getType(swigCPtr));
  }

  public String getLabel() {
    return opensimModelJNI.SimmUnits_getLabel(swigCPtr);
  }

  public void peteTest() {
    opensimModelJNI.SimmUnits_peteTest(swigCPtr);
  }

  public final static class UnitType {
    public final static UnitType simmUnknownUnits = new UnitType("simmUnknownUnits", opensimModelJNI.SimmUnits_simmUnknownUnits_get());
    public final static UnitType simmRadians = new UnitType("simmRadians");
    public final static UnitType simmDegrees = new UnitType("simmDegrees");
    public final static UnitType simmMillimeters = new UnitType("simmMillimeters");
    public final static UnitType simmCentimeters = new UnitType("simmCentimeters");
    public final static UnitType simmMeters = new UnitType("simmMeters");
    public final static UnitType simmSeconds = new UnitType("simmSeconds");
    public final static UnitType simmMilliseconds = new UnitType("simmMilliseconds");
    public final static UnitType simmNewtons = new UnitType("simmNewtons");

    public final int swigValue() {
      return swigValue;
    }

    public String toString() {
      return swigName;
    }

    public static UnitType swigToEnum(int swigValue) {
      if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
        return swigValues[swigValue];
      for (int i = 0; i < swigValues.length; i++)
        if (swigValues[i].swigValue == swigValue)
          return swigValues[i];
      throw new IllegalArgumentException("No enum " + UnitType.class + " with value " + swigValue);
    }

    private UnitType(String swigName) {
      this.swigName = swigName;
      this.swigValue = swigNext++;
    }

    private UnitType(String swigName, int swigValue) {
      this.swigName = swigName;
      this.swigValue = swigValue;
      swigNext = swigValue+1;
    }

    private UnitType(String swigName, UnitType swigEnum) {
      this.swigName = swigName;
      this.swigValue = swigEnum.swigValue;
      swigNext = this.swigValue+1;
    }

    private static UnitType[] swigValues = { simmUnknownUnits, simmRadians, simmDegrees, simmMillimeters, simmCentimeters, simmMeters, simmSeconds, simmMilliseconds, simmNewtons };
    private static int swigNext = 0;
    private final int swigValue;
    private final String swigName;
  }

}
