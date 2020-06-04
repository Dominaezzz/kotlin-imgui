package com.imgui

import kotlin.String

expect class ImGuiSettingsHandler {
  val typeName: String

  val typeHash: ImGuiID

  constructor()

  fun destroy()
}
