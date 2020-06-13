package com.imgui

import cimgui.internal.ImGuiMouseButton_
import cimgui.internal.ImGuiMouseButton_Left
import cimgui.internal.ImGuiMouseButton_Middle
import cimgui.internal.ImGuiMouseButton_Right
import kotlin.Int
import kotlinx.cinterop.convert

actual enum class ImGuiMouseButton(
  val value: cimgui.internal.ImGuiMouseButton
) {
  Left(ImGuiMouseButton_Left.convert()),

  Right(ImGuiMouseButton_Right.convert()),

  Middle(ImGuiMouseButton_Middle.convert());

  actual val cValue: Int
    get() = value.convert()

  actual companion object {
    fun from(value: cimgui.internal.ImGuiMouseButton): ImGuiMouseButton = when
        (value.convert<ImGuiMouseButton_>()) {
      ImGuiMouseButton_Left -> Left
      ImGuiMouseButton_Right -> Right
      ImGuiMouseButton_Middle -> Middle
      else -> throw NoSuchElementException("""Unknown enum constant $value""")
    }
  }
}
