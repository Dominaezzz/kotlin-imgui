package com.imgui

import cimgui.internal.ImGuiCond_.ImGuiCond_Always
import cimgui.internal.ImGuiCond_.ImGuiCond_Appearing
import cimgui.internal.ImGuiCond_.ImGuiCond_FirstUseEver
import cimgui.internal.ImGuiCond_.ImGuiCond_Once
import kotlin.Int

actual enum class ImGuiCond(
  override val value: Int
) : Flag<ImGuiCond> {
  Always(ImGuiCond_Always),

  Once(ImGuiCond_Once),

  FirstUseEver(ImGuiCond_FirstUseEver),

  Appearing(ImGuiCond_Appearing);

  override val info: Flag.EnumInfo<ImGuiCond>
    get() = cachedInfo
  actual companion object {
    private val cachedInfo: Flag.EnumInfo<ImGuiCond> = Flag.enumInfo()

    fun from(value: Int): ImGuiCond = when (value) {
      ImGuiCond_Always -> Always
      ImGuiCond_Once -> Once
      ImGuiCond_FirstUseEver -> FirstUseEver
      ImGuiCond_Appearing -> Appearing
      else -> throw NoSuchElementException("""Unknown enum constant $value""")
    }

    fun fromMultiple(value: Int): Flag<ImGuiCond> = Flag(value, cachedInfo)
  }
}
