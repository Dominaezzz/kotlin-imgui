package com.imgui

import cimgui.internal.ImGuiDockNodeFlags_
import cimgui.internal.ImGuiDockNodeFlags_AutoHideTabBar
import cimgui.internal.ImGuiDockNodeFlags_KeepAliveOnly
import cimgui.internal.ImGuiDockNodeFlags_NoDockingInCentralNode
import cimgui.internal.ImGuiDockNodeFlags_NoResize
import cimgui.internal.ImGuiDockNodeFlags_NoSplit
import cimgui.internal.ImGuiDockNodeFlags_PassthruCentralNode
import kotlin.Int
import kotlinx.cinterop.convert

actual enum class ImGuiDockNodeFlags(
  override val value: cimgui.internal.ImGuiDockNodeFlags
) : Flag<ImGuiDockNodeFlags> {
  KeepAliveOnly(ImGuiDockNodeFlags_KeepAliveOnly.convert()),

  NoDockingInCentralNode(ImGuiDockNodeFlags_NoDockingInCentralNode.convert()),

  PassthruCentralNode(ImGuiDockNodeFlags_PassthruCentralNode.convert()),

  NoSplit(ImGuiDockNodeFlags_NoSplit.convert()),

  NoResize(ImGuiDockNodeFlags_NoResize.convert()),

  AutoHideTabBar(ImGuiDockNodeFlags_AutoHideTabBar.convert());

  actual val cValue: Int
    get() = value.convert()

  override val info: Flag.EnumInfo<ImGuiDockNodeFlags>
    get() = cachedInfo
  actual companion object {
    private val cachedInfo: Flag.EnumInfo<ImGuiDockNodeFlags> = Flag.enumInfo()

    fun from(value: cimgui.internal.ImGuiDockNodeFlags): ImGuiDockNodeFlags = when
        (value.convert<ImGuiDockNodeFlags_>()) {
      ImGuiDockNodeFlags_KeepAliveOnly -> KeepAliveOnly
      ImGuiDockNodeFlags_NoDockingInCentralNode -> NoDockingInCentralNode
      ImGuiDockNodeFlags_PassthruCentralNode -> PassthruCentralNode
      ImGuiDockNodeFlags_NoSplit -> NoSplit
      ImGuiDockNodeFlags_NoResize -> NoResize
      ImGuiDockNodeFlags_AutoHideTabBar -> AutoHideTabBar
      else -> throw NoSuchElementException("""Unknown enum constant $value""")
    }

    fun fromMultiple(value: cimgui.internal.ImGuiDockNodeFlags): Flag<ImGuiDockNodeFlags> =
        Flag(value.convert(), cachedInfo)
  }
}
