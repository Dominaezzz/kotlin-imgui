/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.1
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package cimgui.internal;

public class ImGuiWindowSettings {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  public ImGuiWindowSettings(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  public static long getCPtr(ImGuiWindowSettings obj) {
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
        CImGuiJNI.delete_ImGuiWindowSettings(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setID(long value) {
    CImGuiJNI.ImGuiWindowSettings_ID_set(swigCPtr, this, value);
  }

  public long getID() {
    return CImGuiJNI.ImGuiWindowSettings_ID_get(swigCPtr, this);
  }

  public void setPos(ImVec2ih value) {
    CImGuiJNI.ImGuiWindowSettings_Pos_set(swigCPtr, this, ImVec2ih.getCPtr(value), value);
  }

  public ImVec2ih getPos() {
    long cPtr = CImGuiJNI.ImGuiWindowSettings_Pos_get(swigCPtr, this);
    return (cPtr == 0) ? null : new ImVec2ih(cPtr, false);
  }

  public void setSize(ImVec2ih value) {
    CImGuiJNI.ImGuiWindowSettings_Size_set(swigCPtr, this, ImVec2ih.getCPtr(value), value);
  }

  public ImVec2ih getSize() {
    long cPtr = CImGuiJNI.ImGuiWindowSettings_Size_get(swigCPtr, this);
    return (cPtr == 0) ? null : new ImVec2ih(cPtr, false);
  }

  public void setCollapsed(boolean value) {
    CImGuiJNI.ImGuiWindowSettings_Collapsed_set(swigCPtr, this, value);
  }

  public boolean getCollapsed() {
    return CImGuiJNI.ImGuiWindowSettings_Collapsed_get(swigCPtr, this);
  }

  public ImGuiWindowSettings() {
    this(CImGuiJNI.new_ImGuiWindowSettings(), true);
  }

}