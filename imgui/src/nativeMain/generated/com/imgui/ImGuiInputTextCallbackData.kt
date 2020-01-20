package com.imgui

import cimgui.internal.ImGuiInputTextCallbackData_DeleteChars
import cimgui.internal.ImGuiInputTextCallbackData_HasSelection
import cimgui.internal.ImGuiInputTextCallbackData_ImGuiInputTextCallbackData
import cimgui.internal.ImGuiInputTextCallbackData_InsertChars
import cimgui.internal.ImGuiInputTextCallbackData_destroy
import kotlin.Boolean
import kotlin.Char
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.pointed

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImGuiInputTextCallbackData(
  val ptr: CPointer<cimgui.internal.ImGuiInputTextCallbackData>
) {
  actual val eventFlag: Flag<ImGuiInputTextFlags>
    get() = ptr.pointed.EventFlag.let { ImGuiInputTextFlags.fromMultiple(it) }

  actual val flags: Flag<ImGuiInputTextFlags>
    get() = ptr.pointed.Flags.let { ImGuiInputTextFlags.fromMultiple(it) }

  actual val eventChar: Char
    get() = ptr.pointed.EventChar.toShort().toChar()

  actual val eventKey: ImGuiKey
    get() = ptr.pointed.EventKey.let { ImGuiKey.from(it) }

  actual val bufTextLen: Int
    get() = ptr.pointed.BufTextLen

  actual val bufSize: Int
    get() = ptr.pointed.BufSize

  actual val bufDirty: Boolean
    get() = ptr.pointed.BufDirty

  actual val cursorPos: Int
    get() = ptr.pointed.CursorPos

  actual val selectionStart: Int
    get() = ptr.pointed.SelectionStart

  actual val selectionEnd: Int
    get() = ptr.pointed.SelectionEnd

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
