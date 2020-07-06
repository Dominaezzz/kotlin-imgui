package com.imgui

import kotlin.Boolean

expect class ImGuiWindowSettings {
  val id: ImGuiID

  val collapsed: Boolean

  val wantApply: Boolean

  constructor()

  fun destroy()
}
