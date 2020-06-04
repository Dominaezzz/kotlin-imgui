package com.imgui

import kotlin.Boolean
import kotlin.Float
import kotlin.Int

expect class ImGuiColumns {
  val id: ImGuiID

  val flags: Flag<ImGuiColumnsFlags>

  val isFirstFrame: Boolean

  val isBeingResized: Boolean

  val current: Int

  val count: Int

  val offMinX: Float

  val offMaxX: Float

  val lineMinY: Float

  val lineMaxY: Float

  val hostCursorPosY: Float

  val hostCursorMaxPosX: Float

  constructor()

  fun clear()

  fun destroy()
}
