package com.imgui

import kotlin.Boolean
import kotlin.Char
import kotlin.Int
import kotlin.String

expect class ImGuiInputTextCallbackData {
  val eventFlag: Flag<ImGuiInputTextFlags>

  val flags: Flag<ImGuiInputTextFlags>

  val eventChar: Char

  val eventKey: ImGuiKey

  val bufTextLen: Int

  val bufSize: Int

  val bufDirty: Boolean

  val cursorPos: Int

  val selectionStart: Int

  val selectionEnd: Int

  constructor()

  fun deleteChars(pos: Int, bytesCount: Int)

  fun hasSelection(): Boolean

  fun insertChars(
    pos: Int,
    text: String,
    textEnd: String? = null
  )

  fun destroy()
}
