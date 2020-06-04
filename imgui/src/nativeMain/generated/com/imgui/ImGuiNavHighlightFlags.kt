package com.imgui

import cimgui.internal.ImGuiNavHighlightFlags_
import cimgui.internal.ImGuiNavHighlightFlags_AlwaysDraw
import cimgui.internal.ImGuiNavHighlightFlags_NoRounding
import cimgui.internal.ImGuiNavHighlightFlags_TypeDefault
import cimgui.internal.ImGuiNavHighlightFlags_TypeThin
import kotlinx.cinterop.convert

actual enum class ImGuiNavHighlightFlags(
  override val value: cimgui.internal.ImGuiNavHighlightFlags
) : Flag<ImGuiNavHighlightFlags> {
  TypeDefault(ImGuiNavHighlightFlags_TypeDefault.convert()),

  TypeThin(ImGuiNavHighlightFlags_TypeThin.convert()),

  AlwaysDraw(ImGuiNavHighlightFlags_AlwaysDraw.convert()),

  NoRounding(ImGuiNavHighlightFlags_NoRounding.convert());

  override val info: Flag.EnumInfo<ImGuiNavHighlightFlags>
    get() = cachedInfo
  actual companion object {
    private val cachedInfo: Flag.EnumInfo<ImGuiNavHighlightFlags> = Flag.enumInfo()

    fun from(value: cimgui.internal.ImGuiNavHighlightFlags): ImGuiNavHighlightFlags = when
        (value.convert<ImGuiNavHighlightFlags_>()) {
      ImGuiNavHighlightFlags_TypeDefault -> TypeDefault
      ImGuiNavHighlightFlags_TypeThin -> TypeThin
      ImGuiNavHighlightFlags_AlwaysDraw -> AlwaysDraw
      ImGuiNavHighlightFlags_NoRounding -> NoRounding
      else -> throw NoSuchElementException("""Unknown enum constant $value""")
    }

    fun fromMultiple(value: cimgui.internal.ImGuiNavHighlightFlags): Flag<ImGuiNavHighlightFlags> =
        Flag(value.convert(), cachedInfo)
  }
}
