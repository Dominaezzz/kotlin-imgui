package com.imgui

import cimgui.internal.CImGui.ImGuiColumns_Clear
import cimgui.internal.CImGui.ImGuiColumns_ImGuiColumns
import cimgui.internal.CImGui.ImGuiColumns_destroy
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.Suppress

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImGuiColumns(
  val ptr: cimgui.internal.ImGuiColumns
) {
  actual val id: ImGuiID
    get() = ptr.id.let(::ImGuiID)

  actual val flags: Flag<ImGuiColumnsFlags>
    get() = ptr.flags.let { ImGuiColumnsFlags.fromMultiple(it) }

  actual val isFirstFrame: Boolean
    get() = ptr.isFirstFrame

  actual val isBeingResized: Boolean
    get() = ptr.isBeingResized

  actual val current: Int
    get() = ptr.current

  actual val count: Int
    get() = ptr.count

  actual val offMinX: Float
    get() = ptr.offMinX

  actual val offMaxX: Float
    get() = ptr.offMaxX

  actual val lineMinY: Float
    get() = ptr.lineMinY

  actual val lineMaxY: Float
    get() = ptr.lineMaxY

  actual val hostCursorPosY: Float
    get() = ptr.hostCursorPosY

  actual val hostCursorMaxPosX: Float
    get() = ptr.hostCursorMaxPosX

  actual constructor() : this(ImGuiColumns_ImGuiColumns()!!)

  actual fun clear() {
    ImGuiColumns_Clear(ptr)
  }

  actual fun destroy() {
    ImGuiColumns_destroy(ptr)
  }
}
