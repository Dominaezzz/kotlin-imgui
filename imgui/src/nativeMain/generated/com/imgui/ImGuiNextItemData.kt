package com.imgui

import cimgui.internal.ImGuiNextItemData_ClearFlags
import cimgui.internal.ImGuiNextItemData_ImGuiNextItemData
import cimgui.internal.ImGuiNextItemData_destroy
import kotlin.Boolean
import kotlin.Float
import kotlin.Suppress
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.pointed

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImGuiNextItemData(
  val ptr: CPointer<cimgui.internal.ImGuiNextItemData>
) {
  actual val flags: Flag<ImGuiNextItemDataFlags>
    get() = ptr.pointed.Flags.let { ImGuiNextItemDataFlags.fromMultiple(it) }

  actual val width: Float
    get() = ptr.pointed.Width

  actual val focusScopeId: ImGuiID
    get() = ptr.pointed.FocusScopeId.let(::ImGuiID)

  actual val openCond: Flag<ImGuiCond>
    get() = ptr.pointed.OpenCond.let { ImGuiCond.fromMultiple(it) }

  actual val openVal: Boolean
    get() = ptr.pointed.OpenVal

  actual constructor() : this(ImGuiNextItemData_ImGuiNextItemData()!!)

  actual fun clearFlags() {
    ImGuiNextItemData_ClearFlags(ptr)
  }

  actual fun destroy() {
    ImGuiNextItemData_destroy(ptr)
  }
}
