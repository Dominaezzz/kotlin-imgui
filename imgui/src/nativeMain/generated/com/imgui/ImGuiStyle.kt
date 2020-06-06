package com.imgui

import cimgui.internal.ImGuiStyle_ImGuiStyle
import cimgui.internal.ImGuiStyle_ScaleAllSizes
import cimgui.internal.ImGuiStyle_destroy
import kotlin.Boolean
import kotlin.Float
import kotlin.Suppress
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.pointed

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImGuiStyle(
  val ptr: CPointer<cimgui.internal.ImGuiStyle>
) {
  actual val alpha: Float
    get() = ptr.pointed.Alpha

  actual val windowPadding: Vec2
    get() = ptr.pointed.WindowPadding.fromCValue()

  actual val windowRounding: Float
    get() = ptr.pointed.WindowRounding

  actual val windowBorderSize: Float
    get() = ptr.pointed.WindowBorderSize

  actual val windowMinSize: Vec2
    get() = ptr.pointed.WindowMinSize.fromCValue()

  actual val windowTitleAlign: Vec2
    get() = ptr.pointed.WindowTitleAlign.fromCValue()

  actual val windowMenuButtonPosition: ImGuiDir
    get() = ptr.pointed.WindowMenuButtonPosition.let { ImGuiDir.from(it) }

  actual val childRounding: Float
    get() = ptr.pointed.ChildRounding

  actual val childBorderSize: Float
    get() = ptr.pointed.ChildBorderSize

  actual val popupRounding: Float
    get() = ptr.pointed.PopupRounding

  actual val popupBorderSize: Float
    get() = ptr.pointed.PopupBorderSize

  actual val framePadding: Vec2
    get() = ptr.pointed.FramePadding.fromCValue()

  actual val frameRounding: Float
    get() = ptr.pointed.FrameRounding

  actual val frameBorderSize: Float
    get() = ptr.pointed.FrameBorderSize

  actual val itemSpacing: Vec2
    get() = ptr.pointed.ItemSpacing.fromCValue()

  actual val itemInnerSpacing: Vec2
    get() = ptr.pointed.ItemInnerSpacing.fromCValue()

  actual val touchExtraPadding: Vec2
    get() = ptr.pointed.TouchExtraPadding.fromCValue()

  actual val indentSpacing: Float
    get() = ptr.pointed.IndentSpacing

  actual val columnsMinSpacing: Float
    get() = ptr.pointed.ColumnsMinSpacing

  actual val scrollbarSize: Float
    get() = ptr.pointed.ScrollbarSize

  actual val scrollbarRounding: Float
    get() = ptr.pointed.ScrollbarRounding

  actual val grabMinSize: Float
    get() = ptr.pointed.GrabMinSize

  actual val grabRounding: Float
    get() = ptr.pointed.GrabRounding

  actual val tabRounding: Float
    get() = ptr.pointed.TabRounding

  actual val tabBorderSize: Float
    get() = ptr.pointed.TabBorderSize

  actual val tabMinWidthForUnselectedCloseButton: Float
    get() = ptr.pointed.TabMinWidthForUnselectedCloseButton

  actual val colorButtonPosition: ImGuiDir
    get() = ptr.pointed.ColorButtonPosition.let { ImGuiDir.from(it) }

  actual val buttonTextAlign: Vec2
    get() = ptr.pointed.ButtonTextAlign.fromCValue()

  actual val selectableTextAlign: Vec2
    get() = ptr.pointed.SelectableTextAlign.fromCValue()

  actual val displayWindowPadding: Vec2
    get() = ptr.pointed.DisplayWindowPadding.fromCValue()

  actual val displaySafeAreaPadding: Vec2
    get() = ptr.pointed.DisplaySafeAreaPadding.fromCValue()

  actual val mouseCursorScale: Float
    get() = ptr.pointed.MouseCursorScale

  actual val antiAliasedLines: Boolean
    get() = ptr.pointed.AntiAliasedLines

  actual val antiAliasedFill: Boolean
    get() = ptr.pointed.AntiAliasedFill

  actual val curveTessellationTol: Float
    get() = ptr.pointed.CurveTessellationTol

  actual val circleSegmentMaxError: Float
    get() = ptr.pointed.CircleSegmentMaxError

  actual constructor() : this(ImGuiStyle_ImGuiStyle()!!)

  actual fun scaleAllSizes(scaleFactor: Float) {
    ImGuiStyle_ScaleAllSizes(ptr, scaleFactor)
  }

  actual fun destroy() {
    ImGuiStyle_destroy(ptr)
  }
}
