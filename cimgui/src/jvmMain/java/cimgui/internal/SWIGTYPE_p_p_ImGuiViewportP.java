/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.1
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package cimgui.internal;

public class SWIGTYPE_p_p_ImGuiViewportP {
  private transient long swigCPtr;

  public SWIGTYPE_p_p_ImGuiViewportP(long cPtr, @SuppressWarnings("unused") boolean futureUse) {
    swigCPtr = cPtr;
  }

  public SWIGTYPE_p_p_ImGuiViewportP() {
    swigCPtr = 0;
  }

  public static long getCPtr(SWIGTYPE_p_p_ImGuiViewportP obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    SWIGTYPE_p_p_ImGuiViewportP that = (SWIGTYPE_p_p_ImGuiViewportP) o;

    return swigCPtr == that.swigCPtr;
  }

  @Override
  public int hashCode() {
    return (int) (swigCPtr ^ (swigCPtr >>> 32));
  }
}
