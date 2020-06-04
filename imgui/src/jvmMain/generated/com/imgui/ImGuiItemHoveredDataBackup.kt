package com.imgui

import cimgui.internal.CImGui.ImGuiItemHoveredDataBackup_Backup
import cimgui.internal.CImGui.ImGuiItemHoveredDataBackup_ImGuiItemHoveredDataBackup
import cimgui.internal.CImGui.ImGuiItemHoveredDataBackup_Restore
import cimgui.internal.CImGui.ImGuiItemHoveredDataBackup_destroy
import kotlin.Suppress

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImGuiItemHoveredDataBackup(
  val ptr: cimgui.internal.ImGuiItemHoveredDataBackup
) {
  actual val lastItemId: ImGuiID
    get() = ptr.lastItemId.let(::ImGuiID)

  actual val lastItemStatusFlags: Flag<ImGuiItemStatusFlags>
    get() = ptr.lastItemStatusFlags.let { ImGuiItemStatusFlags.fromMultiple(it) }

  actual constructor() : this(ImGuiItemHoveredDataBackup_ImGuiItemHoveredDataBackup()!!)

  actual fun backup() {
    ImGuiItemHoveredDataBackup_Backup(ptr)
  }

  actual fun restore() {
    ImGuiItemHoveredDataBackup_Restore(ptr)
  }

  actual fun destroy() {
    ImGuiItemHoveredDataBackup_destroy(ptr)
  }
}
