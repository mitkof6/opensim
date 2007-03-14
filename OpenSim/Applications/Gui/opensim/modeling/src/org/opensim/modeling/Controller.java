/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.31
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.opensim.modeling;

public class Controller {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  public Controller(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  public static long getCPtr(Controller obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if(swigCPtr != 0 && swigCMemOwn) {
      swigCMemOwn = false;
      opensimModelJNI.delete_Controller(swigCPtr);
    }
    swigCPtr = 0;
  }

  public static int getNAME_LENGTH() {
    return opensimModelJNI.Controller_NAME_LENGTH_get();
  }

  public static int getDESCRIP_LENGTH() {
    return opensimModelJNI.Controller_DESCRIP_LENGTH_get();
  }

  public void setNull() {
    opensimModelJNI.Controller_setNull(swigCPtr, this);
  }

  public AbstractModel getModel() {
    long cPtr = opensimModelJNI.Controller_getModel(swigCPtr, this);
    return (cPtr == 0) ? null : new AbstractModel(cPtr, false);
  }

  public void setOn(boolean aTrueFalse) {
    opensimModelJNI.Controller_setOn(swigCPtr, this, aTrueFalse);
  }

  public boolean getOn() {
    return opensimModelJNI.Controller_getOn(swigCPtr, this);
  }

  public void setName(String aName) {
    opensimModelJNI.Controller_setName(swigCPtr, this, aName);
  }

  public String getName() {
    return opensimModelJNI.Controller_getName(swigCPtr, this);
  }

  public void setDescription(String aDescrip) {
    opensimModelJNI.Controller_setDescription(swigCPtr, this, aDescrip);
  }

  public String getDescription() {
    return opensimModelJNI.Controller_getDescription(swigCPtr, this);
  }

  public void computeControls(SWIGTYPE_p_double rDT, double aT, SWIGTYPE_p_double aY, ControlSet rX) {
    opensimModelJNI.Controller_computeControls(swigCPtr, this, SWIGTYPE_p_double.getCPtr(rDT), aT, SWIGTYPE_p_double.getCPtr(aY), ControlSet.getCPtr(rX), rX);
  }

}
