package com.imgui

import kotlin.Int

expect class ImGuiPopupData {
  val popupId: ImGuiID

  val window: ImGuiWindow?

  val sourceWindow: ImGuiWindow?

  val openFrameCount: Int

  val openParentId: ImGuiID

  val openPopupPos: Vec2

  val openMousePos: Vec2

  constructor()

  fun destroy()
}
