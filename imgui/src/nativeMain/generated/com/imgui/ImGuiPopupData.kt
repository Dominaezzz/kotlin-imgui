package com.imgui

import cimgui.internal.ImGuiPopupData_ImGuiPopupData
import cimgui.internal.ImGuiPopupData_destroy
import kotlin.Int
import kotlin.Suppress
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.pointed

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImGuiPopupData(
  val ptr: CPointer<cimgui.internal.ImGuiPopupData>
) {
  actual val popupId: ImGuiID
    get() = ptr.pointed.PopupId.let(::ImGuiID)

  actual val window: ImGuiWindow?
    get() = ptr.pointed.Window?.let(::ImGuiWindow)

  actual val sourceWindow: ImGuiWindow?
    get() = ptr.pointed.SourceWindow?.let(::ImGuiWindow)

  actual val openFrameCount: Int
    get() = ptr.pointed.OpenFrameCount

  actual val openParentId: ImGuiID
    get() = ptr.pointed.OpenParentId.let(::ImGuiID)

  actual val openPopupPos: Vec2
    get() = ptr.pointed.OpenPopupPos.fromCValue()

  actual val openMousePos: Vec2
    get() = ptr.pointed.OpenMousePos.fromCValue()

  actual constructor() : this(ImGuiPopupData_ImGuiPopupData()!!)

  actual fun destroy() {
    ImGuiPopupData_destroy(ptr)
  }
}
