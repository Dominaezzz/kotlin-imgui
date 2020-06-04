package com.imgui

import kotlin.Boolean
import kotlin.Float

expect class ImGuiGroupData {
  val backupCursorPos: Vec2

  val backupCursorMaxPos: Vec2

  val backupCurrLineSize: Vec2

  val backupCurrLineTextBaseOffset: Float

  val backupActiveIdIsAlive: ImGuiID

  val backupActiveIdPreviousFrameIsAlive: Boolean

  val emitItem: Boolean
}
