/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.1
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package cimgui.internal;

public class ImColor_Simple {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  public ImColor_Simple(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  public static long getCPtr(ImColor_Simple obj) {
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
        CImGuiJNI.delete_ImColor_Simple(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setValue(ImVec4_Simple value) {
    CImGuiJNI.ImColor_Simple_Value_set(swigCPtr, this, ImVec4_Simple.getCPtr(value), value);
  }

  public ImVec4_Simple getValue() {
    long cPtr = CImGuiJNI.ImColor_Simple_Value_get(swigCPtr, this);
    return (cPtr == 0) ? null : new ImVec4_Simple(cPtr, false);
  }

  public ImColor_Simple() {
    this(CImGuiJNI.new_ImColor_Simple(), true);
  }

}
