package com.imgui

import cimgui.internal.CImGui.ImGuiDockContext_destroy
import kotlin.Boolean
import kotlin.Suppress

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImGuiDockContext(
  val ptr: cimgui.internal.ImGuiDockContext
) {
  actual val wantFullRebuild: Boolean
    get() = ptr.wantFullRebuild

  actual fun destroy() {
    ImGuiDockContext_destroy(ptr)
  }
}
