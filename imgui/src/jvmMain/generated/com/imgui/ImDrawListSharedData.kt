package com.imgui

import cimgui.internal.CImGui.ImDrawListSharedData_ImDrawListSharedData
import cimgui.internal.CImGui.ImDrawListSharedData_SetCircleSegmentMaxError
import cimgui.internal.CImGui.ImDrawListSharedData_destroy
import kotlin.Float
import kotlin.Suppress

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImDrawListSharedData(
  val ptr: cimgui.internal.ImDrawListSharedData
) {
  actual val texUvWhitePixel: Vec2
    get() = ptr.texUvWhitePixel.fromCValue()

  actual val font: ImFont?
    get() = ptr.font?.let(::ImFont)

  actual val fontSize: Float
    get() = ptr.fontSize

  actual val curveTessellationTol: Float
    get() = ptr.curveTessellationTol

  actual val circleSegmentMaxError: Float
    get() = ptr.circleSegmentMaxError

  actual val clipRectFullscreen: Vec4
    get() = ptr.clipRectFullscreen.fromCValue()

  actual val initialFlags: Flag<ImDrawListFlags>
    get() = ptr.initialFlags.let { ImDrawListFlags.fromMultiple(it) }

  actual constructor() : this(ImDrawListSharedData_ImDrawListSharedData()!!)

  actual fun setCircleSegmentMaxError(maxError: Float) {
    ImDrawListSharedData_SetCircleSegmentMaxError(ptr, maxError)
  }

  actual fun destroy() {
    ImDrawListSharedData_destroy(ptr)
  }
}
