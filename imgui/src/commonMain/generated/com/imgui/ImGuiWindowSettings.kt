package com.imgui

import kotlin.Boolean
import kotlin.Short

expect class ImGuiWindowSettings {
  val id: ImGuiID

  val viewportId: ImGuiID

  val dockId: ImGuiID

  val classId: ImGuiID

  val dockOrder: Short

  val collapsed: Boolean

  val wantApply: Boolean

  constructor()

  fun destroy()
}
