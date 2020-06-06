package com.imgui

import cimgui.internal.igAcceptDragDropPayload
import cimgui.internal.igActivateItem
import cimgui.internal.igAlignTextToFramePadding
import cimgui.internal.igArrowButton
import cimgui.internal.igArrowButtonEx
import cimgui.internal.igBegin
import cimgui.internal.igBeginChildEx
import cimgui.internal.igBeginChildFrame
import cimgui.internal.igBeginChildID
import cimgui.internal.igBeginChildStr
import cimgui.internal.igBeginColumns
import cimgui.internal.igBeginCombo
import cimgui.internal.igBeginDockableDragDropSource
import cimgui.internal.igBeginDockableDragDropTarget
import cimgui.internal.igBeginDocked
import cimgui.internal.igBeginDragDropSource
import cimgui.internal.igBeginDragDropTarget
import cimgui.internal.igBeginGroup
import cimgui.internal.igBeginMainMenuBar
import cimgui.internal.igBeginMenu
import cimgui.internal.igBeginMenuBar
import cimgui.internal.igBeginPopup
import cimgui.internal.igBeginPopupContextItem
import cimgui.internal.igBeginPopupContextVoid
import cimgui.internal.igBeginPopupContextWindow
import cimgui.internal.igBeginPopupEx
import cimgui.internal.igBeginPopupModal
import cimgui.internal.igBeginTabBar
import cimgui.internal.igBeginTabItem
import cimgui.internal.igBeginTooltip
import cimgui.internal.igBeginTooltipEx
import cimgui.internal.igBringWindowToDisplayBack
import cimgui.internal.igBringWindowToDisplayFront
import cimgui.internal.igBringWindowToFocusFront
import cimgui.internal.igBullet
import cimgui.internal.igBulletText
import cimgui.internal.igButton
import cimgui.internal.igButtonEx
import cimgui.internal.igCalcItemWidth
import cimgui.internal.igCalcListClipping
import cimgui.internal.igCalcTypematicRepeatAmount
import cimgui.internal.igCalcWrapWidthForPos
import cimgui.internal.igCaptureKeyboardFromApp
import cimgui.internal.igCaptureMouseFromApp
import cimgui.internal.igCheckbox
import cimgui.internal.igCheckboxFlags
import cimgui.internal.igClearActiveID
import cimgui.internal.igClearDragDrop
import cimgui.internal.igClearIniSettings
import cimgui.internal.igCloseButton
import cimgui.internal.igCloseCurrentPopup
import cimgui.internal.igClosePopupToLevel
import cimgui.internal.igClosePopupsOverWindow
import cimgui.internal.igCollapseButton
import cimgui.internal.igCollapsingHeaderBoolPtr
import cimgui.internal.igCollapsingHeaderTreeNodeFlags
import cimgui.internal.igColorButton
import cimgui.internal.igColorConvertFloat4ToU32
import cimgui.internal.igColorConvertHSVtoRGB
import cimgui.internal.igColorConvertRGBtoHSV
import cimgui.internal.igColorEdit3
import cimgui.internal.igColorEdit4
import cimgui.internal.igColorPicker3
import cimgui.internal.igColorPicker4
import cimgui.internal.igColumns
import cimgui.internal.igComboStr
import cimgui.internal.igCreateContext
import cimgui.internal.igCreateNewWindowSettings
import cimgui.internal.igDataTypeGetInfo
import cimgui.internal.igDebugCheckVersionAndDataLayout
import cimgui.internal.igDebugDrawItemRect
import cimgui.internal.igDebugStartItemPicker
import cimgui.internal.igDestroyContext
import cimgui.internal.igDestroyPlatformWindow
import cimgui.internal.igDestroyPlatformWindows
import cimgui.internal.igDockBuilderAddNode
import cimgui.internal.igDockBuilderCopyWindowSettings
import cimgui.internal.igDockBuilderDockWindow
import cimgui.internal.igDockBuilderFinish
import cimgui.internal.igDockBuilderGetCentralNode
import cimgui.internal.igDockBuilderGetNode
import cimgui.internal.igDockBuilderRemoveNode
import cimgui.internal.igDockBuilderRemoveNodeChildNodes
import cimgui.internal.igDockBuilderRemoveNodeDockedWindows
import cimgui.internal.igDockBuilderSetNodePos
import cimgui.internal.igDockBuilderSetNodeSize
import cimgui.internal.igDockContextCalcDropPosForDocking
import cimgui.internal.igDockContextClearNodes
import cimgui.internal.igDockContextGenNodeID
import cimgui.internal.igDockContextInitialize
import cimgui.internal.igDockContextQueueDock
import cimgui.internal.igDockContextQueueUndockNode
import cimgui.internal.igDockContextQueueUndockWindow
import cimgui.internal.igDockContextRebuildNodes
import cimgui.internal.igDockContextShutdown
import cimgui.internal.igDockContextUpdateDocking
import cimgui.internal.igDockContextUpdateUndocking
import cimgui.internal.igDockNodeGetDepth
import cimgui.internal.igDockNodeGetRootNode
import cimgui.internal.igDockSpace
import cimgui.internal.igDockSpaceOverViewport
import cimgui.internal.igDragFloat
import cimgui.internal.igDragFloat2
import cimgui.internal.igDragFloat3
import cimgui.internal.igDragFloat4
import cimgui.internal.igDragFloatRange2
import cimgui.internal.igDragInt
import cimgui.internal.igDragInt2
import cimgui.internal.igDragInt3
import cimgui.internal.igDragInt4
import cimgui.internal.igDragIntRange2
import cimgui.internal.igDummy
import cimgui.internal.igEnd
import cimgui.internal.igEndChild
import cimgui.internal.igEndChildFrame
import cimgui.internal.igEndColumns
import cimgui.internal.igEndCombo
import cimgui.internal.igEndDragDropSource
import cimgui.internal.igEndDragDropTarget
import cimgui.internal.igEndFrame
import cimgui.internal.igEndGroup
import cimgui.internal.igEndMainMenuBar
import cimgui.internal.igEndMenu
import cimgui.internal.igEndMenuBar
import cimgui.internal.igEndPopup
import cimgui.internal.igEndTabBar
import cimgui.internal.igEndTabItem
import cimgui.internal.igEndTooltip
import cimgui.internal.igFindOrCreateColumns
import cimgui.internal.igFindOrCreateWindowSettings
import cimgui.internal.igFindRenderedTextEnd
import cimgui.internal.igFindSettingsHandler
import cimgui.internal.igFindViewportByID
import cimgui.internal.igFindWindowByID
import cimgui.internal.igFindWindowByName
import cimgui.internal.igFindWindowSettings
import cimgui.internal.igFocusTopMostWindowUnderOne
import cimgui.internal.igFocusWindow
import cimgui.internal.igFocusableItemRegister
import cimgui.internal.igFocusableItemUnregister
import cimgui.internal.igGcAwakeTransientWindowBuffers
import cimgui.internal.igGcCompactTransientWindowBuffers
import cimgui.internal.igGetActiveID
import cimgui.internal.igGetBackgroundDrawListNil
import cimgui.internal.igGetBackgroundDrawListViewportPtr
import cimgui.internal.igGetClipboardText
import cimgui.internal.igGetColorU32Col
import cimgui.internal.igGetColorU32U32
import cimgui.internal.igGetColorU32Vec4
import cimgui.internal.igGetColumnIndex
import cimgui.internal.igGetColumnNormFromOffset
import cimgui.internal.igGetColumnOffset
import cimgui.internal.igGetColumnOffsetFromNorm
import cimgui.internal.igGetColumnWidth
import cimgui.internal.igGetColumnsCount
import cimgui.internal.igGetColumnsID
import cimgui.internal.igGetCurrentContext
import cimgui.internal.igGetCurrentWindow
import cimgui.internal.igGetCurrentWindowRead
import cimgui.internal.igGetCursorPosX
import cimgui.internal.igGetCursorPosY
import cimgui.internal.igGetDefaultFont
import cimgui.internal.igGetDragDropPayload
import cimgui.internal.igGetDrawData
import cimgui.internal.igGetDrawListSharedData
import cimgui.internal.igGetFocusID
import cimgui.internal.igGetFocusScopeID
import cimgui.internal.igGetFont
import cimgui.internal.igGetFontSize
import cimgui.internal.igGetForegroundDrawListNil
import cimgui.internal.igGetForegroundDrawListViewportPtr
import cimgui.internal.igGetForegroundDrawListWindowPtr
import cimgui.internal.igGetFrameCount
import cimgui.internal.igGetFrameHeight
import cimgui.internal.igGetFrameHeightWithSpacing
import cimgui.internal.igGetHoveredID
import cimgui.internal.igGetIDStr
import cimgui.internal.igGetIDStrStr
import cimgui.internal.igGetIO
import cimgui.internal.igGetInputTextState
import cimgui.internal.igGetItemID
import cimgui.internal.igGetItemStatusFlags
import cimgui.internal.igGetKeyIndex
import cimgui.internal.igGetKeyPressedAmount
import cimgui.internal.igGetMainViewport
import cimgui.internal.igGetMergedKeyModFlags
import cimgui.internal.igGetMouseCursor
import cimgui.internal.igGetPlatformIO
import cimgui.internal.igGetScrollMaxX
import cimgui.internal.igGetScrollMaxY
import cimgui.internal.igGetScrollX
import cimgui.internal.igGetScrollY
import cimgui.internal.igGetStateStorage
import cimgui.internal.igGetStyle
import cimgui.internal.igGetStyleColorName
import cimgui.internal.igGetStyleColorVec4
import cimgui.internal.igGetTextLineHeight
import cimgui.internal.igGetTextLineHeightWithSpacing
import cimgui.internal.igGetTime
import cimgui.internal.igGetTopMostPopupModal
import cimgui.internal.igGetTreeNodeToLabelSpacing
import cimgui.internal.igGetVersion
import cimgui.internal.igGetWindowAlwaysWantOwnTabBar
import cimgui.internal.igGetWindowContentRegionWidth
import cimgui.internal.igGetWindowDockID
import cimgui.internal.igGetWindowDockNode
import cimgui.internal.igGetWindowDpiScale
import cimgui.internal.igGetWindowDrawList
import cimgui.internal.igGetWindowHeight
import cimgui.internal.igGetWindowResizeID
import cimgui.internal.igGetWindowViewport
import cimgui.internal.igGetWindowWidth
import cimgui.internal.igImAlphaBlendColors
import cimgui.internal.igImCharIsBlankW
import cimgui.internal.igImDot
import cimgui.internal.igImFloorFloat
import cimgui.internal.igImFontAtlasBuildFinish
import cimgui.internal.igImFontAtlasBuildInit
import cimgui.internal.igImFontAtlasBuildSetupFont
import cimgui.internal.igImFontAtlasBuildWithStbTruetype
import cimgui.internal.igImGetDirQuadrantFromDelta
import cimgui.internal.igImHashStr
import cimgui.internal.igImInvLength
import cimgui.internal.igImIsPowerOfTwo
import cimgui.internal.igImLengthSqrVec2
import cimgui.internal.igImLengthSqrVec4
import cimgui.internal.igImLinearSweep
import cimgui.internal.igImModPositive
import cimgui.internal.igImParseFormatFindEnd
import cimgui.internal.igImParseFormatFindStart
import cimgui.internal.igImParseFormatPrecision
import cimgui.internal.igImPowFloat
import cimgui.internal.igImPowdouble
import cimgui.internal.igImSaturate
import cimgui.internal.igImStrSkipBlank
import cimgui.internal.igImStrbolW
import cimgui.internal.igImStreolRange
import cimgui.internal.igImStricmp
import cimgui.internal.igImStristr
import cimgui.internal.igImStrlenW
import cimgui.internal.igImStrnicmp
import cimgui.internal.igImTextCharFromUtf8
import cimgui.internal.igImTextCountCharsFromUtf8
import cimgui.internal.igImTextCountUtf8BytesFromChar
import cimgui.internal.igImTextCountUtf8BytesFromStr
import cimgui.internal.igImTriangleArea
import cimgui.internal.igImTriangleContainsPoint
import cimgui.internal.igImUpperPowerOfTwo
import cimgui.internal.igImage
import cimgui.internal.igImageButton
import cimgui.internal.igIndent
import cimgui.internal.igInitialize
import cimgui.internal.igInputDouble
import cimgui.internal.igInputFloat
import cimgui.internal.igInputFloat2
import cimgui.internal.igInputFloat3
import cimgui.internal.igInputFloat4
import cimgui.internal.igInputInt
import cimgui.internal.igInputInt2
import cimgui.internal.igInputInt3
import cimgui.internal.igInputInt4
import cimgui.internal.igInvisibleButton
import cimgui.internal.igIsActiveIdUsingKey
import cimgui.internal.igIsActiveIdUsingNavDir
import cimgui.internal.igIsActiveIdUsingNavInput
import cimgui.internal.igIsAnyItemActive
import cimgui.internal.igIsAnyItemFocused
import cimgui.internal.igIsAnyItemHovered
import cimgui.internal.igIsAnyMouseDown
import cimgui.internal.igIsDragDropPayloadBeingAccepted
import cimgui.internal.igIsItemActivated
import cimgui.internal.igIsItemActive
import cimgui.internal.igIsItemClicked
import cimgui.internal.igIsItemDeactivated
import cimgui.internal.igIsItemDeactivatedAfterEdit
import cimgui.internal.igIsItemEdited
import cimgui.internal.igIsItemFocused
import cimgui.internal.igIsItemHovered
import cimgui.internal.igIsItemToggledOpen
import cimgui.internal.igIsItemToggledSelection
import cimgui.internal.igIsItemVisible
import cimgui.internal.igIsKeyDown
import cimgui.internal.igIsKeyPressed
import cimgui.internal.igIsKeyPressedMap
import cimgui.internal.igIsKeyReleased
import cimgui.internal.igIsMouseClicked
import cimgui.internal.igIsMouseDoubleClicked
import cimgui.internal.igIsMouseDown
import cimgui.internal.igIsMouseDragPastThreshold
import cimgui.internal.igIsMouseDragging
import cimgui.internal.igIsMouseHoveringRect
import cimgui.internal.igIsMousePosValid
import cimgui.internal.igIsMouseReleased
import cimgui.internal.igIsNavInputDown
import cimgui.internal.igIsPopupOpenID
import cimgui.internal.igIsPopupOpenStr
import cimgui.internal.igIsRectVisibleNil
import cimgui.internal.igIsRectVisibleVec2
import cimgui.internal.igIsWindowAppearing
import cimgui.internal.igIsWindowChildOf
import cimgui.internal.igIsWindowCollapsed
import cimgui.internal.igIsWindowDocked
import cimgui.internal.igIsWindowFocused
import cimgui.internal.igIsWindowHovered
import cimgui.internal.igIsWindowNavFocusable
import cimgui.internal.igItemSizeVec2
import cimgui.internal.igKeepAliveID
import cimgui.internal.igLabelText
import cimgui.internal.igListBoxFooter
import cimgui.internal.igListBoxHeaderInt
import cimgui.internal.igListBoxHeaderVec2
import cimgui.internal.igLoadIniSettingsFromDisk
import cimgui.internal.igLoadIniSettingsFromMemory
import cimgui.internal.igLogButtons
import cimgui.internal.igLogFinish
import cimgui.internal.igLogRenderedText
import cimgui.internal.igLogText
import cimgui.internal.igLogToBuffer
import cimgui.internal.igLogToClipboard
import cimgui.internal.igLogToFile
import cimgui.internal.igLogToTTY
import cimgui.internal.igMarkIniSettingsDirtyNil
import cimgui.internal.igMarkIniSettingsDirtyWindowPtr
import cimgui.internal.igMarkItemEdited
import cimgui.internal.igMenuItemBool
import cimgui.internal.igMenuItemBoolPtr
import cimgui.internal.igNavInitWindow
import cimgui.internal.igNavMoveRequestButNoResultYet
import cimgui.internal.igNavMoveRequestCancel
import cimgui.internal.igNavMoveRequestTryWrapping
import cimgui.internal.igNewFrame
import cimgui.internal.igNewLine
import cimgui.internal.igNextColumn
import cimgui.internal.igOpenPopup
import cimgui.internal.igOpenPopupEx
import cimgui.internal.igOpenPopupOnItemClick
import cimgui.internal.igPopAllowKeyboardFocus
import cimgui.internal.igPopButtonRepeat
import cimgui.internal.igPopClipRect
import cimgui.internal.igPopColumnsBackground
import cimgui.internal.igPopFocusScope
import cimgui.internal.igPopFont
import cimgui.internal.igPopID
import cimgui.internal.igPopItemFlag
import cimgui.internal.igPopItemWidth
import cimgui.internal.igPopStyleColor
import cimgui.internal.igPopStyleVar
import cimgui.internal.igPopTextWrapPos
import cimgui.internal.igProgressBar
import cimgui.internal.igPushAllowKeyboardFocus
import cimgui.internal.igPushButtonRepeat
import cimgui.internal.igPushClipRect
import cimgui.internal.igPushColumnClipRect
import cimgui.internal.igPushColumnsBackground
import cimgui.internal.igPushFocusScope
import cimgui.internal.igPushFont
import cimgui.internal.igPushIDInt
import cimgui.internal.igPushIDStr
import cimgui.internal.igPushIDStrStr
import cimgui.internal.igPushItemFlag
import cimgui.internal.igPushItemWidth
import cimgui.internal.igPushMultiItemsWidths
import cimgui.internal.igPushOverrideID
import cimgui.internal.igPushStyleColorU32
import cimgui.internal.igPushStyleColorVec4
import cimgui.internal.igPushStyleVarFloat
import cimgui.internal.igPushStyleVarVec2
import cimgui.internal.igPushTextWrapPos
import cimgui.internal.igRadioButtonBool
import cimgui.internal.igRadioButtonIntPtr
import cimgui.internal.igRender
import cimgui.internal.igRenderArrow
import cimgui.internal.igRenderArrowDockMenu
import cimgui.internal.igRenderArrowPointingAt
import cimgui.internal.igRenderBullet
import cimgui.internal.igRenderCheckMark
import cimgui.internal.igRenderColorRectWithAlphaCheckerboard
import cimgui.internal.igRenderFrame
import cimgui.internal.igRenderFrameBorder
import cimgui.internal.igRenderMouseCursor
import cimgui.internal.igRenderPlatformWindowsDefault
import cimgui.internal.igRenderText
import cimgui.internal.igRenderTextClipped
import cimgui.internal.igRenderTextClippedEx
import cimgui.internal.igRenderTextEllipsis
import cimgui.internal.igRenderTextWrapped
import cimgui.internal.igResetMouseDragDelta
import cimgui.internal.igSameLine
import cimgui.internal.igSaveIniSettingsToDisk
import cimgui.internal.igSaveIniSettingsToMemory
import cimgui.internal.igScaleWindowsInViewport
import cimgui.internal.igSelectableBool
import cimgui.internal.igSelectableBoolPtr
import cimgui.internal.igSeparator
import cimgui.internal.igSeparatorEx
import cimgui.internal.igSetActiveID
import cimgui.internal.igSetClipboardText
import cimgui.internal.igSetColorEditOptions
import cimgui.internal.igSetColumnOffset
import cimgui.internal.igSetColumnWidth
import cimgui.internal.igSetCurrentContext
import cimgui.internal.igSetCurrentFont
import cimgui.internal.igSetCursorPos
import cimgui.internal.igSetCursorPosX
import cimgui.internal.igSetCursorPosY
import cimgui.internal.igSetCursorScreenPos
import cimgui.internal.igSetFocusID
import cimgui.internal.igSetHoveredID
import cimgui.internal.igSetItemAllowOverlap
import cimgui.internal.igSetItemDefaultFocus
import cimgui.internal.igSetKeyboardFocusHere
import cimgui.internal.igSetMouseCursor
import cimgui.internal.igSetNavID
import cimgui.internal.igSetNextItemOpen
import cimgui.internal.igSetNextItemWidth
import cimgui.internal.igSetNextWindowBgAlpha
import cimgui.internal.igSetNextWindowClass
import cimgui.internal.igSetNextWindowCollapsed
import cimgui.internal.igSetNextWindowContentSize
import cimgui.internal.igSetNextWindowDockID
import cimgui.internal.igSetNextWindowFocus
import cimgui.internal.igSetNextWindowPos
import cimgui.internal.igSetNextWindowScroll
import cimgui.internal.igSetNextWindowSize
import cimgui.internal.igSetNextWindowViewport
import cimgui.internal.igSetScrollFromPosXFloat
import cimgui.internal.igSetScrollFromPosXWindowPtr
import cimgui.internal.igSetScrollFromPosYFloat
import cimgui.internal.igSetScrollFromPosYWindowPtr
import cimgui.internal.igSetScrollHereX
import cimgui.internal.igSetScrollHereY
import cimgui.internal.igSetScrollXFloat
import cimgui.internal.igSetScrollXWindowPtr
import cimgui.internal.igSetScrollYFloat
import cimgui.internal.igSetScrollYWindowPtr
import cimgui.internal.igSetStateStorage
import cimgui.internal.igSetTabItemClosed
import cimgui.internal.igSetTooltip
import cimgui.internal.igSetWindowCollapsedBool
import cimgui.internal.igSetWindowCollapsedStr
import cimgui.internal.igSetWindowCollapsedWindowPtr
import cimgui.internal.igSetWindowDock
import cimgui.internal.igSetWindowFocusNil
import cimgui.internal.igSetWindowFocusStr
import cimgui.internal.igSetWindowFontScale
import cimgui.internal.igSetWindowHitTestHole
import cimgui.internal.igSetWindowPosStr
import cimgui.internal.igSetWindowPosVec2
import cimgui.internal.igSetWindowPosWindowPtr
import cimgui.internal.igSetWindowSizeStr
import cimgui.internal.igSetWindowSizeVec2
import cimgui.internal.igSetWindowSizeWindowPtr
import cimgui.internal.igShadeVertsLinearColorGradientKeepAlpha
import cimgui.internal.igShadeVertsLinearUV
import cimgui.internal.igShowAboutWindow
import cimgui.internal.igShowDemoWindow
import cimgui.internal.igShowFontSelector
import cimgui.internal.igShowMetricsWindow
import cimgui.internal.igShowStyleEditor
import cimgui.internal.igShowStyleSelector
import cimgui.internal.igShowUserGuide
import cimgui.internal.igShowViewportThumbnails
import cimgui.internal.igShrinkWidths
import cimgui.internal.igShutdown
import cimgui.internal.igSliderAngle
import cimgui.internal.igSliderFloat
import cimgui.internal.igSliderFloat2
import cimgui.internal.igSliderFloat3
import cimgui.internal.igSliderFloat4
import cimgui.internal.igSliderInt
import cimgui.internal.igSliderInt2
import cimgui.internal.igSliderInt3
import cimgui.internal.igSliderInt4
import cimgui.internal.igSmallButton
import cimgui.internal.igSpacing
import cimgui.internal.igStartMouseMovingWindow
import cimgui.internal.igStartMouseMovingWindowOrNode
import cimgui.internal.igStyleColorsClassic
import cimgui.internal.igStyleColorsDark
import cimgui.internal.igStyleColorsLight
import cimgui.internal.igTabBarAddTab
import cimgui.internal.igTabBarCloseTab
import cimgui.internal.igTabBarFindMostRecentlySelectedTabForActiveWindow
import cimgui.internal.igTabBarFindTabByID
import cimgui.internal.igTabBarQueueChangeTabOrder
import cimgui.internal.igTabBarRemoveTab
import cimgui.internal.igTabItemEx
import cimgui.internal.igTempInputIsActive
import cimgui.internal.igText
import cimgui.internal.igTextColored
import cimgui.internal.igTextDisabled
import cimgui.internal.igTextEx
import cimgui.internal.igTextUnformatted
import cimgui.internal.igTextWrapped
import cimgui.internal.igTranslateWindowsInViewport
import cimgui.internal.igTreeNodeBehavior
import cimgui.internal.igTreeNodeBehaviorIsOpen
import cimgui.internal.igTreeNodeExStr
import cimgui.internal.igTreeNodeExStrStr
import cimgui.internal.igTreeNodeStr
import cimgui.internal.igTreeNodeStrStr
import cimgui.internal.igTreePop
import cimgui.internal.igTreePushOverrideID
import cimgui.internal.igTreePushPtr
import cimgui.internal.igTreePushStr
import cimgui.internal.igUnindent
import cimgui.internal.igUpdateHoveredWindowAndCaptureFlags
import cimgui.internal.igUpdateMouseMovingWindowEndFrame
import cimgui.internal.igUpdateMouseMovingWindowNewFrame
import cimgui.internal.igUpdatePlatformWindows
import cimgui.internal.igUpdateWindowParentAndRootLinks
import cimgui.internal.igVSliderFloat
import cimgui.internal.igVSliderInt
import cimgui.internal.igValueBool
import cimgui.internal.igValueFloat
import cimgui.internal.igValueInt
import cimgui.internal.igValueUint
import kotlin.Boolean
import kotlin.Double
import kotlin.Float
import kotlin.FloatArray
import kotlin.Int
import kotlin.IntArray
import kotlin.String
import kotlin.UInt
import kotlin.ULong
import kotlin.reflect.KMutableProperty0
import kotlinx.cinterop.addressOf
import kotlinx.cinterop.convert
import kotlinx.cinterop.toKString
import kotlinx.cinterop.usePinned
import kotlinx.cinterop.wcstr

