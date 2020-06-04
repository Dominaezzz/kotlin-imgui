package com.imgui

import cimgui.internal.CImGui.ImGuiSettingsHandler_ImGuiSettingsHandler
import cimgui.internal.CImGui.ImGuiSettingsHandler_destroy
import kotlin.String
import kotlin.Suppress

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImGuiSettingsHandler(
  val ptr: cimgui.internal.ImGuiSettingsHandler
) {
  actual val typeName: String
    get() = ptr.typeName!!

  actual val typeHash: ImGuiID
    get() = ptr.typeHash.let(::ImGuiID)

  actual constructor() : this(ImGuiSettingsHandler_ImGuiSettingsHandler()!!)

  actual fun destroy() {
    ImGuiSettingsHandler_destroy(ptr)
  }
}
