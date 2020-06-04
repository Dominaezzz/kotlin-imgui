/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.1
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package cimgui.internal;

public class ImDrawListSharedData {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  public ImDrawListSharedData(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  public static long getCPtr(ImDrawListSharedData obj) {
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
        CImGuiJNI.delete_ImDrawListSharedData(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setTexUvWhitePixel(ImVec2 value) {
    CImGuiJNI.ImDrawListSharedData_TexUvWhitePixel_set(swigCPtr, this, ImVec2.getCPtr(value), value);
  }

  public ImVec2 getTexUvWhitePixel() {
    long cPtr = CImGuiJNI.ImDrawListSharedData_TexUvWhitePixel_get(swigCPtr, this);
    return (cPtr == 0) ? null : new ImVec2(cPtr, false);
  }

  public void setFont(ImFont value) {
    CImGuiJNI.ImDrawListSharedData_Font_set(swigCPtr, this, ImFont.getCPtr(value), value);
  }

  public ImFont getFont() {
    long cPtr = CImGuiJNI.ImDrawListSharedData_Font_get(swigCPtr, this);
    return (cPtr == 0) ? null : new ImFont(cPtr, false);
  }

  public void setFontSize(float value) {
    CImGuiJNI.ImDrawListSharedData_FontSize_set(swigCPtr, this, value);
  }

  public float getFontSize() {
    return CImGuiJNI.ImDrawListSharedData_FontSize_get(swigCPtr, this);
  }

  public void setCurveTessellationTol(float value) {
    CImGuiJNI.ImDrawListSharedData_CurveTessellationTol_set(swigCPtr, this, value);
  }

  public float getCurveTessellationTol() {
    return CImGuiJNI.ImDrawListSharedData_CurveTessellationTol_get(swigCPtr, this);
  }

  public void setCircleSegmentMaxError(float value) {
    CImGuiJNI.ImDrawListSharedData_CircleSegmentMaxError_set(swigCPtr, this, value);
  }

  public float getCircleSegmentMaxError() {
    return CImGuiJNI.ImDrawListSharedData_CircleSegmentMaxError_get(swigCPtr, this);
  }

  public void setClipRectFullscreen(ImVec4 value) {
    CImGuiJNI.ImDrawListSharedData_ClipRectFullscreen_set(swigCPtr, this, ImVec4.getCPtr(value), value);
  }

  public ImVec4 getClipRectFullscreen() {
    long cPtr = CImGuiJNI.ImDrawListSharedData_ClipRectFullscreen_get(swigCPtr, this);
    return (cPtr == 0) ? null : new ImVec4(cPtr, false);
  }

  public void setInitialFlags(int value) {
    CImGuiJNI.ImDrawListSharedData_InitialFlags_set(swigCPtr, this, value);
  }

  public int getInitialFlags() {
    return CImGuiJNI.ImDrawListSharedData_InitialFlags_get(swigCPtr, this);
  }

  public void setArcFastVtx(ImVec2 value) {
    CImGuiJNI.ImDrawListSharedData_ArcFastVtx_set(swigCPtr, this, ImVec2.getCPtr(value), value);
  }

  public ImVec2 getArcFastVtx() {
    long cPtr = CImGuiJNI.ImDrawListSharedData_ArcFastVtx_get(swigCPtr, this);
    return (cPtr == 0) ? null : new ImVec2(cPtr, false);
  }

  public void setCircleSegmentCounts(SWIGTYPE_p_unsigned_char value) {
    CImGuiJNI.ImDrawListSharedData_CircleSegmentCounts_set(swigCPtr, this, SWIGTYPE_p_unsigned_char.getCPtr(value));
  }

  public SWIGTYPE_p_unsigned_char getCircleSegmentCounts() {
    long cPtr = CImGuiJNI.ImDrawListSharedData_CircleSegmentCounts_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_unsigned_char(cPtr, false);
  }

  public ImDrawListSharedData() {
    this(CImGuiJNI.new_ImDrawListSharedData(), true);
  }

}
