/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.1
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package cimgui.internal;

public class ImVector_ImGuiShrinkWidthItem {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  public ImVector_ImGuiShrinkWidthItem(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  public static long getCPtr(ImVector_ImGuiShrinkWidthItem obj) {
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
        CImGuiJNI.delete_ImVector_ImGuiShrinkWidthItem(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setSize(int value) {
    CImGuiJNI.ImVector_ImGuiShrinkWidthItem_Size_set(swigCPtr, this, value);
  }

  public int getSize() {
    return CImGuiJNI.ImVector_ImGuiShrinkWidthItem_Size_get(swigCPtr, this);
  }

  public void setCapacity(int value) {
    CImGuiJNI.ImVector_ImGuiShrinkWidthItem_Capacity_set(swigCPtr, this, value);
  }

  public int getCapacity() {
    return CImGuiJNI.ImVector_ImGuiShrinkWidthItem_Capacity_get(swigCPtr, this);
  }

  public void setData(ImGuiShrinkWidthItem value) {
    CImGuiJNI.ImVector_ImGuiShrinkWidthItem_Data_set(swigCPtr, this, ImGuiShrinkWidthItem.getCPtr(value), value);
  }

  public ImGuiShrinkWidthItem getData() {
    long cPtr = CImGuiJNI.ImVector_ImGuiShrinkWidthItem_Data_get(swigCPtr, this);
    return (cPtr == 0) ? null : new ImGuiShrinkWidthItem(cPtr, false);
  }

  public ImVector_ImGuiShrinkWidthItem() {
    this(CImGuiJNI.new_ImVector_ImGuiShrinkWidthItem(), true);
  }

}