package com.imgui

import cimgui.internal.ImGuiMouseButton_.ImGuiMouseButton_Left
import cimgui.internal.ImGuiMouseButton_.ImGuiMouseButton_Middle
import cimgui.internal.ImGuiMouseButton_.ImGuiMouseButton_Right
import kotlin.Int

actual enum class ImGuiMouseButton(
  val value: Int
) {
  Left(ImGuiMouseButton_Left),

  Right(ImGuiMouseButton_Right),

  Middle(ImGuiMouseButton_Middle);

  actual val cValue: Int
    get() = value

  actual companion object {
    fun from(value: Int): ImGuiMouseButton = when (value) {
      ImGuiMouseButton_Left -> Left
      ImGuiMouseButton_Right -> Right
      ImGuiMouseButton_Middle -> Middle
      else -> throw NoSuchElementException("""Unknown enum constant $value""")
    }
  }
}
