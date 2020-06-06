package com.imgui

import cimgui.internal.CImGui.ImGuiWindowSettings_ImGuiWindowSettings
import cimgui.internal.CImGui.ImGuiWindowSettings_destroy
import kotlin.Boolean
import kotlin.Short
import kotlin.Suppress

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImGuiWindowSettings(
  val ptr: cimgui.internal.ImGuiWindowSettings
) {
  actual val id: ImGuiID
    get() = ptr.id.let(::ImGuiID)

  actual val viewportId: ImGuiID
    get() = ptr.viewportId.let(::ImGuiID)

  actual val dockId: ImGuiID
    get() = ptr.dockId.let(::ImGuiID)

  actual val classId: ImGuiID
    get() = ptr.classId.let(::ImGuiID)

  actual val dockOrder: Short
    get() = ptr.dockOrder

  actual val collapsed: Boolean
    get() = ptr.collapsed

  actual val wantApply: Boolean
    get() = ptr.wantApply

  actual constructor() : this(ImGuiWindowSettings_ImGuiWindowSettings()!!)

  actual fun destroy() {
    ImGuiWindowSettings_destroy(ptr)
  }
}
