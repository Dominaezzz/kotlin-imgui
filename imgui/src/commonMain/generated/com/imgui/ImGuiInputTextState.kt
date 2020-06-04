package com.imgui

import kotlin.Boolean
import kotlin.Float
import kotlin.Int

expect class ImGuiInputTextState {
  val id: ImGuiID

  val curLenW: Int

  val curLenA: Int

  val textAIsValid: Boolean

  val bufCapacityA: Int

  val scrollX: Float

  val cursorAnim: Float

  val cursorFollow: Boolean

  val selectedAllMouseLock: Boolean

  val userFlags: Flag<ImGuiInputTextFlags>

  constructor()

  fun clearFreeMemory()

  fun clearSelection()

  fun clearText()

  fun cursorAnimReset()

  fun cursorClamp()

  fun getRedoAvailCount(): Int

  fun getUndoAvailCount(): Int

  fun hasSelection(): Boolean

  fun onKeyPressed(key: Int)

  fun selectAll()

  fun destroy()
}
