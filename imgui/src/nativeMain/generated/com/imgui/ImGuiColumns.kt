package com.imgui

import cimgui.internal.ImGuiColumns_Clear
import cimgui.internal.ImGuiColumns_ImGuiColumns
import cimgui.internal.ImGuiColumns_destroy
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.Suppress
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.pointed

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImGuiColumns(
  val ptr: CPointer<cimgui.internal.ImGuiColumns>
) {
  actual val id: ImGuiID
    get() = ptr.pointed.ID.let(::ImGuiID)

  actual val flags: Flag<ImGuiColumnsFlags>
    get() = ptr.pointed.Flags.let { ImGuiColumnsFlags.fromMultiple(it) }

  actual val isFirstFrame: Boolean
    get() = ptr.pointed.IsFirstFrame

  actual val isBeingResized: Boolean
    get() = ptr.pointed.IsBeingResized

  actual val current: Int
    get() = ptr.pointed.Current

  actual val count: Int
    get() = ptr.pointed.Count

  actual val offMinX: Float
    get() = ptr.pointed.OffMinX

  actual val offMaxX: Float
    get() = ptr.pointed.OffMaxX

  actual val lineMinY: Float
    get() = ptr.pointed.LineMinY

  actual val lineMaxY: Float
    get() = ptr.pointed.LineMaxY

  actual val hostCursorPosY: Float
    get() = ptr.pointed.HostCursorPosY

  actual val hostCursorMaxPosX: Float
    get() = ptr.pointed.HostCursorMaxPosX

  actual constructor() : this(ImGuiColumns_ImGuiColumns()!!)

  actual fun clear() {
    ImGuiColumns_Clear(ptr)
  }

  actual fun destroy() {
    ImGuiColumns_destroy(ptr)
  }
}
