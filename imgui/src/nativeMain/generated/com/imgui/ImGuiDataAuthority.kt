package com.imgui

import cimgui.internal.ImGuiDataAuthority_
import cimgui.internal.ImGuiDataAuthority_Auto
import cimgui.internal.ImGuiDataAuthority_DockNode
import cimgui.internal.ImGuiDataAuthority_Window
import kotlin.Int
import kotlinx.cinterop.convert

actual enum class ImGuiDataAuthority(
  val value: cimgui.internal.ImGuiDataAuthority
) {
  Auto(ImGuiDataAuthority_Auto.convert()),

  DockNode(ImGuiDataAuthority_DockNode.convert()),

  Window(ImGuiDataAuthority_Window.convert());

  actual val cValue: Int
    get() = value.convert()

  actual companion object {
    fun from(value: cimgui.internal.ImGuiDataAuthority): ImGuiDataAuthority = when
        (value.convert<ImGuiDataAuthority_>()) {
      ImGuiDataAuthority_Auto -> Auto
      ImGuiDataAuthority_DockNode -> DockNode
      ImGuiDataAuthority_Window -> Window
      else -> throw NoSuchElementException("""Unknown enum constant $value""")
    }
  }
}
