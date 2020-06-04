package com.imgui

import cimgui.internal.ImGuiNavMoveResult_Clear
import cimgui.internal.ImGuiNavMoveResult_ImGuiNavMoveResult
import cimgui.internal.ImGuiNavMoveResult_destroy
import kotlin.Float
import kotlin.Suppress
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.pointed

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImGuiNavMoveResult(
  val ptr: CPointer<cimgui.internal.ImGuiNavMoveResult>
) {
  actual val window: ImGuiWindow?
    get() = ptr.pointed.Window?.let(::ImGuiWindow)

  actual val id: ImGuiID
    get() = ptr.pointed.ID.let(::ImGuiID)

  actual val focusScopeId: ImGuiID
    get() = ptr.pointed.FocusScopeId.let(::ImGuiID)

  actual val distBox: Float
    get() = ptr.pointed.DistBox

  actual val distCenter: Float
    get() = ptr.pointed.DistCenter

  actual val distAxial: Float
    get() = ptr.pointed.DistAxial

  actual constructor() : this(ImGuiNavMoveResult_ImGuiNavMoveResult()!!)

  actual fun clear() {
    ImGuiNavMoveResult_Clear(ptr)
  }

  actual fun destroy() {
    ImGuiNavMoveResult_destroy(ptr)
  }
}
