package com.imgui

import cimgui.internal.CImGui.ImGuiDockNode_GetMergedFlags
import cimgui.internal.CImGui.ImGuiDockNode_ImGuiDockNode
import cimgui.internal.CImGui.ImGuiDockNode_IsCentralNode
import cimgui.internal.CImGui.ImGuiDockNode_IsDockSpace
import cimgui.internal.CImGui.ImGuiDockNode_IsEmpty
import cimgui.internal.CImGui.ImGuiDockNode_IsFloatingNode
import cimgui.internal.CImGui.ImGuiDockNode_IsHiddenTabBar
import cimgui.internal.CImGui.ImGuiDockNode_IsLeafNode
import cimgui.internal.CImGui.ImGuiDockNode_IsNoTabBar
import cimgui.internal.CImGui.ImGuiDockNode_IsRootNode
import cimgui.internal.CImGui.ImGuiDockNode_IsSplitNode
import cimgui.internal.CImGui.ImGuiDockNode_destroy
import kotlin.Boolean
import kotlin.Int
import kotlin.Suppress

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImGuiDockNode(
  val ptr: cimgui.internal.ImGuiDockNode
) {
  actual val id: ImGuiID
    get() = ptr.id.let(::ImGuiID)

  actual val sharedFlags: Flag<ImGuiDockNodeFlags>
    get() = ptr.sharedFlags.let { ImGuiDockNodeFlags.fromMultiple(it) }

  actual val localFlags: Flag<ImGuiDockNodeFlags>
    get() = ptr.localFlags.let { ImGuiDockNodeFlags.fromMultiple(it) }

  actual val parentNode: ImGuiDockNode?
    get() = ptr.parentNode?.let(::ImGuiDockNode)

  actual val tabBar: ImGuiTabBar?
    get() = ptr.tabBar?.let(::ImGuiTabBar)

  actual val pos: Vec2
    get() = ptr.pos.fromCValue()

  actual val size: Vec2
    get() = ptr.size.fromCValue()

  actual val sizeRef: Vec2
    get() = ptr.sizeRef.fromCValue()

  actual val hostWindow: ImGuiWindow?
    get() = ptr.hostWindow?.let(::ImGuiWindow)

  actual val visibleWindow: ImGuiWindow?
    get() = ptr.visibleWindow?.let(::ImGuiWindow)

  actual val centralNode: ImGuiDockNode?
    get() = ptr.centralNode?.let(::ImGuiDockNode)

  actual val onlyNodeWithWindows: ImGuiDockNode?
    get() = ptr.onlyNodeWithWindows?.let(::ImGuiDockNode)

  actual val lastFrameAlive: Int
    get() = ptr.lastFrameAlive

  actual val lastFrameActive: Int
    get() = ptr.lastFrameActive

  actual val lastFrameFocused: Int
    get() = ptr.lastFrameFocused

  actual val lastFocusedNodeId: ImGuiID
    get() = ptr.lastFocusedNodeId.let(::ImGuiID)

  actual val selectedTabId: ImGuiID
    get() = ptr.selectedTabId.let(::ImGuiID)

  actual val wantCloseTabId: ImGuiID
    get() = ptr.wantCloseTabId.let(::ImGuiID)

  actual val authorityForPos: ImGuiDataAuthority
    get() = ptr.authorityForPos.let { ImGuiDataAuthority.from(it) }

  actual val authorityForSize: ImGuiDataAuthority
    get() = ptr.authorityForSize.let { ImGuiDataAuthority.from(it) }

  actual val authorityForViewport: ImGuiDataAuthority
    get() = ptr.authorityForViewport.let { ImGuiDataAuthority.from(it) }

  actual val isVisible: Boolean
    get() = ptr.isVisible

  actual val isFocused: Boolean
    get() = ptr.isFocused

  actual val hasCloseButton: Boolean
    get() = ptr.hasCloseButton

  actual val hasWindowMenuButton: Boolean
    get() = ptr.hasWindowMenuButton

  actual val enableCloseButton: Boolean
    get() = ptr.enableCloseButton

  actual val wantCloseAll: Boolean
    get() = ptr.wantCloseAll

  actual val wantLockSizeOnce: Boolean
    get() = ptr.wantLockSizeOnce

  actual val wantMouseMove: Boolean
    get() = ptr.wantMouseMove

  actual val wantHiddenTabBarUpdate: Boolean
    get() = ptr.wantHiddenTabBarUpdate

  actual val wantHiddenTabBarToggle: Boolean
    get() = ptr.wantHiddenTabBarToggle

  actual val markedForPosSizeWrite: Boolean
    get() = ptr.markedForPosSizeWrite

  actual constructor(id: ImGuiID) : this(ImGuiDockNode_ImGuiDockNode(id.value)!!)

  actual fun getMergedFlags(): Flag<ImGuiDockNodeFlags> = ImGuiDockNode_GetMergedFlags(ptr).let {
      ImGuiDockNodeFlags.fromMultiple(it) }

  actual fun isCentralNode(): Boolean = ImGuiDockNode_IsCentralNode(ptr)

  actual fun isDockSpace(): Boolean = ImGuiDockNode_IsDockSpace(ptr)

  actual fun isEmpty(): Boolean = ImGuiDockNode_IsEmpty(ptr)

  actual fun isFloatingNode(): Boolean = ImGuiDockNode_IsFloatingNode(ptr)

  actual fun isHiddenTabBar(): Boolean = ImGuiDockNode_IsHiddenTabBar(ptr)

  actual fun isLeafNode(): Boolean = ImGuiDockNode_IsLeafNode(ptr)

  actual fun isNoTabBar(): Boolean = ImGuiDockNode_IsNoTabBar(ptr)

  actual fun isRootNode(): Boolean = ImGuiDockNode_IsRootNode(ptr)

  actual fun isSplitNode(): Boolean = ImGuiDockNode_IsSplitNode(ptr)

  actual fun destroy() {
    ImGuiDockNode_destroy(ptr)
  }
}
