package com.imgui

import cimgui.internal.CImGui.ImGuiStyle_ImGuiStyle
import cimgui.internal.CImGui.ImGuiStyle_ScaleAllSizes
import cimgui.internal.CImGui.ImGuiStyle_destroy
import kotlin.Boolean
import kotlin.Float
import kotlin.Suppress

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImGuiStyle(
  val ptr: cimgui.internal.ImGuiStyle
) {
  actual val alpha: Float
    get() = ptr.alpha

  actual val windowPadding: Vec2
    get() = ptr.windowPadding.fromCValue()

  actual val windowRounding: Float
    get() = ptr.windowRounding

  actual val windowBorderSize: Float
    get() = ptr.windowBorderSize

  actual val windowMinSize: Vec2
    get() = ptr.windowMinSize.fromCValue()

  actual val windowTitleAlign: Vec2
    get() = ptr.windowTitleAlign.fromCValue()

  actual val windowMenuButtonPosition: ImGuiDir
    get() = ptr.windowMenuButtonPosition.let { ImGuiDir.from(it) }

  actual val childRounding: Float
    get() = ptr.childRounding

  actual val childBorderSize: Float
    get() = ptr.childBorderSize

  actual val popupRounding: Float
    get() = ptr.popupRounding

  actual val popupBorderSize: Float
    get() = ptr.popupBorderSize

  actual val framePadding: Vec2
    get() = ptr.framePadding.fromCValue()

  actual val frameRounding: Float
    get() = ptr.frameRounding

  actual val frameBorderSize: Float
    get() = ptr.frameBorderSize

  actual val itemSpacing: Vec2
    get() = ptr.itemSpacing.fromCValue()

  actual val itemInnerSpacing: Vec2
    get() = ptr.itemInnerSpacing.fromCValue()

  actual val touchExtraPadding: Vec2
    get() = ptr.touchExtraPadding.fromCValue()

  actual val indentSpacing: Float
    get() = ptr.indentSpacing

  actual val columnsMinSpacing: Float
    get() = ptr.columnsMinSpacing

  actual val scrollbarSize: Float
    get() = ptr.scrollbarSize

  actual val scrollbarRounding: Float
    get() = ptr.scrollbarRounding

  actual val grabMinSize: Float
    get() = ptr.grabMinSize

  actual val grabRounding: Float
    get() = ptr.grabRounding

  actual val tabRounding: Float
    get() = ptr.tabRounding

  actual val tabBorderSize: Float
    get() = ptr.tabBorderSize

  actual val colorButtonPosition: ImGuiDir
    get() = ptr.colorButtonPosition.let { ImGuiDir.from(it) }

  actual val buttonTextAlign: Vec2
    get() = ptr.buttonTextAlign.fromCValue()

  actual val selectableTextAlign: Vec2
    get() = ptr.selectableTextAlign.fromCValue()

  actual val displayWindowPadding: Vec2
    get() = ptr.displayWindowPadding.fromCValue()

  actual val displaySafeAreaPadding: Vec2
    get() = ptr.displaySafeAreaPadding.fromCValue()

  actual val mouseCursorScale: Float
    get() = ptr.mouseCursorScale

  actual val antiAliasedLines: Boolean
    get() = ptr.antiAliasedLines

  actual val antiAliasedFill: Boolean
    get() = ptr.antiAliasedFill

  actual val curveTessellationTol: Float
    get() = ptr.curveTessellationTol

  actual constructor() : this(ImGuiStyle_ImGuiStyle()!!)

  actual fun scaleAllSizes(scaleFactor: Float) {
    ImGuiStyle_ScaleAllSizes(ptr, scaleFactor)
  }

  actual fun destroy() {
    ImGuiStyle_destroy(ptr)
  }
}
