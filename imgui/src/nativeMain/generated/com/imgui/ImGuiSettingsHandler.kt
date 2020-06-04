package com.imgui

import cimgui.internal.ImGuiSettingsHandler_ImGuiSettingsHandler
import cimgui.internal.ImGuiSettingsHandler_destroy
import kotlin.String
import kotlin.Suppress
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.pointed
import kotlinx.cinterop.toKString

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImGuiSettingsHandler(
  val ptr: CPointer<cimgui.internal.ImGuiSettingsHandler>
) {
  actual val typeName: String
    get() = ptr.pointed.TypeName!!.toKString()

  actual val typeHash: ImGuiID
    get() = ptr.pointed.TypeHash.let(::ImGuiID)

  actual constructor() : this(ImGuiSettingsHandler_ImGuiSettingsHandler()!!)

  actual fun destroy() {
    ImGuiSettingsHandler_destroy(ptr)
  }
}
