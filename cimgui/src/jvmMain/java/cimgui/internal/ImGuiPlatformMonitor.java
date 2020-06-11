/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.1
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package cimgui.internal;

public class ImGuiPlatformMonitor {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  public ImGuiPlatformMonitor(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  public static long getCPtr(ImGuiPlatformMonitor obj) {
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
        CImGuiJNI.delete_ImGuiPlatformMonitor(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setMainPos(ImVec2 value) {
    CImGuiJNI.ImGuiPlatformMonitor_MainPos_set(swigCPtr, this, ImVec2.getCPtr(value), value);
  }

  public ImVec2 getMainPos() {
    long cPtr = CImGuiJNI.ImGuiPlatformMonitor_MainPos_get(swigCPtr, this);
    return (cPtr == 0) ? null : new ImVec2(cPtr, false);
  }

  public void setMainSize(ImVec2 value) {
    CImGuiJNI.ImGuiPlatformMonitor_MainSize_set(swigCPtr, this, ImVec2.getCPtr(value), value);
  }

  public ImVec2 getMainSize() {
    long cPtr = CImGuiJNI.ImGuiPlatformMonitor_MainSize_get(swigCPtr, this);
    return (cPtr == 0) ? null : new ImVec2(cPtr, false);
  }

  public void setWorkPos(ImVec2 value) {
    CImGuiJNI.ImGuiPlatformMonitor_WorkPos_set(swigCPtr, this, ImVec2.getCPtr(value), value);
  }

  public ImVec2 getWorkPos() {
    long cPtr = CImGuiJNI.ImGuiPlatformMonitor_WorkPos_get(swigCPtr, this);
    return (cPtr == 0) ? null : new ImVec2(cPtr, false);
  }

  public void setWorkSize(ImVec2 value) {
    CImGuiJNI.ImGuiPlatformMonitor_WorkSize_set(swigCPtr, this, ImVec2.getCPtr(value), value);
  }

  public ImVec2 getWorkSize() {
    long cPtr = CImGuiJNI.ImGuiPlatformMonitor_WorkSize_get(swigCPtr, this);
    return (cPtr == 0) ? null : new ImVec2(cPtr, false);
  }

  public void setDpiScale(float value) {
    CImGuiJNI.ImGuiPlatformMonitor_DpiScale_set(swigCPtr, this, value);
  }

  public float getDpiScale() {
    return CImGuiJNI.ImGuiPlatformMonitor_DpiScale_get(swigCPtr, this);
  }

  public ImGuiPlatformMonitor() {
    this(CImGuiJNI.new_ImGuiPlatformMonitor(), true);
  }

}