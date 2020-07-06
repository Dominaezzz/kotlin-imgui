/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.2
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package cimgui.internal;

public class ImVector_ImGuiItemFlags {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  public ImVector_ImGuiItemFlags(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  public static long getCPtr(ImVector_ImGuiItemFlags obj) {
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
        CImGuiJNI.delete_ImVector_ImGuiItemFlags(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setSize(int value) {
    CImGuiJNI.ImVector_ImGuiItemFlags_Size_set(swigCPtr, this, value);
  }

  public int getSize() {
    return CImGuiJNI.ImVector_ImGuiItemFlags_Size_get(swigCPtr, this);
  }

  public void setCapacity(int value) {
    CImGuiJNI.ImVector_ImGuiItemFlags_Capacity_set(swigCPtr, this, value);
  }

  public int getCapacity() {
    return CImGuiJNI.ImVector_ImGuiItemFlags_Capacity_get(swigCPtr, this);
  }

  public void setData(SWIGTYPE_p_int value) {
    CImGuiJNI.ImVector_ImGuiItemFlags_Data_set(swigCPtr, this, SWIGTYPE_p_int.getCPtr(value));
  }

  public SWIGTYPE_p_int getData() {
    long cPtr = CImGuiJNI.ImVector_ImGuiItemFlags_Data_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_int(cPtr, false);
  }

  public ImVector_ImGuiItemFlags() {
    this(CImGuiJNI.new_ImVector_ImGuiItemFlags(), true);
  }

}
