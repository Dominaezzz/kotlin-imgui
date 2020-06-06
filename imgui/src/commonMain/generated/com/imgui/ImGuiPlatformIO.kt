package com.imgui

expect class ImGuiPlatformIO {
  val mainViewport: ImGuiViewport?

  constructor()

  fun destroy()
}
