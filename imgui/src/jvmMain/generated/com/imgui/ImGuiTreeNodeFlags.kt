package com.imgui

import cimgui.internal.ImGuiTreeNodeFlags_.ImGuiTreeNodeFlags_AllowItemOverlap
import cimgui.internal.ImGuiTreeNodeFlags_.ImGuiTreeNodeFlags_Bullet
import cimgui.internal.ImGuiTreeNodeFlags_.ImGuiTreeNodeFlags_CollapsingHeader
import cimgui.internal.ImGuiTreeNodeFlags_.ImGuiTreeNodeFlags_DefaultOpen
import cimgui.internal.ImGuiTreeNodeFlags_.ImGuiTreeNodeFlags_FramePadding
import cimgui.internal.ImGuiTreeNodeFlags_.ImGuiTreeNodeFlags_Framed
import cimgui.internal.ImGuiTreeNodeFlags_.ImGuiTreeNodeFlags_Leaf
import cimgui.internal.ImGuiTreeNodeFlags_.ImGuiTreeNodeFlags_NavLeftJumpsBackHere
import cimgui.internal.ImGuiTreeNodeFlags_.ImGuiTreeNodeFlags_NoAutoOpenOnLog
import cimgui.internal.ImGuiTreeNodeFlags_.ImGuiTreeNodeFlags_NoTreePushOnOpen
import cimgui.internal.ImGuiTreeNodeFlags_.ImGuiTreeNodeFlags_OpenOnArrow
import cimgui.internal.ImGuiTreeNodeFlags_.ImGuiTreeNodeFlags_OpenOnDoubleClick
import cimgui.internal.ImGuiTreeNodeFlags_.ImGuiTreeNodeFlags_Selected
import cimgui.internal.ImGuiTreeNodeFlags_.ImGuiTreeNodeFlags_SpanAvailWidth
import cimgui.internal.ImGuiTreeNodeFlags_.ImGuiTreeNodeFlags_SpanFullWidth
import kotlin.Int

actual enum class ImGuiTreeNodeFlags(
  override val value: Int
) : Flag<ImGuiTreeNodeFlags> {
  Selected(ImGuiTreeNodeFlags_Selected),

  Framed(ImGuiTreeNodeFlags_Framed),

  AllowItemOverlap(ImGuiTreeNodeFlags_AllowItemOverlap),

  NoTreePushOnOpen(ImGuiTreeNodeFlags_NoTreePushOnOpen),

  NoAutoOpenOnLog(ImGuiTreeNodeFlags_NoAutoOpenOnLog),

  DefaultOpen(ImGuiTreeNodeFlags_DefaultOpen),

  OpenOnDoubleClick(ImGuiTreeNodeFlags_OpenOnDoubleClick),

  OpenOnArrow(ImGuiTreeNodeFlags_OpenOnArrow),

  Leaf(ImGuiTreeNodeFlags_Leaf),

  Bullet(ImGuiTreeNodeFlags_Bullet),

  FramePadding(ImGuiTreeNodeFlags_FramePadding),

  SpanAvailWidth(ImGuiTreeNodeFlags_SpanAvailWidth),

  SpanFullWidth(ImGuiTreeNodeFlags_SpanFullWidth),

  NavLeftJumpsBackHere(ImGuiTreeNodeFlags_NavLeftJumpsBackHere);

  override val info: Flag.EnumInfo<ImGuiTreeNodeFlags>
    get() = cachedInfo
  actual companion object {
    private val cachedInfo: Flag.EnumInfo<ImGuiTreeNodeFlags> = Flag.enumInfo()

    actual val CollapsingHeader: Flag<ImGuiTreeNodeFlags> =
        Flag(ImGuiTreeNodeFlags_CollapsingHeader, cachedInfo)

    fun from(value: Int): ImGuiTreeNodeFlags = when (value) {
      ImGuiTreeNodeFlags_Selected -> Selected
      ImGuiTreeNodeFlags_Framed -> Framed
      ImGuiTreeNodeFlags_AllowItemOverlap -> AllowItemOverlap
      ImGuiTreeNodeFlags_NoTreePushOnOpen -> NoTreePushOnOpen
      ImGuiTreeNodeFlags_NoAutoOpenOnLog -> NoAutoOpenOnLog
      ImGuiTreeNodeFlags_DefaultOpen -> DefaultOpen
      ImGuiTreeNodeFlags_OpenOnDoubleClick -> OpenOnDoubleClick
      ImGuiTreeNodeFlags_OpenOnArrow -> OpenOnArrow
      ImGuiTreeNodeFlags_Leaf -> Leaf
      ImGuiTreeNodeFlags_Bullet -> Bullet
      ImGuiTreeNodeFlags_FramePadding -> FramePadding
      ImGuiTreeNodeFlags_SpanAvailWidth -> SpanAvailWidth
      ImGuiTreeNodeFlags_SpanFullWidth -> SpanFullWidth
      ImGuiTreeNodeFlags_NavLeftJumpsBackHere -> NavLeftJumpsBackHere
      else -> throw NoSuchElementException("""Unknown enum constant $value""")
    }

    fun fromMultiple(value: Int): Flag<ImGuiTreeNodeFlags> = Flag(value, cachedInfo)
  }
}
