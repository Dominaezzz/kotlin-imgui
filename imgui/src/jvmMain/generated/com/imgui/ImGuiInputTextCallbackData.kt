package com.imgui

import cimgui.internal.CImGui.ImGuiInputTextCallbackData_DeleteChars
import cimgui.internal.CImGui.ImGuiInputTextCallbackData_HasSelection
import cimgui.internal.CImGui.ImGuiInputTextCallbackData_ImGuiInputTextCallbackData
import cimgui.internal.CImGui.ImGuiInputTextCallbackData_InsertChars
import cimgui.internal.CImGui.ImGuiInputTextCallbackData_destroy
import kotlin.Boolean
import kotlin.Char
import kotlin.Int
import kotlin.String
import kotlin.Suppress

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImGuiInputTextCallbackData(
  val ptr: cimgui.internal.ImGuiInputTextCallbackData
) {
  actual val eventFlag: Flag<ImGuiInputTextFlags>
    get() = ptr.eventFlag.let { ImGuiInputTextFlags.fromMultiple(it) }

  actual val flags: Flag<ImGuiInputTextFlags>
    get() = ptr.flags.let { ImGuiInputTextFlags.fromMultiple(it) }

  actual val eventChar: Char
    get() = ptr.eventChar.toShort().toChar()

  actual val eventKey: ImGuiKey
    get() = ptr.eventKey.let { ImGuiKey.from(it) }

  actual val bufTextLen: Int
    get() = ptr.bufTextLen

  actual val bufSize: Int
    get() = ptr.bufSize

  actual val bufDirty: Boolean
    get() = ptr.bufDirty

  actual val cursorPos: Int
    get() = ptr.cursorPos

  actual val selectionStart: Int
    get() = ptr.selectionStart

  actual val selectionEnd: Int
    get() = ptr.selectionEnd

  actual constructor() : this(ImGuiInputTextCallbackData_ImGuiInputTextCallbackData()!!)

  actual fun deleteChars(pos: Int, bytesCount: Int) {
    ImGuiInputTextCallbackData_DeleteChars(ptr, pos, bytesCount)
  }

  actual fun hasSelection(): Boolean = ImGuiInputTextCallbackData_HasSelection(ptr)

  actual fun insertChars(
    pos: Int,
    text: String,
    textEnd: String?
  ) {
    ImGuiInputTextCallbackData_InsertChars(ptr, pos, text, textEnd)
  }

  actual fun destroy() {
    ImGuiInputTextCallbackData_destroy(ptr)
  }
}
