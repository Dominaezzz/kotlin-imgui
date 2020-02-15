/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.1
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package cimgui.internal;

public class ImDrawData {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  public ImDrawData(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  public static long getCPtr(ImDrawData obj) {
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
        CImGuiJNI.delete_ImDrawData(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setValid(boolean value) {
    CImGuiJNI.ImDrawData_Valid_set(swigCPtr, this, value);
  }

  public boolean getValid() {
    return CImGuiJNI.ImDrawData_Valid_get(swigCPtr, this);
  }

  public void setCmdLists(SWIGTYPE_p_p_ImDrawList value) {
    CImGuiJNI.ImDrawData_CmdLists_set(swigCPtr, this, SWIGTYPE_p_p_ImDrawList.getCPtr(value));
  }

  public SWIGTYPE_p_p_ImDrawList getCmdLists() {
    long cPtr = CImGuiJNI.ImDrawData_CmdLists_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_p_ImDrawList(cPtr, false);
  }

  public void setCmdListsCount(int value) {
    CImGuiJNI.ImDrawData_CmdListsCount_set(swigCPtr, this, value);
  }

  public int getCmdListsCount() {
    return CImGuiJNI.ImDrawData_CmdListsCount_get(swigCPtr, this);
  }

  public void setTotalIdxCount(int value) {
    CImGuiJNI.ImDrawData_TotalIdxCount_set(swigCPtr, this, value);
  }

  public int getTotalIdxCount() {
    return CImGuiJNI.ImDrawData_TotalIdxCount_get(swigCPtr, this);
  }

  public void setTotalVtxCount(int value) {
    CImGuiJNI.ImDrawData_TotalVtxCount_set(swigCPtr, this, value);
  }

  public int getTotalVtxCount() {
    return CImGuiJNI.ImDrawData_TotalVtxCount_get(swigCPtr, this);
  }

  public void setDisplayPos(ImVec2 value) {
    CImGuiJNI.ImDrawData_DisplayPos_set(swigCPtr, this, ImVec2.getCPtr(value), value);
  }

  public ImVec2 getDisplayPos() {
    long cPtr = CImGuiJNI.ImDrawData_DisplayPos_get(swigCPtr, this);
    return (cPtr == 0) ? null : new ImVec2(cPtr, false);
  }

  public void setDisplaySize(ImVec2 value) {
    CImGuiJNI.ImDrawData_DisplaySize_set(swigCPtr, this, ImVec2.getCPtr(value), value);
  }

  public ImVec2 getDisplaySize() {
    long cPtr = CImGuiJNI.ImDrawData_DisplaySize_get(swigCPtr, this);
    return (cPtr == 0) ? null : new ImVec2(cPtr, false);
  }

  public void setFramebufferScale(ImVec2 value) {
    CImGuiJNI.ImDrawData_FramebufferScale_set(swigCPtr, this, ImVec2.getCPtr(value), value);
  }

  public ImVec2 getFramebufferScale() {
    long cPtr = CImGuiJNI.ImDrawData_FramebufferScale_get(swigCPtr, this);
    return (cPtr == 0) ? null : new ImVec2(cPtr, false);
  }

  public ImDrawData() {
    this(CImGuiJNI.new_ImDrawData(), true);
  }

}