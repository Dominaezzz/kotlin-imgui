/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.1
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package cimgui.internal;

public class ImVec1 {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  public ImVec1(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  public static long getCPtr(ImVec1 obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  @SuppressWarnings("deprecation")
  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        CImGuiJNI.delete_ImVec1(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setX(float value) {
    CImGuiJNI.ImVec1_x_set(swigCPtr, this, value);
  }

  public float getX() {
    return CImGuiJNI.ImVec1_x_get(swigCPtr, this);
  }

  public ImVec1() {
    this(CImGuiJNI.new_ImVec1(), true);
  }

}