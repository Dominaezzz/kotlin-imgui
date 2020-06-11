package com.imgui

import cimgui.internal.ImGuiDockContext_destroy
import kotlin.Boolean
import kotlin.Suppress
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.pointed

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImGuiDockContext(
  val ptr: CPointer<cimgui.internal.ImGuiDockContext>
) {
  actual val wantFullRebuild: Boolean
    get() = ptr.pointed.WantFullRebuild

  actual fun destroy() {
    ImGuiDockContext_destroy(ptr)
  }
}
