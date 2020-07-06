package com.imgui

import cimgui.internal.CImGui
import cimgui.internal.CImGui.ImGuiContext_ImGuiContext
import cimgui.internal.CImGui.ImGuiContext_destroy
import cimgui.internal.CImGui.floatArray_getitem
import kotlin.Boolean
import kotlin.Double
import kotlin.Float
import kotlin.Int
import kotlin.Suppress
import kotlin.UInt

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImGuiContext(
  val ptr: cimgui.internal.ImGuiContext
) {
  actual val initialized: Boolean
    get() = ptr.initialized

  actual val fontAtlasOwnedByContext: Boolean
    get() = ptr.fontAtlasOwnedByContext

  actual val font: ImFont?
    get() = ptr.font?.let(::ImFont)

  actual val fontSize: Float
    get() = ptr.fontSize

  actual val fontBaseSize: Float
    get() = ptr.fontBaseSize

  actual val time: Double
    get() = ptr.time

  actual val frameCount: Int
    get() = ptr.frameCount

  actual val frameCountEnded: Int
    get() = ptr.frameCountEnded

  actual val frameCountRendered: Int
    get() = ptr.frameCountRendered

  actual val withinFrameScope: Boolean
    get() = ptr.withinFrameScope

  actual val withinFrameScopeWithImplicitWindow: Boolean
    get() = ptr.withinFrameScopeWithImplicitWindow

  actual val withinEndChild: Boolean
    get() = ptr.withinEndChild

  actual val testEngineHookItems: Boolean
    get() = ptr.testEngineHookItems

  actual val testEngineHookIdInfo: ImGuiID
    get() = ptr.testEngineHookIdInfo.let(::ImGuiID)

  actual val windowsActiveCount: Int
    get() = ptr.windowsActiveCount

  actual val currentWindow: ImGuiWindow?
    get() = ptr.currentWindow?.let(::ImGuiWindow)

  actual val hoveredWindow: ImGuiWindow?
    get() = ptr.hoveredWindow?.let(::ImGuiWindow)

  actual val hoveredRootWindow: ImGuiWindow?
    get() = ptr.hoveredRootWindow?.let(::ImGuiWindow)

  actual val movingWindow: ImGuiWindow?
    get() = ptr.movingWindow?.let(::ImGuiWindow)

  actual val wheelingWindow: ImGuiWindow?
    get() = ptr.wheelingWindow?.let(::ImGuiWindow)

  actual val wheelingWindowRefMousePos: Vec2
    get() = ptr.wheelingWindowRefMousePos.fromCValue()

  actual val wheelingWindowTimer: Float
    get() = ptr.wheelingWindowTimer

  actual val hoveredId: ImGuiID
    get() = ptr.hoveredId.let(::ImGuiID)

  actual val hoveredIdAllowOverlap: Boolean
    get() = ptr.hoveredIdAllowOverlap

  actual val hoveredIdPreviousFrame: ImGuiID
    get() = ptr.hoveredIdPreviousFrame.let(::ImGuiID)

  actual val hoveredIdTimer: Float
    get() = ptr.hoveredIdTimer

  actual val hoveredIdNotActiveTimer: Float
    get() = ptr.hoveredIdNotActiveTimer

  actual val activeId: ImGuiID
    get() = ptr.activeId.let(::ImGuiID)

  actual val activeIdIsAlive: ImGuiID
    get() = ptr.activeIdIsAlive.let(::ImGuiID)

  actual val activeIdTimer: Float
    get() = ptr.activeIdTimer

  actual val activeIdIsJustActivated: Boolean
    get() = ptr.activeIdIsJustActivated

  actual val activeIdAllowOverlap: Boolean
    get() = ptr.activeIdAllowOverlap

  actual val activeIdHasBeenPressedBefore: Boolean
    get() = ptr.activeIdHasBeenPressedBefore

  actual val activeIdHasBeenEditedBefore: Boolean
    get() = ptr.activeIdHasBeenEditedBefore

  actual val activeIdHasBeenEditedThisFrame: Boolean
    get() = ptr.activeIdHasBeenEditedThisFrame

  actual val activeIdUsingNavDirMask: UInt
    get() = ptr.activeIdUsingNavDirMask.toUInt()

  actual val activeIdUsingNavInputMask: UInt
    get() = ptr.activeIdUsingNavInputMask.toUInt()

  actual val activeIdClickOffset: Vec2
    get() = ptr.activeIdClickOffset.fromCValue()

  actual val activeIdWindow: ImGuiWindow?
    get() = ptr.activeIdWindow?.let(::ImGuiWindow)

  actual val activeIdMouseButton: Int
    get() = ptr.activeIdMouseButton

  actual val activeIdPreviousFrame: ImGuiID
    get() = ptr.activeIdPreviousFrame.let(::ImGuiID)

  actual val activeIdPreviousFrameIsAlive: Boolean
    get() = ptr.activeIdPreviousFrameIsAlive

  actual val activeIdPreviousFrameHasBeenEditedBefore: Boolean
    get() = ptr.activeIdPreviousFrameHasBeenEditedBefore

  actual val activeIdPreviousFrameWindow: ImGuiWindow?
    get() = ptr.activeIdPreviousFrameWindow?.let(::ImGuiWindow)

  actual val lastActiveId: ImGuiID
    get() = ptr.lastActiveId.let(::ImGuiID)

  actual val lastActiveIdTimer: Float
    get() = ptr.lastActiveIdTimer

  actual val navWindow: ImGuiWindow?
    get() = ptr.navWindow?.let(::ImGuiWindow)

  actual val navId: ImGuiID
    get() = ptr.navId.let(::ImGuiID)

  actual val navFocusScopeId: ImGuiID
    get() = ptr.navFocusScopeId.let(::ImGuiID)

  actual val navActivateId: ImGuiID
    get() = ptr.navActivateId.let(::ImGuiID)

  actual val navActivateDownId: ImGuiID
    get() = ptr.navActivateDownId.let(::ImGuiID)

  actual val navActivatePressedId: ImGuiID
    get() = ptr.navActivatePressedId.let(::ImGuiID)

  actual val navInputId: ImGuiID
    get() = ptr.navInputId.let(::ImGuiID)

  actual val navJustTabbedId: ImGuiID
    get() = ptr.navJustTabbedId.let(::ImGuiID)

  actual val navJustMovedToId: ImGuiID
    get() = ptr.navJustMovedToId.let(::ImGuiID)

  actual val navJustMovedToFocusScopeId: ImGuiID
    get() = ptr.navJustMovedToFocusScopeId.let(::ImGuiID)

  actual val navJustMovedToKeyMods: Flag<ImGuiKeyModFlags>
    get() = ptr.navJustMovedToKeyMods.let { ImGuiKeyModFlags.fromMultiple(it) }

  actual val navNextActivateId: ImGuiID
    get() = ptr.navNextActivateId.let(::ImGuiID)

  actual val navScoringCount: Int
    get() = ptr.navScoringCount

  actual val navIdTabCounter: Int
    get() = ptr.navIdTabCounter

  actual val navIdIsAlive: Boolean
    get() = ptr.navIdIsAlive

  actual val navMousePosDirty: Boolean
    get() = ptr.navMousePosDirty

  actual val navDisableHighlight: Boolean
    get() = ptr.navDisableHighlight

  actual val navDisableMouseHover: Boolean
    get() = ptr.navDisableMouseHover

  actual val navAnyRequest: Boolean
    get() = ptr.navAnyRequest

  actual val navInitRequest: Boolean
    get() = ptr.navInitRequest

  actual val navInitRequestFromMove: Boolean
    get() = ptr.navInitRequestFromMove

  actual val navInitResultId: ImGuiID
    get() = ptr.navInitResultId.let(::ImGuiID)

  actual val navMoveFromClampedRefRect: Boolean
    get() = ptr.navMoveFromClampedRefRect

  actual val navMoveRequest: Boolean
    get() = ptr.navMoveRequest

  actual val navMoveRequestFlags: Flag<ImGuiNavMoveFlags>
    get() = ptr.navMoveRequestFlags.let { ImGuiNavMoveFlags.fromMultiple(it) }

  actual val navMoveRequestKeyMods: Flag<ImGuiKeyModFlags>
    get() = ptr.navMoveRequestKeyMods.let { ImGuiKeyModFlags.fromMultiple(it) }

  actual val navMoveDir: ImGuiDir
    get() = ptr.navMoveDir.let { ImGuiDir.from(it) }

  actual val navMoveDirLast: ImGuiDir
    get() = ptr.navMoveDirLast.let { ImGuiDir.from(it) }

  actual val navMoveClipDir: ImGuiDir
    get() = ptr.navMoveClipDir.let { ImGuiDir.from(it) }

  actual val navWrapRequestWindow: ImGuiWindow?
    get() = ptr.navWrapRequestWindow?.let(::ImGuiWindow)

  actual val navWrapRequestFlags: Flag<ImGuiNavMoveFlags>
    get() = ptr.navWrapRequestFlags.let { ImGuiNavMoveFlags.fromMultiple(it) }

  actual val navWindowingTarget: ImGuiWindow?
    get() = ptr.navWindowingTarget?.let(::ImGuiWindow)

  actual val navWindowingTargetAnim: ImGuiWindow?
    get() = ptr.navWindowingTargetAnim?.let(::ImGuiWindow)

  actual val navWindowingListWindow: ImGuiWindow?
    get() = ptr.navWindowingListWindow?.let(::ImGuiWindow)

  actual val navWindowingTimer: Float
    get() = ptr.navWindowingTimer

  actual val navWindowingHighlightAlpha: Float
    get() = ptr.navWindowingHighlightAlpha

  actual val navWindowingToggleLayer: Boolean
    get() = ptr.navWindowingToggleLayer

  actual val focusRequestCurrWindow: ImGuiWindow?
    get() = ptr.focusRequestCurrWindow?.let(::ImGuiWindow)

  actual val focusRequestNextWindow: ImGuiWindow?
    get() = ptr.focusRequestNextWindow?.let(::ImGuiWindow)

  actual val focusRequestCurrCounterRegular: Int
    get() = ptr.focusRequestCurrCounterRegular

  actual val focusRequestCurrCounterTabStop: Int
    get() = ptr.focusRequestCurrCounterTabStop

  actual val focusRequestNextCounterRegular: Int
    get() = ptr.focusRequestNextCounterRegular

  actual val focusRequestNextCounterTabStop: Int
    get() = ptr.focusRequestNextCounterTabStop

  actual val focusTabPressed: Boolean
    get() = ptr.focusTabPressed

  actual val dimBgRatio: Float
    get() = ptr.dimBgRatio

  actual val mouseCursor: ImGuiMouseCursor
    get() = ptr.mouseCursor.let { ImGuiMouseCursor.from(it) }

  actual val dragDropActive: Boolean
    get() = ptr.dragDropActive

  actual val dragDropWithinSource: Boolean
    get() = ptr.dragDropWithinSource

  actual val dragDropWithinTarget: Boolean
    get() = ptr.dragDropWithinTarget

  actual val dragDropSourceFlags: Flag<ImGuiDragDropFlags>
    get() = ptr.dragDropSourceFlags.let { ImGuiDragDropFlags.fromMultiple(it) }

  actual val dragDropSourceFrameCount: Int
    get() = ptr.dragDropSourceFrameCount

  actual val dragDropMouseButton: Int
    get() = ptr.dragDropMouseButton

  actual val dragDropTargetId: ImGuiID
    get() = ptr.dragDropTargetId.let(::ImGuiID)

  actual val dragDropAcceptFlags: Flag<ImGuiDragDropFlags>
    get() = ptr.dragDropAcceptFlags.let { ImGuiDragDropFlags.fromMultiple(it) }

  actual val dragDropAcceptIdCurrRectSurface: Float
    get() = ptr.dragDropAcceptIdCurrRectSurface

  actual val dragDropAcceptIdCurr: ImGuiID
    get() = ptr.dragDropAcceptIdCurr.let(::ImGuiID)

  actual val dragDropAcceptIdPrev: ImGuiID
    get() = ptr.dragDropAcceptIdPrev.let(::ImGuiID)

  actual val dragDropAcceptFrameCount: Int
    get() = ptr.dragDropAcceptFrameCount

  actual val dragDropHoldJustPressedId: ImGuiID
    get() = ptr.dragDropHoldJustPressedId.let(::ImGuiID)

  actual val currentTabBar: ImGuiTabBar?
    get() = ptr.currentTabBar?.let(::ImGuiTabBar)

  actual val lastValidMousePos: Vec2
    get() = ptr.lastValidMousePos.fromCValue()

  actual val tempInputId: ImGuiID
    get() = ptr.tempInputId.let(::ImGuiID)

  actual val colorEditOptions: Flag<ImGuiColorEditFlags>
    get() = ptr.colorEditOptions.let { ImGuiColorEditFlags.fromMultiple(it) }

  actual val colorEditLastHue: Float
    get() = ptr.colorEditLastHue

  actual val colorEditLastSat: Float
    get() = ptr.colorEditLastSat

  actual val colorPickerRef: Vec4
    get() = ptr.colorPickerRef.fromCValue()

  actual val dragCurrentAccumDirty: Boolean
    get() = ptr.dragCurrentAccumDirty

  actual val dragCurrentAccum: Float
    get() = ptr.dragCurrentAccum

  actual val dragSpeedDefaultRatio: Float
    get() = ptr.dragSpeedDefaultRatio

  actual val scrollbarClickDeltaToGrabCenter: Float
    get() = ptr.scrollbarClickDeltaToGrabCenter

  actual val tooltipOverrideCount: Int
    get() = ptr.tooltipOverrideCount

  actual val platformImePos: Vec2
    get() = ptr.platformImePos.fromCValue()

  actual val platformImeLastPos: Vec2
    get() = ptr.platformImeLastPos.fromCValue()

  actual val settingsLoaded: Boolean
    get() = ptr.settingsLoaded

  actual val settingsDirtyTimer: Float
    get() = ptr.settingsDirtyTimer

  actual val logEnabled: Boolean
    get() = ptr.logEnabled

  actual val logLinePosY: Float
    get() = ptr.logLinePosY

  actual val logLineFirstItem: Boolean
    get() = ptr.logLineFirstItem

  actual val logDepthRef: Int
    get() = ptr.logDepthRef

  actual val logDepthToExpand: Int
    get() = ptr.logDepthToExpand

  actual val logDepthToExpandDefault: Int
    get() = ptr.logDepthToExpandDefault

  actual val debugItemPickerActive: Boolean
    get() = ptr.debugItemPickerActive

  actual val debugItemPickerBreakId: ImGuiID
    get() = ptr.debugItemPickerBreakId.let(::ImGuiID)

  actual val framerateSecPerFrameIdx: Int
    get() = ptr.framerateSecPerFrameIdx

  actual val framerateSecPerFrameAccum: Float
    get() = ptr.framerateSecPerFrameAccum

  actual val wantCaptureMouseNextFrame: Int
    get() = ptr.wantCaptureMouseNextFrame

  actual val wantCaptureKeyboardNextFrame: Int
    get() = ptr.wantCaptureKeyboardNextFrame

  actual val wantTextInputNextFrame: Int
    get() = ptr.wantTextInputNextFrame

  actual constructor(sharedFontAtlas: ImFontAtlas) :
      this(ImGuiContext_ImGuiContext(sharedFontAtlas.ptr)!!)

  actual fun colorEditLastColor(index: Int): Float {
    require(index in 0..3)
    return floatArray_getitem(ptr.colorEditLastColor, index)
  }

  actual fun framerateSecPerFrame(index: Int): Float {
    require(index in 0..120)
    return floatArray_getitem(ptr.framerateSecPerFrame, index)
  }

  actual fun destroy() {
    ImGuiContext_destroy(ptr)
  }
}
