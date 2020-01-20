package com.imgui

import kotlin.Float
import kotlin.Int

expect class ImGuiStoragePair {
  val key: ImGuiID

  constructor(key: ImGuiID, valI: Int)

  constructor(key: ImGuiID, valF: Float)

  fun destroy()
}
