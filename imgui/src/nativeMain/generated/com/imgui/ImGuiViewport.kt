package com.imgui

import cimgui.internal.ImGuiViewport_ImGuiViewport
import cimgui.internal.ImGuiViewport_destroy
import kotlin.Boolean
import kotlin.Float
import kotlin.Suppress
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.pointed

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImGuiViewport(
  val ptr: CPointer<cimgui.internal.ImGuiViewport>
) {
  actual val id: ImGuiID
    get() = ptr.pointed.ID.let(::ImGuiID)

  actual val flags: Flag<ImGuiViewportFlags>
    get() = ptr.pointed.Flags.let { ImGuiViewportFlags.fromMultiple(it) }

  actual val pos: Vec2
    get() = ptr.pointed.Pos.fromCValue()

  actual val size: Vec2
    get() = ptr.pointed.Size.fromCValue()

  actual val workOffsetMin: Vec2
    get() = ptr.pointed.WorkOffsetMin.fromCValue()

  actual val workOffsetMax: Vec2
    get() = ptr.pointed.WorkOffsetMax.fromCValue()

  actual val dpiScale: Float
    get() = ptr.pointed.DpiScale

  actual val drawData: ImDrawData?
    get() = ptr.pointed.DrawData?.let(::ImDrawData)

  actual val parentViewportId: ImGuiID
    get() = ptr.pointed.ParentViewportId.let(::ImGuiID)

  actual var platformRequestMove: Boolean
    get() = ptr.pointed.PlatformRequestMove
    set(value) {
      ptr.pointed.PlatformRequestMove = value
    }

  actual var platformRequestResize: Boolean
    get() = ptr.pointed.PlatformRequestResize
    set(value) {
      ptr.pointed.PlatformRequestResize = value
    }

  actual var platformRequestClose: Boolean
    get() = ptr.pointed.PlatformRequestClose
    set(value) {
      ptr.pointed.PlatformRequestClose = value
    }

  actual constructor() : this(ImGuiViewport_ImGuiViewport()!!)

  actual fun destroy() {
    ImGuiViewport_destroy(ptr)
  }
}
