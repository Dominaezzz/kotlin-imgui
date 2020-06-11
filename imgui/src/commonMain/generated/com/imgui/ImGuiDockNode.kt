package com.imgui

import kotlin.Boolean
import kotlin.Int

expect class ImGuiDockNode {
  val id: ImGuiID

  val sharedFlags: Flag<ImGuiDockNodeFlags>

  val localFlags: Flag<ImGuiDockNodeFlags>

  val parentNode: ImGuiDockNode?

  val tabBar: ImGuiTabBar?

  val pos: Vec2

  val size: Vec2

  val sizeRef: Vec2

  val hostWindow: ImGuiWindow?

  val visibleWindow: ImGuiWindow?

  val centralNode: ImGuiDockNode?

  val onlyNodeWithWindows: ImGuiDockNode?

  val lastFrameAlive: Int

  val lastFrameActive: Int

  val lastFrameFocused: Int

  val lastFocusedNodeId: ImGuiID

  val selectedTabId: ImGuiID

  val wantCloseTabId: ImGuiID

  val authorityForPos: ImGuiDataAuthority

  val authorityForSize: ImGuiDataAuthority

  val authorityForViewport: ImGuiDataAuthority

  val isVisible: Boolean

  val isFocused: Boolean

  val hasCloseButton: Boolean

  val hasWindowMenuButton: Boolean

  val enableCloseButton: Boolean

  val wantCloseAll: Boolean

  val wantLockSizeOnce: Boolean

  val wantMouseMove: Boolean

  val wantHiddenTabBarUpdate: Boolean

  val wantHiddenTabBarToggle: Boolean

  val markedForPosSizeWrite: Boolean

  fun destroy()
}
