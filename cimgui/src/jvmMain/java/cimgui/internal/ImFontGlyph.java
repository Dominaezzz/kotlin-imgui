/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.2
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package cimgui.internal;

public class ImFontGlyph {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  public ImFontGlyph(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  public static long getCPtr(ImFontGlyph obj) {
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
        CImGuiJNI.delete_ImFontGlyph(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setCodepoint(long value) {
    CImGuiJNI.ImFontGlyph_Codepoint_set(swigCPtr, this, value);
  }

  public long getCodepoint() {
    return CImGuiJNI.ImFontGlyph_Codepoint_get(swigCPtr, this);
  }

  public void setVisible(long value) {
    CImGuiJNI.ImFontGlyph_Visible_set(swigCPtr, this, value);
  }

  public long getVisible() {
    return CImGuiJNI.ImFontGlyph_Visible_get(swigCPtr, this);
  }

  public void setAdvanceX(float value) {
    CImGuiJNI.ImFontGlyph_AdvanceX_set(swigCPtr, this, value);
  }

  public float getAdvanceX() {
    return CImGuiJNI.ImFontGlyph_AdvanceX_get(swigCPtr, this);
  }

  public void setX0(float value) {
    CImGuiJNI.ImFontGlyph_X0_set(swigCPtr, this, value);
  }

  public float getX0() {
    return CImGuiJNI.ImFontGlyph_X0_get(swigCPtr, this);
  }

  public void setY0(float value) {
    CImGuiJNI.ImFontGlyph_Y0_set(swigCPtr, this, value);
  }

  public float getY0() {
    return CImGuiJNI.ImFontGlyph_Y0_get(swigCPtr, this);
  }

  public void setX1(float value) {
    CImGuiJNI.ImFontGlyph_X1_set(swigCPtr, this, value);
  }

  public float getX1() {
    return CImGuiJNI.ImFontGlyph_X1_get(swigCPtr, this);
  }

  public void setY1(float value) {
    CImGuiJNI.ImFontGlyph_Y1_set(swigCPtr, this, value);
  }

  public float getY1() {
    return CImGuiJNI.ImFontGlyph_Y1_get(swigCPtr, this);
  }

  public void setU0(float value) {
    CImGuiJNI.ImFontGlyph_U0_set(swigCPtr, this, value);
  }

  public float getU0() {
    return CImGuiJNI.ImFontGlyph_U0_get(swigCPtr, this);
  }

  public void setV0(float value) {
    CImGuiJNI.ImFontGlyph_V0_set(swigCPtr, this, value);
  }

  public float getV0() {
    return CImGuiJNI.ImFontGlyph_V0_get(swigCPtr, this);
  }

  public void setU1(float value) {
    CImGuiJNI.ImFontGlyph_U1_set(swigCPtr, this, value);
  }

  public float getU1() {
    return CImGuiJNI.ImFontGlyph_U1_get(swigCPtr, this);
  }

  public void setV1(float value) {
    CImGuiJNI.ImFontGlyph_V1_set(swigCPtr, this, value);
  }

  public float getV1() {
    return CImGuiJNI.ImFontGlyph_V1_get(swigCPtr, this);
  }

  public ImFontGlyph() {
    this(CImGuiJNI.new_ImFontGlyph(), true);
  }

}
