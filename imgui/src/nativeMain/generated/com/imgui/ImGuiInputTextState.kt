package com.imgui

import cimgui.internal.ImGuiInputTextState_ClearFreeMemory
import cimgui.internal.ImGuiInputTextState_ClearSelection
import cimgui.internal.ImGuiInputTextState_ClearText
import cimgui.internal.ImGuiInputTextState_CursorAnimReset
import cimgui.internal.ImGuiInputTextState_CursorClamp
import cimgui.internal.ImGuiInputTextState_GetRedoAvailCount
import cimgui.internal.ImGuiInputTextState_GetUndoAvailCount
import cimgui.internal.ImGuiInputTextState_HasSelection
import cimgui.internal.ImGuiInputTextState_ImGuiInputTextState
import cimgui.internal.ImGuiInputTextState_OnKeyPressed
import cimgui.internal.ImGuiInputTextState_SelectAll
import cimgui.internal.ImGuiInputTextState_destroy
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.Suppress
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.pointed

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImGuiInputTextState(
  val ptr: CPointer<cimgui.internal.ImGuiInputTextState>
) {
  actual val id: ImGuiID
    get() = ptr.pointed.ID.let(::ImGuiID)

  actual val curLenW: Int
    get() = ptr.pointed.CurLenW

  actual val curLenA: Int
    get() = ptr.pointed.CurLenA

  actual val textAIsValid: Boolean
    get() = ptr.pointed.TextAIsValid

  actual val bufCapacityA: Int
    get() = ptr.pointed.BufCapacityA

  actual val scrollX: Float
    get() = ptr.pointed.ScrollX

  actual val cursorAnim: Float
    get() = ptr.pointed.CursorAnim

  actual val cursorFollow: Boolean
    get() = ptr.pointed.CursorFollow

  actual val selectedAllMouseLock: Boolean
    get() = ptr.pointed.SelectedAllMouseLock

  actual val userFlags: Flag<ImGuiInputTextFlags>
    get() = ptr.pointed.UserFlags.let { ImGuiInputTextFlags.fromMultiple(it) }

  actual constructor() : this(ImGuiInputTextState_ImGuiInputTextState()!!)

  actual fun clearFreeMemory() {
    ImGuiInputTextState_ClearFreeMemory(ptr)
  }

  actual fun clearSelection() {
    ImGuiInputTextState_ClearSelection(ptr)
  }

  actual fun clearText() {
    ImGuiInputTextState_ClearText(ptr)
  }

  actual fun cursorAnimReset() {
    ImGuiInputTextState_CursorAnimReset(ptr)
  }

  actual fun cursorClamp() {
    ImGuiInputTextState_CursorClamp(ptr)
  }

  actual fun getRedoAvailCount(): Int = ImGuiInputTextState_GetRedoAvailCount(ptr)

  actual fun getUndoAvailCount(): Int = ImGuiInputTextState_GetUndoAvailCount(ptr)

  actual fun hasSelection(): Boolean = ImGuiInputTextState_HasSelection(ptr)

  actual fun onKeyPressed(key: Int) {
    ImGuiInputTextState_OnKeyPressed(ptr, key)
  }

  actual fun selectAll() {
    ImGuiInputTextState_SelectAll(ptr)
  }

  actual fun destroy() {
    ImGuiInputTextState_destroy(ptr)
  }
}
