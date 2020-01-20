package com.imgui

import kotlin.Int

expect class ImGuiOnceUponAFrame {
  val refFrame: Int

  constructor()

  fun destroy()
}
