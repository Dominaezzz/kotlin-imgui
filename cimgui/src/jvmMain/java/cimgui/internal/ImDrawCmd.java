/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.1
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package cimgui.internal;

public class ImDrawCmd {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  public ImDrawCmd(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  public static long getCPtr(ImDrawCmd obj) {
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
        CImGuiJNI.delete_ImDrawCmd(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setElemCount(long value) {
    CImGuiJNI.ImDrawCmd_ElemCount_set(swigCPtr, this, value);
  }

  public long getElemCount() {
    return CImGuiJNI.ImDrawCmd_ElemCount_get(swigCPtr, this);
  }

  public void setClipRect(ImVec4 value) {
    CImGuiJNI.ImDrawCmd_ClipRect_set(swigCPtr, this, ImVec4.getCPtr(value), value);
  }

  public ImVec4 getClipRect() {
    long cPtr = CImGuiJNI.ImDrawCmd_ClipRect_get(swigCPtr, this);
    return (cPtr == 0) ? null : new ImVec4(cPtr, false);
  }

  public void setTextureId(SWIGTYPE_p_void value) {
    CImGuiJNI.ImDrawCmd_TextureId_set(swigCPtr, this, SWIGTYPE_p_void.getCPtr(value));
  }

  public SWIGTYPE_p_void getTextureId() {
    long cPtr = CImGuiJNI.ImDrawCmd_TextureId_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_void(cPtr, false);
  }

  public void setVtxOffset(long value) {
    CImGuiJNI.ImDrawCmd_VtxOffset_set(swigCPtr, this, value);
  }

  public long getVtxOffset() {
    return CImGuiJNI.ImDrawCmd_VtxOffset_get(swigCPtr, this);
  }

  public void setIdxOffset(long value) {
    CImGuiJNI.ImDrawCmd_IdxOffset_set(swigCPtr, this, value);
  }

  public long getIdxOffset() {
    return CImGuiJNI.ImDrawCmd_IdxOffset_get(swigCPtr, this);
  }

  public void setUserCallback(SWIGTYPE_p_f_p_q_const__ImDrawList_p_q_const__ImDrawCmd__void value) {
    CImGuiJNI.ImDrawCmd_UserCallback_set(swigCPtr, this, SWIGTYPE_p_f_p_q_const__ImDrawList_p_q_const__ImDrawCmd__void.getCPtr(value));
  }

  public SWIGTYPE_p_f_p_q_const__ImDrawList_p_q_const__ImDrawCmd__void getUserCallback() {
    long cPtr = CImGuiJNI.ImDrawCmd_UserCallback_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_f_p_q_const__ImDrawList_p_q_const__ImDrawCmd__void(cPtr, false);
  }

  public void setUserCallbackData(SWIGTYPE_p_void value) {
    CImGuiJNI.ImDrawCmd_UserCallbackData_set(swigCPtr, this, SWIGTYPE_p_void.getCPtr(value));
  }

  public SWIGTYPE_p_void getUserCallbackData() {
    long cPtr = CImGuiJNI.ImDrawCmd_UserCallbackData_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_void(cPtr, false);
  }

  public ImDrawCmd() {
    this(CImGuiJNI.new_ImDrawCmd(), true);
  }

}