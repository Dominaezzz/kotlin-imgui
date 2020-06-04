package com.imgui

import cimgui.internal.ImGuiNavHighlightFlags_.ImGuiNavHighlightFlags_AlwaysDraw
import cimgui.internal.ImGuiNavHighlightFlags_.ImGuiNavHighlightFlags_NoRounding
import cimgui.internal.ImGuiNavHighlightFlags_.ImGuiNavHighlightFlags_TypeDefault
import cimgui.internal.ImGuiNavHighlightFlags_.ImGuiNavHighlightFlags_TypeThin
import kotlin.Int

actual enum class ImGuiNavHighlightFlags(
  override val value: Int
) : Flag<ImGuiNavHighlightFlags> {
  TypeDefault(ImGuiNavHighlightFlags_TypeDefault),

  TypeThin(ImGuiNavHighlightFlags_TypeThin),

  AlwaysDraw(ImGuiNavHighlightFlags_AlwaysDraw),

  NoRounding(ImGuiNavHighlightFlags_NoRounding);

  override val info: Flag.EnumInfo<ImGuiNavHighlightFlags>
    get() = cachedInfo
  actual companion object {
    private val cachedInfo: Flag.EnumInfo<ImGuiNavHighlightFlags> = Flag.enumInfo()

    fun from(value: Int): ImGuiNavHighlightFlags = when (value) {
      ImGuiNavHighlightFlags_TypeDefault -> TypeDefault
      ImGuiNavHighlightFlags_TypeThin -> TypeThin
      ImGuiNavHighlightFlags_AlwaysDraw -> AlwaysDraw
      ImGuiNavHighlightFlags_NoRounding -> NoRounding
      else -> throw NoSuchElementException("""Unknown enum constant $value""")
    }

    fun fromMultiple(value: Int): Flag<ImGuiNavHighlightFlags> = Flag(value, cachedInfo)
  }
}
