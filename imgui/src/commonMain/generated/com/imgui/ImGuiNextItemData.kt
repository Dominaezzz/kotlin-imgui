package com.imgui

import kotlin.Boolean
import kotlin.Float

expect class ImGuiNextItemData {
  val flags: Flag<ImGuiNextItemDataFlags>

  val width: Float

  val focusScopeId: ImGuiID

  val openCond: Flag<ImGuiCond>

  val openVal: Boolean

  constructor()

  fun clearFlags()

  fun destroy()
}
