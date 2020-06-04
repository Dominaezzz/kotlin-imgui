/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.1
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package cimgui.internal;

public class ImGuiColorMod {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  public ImGuiColorMod(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  public static long getCPtr(ImGuiColorMod obj) {
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
        CImGuiJNI.delete_ImGuiColorMod(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setCol(int value) {
    CImGuiJNI.ImGuiColorMod_Col_set(swigCPtr, this, value);
  }

  public int getCol() {
    return CImGuiJNI.ImGuiColorMod_Col_get(swigCPtr, this);
  }

  public void setBackupValue(ImVec4 value) {
    CImGuiJNI.ImGuiColorMod_BackupValue_set(swigCPtr, this, ImVec4.getCPtr(value), value);
  }

  public ImVec4 getBackupValue() {
    long cPtr = CImGuiJNI.ImGuiColorMod_BackupValue_get(swigCPtr, this);
    return (cPtr == 0) ? null : new ImVec4(cPtr, false);
  }

  public ImGuiColorMod() {
    this(CImGuiJNI.new_ImGuiColorMod(), true);
  }

}
