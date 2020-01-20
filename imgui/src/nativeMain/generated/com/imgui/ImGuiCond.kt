package com.imgui

import cimgui.internal.ImGuiCond_
import cimgui.internal.ImGuiCond_Always
import cimgui.internal.ImGuiCond_Appearing
import cimgui.internal.ImGuiCond_FirstUseEver
import cimgui.internal.ImGuiCond_Once
import kotlinx.cinterop.convert

actual enum class ImGuiCond(
  override val value: cimgui.internal.ImGuiCond
) : Flag<ImGuiCond> {
  Always(ImGuiCond_Always.convert()),

  Once(ImGuiCond_Once.convert()),

  FirstUseEver(ImGuiCond_FirstUseEver.convert()),

  Appearing(ImGuiCond_Appearing.convert());

  override val info: Flag.EnumInfo<ImGuiCond>
    get() = cachedInfo
  actual companion object {
    private val cachedInfo: Flag.EnumInfo<ImGuiCond> = Flag.enumInfo()

    fun from(value: cimgui.internal.ImGuiCond): ImGuiCond = when (value.convert<ImGuiCond_>()) {
      ImGuiCond_Always -> Always
      ImGuiCond_Once -> Once
      ImGuiCond_FirstUseEver -> FirstUseEver
      ImGuiCond_Appearing -> Appearing
      else -> throw NoSuchElementException("""Unknown enum constant $value""")
    }

    fun fromMultiple(value: cimgui.internal.ImGuiCond): Flag<ImGuiCond> = Flag(value.convert(),
        cachedInfo)
  }
}
