/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.1
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package cimgui.internal;

public class ImDrawChannel {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  public ImDrawChannel(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  public static long getCPtr(ImDrawChannel obj) {
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
        CImGuiJNI.delete_ImDrawChannel(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void set_CmdBuffer(ImVector_ImDrawCmd value) {
    CImGuiJNI.ImDrawChannel__CmdBuffer_set(swigCPtr, this, ImVector_ImDrawCmd.getCPtr(value), value);
  }

  public ImVector_ImDrawCmd get_CmdBuffer() {
    long cPtr = CImGuiJNI.ImDrawChannel__CmdBuffer_get(swigCPtr, this);
    return (cPtr == 0) ? null : new ImVector_ImDrawCmd(cPtr, false);
  }

  public void set_IdxBuffer(ImVector_ImDrawIdx value) {
    CImGuiJNI.ImDrawChannel__IdxBuffer_set(swigCPtr, this, ImVector_ImDrawIdx.getCPtr(value), value);
  }

  public ImVector_ImDrawIdx get_IdxBuffer() {
    long cPtr = CImGuiJNI.ImDrawChannel__IdxBuffer_get(swigCPtr, this);
    return (cPtr == 0) ? null : new ImVector_ImDrawIdx(cPtr, false);
  }

  public ImDrawChannel() {
    this(CImGuiJNI.new_ImDrawChannel(), true);
  }

}
