/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.1
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package cimgui.internal;

public class ImChunkStream_ImGuiWindowSettings {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  public ImChunkStream_ImGuiWindowSettings(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  public static long getCPtr(ImChunkStream_ImGuiWindowSettings obj) {
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
        CImGuiJNI.delete_ImChunkStream_ImGuiWindowSettings(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setBuf(ImVector_ImGuiWindowSettings value) {
    CImGuiJNI.ImChunkStream_ImGuiWindowSettings_Buf_set(swigCPtr, this, ImVector_ImGuiWindowSettings.getCPtr(value), value);
  }

  public ImVector_ImGuiWindowSettings getBuf() {
    long cPtr = CImGuiJNI.ImChunkStream_ImGuiWindowSettings_Buf_get(swigCPtr, this);
    return (cPtr == 0) ? null : new ImVector_ImGuiWindowSettings(cPtr, false);
  }

  public ImChunkStream_ImGuiWindowSettings() {
    this(CImGuiJNI.new_ImChunkStream_ImGuiWindowSettings(), true);
  }

}
