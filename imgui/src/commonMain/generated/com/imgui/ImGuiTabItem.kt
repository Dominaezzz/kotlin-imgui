package com.imgui

import kotlin.Float
import kotlin.Int

expect class ImGuiTabItem {
  val id: ImGuiID

  val flags: Flag<ImGuiTabItemFlags>

  val lastFrameVisible: Int

  val lastFrameSelected: Int

  val nameOffset: Int

  val offset: Float

  val width: Float

  val contentWidth: Float

  constructor()

  fun destroy()
}
