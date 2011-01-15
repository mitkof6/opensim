/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.37
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.opensim.modeling;

public class Coordinate extends ModelComponent {
  private long swigCPtr;

  public Coordinate(long cPtr, boolean cMemoryOwn) {
    super(opensimModelJNI.SWIGStorageUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  public static long getCPtr(Coordinate obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if(swigCPtr != 0 && swigCMemOwn) {
      swigCMemOwn = false;
      opensimModelJNI.delete_Coordinate(swigCPtr);
    }
    swigCPtr = 0;
    super.delete();
  }

  public Coordinate() {
    this(opensimModelJNI.new_Coordinate__SWIG_0(), true);
  }

  public Coordinate(String aName, Coordinate.MotionType aMotionType, double aRangeMin, double aRangeMax) {
    this(opensimModelJNI.new_Coordinate__SWIG_1(aName, aMotionType.swigValue(), aRangeMin, aRangeMax), true);
  }

  public Coordinate(Coordinate aCoordinate) {
    this(opensimModelJNI.new_Coordinate__SWIG_2(Coordinate.getCPtr(aCoordinate), aCoordinate), true);
  }

  public OpenSimObject copy() {
    long cPtr = opensimModelJNI.Coordinate_copy__SWIG_0(swigCPtr, this);
    return (cPtr == 0) ? null : new OpenSimObject(cPtr, false);
  }

  public void copyData(Coordinate aCoordinate) {
    opensimModelJNI.Coordinate_copyData(swigCPtr, this, Coordinate.getCPtr(aCoordinate), aCoordinate);
  }

  public void setup(Model aModel) {
    opensimModelJNI.Coordinate_setup(swigCPtr, this, Model.getCPtr(aModel), aModel);
  }

  public void setJoint(Joint aOwningJoint) {
    opensimModelJNI.Coordinate_setJoint(swigCPtr, this, Joint.getCPtr(aOwningJoint), aOwningJoint);
  }

  public Joint getJoint() {
    return new Joint(opensimModelJNI.Coordinate_getJoint(swigCPtr, this), false);
  }

  public Model getModel() {
    return new Model(opensimModelJNI.Coordinate_getModel(swigCPtr, this), false);
  }

  public void updateFromCoordinate(Coordinate aCoordinate) {
    opensimModelJNI.Coordinate_updateFromCoordinate(swigCPtr, this, Coordinate.getCPtr(aCoordinate), aCoordinate);
  }

  public double getValue(SWIGTYPE_p_SimTK__State s) {
    return opensimModelJNI.Coordinate_getValue(swigCPtr, this, SWIGTYPE_p_SimTK__State.getCPtr(s));
  }

  public boolean setValue(SWIGTYPE_p_SimTK__State s, double aValue, boolean aEnforceContraints) {
    return opensimModelJNI.Coordinate_setValue__SWIG_0(swigCPtr, this, SWIGTYPE_p_SimTK__State.getCPtr(s), aValue, aEnforceContraints);
  }

  public boolean setValue(SWIGTYPE_p_SimTK__State s, double aValue) {
    return opensimModelJNI.Coordinate_setValue__SWIG_1(swigCPtr, this, SWIGTYPE_p_SimTK__State.getCPtr(s), aValue);
  }

  public double getSpeedValue(SWIGTYPE_p_SimTK__State s) {
    return opensimModelJNI.Coordinate_getSpeedValue(swigCPtr, this, SWIGTYPE_p_SimTK__State.getCPtr(s));
  }

  public boolean setSpeedValue(SWIGTYPE_p_SimTK__State s, double aValue) {
    return opensimModelJNI.Coordinate_setSpeedValue(swigCPtr, this, SWIGTYPE_p_SimTK__State.getCPtr(s), aValue);
  }

  public String getSpeedName() {
    return opensimModelJNI.Coordinate_getSpeedName(swigCPtr, this);
  }

  public double getAccelerationValue(SWIGTYPE_p_SimTK__State s) {
    return opensimModelJNI.Coordinate_getAccelerationValue(swigCPtr, this, SWIGTYPE_p_SimTK__State.getCPtr(s));
  }

  public boolean getValueUseDefault() {
    return opensimModelJNI.Coordinate_getValueUseDefault(swigCPtr, this);
  }

  public void getRange(double[] rRange) {
    opensimModelJNI.Coordinate_getRange(swigCPtr, this, rRange);
  }

  public boolean setRange(double[] aRange) {
    return opensimModelJNI.Coordinate_setRange(swigCPtr, this, aRange);
  }

  public double getRangeMin() {
    return opensimModelJNI.Coordinate_getRangeMin(swigCPtr, this);
  }

  public double getRangeMax() {
    return opensimModelJNI.Coordinate_getRangeMax(swigCPtr, this);
  }

  public boolean setRangeMin(double aMin) {
    return opensimModelJNI.Coordinate_setRangeMin(swigCPtr, this, aMin);
  }

  public boolean setRangeMax(double aMax) {
    return opensimModelJNI.Coordinate_setRangeMax(swigCPtr, this, aMax);
  }

  public boolean getRangeUseDefault() {
    return opensimModelJNI.Coordinate_getRangeUseDefault(swigCPtr, this);
  }

  public double getDefaultValue() {
    return opensimModelJNI.Coordinate_getDefaultValue(swigCPtr, this);
  }

  public boolean setDefaultValue(double aDefaultValue) {
    return opensimModelJNI.Coordinate_setDefaultValue(swigCPtr, this, aDefaultValue);
  }

  public double getDefaultSpeedValue() {
    return opensimModelJNI.Coordinate_getDefaultSpeedValue(swigCPtr, this);
  }

  public void setDefaultSpeedValue(double aDefaultSpeedValue) {
    opensimModelJNI.Coordinate_setDefaultSpeedValue(swigCPtr, this, aDefaultSpeedValue);
  }

  public double getInitialValue() {
    return opensimModelJNI.Coordinate_getInitialValue(swigCPtr, this);
  }

  public void setInitialValue(double aInitialValue) {
    opensimModelJNI.Coordinate_setInitialValue(swigCPtr, this, aInitialValue);
  }

  public boolean getDefaultValueUseDefault() {
    return opensimModelJNI.Coordinate_getDefaultValueUseDefault(swigCPtr, this);
  }

  public boolean getClamped(SWIGTYPE_p_SimTK__State s) {
    return opensimModelJNI.Coordinate_getClamped(swigCPtr, this, SWIGTYPE_p_SimTK__State.getCPtr(s));
  }

  public boolean setClamped(SWIGTYPE_p_SimTK__State s, boolean aClamped) {
    return opensimModelJNI.Coordinate_setClamped(swigCPtr, this, SWIGTYPE_p_SimTK__State.getCPtr(s), aClamped);
  }

  public boolean getDefaultClamped() {
    return opensimModelJNI.Coordinate_getDefaultClamped(swigCPtr, this);
  }

  public void setDefaultClamped(boolean aClamped) {
    opensimModelJNI.Coordinate_setDefaultClamped(swigCPtr, this, aClamped);
  }

  public boolean getClampedUseDefault() {
    return opensimModelJNI.Coordinate_getClampedUseDefault(swigCPtr, this);
  }

  public boolean getLocked(SWIGTYPE_p_SimTK__State s) {
    return opensimModelJNI.Coordinate_getLocked(swigCPtr, this, SWIGTYPE_p_SimTK__State.getCPtr(s));
  }

  public boolean setLocked(SWIGTYPE_p_SimTK__State s, boolean aLocked) {
    return opensimModelJNI.Coordinate_setLocked(swigCPtr, this, SWIGTYPE_p_SimTK__State.getCPtr(s), aLocked);
  }

  public boolean getDefaultLocked() {
    return opensimModelJNI.Coordinate_getDefaultLocked(swigCPtr, this);
  }

  public void setDefaultLocked(boolean aLocked) {
    opensimModelJNI.Coordinate_setDefaultLocked(swigCPtr, this, aLocked);
  }

  public boolean getLockedUseDefault() {
    return opensimModelJNI.Coordinate_getLockedUseDefault(swigCPtr, this);
  }

  public boolean isPrescribed(SWIGTYPE_p_SimTK__State s) {
    return opensimModelJNI.Coordinate_isPrescribed(swigCPtr, this, SWIGTYPE_p_SimTK__State.getCPtr(s));
  }

  public void setIsPrescribed(SWIGTYPE_p_SimTK__State s, boolean isPrescribed) {
    opensimModelJNI.Coordinate_setIsPrescribed(swigCPtr, this, SWIGTYPE_p_SimTK__State.getCPtr(s), isPrescribed);
  }

  public boolean getDefaultIsPrescribed() {
    return opensimModelJNI.Coordinate_getDefaultIsPrescribed(swigCPtr, this);
  }

  public void setDefaultIsPrescribed(boolean isPrescribed) {
    opensimModelJNI.Coordinate_setDefaultIsPrescribed(swigCPtr, this, isPrescribed);
  }

  public void setPrescribedFunction(Function function) {
    opensimModelJNI.Coordinate_setPrescribedFunction(swigCPtr, this, Function.getCPtr(function), function);
  }

  public Function getPrescribedFunction() {
    long cPtr = opensimModelJNI.Coordinate_getPrescribedFunction(swigCPtr, this);
    return (cPtr == 0) ? null : new Function(cPtr, false);
  }

  public Coordinate.MotionType getMotionType() {
    return Coordinate.MotionType.swigToEnum(opensimModelJNI.Coordinate_getMotionType(swigCPtr, this));
  }

  public void setMotionType(Coordinate.MotionType aMotionType) {
    opensimModelJNI.Coordinate_setMotionType(swigCPtr, this, aMotionType.swigValue());
  }

  public boolean isDependent(SWIGTYPE_p_SimTK__State s) {
    return opensimModelJNI.Coordinate_isDependent(swigCPtr, this, SWIGTYPE_p_SimTK__State.getCPtr(s));
  }

  public boolean isConstrained(SWIGTYPE_p_SimTK__State s) {
    return opensimModelJNI.Coordinate_isConstrained(swigCPtr, this, SWIGTYPE_p_SimTK__State.getCPtr(s));
  }

  public int getMobilityIndex() {
    return opensimModelJNI.Coordinate_getMobilityIndex(swigCPtr, this);
  }

  public SWIGTYPE_p_SimTK__MobilizedBodyIndex getBodyIndex() {
    return new SWIGTYPE_p_SimTK__MobilizedBodyIndex(opensimModelJNI.Coordinate_getBodyIndex(swigCPtr, this), true);
  }

  public String getStateVariableName(int index) {
    return opensimModelJNI.Coordinate_getStateVariableName(swigCPtr, this, index);
  }

  public int getStateVariableYIndex(int index) {
    return opensimModelJNI.Coordinate_getStateVariableYIndex(swigCPtr, this, index);
  }

  public static boolean isKindOf(String type) {
    return opensimModelJNI.Coordinate_isKindOf(type);
  }

  public boolean isA(String type) {
    return opensimModelJNI.Coordinate_isA(swigCPtr, this, type);
  }

  public static Coordinate safeDownCast(OpenSimObject obj) {
    long cPtr = opensimModelJNI.Coordinate_safeDownCast(OpenSimObject.getCPtr(obj), obj);
    return (cPtr == 0) ? null : new Coordinate(cPtr, false);
  }

  public void copy(OpenSimObject aObject) {
    opensimModelJNI.Coordinate_copy__SWIG_1(swigCPtr, this, OpenSimObject.getCPtr(aObject), aObject);
  }

  public final static class MotionType {
    public final static MotionType Rotational = new MotionType("Rotational");
    public final static MotionType Translational = new MotionType("Translational");
    public final static MotionType Coupled = new MotionType("Coupled");

    public final int swigValue() {
      return swigValue;
    }

    public String toString() {
      return swigName;
    }

    public static MotionType swigToEnum(int swigValue) {
      if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
        return swigValues[swigValue];
      for (int i = 0; i < swigValues.length; i++)
        if (swigValues[i].swigValue == swigValue)
          return swigValues[i];
      throw new IllegalArgumentException("No enum " + MotionType.class + " with value " + swigValue);
    }

    private MotionType(String swigName) {
      this.swigName = swigName;
      this.swigValue = swigNext++;
    }

    private MotionType(String swigName, int swigValue) {
      this.swigName = swigName;
      this.swigValue = swigValue;
      swigNext = swigValue+1;
    }

    private MotionType(String swigName, MotionType swigEnum) {
      this.swigName = swigName;
      this.swigValue = swigEnum.swigValue;
      swigNext = this.swigValue+1;
    }

    private static MotionType[] swigValues = { Rotational, Translational, Coupled };
    private static int swigNext = 0;
    private final int swigValue;
    private final String swigName;
  }

}
