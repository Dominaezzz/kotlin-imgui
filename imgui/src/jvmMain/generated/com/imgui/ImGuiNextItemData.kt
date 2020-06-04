package com.imgui

import cimgui.internal.CImGui.ImGuiNextItemData_ClearFlags
import cimgui.internal.CImGui.ImGuiNextItemData_ImGuiNextItemData
import cimgui.internal.CImGui.ImGuiNextItemData_destroy
import kotlin.Boolean
import kotlin.Float
import kotlin.Suppress

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImGuiNextItemData(
  val ptr: cimgui.internal.ImGuiNextItemData
) {
  actual val flags: Flag<ImGuiNextItemDataFlags>
    get() = ptr.flags.let { ImGuiNextItemDataFlags.fromMultiple(it) }

  actual val width: Float
    get() = ptr.width

  actual val focusScopeId: ImGuiID
    get() = ptr.focusScopeId.let(::ImGuiID)

  actual val openCond: Flag<ImGuiCond>
    get() = ptr.openCond.let { ImGuiCond.fromMultiple(it) }

  actual val openVal: Boolean
    get() = ptr.openVal

  actual constructor() : this(ImGuiNextItemData_ImGuiNextItemData()!!)

  actual fun clearFlags() {
    ImGuiNextItemData_ClearFlags(ptr)
  }

  actual fun destroy() {
    ImGuiNextItemData_destroy(ptr)
  }
}
