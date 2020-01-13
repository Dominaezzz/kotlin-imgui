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
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.pointed

inline class ImGuiInputTextCallbackData(
  val ptr: CPointer<cimgui.internal.ImGuiInputTextCallbackData>
) {
  val eventFlag: Flag<ImGuiInputTextFlags>
    get() = ptr.pointed.EventFlag.let { ImGuiInputTextFlags.fromMultiple(it) }

  val flags: Flag<ImGuiInputTextFlags>
    get() = ptr.pointed.Flags.let { ImGuiInputTextFlags.fromMultiple(it) }

  val eventChar: Char
    get() = ptr.pointed.EventChar.toShort().toChar()

  val eventKey: ImGuiKey
    get() = ptr.pointed.EventKey.let { ImGuiKey.from(it) }

  val bufTextLen: Int
    get() = ptr.pointed.BufTextLen

  val bufSize: Int
    get() = ptr.pointed.BufSize

  val bufDirty: Boolean
    get() = ptr.pointed.BufDirty

  val cursorPos: Int
    get() = ptr.pointed.CursorPos

  val selectionStart: Int
    get() = ptr.pointed.SelectionStart

  val selectionEnd: Int
    get() = ptr.pointed.SelectionEnd

  constructor() : this(ImGuiInputTextCallbackData_ImGuiInputTextCallbackData()!!)

  fun deleteChars(pos: Int, bytesCount: Int) {
    ImGuiInputTextCallbackData_DeleteChars(ptr, pos, bytesCount)
  }

  fun hasSelection(): Boolean = ImGuiInputTextCallbackData_HasSelection(ptr)

  fun insertChars(
    pos: Int,
    text: String,
    textEnd: String? = null
  ) {
    ImGuiInputTextCallbackData_InsertChars(ptr, pos, text, textEnd)
  }

  fun destroy() {
    ImGuiInputTextCallbackData_destroy(ptr)
  }
}
