/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.2
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package cimgui.internal;

public class ImGuiColumnData {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  public ImGuiColumnData(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  public static long getCPtr(ImGuiColumnData obj) {
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
        CImGuiJNI.delete_ImGuiColumnData(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setOffsetNorm(float value) {
    CImGuiJNI.ImGuiColumnData_OffsetNorm_set(swigCPtr, this, value);
  }

  public float getOffsetNorm() {
    return CImGuiJNI.ImGuiColumnData_OffsetNorm_get(swigCPtr, this);
  }

  public void setOffsetNormBeforeResize(float value) {
    CImGuiJNI.ImGuiColumnData_OffsetNormBeforeResize_set(swigCPtr, this, value);
  }

  public float getOffsetNormBeforeResize() {
    return CImGuiJNI.ImGuiColumnData_OffsetNormBeforeResize_get(swigCPtr, this);
  }

  public void setFlags(int value) {
    CImGuiJNI.ImGuiColumnData_Flags_set(swigCPtr, this, value);
  }

  public int getFlags() {
    return CImGuiJNI.ImGuiColumnData_Flags_get(swigCPtr, this);
  }

  public void setClipRect(ImRect value) {
    CImGuiJNI.ImGuiColumnData_ClipRect_set(swigCPtr, this, ImRect.getCPtr(value), value);
  }

  public ImRect getClipRect() {
    long cPtr = CImGuiJNI.ImGuiColumnData_ClipRect_get(swigCPtr, this);
    return (cPtr == 0) ? null : new ImRect(cPtr, false);
  }

  public ImGuiColumnData() {
    this(CImGuiJNI.new_ImGuiColumnData(), true);
  }

}
