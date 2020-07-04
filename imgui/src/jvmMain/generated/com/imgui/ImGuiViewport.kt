package com.imgui

import cimgui.internal.CImGui.ImGuiViewport_ImGuiViewport
import cimgui.internal.CImGui.ImGuiViewport_destroy
import kotlin.Boolean
import kotlin.Float
import kotlin.Suppress

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImGuiViewport(
  val ptr: cimgui.internal.ImGuiViewport
) {
  actual val id: ImGuiID
    get() = ptr.id.let(::ImGuiID)

  actual val flags: Flag<ImGuiViewportFlags>
    get() = ptr.flags.let { ImGuiViewportFlags.fromMultiple(it) }

  actual val pos: Vec2
    get() = ptr.pos.fromCValue()

  actual val size: Vec2
    get() = ptr.size.fromCValue()

  actual val workOffsetMin: Vec2
    get() = ptr.workOffsetMin.fromCValue()

  actual val workOffsetMax: Vec2
    get() = ptr.workOffsetMax.fromCValue()

  actual val dpiScale: Float
    get() = ptr.dpiScale

  actual val drawData: ImDrawData?
    get() = ptr.drawData?.let(::ImDrawData)

  actual val parentViewportId: ImGuiID
    get() = ptr.parentViewportId.let(::ImGuiID)

  actual var platformRequestMove: Boolean
    get() = ptr.platformRequestMove
    set(value) {
      ptr.platformRequestMove = value
    }

  actual var platformRequestResize: Boolean
    get() = ptr.platformRequestResize
    set(value) {
      ptr.platformRequestResize = value
    }

  actual var platformRequestClose: Boolean
    get() = ptr.platformRequestClose
    set(value) {
      ptr.platformRequestClose = value
    }

  actual constructor() : this(ImGuiViewport_ImGuiViewport()!!)

  actual fun destroy() {
    ImGuiViewport_destroy(ptr)
  }
}
