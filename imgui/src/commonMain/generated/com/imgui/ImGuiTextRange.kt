package com.imgui

import kotlin.Boolean
import kotlin.String

expect class ImGuiTextRange {
  val b: String

  val e: String

  constructor()

  constructor(b: String, e: String)

  fun destroy()

  fun empty(): Boolean
}
