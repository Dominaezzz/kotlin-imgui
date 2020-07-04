package com.imgui

import kotlin.Float

expect class ImGuiPlatformMonitor {
  var mainPos: Vec2

  var mainSize: Vec2

  var workPos: Vec2

  var workSize: Vec2

  var dpiScale: Float

  constructor()

  fun destroy()
}
