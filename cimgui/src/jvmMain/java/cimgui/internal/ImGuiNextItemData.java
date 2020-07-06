/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.2
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package cimgui.internal;

public class ImGuiNextItemData {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  public ImGuiNextItemData(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  public static long getCPtr(ImGuiNextItemData obj) {
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
        CImGuiJNI.delete_ImGuiNextItemData(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setFlags(int value) {
    CImGuiJNI.ImGuiNextItemData_Flags_set(swigCPtr, this, value);
  }

  public int getFlags() {
    return CImGuiJNI.ImGuiNextItemData_Flags_get(swigCPtr, this);
  }

  public void setWidth(float value) {
    CImGuiJNI.ImGuiNextItemData_Width_set(swigCPtr, this, value);
  }

  public float getWidth() {
    return CImGuiJNI.ImGuiNextItemData_Width_get(swigCPtr, this);
  }

  public void setFocusScopeId(long value) {
    CImGuiJNI.ImGuiNextItemData_FocusScopeId_set(swigCPtr, this, value);
  }

  public long getFocusScopeId() {
    return CImGuiJNI.ImGuiNextItemData_FocusScopeId_get(swigCPtr, this);
  }

  public void setOpenCond(int value) {
    CImGuiJNI.ImGuiNextItemData_OpenCond_set(swigCPtr, this, value);
  }

  public int getOpenCond() {
    return CImGuiJNI.ImGuiNextItemData_OpenCond_get(swigCPtr, this);
  }

  public void setOpenVal(boolean value) {
    CImGuiJNI.ImGuiNextItemData_OpenVal_set(swigCPtr, this, value);
  }

  public boolean getOpenVal() {
    return CImGuiJNI.ImGuiNextItemData_OpenVal_get(swigCPtr, this);
  }

  public ImGuiNextItemData() {
    this(CImGuiJNI.new_ImGuiNextItemData(), true);
  }

}
