package com.imgui

import cimgui.internal.ImDrawListSharedData_ImDrawListSharedData
import cimgui.internal.ImDrawListSharedData_SetCircleSegmentMaxError
import cimgui.internal.ImDrawListSharedData_destroy
import kotlin.Float
import kotlin.Int
import kotlin.Suppress
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.get
import kotlinx.cinterop.pointed

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImDrawListSharedData(
  val ptr: CPointer<cimgui.internal.ImDrawListSharedData>
) {
  actual val texUvWhitePixel: Vec2
    get() = ptr.pointed.TexUvWhitePixel.fromCValue()

  actual val font: ImFont?
    get() = ptr.pointed.Font?.let(::ImFont)

  actual val fontSize: Float
    get() = ptr.pointed.FontSize

  actual val curveTessellationTol: Float
    get() = ptr.pointed.CurveTessellationTol

  actual val circleSegmentMaxError: Float
    get() = ptr.pointed.CircleSegmentMaxError

  actual val clipRectFullscreen: Vec4
    get() = ptr.pointed.ClipRectFullscreen.fromCValue()

  actual val initialFlags: Flag<ImDrawListFlags>
    get() = ptr.pointed.InitialFlags.let { ImDrawListFlags.fromMultiple(it) }

  actual constructor() : this(ImDrawListSharedData_ImDrawListSharedData()!!)

  actual fun arcFastVtx(index: Int): Vec2 {
    require(index in 0..12)
    return ptr.pointed.ArcFastVtx.get(index).fromCValue()
  }

  actual fun setCircleSegmentMaxError(maxError: Float) {
    ImDrawListSharedData_SetCircleSegmentMaxError(ptr, maxError)
  }

  actual fun destroy() {
    ImDrawListSharedData_destroy(ptr)
  }
}
