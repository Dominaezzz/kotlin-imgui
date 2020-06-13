package com.imgui

import kotlin.Boolean
import kotlin.Double
import kotlin.Float
import kotlin.Int
import kotlin.UInt

expect class ImGuiContext {
  val initialized: Boolean

  val fontAtlasOwnedByContext: Boolean

  val font: ImFont?

  val fontSize: Float

  val fontBaseSize: Float

  val time: Double

  val frameCount: Int

  val frameCountEnded: Int

  val frameCountRendered: Int

  val withinFrameScope: Boolean

  val withinFrameScopeWithImplicitWindow: Boolean

  val withinEndChild: Boolean

  val windowsActiveCount: Int

  val currentWindow: ImGuiWindow?

  val hoveredWindow: ImGuiWindow?

  val hoveredRootWindow: ImGuiWindow?

  val movingWindow: ImGuiWindow?

  val wheelingWindow: ImGuiWindow?

  val wheelingWindowRefMousePos: Vec2

  val wheelingWindowTimer: Float

  val hoveredId: ImGuiID

  val hoveredIdAllowOverlap: Boolean

  val hoveredIdPreviousFrame: ImGuiID

  val hoveredIdTimer: Float

  val hoveredIdNotActiveTimer: Float

  val activeId: ImGuiID

  val activeIdIsAlive: ImGuiID

  val activeIdTimer: Float

  val activeIdIsJustActivated: Boolean

  val activeIdAllowOverlap: Boolean

  val activeIdHasBeenPressedBefore: Boolean

  val activeIdHasBeenEditedBefore: Boolean

  val activeIdHasBeenEditedThisFrame: Boolean

  val activeIdUsingNavDirMask: UInt

  val activeIdUsingNavInputMask: UInt

  val activeIdClickOffset: Vec2

  val activeIdWindow: ImGuiWindow?

  val activeIdMouseButton: Int

  val activeIdPreviousFrame: ImGuiID

  val activeIdPreviousFrameIsAlive: Boolean

  val activeIdPreviousFrameHasBeenEditedBefore: Boolean

  val activeIdPreviousFrameWindow: ImGuiWindow?

  val lastActiveId: ImGuiID

  val lastActiveIdTimer: Float

  val navWindow: ImGuiWindow?

  val navId: ImGuiID

  val navFocusScopeId: ImGuiID

  val navActivateId: ImGuiID

  val navActivateDownId: ImGuiID

  val navActivatePressedId: ImGuiID

  val navInputId: ImGuiID

  val navJustTabbedId: ImGuiID

  val navJustMovedToId: ImGuiID

  val navJustMovedToFocusScopeId: ImGuiID

  val navJustMovedToKeyMods: Flag<ImGuiKeyModFlags>

  val navNextActivateId: ImGuiID

  val navScoringCount: Int

  val navIdTabCounter: Int

  val navIdIsAlive: Boolean

  val navMousePosDirty: Boolean

  val navDisableHighlight: Boolean

  val navDisableMouseHover: Boolean

  val navAnyRequest: Boolean

  val navInitRequest: Boolean

  val navInitRequestFromMove: Boolean

  val navInitResultId: ImGuiID

  val navMoveFromClampedRefRect: Boolean

  val navMoveRequest: Boolean

  val navMoveRequestFlags: Flag<ImGuiNavMoveFlags>

  val navMoveRequestKeyMods: Flag<ImGuiKeyModFlags>

  val navMoveDir: ImGuiDir

  val navMoveDirLast: ImGuiDir

  val navMoveClipDir: ImGuiDir

  val navWindowingTarget: ImGuiWindow?

  val navWindowingTargetAnim: ImGuiWindow?

  val navWindowingList: ImGuiWindow?

  val navWindowingTimer: Float

  val navWindowingHighlightAlpha: Float

  val navWindowingToggleLayer: Boolean

  val focusRequestCurrWindow: ImGuiWindow?

  val focusRequestNextWindow: ImGuiWindow?

  val focusRequestCurrCounterRegular: Int

  val focusRequestCurrCounterTabStop: Int

  val focusRequestNextCounterRegular: Int

  val focusRequestNextCounterTabStop: Int

  val focusTabPressed: Boolean

  val dimBgRatio: Float

  val mouseCursor: ImGuiMouseCursor

  val dragDropActive: Boolean

  val dragDropWithinSource: Boolean

  val dragDropWithinTarget: Boolean

  val dragDropSourceFlags: Flag<ImGuiDragDropFlags>

  val dragDropSourceFrameCount: Int

  val dragDropMouseButton: Int

  val dragDropTargetId: ImGuiID

  val dragDropAcceptFlags: Flag<ImGuiDragDropFlags>

  val dragDropAcceptIdCurrRectSurface: Float

  val dragDropAcceptIdCurr: ImGuiID

  val dragDropAcceptIdPrev: ImGuiID

  val dragDropAcceptFrameCount: Int

  val currentTabBar: ImGuiTabBar?

  val lastValidMousePos: Vec2

  val tempInputId: ImGuiID

  val colorEditOptions: Flag<ImGuiColorEditFlags>

  val colorEditLastHue: Float

  val colorEditLastSat: Float

  val colorPickerRef: Vec4

  val dragCurrentAccumDirty: Boolean

  val dragCurrentAccum: Float

  val dragSpeedDefaultRatio: Float

  val scrollbarClickDeltaToGrabCenter: Float

  val tooltipOverrideCount: Int

  val platformImePos: Vec2

  val platformImeLastPos: Vec2

  val settingsLoaded: Boolean

  val settingsDirtyTimer: Float

  val logEnabled: Boolean

  val logLinePosY: Float

  val logLineFirstItem: Boolean

  val logDepthRef: Int

  val logDepthToExpand: Int

  val logDepthToExpandDefault: Int

  val debugItemPickerActive: Boolean

  val debugItemPickerBreakId: ImGuiID

  val framerateSecPerFrameIdx: Int

  val framerateSecPerFrameAccum: Float

  val wantCaptureMouseNextFrame: Int

  val wantCaptureKeyboardNextFrame: Int

  val wantTextInputNextFrame: Int

  constructor(sharedFontAtlas: ImFontAtlas)

  fun colorEditLastColor(index: Int): Float

  fun framerateSecPerFrame(index: Int): Float

  fun destroy()
}
