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

  val windowPadding: Vec2
    get() = ptr.pointed.WindowPadding.fromCValue()

  val windowRounding: Float
    get() = ptr.pointed.WindowRounding

  val windowBorderSize: Float
    get() = ptr.pointed.WindowBorderSize

  val windowMinSize: Vec2
    get() = ptr.pointed.WindowMinSize.fromCValue()

  val windowTitleAlign: Vec2
    get() = ptr.pointed.WindowTitleAlign.fromCValue()

  val windowMenuButtonPosition: ImGuiDir
    get() = ptr.pointed.WindowMenuButtonPosition.let { ImGuiDir.from(it) }

  val childRounding: Float
    get() = ptr.pointed.ChildRounding

  val childBorderSize: Float
    get() = ptr.pointed.ChildBorderSize

  val popupRounding: Float
    get() = ptr.pointed.PopupRounding

  val popupBorderSize: Float
    get() = ptr.pointed.PopupBorderSize

  val framePadding: Vec2
    get() = ptr.pointed.FramePadding.fromCValue()

  val frameRounding: Float
    get() = ptr.pointed.FrameRounding

  val frameBorderSize: Float
    get() = ptr.pointed.FrameBorderSize

  val itemSpacing: Vec2
    get() = ptr.pointed.ItemSpacing.fromCValue()

  val itemInnerSpacing: Vec2
    get() = ptr.pointed.ItemInnerSpacing.fromCValue()

  val touchExtraPadding: Vec2
    get() = ptr.pointed.TouchExtraPadding.fromCValue()

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

  val colorButtonPosition: ImGuiDir
    get() = ptr.pointed.ColorButtonPosition.let { ImGuiDir.from(it) }

  val buttonTextAlign: Vec2
    get() = ptr.pointed.ButtonTextAlign.fromCValue()

  val selectableTextAlign: Vec2
    get() = ptr.pointed.SelectableTextAlign.fromCValue()

  val displayWindowPadding: Vec2
    get() = ptr.pointed.DisplayWindowPadding.fromCValue()

  val displaySafeAreaPadding: Vec2
    get() = ptr.pointed.DisplaySafeAreaPadding.fromCValue()

  val mouseCursorScale: Float
    get() = ptr.pointed.MouseCursorScale

  val antiAliasedLines: Boolean
    get() = ptr.pointed.AntiAliasedLines

  val antiAliasedFill: Boolean
    get() = ptr.pointed.AntiAliasedFill

  val curveTessellationTol: Float
    get() = ptr.pointed.CurveTessellationTol
}
