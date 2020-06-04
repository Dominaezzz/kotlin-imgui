package com.imgui

import cimgui.internal.ImGuiColumnData_ImGuiColumnData
import cimgui.internal.ImGuiColumnData_destroy
import kotlin.Float
import kotlin.Suppress
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.pointed

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImGuiColumnData(
  val ptr: CPointer<cimgui.internal.ImGuiColumnData>
) {
  actual val offsetNorm: Float
    get() = ptr.pointed.OffsetNorm

  actual val offsetNormBeforeResize: Float
    get() = ptr.pointed.OffsetNormBeforeResize

  actual val flags: Flag<ImGuiColumnsFlags>
    get() = ptr.pointed.Flags.let { ImGuiColumnsFlags.fromMultiple(it) }

  actual constructor() : this(ImGuiColumnData_ImGuiColumnData()!!)

  actual fun destroy() {
    ImGuiColumnData_destroy(ptr)
  }
}
