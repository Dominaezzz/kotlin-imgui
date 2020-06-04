/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.1
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package cimgui.internal;

public class ImGuiInputTextState {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  public ImGuiInputTextState(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  public static long getCPtr(ImGuiInputTextState obj) {
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
        CImGuiJNI.delete_ImGuiInputTextState(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setID(long value) {
    CImGuiJNI.ImGuiInputTextState_ID_set(swigCPtr, this, value);
  }

  public long getID() {
    return CImGuiJNI.ImGuiInputTextState_ID_get(swigCPtr, this);
  }

  public void setCurLenW(int value) {
    CImGuiJNI.ImGuiInputTextState_CurLenW_set(swigCPtr, this, value);
  }

  public int getCurLenW() {
    return CImGuiJNI.ImGuiInputTextState_CurLenW_get(swigCPtr, this);
  }

  public void setCurLenA(int value) {
    CImGuiJNI.ImGuiInputTextState_CurLenA_set(swigCPtr, this, value);
  }

  public int getCurLenA() {
    return CImGuiJNI.ImGuiInputTextState_CurLenA_get(swigCPtr, this);
  }

  public void setTextW(ImVector_ImWchar value) {
    CImGuiJNI.ImGuiInputTextState_TextW_set(swigCPtr, this, ImVector_ImWchar.getCPtr(value), value);
  }

  public ImVector_ImWchar getTextW() {
    long cPtr = CImGuiJNI.ImGuiInputTextState_TextW_get(swigCPtr, this);
    return (cPtr == 0) ? null : new ImVector_ImWchar(cPtr, false);
  }

  public void setTextA(ImVector_char value) {
    CImGuiJNI.ImGuiInputTextState_TextA_set(swigCPtr, this, ImVector_char.getCPtr(value), value);
  }

  public ImVector_char getTextA() {
    long cPtr = CImGuiJNI.ImGuiInputTextState_TextA_get(swigCPtr, this);
    return (cPtr == 0) ? null : new ImVector_char(cPtr, false);
  }

  public void setInitialTextA(ImVector_char value) {
    CImGuiJNI.ImGuiInputTextState_InitialTextA_set(swigCPtr, this, ImVector_char.getCPtr(value), value);
  }

  public ImVector_char getInitialTextA() {
    long cPtr = CImGuiJNI.ImGuiInputTextState_InitialTextA_get(swigCPtr, this);
    return (cPtr == 0) ? null : new ImVector_char(cPtr, false);
  }

  public void setTextAIsValid(boolean value) {
    CImGuiJNI.ImGuiInputTextState_TextAIsValid_set(swigCPtr, this, value);
  }

  public boolean getTextAIsValid() {
    return CImGuiJNI.ImGuiInputTextState_TextAIsValid_get(swigCPtr, this);
  }

  public void setBufCapacityA(int value) {
    CImGuiJNI.ImGuiInputTextState_BufCapacityA_set(swigCPtr, this, value);
  }

  public int getBufCapacityA() {
    return CImGuiJNI.ImGuiInputTextState_BufCapacityA_get(swigCPtr, this);
  }

  public void setScrollX(float value) {
    CImGuiJNI.ImGuiInputTextState_ScrollX_set(swigCPtr, this, value);
  }

  public float getScrollX() {
    return CImGuiJNI.ImGuiInputTextState_ScrollX_get(swigCPtr, this);
  }

  public void setStb(STB_TexteditState value) {
    CImGuiJNI.ImGuiInputTextState_Stb_set(swigCPtr, this, STB_TexteditState.getCPtr(value), value);
  }

  public STB_TexteditState getStb() {
    long cPtr = CImGuiJNI.ImGuiInputTextState_Stb_get(swigCPtr, this);
    return (cPtr == 0) ? null : new STB_TexteditState(cPtr, false);
  }

  public void setCursorAnim(float value) {
    CImGuiJNI.ImGuiInputTextState_CursorAnim_set(swigCPtr, this, value);
  }

  public float getCursorAnim() {
    return CImGuiJNI.ImGuiInputTextState_CursorAnim_get(swigCPtr, this);
  }

  public void setCursorFollow(boolean value) {
    CImGuiJNI.ImGuiInputTextState_CursorFollow_set(swigCPtr, this, value);
  }

  public boolean getCursorFollow() {
    return CImGuiJNI.ImGuiInputTextState_CursorFollow_get(swigCPtr, this);
  }

  public void setSelectedAllMouseLock(boolean value) {
    CImGuiJNI.ImGuiInputTextState_SelectedAllMouseLock_set(swigCPtr, this, value);
  }

  public boolean getSelectedAllMouseLock() {
    return CImGuiJNI.ImGuiInputTextState_SelectedAllMouseLock_get(swigCPtr, this);
  }

  public void setUserFlags(int value) {
    CImGuiJNI.ImGuiInputTextState_UserFlags_set(swigCPtr, this, value);
  }

  public int getUserFlags() {
    return CImGuiJNI.ImGuiInputTextState_UserFlags_get(swigCPtr, this);
  }

  public void setUserCallback(SWIGTYPE_p_f_p_ImGuiInputTextCallbackData__int value) {
    CImGuiJNI.ImGuiInputTextState_UserCallback_set(swigCPtr, this, SWIGTYPE_p_f_p_ImGuiInputTextCallbackData__int.getCPtr(value));
  }

  public SWIGTYPE_p_f_p_ImGuiInputTextCallbackData__int getUserCallback() {
    long cPtr = CImGuiJNI.ImGuiInputTextState_UserCallback_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_f_p_ImGuiInputTextCallbackData__int(cPtr, false);
  }

  public void setUserCallbackData(SWIGTYPE_p_void value) {
    CImGuiJNI.ImGuiInputTextState_UserCallbackData_set(swigCPtr, this, SWIGTYPE_p_void.getCPtr(value));
  }

  public SWIGTYPE_p_void getUserCallbackData() {
    long cPtr = CImGuiJNI.ImGuiInputTextState_UserCallbackData_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_void(cPtr, false);
  }

  public ImGuiInputTextState() {
    this(CImGuiJNI.new_ImGuiInputTextState(), true);
  }

}
