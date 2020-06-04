package com.imgui

import cimgui.internal.ImGuiNavMoveFlags_.ImGuiNavMoveFlags_AllowCurrentNavId
import cimgui.internal.ImGuiNavMoveFlags_.ImGuiNavMoveFlags_AlsoScoreVisibleSet
import cimgui.internal.ImGuiNavMoveFlags_.ImGuiNavMoveFlags_LoopX
import cimgui.internal.ImGuiNavMoveFlags_.ImGuiNavMoveFlags_LoopY
import cimgui.internal.ImGuiNavMoveFlags_.ImGuiNavMoveFlags_ScrollToEdge
import cimgui.internal.ImGuiNavMoveFlags_.ImGuiNavMoveFlags_WrapX
import cimgui.internal.ImGuiNavMoveFlags_.ImGuiNavMoveFlags_WrapY
import kotlin.Int

actual enum class ImGuiNavMoveFlags(
  override val value: Int
) : Flag<ImGuiNavMoveFlags> {
  LoopX(ImGuiNavMoveFlags_LoopX),

  LoopY(ImGuiNavMoveFlags_LoopY),

  WrapX(ImGuiNavMoveFlags_WrapX),

  WrapY(ImGuiNavMoveFlags_WrapY),

  AllowCurrentNavId(ImGuiNavMoveFlags_AllowCurrentNavId),

  AlsoScoreVisibleSet(ImGuiNavMoveFlags_AlsoScoreVisibleSet),

  ScrollToEdge(ImGuiNavMoveFlags_ScrollToEdge);

  override val info: Flag.EnumInfo<ImGuiNavMoveFlags>
    get() = cachedInfo
  actual companion object {
    private val cachedInfo: Flag.EnumInfo<ImGuiNavMoveFlags> = Flag.enumInfo()

    fun from(value: Int): ImGuiNavMoveFlags = when (value) {
      ImGuiNavMoveFlags_LoopX -> LoopX
      ImGuiNavMoveFlags_LoopY -> LoopY
      ImGuiNavMoveFlags_WrapX -> WrapX
      ImGuiNavMoveFlags_WrapY -> WrapY
      ImGuiNavMoveFlags_AllowCurrentNavId -> AllowCurrentNavId
      ImGuiNavMoveFlags_AlsoScoreVisibleSet -> AlsoScoreVisibleSet
      ImGuiNavMoveFlags_ScrollToEdge -> ScrollToEdge
      else -> throw NoSuchElementException("""Unknown enum constant $value""")
    }

    fun fromMultiple(value: Int): Flag<ImGuiNavMoveFlags> = Flag(value, cachedInfo)
  }
}
