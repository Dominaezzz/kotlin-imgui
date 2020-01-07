package com.imgui

import cimgui.internal.ImGuiTreeNodeFlags_AllowItemOverlap
import cimgui.internal.ImGuiTreeNodeFlags_Bullet
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
import kotlin.Int

enum class ImGuiTreeNodeFlags(
  override val value: Int
) : Flag<ImGuiTreeNodeFlags> {
  Selected(ImGuiTreeNodeFlags_Selected.toInt()),

  Framed(ImGuiTreeNodeFlags_Framed.toInt()),

  AllowItemOverlap(ImGuiTreeNodeFlags_AllowItemOverlap.toInt()),

  NoTreePushOnOpen(ImGuiTreeNodeFlags_NoTreePushOnOpen.toInt()),

  NoAutoOpenOnLog(ImGuiTreeNodeFlags_NoAutoOpenOnLog.toInt()),

  DefaultOpen(ImGuiTreeNodeFlags_DefaultOpen.toInt()),

  OpenOnDoubleClick(ImGuiTreeNodeFlags_OpenOnDoubleClick.toInt()),

  OpenOnArrow(ImGuiTreeNodeFlags_OpenOnArrow.toInt()),

  Leaf(ImGuiTreeNodeFlags_Leaf.toInt()),

  Bullet(ImGuiTreeNodeFlags_Bullet.toInt()),

  FramePadding(ImGuiTreeNodeFlags_FramePadding.toInt()),

  SpanAvailWidth(ImGuiTreeNodeFlags_SpanAvailWidth.toInt()),

  SpanFullWidth(ImGuiTreeNodeFlags_SpanFullWidth.toInt()),

  NavLeftJumpsBackHere(ImGuiTreeNodeFlags_NavLeftJumpsBackHere.toInt());

  override val info: Flag.EnumInfo<ImGuiTreeNodeFlags>
    get() = cachedInfo
  companion object {
    private val cachedInfo: Flag.EnumInfo<ImGuiTreeNodeFlags> = Flag.enumInfo()
  }
}
