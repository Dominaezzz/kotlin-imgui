package com.imgui

import kotlin.Float

expect class ImGuiColumnData {
  val offsetNorm: Float

  val offsetNormBeforeResize: Float

  val flags: Flag<ImGuiColumnsFlags>

  constructor()

  fun destroy()
}
