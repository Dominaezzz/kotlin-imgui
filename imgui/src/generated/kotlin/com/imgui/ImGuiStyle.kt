package com.imgui

import kotlin.Boolean
import kotlin.Float
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.pointed

inline class ImGuiStyle(
  val ptr: CPointer<cimgui.internal.ImGuiStyle>
) {
  val alpha: Float
    get() = ptr.pointed.Alpha

  val windowRounding: Float
    get() = ptr.pointed.WindowRounding

  val windowBorderSize: Float
    get() = ptr.pointed.WindowBorderSize

  val childRounding: Float
    get() = ptr.pointed.ChildRounding

  val childBorderSize: Float
    get() = ptr.pointed.ChildBorderSize

  val popupRounding: Float
    get() = ptr.pointed.PopupRounding

  val popupBorderSize: Float
    get() = ptr.pointed.PopupBorderSize

  val frameRounding: Float
    get() = ptr.pointed.FrameRounding

  val frameBorderSize: Float
    get() = ptr.pointed.FrameBorderSize

  val indentSpacing: Float
    get() = ptr.pointed.IndentSpacing

  val columnsMinSpacing: Float
    get() = ptr.pointed.ColumnsMinSpacing

  val scrollbarSize: Float
    get() = ptr.pointed.ScrollbarSize

  val scrollbarRounding: Float
    get() = ptr.pointed.ScrollbarRounding

  val grabMinSize: Float
    get() = ptr.pointed.GrabMinSize

  val grabRounding: Float
    get() = ptr.pointed.GrabRounding

  val tabRounding: Float
    get() = ptr.pointed.TabRounding

  val tabBorderSize: Float
    get() = ptr.pointed.TabBorderSize

  val mouseCursorScale: Float
    get() = ptr.pointed.MouseCursorScale

  val antiAliasedLines: Boolean
    get() = ptr.pointed.AntiAliasedLines

  val antiAliasedFill: Boolean
    get() = ptr.pointed.AntiAliasedFill

  val curveTessellationTol: Float
    get() = ptr.pointed.CurveTessellationTol
}
