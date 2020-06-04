package com.imgui

import cimgui.internal.CImGui.ImGuiPopupData_ImGuiPopupData
import cimgui.internal.CImGui.ImGuiPopupData_destroy
import kotlin.Int
import kotlin.Suppress

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImGuiPopupData(
  val ptr: cimgui.internal.ImGuiPopupData
) {
  actual val popupId: ImGuiID
    get() = ptr.popupId.let(::ImGuiID)

  actual val window: ImGuiWindow?
    get() = ptr.window?.let(::ImGuiWindow)

  actual val sourceWindow: ImGuiWindow?
    get() = ptr.sourceWindow?.let(::ImGuiWindow)

  actual val openFrameCount: Int
    get() = ptr.openFrameCount

  actual val openParentId: ImGuiID
    get() = ptr.openParentId.let(::ImGuiID)

  actual val openPopupPos: Vec2
    get() = ptr.openPopupPos.fromCValue()

  actual val openMousePos: Vec2
    get() = ptr.openMousePos.fromCValue()

  actual constructor() : this(ImGuiPopupData_ImGuiPopupData()!!)

  actual fun destroy() {
    ImGuiPopupData_destroy(ptr)
  }
}
