/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.29
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.opensim.modeling;

public class Transform {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  public Transform(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  public static long getCPtr(Transform obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public void delete() {
    if(swigCPtr != 0 && swigCMemOwn) {
      swigCMemOwn = false;
      opensimModelJNI.delete_Transform(swigCPtr);
    }
    swigCPtr = 0;
  }

  public Transform() {
    this(opensimModelJNI.new_Transform__SWIG_0(), true);
  }

  public Transform(Transform aTransform) {
    this(opensimModelJNI.new_Transform__SWIG_1(Transform.getCPtr(aTransform)), true);
  }

  public Transform(double r, Transform.AnglePreference preference, double[] axis) {
    this(opensimModelJNI.new_Transform__SWIG_2(r, preference.swigValue(), axis), true);
  }

  public Transform copy() {
    long cPtr = opensimModelJNI.Transform_copy(swigCPtr);
    return (cPtr == 0) ? null : new Transform(cPtr, false);
  }

  public void printMatrix() {
    opensimModelJNI.Transform_printMatrix(swigCPtr);
  }

  public void getPosition(double[] pos) {
    opensimModelJNI.Transform_getPosition(swigCPtr, pos);
  }

  public void setPosition(double[] pos) {
    opensimModelJNI.Transform_setPosition(swigCPtr, pos);
  }

  public void getOrientation(SWIGTYPE_p_a_3__double rOrientation) {
    opensimModelJNI.Transform_getOrientation(swigCPtr, SWIGTYPE_p_a_3__double.getCPtr(rOrientation));
  }

  public void setOrientation(SWIGTYPE_p_a_3__double aOrientation) {
    opensimModelJNI.Transform_setOrientation(swigCPtr, SWIGTYPE_p_a_3__double.getCPtr(aOrientation));
  }

  public void setIdentity() {
    opensimModelJNI.Transform_setIdentity(swigCPtr);
  }

  public void rotate(double[] r, Transform.AnglePreference preference, Transform.RotationOrder order) {
    opensimModelJNI.Transform_rotate(swigCPtr, r, preference.swigValue(), order.swigValue());
  }

  public void rotateX(double r, Transform.AnglePreference preference) {
    opensimModelJNI.Transform_rotateX(swigCPtr, r, preference.swigValue());
  }

  public void rotateY(double r, Transform.AnglePreference preference) {
    opensimModelJNI.Transform_rotateY(swigCPtr, r, preference.swigValue());
  }

  public void rotateZ(double r, Transform.AnglePreference preference) {
    opensimModelJNI.Transform_rotateZ(swigCPtr, r, preference.swigValue());
  }

  public void rotateAxis(double r, Transform.AnglePreference preference, double[] axis) {
    opensimModelJNI.Transform_rotateAxis(swigCPtr, r, preference.swigValue(), axis);
  }

  public void translateX(double t) {
    opensimModelJNI.Transform_translateX(swigCPtr, t);
  }

  public void translateY(double t) {
    opensimModelJNI.Transform_translateY(swigCPtr, t);
  }

  public void translateZ(double t) {
    opensimModelJNI.Transform_translateZ(swigCPtr, t);
  }

  public void translate(double[] t) {
    opensimModelJNI.Transform_translate(swigCPtr, t);
  }

  public void transformPoint(double[] pt) {
    opensimModelJNI.Transform_transformPoint__SWIG_0(swigCPtr, pt);
  }

  public void transformPoint(ArrayDouble pt) {
    opensimModelJNI.Transform_transformPoint__SWIG_1(swigCPtr, ArrayDouble.getCPtr(pt));
  }

  public void transformVector(double[] vec) {
    opensimModelJNI.Transform_transformVector__SWIG_0(swigCPtr, vec);
  }

  public void transformVector(ArrayDouble vec) {
    opensimModelJNI.Transform_transformVector__SWIG_1(swigCPtr, ArrayDouble.getCPtr(vec));
  }

  public SWIGTYPE_p_double getMatrix() {
    long cPtr = opensimModelJNI.Transform_getMatrix__SWIG_0(swigCPtr);
    return (cPtr == 0) ? null : new SWIGTYPE_p_double(cPtr, false);
  }

  public void getMatrix(double[] aMat) {
    opensimModelJNI.Transform_getMatrix__SWIG_1(swigCPtr, aMat);
  }

  public void setRotationSubmatrix(SWIGTYPE_p_a_3__double rDirCos) {
    opensimModelJNI.Transform_setRotationSubmatrix(swigCPtr, SWIGTYPE_p_a_3__double.getCPtr(rDirCos));
  }

  public final static class AxisName {
    public final static AxisName X = new AxisName("X", opensimModelJNI.Transform_X_get());
    public final static AxisName Y = new AxisName("Y", opensimModelJNI.Transform_Y_get());
    public final static AxisName Z = new AxisName("Z", opensimModelJNI.Transform_Z_get());
    public final static AxisName W = new AxisName("W", opensimModelJNI.Transform_W_get());
    public final static AxisName NoAxis = new AxisName("NoAxis", opensimModelJNI.Transform_NoAxis_get());

    public final int swigValue() {
      return swigValue;
    }

    public String toString() {
      return swigName;
    }

    public static AxisName swigToEnum(int swigValue) {
      if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
        return swigValues[swigValue];
      for (int i = 0; i < swigValues.length; i++)
        if (swigValues[i].swigValue == swigValue)
          return swigValues[i];
      throw new IllegalArgumentException("No enum " + AxisName.class + " with value " + swigValue);
    }

    private AxisName(String swigName) {
      this.swigName = swigName;
      this.swigValue = swigNext++;
    }

    private AxisName(String swigName, int swigValue) {
      this.swigName = swigName;
      this.swigValue = swigValue;
      swigNext = swigValue+1;
    }

    private AxisName(String swigName, AxisName swigEnum) {
      this.swigName = swigName;
      this.swigValue = swigEnum.swigValue;
      swigNext = this.swigValue+1;
    }

    private static AxisName[] swigValues = { X, Y, Z, W, NoAxis };
    private static int swigNext = 0;
    private final int swigValue;
    private final String swigName;
  }

  public final static class RotationOrder {
    public final static RotationOrder XYZ = new RotationOrder("XYZ", opensimModelJNI.Transform_XYZ_get());
    public final static RotationOrder XZY = new RotationOrder("XZY", opensimModelJNI.Transform_XZY_get());
    public final static RotationOrder YXZ = new RotationOrder("YXZ", opensimModelJNI.Transform_YXZ_get());
    public final static RotationOrder YZX = new RotationOrder("YZX", opensimModelJNI.Transform_YZX_get());
    public final static RotationOrder ZXY = new RotationOrder("ZXY", opensimModelJNI.Transform_ZXY_get());
    public final static RotationOrder ZYX = new RotationOrder("ZYX", opensimModelJNI.Transform_ZYX_get());

    public final int swigValue() {
      return swigValue;
    }

    public String toString() {
      return swigName;
    }

    public static RotationOrder swigToEnum(int swigValue) {
      if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
        return swigValues[swigValue];
      for (int i = 0; i < swigValues.length; i++)
        if (swigValues[i].swigValue == swigValue)
          return swigValues[i];
      throw new IllegalArgumentException("No enum " + RotationOrder.class + " with value " + swigValue);
    }

    private RotationOrder(String swigName) {
      this.swigName = swigName;
      this.swigValue = swigNext++;
    }

    private RotationOrder(String swigName, int swigValue) {
      this.swigName = swigName;
      this.swigValue = swigValue;
      swigNext = swigValue+1;
    }

    private RotationOrder(String swigName, RotationOrder swigEnum) {
      this.swigName = swigName;
      this.swigValue = swigEnum.swigValue;
      swigNext = this.swigValue+1;
    }

    private static RotationOrder[] swigValues = { XYZ, XZY, YXZ, YZX, ZXY, ZYX };
    private static int swigNext = 0;
    private final int swigValue;
    private final String swigName;
  }

  public final static class AnglePreference {
    public final static AnglePreference Radians = new AnglePreference("Radians");
    public final static AnglePreference Degrees = new AnglePreference("Degrees");

    public final int swigValue() {
      return swigValue;
    }

    public String toString() {
      return swigName;
    }

    public static AnglePreference swigToEnum(int swigValue) {
      if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
        return swigValues[swigValue];
      for (int i = 0; i < swigValues.length; i++)
        if (swigValues[i].swigValue == swigValue)
          return swigValues[i];
      throw new IllegalArgumentException("No enum " + AnglePreference.class + " with value " + swigValue);
    }

    private AnglePreference(String swigName) {
      this.swigName = swigName;
      this.swigValue = swigNext++;
    }

    private AnglePreference(String swigName, int swigValue) {
      this.swigName = swigName;
      this.swigValue = swigValue;
      swigNext = swigValue+1;
    }

    private AnglePreference(String swigName, AnglePreference swigEnum) {
      this.swigName = swigName;
      this.swigValue = swigEnum.swigValue;
      swigNext = this.swigValue+1;
    }

    private static AnglePreference[] swigValues = { Radians, Degrees };
    private static int swigNext = 0;
    private final int swigValue;
    private final String swigName;
  }

}
