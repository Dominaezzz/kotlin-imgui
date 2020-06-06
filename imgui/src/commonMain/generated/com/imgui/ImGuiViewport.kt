package com.imgui

import kotlin.Boolean
import kotlin.Float

expect class ImGuiViewport {
  val id: ImGuiID

  val flags: Flag<ImGuiViewportFlags>

  val pos: Vec2

  val size: Vec2

  val workOffsetMin: Vec2

  val workOffsetMax: Vec2

  val dpiScale: Float

  val drawData: ImDrawData?

  val parentViewportId: ImGuiID

  val platformRequestMove: Boolean

  val platformRequestResize: Boolean

  val platformRequestClose: Boolean

  constructor()

  fun destroy()
}
