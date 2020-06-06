package com.imgui

import kotlin.Float

expect class ImGuiPlatformMonitor {
  val mainPos: Vec2

  val mainSize: Vec2

  val workPos: Vec2

  val workSize: Vec2

  val dpiScale: Float

  constructor()

  fun destroy()
}
