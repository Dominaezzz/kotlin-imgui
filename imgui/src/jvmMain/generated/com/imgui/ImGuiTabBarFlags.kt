package com.imgui

import cimgui.internal.ImGuiTabBarFlags_.ImGuiTabBarFlags_AutoSelectNewTabs
import cimgui.internal.ImGuiTabBarFlags_.ImGuiTabBarFlags_FittingPolicyDefault_
import cimgui.internal.ImGuiTabBarFlags_.ImGuiTabBarFlags_FittingPolicyMask_
import cimgui.internal.ImGuiTabBarFlags_.ImGuiTabBarFlags_FittingPolicyResizeDown
import cimgui.internal.ImGuiTabBarFlags_.ImGuiTabBarFlags_FittingPolicyScroll
import cimgui.internal.ImGuiTabBarFlags_.ImGuiTabBarFlags_NoCloseWithMiddleMouseButton
import cimgui.internal.ImGuiTabBarFlags_.ImGuiTabBarFlags_NoTabListScrollingButtons
import cimgui.internal.ImGuiTabBarFlags_.ImGuiTabBarFlags_NoTooltip
import cimgui.internal.ImGuiTabBarFlags_.ImGuiTabBarFlags_Reorderable
import cimgui.internal.ImGuiTabBarFlags_.ImGuiTabBarFlags_TabListPopupButton
import kotlin.Int

actual enum class ImGuiTabBarFlags(
  override val value: Int
) : Flag<ImGuiTabBarFlags> {
  Reorderable(ImGuiTabBarFlags_Reorderable),

  AutoSelectNewTabs(ImGuiTabBarFlags_AutoSelectNewTabs),

  TabListPopupButton(ImGuiTabBarFlags_TabListPopupButton),

  NoCloseWithMiddleMouseButton(ImGuiTabBarFlags_NoCloseWithMiddleMouseButton),

  NoTabListScrollingButtons(ImGuiTabBarFlags_NoTabListScrollingButtons),

  NoTooltip(ImGuiTabBarFlags_NoTooltip),

  FittingPolicyResizeDown(ImGuiTabBarFlags_FittingPolicyResizeDown),

  FittingPolicyScroll(ImGuiTabBarFlags_FittingPolicyScroll);

  override val info: Flag.EnumInfo<ImGuiTabBarFlags>
    get() = cachedInfo
  actual companion object {
    private val cachedInfo: Flag.EnumInfo<ImGuiTabBarFlags> = Flag.enumInfo()

    actual val FittingPolicyMask_: Flag<ImGuiTabBarFlags> =
        Flag(ImGuiTabBarFlags_FittingPolicyMask_, cachedInfo)

    actual val FittingPolicyDefault_: Flag<ImGuiTabBarFlags> =
        Flag(ImGuiTabBarFlags_FittingPolicyDefault_, cachedInfo)

    fun from(value: Int): ImGuiTabBarFlags = when (value) {
      ImGuiTabBarFlags_Reorderable -> Reorderable
      ImGuiTabBarFlags_AutoSelectNewTabs -> AutoSelectNewTabs
      ImGuiTabBarFlags_TabListPopupButton -> TabListPopupButton
      ImGuiTabBarFlags_NoCloseWithMiddleMouseButton -> NoCloseWithMiddleMouseButton
      ImGuiTabBarFlags_NoTabListScrollingButtons -> NoTabListScrollingButtons
      ImGuiTabBarFlags_NoTooltip -> NoTooltip
      ImGuiTabBarFlags_FittingPolicyResizeDown -> FittingPolicyResizeDown
      ImGuiTabBarFlags_FittingPolicyScroll -> FittingPolicyScroll
      else -> throw NoSuchElementException("""Unknown enum constant $value""")
    }

    fun fromMultiple(value: Int): Flag<ImGuiTabBarFlags> = Flag(value, cachedInfo)
  }
}
