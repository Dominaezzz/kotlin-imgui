package com.imgui

import cimgui.internal.ImGuiNavMoveFlags_
import cimgui.internal.ImGuiNavMoveFlags_AllowCurrentNavId
import cimgui.internal.ImGuiNavMoveFlags_AlsoScoreVisibleSet
import cimgui.internal.ImGuiNavMoveFlags_LoopX
import cimgui.internal.ImGuiNavMoveFlags_LoopY
import cimgui.internal.ImGuiNavMoveFlags_ScrollToEdge
import cimgui.internal.ImGuiNavMoveFlags_WrapX
import cimgui.internal.ImGuiNavMoveFlags_WrapY
import kotlin.Int
import kotlinx.cinterop.convert

actual enum class ImGuiNavMoveFlags(
  override val value: cimgui.internal.ImGuiNavMoveFlags
) : Flag<ImGuiNavMoveFlags> {
  LoopX(ImGuiNavMoveFlags_LoopX.convert()),

  LoopY(ImGuiNavMoveFlags_LoopY.convert()),

  WrapX(ImGuiNavMoveFlags_WrapX.convert()),

  WrapY(ImGuiNavMoveFlags_WrapY.convert()),

  AllowCurrentNavId(ImGuiNavMoveFlags_AllowCurrentNavId.convert()),

  AlsoScoreVisibleSet(ImGuiNavMoveFlags_AlsoScoreVisibleSet.convert()),

  ScrollToEdge(ImGuiNavMoveFlags_ScrollToEdge.convert());

  actual val cValue: Int
    get() = value.convert()

  override val info: Flag.EnumInfo<ImGuiNavMoveFlags>
    get() = cachedInfo
  actual companion object {
    private val cachedInfo: Flag.EnumInfo<ImGuiNavMoveFlags> = Flag.enumInfo()

    fun from(value: cimgui.internal.ImGuiNavMoveFlags): ImGuiNavMoveFlags = when
        (value.convert<ImGuiNavMoveFlags_>()) {
      ImGuiNavMoveFlags_LoopX -> LoopX
      ImGuiNavMoveFlags_LoopY -> LoopY
      ImGuiNavMoveFlags_WrapX -> WrapX
      ImGuiNavMoveFlags_WrapY -> WrapY
      ImGuiNavMoveFlags_AllowCurrentNavId -> AllowCurrentNavId
      ImGuiNavMoveFlags_AlsoScoreVisibleSet -> AlsoScoreVisibleSet
      ImGuiNavMoveFlags_ScrollToEdge -> ScrollToEdge
      else -> throw NoSuchElementException("""Unknown enum constant $value""")
    }

    fun fromMultiple(value: cimgui.internal.ImGuiNavMoveFlags): Flag<ImGuiNavMoveFlags> =
        Flag(value.convert(), cachedInfo)
  }
}
