package com.imgui

import kotlin.Boolean
import kotlin.Int
import kotlin.String

expect class ImGuiTextBuffer {
  constructor()

  fun append(str: String, strEnd: String? = null)

  fun appendf(fmt: String)

  fun begin(): String?

  fun c_str(): String?

  fun clear()

  fun destroy()

  fun empty(): Boolean

  fun end(): String?

  fun reserve(capacity: Int)

  fun size(): Int
}
