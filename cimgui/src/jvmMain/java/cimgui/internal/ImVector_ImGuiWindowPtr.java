/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.2
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package cimgui.internal;

public class ImVector_ImGuiWindowPtr {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  public ImVector_ImGuiWindowPtr(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  public static long getCPtr(ImVector_ImGuiWindowPtr obj) {
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
        CImGuiJNI.delete_ImVector_ImGuiWindowPtr(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setSize(int value) {
    CImGuiJNI.ImVector_ImGuiWindowPtr_Size_set(swigCPtr, this, value);
  }

  public int getSize() {
    return CImGuiJNI.ImVector_ImGuiWindowPtr_Size_get(swigCPtr, this);
  }

  public void setCapacity(int value) {
    CImGuiJNI.ImVector_ImGuiWindowPtr_Capacity_set(swigCPtr, this, value);
  }

  public int getCapacity() {
    return CImGuiJNI.ImVector_ImGuiWindowPtr_Capacity_get(swigCPtr, this);
  }

  public void setData(SWIGTYPE_p_p_ImGuiWindow value) {
    CImGuiJNI.ImVector_ImGuiWindowPtr_Data_set(swigCPtr, this, SWIGTYPE_p_p_ImGuiWindow.getCPtr(value));
  }

  public SWIGTYPE_p_p_ImGuiWindow getData() {
    long cPtr = CImGuiJNI.ImVector_ImGuiWindowPtr_Data_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_p_ImGuiWindow(cPtr, false);
  }

  public ImVector_ImGuiWindowPtr() {
    this(CImGuiJNI.new_ImVector_ImGuiWindowPtr(), true);
  }

}
