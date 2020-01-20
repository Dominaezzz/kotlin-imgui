package com.imgui

import cimgui.internal.ImGuiTreeNodeFlags_
import cimgui.internal.ImGuiTreeNodeFlags_AllowItemOverlap
import cimgui.internal.ImGuiTreeNodeFlags_Bullet
import cimgui.internal.ImGuiTreeNodeFlags_CollapsingHeader
import cimgui.internal.ImGuiTreeNodeFlags_DefaultOpen
import cimgui.internal.ImGuiTreeNodeFlags_FramePadding
import cimgui.internal.ImGuiTreeNodeFlags_Framed
import cimgui.internal.ImGuiTreeNodeFlags_Leaf
import cimgui.internal.ImGuiTreeNodeFlags_NavLeftJumpsBackHere
import cimgui.internal.ImGuiTreeNodeFlags_NoAutoOpenOnLog
import cimgui.internal.ImGuiTreeNodeFlags_NoTreePushOnOpen
import cimgui.internal.ImGuiTreeNodeFlags_OpenOnArrow
import cimgui.internal.ImGuiTreeNodeFlags_OpenOnDoubleClick
import cimgui.internal.ImGuiTreeNodeFlags_Selected
import cimgui.internal.ImGuiTreeNodeFlags_SpanAvailWidth
import cimgui.internal.ImGuiTreeNodeFlags_SpanFullWidth
import kotlinx.cinterop.convert

actual enum class ImGuiTreeNodeFlags(
  override val value: cimgui.internal.ImGuiTreeNodeFlags
) : Flag<ImGuiTreeNodeFlags> {
  Selected(ImGuiTreeNodeFlags_Selected.convert()),

  Framed(ImGuiTreeNodeFlags_Framed.convert()),

  AllowItemOverlap(ImGuiTreeNodeFlags_AllowItemOverlap.convert()),

  NoTreePushOnOpen(ImGuiTreeNodeFlags_NoTreePushOnOpen.convert()),

  NoAutoOpenOnLog(ImGuiTreeNodeFlags_NoAutoOpenOnLog.convert()),

  DefaultOpen(ImGuiTreeNodeFlags_DefaultOpen.convert()),

  OpenOnDoubleClick(ImGuiTreeNodeFlags_OpenOnDoubleClick.convert()),

  OpenOnArrow(ImGuiTreeNodeFlags_OpenOnArrow.convert()),

  Leaf(ImGuiTreeNodeFlags_Leaf.convert()),

  Bullet(ImGuiTreeNodeFlags_Bullet.convert()),

  FramePadding(ImGuiTreeNodeFlags_FramePadding.convert()),

  SpanAvailWidth(ImGuiTreeNodeFlags_SpanAvailWidth.convert()),

  SpanFullWidth(ImGuiTreeNodeFlags_SpanFullWidth.convert()),

  NavLeftJumpsBackHere(ImGuiTreeNodeFlags_NavLeftJumpsBackHere.convert());

  override val info: Flag.EnumInfo<ImGuiTreeNodeFlags>
    get() = cachedInfo
  actual companion object {
    private val cachedInfo: Flag.EnumInfo<ImGuiTreeNodeFlags> = Flag.enumInfo()

    actual val CollapsingHeader: Flag<ImGuiTreeNodeFlags> =
        Flag(ImGuiTreeNodeFlags_CollapsingHeader.toInt(), cachedInfo)

    fun from(value: cimgui.internal.ImGuiTreeNodeFlags): ImGuiTreeNodeFlags = when
        (value.convert<ImGuiTreeNodeFlags_>()) {
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

    fun fromMultiple(value: cimgui.internal.ImGuiTreeNodeFlags): Flag<ImGuiTreeNodeFlags> =
        Flag(value.convert(), cachedInfo)
  }
}
