package com.imgui

import cimgui.internal.ImGuiWindowSettings_ImGuiWindowSettings
import cimgui.internal.ImGuiWindowSettings_destroy
import kotlin.Boolean
import kotlin.Short
import kotlin.Suppress
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.pointed

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImGuiWindowSettings(
  val ptr: CPointer<cimgui.internal.ImGuiWindowSettings>
) {
  actual val id: ImGuiID
    get() = ptr.pointed.ID.let(::ImGuiID)

  actual val viewportId: ImGuiID
    get() = ptr.pointed.ViewportId.let(::ImGuiID)

  actual val dockId: ImGuiID
    get() = ptr.pointed.DockId.let(::ImGuiID)

  actual val classId: ImGuiID
    get() = ptr.pointed.ClassId.let(::ImGuiID)

  actual val dockOrder: Short
    get() = ptr.pointed.DockOrder

  actual val collapsed: Boolean
    get() = ptr.pointed.Collapsed

  actual val wantApply: Boolean
    get() = ptr.pointed.WantApply

  actual constructor() : this(ImGuiWindowSettings_ImGuiWindowSettings()!!)

  actual fun destroy() {
    ImGuiWindowSettings_destroy(ptr)
  }
}
