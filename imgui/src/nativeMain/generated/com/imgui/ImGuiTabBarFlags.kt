package com.imgui

import cimgui.internal.ImGuiTabBarFlags_
import cimgui.internal.ImGuiTabBarFlags_AutoSelectNewTabs
import cimgui.internal.ImGuiTabBarFlags_FittingPolicyDefault_
import cimgui.internal.ImGuiTabBarFlags_FittingPolicyMask_
import cimgui.internal.ImGuiTabBarFlags_FittingPolicyResizeDown
import cimgui.internal.ImGuiTabBarFlags_FittingPolicyScroll
import cimgui.internal.ImGuiTabBarFlags_NoCloseWithMiddleMouseButton
import cimgui.internal.ImGuiTabBarFlags_NoTabListScrollingButtons
import cimgui.internal.ImGuiTabBarFlags_NoTooltip
import cimgui.internal.ImGuiTabBarFlags_Reorderable
import cimgui.internal.ImGuiTabBarFlags_TabListPopupButton
import kotlinx.cinterop.convert

actual enum class ImGuiTabBarFlags(
  override val value: cimgui.internal.ImGuiTabBarFlags
) : Flag<ImGuiTabBarFlags> {
  Reorderable(ImGuiTabBarFlags_Reorderable.convert()),

  AutoSelectNewTabs(ImGuiTabBarFlags_AutoSelectNewTabs.convert()),

  TabListPopupButton(ImGuiTabBarFlags_TabListPopupButton.convert()),

  NoCloseWithMiddleMouseButton(ImGuiTabBarFlags_NoCloseWithMiddleMouseButton.convert()),

  NoTabListScrollingButtons(ImGuiTabBarFlags_NoTabListScrollingButtons.convert()),

  NoTooltip(ImGuiTabBarFlags_NoTooltip.convert()),

  FittingPolicyResizeDown(ImGuiTabBarFlags_FittingPolicyResizeDown.convert()),

  FittingPolicyScroll(ImGuiTabBarFlags_FittingPolicyScroll.convert());

  override val info: Flag.EnumInfo<ImGuiTabBarFlags>
    get() = cachedInfo
  actual companion object {
    private val cachedInfo: Flag.EnumInfo<ImGuiTabBarFlags> = Flag.enumInfo()

    actual val FittingPolicyMask_: Flag<ImGuiTabBarFlags> =
        Flag(ImGuiTabBarFlags_FittingPolicyMask_.toInt(), cachedInfo)

    actual val FittingPolicyDefault_: Flag<ImGuiTabBarFlags> =
        Flag(ImGuiTabBarFlags_FittingPolicyDefault_.toInt(), cachedInfo)

    fun from(value: cimgui.internal.ImGuiTabBarFlags): ImGuiTabBarFlags = when
        (value.convert<ImGuiTabBarFlags_>()) {
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

    fun fromMultiple(value: cimgui.internal.ImGuiTabBarFlags): Flag<ImGuiTabBarFlags> =
        Flag(value.convert(), cachedInfo)
  }
}
