package com.imgui

import cimgui.internal.ImGuiDockNode_destroy
import kotlin.Boolean
import kotlin.Int
import kotlin.Suppress
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.pointed

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImGuiDockNode(
  val ptr: CPointer<cimgui.internal.ImGuiDockNode>
) {
  actual val id: ImGuiID
    get() = ptr.pointed.ID.let(::ImGuiID)

  actual val sharedFlags: Flag<ImGuiDockNodeFlags>
    get() = ptr.pointed.SharedFlags.let { ImGuiDockNodeFlags.fromMultiple(it) }

  actual val localFlags: Flag<ImGuiDockNodeFlags>
    get() = ptr.pointed.LocalFlags.let { ImGuiDockNodeFlags.fromMultiple(it) }

  actual val parentNode: ImGuiDockNode?
    get() = ptr.pointed.ParentNode?.let(::ImGuiDockNode)

  actual val tabBar: ImGuiTabBar?
    get() = ptr.pointed.TabBar?.let(::ImGuiTabBar)

  actual val pos: Vec2
    get() = ptr.pointed.Pos.fromCValue()

  actual val size: Vec2
    get() = ptr.pointed.Size.fromCValue()

  actual val sizeRef: Vec2
    get() = ptr.pointed.SizeRef.fromCValue()

  actual val hostWindow: ImGuiWindow?
    get() = ptr.pointed.HostWindow?.let(::ImGuiWindow)

  actual val visibleWindow: ImGuiWindow?
    get() = ptr.pointed.VisibleWindow?.let(::ImGuiWindow)

  actual val centralNode: ImGuiDockNode?
    get() = ptr.pointed.CentralNode?.let(::ImGuiDockNode)

  actual val onlyNodeWithWindows: ImGuiDockNode?
    get() = ptr.pointed.OnlyNodeWithWindows?.let(::ImGuiDockNode)

  actual val lastFrameAlive: Int
    get() = ptr.pointed.LastFrameAlive

  actual val lastFrameActive: Int
    get() = ptr.pointed.LastFrameActive

  actual val lastFrameFocused: Int
    get() = ptr.pointed.LastFrameFocused

  actual val lastFocusedNodeId: ImGuiID
    get() = ptr.pointed.LastFocusedNodeId.let(::ImGuiID)

  actual val selectedTabId: ImGuiID
    get() = ptr.pointed.SelectedTabId.let(::ImGuiID)

  actual val wantCloseTabId: ImGuiID
    get() = ptr.pointed.WantCloseTabId.let(::ImGuiID)

  actual val authorityForPos: ImGuiDataAuthority
    get() = ptr.pointed.AuthorityForPos.let { ImGuiDataAuthority.from(it) }

  actual val authorityForSize: ImGuiDataAuthority
    get() = ptr.pointed.AuthorityForSize.let { ImGuiDataAuthority.from(it) }

  actual val authorityForViewport: ImGuiDataAuthority
    get() = ptr.pointed.AuthorityForViewport.let { ImGuiDataAuthority.from(it) }

  actual val isVisible: Boolean
    get() = ptr.pointed.IsVisible

  actual val isFocused: Boolean
    get() = ptr.pointed.IsFocused

  actual val hasCloseButton: Boolean
    get() = ptr.pointed.HasCloseButton

  actual val hasWindowMenuButton: Boolean
    get() = ptr.pointed.HasWindowMenuButton

  actual val enableCloseButton: Boolean
    get() = ptr.pointed.EnableCloseButton

  actual val wantCloseAll: Boolean
    get() = ptr.pointed.WantCloseAll

  actual val wantLockSizeOnce: Boolean
    get() = ptr.pointed.WantLockSizeOnce

  actual val wantMouseMove: Boolean
    get() = ptr.pointed.WantMouseMove

  actual val wantHiddenTabBarUpdate: Boolean
    get() = ptr.pointed.WantHiddenTabBarUpdate

  actual val wantHiddenTabBarToggle: Boolean
    get() = ptr.pointed.WantHiddenTabBarToggle

  actual val markedForPosSizeWrite: Boolean
    get() = ptr.pointed.MarkedForPosSizeWrite

  actual fun destroy() {
    ImGuiDockNode_destroy(ptr)
  }
}
