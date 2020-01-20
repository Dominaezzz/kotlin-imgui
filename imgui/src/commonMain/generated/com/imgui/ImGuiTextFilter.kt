package com.imgui

import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.String

expect class ImGuiTextFilter {
  val countGrep: Int

  constructor(defaultFilter: String = "")

  fun build()

  fun clear()

  fun draw(label: String = "Filter(inc,-exc)", width: Float = 0.0f): Boolean

  fun isActive(): Boolean

  fun passFilter(text: String, textEnd: String? = null): Boolean

  fun destroy()
}
