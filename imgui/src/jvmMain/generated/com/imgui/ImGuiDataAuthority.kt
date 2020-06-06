package com.imgui

import cimgui.internal.ImGuiDataAuthority_.ImGuiDataAuthority_Auto
import cimgui.internal.ImGuiDataAuthority_.ImGuiDataAuthority_DockNode
import cimgui.internal.ImGuiDataAuthority_.ImGuiDataAuthority_Window
import kotlin.Int

actual enum class ImGuiDataAuthority(
  val value: Int
) {
  Auto(ImGuiDataAuthority_Auto),

  DockNode(ImGuiDataAuthority_DockNode),

  Window(ImGuiDataAuthority_Window);

  actual companion object {
    fun from(value: Int): ImGuiDataAuthority = when (value) {
      ImGuiDataAuthority_Auto -> Auto
      ImGuiDataAuthority_DockNode -> DockNode
      ImGuiDataAuthority_Window -> Window
      else -> throw NoSuchElementException("""Unknown enum constant $value""")
    }
  }
}