actual object ImGui {
    actual fun acceptDragDropPayload(type: String, flags: Flag<ImGuiDragDropFlags>?): ImGuiPayload =
            igAcceptDragDropPayload(type, flags?.value ?: 0)!!.let(::ImGuiPayload)

    actual fun activateItem(id: ImGuiID) {
        igActivateItem(id.value)
    }

    actual fun alignTextToFramePadding() {
        igAlignTextToFramePadding()
    }

    actual fun arrowButton(strId: String, dir: ImGuiDir): Boolean = igArrowButton(strId, dir.value)

    actual fun arrowButtonEx(
        strId: String,
        dir: ImGuiDir,
        sizeArg: Vec2,
        flags: Flag<ImGuiButtonFlags>?
    ): Boolean = igArrowButtonEx(strId, dir.value, sizeArg.toCValue(), flags?.value ?: 0)

    actual fun begin(
        name: String,
        pOpen: KMutableProperty0<Boolean>?,
        flags: Flag<ImGuiWindowFlags>?
    ): Boolean = usingPropertyN(pOpen) { ptrPOpen ->
        igBegin(name, ptrPOpen, flags?.value ?: 0)
    }

    actual fun beginChild(
        strId: String,
        size: Vec2,
        border: Boolean,
        flags: Flag<ImGuiWindowFlags>?
    ): Boolean = igBeginChildStr(strId, size.toCValue(), border, flags?.value ?: 0)

    actual fun beginChild(
        id: ImGuiID,
        size: Vec2,
        border: Boolean,
        flags: Flag<ImGuiWindowFlags>?
    ): Boolean = igBeginChildID(id.value, size.toCValue(), border, flags?.value ?: 0)

    actual fun beginChildEx(
        name: String,
        id: ImGuiID,
        sizeArg: Vec2,
        border: Boolean,
        flags: Flag<ImGuiWindowFlags>
    ): Boolean = igBeginChildEx(name, id.value, sizeArg.toCValue(), border, flags.value)

    actual fun beginChildFrame(
        id: ImGuiID,
        size: Vec2,
        flags: Flag<ImGuiWindowFlags>?
    ): Boolean = igBeginChildFrame(id.value, size.toCValue(), flags?.value ?: 0)

    actual fun beginColumns(
        strId: String,
        count: Int,
        flags: Flag<ImGuiColumnsFlags>?
    ) {
        igBeginColumns(strId, count, flags?.value ?: 0)
    }

    actual fun beginCombo(
        label: String,
        previewValue: String,
        flags: Flag<ImGuiComboFlags>?
    ): Boolean = igBeginCombo(label, previewValue, flags?.value ?: 0)

    actual fun beginDockableDragDropSource(window: ImGuiWindow) {
        igBeginDockableDragDropSource(window.ptr)
    }

    actual fun beginDockableDragDropTarget(window: ImGuiWindow) {
        igBeginDockableDragDropTarget(window.ptr)
    }

    actual fun beginDocked(window: ImGuiWindow, pOpen: KMutableProperty0<Boolean>) {
        usingProperty(pOpen) { ptrPOpen ->
            igBeginDocked(window.ptr, ptrPOpen)
        }
    }

    actual fun beginDragDropSource(flags: Flag<ImGuiDragDropFlags>?): Boolean =
            igBeginDragDropSource(flags?.value ?: 0)

    actual fun beginDragDropTarget(): Boolean = igBeginDragDropTarget()

    actual fun beginGroup() {
        igBeginGroup()
    }

    actual fun beginMainMenuBar(): Boolean = igBeginMainMenuBar()

    actual fun beginMenu(label: String, enabled: Boolean): Boolean = igBeginMenu(label, enabled)

    actual fun beginMenuBar(): Boolean = igBeginMenuBar()

    actual fun beginPopup(strId: String, flags: Flag<ImGuiWindowFlags>?): Boolean =
            igBeginPopup(strId, flags?.value ?: 0)

    actual fun beginPopupContextItem(strId: String?, mouseButton: ImGuiMouseButton): Boolean =
            igBeginPopupContextItem(strId, mouseButton.value)

    actual fun beginPopupContextVoid(strId: String?, mouseButton: ImGuiMouseButton): Boolean =
            igBeginPopupContextVoid(strId, mouseButton.value)

    actual fun beginPopupContextWindow(
        strId: String?,
        mouseButton: ImGuiMouseButton,
        alsoOverItems: Boolean
    ): Boolean = igBeginPopupContextWindow(strId, mouseButton.value, alsoOverItems)

    actual fun beginPopupEx(id: ImGuiID, extraFlags: Flag<ImGuiWindowFlags>): Boolean =
            igBeginPopupEx(id.value, extraFlags.value)

    actual fun beginPopupModal(
        name: String,
        pOpen: KMutableProperty0<Boolean>?,
        flags: Flag<ImGuiWindowFlags>?
    ): Boolean = usingPropertyN(pOpen) { ptrPOpen ->
        igBeginPopupModal(name, ptrPOpen, flags?.value ?: 0)
    }

    actual fun beginTabBar(strId: String, flags: Flag<ImGuiTabBarFlags>?): Boolean =
            igBeginTabBar(strId, flags?.value ?: 0)

    actual fun beginTabItem(
        label: String,
        pOpen: KMutableProperty0<Boolean>?,
        flags: Flag<ImGuiTabItemFlags>?
    ): Boolean = usingPropertyN(pOpen) { ptrPOpen ->
        igBeginTabItem(label, ptrPOpen, flags?.value ?: 0)
    }

    actual fun beginTooltip() {
        igBeginTooltip()
    }

    actual fun beginTooltipEx(extraFlags: Flag<ImGuiWindowFlags>,
            tooltipFlags: Flag<ImGuiTooltipFlags>) {
        igBeginTooltipEx(extraFlags.value, tooltipFlags.value)
    }

    actual fun bringWindowToDisplayBack(window: ImGuiWindow) {
        igBringWindowToDisplayBack(window.ptr)
    }

    actual fun bringWindowToDisplayFront(window: ImGuiWindow) {
        igBringWindowToDisplayFront(window.ptr)
    }

    actual fun bringWindowToFocusFront(window: ImGuiWindow) {
        igBringWindowToFocusFront(window.ptr)
    }

    actual fun bullet() {
        igBullet()
    }

    actual fun bulletText(fmt: String) {
        igBulletText(fmt)
    }

    actual fun button(label: String, size: Vec2): Boolean = igButton(label, size.toCValue())

    actual fun buttonEx(
        label: String,
        sizeArg: Vec2,
        flags: Flag<ImGuiButtonFlags>?
    ): Boolean = igButtonEx(label, sizeArg.toCValue(), flags?.value ?: 0)

    actual fun calcItemWidth(): Float = igCalcItemWidth()

    actual fun calcListClipping(
        itemsCount: Int,
        itemsHeight: Float,
        outItemsDisplayStart: KMutableProperty0<Int>,
        outItemsDisplayEnd: KMutableProperty0<Int>
    ) {
        usingProperty(outItemsDisplayStart) { ptrOutItemsDisplayStart ->
            usingProperty(outItemsDisplayEnd) { ptrOutItemsDisplayEnd ->
                igCalcListClipping(itemsCount, itemsHeight, ptrOutItemsDisplayStart,
                        ptrOutItemsDisplayEnd)
            }
        }
    }

    actual fun calcTypematicRepeatAmount(
        t0: Float,
        t1: Float,
        repeatDelay: Float,
        repeatRate: Float
    ): Int = igCalcTypematicRepeatAmount(t0, t1, repeatDelay, repeatRate)

    actual fun calcWrapWidthForPos(pos: Vec2, wrapPosX: Float): Float =
            igCalcWrapWidthForPos(pos.toCValue(), wrapPosX)

    actual fun captureKeyboardFromApp(wantCaptureKeyboardValue: Boolean) {
        igCaptureKeyboardFromApp(wantCaptureKeyboardValue)
    }

    actual fun captureMouseFromApp(wantCaptureMouseValue: Boolean) {
        igCaptureMouseFromApp(wantCaptureMouseValue)
    }

    actual fun checkbox(label: String, v: KMutableProperty0<Boolean>): Boolean = usingProperty(v) {
            ptrV ->
        igCheckbox(label, ptrV)
    }

    actual fun checkboxFlags(
        label: String,
        flags: KMutableProperty0<UInt>,
        flagsValue: UInt
    ): Boolean = usingProperty(flags) { ptrFlags ->
        igCheckboxFlags(label, ptrFlags, flagsValue)
    }

    actual fun clearActiveID() {
        igClearActiveID()
    }

    actual fun clearDragDrop() {
        igClearDragDrop()
    }

    actual fun clearIniSettings() {
        igClearIniSettings()
    }

    actual fun closeButton(id: ImGuiID, pos: Vec2): Boolean = igCloseButton(id.value,
            pos.toCValue())

    actual fun closeCurrentPopup() {
        igCloseCurrentPopup()
    }

    actual fun closePopupToLevel(remaining: Int, restoreFocusToWindowUnderPopup: Boolean) {
        igClosePopupToLevel(remaining, restoreFocusToWindowUnderPopup)
    }

    actual fun closePopupsOverWindow(refWindow: ImGuiWindow,
            restoreFocusToWindowUnderPopup: Boolean) {
        igClosePopupsOverWindow(refWindow.ptr, restoreFocusToWindowUnderPopup)
    }

    actual fun collapseButton(
        id: ImGuiID,
        pos: Vec2,
        dockNode: ImGuiDockNode
    ): Boolean = igCollapseButton(id.value, pos.toCValue(), dockNode.ptr)

    actual fun collapsingHeader(label: String, flags: Flag<ImGuiTreeNodeFlags>?): Boolean =
            igCollapsingHeaderTreeNodeFlags(label, flags?.value ?: 0)

    actual fun collapsingHeader(
        label: String,
        pOpen: KMutableProperty0<Boolean>,
        flags: Flag<ImGuiTreeNodeFlags>?
    ): Boolean = usingProperty(pOpen) { ptrPOpen ->
        igCollapsingHeaderBoolPtr(label, ptrPOpen, flags?.value ?: 0)
    }

    actual fun colorButton(
        descId: String,
        col: Vec4,
        flags: Flag<ImGuiColorEditFlags>?,
        size: Vec2
    ): Boolean = igColorButton(descId, col.toCValue(), flags?.value ?: 0, size.toCValue())

    actual fun colorConvertFloat4ToU32(`in`: Vec4): UInt =
            igColorConvertFloat4ToU32(`in`.toCValue()).toUInt()

    actual fun colorConvertHSVtoRGB(
        h: Float,
        s: Float,
        v: Float,
        outR: KMutableProperty0<Float>,
        outG: KMutableProperty0<Float>,
        outB: KMutableProperty0<Float>
    ) {
        usingProperty(outR) { ptrOutR ->
            usingProperty(outG) { ptrOutG ->
                usingProperty(outB) { ptrOutB ->
                    igColorConvertHSVtoRGB(h, s, v, ptrOutR, ptrOutG, ptrOutB)
                }
            }
        }
    }

    actual fun colorConvertRGBtoHSV(
        r: Float,
        g: Float,
        b: Float,
        outH: KMutableProperty0<Float>,
        outS: KMutableProperty0<Float>,
        outV: KMutableProperty0<Float>
    ) {
        usingProperty(outH) { ptrOutH ->
            usingProperty(outS) { ptrOutS ->
                usingProperty(outV) { ptrOutV ->
                    igColorConvertRGBtoHSV(r, g, b, ptrOutH, ptrOutS, ptrOutV)
                }
            }
        }
    }

    actual fun colorEdit3(
        label: String,
        col: FloatArray,
        flags: Flag<ImGuiColorEditFlags>?
    ): Boolean {
        require(col.size >= 3)

        return col.usePinned { pinnedCol ->
            igColorEdit3(label, pinnedCol.addressOf(0), flags?.value ?: 0)
        }
    }

    actual fun colorEdit4(
        label: String,
        col: FloatArray,
        flags: Flag<ImGuiColorEditFlags>?
    ): Boolean {
        require(col.size >= 4)

        return col.usePinned { pinnedCol ->
            igColorEdit4(label, pinnedCol.addressOf(0), flags?.value ?: 0)
        }
    }

    actual fun colorPicker3(
        label: String,
        col: FloatArray,
        flags: Flag<ImGuiColorEditFlags>?
    ): Boolean {
        require(col.size >= 3)

        return col.usePinned { pinnedCol ->
            igColorPicker3(label, pinnedCol.addressOf(0), flags?.value ?: 0)
        }
    }

    actual fun colorPicker4(
        label: String,
        col: FloatArray,
        flags: Flag<ImGuiColorEditFlags>?
    ): Boolean {
        require(col.size >= 4)

        return col.usePinned { pinnedCol ->
            igColorPicker4(label, pinnedCol.addressOf(0), flags?.value ?: 0, null)
        }
    }

    actual fun columns(
        count: Int,
        id: String?,
        border: Boolean
    ) {
        igColumns(count, id, border)
    }

    actual fun combo(
        label: String,
        currentItem: KMutableProperty0<Int>,
        itemsSeparatedByZeros: String,
        popupMaxHeightInItems: Int
    ): Boolean = usingProperty(currentItem) { ptrCurrentItem ->
        igComboStr(label, ptrCurrentItem, itemsSeparatedByZeros, popupMaxHeightInItems)
    }

    actual fun createContext(sharedFontAtlas: ImFontAtlas?): ImGuiContext =
            igCreateContext(sharedFontAtlas?.ptr)!!.let(::ImGuiContext)

    actual fun createNewWindowSettings(name: String): ImGuiWindowSettings =
            igCreateNewWindowSettings(name)!!.let(::ImGuiWindowSettings)

    actual fun dataTypeGetInfo(dataType: ImGuiDataType): ImGuiDataTypeInfo =
            igDataTypeGetInfo(dataType.value)!!.let(::ImGuiDataTypeInfo)

    actual fun debugCheckVersionAndDataLayout(
        versionStr: String,
        szIo: ULong,
        szStyle: ULong,
        szVec2: ULong,
        szVec4: ULong,
        szDrawvert: ULong,
        szDrawidx: ULong
    ): Boolean = igDebugCheckVersionAndDataLayout(versionStr, szIo.convert(), szStyle.convert(),
            szVec2.convert(), szVec4.convert(), szDrawvert.convert(), szDrawidx.convert())

    actual fun debugDrawItemRect(col: UInt) {
        igDebugDrawItemRect(col)
    }

    actual fun debugStartItemPicker() {
        igDebugStartItemPicker()
    }

    actual fun destroyContext(ctx: ImGuiContext?) {
        igDestroyContext(ctx?.ptr)
    }

    actual fun destroyPlatformWindow(viewport: ImGuiViewportP) {
        igDestroyPlatformWindow(viewport.ptr)
    }

    actual fun destroyPlatformWindows() {
        igDestroyPlatformWindows()
    }

    actual fun dockBuilderAddNode(nodeId: ImGuiID, flags: Flag<ImGuiDockNodeFlags>?): ImGuiID =
            igDockBuilderAddNode(nodeId.value, flags?.value ?: 0).let(::ImGuiID)

    actual fun dockBuilderCopyWindowSettings(srcName: String, dstName: String) {
        igDockBuilderCopyWindowSettings(srcName, dstName)
    }

    actual fun dockBuilderDockWindow(windowName: String, nodeId: ImGuiID) {
        igDockBuilderDockWindow(windowName, nodeId.value)
    }

    actual fun dockBuilderFinish(nodeId: ImGuiID) {
        igDockBuilderFinish(nodeId.value)
    }

    actual fun dockBuilderGetCentralNode(nodeId: ImGuiID): ImGuiDockNode =
            igDockBuilderGetCentralNode(nodeId.value)!!.let(::ImGuiDockNode)

    actual fun dockBuilderGetNode(nodeId: ImGuiID): ImGuiDockNode =
            igDockBuilderGetNode(nodeId.value)!!.let(::ImGuiDockNode)

    actual fun dockBuilderRemoveNode(nodeId: ImGuiID) {
        igDockBuilderRemoveNode(nodeId.value)
    }

    actual fun dockBuilderRemoveNodeChildNodes(nodeId: ImGuiID) {
        igDockBuilderRemoveNodeChildNodes(nodeId.value)
    }

    actual fun dockBuilderRemoveNodeDockedWindows(nodeId: ImGuiID, clearSettingsRefs: Boolean) {
        igDockBuilderRemoveNodeDockedWindows(nodeId.value, clearSettingsRefs)
    }

    actual fun dockBuilderSetNodePos(nodeId: ImGuiID, pos: Vec2) {
        igDockBuilderSetNodePos(nodeId.value, pos.toCValue())
    }

    actual fun dockBuilderSetNodeSize(nodeId: ImGuiID, size: Vec2) {
        igDockBuilderSetNodeSize(nodeId.value, size.toCValue())
    }

    actual fun dockContextCalcDropPosForDocking(
        target: ImGuiWindow,
        targetNode: ImGuiDockNode,
        payload: ImGuiWindow,
        splitDir: ImGuiDir,
        splitOuter: Boolean,
        outPos: ImVec2
    ): Boolean = igDockContextCalcDropPosForDocking(target.ptr, targetNode.ptr, payload.ptr,
            splitDir.value, splitOuter, outPos.ptr)

    actual fun dockContextClearNodes(
        ctx: ImGuiContext,
        rootId: ImGuiID,
        clearSettingsRefs: Boolean
    ) {
        igDockContextClearNodes(ctx.ptr, rootId.value, clearSettingsRefs)
    }

    actual fun dockContextGenNodeID(ctx: ImGuiContext): ImGuiID =
            igDockContextGenNodeID(ctx.ptr).let(::ImGuiID)

    actual fun dockContextInitialize(ctx: ImGuiContext) {
        igDockContextInitialize(ctx.ptr)
    }

    actual fun dockContextQueueDock(
        ctx: ImGuiContext,
        target: ImGuiWindow,
        targetNode: ImGuiDockNode,
        payload: ImGuiWindow,
        splitDir: ImGuiDir,
        splitRatio: Float,
        splitOuter: Boolean
    ) {
        igDockContextQueueDock(ctx.ptr, target.ptr, targetNode.ptr, payload.ptr, splitDir.value,
                splitRatio, splitOuter)
    }

    actual fun dockContextQueueUndockNode(ctx: ImGuiContext, node: ImGuiDockNode) {
        igDockContextQueueUndockNode(ctx.ptr, node.ptr)
    }

    actual fun dockContextQueueUndockWindow(ctx: ImGuiContext, window: ImGuiWindow) {
        igDockContextQueueUndockWindow(ctx.ptr, window.ptr)
    }

    actual fun dockContextRebuildNodes(ctx: ImGuiContext) {
        igDockContextRebuildNodes(ctx.ptr)
    }

    actual fun dockContextShutdown(ctx: ImGuiContext) {
        igDockContextShutdown(ctx.ptr)
    }

    actual fun dockContextUpdateDocking(ctx: ImGuiContext) {
        igDockContextUpdateDocking(ctx.ptr)
    }

    actual fun dockContextUpdateUndocking(ctx: ImGuiContext) {
        igDockContextUpdateUndocking(ctx.ptr)
    }

    actual fun dockNodeGetDepth(node: ImGuiDockNode): Int = igDockNodeGetDepth(node.ptr)

    actual fun dockNodeGetRootNode(node: ImGuiDockNode): ImGuiDockNode =
            igDockNodeGetRootNode(node.ptr)!!.let(::ImGuiDockNode)

    actual fun dockSpace(
        id: ImGuiID,
        size: Vec2,
        flags: Flag<ImGuiDockNodeFlags>?,
        windowClass: ImGuiWindowClass?
    ) {
        igDockSpace(id.value, size.toCValue(), flags?.value ?: 0, windowClass?.ptr)
    }

    actual fun dockSpaceOverViewport(
        viewport: ImGuiViewport?,
        flags: Flag<ImGuiDockNodeFlags>?,
        windowClass: ImGuiWindowClass?
    ): ImGuiID = igDockSpaceOverViewport(viewport?.ptr, flags?.value ?: 0,
            windowClass?.ptr).let(::ImGuiID)

    actual fun dragFloat(
        label: String,
        v: KMutableProperty0<Float>,
        vSpeed: Float,
        vMin: Float,
        vMax: Float,
        format: String,
        power: Float
    ): Boolean = usingProperty(v) { ptrV ->
        igDragFloat(label, ptrV, vSpeed, vMin, vMax, format, power)
    }

    actual fun dragFloat2(
        label: String,
        v: FloatArray,
        vSpeed: Float,
        vMin: Float,
        vMax: Float,
        format: String,
        power: Float
    ): Boolean {
        require(v.size >= 2)

        return v.usePinned { pinnedV ->
            igDragFloat2(label, pinnedV.addressOf(0), vSpeed, vMin, vMax, format, power)
        }
    }

    actual fun dragFloat3(
        label: String,
        v: FloatArray,
        vSpeed: Float,
        vMin: Float,
        vMax: Float,
        format: String,
        power: Float
    ): Boolean {
        require(v.size >= 3)

        return v.usePinned { pinnedV ->
            igDragFloat3(label, pinnedV.addressOf(0), vSpeed, vMin, vMax, format, power)
        }
    }

    actual fun dragFloat4(
        label: String,
        v: FloatArray,
        vSpeed: Float,
        vMin: Float,
        vMax: Float,
        format: String,
        power: Float
    ): Boolean {
        require(v.size >= 4)

        return v.usePinned { pinnedV ->
            igDragFloat4(label, pinnedV.addressOf(0), vSpeed, vMin, vMax, format, power)
        }
    }

    actual fun dragFloatRange2(
        label: String,
        vCurrentMin: KMutableProperty0<Float>,
        vCurrentMax: KMutableProperty0<Float>,
        vSpeed: Float,
        vMin: Float,
        vMax: Float,
        format: String,
        formatMax: String?,
        power: Float
    ): Boolean = usingProperty(vCurrentMin) { ptrVCurrentMin ->
        usingProperty(vCurrentMax) { ptrVCurrentMax ->
            igDragFloatRange2(label, ptrVCurrentMin, ptrVCurrentMax, vSpeed, vMin, vMax, format,
                    formatMax, power)
        }
    }

    actual fun dragInt(
        label: String,
        v: KMutableProperty0<Int>,
        vSpeed: Float,
        vMin: Int,
        vMax: Int,
        format: String
    ): Boolean = usingProperty(v) { ptrV ->
        igDragInt(label, ptrV, vSpeed, vMin, vMax, format)
    }

    actual fun dragInt2(
        label: String,
        v: IntArray,
        vSpeed: Float,
        vMin: Int,
        vMax: Int,
        format: String
    ): Boolean {
        require(v.size >= 2)

        return v.usePinned { pinnedV ->
            igDragInt2(label, pinnedV.addressOf(0), vSpeed, vMin, vMax, format)
        }
    }

    actual fun dragInt3(
        label: String,
        v: IntArray,
        vSpeed: Float,
        vMin: Int,
        vMax: Int,
        format: String
    ): Boolean {
        require(v.size >= 3)

        return v.usePinned { pinnedV ->
            igDragInt3(label, pinnedV.addressOf(0), vSpeed, vMin, vMax, format)
        }
    }

    actual fun dragInt4(
        label: String,
        v: IntArray,
        vSpeed: Float,
        vMin: Int,
        vMax: Int,
        format: String
    ): Boolean {
        require(v.size >= 4)

        return v.usePinned { pinnedV ->
            igDragInt4(label, pinnedV.addressOf(0), vSpeed, vMin, vMax, format)
        }
    }

    actual fun dragIntRange2(
        label: String,
        vCurrentMin: KMutableProperty0<Int>,
        vCurrentMax: KMutableProperty0<Int>,
        vSpeed: Float,
        vMin: Int,
        vMax: Int,
        format: String,
        formatMax: String?
    ): Boolean = usingProperty(vCurrentMin) { ptrVCurrentMin ->
        usingProperty(vCurrentMax) { ptrVCurrentMax ->
            igDragIntRange2(label, ptrVCurrentMin, ptrVCurrentMax, vSpeed, vMin, vMax, format,
                    formatMax)
        }
    }

    actual fun dummy(size: Vec2) {
        igDummy(size.toCValue())
    }

    actual fun end() {
        igEnd()
    }

    actual fun endChild() {
        igEndChild()
    }

    actual fun endChildFrame() {
        igEndChildFrame()
    }

    actual fun endColumns() {
        igEndColumns()
    }

    actual fun endCombo() {
        igEndCombo()
    }

    actual fun endDragDropSource() {
        igEndDragDropSource()
    }

    actual fun endDragDropTarget() {
        igEndDragDropTarget()
    }

    actual fun endFrame() {
        igEndFrame()
    }

    actual fun endGroup() {
        igEndGroup()
    }

    actual fun endMainMenuBar() {
        igEndMainMenuBar()
    }

    actual fun endMenu() {
        igEndMenu()
    }

    actual fun endMenuBar() {
        igEndMenuBar()
    }

    actual fun endPopup() {
        igEndPopup()
    }

    actual fun endTabBar() {
        igEndTabBar()
    }

    actual fun endTabItem() {
        igEndTabItem()
    }

    actual fun endTooltip() {
        igEndTooltip()
    }

    actual fun findOrCreateColumns(window: ImGuiWindow, id: ImGuiID): ImGuiColumns =
            igFindOrCreateColumns(window.ptr, id.value)!!.let(::ImGuiColumns)

    actual fun findOrCreateWindowSettings(name: String): ImGuiWindowSettings =
            igFindOrCreateWindowSettings(name)!!.let(::ImGuiWindowSettings)

    actual fun findRenderedTextEnd(text: String, textEnd: String?): String? =
            igFindRenderedTextEnd(text, textEnd)?.toKString()

    actual fun findSettingsHandler(typeName: String): ImGuiSettingsHandler =
            igFindSettingsHandler(typeName)!!.let(::ImGuiSettingsHandler)

    actual fun findViewportByID(id: ImGuiID): ImGuiViewport =
            igFindViewportByID(id.value)!!.let(::ImGuiViewport)

    actual fun findWindowByID(id: ImGuiID): ImGuiWindow =
            igFindWindowByID(id.value)!!.let(::ImGuiWindow)

    actual fun findWindowByName(name: String): ImGuiWindow =
            igFindWindowByName(name)!!.let(::ImGuiWindow)

    actual fun findWindowSettings(id: ImGuiID): ImGuiWindowSettings =
            igFindWindowSettings(id.value)!!.let(::ImGuiWindowSettings)

    actual fun focusTopMostWindowUnderOne(underThisWindow: ImGuiWindow, ignoreWindow: ImGuiWindow) {
        igFocusTopMostWindowUnderOne(underThisWindow.ptr, ignoreWindow.ptr)
    }

    actual fun focusWindow(window: ImGuiWindow) {
        igFocusWindow(window.ptr)
    }

    actual fun focusableItemRegister(window: ImGuiWindow, id: ImGuiID): Boolean =
            igFocusableItemRegister(window.ptr, id.value)

    actual fun focusableItemUnregister(window: ImGuiWindow) {
        igFocusableItemUnregister(window.ptr)
    }

    actual fun gcAwakeTransientWindowBuffers(window: ImGuiWindow) {
        igGcAwakeTransientWindowBuffers(window.ptr)
    }

    actual fun gcCompactTransientWindowBuffers(window: ImGuiWindow) {
        igGcCompactTransientWindowBuffers(window.ptr)
    }

    actual fun getActiveID(): ImGuiID = igGetActiveID().let(::ImGuiID)

    actual fun getBackgroundDrawList(): ImDrawList =
            igGetBackgroundDrawListNil()!!.let(::ImDrawList)

    actual fun getBackgroundDrawList(viewport: ImGuiViewport): ImDrawList =
            igGetBackgroundDrawListViewportPtr(viewport.ptr)!!.let(::ImDrawList)

    actual fun getClipboardText(): String? = igGetClipboardText()?.toKString()

    actual fun getColorU32(idx: ImGuiCol, alphaMul: Float): UInt = igGetColorU32Col(idx.value,
            alphaMul).toUInt()

    actual fun getColorU32(col: Vec4): UInt = igGetColorU32Vec4(col.toCValue()).toUInt()

    actual fun getColorU32(col: UInt): UInt = igGetColorU32U32(col).toUInt()

    actual fun getColumnIndex(): Int = igGetColumnIndex()

    actual fun getColumnNormFromOffset(columns: ImGuiColumns, offset: Float): Float =
            igGetColumnNormFromOffset(columns.ptr, offset)

    actual fun getColumnOffset(columnIndex: Int): Float = igGetColumnOffset(columnIndex)

    actual fun getColumnOffsetFromNorm(columns: ImGuiColumns, offsetNorm: Float): Float =
            igGetColumnOffsetFromNorm(columns.ptr, offsetNorm)

    actual fun getColumnWidth(columnIndex: Int): Float = igGetColumnWidth(columnIndex)

    actual fun getColumnsCount(): Int = igGetColumnsCount()

    actual fun getColumnsID(strId: String, count: Int): ImGuiID = igGetColumnsID(strId,
            count).let(::ImGuiID)

    actual fun getCurrentContext(): ImGuiContext = igGetCurrentContext()!!.let(::ImGuiContext)

    actual fun getCurrentWindow(): ImGuiWindow = igGetCurrentWindow()!!.let(::ImGuiWindow)

    actual fun getCurrentWindowRead(): ImGuiWindow = igGetCurrentWindowRead()!!.let(::ImGuiWindow)

    actual fun getCursorPosX(): Float = igGetCursorPosX()

    actual fun getCursorPosY(): Float = igGetCursorPosY()

    actual fun getDefaultFont(): ImFont = igGetDefaultFont()!!.let(::ImFont)

    actual fun getDragDropPayload(): ImGuiPayload = igGetDragDropPayload()!!.let(::ImGuiPayload)

    actual fun getDrawData(): ImDrawData = igGetDrawData()!!.let(::ImDrawData)

    actual fun getDrawListSharedData(): ImDrawListSharedData =
            igGetDrawListSharedData()!!.let(::ImDrawListSharedData)

    actual fun getFocusID(): ImGuiID = igGetFocusID().let(::ImGuiID)

    actual fun getFocusScopeID(): ImGuiID = igGetFocusScopeID().let(::ImGuiID)

    actual fun getFont(): ImFont = igGetFont()!!.let(::ImFont)

    actual fun getFontSize(): Float = igGetFontSize()

    actual fun getForegroundDrawList(): ImDrawList =
            igGetForegroundDrawListNil()!!.let(::ImDrawList)

    actual fun getForegroundDrawList(viewport: ImGuiViewport): ImDrawList =
            igGetForegroundDrawListViewportPtr(viewport.ptr)!!.let(::ImDrawList)

    actual fun getForegroundDrawList(window: ImGuiWindow): ImDrawList =
            igGetForegroundDrawListWindowPtr(window.ptr)!!.let(::ImDrawList)

    actual fun getFrameCount(): Int = igGetFrameCount()

    actual fun getFrameHeight(): Float = igGetFrameHeight()

    actual fun getFrameHeightWithSpacing(): Float = igGetFrameHeightWithSpacing()

    actual fun getHoveredID(): ImGuiID = igGetHoveredID().let(::ImGuiID)

    actual fun getID(strId: String): ImGuiID = igGetIDStr(strId).let(::ImGuiID)

    actual fun getID(strIdBegin: String, strIdEnd: String): ImGuiID = igGetIDStrStr(strIdBegin,
            strIdEnd).let(::ImGuiID)

    actual fun getIO(): ImGuiIO = igGetIO()!!.let(::ImGuiIO)

    actual fun getInputTextState(id: ImGuiID): ImGuiInputTextState =
            igGetInputTextState(id.value)!!.let(::ImGuiInputTextState)

    actual fun getItemID(): ImGuiID = igGetItemID().let(::ImGuiID)

    actual fun getItemStatusFlags(): Flag<ImGuiItemStatusFlags> = igGetItemStatusFlags().let {
            ImGuiItemStatusFlags.fromMultiple(it) }

    actual fun getKeyIndex(imguiKey: ImGuiKey): Int = igGetKeyIndex(imguiKey.value)

    actual fun getKeyPressedAmount(
        keyIndex: Int,
        repeatDelay: Float,
        rate: Float
    ): Int = igGetKeyPressedAmount(keyIndex, repeatDelay, rate)

    actual fun getMainViewport(): ImGuiViewport = igGetMainViewport()!!.let(::ImGuiViewport)

    actual fun getMergedKeyModFlags(): Flag<ImGuiKeyModFlags> = igGetMergedKeyModFlags().let {
            ImGuiKeyModFlags.fromMultiple(it) }

    actual fun getMouseCursor(): ImGuiMouseCursor = igGetMouseCursor().let {
            ImGuiMouseCursor.from(it) }

    actual fun getPlatformIO(): ImGuiPlatformIO = igGetPlatformIO()!!.let(::ImGuiPlatformIO)

    actual fun getScrollMaxX(): Float = igGetScrollMaxX()

    actual fun getScrollMaxY(): Float = igGetScrollMaxY()

    actual fun getScrollX(): Float = igGetScrollX()

    actual fun getScrollY(): Float = igGetScrollY()

    actual fun getStateStorage(): ImGuiStorage = igGetStateStorage()!!.let(::ImGuiStorage)

    actual fun getStyle(): ImGuiStyle = igGetStyle()!!.let(::ImGuiStyle)

    actual fun getStyleColorName(idx: ImGuiCol): String? =
            igGetStyleColorName(idx.value)?.toKString()

    actual fun getStyleColorVec4(idx: ImGuiCol): ImVec4 =
            igGetStyleColorVec4(idx.value)!!.let(::ImVec4)

    actual fun getTextLineHeight(): Float = igGetTextLineHeight()

    actual fun getTextLineHeightWithSpacing(): Float = igGetTextLineHeightWithSpacing()

    actual fun getTime(): Double = igGetTime()

    actual fun getTopMostPopupModal(): ImGuiWindow = igGetTopMostPopupModal()!!.let(::ImGuiWindow)

    actual fun getTreeNodeToLabelSpacing(): Float = igGetTreeNodeToLabelSpacing()

    actual fun getVersion(): String? = igGetVersion()?.toKString()

    actual fun getWindowAlwaysWantOwnTabBar(window: ImGuiWindow): Boolean =
            igGetWindowAlwaysWantOwnTabBar(window.ptr)

    actual fun getWindowContentRegionWidth(): Float = igGetWindowContentRegionWidth()

    actual fun getWindowDockID(): ImGuiID = igGetWindowDockID().let(::ImGuiID)

    actual fun getWindowDockNode(): ImGuiDockNode = igGetWindowDockNode()!!.let(::ImGuiDockNode)

    actual fun getWindowDpiScale(): Float = igGetWindowDpiScale()

    actual fun getWindowDrawList(): ImDrawList = igGetWindowDrawList()!!.let(::ImDrawList)

    actual fun getWindowHeight(): Float = igGetWindowHeight()

    actual fun getWindowResizeID(window: ImGuiWindow, n: Int): ImGuiID =
            igGetWindowResizeID(window.ptr, n).let(::ImGuiID)

    actual fun getWindowViewport(): ImGuiViewport = igGetWindowViewport()!!.let(::ImGuiViewport)

    actual fun getWindowWidth(): Float = igGetWindowWidth()

    actual fun imAlphaBlendColors(colA: UInt, colB: UInt): UInt = igImAlphaBlendColors(colA,
            colB).toUInt()

    actual fun imCharIsBlankW(c: UInt): Boolean = igImCharIsBlankW(c)

    actual fun imDot(a: Vec2, b: Vec2): Float = igImDot(a.toCValue(), b.toCValue())

    actual fun imFloor(f: Float): Float = igImFloorFloat(f)

    actual fun imFontAtlasBuildFinish(atlas: ImFontAtlas) {
        igImFontAtlasBuildFinish(atlas.ptr)
    }

    actual fun imFontAtlasBuildInit(atlas: ImFontAtlas) {
        igImFontAtlasBuildInit(atlas.ptr)
    }

    actual fun imFontAtlasBuildSetupFont(
        atlas: ImFontAtlas,
        font: ImFont,
        fontConfig: ImFontConfig,
        ascent: Float,
        descent: Float
    ) {
        igImFontAtlasBuildSetupFont(atlas.ptr, font.ptr, fontConfig.ptr, ascent, descent)
    }

    actual fun imFontAtlasBuildWithStbTruetype(atlas: ImFontAtlas): Boolean =
            igImFontAtlasBuildWithStbTruetype(atlas.ptr)

    actual fun imGetDirQuadrantFromDelta(dx: Float, dy: Float): ImGuiDir =
            igImGetDirQuadrantFromDelta(dx, dy).let { ImGuiDir.from(it) }

    actual fun imHashStr(
        data: String,
        dataSize: ULong,
        seed: UInt
    ): UInt = igImHashStr(data, dataSize.convert(), seed).toUInt()

    actual fun imInvLength(lhs: Vec2, failValue: Float): Float = igImInvLength(lhs.toCValue(),
            failValue)

    actual fun imIsPowerOfTwo(v: Int): Boolean = igImIsPowerOfTwo(v)

    actual fun imLengthSqr(lhs: Vec2): Float = igImLengthSqrVec2(lhs.toCValue())

    actual fun imLengthSqr(lhs: Vec4): Float = igImLengthSqrVec4(lhs.toCValue())

    actual fun imLinearSweep(
        current: Float,
        target: Float,
        speed: Float
    ): Float = igImLinearSweep(current, target, speed)

    actual fun imModPositive(a: Int, b: Int): Int = igImModPositive(a, b)

    actual fun imParseFormatFindEnd(format: String): String? =
            igImParseFormatFindEnd(format)?.toKString()

    actual fun imParseFormatFindStart(format: String): String? =
            igImParseFormatFindStart(format)?.toKString()

    actual fun imParseFormatPrecision(format: String, defaultValue: Int): Int =
            igImParseFormatPrecision(format, defaultValue)

    actual fun imPow(x: Float, y: Float): Float = igImPowFloat(x, y)

    actual fun imPow(x: Double, y: Double): Double = igImPowdouble(x, y)

    actual fun imSaturate(f: Float): Float = igImSaturate(f)

    actual fun imStrSkipBlank(str: String): String? = igImStrSkipBlank(str)?.toKString()

    actual fun imStrbolW(bufMidLine: String, bufBegin: String): String =
            igImStrbolW(bufMidLine.wcstr, bufBegin.wcstr)!!.toKString()

    actual fun imStreolRange(str: String, strEnd: String): String? = igImStreolRange(str,
            strEnd)?.toKString()

    actual fun imStricmp(str1: String, str2: String): Int = igImStricmp(str1, str2)

    actual fun imStristr(
        haystack: String,
        haystackEnd: String,
        needle: String,
        needleEnd: String
    ): String? = igImStristr(haystack, haystackEnd, needle, needleEnd)?.toKString()

    actual fun imStrlenW(str: String): Int = igImStrlenW(str.wcstr)

    actual fun imStrnicmp(
        str1: String,
        str2: String,
        count: ULong
    ): Int = igImStrnicmp(str1, str2, count.convert())

    actual fun imTextCharFromUtf8(
        outChar: KMutableProperty0<UInt>,
        inText: String,
        inTextEnd: String
    ): Int = usingProperty(outChar) { ptrOutChar ->
        igImTextCharFromUtf8(ptrOutChar, inText, inTextEnd)
    }

    actual fun imTextCountCharsFromUtf8(inText: String, inTextEnd: String): Int =
            igImTextCountCharsFromUtf8(inText, inTextEnd)

    actual fun imTextCountUtf8BytesFromChar(inText: String, inTextEnd: String): Int =
            igImTextCountUtf8BytesFromChar(inText, inTextEnd)

    actual fun imTextCountUtf8BytesFromStr(inText: String, inTextEnd: String): Int =
            igImTextCountUtf8BytesFromStr(inText.wcstr, inTextEnd.wcstr)

    actual fun imTriangleArea(
        a: Vec2,
        b: Vec2,
        c: Vec2
    ): Float = igImTriangleArea(a.toCValue(), b.toCValue(), c.toCValue())

    actual fun imTriangleContainsPoint(
        a: Vec2,
        b: Vec2,
        c: Vec2,
        p: Vec2
    ): Boolean = igImTriangleContainsPoint(a.toCValue(), b.toCValue(), c.toCValue(), p.toCValue())

    actual fun imUpperPowerOfTwo(v: Int): Int = igImUpperPowerOfTwo(v)

    actual fun image(
        userTextureId: ImTextureID,
        size: Vec2,
        uv0: Vec2,
        uv1: Vec2,
        tintCol: Vec4,
        borderCol: Vec4
    ) {
        igImage(userTextureId.value, size.toCValue(), uv0.toCValue(), uv1.toCValue(),
                tintCol.toCValue(), borderCol.toCValue())
    }

    actual fun imageButton(
        userTextureId: ImTextureID,
        size: Vec2,
        uv0: Vec2,
        uv1: Vec2,
        framePadding: Int,
        bgCol: Vec4,
        tintCol: Vec4
    ): Boolean = igImageButton(userTextureId.value, size.toCValue(), uv0.toCValue(), uv1.toCValue(),
            framePadding, bgCol.toCValue(), tintCol.toCValue())

    actual fun indent(indentW: Float) {
        igIndent(indentW)
    }

    actual fun initialize(context: ImGuiContext) {
        igInitialize(context.ptr)
    }

    actual fun inputDouble(
        label: String,
        v: KMutableProperty0<Double>,
        step: Double,
        stepFast: Double,
        format: String,
        flags: Flag<ImGuiInputTextFlags>?
    ): Boolean = usingProperty(v) { ptrV ->
        igInputDouble(label, ptrV, step, stepFast, format, flags?.value ?: 0)
    }

    actual fun inputFloat(
        label: String,
        v: KMutableProperty0<Float>,
        step: Float,
        stepFast: Float,
        format: String,
        flags: Flag<ImGuiInputTextFlags>?
    ): Boolean = usingProperty(v) { ptrV ->
        igInputFloat(label, ptrV, step, stepFast, format, flags?.value ?: 0)
    }

    actual fun inputFloat2(
        label: String,
        v: FloatArray,
        format: String,
        flags: Flag<ImGuiInputTextFlags>?
    ): Boolean {
        require(v.size >= 2)

        return v.usePinned { pinnedV ->
            igInputFloat2(label, pinnedV.addressOf(0), format, flags?.value ?: 0)
        }
    }

    actual fun inputFloat3(
        label: String,
        v: FloatArray,
        format: String,
        flags: Flag<ImGuiInputTextFlags>?
    ): Boolean {
        require(v.size >= 3)

        return v.usePinned { pinnedV ->
            igInputFloat3(label, pinnedV.addressOf(0), format, flags?.value ?: 0)
        }
    }

    actual fun inputFloat4(
        label: String,
        v: FloatArray,
        format: String,
        flags: Flag<ImGuiInputTextFlags>?
    ): Boolean {
        require(v.size >= 4)

        return v.usePinned { pinnedV ->
            igInputFloat4(label, pinnedV.addressOf(0), format, flags?.value ?: 0)
        }
    }

    actual fun inputInt(
        label: String,
        v: KMutableProperty0<Int>,
        step: Int,
        stepFast: Int,
        flags: Flag<ImGuiInputTextFlags>?
    ): Boolean = usingProperty(v) { ptrV ->
        igInputInt(label, ptrV, step, stepFast, flags?.value ?: 0)
    }

    actual fun inputInt2(
        label: String,
        v: IntArray,
        flags: Flag<ImGuiInputTextFlags>?
    ): Boolean {
        require(v.size >= 2)

        return v.usePinned { pinnedV ->
            igInputInt2(label, pinnedV.addressOf(0), flags?.value ?: 0)
        }
    }

    actual fun inputInt3(
        label: String,
        v: IntArray,
        flags: Flag<ImGuiInputTextFlags>?
    ): Boolean {
        require(v.size >= 3)

        return v.usePinned { pinnedV ->
            igInputInt3(label, pinnedV.addressOf(0), flags?.value ?: 0)
        }
    }

    actual fun inputInt4(
        label: String,
        v: IntArray,
        flags: Flag<ImGuiInputTextFlags>?
    ): Boolean {
        require(v.size >= 4)

        return v.usePinned { pinnedV ->
            igInputInt4(label, pinnedV.addressOf(0), flags?.value ?: 0)
        }
    }

    actual fun invisibleButton(strId: String, size: Vec2): Boolean = igInvisibleButton(strId,
            size.toCValue())

    actual fun isActiveIdUsingKey(key: ImGuiKey): Boolean = igIsActiveIdUsingKey(key.value)

    actual fun isActiveIdUsingNavDir(dir: ImGuiDir): Boolean = igIsActiveIdUsingNavDir(dir.value)

    actual fun isActiveIdUsingNavInput(input: ImGuiNavInput): Boolean =
            igIsActiveIdUsingNavInput(input.value)

    actual fun isAnyItemActive(): Boolean = igIsAnyItemActive()

    actual fun isAnyItemFocused(): Boolean = igIsAnyItemFocused()

    actual fun isAnyItemHovered(): Boolean = igIsAnyItemHovered()

    actual fun isAnyMouseDown(): Boolean = igIsAnyMouseDown()

    actual fun isDragDropPayloadBeingAccepted(): Boolean = igIsDragDropPayloadBeingAccepted()

    actual fun isItemActivated(): Boolean = igIsItemActivated()

    actual fun isItemActive(): Boolean = igIsItemActive()

    actual fun isItemClicked(mouseButton: ImGuiMouseButton): Boolean =
            igIsItemClicked(mouseButton.value)

    actual fun isItemDeactivated(): Boolean = igIsItemDeactivated()

    actual fun isItemDeactivatedAfterEdit(): Boolean = igIsItemDeactivatedAfterEdit()

    actual fun isItemEdited(): Boolean = igIsItemEdited()

    actual fun isItemFocused(): Boolean = igIsItemFocused()

    actual fun isItemHovered(flags: Flag<ImGuiHoveredFlags>?): Boolean =
            igIsItemHovered(flags?.value ?: 0)

    actual fun isItemToggledOpen(): Boolean = igIsItemToggledOpen()

    actual fun isItemToggledSelection(): Boolean = igIsItemToggledSelection()

    actual fun isItemVisible(): Boolean = igIsItemVisible()

    actual fun isKeyDown(userKeyIndex: Int): Boolean = igIsKeyDown(userKeyIndex)

    actual fun isKeyPressed(userKeyIndex: Int, repeat: Boolean): Boolean =
            igIsKeyPressed(userKeyIndex, repeat)

    actual fun isKeyPressedMap(key: ImGuiKey, repeat: Boolean): Boolean =
            igIsKeyPressedMap(key.value, repeat)

    actual fun isKeyReleased(userKeyIndex: Int): Boolean = igIsKeyReleased(userKeyIndex)

    actual fun isMouseClicked(button: ImGuiMouseButton, repeat: Boolean): Boolean =
            igIsMouseClicked(button.value, repeat)

    actual fun isMouseDoubleClicked(button: ImGuiMouseButton): Boolean =
            igIsMouseDoubleClicked(button.value)

    actual fun isMouseDown(button: ImGuiMouseButton): Boolean = igIsMouseDown(button.value)

    actual fun isMouseDragPastThreshold(button: ImGuiMouseButton, lockThreshold: Float): Boolean =
            igIsMouseDragPastThreshold(button.value, lockThreshold)

    actual fun isMouseDragging(button: ImGuiMouseButton, lockThreshold: Float): Boolean =
            igIsMouseDragging(button.value, lockThreshold)

    actual fun isMouseHoveringRect(
        rMin: Vec2,
        rMax: Vec2,
        clip: Boolean
    ): Boolean = igIsMouseHoveringRect(rMin.toCValue(), rMax.toCValue(), clip)

    actual fun isMousePosValid(mousePos: ImVec2?): Boolean = igIsMousePosValid(mousePos?.ptr)

    actual fun isMouseReleased(button: ImGuiMouseButton): Boolean = igIsMouseReleased(button.value)

    actual fun isNavInputDown(n: ImGuiNavInput): Boolean = igIsNavInputDown(n.value)

    actual fun isPopupOpen(strId: String): Boolean = igIsPopupOpenStr(strId)

    actual fun isPopupOpen(id: ImGuiID): Boolean = igIsPopupOpenID(id.value)

    actual fun isRectVisible(size: Vec2): Boolean = igIsRectVisibleNil(size.toCValue())

    actual fun isRectVisible(rectMin: Vec2, rectMax: Vec2): Boolean =
            igIsRectVisibleVec2(rectMin.toCValue(), rectMax.toCValue())

    actual fun isWindowAppearing(): Boolean = igIsWindowAppearing()

    actual fun isWindowChildOf(window: ImGuiWindow, potentialParent: ImGuiWindow): Boolean =
            igIsWindowChildOf(window.ptr, potentialParent.ptr)

    actual fun isWindowCollapsed(): Boolean = igIsWindowCollapsed()

    actual fun isWindowDocked(): Boolean = igIsWindowDocked()

    actual fun isWindowFocused(flags: Flag<ImGuiFocusedFlags>?): Boolean =
            igIsWindowFocused(flags?.value ?: 0)

    actual fun isWindowHovered(flags: Flag<ImGuiHoveredFlags>?): Boolean =
            igIsWindowHovered(flags?.value ?: 0)

    actual fun isWindowNavFocusable(window: ImGuiWindow): Boolean =
            igIsWindowNavFocusable(window.ptr)

    actual fun itemSize(size: Vec2, textBaselineY: Float) {
        igItemSizeVec2(size.toCValue(), textBaselineY)
    }

    actual fun keepAliveID(id: ImGuiID) {
        igKeepAliveID(id.value)
    }

    actual fun labelText(label: String, fmt: String) {
        igLabelText(label, fmt)
    }

    actual fun listBoxFooter() {
        igListBoxFooter()
    }

    actual fun listBoxHeader(label: String, size: Vec2): Boolean = igListBoxHeaderVec2(label,
            size.toCValue())

    actual fun listBoxHeader(
        label: String,
        itemsCount: Int,
        heightInItems: Int
    ): Boolean = igListBoxHeaderInt(label, itemsCount, heightInItems)

    actual fun loadIniSettingsFromDisk(iniFilename: String) {
        igLoadIniSettingsFromDisk(iniFilename)
    }

    actual fun loadIniSettingsFromMemory(iniData: String, iniSize: ULong) {
        igLoadIniSettingsFromMemory(iniData, iniSize.convert())
    }

    actual fun logButtons() {
        igLogButtons()
    }

    actual fun logFinish() {
        igLogFinish()
    }

    actual fun logRenderedText(
        refPos: ImVec2,
        text: String,
        textEnd: String?
    ) {
        igLogRenderedText(refPos.ptr, text, textEnd)
    }

    actual fun logText(fmt: String) {
        igLogText(fmt)
    }

    actual fun logToBuffer(autoOpenDepth: Int) {
        igLogToBuffer(autoOpenDepth)
    }

    actual fun logToClipboard(autoOpenDepth: Int) {
        igLogToClipboard(autoOpenDepth)
    }

    actual fun logToFile(autoOpenDepth: Int, filename: String?) {
        igLogToFile(autoOpenDepth, filename)
    }

    actual fun logToTTY(autoOpenDepth: Int) {
        igLogToTTY(autoOpenDepth)
    }

    actual fun markIniSettingsDirty() {
        igMarkIniSettingsDirtyNil()
    }

    actual fun markIniSettingsDirty(window: ImGuiWindow) {
        igMarkIniSettingsDirtyWindowPtr(window.ptr)
    }

    actual fun markItemEdited(id: ImGuiID) {
        igMarkItemEdited(id.value)
    }

    actual fun menuItem(
        label: String,
        shortcut: String?,
        selected: Boolean,
        enabled: Boolean
    ): Boolean = igMenuItemBool(label, shortcut, selected, enabled)

    actual fun menuItem(
        label: String,
        shortcut: String,
        pSelected: KMutableProperty0<Boolean>,
        enabled: Boolean
    ): Boolean = usingProperty(pSelected) { ptrPSelected ->
        igMenuItemBoolPtr(label, shortcut, ptrPSelected, enabled)
    }

    actual fun navInitWindow(window: ImGuiWindow, forceReinit: Boolean) {
        igNavInitWindow(window.ptr, forceReinit)
    }

    actual fun navMoveRequestButNoResultYet(): Boolean = igNavMoveRequestButNoResultYet()

    actual fun navMoveRequestCancel() {
        igNavMoveRequestCancel()
    }

    actual fun navMoveRequestTryWrapping(window: ImGuiWindow, moveFlags: Flag<ImGuiNavMoveFlags>) {
        igNavMoveRequestTryWrapping(window.ptr, moveFlags.value)
    }

    actual fun newFrame() {
        igNewFrame()
    }

    actual fun newLine() {
        igNewLine()
    }

    actual fun nextColumn() {
        igNextColumn()
    }

    actual fun openPopup(strId: String) {
        igOpenPopup(strId)
    }

    actual fun openPopupEx(id: ImGuiID) {
        igOpenPopupEx(id.value)
    }

    actual fun openPopupOnItemClick(strId: String?, mouseButton: ImGuiMouseButton): Boolean =
            igOpenPopupOnItemClick(strId, mouseButton.value)

    actual fun popAllowKeyboardFocus() {
        igPopAllowKeyboardFocus()
    }

    actual fun popButtonRepeat() {
        igPopButtonRepeat()
    }

    actual fun popClipRect() {
        igPopClipRect()
    }

    actual fun popColumnsBackground() {
        igPopColumnsBackground()
    }

    actual fun popFocusScope() {
        igPopFocusScope()
    }

    actual fun popFont() {
        igPopFont()
    }

    actual fun popID() {
        igPopID()
    }

    actual fun popItemFlag() {
        igPopItemFlag()
    }

    actual fun popItemWidth() {
        igPopItemWidth()
    }

    actual fun popStyleColor(count: Int) {
        igPopStyleColor(count)
    }

    actual fun popStyleVar(count: Int) {
        igPopStyleVar(count)
    }

    actual fun popTextWrapPos() {
        igPopTextWrapPos()
    }

    actual fun progressBar(
        fraction: Float,
        sizeArg: Vec2,
        overlay: String?
    ) {
        igProgressBar(fraction, sizeArg.toCValue(), overlay)
    }

    actual fun pushAllowKeyboardFocus(allowKeyboardFocus: Boolean) {
        igPushAllowKeyboardFocus(allowKeyboardFocus)
    }

    actual fun pushButtonRepeat(repeat: Boolean) {
        igPushButtonRepeat(repeat)
    }

    actual fun pushClipRect(
        clipRectMin: Vec2,
        clipRectMax: Vec2,
        intersectWithCurrentClipRect: Boolean
    ) {
        igPushClipRect(clipRectMin.toCValue(), clipRectMax.toCValue(), intersectWithCurrentClipRect)
    }

    actual fun pushColumnClipRect(columnIndex: Int) {
        igPushColumnClipRect(columnIndex)
    }

    actual fun pushColumnsBackground() {
        igPushColumnsBackground()
    }

    actual fun pushFocusScope(id: ImGuiID) {
        igPushFocusScope(id.value)
    }

    actual fun pushFont(font: ImFont) {
        igPushFont(font.ptr)
    }

    actual fun pushID(strId: String) {
        igPushIDStr(strId)
    }

    actual fun pushID(strIdBegin: String, strIdEnd: String) {
        igPushIDStrStr(strIdBegin, strIdEnd)
    }

    actual fun pushID(intId: Int) {
        igPushIDInt(intId)
    }

    actual fun pushItemFlag(option: Flag<ImGuiItemFlags>, enabled: Boolean) {
        igPushItemFlag(option.value, enabled)
    }

    actual fun pushItemWidth(itemWidth: Float) {
        igPushItemWidth(itemWidth)
    }

    actual fun pushMultiItemsWidths(components: Int, widthFull: Float) {
        igPushMultiItemsWidths(components, widthFull)
    }

    actual fun pushOverrideID(id: ImGuiID) {
        igPushOverrideID(id.value)
    }

    actual fun pushStyleColor(idx: ImGuiCol, col: UInt) {
        igPushStyleColorU32(idx.value, col)
    }

    actual fun pushStyleColor(idx: ImGuiCol, col: Vec4) {
        igPushStyleColorVec4(idx.value, col.toCValue())
    }

    actual fun pushStyleVar(idx: ImGuiStyleVar, `val`: Float) {
        igPushStyleVarFloat(idx.value, `val`)
    }

    actual fun pushStyleVar(idx: ImGuiStyleVar, `val`: Vec2) {
        igPushStyleVarVec2(idx.value, `val`.toCValue())
    }

    actual fun pushTextWrapPos(wrapLocalPosX: Float) {
        igPushTextWrapPos(wrapLocalPosX)
    }

    actual fun radioButton(label: String, active: Boolean): Boolean = igRadioButtonBool(label,
            active)

    actual fun radioButton(
        label: String,
        v: KMutableProperty0<Int>,
        vButton: Int
    ): Boolean = usingProperty(v) { ptrV ->
        igRadioButtonIntPtr(label, ptrV, vButton)
    }

    actual fun render() {
        igRender()
    }

    actual fun renderArrow(
        drawList: ImDrawList,
        pos: Vec2,
        col: UInt,
        dir: ImGuiDir,
        scale: Float
    ) {
        igRenderArrow(drawList.ptr, pos.toCValue(), col, dir.value, scale)
    }

    actual fun renderArrowDockMenu(
        drawList: ImDrawList,
        pMin: Vec2,
        sz: Float,
        col: UInt
    ) {
        igRenderArrowDockMenu(drawList.ptr, pMin.toCValue(), sz, col)
    }

    actual fun renderArrowPointingAt(
        drawList: ImDrawList,
        pos: Vec2,
        halfSz: Vec2,
        direction: ImGuiDir,
        col: UInt
    ) {
        igRenderArrowPointingAt(drawList.ptr, pos.toCValue(), halfSz.toCValue(), direction.value,
                col)
    }

    actual fun renderBullet(
        drawList: ImDrawList,
        pos: Vec2,
        col: UInt
    ) {
        igRenderBullet(drawList.ptr, pos.toCValue(), col)
    }

    actual fun renderCheckMark(
        drawList: ImDrawList,
        pos: Vec2,
        col: UInt,
        sz: Float
    ) {
        igRenderCheckMark(drawList.ptr, pos.toCValue(), col, sz)
    }

    actual fun renderColorRectWithAlphaCheckerboard(
        drawList: ImDrawList,
        pMin: Vec2,
        pMax: Vec2,
        fillCol: UInt,
        gridStep: Float,
        gridOff: Vec2,
        rounding: Float,
        roundingCornersFlags: Int
    ) {
        igRenderColorRectWithAlphaCheckerboard(drawList.ptr, pMin.toCValue(), pMax.toCValue(),
                fillCol, gridStep, gridOff.toCValue(), rounding, roundingCornersFlags)
    }

    actual fun renderFrame(
        pMin: Vec2,
        pMax: Vec2,
        fillCol: UInt,
        border: Boolean,
        rounding: Float
    ) {
        igRenderFrame(pMin.toCValue(), pMax.toCValue(), fillCol, border, rounding)
    }

    actual fun renderFrameBorder(
        pMin: Vec2,
        pMax: Vec2,
        rounding: Float
    ) {
        igRenderFrameBorder(pMin.toCValue(), pMax.toCValue(), rounding)
    }

    actual fun renderMouseCursor(
        drawList: ImDrawList,
        pos: Vec2,
        scale: Float,
        mouseCursor: ImGuiMouseCursor,
        colFill: UInt,
        colBorder: UInt,
        colShadow: UInt
    ) {
        igRenderMouseCursor(drawList.ptr, pos.toCValue(), scale, mouseCursor.value, colFill,
                colBorder, colShadow)
    }

    actual fun renderPlatformWindowsDefault() {
        igRenderPlatformWindowsDefault(null, null)
    }

    actual fun renderText(
        pos: Vec2,
        text: String,
        textEnd: String?,
        hideTextAfterHash: Boolean
    ) {
        igRenderText(pos.toCValue(), text, textEnd, hideTextAfterHash)
    }

    actual fun renderTextClipped(
        posMin: Vec2,
        posMax: Vec2,
        text: String,
        textEnd: String,
        textSizeIfKnown: ImVec2,
        align: Vec2,
        clipRect: ImRect?
    ) {
        igRenderTextClipped(posMin.toCValue(), posMax.toCValue(), text, textEnd,
                textSizeIfKnown.ptr, align.toCValue(), clipRect?.ptr)
    }

    actual fun renderTextClippedEx(
        drawList: ImDrawList,
        posMin: Vec2,
        posMax: Vec2,
        text: String,
        textEnd: String,
        textSizeIfKnown: ImVec2,
        align: Vec2,
        clipRect: ImRect?
    ) {
        igRenderTextClippedEx(drawList.ptr, posMin.toCValue(), posMax.toCValue(), text, textEnd,
                textSizeIfKnown.ptr, align.toCValue(), clipRect?.ptr)
    }

    actual fun renderTextEllipsis(
        drawList: ImDrawList,
        posMin: Vec2,
        posMax: Vec2,
        clipMaxX: Float,
        ellipsisMaxX: Float,
        text: String,
        textEnd: String,
        textSizeIfKnown: ImVec2
    ) {
        igRenderTextEllipsis(drawList.ptr, posMin.toCValue(), posMax.toCValue(), clipMaxX,
                ellipsisMaxX, text, textEnd, textSizeIfKnown.ptr)
    }

    actual fun renderTextWrapped(
        pos: Vec2,
        text: String,
        textEnd: String,
        wrapWidth: Float
    ) {
        igRenderTextWrapped(pos.toCValue(), text, textEnd, wrapWidth)
    }

    actual fun resetMouseDragDelta(button: ImGuiMouseButton) {
        igResetMouseDragDelta(button.value)
    }

    actual fun sameLine(offsetFromStartX: Float, spacing: Float) {
        igSameLine(offsetFromStartX, spacing)
    }

    actual fun saveIniSettingsToDisk(iniFilename: String) {
        igSaveIniSettingsToDisk(iniFilename)
    }

    actual fun saveIniSettingsToMemory(outIniSize: KMutableProperty0<ULong>?): String? =
            usingPropertyN(outIniSize) { ptrOutIniSize ->
        igSaveIniSettingsToMemory(ptrOutIniSize)
    }?.toKString()

    actual fun scaleWindowsInViewport(viewport: ImGuiViewportP, scale: Float) {
        igScaleWindowsInViewport(viewport.ptr, scale)
    }

    actual fun selectable(
        label: String,
        selected: Boolean,
        flags: Flag<ImGuiSelectableFlags>?,
        size: Vec2
    ): Boolean = igSelectableBool(label, selected, flags?.value ?: 0, size.toCValue())

    actual fun selectable(
        label: String,
        pSelected: KMutableProperty0<Boolean>,
        flags: Flag<ImGuiSelectableFlags>?,
        size: Vec2
    ): Boolean = usingProperty(pSelected) { ptrPSelected ->
        igSelectableBoolPtr(label, ptrPSelected, flags?.value ?: 0, size.toCValue())
    }

    actual fun separator() {
        igSeparator()
    }

    actual fun separatorEx(flags: Flag<ImGuiSeparatorFlags>) {
        igSeparatorEx(flags.value)
    }

    actual fun setActiveID(id: ImGuiID, window: ImGuiWindow) {
        igSetActiveID(id.value, window.ptr)
    }

    actual fun setClipboardText(text: String) {
        igSetClipboardText(text)
    }

    actual fun setColorEditOptions(flags: Flag<ImGuiColorEditFlags>) {
        igSetColorEditOptions(flags.value)
    }

    actual fun setColumnOffset(columnIndex: Int, offsetX: Float) {
        igSetColumnOffset(columnIndex, offsetX)
    }

    actual fun setColumnWidth(columnIndex: Int, width: Float) {
        igSetColumnWidth(columnIndex, width)
    }

    actual fun setCurrentContext(ctx: ImGuiContext) {
        igSetCurrentContext(ctx.ptr)
    }

    actual fun setCurrentFont(font: ImFont) {
        igSetCurrentFont(font.ptr)
    }

    actual fun setCursorPos(localPos: Vec2) {
        igSetCursorPos(localPos.toCValue())
    }

    actual fun setCursorPosX(localX: Float) {
        igSetCursorPosX(localX)
    }

    actual fun setCursorPosY(localY: Float) {
        igSetCursorPosY(localY)
    }

    actual fun setCursorScreenPos(pos: Vec2) {
        igSetCursorScreenPos(pos.toCValue())
    }

    actual fun setFocusID(id: ImGuiID, window: ImGuiWindow) {
        igSetFocusID(id.value, window.ptr)
    }

    actual fun setHoveredID(id: ImGuiID) {
        igSetHoveredID(id.value)
    }

    actual fun setItemAllowOverlap() {
        igSetItemAllowOverlap()
    }

    actual fun setItemDefaultFocus() {
        igSetItemDefaultFocus()
    }

    actual fun setKeyboardFocusHere(offset: Int) {
        igSetKeyboardFocusHere(offset)
    }

    actual fun setMouseCursor(cursorType: ImGuiMouseCursor) {
        igSetMouseCursor(cursorType.value)
    }

    actual fun setNavID(
        id: ImGuiID,
        navLayer: Int,
        focusScopeId: ImGuiID
    ) {
        igSetNavID(id.value, navLayer, focusScopeId.value)
    }

    actual fun setNextItemOpen(isOpen: Boolean, cond: Flag<ImGuiCond>?) {
        igSetNextItemOpen(isOpen, cond?.value ?: 0)
    }

    actual fun setNextItemWidth(itemWidth: Float) {
        igSetNextItemWidth(itemWidth)
    }

    actual fun setNextWindowBgAlpha(alpha: Float) {
        igSetNextWindowBgAlpha(alpha)
    }

    actual fun setNextWindowClass(windowClass: ImGuiWindowClass) {
        igSetNextWindowClass(windowClass.ptr)
    }

    actual fun setNextWindowCollapsed(collapsed: Boolean, cond: Flag<ImGuiCond>?) {
        igSetNextWindowCollapsed(collapsed, cond?.value ?: 0)
    }

    actual fun setNextWindowContentSize(size: Vec2) {
        igSetNextWindowContentSize(size.toCValue())
    }

    actual fun setNextWindowDockID(dockId: ImGuiID, cond: Flag<ImGuiCond>?) {
        igSetNextWindowDockID(dockId.value, cond?.value ?: 0)
    }

    actual fun setNextWindowFocus() {
        igSetNextWindowFocus()
    }

    actual fun setNextWindowPos(
        pos: Vec2,
        cond: Flag<ImGuiCond>?,
        pivot: Vec2
    ) {
        igSetNextWindowPos(pos.toCValue(), cond?.value ?: 0, pivot.toCValue())
    }

    actual fun setNextWindowScroll(scroll: Vec2) {
        igSetNextWindowScroll(scroll.toCValue())
    }

    actual fun setNextWindowSize(size: Vec2, cond: Flag<ImGuiCond>?) {
        igSetNextWindowSize(size.toCValue(), cond?.value ?: 0)
    }

    actual fun setNextWindowViewport(viewportId: ImGuiID) {
        igSetNextWindowViewport(viewportId.value)
    }

    actual fun setScrollFromPosX(localX: Float, centerXRatio: Float) {
        igSetScrollFromPosXFloat(localX, centerXRatio)
    }

    actual fun setScrollFromPosX(
        window: ImGuiWindow,
        localX: Float,
        centerXRatio: Float
    ) {
        igSetScrollFromPosXWindowPtr(window.ptr, localX, centerXRatio)
    }

    actual fun setScrollFromPosY(localY: Float, centerYRatio: Float) {
        igSetScrollFromPosYFloat(localY, centerYRatio)
    }

    actual fun setScrollFromPosY(
        window: ImGuiWindow,
        localY: Float,
        centerYRatio: Float
    ) {
        igSetScrollFromPosYWindowPtr(window.ptr, localY, centerYRatio)
    }

    actual fun setScrollHereX(centerXRatio: Float) {
        igSetScrollHereX(centerXRatio)
    }

    actual fun setScrollHereY(centerYRatio: Float) {
        igSetScrollHereY(centerYRatio)
    }

    actual fun setScrollX(scrollX: Float) {
        igSetScrollXFloat(scrollX)
    }

    actual fun setScrollX(window: ImGuiWindow, newScrollX: Float) {
        igSetScrollXWindowPtr(window.ptr, newScrollX)
    }

    actual fun setScrollY(scrollY: Float) {
        igSetScrollYFloat(scrollY)
    }

    actual fun setScrollY(window: ImGuiWindow, newScrollY: Float) {
        igSetScrollYWindowPtr(window.ptr, newScrollY)
    }

    actual fun setStateStorage(storage: ImGuiStorage) {
        igSetStateStorage(storage.ptr)
    }

    actual fun setTabItemClosed(tabOrDockedWindowLabel: String) {
        igSetTabItemClosed(tabOrDockedWindowLabel)
    }

    actual fun setTooltip(fmt: String) {
        igSetTooltip(fmt)
    }

    actual fun setWindowCollapsed(collapsed: Boolean, cond: Flag<ImGuiCond>?) {
        igSetWindowCollapsedBool(collapsed, cond?.value ?: 0)
    }

    actual fun setWindowCollapsed(
        name: String,
        collapsed: Boolean,
        cond: Flag<ImGuiCond>?
    ) {
        igSetWindowCollapsedStr(name, collapsed, cond?.value ?: 0)
    }

    actual fun setWindowCollapsed(
        window: ImGuiWindow,
        collapsed: Boolean,
        cond: Flag<ImGuiCond>?
    ) {
        igSetWindowCollapsedWindowPtr(window.ptr, collapsed, cond?.value ?: 0)
    }

    actual fun setWindowDock(
        window: ImGuiWindow,
        dockId: ImGuiID,
        cond: Flag<ImGuiCond>
    ) {
        igSetWindowDock(window.ptr, dockId.value, cond.value)
    }

    actual fun setWindowFocus() {
        igSetWindowFocusNil()
    }

    actual fun setWindowFocus(name: String) {
        igSetWindowFocusStr(name)
    }

    actual fun setWindowFontScale(scale: Float) {
        igSetWindowFontScale(scale)
    }

    actual fun setWindowHitTestHole(
        window: ImGuiWindow,
        pos: Vec2,
        size: Vec2
    ) {
        igSetWindowHitTestHole(window.ptr, pos.toCValue(), size.toCValue())
    }

    actual fun setWindowPos(pos: Vec2, cond: Flag<ImGuiCond>?) {
        igSetWindowPosVec2(pos.toCValue(), cond?.value ?: 0)
    }

    actual fun setWindowPos(
        name: String,
        pos: Vec2,
        cond: Flag<ImGuiCond>?
    ) {
        igSetWindowPosStr(name, pos.toCValue(), cond?.value ?: 0)
    }

    actual fun setWindowPos(
        window: ImGuiWindow,
        pos: Vec2,
        cond: Flag<ImGuiCond>?
    ) {
        igSetWindowPosWindowPtr(window.ptr, pos.toCValue(), cond?.value ?: 0)
    }

    actual fun setWindowSize(size: Vec2, cond: Flag<ImGuiCond>?) {
        igSetWindowSizeVec2(size.toCValue(), cond?.value ?: 0)
    }

    actual fun setWindowSize(
        name: String,
        size: Vec2,
        cond: Flag<ImGuiCond>?
    ) {
        igSetWindowSizeStr(name, size.toCValue(), cond?.value ?: 0)
    }

    actual fun setWindowSize(
        window: ImGuiWindow,
        size: Vec2,
        cond: Flag<ImGuiCond>?
    ) {
        igSetWindowSizeWindowPtr(window.ptr, size.toCValue(), cond?.value ?: 0)
    }

    actual fun shadeVertsLinearColorGradientKeepAlpha(
        drawList: ImDrawList,
        vertStartIdx: Int,
        vertEndIdx: Int,
        gradientP0: Vec2,
        gradientP1: Vec2,
        col0: UInt,
        col1: UInt
    ) {
        igShadeVertsLinearColorGradientKeepAlpha(drawList.ptr, vertStartIdx, vertEndIdx,
                gradientP0.toCValue(), gradientP1.toCValue(), col0, col1)
    }

    actual fun shadeVertsLinearUV(
        drawList: ImDrawList,
        vertStartIdx: Int,
        vertEndIdx: Int,
        a: Vec2,
        b: Vec2,
        uvA: Vec2,
        uvB: Vec2,
        clamp: Boolean
    ) {
        igShadeVertsLinearUV(drawList.ptr, vertStartIdx, vertEndIdx, a.toCValue(), b.toCValue(),
                uvA.toCValue(), uvB.toCValue(), clamp)
    }

    actual fun showAboutWindow(pOpen: KMutableProperty0<Boolean>?) {
        usingPropertyN(pOpen) { ptrPOpen ->
            igShowAboutWindow(ptrPOpen)
        }
    }

    actual fun showDemoWindow(pOpen: KMutableProperty0<Boolean>?) {
        usingPropertyN(pOpen) { ptrPOpen ->
            igShowDemoWindow(ptrPOpen)
        }
    }

    actual fun showFontSelector(label: String) {
        igShowFontSelector(label)
    }

    actual fun showMetricsWindow(pOpen: KMutableProperty0<Boolean>?) {
        usingPropertyN(pOpen) { ptrPOpen ->
            igShowMetricsWindow(ptrPOpen)
        }
    }

    actual fun showStyleEditor(ref: ImGuiStyle?) {
        igShowStyleEditor(ref?.ptr)
    }

    actual fun showStyleSelector(label: String): Boolean = igShowStyleSelector(label)

    actual fun showUserGuide() {
        igShowUserGuide()
    }

    actual fun showViewportThumbnails() {
        igShowViewportThumbnails()
    }

    actual fun shrinkWidths(
        items: ImGuiShrinkWidthItem,
        count: Int,
        widthExcess: Float
    ) {
        igShrinkWidths(items.ptr, count, widthExcess)
    }

    actual fun shutdown(context: ImGuiContext) {
        igShutdown(context.ptr)
    }

    actual fun sliderAngle(
        label: String,
        vRad: KMutableProperty0<Float>,
        vDegreesMin: Float,
        vDegreesMax: Float,
        format: String
    ): Boolean = usingProperty(vRad) { ptrVRad ->
        igSliderAngle(label, ptrVRad, vDegreesMin, vDegreesMax, format)
    }

    actual fun sliderFloat(
        label: String,
        v: KMutableProperty0<Float>,
        vMin: Float,
        vMax: Float,
        format: String,
        power: Float
    ): Boolean = usingProperty(v) { ptrV ->
        igSliderFloat(label, ptrV, vMin, vMax, format, power)
    }

    actual fun sliderFloat2(
        label: String,
        v: FloatArray,
        vMin: Float,
        vMax: Float,
        format: String,
        power: Float
    ): Boolean {
        require(v.size >= 2)

        return v.usePinned { pinnedV ->
            igSliderFloat2(label, pinnedV.addressOf(0), vMin, vMax, format, power)
        }
    }

    actual fun sliderFloat3(
        label: String,
        v: FloatArray,
        vMin: Float,
        vMax: Float,
        format: String,
        power: Float
    ): Boolean {
        require(v.size >= 3)

        return v.usePinned { pinnedV ->
            igSliderFloat3(label, pinnedV.addressOf(0), vMin, vMax, format, power)
        }
    }

    actual fun sliderFloat4(
        label: String,
        v: FloatArray,
        vMin: Float,
        vMax: Float,
        format: String,
        power: Float
    ): Boolean {
        require(v.size >= 4)

        return v.usePinned { pinnedV ->
            igSliderFloat4(label, pinnedV.addressOf(0), vMin, vMax, format, power)
        }
    }

    actual fun sliderInt(
        label: String,
        v: KMutableProperty0<Int>,
        vMin: Int,
        vMax: Int,
        format: String
    ): Boolean = usingProperty(v) { ptrV ->
        igSliderInt(label, ptrV, vMin, vMax, format)
    }

    actual fun sliderInt2(
        label: String,
        v: IntArray,
        vMin: Int,
        vMax: Int,
        format: String
    ): Boolean {
        require(v.size >= 2)

        return v.usePinned { pinnedV ->
            igSliderInt2(label, pinnedV.addressOf(0), vMin, vMax, format)
        }
    }

    actual fun sliderInt3(
        label: String,
        v: IntArray,
        vMin: Int,
        vMax: Int,
        format: String
    ): Boolean {
        require(v.size >= 3)

        return v.usePinned { pinnedV ->
            igSliderInt3(label, pinnedV.addressOf(0), vMin, vMax, format)
        }
    }

    actual fun sliderInt4(
        label: String,
        v: IntArray,
        vMin: Int,
        vMax: Int,
        format: String
    ): Boolean {
        require(v.size >= 4)

        return v.usePinned { pinnedV ->
            igSliderInt4(label, pinnedV.addressOf(0), vMin, vMax, format)
        }
    }

    actual fun smallButton(label: String): Boolean = igSmallButton(label)

    actual fun spacing() {
        igSpacing()
    }

    actual fun startMouseMovingWindow(window: ImGuiWindow) {
        igStartMouseMovingWindow(window.ptr)
    }

    actual fun startMouseMovingWindowOrNode(
        window: ImGuiWindow,
        node: ImGuiDockNode,
        undockFloatingNode: Boolean
    ) {
        igStartMouseMovingWindowOrNode(window.ptr, node.ptr, undockFloatingNode)
    }

    actual fun styleColorsClassic(dst: ImGuiStyle?) {
        igStyleColorsClassic(dst?.ptr)
    }

    actual fun styleColorsDark(dst: ImGuiStyle?) {
        igStyleColorsDark(dst?.ptr)
    }

    actual fun styleColorsLight(dst: ImGuiStyle?) {
        igStyleColorsLight(dst?.ptr)
    }

    actual fun tabBarAddTab(
        tabBar: ImGuiTabBar,
        tabFlags: Flag<ImGuiTabItemFlags>,
        window: ImGuiWindow
    ) {
        igTabBarAddTab(tabBar.ptr, tabFlags.value, window.ptr)
    }

    actual fun tabBarCloseTab(tabBar: ImGuiTabBar, tab: ImGuiTabItem) {
        igTabBarCloseTab(tabBar.ptr, tab.ptr)
    }

    actual fun tabBarFindMostRecentlySelectedTabForActiveWindow(tabBar: ImGuiTabBar): ImGuiTabItem =
            igTabBarFindMostRecentlySelectedTabForActiveWindow(tabBar.ptr)!!.let(::ImGuiTabItem)

    actual fun tabBarFindTabByID(tabBar: ImGuiTabBar, tabId: ImGuiID): ImGuiTabItem =
            igTabBarFindTabByID(tabBar.ptr, tabId.value)!!.let(::ImGuiTabItem)

    actual fun tabBarQueueChangeTabOrder(
        tabBar: ImGuiTabBar,
        tab: ImGuiTabItem,
        dir: Int
    ) {
        igTabBarQueueChangeTabOrder(tabBar.ptr, tab.ptr, dir)
    }

    actual fun tabBarRemoveTab(tabBar: ImGuiTabBar, tabId: ImGuiID) {
        igTabBarRemoveTab(tabBar.ptr, tabId.value)
    }

    actual fun tabItemEx(
        tabBar: ImGuiTabBar,
        label: String,
        pOpen: KMutableProperty0<Boolean>,
        flags: Flag<ImGuiTabItemFlags>,
        dockedWindow: ImGuiWindow
    ): Boolean = usingProperty(pOpen) { ptrPOpen ->
        igTabItemEx(tabBar.ptr, label, ptrPOpen, flags.value, dockedWindow.ptr)
    }

    actual fun tempInputIsActive(id: ImGuiID): Boolean = igTempInputIsActive(id.value)

    actual fun text(fmt: String) {
        igText(fmt)
    }

    actual fun textColored(col: Vec4, fmt: String) {
        igTextColored(col.toCValue(), fmt)
    }

    actual fun textDisabled(fmt: String) {
        igTextDisabled(fmt)
    }

    actual fun textEx(
        text: String,
        textEnd: String?,
        flags: Flag<ImGuiTextFlags>?
    ) {
        igTextEx(text, textEnd, flags?.value ?: 0)
    }

    actual fun textUnformatted(text: String, textEnd: String?) {
        igTextUnformatted(text, textEnd)
    }

    actual fun textWrapped(fmt: String) {
        igTextWrapped(fmt)
    }

    actual fun translateWindowsInViewport(
        viewport: ImGuiViewportP,
        oldPos: Vec2,
        newPos: Vec2
    ) {
        igTranslateWindowsInViewport(viewport.ptr, oldPos.toCValue(), newPos.toCValue())
    }

    actual fun treeNode(label: String): Boolean = igTreeNodeStr(label)

    actual fun treeNode(strId: String, fmt: String): Boolean = igTreeNodeStrStr(strId, fmt)

    actual fun treeNodeBehavior(
        id: ImGuiID,
        flags: Flag<ImGuiTreeNodeFlags>,
        label: String,
        labelEnd: String?
    ): Boolean = igTreeNodeBehavior(id.value, flags.value, label, labelEnd)

    actual fun treeNodeBehaviorIsOpen(id: ImGuiID, flags: Flag<ImGuiTreeNodeFlags>?): Boolean =
            igTreeNodeBehaviorIsOpen(id.value, flags?.value ?: 0)

    actual fun treeNodeEx(label: String, flags: Flag<ImGuiTreeNodeFlags>?): Boolean =
            igTreeNodeExStr(label, flags?.value ?: 0)

    actual fun treeNodeEx(
        strId: String,
        flags: Flag<ImGuiTreeNodeFlags>,
        fmt: String
    ): Boolean = igTreeNodeExStrStr(strId, flags.value, fmt)

    actual fun treePop() {
        igTreePop()
    }

    actual fun treePush(strId: String) {
        igTreePushStr(strId)
    }

    actual fun treePush() {
        igTreePushPtr(null)
    }

    actual fun treePushOverrideID(id: ImGuiID) {
        igTreePushOverrideID(id.value)
    }

    actual fun unindent(indentW: Float) {
        igUnindent(indentW)
    }

    actual fun updateHoveredWindowAndCaptureFlags() {
        igUpdateHoveredWindowAndCaptureFlags()
    }

    actual fun updateMouseMovingWindowEndFrame() {
        igUpdateMouseMovingWindowEndFrame()
    }

    actual fun updateMouseMovingWindowNewFrame() {
        igUpdateMouseMovingWindowNewFrame()
    }

    actual fun updatePlatformWindows() {
        igUpdatePlatformWindows()
    }

    actual fun updateWindowParentAndRootLinks(
        window: ImGuiWindow,
        flags: Flag<ImGuiWindowFlags>,
        parentWindow: ImGuiWindow
    ) {
        igUpdateWindowParentAndRootLinks(window.ptr, flags.value, parentWindow.ptr)
    }

    actual fun vSliderFloat(
        label: String,
        size: Vec2,
        v: KMutableProperty0<Float>,
        vMin: Float,
        vMax: Float,
        format: String,
        power: Float
    ): Boolean = usingProperty(v) { ptrV ->
        igVSliderFloat(label, size.toCValue(), ptrV, vMin, vMax, format, power)
    }

    actual fun vSliderInt(
        label: String,
        size: Vec2,
        v: KMutableProperty0<Int>,
        vMin: Int,
        vMax: Int,
        format: String
    ): Boolean = usingProperty(v) { ptrV ->
        igVSliderInt(label, size.toCValue(), ptrV, vMin, vMax, format)
    }

    actual fun value(prefix: String, b: Boolean) {
        igValueBool(prefix, b)
    }

    actual fun value(prefix: String, v: Int) {
        igValueInt(prefix, v)
    }

    actual fun value(prefix: String, v: UInt) {
        igValueUint(prefix, v)
    }

    actual fun value(
        prefix: String,
        v: Float,
        floatFormat: String?
    ) {
        igValueFloat(prefix, v, floatFormat)
    }
}
