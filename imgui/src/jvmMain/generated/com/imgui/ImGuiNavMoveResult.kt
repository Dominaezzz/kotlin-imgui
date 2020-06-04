package com.imgui

import cimgui.internal.CImGui.ImGuiNavMoveResult_Clear
import cimgui.internal.CImGui.ImGuiNavMoveResult_ImGuiNavMoveResult
import cimgui.internal.CImGui.ImGuiNavMoveResult_destroy
import kotlin.Float
import kotlin.Suppress

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImGuiNavMoveResult(
  val ptr: cimgui.internal.ImGuiNavMoveResult
) {
  actual val window: ImGuiWindow?
    get() = ptr.window?.let(::ImGuiWindow)

  actual val id: ImGuiID
    get() = ptr.id.let(::ImGuiID)

  actual val focusScopeId: ImGuiID
    get() = ptr.focusScopeId.let(::ImGuiID)

  actual val distBox: Float
    get() = ptr.distBox

  actual val distCenter: Float
    get() = ptr.distCenter

  actual val distAxial: Float
    get() = ptr.distAxial

  actual constructor() : this(ImGuiNavMoveResult_ImGuiNavMoveResult()!!)

  actual fun clear() {
    ImGuiNavMoveResult_Clear(ptr)
  }

  actual fun destroy() {
    ImGuiNavMoveResult_destroy(ptr)
  }
}
