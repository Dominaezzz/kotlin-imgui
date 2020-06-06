package com.imgui

import cimgui.internal.ImGuiDockNodeFlags_.ImGuiDockNodeFlags_AutoHideTabBar
import cimgui.internal.ImGuiDockNodeFlags_.ImGuiDockNodeFlags_KeepAliveOnly
import cimgui.internal.ImGuiDockNodeFlags_.ImGuiDockNodeFlags_NoDockingInCentralNode
import cimgui.internal.ImGuiDockNodeFlags_.ImGuiDockNodeFlags_NoResize
import cimgui.internal.ImGuiDockNodeFlags_.ImGuiDockNodeFlags_NoSplit
import cimgui.internal.ImGuiDockNodeFlags_.ImGuiDockNodeFlags_PassthruCentralNode
import kotlin.Int

actual enum class ImGuiDockNodeFlags(
  override val value: Int
) : Flag<ImGuiDockNodeFlags> {
  KeepAliveOnly(ImGuiDockNodeFlags_KeepAliveOnly),

  NoDockingInCentralNode(ImGuiDockNodeFlags_NoDockingInCentralNode),

  PassthruCentralNode(ImGuiDockNodeFlags_PassthruCentralNode),

  NoSplit(ImGuiDockNodeFlags_NoSplit),

  NoResize(ImGuiDockNodeFlags_NoResize),

  AutoHideTabBar(ImGuiDockNodeFlags_AutoHideTabBar);

  override val info: Flag.EnumInfo<ImGuiDockNodeFlags>
    get() = cachedInfo
  actual companion object {
    private val cachedInfo: Flag.EnumInfo<ImGuiDockNodeFlags> = Flag.enumInfo()

    fun from(value: Int): ImGuiDockNodeFlags = when (value) {
      ImGuiDockNodeFlags_KeepAliveOnly -> KeepAliveOnly
      ImGuiDockNodeFlags_NoDockingInCentralNode -> NoDockingInCentralNode
      ImGuiDockNodeFlags_PassthruCentralNode -> PassthruCentralNode
      ImGuiDockNodeFlags_NoSplit -> NoSplit
      ImGuiDockNodeFlags_NoResize -> NoResize
      ImGuiDockNodeFlags_AutoHideTabBar -> AutoHideTabBar
      else -> throw NoSuchElementException("""Unknown enum constant $value""")
    }

    fun fromMultiple(value: Int): Flag<ImGuiDockNodeFlags> = Flag(value, cachedInfo)
  }
}
