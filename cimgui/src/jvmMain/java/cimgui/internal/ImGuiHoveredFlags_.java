/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.1
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package cimgui.internal;

public final class ImGuiHoveredFlags_ {
  public final static int ImGuiHoveredFlags_None = 0;
  public final static int ImGuiHoveredFlags_ChildWindows = 1 << 0;
  public final static int ImGuiHoveredFlags_RootWindow = 1 << 1;
  public final static int ImGuiHoveredFlags_AnyWindow = 1 << 2;
  public final static int ImGuiHoveredFlags_AllowWhenBlockedByPopup = 1 << 3;
  public final static int ImGuiHoveredFlags_AllowWhenBlockedByActiveItem = 1 << 5;
  public final static int ImGuiHoveredFlags_AllowWhenOverlapped = 1 << 6;
  public final static int ImGuiHoveredFlags_AllowWhenDisabled = 1 << 7;
  public final static int ImGuiHoveredFlags_RectOnly = ImGuiHoveredFlags_AllowWhenBlockedByPopup|ImGuiHoveredFlags_AllowWhenBlockedByActiveItem|ImGuiHoveredFlags_AllowWhenOverlapped;
  public final static int ImGuiHoveredFlags_RootAndChildWindows = ImGuiHoveredFlags_RootWindow|ImGuiHoveredFlags_ChildWindows;
}

