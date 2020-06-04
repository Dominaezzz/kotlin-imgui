package com.imgui

import cimgui.internal.ImGuiItemHoveredDataBackup_Backup
import cimgui.internal.ImGuiItemHoveredDataBackup_ImGuiItemHoveredDataBackup
import cimgui.internal.ImGuiItemHoveredDataBackup_Restore
import cimgui.internal.ImGuiItemHoveredDataBackup_destroy
import kotlin.Suppress
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.pointed

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImGuiItemHoveredDataBackup(
  val ptr: CPointer<cimgui.internal.ImGuiItemHoveredDataBackup>
) {
  actual val lastItemId: ImGuiID
    get() = ptr.pointed.LastItemId.let(::ImGuiID)

  actual val lastItemStatusFlags: Flag<ImGuiItemStatusFlags>
    get() = ptr.pointed.LastItemStatusFlags.let { ImGuiItemStatusFlags.fromMultiple(it) }

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
