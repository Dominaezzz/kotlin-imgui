/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.1
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package cimgui.internal;

public class ImVec4_Simple {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  public ImVec4_Simple(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  public static long getCPtr(ImVec4_Simple obj) {
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
        CImGuiJNI.delete_ImVec4_Simple(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setX(float value) {
    CImGuiJNI.ImVec4_Simple_x_set(swigCPtr, this, value);
  }

  public float getX() {
    return CImGuiJNI.ImVec4_Simple_x_get(swigCPtr, this);
  }

  public void setY(float value) {
    CImGuiJNI.ImVec4_Simple_y_set(swigCPtr, this, value);
  }

  public float getY() {
    return CImGuiJNI.ImVec4_Simple_y_get(swigCPtr, this);
  }

  public void setZ(float value) {
    CImGuiJNI.ImVec4_Simple_z_set(swigCPtr, this, value);
  }

  public float getZ() {
    return CImGuiJNI.ImVec4_Simple_z_get(swigCPtr, this);
  }

  public void setW(float value) {
    CImGuiJNI.ImVec4_Simple_w_set(swigCPtr, this, value);
  }

  public float getW() {
    return CImGuiJNI.ImVec4_Simple_w_get(swigCPtr, this);
  }

  public ImVec4_Simple() {
    this(CImGuiJNI.new_ImVec4_Simple(), true);
  }

}