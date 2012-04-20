/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.4
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.opensim.modeling;

public class DisplayGeometry extends OpenSimObject {
  private long swigCPtr;

  public DisplayGeometry(long cPtr, boolean cMemoryOwn) {
    super(opensimModelJNI.DisplayGeometry_SWIGUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  public static long getCPtr(DisplayGeometry obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        opensimModelJNI.delete_DisplayGeometry(swigCPtr);
      }
      swigCPtr = 0;
    }
    super.delete();
  }

  public static DisplayGeometry safeDownCast(OpenSimObject obj) {
    long cPtr = opensimModelJNI.DisplayGeometry_safeDownCast(OpenSimObject.getCPtr(obj), obj);
    return (cPtr == 0) ? null : new DisplayGeometry(cPtr, false);
  }

  public void assign(OpenSimObject aObject) {
    opensimModelJNI.DisplayGeometry_assign(swigCPtr, this, OpenSimObject.getCPtr(aObject), aObject);
  }

  public static String getClassName() {
    return opensimModelJNI.DisplayGeometry_getClassName();
  }

  public OpenSimObject clone() {
    long cPtr = opensimModelJNI.DisplayGeometry_clone(swigCPtr, this);
    return (cPtr == 0) ? null : new DisplayGeometry(cPtr, false);
  }

  public String getConcreteClassName() {
    return opensimModelJNI.DisplayGeometry_getConcreteClassName(swigCPtr, this);
  }

  public DisplayGeometry() {
    this(opensimModelJNI.new_DisplayGeometry__SWIG_0(), true);
  }

  public DisplayGeometry(String aFileName) {
    this(opensimModelJNI.new_DisplayGeometry__SWIG_1(aFileName), true);
  }

  public DisplayGeometry(DisplayGeometry aDisplayGeometry) {
    this(opensimModelJNI.new_DisplayGeometry__SWIG_2(DisplayGeometry.getCPtr(aDisplayGeometry), aDisplayGeometry), true);
  }

  public String getGeometryFile() {
    return opensimModelJNI.DisplayGeometry_getGeometryFile(swigCPtr, this);
  }

  public void setGeometryFile(String aGeometryFile) {
    opensimModelJNI.DisplayGeometry_setGeometryFile(swigCPtr, this, aGeometryFile);
  }

  public SWIGTYPE_p_SimTK__Vec3 getColor() {
    return new SWIGTYPE_p_SimTK__Vec3(opensimModelJNI.DisplayGeometry_getColor__SWIG_0(swigCPtr, this), false);
  }

  public void getColor(double[] aColor) {
    opensimModelJNI.DisplayGeometry_getColor__SWIG_1(swigCPtr, this, aColor);
  }

  public void setColor(SWIGTYPE_p_SimTK__Vec3 aColor) {
    opensimModelJNI.DisplayGeometry_setColor__SWIG_0(swigCPtr, this, SWIGTYPE_p_SimTK__Vec3.getCPtr(aColor));
  }

  public void setColor(double[] aColor) {
    opensimModelJNI.DisplayGeometry_setColor__SWIG_1(swigCPtr, this, aColor);
  }

  public String getTextureFile() {
    return opensimModelJNI.DisplayGeometry_getTextureFile(swigCPtr, this);
  }

  public void setTextureFile(String aTextureFile) {
    opensimModelJNI.DisplayGeometry_setTextureFile(swigCPtr, this, aTextureFile);
  }

  public SWIGTYPE_p_SimTK__Transform getTransform() {
    return new SWIGTYPE_p_SimTK__Transform(opensimModelJNI.DisplayGeometry_getTransform(swigCPtr, this), false);
  }

  public void setTransform(SWIGTYPE_p_SimTK__Transform aTransform) {
    opensimModelJNI.DisplayGeometry_setTransform(swigCPtr, this, SWIGTYPE_p_SimTK__Transform.getCPtr(aTransform));
  }

  public void setRotationsAndTRanslations(double[] aArray) {
    opensimModelJNI.DisplayGeometry_setRotationsAndTRanslations(swigCPtr, this, aArray);
  }

