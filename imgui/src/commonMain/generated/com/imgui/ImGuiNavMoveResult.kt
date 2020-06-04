package com.imgui

import kotlin.Float

expect class ImGuiNavMoveResult {
  val window: ImGuiWindow?

  val id: ImGuiID

  val focusScopeId: ImGuiID

  val distBox: Float

  val distCenter: Float

  val distAxial: Float

  constructor()

  fun clear()

  fun destroy()
}
