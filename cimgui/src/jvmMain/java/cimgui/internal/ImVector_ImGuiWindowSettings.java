/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.2
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package cimgui.internal;

public class ImVector_ImGuiWindowSettings {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  public ImVector_ImGuiWindowSettings(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  public static long getCPtr(ImVector_ImGuiWindowSettings obj) {
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
        CImGuiJNI.delete_ImVector_ImGuiWindowSettings(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setSize(int value) {
    CImGuiJNI.ImVector_ImGuiWindowSettings_Size_set(swigCPtr, this, value);
  }

  public int getSize() {
    return CImGuiJNI.ImVector_ImGuiWindowSettings_Size_get(swigCPtr, this);
  }

  public void setCapacity(int value) {
    CImGuiJNI.ImVector_ImGuiWindowSettings_Capacity_set(swigCPtr, this, value);
  }

  public int getCapacity() {
    return CImGuiJNI.ImVector_ImGuiWindowSettings_Capacity_get(swigCPtr, this);
  }

  public void setData(ImGuiWindowSettings value) {
    CImGuiJNI.ImVector_ImGuiWindowSettings_Data_set(swigCPtr, this, ImGuiWindowSettings.getCPtr(value), value);
  }

  public ImGuiWindowSettings getData() {
    long cPtr = CImGuiJNI.ImVector_ImGuiWindowSettings_Data_get(swigCPtr, this);
    return (cPtr == 0) ? null : new ImGuiWindowSettings(cPtr, false);
  }

  public ImVector_ImGuiWindowSettings() {
    this(CImGuiJNI.new_ImVector_ImGuiWindowSettings(), true);
  }

}