  public void getRotationsAndTranslationsAsArray6(double[] aArray) {
    opensimModelJNI.DisplayGeometry_getRotationsAndTranslationsAsArray6(swigCPtr, this, aArray);
  }

  public SWIGTYPE_p_SimTK__Vec3 getScaleFactors() {
    return new SWIGTYPE_p_SimTK__Vec3(opensimModelJNI.DisplayGeometry_getScaleFactors__SWIG_0(swigCPtr, this), false);
  }

  public void getScaleFactors(double[] aScaleFactors) {
    opensimModelJNI.DisplayGeometry_getScaleFactors__SWIG_1(swigCPtr, this, aScaleFactors);
  }

  public void setScaleFactors(double[] aScaleFactors) {
    opensimModelJNI.DisplayGeometry_setScaleFactors__SWIG_0(swigCPtr, this, aScaleFactors);
  }

  public void setScaleFactors(SWIGTYPE_p_SimTK__Vec3 aScaleFactors) {
    opensimModelJNI.DisplayGeometry_setScaleFactors__SWIG_1(swigCPtr, this, SWIGTYPE_p_SimTK__Vec3.getCPtr(aScaleFactors));
  }

  public DisplayGeometry.DisplayPreference getDisplayPreference() {
    return DisplayGeometry.DisplayPreference.swigToEnum(opensimModelJNI.DisplayGeometry_getDisplayPreference(swigCPtr, this));
  }

  public void setDisplayPreference(DisplayGeometry.DisplayPreference aPreference) {
    opensimModelJNI.DisplayGeometry_setDisplayPreference(swigCPtr, this, aPreference.swigValue());
  }

  public double getOpacity() {
    return opensimModelJNI.DisplayGeometry_getOpacity(swigCPtr, this);
  }

  public void setOpacity(double aOpacity) {
    opensimModelJNI.DisplayGeometry_setOpacity(swigCPtr, this, aOpacity);
  }

  public final static class DisplayPreference {
    public final static DisplayGeometry.DisplayPreference None = new DisplayGeometry.DisplayPreference("None", opensimModelJNI.DisplayGeometry_None_get());
    public final static DisplayGeometry.DisplayPreference WireFrame = new DisplayGeometry.DisplayPreference("WireFrame", opensimModelJNI.DisplayGeometry_WireFrame_get());
    public final static DisplayGeometry.DisplayPreference SolidFill = new DisplayGeometry.DisplayPreference("SolidFill", opensimModelJNI.DisplayGeometry_SolidFill_get());
    public final static DisplayGeometry.DisplayPreference FlatShaded = new DisplayGeometry.DisplayPreference("FlatShaded", opensimModelJNI.DisplayGeometry_FlatShaded_get());
    public final static DisplayGeometry.DisplayPreference GouraudShaded = new DisplayGeometry.DisplayPreference("GouraudShaded", opensimModelJNI.DisplayGeometry_GouraudShaded_get());

    public final int swigValue() {
      return swigValue;
    }

    public String toString() {
      return swigName;
    }

    public static DisplayPreference swigToEnum(int swigValue) {
      if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
        return swigValues[swigValue];
      for (int i = 0; i < swigValues.length; i++)
        if (swigValues[i].swigValue == swigValue)
          return swigValues[i];
      throw new IllegalArgumentException("No enum " + DisplayPreference.class + " with value " + swigValue);
    }

    private DisplayPreference(String swigName) {
      this.swigName = swigName;
      this.swigValue = swigNext++;
    }

    private DisplayPreference(String swigName, int swigValue) {
      this.swigName = swigName;
      this.swigValue = swigValue;
      swigNext = swigValue+1;
    }

    private DisplayPreference(String swigName, DisplayPreference swigEnum) {
      this.swigName = swigName;
      this.swigValue = swigEnum.swigValue;
      swigNext = this.swigValue+1;
    }

    private static DisplayPreference[] swigValues = { None, WireFrame, SolidFill, FlatShaded, GouraudShaded };
    private static int swigNext = 0;
    private final int swigValue;
    private final String swigName;
  }

}
