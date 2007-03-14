/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.31
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.opensim.modeling;

public class SimmTranslationDof extends AbstractDof {
  private long swigCPtr;

  public SimmTranslationDof(long cPtr, boolean cMemoryOwn) {
    super(opensimModelJNI.SWIGStorageUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  public static long getCPtr(SimmTranslationDof obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if(swigCPtr != 0 && swigCMemOwn) {
      swigCMemOwn = false;
      opensimModelJNI.delete_SimmTranslationDof(swigCPtr);
    }
    swigCPtr = 0;
    super.delete();
  }

  public SimmTranslationDof() {
    this(opensimModelJNI.new_SimmTranslationDof__SWIG_0(), true);
  }

  public SimmTranslationDof(SimmTranslationDof aDof) {
    this(opensimModelJNI.new_SimmTranslationDof__SWIG_1(SimmTranslationDof.getCPtr(aDof), aDof), true);
  }

  public OpenSimObject copy() {
    long cPtr = opensimModelJNI.SimmTranslationDof_copy(swigCPtr, this);
    return (cPtr == 0) ? null : new OpenSimObject(cPtr, false);
  }

  public void updateFromXMLNode() {
    opensimModelJNI.SimmTranslationDof_updateFromXMLNode(swigCPtr, this);
  }

  public void copyData(SimmTranslationDof aDof) {
    opensimModelJNI.SimmTranslationDof_copyData(swigCPtr, this, SimmTranslationDof.getCPtr(aDof), aDof);
  }

  public void getAxis(double[] rAxis) {
    opensimModelJNI.SimmTranslationDof_getAxis(swigCPtr, this, rAxis);
  }

  public SWIGTYPE_p_double getAxisPtr() {
    long cPtr = opensimModelJNI.SimmTranslationDof_getAxisPtr(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_double(cPtr, false);
  }

  public double getValue() {
    return opensimModelJNI.SimmTranslationDof_getValue(swigCPtr, this);
  }

  public AbstractDof.DofType getMotionType() {
    return AbstractDof.DofType.swigToEnum(opensimModelJNI.SimmTranslationDof_getMotionType(swigCPtr, this));
  }

  public void getTranslation(double[] rVec) {
    opensimModelJNI.SimmTranslationDof_getTranslation(swigCPtr, this, rVec);
  }

  public SimmTranslationDof.AxisIndex getAxisIndex() {
    return SimmTranslationDof.AxisIndex.swigToEnum(opensimModelJNI.SimmTranslationDof_getAxisIndex(swigCPtr, this));
  }

  public void peteTest() {
    opensimModelJNI.SimmTranslationDof_peteTest(swigCPtr, this);
  }

  public final static class AxisIndex {
    public final static AxisIndex xTranslation = new AxisIndex("xTranslation", opensimModelJNI.SimmTranslationDof_xTranslation_get());
    public final static AxisIndex yTranslation = new AxisIndex("yTranslation");
    public final static AxisIndex zTranslation = new AxisIndex("zTranslation");

    public final int swigValue() {
      return swigValue;
    }

    public String toString() {
      return swigName;
    }

    public static AxisIndex swigToEnum(int swigValue) {
      if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
        return swigValues[swigValue];
      for (int i = 0; i < swigValues.length; i++)
        if (swigValues[i].swigValue == swigValue)
          return swigValues[i];
      throw new IllegalArgumentException("No enum " + AxisIndex.class + " with value " + swigValue);
    }

    private AxisIndex(String swigName) {
      this.swigName = swigName;
      this.swigValue = swigNext++;
    }

    private AxisIndex(String swigName, int swigValue) {
      this.swigName = swigName;
      this.swigValue = swigValue;
      swigNext = swigValue+1;
    }

    private AxisIndex(String swigName, AxisIndex swigEnum) {
      this.swigName = swigName;
      this.swigValue = swigEnum.swigValue;
      swigNext = this.swigValue+1;
    }

    private static AxisIndex[] swigValues = { xTranslation, yTranslation, zTranslation };
    private static int swigNext = 0;
    private final int swigValue;
    private final String swigName;
  }

}
