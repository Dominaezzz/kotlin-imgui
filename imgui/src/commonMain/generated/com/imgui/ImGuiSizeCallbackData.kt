package com.imgui

expect class ImGuiSizeCallbackData {
  val pos: Vec2

  val currentSize: Vec2

  val desiredSize: Vec2
}
