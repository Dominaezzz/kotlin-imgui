/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.1
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package cimgui.internal;

public class ImGuiTextRange {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  public ImGuiTextRange(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  public static long getCPtr(ImGuiTextRange obj) {
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
        CImGuiJNI.delete_ImGuiTextRange(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setB(String value) {
    CImGuiJNI.ImGuiTextRange_b_set(swigCPtr, this, value);
  }

  public String getB() {
    return CImGuiJNI.ImGuiTextRange_b_get(swigCPtr, this);
  }

  public void setE(String value) {
    CImGuiJNI.ImGuiTextRange_e_set(swigCPtr, this, value);
  }

  public String getE() {
    return CImGuiJNI.ImGuiTextRange_e_get(swigCPtr, this);
  }

  public ImGuiTextRange() {
    this(CImGuiJNI.new_ImGuiTextRange(), true);
  }

}