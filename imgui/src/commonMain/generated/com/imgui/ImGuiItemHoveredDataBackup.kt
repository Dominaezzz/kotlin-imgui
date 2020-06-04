package com.imgui

expect class ImGuiItemHoveredDataBackup {
  val lastItemId: ImGuiID

  val lastItemStatusFlags: Flag<ImGuiItemStatusFlags>

  constructor()

  fun backup()

  fun restore()

  fun destroy()
}
