package com.imgui

import cimgui.internal.ImGuiContext_ImGuiContext
import cimgui.internal.ImGuiContext_destroy
import kotlin.Boolean
import kotlin.Double
import kotlin.Float
import kotlin.Int
import kotlin.Suppress
import kotlin.UInt
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.pointed

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImGuiContext(
  val ptr: CPointer<cimgui.internal.ImGuiContext>
) {
  actual val initialized: Boolean
    get() = ptr.pointed.Initialized

  actual val fontAtlasOwnedByContext: Boolean
    get() = ptr.pointed.FontAtlasOwnedByContext

  actual val configFlagsCurrFrame: Flag<ImGuiConfigFlags>
    get() = ptr.pointed.ConfigFlagsCurrFrame.let { ImGuiConfigFlags.fromMultiple(it) }

  actual val configFlagsLastFrame: Flag<ImGuiConfigFlags>
    get() = ptr.pointed.ConfigFlagsLastFrame.let { ImGuiConfigFlags.fromMultiple(it) }

  actual val font: ImFont?
    get() = ptr.pointed.Font?.let(::ImFont)

  actual val fontSize: Float
    get() = ptr.pointed.FontSize

  actual val fontBaseSize: Float
    get() = ptr.pointed.FontBaseSize

  actual val time: Double
    get() = ptr.pointed.Time

  actual val frameCount: Int
    get() = ptr.pointed.FrameCount

  actual val frameCountEnded: Int
    get() = ptr.pointed.FrameCountEnded

  actual val frameCountPlatformEnded: Int
    get() = ptr.pointed.FrameCountPlatformEnded

  actual val frameCountRendered: Int
    get() = ptr.pointed.FrameCountRendered

  actual val withinFrameScope: Boolean
    get() = ptr.pointed.WithinFrameScope

  actual val withinFrameScopeWithImplicitWindow: Boolean
    get() = ptr.pointed.WithinFrameScopeWithImplicitWindow

  actual val withinEndChild: Boolean
    get() = ptr.pointed.WithinEndChild

  actual val testEngineHookItems: Boolean
    get() = ptr.pointed.TestEngineHookItems

  actual val testEngineHookIdInfo: ImGuiID
    get() = ptr.pointed.TestEngineHookIdInfo.let(::ImGuiID)

  actual val windowsActiveCount: Int
    get() = ptr.pointed.WindowsActiveCount

  actual val currentWindow: ImGuiWindow?
    get() = ptr.pointed.CurrentWindow?.let(::ImGuiWindow)

  actual val hoveredWindow: ImGuiWindow?
    get() = ptr.pointed.HoveredWindow?.let(::ImGuiWindow)

  actual val hoveredRootWindow: ImGuiWindow?
    get() = ptr.pointed.HoveredRootWindow?.let(::ImGuiWindow)

  actual val hoveredWindowUnderMovingWindow: ImGuiWindow?
    get() = ptr.pointed.HoveredWindowUnderMovingWindow?.let(::ImGuiWindow)

  actual val movingWindow: ImGuiWindow?
    get() = ptr.pointed.MovingWindow?.let(::ImGuiWindow)

  actual val wheelingWindow: ImGuiWindow?
    get() = ptr.pointed.WheelingWindow?.let(::ImGuiWindow)

  actual val wheelingWindowRefMousePos: Vec2
    get() = ptr.pointed.WheelingWindowRefMousePos.fromCValue()

  actual val wheelingWindowTimer: Float
    get() = ptr.pointed.WheelingWindowTimer

  actual val hoveredId: ImGuiID
    get() = ptr.pointed.HoveredId.let(::ImGuiID)

  actual val hoveredIdAllowOverlap: Boolean
    get() = ptr.pointed.HoveredIdAllowOverlap

  actual val hoveredIdPreviousFrame: ImGuiID
    get() = ptr.pointed.HoveredIdPreviousFrame.let(::ImGuiID)

  actual val hoveredIdTimer: Float
    get() = ptr.pointed.HoveredIdTimer

  actual val hoveredIdNotActiveTimer: Float
    get() = ptr.pointed.HoveredIdNotActiveTimer

  actual val activeId: ImGuiID
    get() = ptr.pointed.ActiveId.let(::ImGuiID)

  actual val activeIdIsAlive: ImGuiID
    get() = ptr.pointed.ActiveIdIsAlive.let(::ImGuiID)

  actual val activeIdTimer: Float
    get() = ptr.pointed.ActiveIdTimer

  actual val activeIdIsJustActivated: Boolean
    get() = ptr.pointed.ActiveIdIsJustActivated

  actual val activeIdAllowOverlap: Boolean
    get() = ptr.pointed.ActiveIdAllowOverlap

  actual val activeIdHasBeenPressedBefore: Boolean
    get() = ptr.pointed.ActiveIdHasBeenPressedBefore

  actual val activeIdHasBeenEditedBefore: Boolean
    get() = ptr.pointed.ActiveIdHasBeenEditedBefore

  actual val activeIdHasBeenEditedThisFrame: Boolean
    get() = ptr.pointed.ActiveIdHasBeenEditedThisFrame

  actual val activeIdUsingNavDirMask: UInt
    get() = ptr.pointed.ActiveIdUsingNavDirMask.toUInt()

  actual val activeIdUsingNavInputMask: UInt
    get() = ptr.pointed.ActiveIdUsingNavInputMask.toUInt()

  actual val activeIdClickOffset: Vec2
    get() = ptr.pointed.ActiveIdClickOffset.fromCValue()

  actual val activeIdWindow: ImGuiWindow?
    get() = ptr.pointed.ActiveIdWindow?.let(::ImGuiWindow)

  actual val activeIdMouseButton: Int
    get() = ptr.pointed.ActiveIdMouseButton

  actual val activeIdPreviousFrame: ImGuiID
    get() = ptr.pointed.ActiveIdPreviousFrame.let(::ImGuiID)

  actual val activeIdPreviousFrameIsAlive: Boolean
    get() = ptr.pointed.ActiveIdPreviousFrameIsAlive

  actual val activeIdPreviousFrameHasBeenEditedBefore: Boolean
    get() = ptr.pointed.ActiveIdPreviousFrameHasBeenEditedBefore

  actual val activeIdPreviousFrameWindow: ImGuiWindow?
    get() = ptr.pointed.ActiveIdPreviousFrameWindow?.let(::ImGuiWindow)

  actual val lastActiveId: ImGuiID
    get() = ptr.pointed.LastActiveId.let(::ImGuiID)

  actual val lastActiveIdTimer: Float
    get() = ptr.pointed.LastActiveIdTimer

  actual val currentDpiScale: Float
    get() = ptr.pointed.CurrentDpiScale

  actual val currentViewport: ImGuiViewportP?
    get() = ptr.pointed.CurrentViewport?.let(::ImGuiViewportP)

  actual val mouseViewport: ImGuiViewportP?
    get() = ptr.pointed.MouseViewport?.let(::ImGuiViewportP)

  actual val mouseLastHoveredViewport: ImGuiViewportP?
    get() = ptr.pointed.MouseLastHoveredViewport?.let(::ImGuiViewportP)

  actual val platformLastFocusedViewport: ImGuiID
    get() = ptr.pointed.PlatformLastFocusedViewport.let(::ImGuiID)

  actual val viewportFrontMostStampCount: Int
    get() = ptr.pointed.ViewportFrontMostStampCount

  actual val navWindow: ImGuiWindow?
    get() = ptr.pointed.NavWindow?.let(::ImGuiWindow)

  actual val navId: ImGuiID
    get() = ptr.pointed.NavId.let(::ImGuiID)

  actual val navFocusScopeId: ImGuiID
    get() = ptr.pointed.NavFocusScopeId.let(::ImGuiID)

  actual val navActivateId: ImGuiID
    get() = ptr.pointed.NavActivateId.let(::ImGuiID)

  actual val navActivateDownId: ImGuiID
    get() = ptr.pointed.NavActivateDownId.let(::ImGuiID)

  actual val navActivatePressedId: ImGuiID
    get() = ptr.pointed.NavActivatePressedId.let(::ImGuiID)

  actual val navInputId: ImGuiID
    get() = ptr.pointed.NavInputId.let(::ImGuiID)

  actual val navJustTabbedId: ImGuiID
    get() = ptr.pointed.NavJustTabbedId.let(::ImGuiID)

  actual val navJustMovedToId: ImGuiID
    get() = ptr.pointed.NavJustMovedToId.let(::ImGuiID)

  actual val navJustMovedToFocusScopeId: ImGuiID
    get() = ptr.pointed.NavJustMovedToFocusScopeId.let(::ImGuiID)

  actual val navJustMovedToKeyMods: Flag<ImGuiKeyModFlags>
    get() = ptr.pointed.NavJustMovedToKeyMods.let { ImGuiKeyModFlags.fromMultiple(it) }

  actual val navNextActivateId: ImGuiID
    get() = ptr.pointed.NavNextActivateId.let(::ImGuiID)

  actual val navScoringCount: Int
    get() = ptr.pointed.NavScoringCount

  actual val navIdTabCounter: Int
    get() = ptr.pointed.NavIdTabCounter

  actual val navIdIsAlive: Boolean
    get() = ptr.pointed.NavIdIsAlive

  actual val navMousePosDirty: Boolean
    get() = ptr.pointed.NavMousePosDirty

  actual val navDisableHighlight: Boolean
    get() = ptr.pointed.NavDisableHighlight

  actual val navDisableMouseHover: Boolean
    get() = ptr.pointed.NavDisableMouseHover

  actual val navAnyRequest: Boolean
    get() = ptr.pointed.NavAnyRequest

  actual val navInitRequest: Boolean
    get() = ptr.pointed.NavInitRequest

  actual val navInitRequestFromMove: Boolean
    get() = ptr.pointed.NavInitRequestFromMove

  actual val navInitResultId: ImGuiID
    get() = ptr.pointed.NavInitResultId.let(::ImGuiID)

  actual val navMoveFromClampedRefRect: Boolean
    get() = ptr.pointed.NavMoveFromClampedRefRect

  actual val navMoveRequest: Boolean
    get() = ptr.pointed.NavMoveRequest

  actual val navMoveRequestFlags: Flag<ImGuiNavMoveFlags>
    get() = ptr.pointed.NavMoveRequestFlags.let { ImGuiNavMoveFlags.fromMultiple(it) }

  actual val navMoveRequestKeyMods: Flag<ImGuiKeyModFlags>
    get() = ptr.pointed.NavMoveRequestKeyMods.let { ImGuiKeyModFlags.fromMultiple(it) }

  actual val navMoveDir: ImGuiDir
    get() = ptr.pointed.NavMoveDir.let { ImGuiDir.from(it) }

  actual val navMoveDirLast: ImGuiDir
    get() = ptr.pointed.NavMoveDirLast.let { ImGuiDir.from(it) }

  actual val navMoveClipDir: ImGuiDir
    get() = ptr.pointed.NavMoveClipDir.let { ImGuiDir.from(it) }

  actual val navWrapRequestWindow: ImGuiWindow?
    get() = ptr.pointed.NavWrapRequestWindow?.let(::ImGuiWindow)

  actual val navWrapRequestFlags: Flag<ImGuiNavMoveFlags>
    get() = ptr.pointed.NavWrapRequestFlags.let { ImGuiNavMoveFlags.fromMultiple(it) }

  actual val navWindowingTarget: ImGuiWindow?
    get() = ptr.pointed.NavWindowingTarget?.let(::ImGuiWindow)

  actual val navWindowingTargetAnim: ImGuiWindow?
    get() = ptr.pointed.NavWindowingTargetAnim?.let(::ImGuiWindow)

  actual val navWindowingListWindow: ImGuiWindow?
    get() = ptr.pointed.NavWindowingListWindow?.let(::ImGuiWindow)

  actual val navWindowingTimer: Float
    get() = ptr.pointed.NavWindowingTimer

  actual val navWindowingHighlightAlpha: Float
    get() = ptr.pointed.NavWindowingHighlightAlpha

  actual val navWindowingToggleLayer: Boolean
    get() = ptr.pointed.NavWindowingToggleLayer

  actual val focusRequestCurrWindow: ImGuiWindow?
    get() = ptr.pointed.FocusRequestCurrWindow?.let(::ImGuiWindow)

  actual val focusRequestNextWindow: ImGuiWindow?
    get() = ptr.pointed.FocusRequestNextWindow?.let(::ImGuiWindow)

  actual val focusRequestCurrCounterRegular: Int
    get() = ptr.pointed.FocusRequestCurrCounterRegular

  actual val focusRequestCurrCounterTabStop: Int
    get() = ptr.pointed.FocusRequestCurrCounterTabStop

  actual val focusRequestNextCounterRegular: Int
    get() = ptr.pointed.FocusRequestNextCounterRegular

  actual val focusRequestNextCounterTabStop: Int
    get() = ptr.pointed.FocusRequestNextCounterTabStop

  actual val focusTabPressed: Boolean
    get() = ptr.pointed.FocusTabPressed

  actual val dimBgRatio: Float
    get() = ptr.pointed.DimBgRatio

  actual val mouseCursor: ImGuiMouseCursor
    get() = ptr.pointed.MouseCursor.let { ImGuiMouseCursor.from(it) }

  actual val dragDropActive: Boolean
    get() = ptr.pointed.DragDropActive

  actual val dragDropWithinSource: Boolean
    get() = ptr.pointed.DragDropWithinSource

  actual val dragDropWithinTarget: Boolean
    get() = ptr.pointed.DragDropWithinTarget

  actual val dragDropSourceFlags: Flag<ImGuiDragDropFlags>
    get() = ptr.pointed.DragDropSourceFlags.let { ImGuiDragDropFlags.fromMultiple(it) }

  actual val dragDropSourceFrameCount: Int
    get() = ptr.pointed.DragDropSourceFrameCount

  actual val dragDropMouseButton: Int
    get() = ptr.pointed.DragDropMouseButton

  actual val dragDropTargetId: ImGuiID
    get() = ptr.pointed.DragDropTargetId.let(::ImGuiID)

  actual val dragDropAcceptFlags: Flag<ImGuiDragDropFlags>
    get() = ptr.pointed.DragDropAcceptFlags.let { ImGuiDragDropFlags.fromMultiple(it) }

  actual val dragDropAcceptIdCurrRectSurface: Float
    get() = ptr.pointed.DragDropAcceptIdCurrRectSurface

  actual val dragDropAcceptIdCurr: ImGuiID
    get() = ptr.pointed.DragDropAcceptIdCurr.let(::ImGuiID)

  actual val dragDropAcceptIdPrev: ImGuiID
    get() = ptr.pointed.DragDropAcceptIdPrev.let(::ImGuiID)

  actual val dragDropAcceptFrameCount: Int
    get() = ptr.pointed.DragDropAcceptFrameCount

  actual val dragDropHoldJustPressedId: ImGuiID
    get() = ptr.pointed.DragDropHoldJustPressedId.let(::ImGuiID)

  actual val currentTabBar: ImGuiTabBar?
    get() = ptr.pointed.CurrentTabBar?.let(::ImGuiTabBar)

  actual val lastValidMousePos: Vec2
    get() = ptr.pointed.LastValidMousePos.fromCValue()

  actual val tempInputId: ImGuiID
    get() = ptr.pointed.TempInputId.let(::ImGuiID)

  actual val colorEditOptions: Flag<ImGuiColorEditFlags>
    get() = ptr.pointed.ColorEditOptions.let { ImGuiColorEditFlags.fromMultiple(it) }

  actual val colorEditLastHue: Float
    get() = ptr.pointed.ColorEditLastHue

  actual val colorEditLastSat: Float
    get() = ptr.pointed.ColorEditLastSat

  actual val colorPickerRef: Vec4
    get() = ptr.pointed.ColorPickerRef.fromCValue()

  actual val dragCurrentAccumDirty: Boolean
    get() = ptr.pointed.DragCurrentAccumDirty

  actual val dragCurrentAccum: Float
    get() = ptr.pointed.DragCurrentAccum

  actual val dragSpeedDefaultRatio: Float
    get() = ptr.pointed.DragSpeedDefaultRatio

  actual val scrollbarClickDeltaToGrabCenter: Float
    get() = ptr.pointed.ScrollbarClickDeltaToGrabCenter

  actual val tooltipOverrideCount: Int
    get() = ptr.pointed.TooltipOverrideCount

  actual val platformImePos: Vec2
    get() = ptr.pointed.PlatformImePos.fromCValue()

  actual val platformImeLastPos: Vec2
    get() = ptr.pointed.PlatformImeLastPos.fromCValue()

  actual val platformImePosViewport: ImGuiViewportP?
    get() = ptr.pointed.PlatformImePosViewport?.let(::ImGuiViewportP)

  actual val settingsLoaded: Boolean
    get() = ptr.pointed.SettingsLoaded

  actual val settingsDirtyTimer: Float
    get() = ptr.pointed.SettingsDirtyTimer

  actual val logEnabled: Boolean
    get() = ptr.pointed.LogEnabled

  actual val logLinePosY: Float
    get() = ptr.pointed.LogLinePosY

  actual val logLineFirstItem: Boolean
    get() = ptr.pointed.LogLineFirstItem

  actual val logDepthRef: Int
    get() = ptr.pointed.LogDepthRef

  actual val logDepthToExpand: Int
    get() = ptr.pointed.LogDepthToExpand

  actual val logDepthToExpandDefault: Int
    get() = ptr.pointed.LogDepthToExpandDefault

  actual val debugItemPickerActive: Boolean
    get() = ptr.pointed.DebugItemPickerActive

  actual val debugItemPickerBreakId: ImGuiID
    get() = ptr.pointed.DebugItemPickerBreakId.let(::ImGuiID)

  actual val framerateSecPerFrameIdx: Int
    get() = ptr.pointed.FramerateSecPerFrameIdx

  actual val framerateSecPerFrameAccum: Float
    get() = ptr.pointed.FramerateSecPerFrameAccum

  actual val wantCaptureMouseNextFrame: Int
    get() = ptr.pointed.WantCaptureMouseNextFrame

  actual val wantCaptureKeyboardNextFrame: Int
    get() = ptr.pointed.WantCaptureKeyboardNextFrame

  actual val wantTextInputNextFrame: Int
    get() = ptr.pointed.WantTextInputNextFrame

  actual constructor(sharedFontAtlas: ImFontAtlas) :
      this(ImGuiContext_ImGuiContext(sharedFontAtlas.ptr)!!)

  actual fun destroy() {
    ImGuiContext_destroy(ptr)
  }
}
