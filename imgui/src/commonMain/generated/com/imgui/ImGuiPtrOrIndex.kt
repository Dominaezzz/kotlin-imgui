package com.imgui

import kotlin.Int

expect class ImGuiPtrOrIndex {
  val index: Int

  constructor(index: Int)

  fun destroy()
}
