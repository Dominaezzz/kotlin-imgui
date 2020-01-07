package com.imgui

import cimgui.internal.ImGuiCond_Always
import cimgui.internal.ImGuiCond_Appearing
import cimgui.internal.ImGuiCond_FirstUseEver
import cimgui.internal.ImGuiCond_Once
import kotlin.Int

enum class ImGuiCond(
  override val value: Int
) : Flag<ImGuiCond> {
  Always(ImGuiCond_Always.toInt()),

  Once(ImGuiCond_Once.toInt()),

  FirstUseEver(ImGuiCond_FirstUseEver.toInt()),

  Appearing(ImGuiCond_Appearing.toInt());

  override val info: Flag.EnumInfo<ImGuiCond>
    get() = cachedInfo
  companion object {
    private val cachedInfo: Flag.EnumInfo<ImGuiCond> = Flag.enumInfo()
  }
}
