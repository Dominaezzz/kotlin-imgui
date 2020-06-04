package com.imgui

import cimgui.internal.CImGui.ImGuiInputTextState_ClearFreeMemory
import cimgui.internal.CImGui.ImGuiInputTextState_ClearSelection
import cimgui.internal.CImGui.ImGuiInputTextState_ClearText
import cimgui.internal.CImGui.ImGuiInputTextState_CursorAnimReset
import cimgui.internal.CImGui.ImGuiInputTextState_CursorClamp
import cimgui.internal.CImGui.ImGuiInputTextState_GetRedoAvailCount
import cimgui.internal.CImGui.ImGuiInputTextState_GetUndoAvailCount
import cimgui.internal.CImGui.ImGuiInputTextState_HasSelection
import cimgui.internal.CImGui.ImGuiInputTextState_ImGuiInputTextState
import cimgui.internal.CImGui.ImGuiInputTextState_OnKeyPressed
import cimgui.internal.CImGui.ImGuiInputTextState_SelectAll
import cimgui.internal.CImGui.ImGuiInputTextState_destroy
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.Suppress

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImGuiInputTextState(
  val ptr: cimgui.internal.ImGuiInputTextState
) {
  actual val id: ImGuiID
    get() = ptr.id.let(::ImGuiID)

  actual val curLenW: Int
    get() = ptr.curLenW

  actual val curLenA: Int
    get() = ptr.curLenA

  actual val textAIsValid: Boolean
    get() = ptr.textAIsValid

  actual val bufCapacityA: Int
    get() = ptr.bufCapacityA

  actual val scrollX: Float
    get() = ptr.scrollX

  actual val cursorAnim: Float
    get() = ptr.cursorAnim

  actual val cursorFollow: Boolean
    get() = ptr.cursorFollow

  actual val selectedAllMouseLock: Boolean
    get() = ptr.selectedAllMouseLock

  actual val userFlags: Flag<ImGuiInputTextFlags>
    get() = ptr.userFlags.let { ImGuiInputTextFlags.fromMultiple(it) }

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
