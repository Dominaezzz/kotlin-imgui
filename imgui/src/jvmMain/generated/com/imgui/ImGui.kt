package com.imgui

import cimgui.internal.CImGui.igAcceptDragDropPayload
import cimgui.internal.CImGui.igActivateItem
import cimgui.internal.CImGui.igAlignTextToFramePadding
import cimgui.internal.CImGui.igArrowButton
import cimgui.internal.CImGui.igArrowButtonEx
import cimgui.internal.CImGui.igBegin
import cimgui.internal.CImGui.igBeginChildEx
import cimgui.internal.CImGui.igBeginChildFrame
import cimgui.internal.CImGui.igBeginChildID
import cimgui.internal.CImGui.igBeginChildStr
import cimgui.internal.CImGui.igBeginColumns
import cimgui.internal.CImGui.igBeginCombo
import cimgui.internal.CImGui.igBeginDragDropSource
import cimgui.internal.CImGui.igBeginDragDropTarget
import cimgui.internal.CImGui.igBeginGroup
import cimgui.internal.CImGui.igBeginMainMenuBar
import cimgui.internal.CImGui.igBeginMenu
import cimgui.internal.CImGui.igBeginMenuBar
import cimgui.internal.CImGui.igBeginPopup
import cimgui.internal.CImGui.igBeginPopupContextItem
import cimgui.internal.CImGui.igBeginPopupContextVoid
import cimgui.internal.CImGui.igBeginPopupContextWindow
import cimgui.internal.CImGui.igBeginPopupEx
import cimgui.internal.CImGui.igBeginPopupModal
import cimgui.internal.CImGui.igBeginTabBar
import cimgui.internal.CImGui.igBeginTabItem
import cimgui.internal.CImGui.igBeginTooltip
import cimgui.internal.CImGui.igBeginTooltipEx
import cimgui.internal.CImGui.igBringWindowToDisplayBack
import cimgui.internal.CImGui.igBringWindowToDisplayFront
import cimgui.internal.CImGui.igBringWindowToFocusFront
import cimgui.internal.CImGui.igBullet
import cimgui.internal.CImGui.igBulletText
import cimgui.internal.CImGui.igButton
import cimgui.internal.CImGui.igButtonEx
import cimgui.internal.CImGui.igCalcItemWidth
import cimgui.internal.CImGui.igCalcListClipping
import cimgui.internal.CImGui.igCalcTypematicRepeatAmount
import cimgui.internal.CImGui.igCalcWrapWidthForPos
import cimgui.internal.CImGui.igCaptureKeyboardFromApp
import cimgui.internal.CImGui.igCaptureMouseFromApp
import cimgui.internal.CImGui.igCheckbox
import cimgui.internal.CImGui.igCheckboxFlags
import cimgui.internal.CImGui.igClearActiveID
import cimgui.internal.CImGui.igClearDragDrop
import cimgui.internal.CImGui.igClearIniSettings
import cimgui.internal.CImGui.igCloseButton
import cimgui.internal.CImGui.igCloseCurrentPopup
import cimgui.internal.CImGui.igClosePopupToLevel
import cimgui.internal.CImGui.igClosePopupsOverWindow
import cimgui.internal.CImGui.igCollapseButton
import cimgui.internal.CImGui.igCollapsingHeaderBoolPtr
import cimgui.internal.CImGui.igCollapsingHeaderTreeNodeFlags
import cimgui.internal.CImGui.igColorButton
import cimgui.internal.CImGui.igColorConvertFloat4ToU32
import cimgui.internal.CImGui.igColorConvertHSVtoRGB
import cimgui.internal.CImGui.igColorConvertRGBtoHSV
import cimgui.internal.CImGui.igColorEdit3
import cimgui.internal.CImGui.igColorEdit4
import cimgui.internal.CImGui.igColorPicker3
import cimgui.internal.CImGui.igColorPicker4
import cimgui.internal.CImGui.igColumns
import cimgui.internal.CImGui.igComboStr
import cimgui.internal.CImGui.igCreateContext
import cimgui.internal.CImGui.igCreateNewWindowSettings
import cimgui.internal.CImGui.igDataTypeGetInfo
import cimgui.internal.CImGui.igDebugCheckVersionAndDataLayout
import cimgui.internal.CImGui.igDebugDrawItemRect
import cimgui.internal.CImGui.igDebugStartItemPicker
import cimgui.internal.CImGui.igDestroyContext
import cimgui.internal.CImGui.igDragFloat
import cimgui.internal.CImGui.igDragFloat2
import cimgui.internal.CImGui.igDragFloat3
import cimgui.internal.CImGui.igDragFloat4
import cimgui.internal.CImGui.igDragFloatRange2
import cimgui.internal.CImGui.igDragInt
import cimgui.internal.CImGui.igDragInt2
import cimgui.internal.CImGui.igDragInt3
import cimgui.internal.CImGui.igDragInt4
import cimgui.internal.CImGui.igDragIntRange2
import cimgui.internal.CImGui.igDummy
import cimgui.internal.CImGui.igEnd
import cimgui.internal.CImGui.igEndChild
import cimgui.internal.CImGui.igEndChildFrame
import cimgui.internal.CImGui.igEndColumns
import cimgui.internal.CImGui.igEndCombo
import cimgui.internal.CImGui.igEndDragDropSource
import cimgui.internal.CImGui.igEndDragDropTarget
import cimgui.internal.CImGui.igEndFrame
import cimgui.internal.CImGui.igEndGroup
import cimgui.internal.CImGui.igEndMainMenuBar
import cimgui.internal.CImGui.igEndMenu
import cimgui.internal.CImGui.igEndMenuBar
import cimgui.internal.CImGui.igEndPopup
import cimgui.internal.CImGui.igEndTabBar
import cimgui.internal.CImGui.igEndTabItem
import cimgui.internal.CImGui.igEndTooltip
import cimgui.internal.CImGui.igFindOrCreateColumns
import cimgui.internal.CImGui.igFindOrCreateWindowSettings
import cimgui.internal.CImGui.igFindRenderedTextEnd
import cimgui.internal.CImGui.igFindSettingsHandler
import cimgui.internal.CImGui.igFindWindowByID
import cimgui.internal.CImGui.igFindWindowByName
import cimgui.internal.CImGui.igFindWindowSettings
import cimgui.internal.CImGui.igFocusTopMostWindowUnderOne
import cimgui.internal.CImGui.igFocusWindow
import cimgui.internal.CImGui.igFocusableItemRegister
import cimgui.internal.CImGui.igFocusableItemUnregister
import cimgui.internal.CImGui.igGcAwakeTransientWindowBuffers
import cimgui.internal.CImGui.igGcCompactTransientWindowBuffers
import cimgui.internal.CImGui.igGetActiveID
import cimgui.internal.CImGui.igGetBackgroundDrawList
import cimgui.internal.CImGui.igGetClipboardText
import cimgui.internal.CImGui.igGetColorU32Col
import cimgui.internal.CImGui.igGetColorU32U32
import cimgui.internal.CImGui.igGetColorU32Vec4
import cimgui.internal.CImGui.igGetColumnIndex
import cimgui.internal.CImGui.igGetColumnNormFromOffset
import cimgui.internal.CImGui.igGetColumnOffset
import cimgui.internal.CImGui.igGetColumnOffsetFromNorm
import cimgui.internal.CImGui.igGetColumnWidth
import cimgui.internal.CImGui.igGetColumnsCount
import cimgui.internal.CImGui.igGetColumnsID
import cimgui.internal.CImGui.igGetCurrentContext
import cimgui.internal.CImGui.igGetCurrentWindow
import cimgui.internal.CImGui.igGetCurrentWindowRead
import cimgui.internal.CImGui.igGetCursorPosX
import cimgui.internal.CImGui.igGetCursorPosY
import cimgui.internal.CImGui.igGetDefaultFont
import cimgui.internal.CImGui.igGetDragDropPayload
import cimgui.internal.CImGui.igGetDrawData
import cimgui.internal.CImGui.igGetDrawListSharedData
import cimgui.internal.CImGui.igGetFocusID
import cimgui.internal.CImGui.igGetFocusScopeID
import cimgui.internal.CImGui.igGetFont
import cimgui.internal.CImGui.igGetFontSize
import cimgui.internal.CImGui.igGetForegroundDrawListNil
import cimgui.internal.CImGui.igGetForegroundDrawListWindowPtr
import cimgui.internal.CImGui.igGetFrameCount
import cimgui.internal.CImGui.igGetFrameHeight
import cimgui.internal.CImGui.igGetFrameHeightWithSpacing
import cimgui.internal.CImGui.igGetHoveredID
import cimgui.internal.CImGui.igGetIDStr
import cimgui.internal.CImGui.igGetIDStrStr
import cimgui.internal.CImGui.igGetIO
import cimgui.internal.CImGui.igGetInputTextState
import cimgui.internal.CImGui.igGetItemID
import cimgui.internal.CImGui.igGetItemStatusFlags
import cimgui.internal.CImGui.igGetKeyIndex
import cimgui.internal.CImGui.igGetKeyPressedAmount
import cimgui.internal.CImGui.igGetMergedKeyModFlags
import cimgui.internal.CImGui.igGetMouseCursor
import cimgui.internal.CImGui.igGetScrollMaxX
import cimgui.internal.CImGui.igGetScrollMaxY
import cimgui.internal.CImGui.igGetScrollX
import cimgui.internal.CImGui.igGetScrollY
import cimgui.internal.CImGui.igGetStateStorage
import cimgui.internal.CImGui.igGetStyle
import cimgui.internal.CImGui.igGetStyleColorName
import cimgui.internal.CImGui.igGetStyleColorVec4
import cimgui.internal.CImGui.igGetTextLineHeight
import cimgui.internal.CImGui.igGetTextLineHeightWithSpacing
import cimgui.internal.CImGui.igGetTime
import cimgui.internal.CImGui.igGetTopMostPopupModal
import cimgui.internal.CImGui.igGetTreeNodeToLabelSpacing
import cimgui.internal.CImGui.igGetVersion
import cimgui.internal.CImGui.igGetWindowContentRegionWidth
import cimgui.internal.CImGui.igGetWindowDrawList
import cimgui.internal.CImGui.igGetWindowHeight
import cimgui.internal.CImGui.igGetWindowResizeID
import cimgui.internal.CImGui.igGetWindowWidth
import cimgui.internal.CImGui.igImAlphaBlendColors
import cimgui.internal.CImGui.igImCharIsBlankW
import cimgui.internal.CImGui.igImDot
import cimgui.internal.CImGui.igImFloorFloat
import cimgui.internal.CImGui.igImFontAtlasBuildFinish
import cimgui.internal.CImGui.igImFontAtlasBuildInit
import cimgui.internal.CImGui.igImFontAtlasBuildSetupFont
import cimgui.internal.CImGui.igImFontAtlasBuildWithStbTruetype
import cimgui.internal.CImGui.igImGetDirQuadrantFromDelta
import cimgui.internal.CImGui.igImHashStr
import cimgui.internal.CImGui.igImInvLength
import cimgui.internal.CImGui.igImIsPowerOfTwo
import cimgui.internal.CImGui.igImLengthSqrVec2
import cimgui.internal.CImGui.igImLengthSqrVec4
import cimgui.internal.CImGui.igImLinearSweep
import cimgui.internal.CImGui.igImModPositive
import cimgui.internal.CImGui.igImParseFormatFindEnd
import cimgui.internal.CImGui.igImParseFormatFindStart
import cimgui.internal.CImGui.igImParseFormatPrecision
import cimgui.internal.CImGui.igImPowFloat
import cimgui.internal.CImGui.igImPowdouble
import cimgui.internal.CImGui.igImSaturate
import cimgui.internal.CImGui.igImStrSkipBlank
import cimgui.internal.CImGui.igImStrbolW
import cimgui.internal.CImGui.igImStreolRange
import cimgui.internal.CImGui.igImStricmp
import cimgui.internal.CImGui.igImStristr
import cimgui.internal.CImGui.igImStrlenW
import cimgui.internal.CImGui.igImStrnicmp
import cimgui.internal.CImGui.igImTextCharFromUtf8
import cimgui.internal.CImGui.igImTextCountCharsFromUtf8
import cimgui.internal.CImGui.igImTextCountUtf8BytesFromChar
import cimgui.internal.CImGui.igImTextCountUtf8BytesFromStr
import cimgui.internal.CImGui.igImTriangleArea
import cimgui.internal.CImGui.igImTriangleContainsPoint
import cimgui.internal.CImGui.igImUpperPowerOfTwo
import cimgui.internal.CImGui.igImage
import cimgui.internal.CImGui.igImageButton
import cimgui.internal.CImGui.igImageButtonEx
import cimgui.internal.CImGui.igIndent
import cimgui.internal.CImGui.igInitialize
import cimgui.internal.CImGui.igInputDouble
import cimgui.internal.CImGui.igInputFloat
import cimgui.internal.CImGui.igInputFloat2
import cimgui.internal.CImGui.igInputFloat3
import cimgui.internal.CImGui.igInputFloat4
import cimgui.internal.CImGui.igInputInt
import cimgui.internal.CImGui.igInputInt2
import cimgui.internal.CImGui.igInputInt3
import cimgui.internal.CImGui.igInputInt4
import cimgui.internal.CImGui.igInvisibleButton
import cimgui.internal.CImGui.igIsActiveIdUsingKey
import cimgui.internal.CImGui.igIsActiveIdUsingNavDir
import cimgui.internal.CImGui.igIsActiveIdUsingNavInput
import cimgui.internal.CImGui.igIsAnyItemActive
import cimgui.internal.CImGui.igIsAnyItemFocused
import cimgui.internal.CImGui.igIsAnyItemHovered
import cimgui.internal.CImGui.igIsAnyMouseDown
import cimgui.internal.CImGui.igIsDragDropPayloadBeingAccepted
import cimgui.internal.CImGui.igIsItemActivated
import cimgui.internal.CImGui.igIsItemActive
import cimgui.internal.CImGui.igIsItemClicked
import cimgui.internal.CImGui.igIsItemDeactivated
import cimgui.internal.CImGui.igIsItemDeactivatedAfterEdit
import cimgui.internal.CImGui.igIsItemEdited
import cimgui.internal.CImGui.igIsItemFocused
import cimgui.internal.CImGui.igIsItemHovered
import cimgui.internal.CImGui.igIsItemToggledOpen
import cimgui.internal.CImGui.igIsItemToggledSelection
import cimgui.internal.CImGui.igIsItemVisible
import cimgui.internal.CImGui.igIsKeyDown
import cimgui.internal.CImGui.igIsKeyPressed
import cimgui.internal.CImGui.igIsKeyPressedMap
import cimgui.internal.CImGui.igIsKeyReleased
import cimgui.internal.CImGui.igIsMouseClicked
import cimgui.internal.CImGui.igIsMouseDoubleClicked
import cimgui.internal.CImGui.igIsMouseDown
import cimgui.internal.CImGui.igIsMouseDragPastThreshold
import cimgui.internal.CImGui.igIsMouseDragging
import cimgui.internal.CImGui.igIsMouseHoveringRect
import cimgui.internal.CImGui.igIsMousePosValid
import cimgui.internal.CImGui.igIsMouseReleased
import cimgui.internal.CImGui.igIsNavInputDown
import cimgui.internal.CImGui.igIsPopupOpenID
import cimgui.internal.CImGui.igIsPopupOpenStr
import cimgui.internal.CImGui.igIsRectVisibleNil
import cimgui.internal.CImGui.igIsRectVisibleVec2
import cimgui.internal.CImGui.igIsWindowAppearing
import cimgui.internal.CImGui.igIsWindowChildOf
import cimgui.internal.CImGui.igIsWindowCollapsed
import cimgui.internal.CImGui.igIsWindowFocused
import cimgui.internal.CImGui.igIsWindowHovered
import cimgui.internal.CImGui.igIsWindowNavFocusable
import cimgui.internal.CImGui.igItemSizeVec2
import cimgui.internal.CImGui.igKeepAliveID
import cimgui.internal.CImGui.igLabelText
import cimgui.internal.CImGui.igListBoxFooter
import cimgui.internal.CImGui.igListBoxHeaderInt
import cimgui.internal.CImGui.igListBoxHeaderVec2
import cimgui.internal.CImGui.igLoadIniSettingsFromDisk
import cimgui.internal.CImGui.igLoadIniSettingsFromMemory
import cimgui.internal.CImGui.igLogButtons
import cimgui.internal.CImGui.igLogFinish
import cimgui.internal.CImGui.igLogRenderedText
import cimgui.internal.CImGui.igLogText
import cimgui.internal.CImGui.igLogToBuffer
import cimgui.internal.CImGui.igLogToClipboard
import cimgui.internal.CImGui.igLogToFile
import cimgui.internal.CImGui.igLogToTTY
import cimgui.internal.CImGui.igMarkIniSettingsDirtyNil
import cimgui.internal.CImGui.igMarkIniSettingsDirtyWindowPtr
import cimgui.internal.CImGui.igMarkItemEdited
import cimgui.internal.CImGui.igMenuItemBool
import cimgui.internal.CImGui.igMenuItemBoolPtr
import cimgui.internal.CImGui.igNavInitWindow
import cimgui.internal.CImGui.igNavMoveRequestButNoResultYet
import cimgui.internal.CImGui.igNavMoveRequestCancel
import cimgui.internal.CImGui.igNavMoveRequestTryWrapping
import cimgui.internal.CImGui.igNewFrame
import cimgui.internal.CImGui.igNewLine
import cimgui.internal.CImGui.igNextColumn
import cimgui.internal.CImGui.igOpenPopup
import cimgui.internal.CImGui.igOpenPopupContextItem
import cimgui.internal.CImGui.igOpenPopupEx
import cimgui.internal.CImGui.igPopAllowKeyboardFocus
import cimgui.internal.CImGui.igPopButtonRepeat
import cimgui.internal.CImGui.igPopClipRect
import cimgui.internal.CImGui.igPopColumnsBackground
import cimgui.internal.CImGui.igPopFocusScope
import cimgui.internal.CImGui.igPopFont
import cimgui.internal.CImGui.igPopID
import cimgui.internal.CImGui.igPopItemFlag
import cimgui.internal.CImGui.igPopItemWidth
import cimgui.internal.CImGui.igPopStyleColor
import cimgui.internal.CImGui.igPopStyleVar
import cimgui.internal.CImGui.igPopTextWrapPos
import cimgui.internal.CImGui.igProgressBar
import cimgui.internal.CImGui.igPushAllowKeyboardFocus
import cimgui.internal.CImGui.igPushButtonRepeat
import cimgui.internal.CImGui.igPushClipRect
import cimgui.internal.CImGui.igPushColumnClipRect
import cimgui.internal.CImGui.igPushColumnsBackground
import cimgui.internal.CImGui.igPushFocusScope
import cimgui.internal.CImGui.igPushFont
import cimgui.internal.CImGui.igPushIDInt
import cimgui.internal.CImGui.igPushIDStr
import cimgui.internal.CImGui.igPushIDStrStr
import cimgui.internal.CImGui.igPushItemFlag
import cimgui.internal.CImGui.igPushItemWidth
import cimgui.internal.CImGui.igPushMultiItemsWidths
import cimgui.internal.CImGui.igPushOverrideID
import cimgui.internal.CImGui.igPushStyleColorU32
import cimgui.internal.CImGui.igPushStyleColorVec4
import cimgui.internal.CImGui.igPushStyleVarFloat
import cimgui.internal.CImGui.igPushStyleVarVec2
import cimgui.internal.CImGui.igPushTextWrapPos
import cimgui.internal.CImGui.igRadioButtonBool
import cimgui.internal.CImGui.igRadioButtonIntPtr
import cimgui.internal.CImGui.igRender
import cimgui.internal.CImGui.igRenderArrow
import cimgui.internal.CImGui.igRenderArrowPointingAt
import cimgui.internal.CImGui.igRenderBullet
import cimgui.internal.CImGui.igRenderCheckMark
import cimgui.internal.CImGui.igRenderColorRectWithAlphaCheckerboard
import cimgui.internal.CImGui.igRenderFrame
import cimgui.internal.CImGui.igRenderFrameBorder
import cimgui.internal.CImGui.igRenderMouseCursor
import cimgui.internal.CImGui.igRenderText
import cimgui.internal.CImGui.igRenderTextClipped
import cimgui.internal.CImGui.igRenderTextClippedEx
import cimgui.internal.CImGui.igRenderTextEllipsis
import cimgui.internal.CImGui.igRenderTextWrapped
import cimgui.internal.CImGui.igResetMouseDragDelta
import cimgui.internal.CImGui.igSameLine
import cimgui.internal.CImGui.igSaveIniSettingsToDisk
import cimgui.internal.CImGui.igSaveIniSettingsToMemory
import cimgui.internal.CImGui.igSelectableBool
import cimgui.internal.CImGui.igSelectableBoolPtr
import cimgui.internal.CImGui.igSeparator
import cimgui.internal.CImGui.igSeparatorEx
import cimgui.internal.CImGui.igSetActiveID
import cimgui.internal.CImGui.igSetClipboardText
import cimgui.internal.CImGui.igSetColorEditOptions
import cimgui.internal.CImGui.igSetColumnOffset
import cimgui.internal.CImGui.igSetColumnWidth
import cimgui.internal.CImGui.igSetCurrentContext
import cimgui.internal.CImGui.igSetCurrentFont
import cimgui.internal.CImGui.igSetCursorPos
import cimgui.internal.CImGui.igSetCursorPosX
import cimgui.internal.CImGui.igSetCursorPosY
import cimgui.internal.CImGui.igSetCursorScreenPos
import cimgui.internal.CImGui.igSetFocusID
import cimgui.internal.CImGui.igSetHoveredID
import cimgui.internal.CImGui.igSetItemAllowOverlap
import cimgui.internal.CImGui.igSetItemDefaultFocus
import cimgui.internal.CImGui.igSetKeyboardFocusHere
import cimgui.internal.CImGui.igSetMouseCursor
import cimgui.internal.CImGui.igSetNavID
import cimgui.internal.CImGui.igSetNextItemOpen
import cimgui.internal.CImGui.igSetNextItemWidth
import cimgui.internal.CImGui.igSetNextWindowBgAlpha
import cimgui.internal.CImGui.igSetNextWindowCollapsed
import cimgui.internal.CImGui.igSetNextWindowContentSize
import cimgui.internal.CImGui.igSetNextWindowFocus
import cimgui.internal.CImGui.igSetNextWindowPos
import cimgui.internal.CImGui.igSetNextWindowScroll
import cimgui.internal.CImGui.igSetNextWindowSize
import cimgui.internal.CImGui.igSetScrollFromPosXFloat
import cimgui.internal.CImGui.igSetScrollFromPosXWindowPtr
import cimgui.internal.CImGui.igSetScrollFromPosYFloat
import cimgui.internal.CImGui.igSetScrollFromPosYWindowPtr
import cimgui.internal.CImGui.igSetScrollHereX
import cimgui.internal.CImGui.igSetScrollHereY
import cimgui.internal.CImGui.igSetScrollXFloat
import cimgui.internal.CImGui.igSetScrollXWindowPtr
import cimgui.internal.CImGui.igSetScrollYFloat
import cimgui.internal.CImGui.igSetScrollYWindowPtr
import cimgui.internal.CImGui.igSetStateStorage
import cimgui.internal.CImGui.igSetTabItemClosed
import cimgui.internal.CImGui.igSetTooltip
import cimgui.internal.CImGui.igSetWindowCollapsedBool
import cimgui.internal.CImGui.igSetWindowCollapsedStr
import cimgui.internal.CImGui.igSetWindowCollapsedWindowPtr
import cimgui.internal.CImGui.igSetWindowFocusNil
import cimgui.internal.CImGui.igSetWindowFocusStr
import cimgui.internal.CImGui.igSetWindowFontScale
import cimgui.internal.CImGui.igSetWindowPosStr
import cimgui.internal.CImGui.igSetWindowPosVec2
import cimgui.internal.CImGui.igSetWindowPosWindowPtr
import cimgui.internal.CImGui.igSetWindowSizeStr
import cimgui.internal.CImGui.igSetWindowSizeVec2
import cimgui.internal.CImGui.igSetWindowSizeWindowPtr
import cimgui.internal.CImGui.igShadeVertsLinearColorGradientKeepAlpha
import cimgui.internal.CImGui.igShadeVertsLinearUV
import cimgui.internal.CImGui.igShowAboutWindow
import cimgui.internal.CImGui.igShowDemoWindow
import cimgui.internal.CImGui.igShowFontSelector
import cimgui.internal.CImGui.igShowMetricsWindow
import cimgui.internal.CImGui.igShowStyleEditor
import cimgui.internal.CImGui.igShowStyleSelector
import cimgui.internal.CImGui.igShowUserGuide
import cimgui.internal.CImGui.igShrinkWidths
import cimgui.internal.CImGui.igShutdown
import cimgui.internal.CImGui.igSliderAngle
import cimgui.internal.CImGui.igSliderFloat
import cimgui.internal.CImGui.igSliderFloat2
import cimgui.internal.CImGui.igSliderFloat3
import cimgui.internal.CImGui.igSliderFloat4
import cimgui.internal.CImGui.igSliderInt
import cimgui.internal.CImGui.igSliderInt2
import cimgui.internal.CImGui.igSliderInt3
import cimgui.internal.CImGui.igSliderInt4
import cimgui.internal.CImGui.igSmallButton
import cimgui.internal.CImGui.igSpacing
import cimgui.internal.CImGui.igStartMouseMovingWindow
import cimgui.internal.CImGui.igStyleColorsClassic
import cimgui.internal.CImGui.igStyleColorsDark
import cimgui.internal.CImGui.igStyleColorsLight
import cimgui.internal.CImGui.igTabBarCloseTab
import cimgui.internal.CImGui.igTabBarFindTabByID
import cimgui.internal.CImGui.igTabBarQueueChangeTabOrder
import cimgui.internal.CImGui.igTabBarRemoveTab
import cimgui.internal.CImGui.igTabItemEx
import cimgui.internal.CImGui.igTempInputIsActive
import cimgui.internal.CImGui.igText
import cimgui.internal.CImGui.igTextColored
import cimgui.internal.CImGui.igTextDisabled
import cimgui.internal.CImGui.igTextEx
import cimgui.internal.CImGui.igTextUnformatted
import cimgui.internal.CImGui.igTextWrapped
import cimgui.internal.CImGui.igTreeNodeBehavior
import cimgui.internal.CImGui.igTreeNodeBehaviorIsOpen
import cimgui.internal.CImGui.igTreeNodeExStr
import cimgui.internal.CImGui.igTreeNodeExStrStr
import cimgui.internal.CImGui.igTreeNodeStr
import cimgui.internal.CImGui.igTreeNodeStrStr
import cimgui.internal.CImGui.igTreePop
import cimgui.internal.CImGui.igTreePushOverrideID
import cimgui.internal.CImGui.igTreePushPtr
import cimgui.internal.CImGui.igTreePushStr
import cimgui.internal.CImGui.igUnindent
import cimgui.internal.CImGui.igUpdateHoveredWindowAndCaptureFlags
import cimgui.internal.CImGui.igUpdateMouseMovingWindowEndFrame
import cimgui.internal.CImGui.igUpdateMouseMovingWindowNewFrame
import cimgui.internal.CImGui.igUpdateWindowParentAndRootLinks
import cimgui.internal.CImGui.igVSliderFloat
import cimgui.internal.CImGui.igVSliderInt
import cimgui.internal.CImGui.igValueBool
import cimgui.internal.CImGui.igValueFloat
import cimgui.internal.CImGui.igValueInt
import cimgui.internal.CImGui.igValueUint
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

actual object ImGui {
    init {
        loadCImGuiNativeLibs()
    }

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
    ): Boolean = usingVec2 { ptrSizeArg -> 
        igArrowButtonEx(strId, dir.value, ptrSizeArg, flags?.value ?: 0)
    }

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
    ): Boolean = usingVec2 { ptrSize -> 
        igBeginChildStr(strId, ptrSize, border, flags?.value ?: 0)
    }

    actual fun beginChild(
        id: ImGuiID,
        size: Vec2,
        border: Boolean,
        flags: Flag<ImGuiWindowFlags>?
    ): Boolean = usingVec2 { ptrSize -> 
        igBeginChildID(id.value, ptrSize, border, flags?.value ?: 0)
    }

    actual fun beginChildEx(
        name: String,
        id: ImGuiID,
        sizeArg: Vec2,
        border: Boolean,
        flags: Flag<ImGuiWindowFlags>
    ): Boolean = usingVec2 { ptrSizeArg -> 
        igBeginChildEx(name, id.value, ptrSizeArg, border, flags.value)
    }

    actual fun beginChildFrame(
        id: ImGuiID,
        size: Vec2,
        flags: Flag<ImGuiWindowFlags>?
    ): Boolean = usingVec2 { ptrSize -> 
        igBeginChildFrame(id.value, ptrSize, flags?.value ?: 0)
    }

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

    actual fun beginPopupContextItem(strId: String?, popupFlags: Flag<ImGuiPopupFlags>): Boolean =
            igBeginPopupContextItem(strId, popupFlags.value)

    actual fun beginPopupContextVoid(strId: String?, popupFlags: Flag<ImGuiPopupFlags>): Boolean =
            igBeginPopupContextVoid(strId, popupFlags.value)

    actual fun beginPopupContextWindow(strId: String?, popupFlags: Flag<ImGuiPopupFlags>): Boolean =
            igBeginPopupContextWindow(strId, popupFlags.value)

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

    actual fun button(label: String, size: Vec2): Boolean = usingVec2 { ptrSize -> 
        igButton(label, ptrSize)
    }

    actual fun buttonEx(
        label: String,
        sizeArg: Vec2,
        flags: Flag<ImGuiButtonFlags>?
    ): Boolean = usingVec2 { ptrSizeArg -> 
        igButtonEx(label, ptrSizeArg, flags?.value ?: 0)
    }

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

    actual fun calcWrapWidthForPos(pos: Vec2, wrapPosX: Float): Float = usingVec2 { ptrPos -> 
        igCalcWrapWidthForPos(ptrPos, wrapPosX)
    }

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
        igCheckboxFlags(label, ptrFlags, flagsValue.toLong())
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

    actual fun closeButton(id: ImGuiID, pos: Vec2): Boolean = usingVec2 { ptrPos -> 
        igCloseButton(id.value, ptrPos)
    }

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

    actual fun collapseButton(id: ImGuiID, pos: Vec2): Boolean = usingVec2 { ptrPos -> 
        igCollapseButton(id.value, ptrPos)
    }

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
    ): Boolean = usingVec4 { ptrCol -> 
        usingVec2 { ptrSize -> 
            igColorButton(descId, ptrCol, flags?.value ?: 0, ptrSize)
        }
    }

    actual fun colorConvertFloat4ToU32(`in`: Vec4): UInt = usingVec4 { ptrIn -> 
        igColorConvertFloat4ToU32(ptrIn)
    }.toUInt()

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

        return col.nativeCopy { pinnedCol ->
            igColorEdit3(label, pinnedCol, flags?.value ?: 0)
        }
    }

    actual fun colorEdit4(
        label: String,
        col: FloatArray,
        flags: Flag<ImGuiColorEditFlags>?
    ): Boolean {
        require(col.size >= 4)

        return col.nativeCopy { pinnedCol ->
            igColorEdit4(label, pinnedCol, flags?.value ?: 0)
        }
    }

    actual fun colorPicker3(
        label: String,
        col: FloatArray,
        flags: Flag<ImGuiColorEditFlags>?
    ): Boolean {
        require(col.size >= 3)

        return col.nativeCopy { pinnedCol ->
            igColorPicker3(label, pinnedCol, flags?.value ?: 0)
        }
    }

    actual fun colorPicker4(
        label: String,
        col: FloatArray,
        flags: Flag<ImGuiColorEditFlags>?
    ): Boolean {
        require(col.size >= 4)

        return col.nativeCopy { pinnedCol ->
            igColorPicker4(label, pinnedCol, flags?.value ?: 0, null)
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
    ): Boolean = igDebugCheckVersionAndDataLayout(versionStr, szIo.toLong(), szStyle.toLong(),
            szVec2.toLong(), szVec4.toLong(), szDrawvert.toLong(), szDrawidx.toLong())

    actual fun debugDrawItemRect(col: UInt) {
        igDebugDrawItemRect(col.toLong())
    }

    actual fun debugStartItemPicker() {
        igDebugStartItemPicker()
    }

    actual fun destroyContext(ctx: ImGuiContext?) {
        igDestroyContext(ctx?.ptr)
    }

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

        return v.nativeCopy { pinnedV ->
            igDragFloat2(label, pinnedV, vSpeed, vMin, vMax, format, power)
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

        return v.nativeCopy { pinnedV ->
            igDragFloat3(label, pinnedV, vSpeed, vMin, vMax, format, power)
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

        return v.nativeCopy { pinnedV ->
            igDragFloat4(label, pinnedV, vSpeed, vMin, vMax, format, power)
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

        return v.nativeCopy { pinnedV ->
            igDragInt2(label, pinnedV, vSpeed, vMin, vMax, format)
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

        return v.nativeCopy { pinnedV ->
            igDragInt3(label, pinnedV, vSpeed, vMin, vMax, format)
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

        return v.nativeCopy { pinnedV ->
            igDragInt4(label, pinnedV, vSpeed, vMin, vMax, format)
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
        usingVec2 { ptrSize -> 
            igDummy(ptrSize)
        }
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
            igFindRenderedTextEnd(text, textEnd)

    actual fun findSettingsHandler(typeName: String): ImGuiSettingsHandler =
            igFindSettingsHandler(typeName)!!.let(::ImGuiSettingsHandler)

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

    actual fun getBackgroundDrawList(): ImDrawList = igGetBackgroundDrawList()!!.let(::ImDrawList)

    actual fun getClipboardText(): String? = igGetClipboardText()

    actual fun getColorU32(idx: ImGuiCol, alphaMul: Float): UInt = igGetColorU32Col(idx.value,
            alphaMul).toUInt()

    actual fun getColorU32(col: Vec4): UInt = usingVec4 { ptrCol -> 
        igGetColorU32Vec4(ptrCol)
    }.toUInt()

    actual fun getColorU32(col: UInt): UInt = igGetColorU32U32(col.toLong()).toUInt()

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

    actual fun getMergedKeyModFlags(): Flag<ImGuiKeyModFlags> = igGetMergedKeyModFlags().let {
            ImGuiKeyModFlags.fromMultiple(it) }

    actual fun getMouseCursor(): ImGuiMouseCursor = igGetMouseCursor().let {
            ImGuiMouseCursor.from(it) }

    actual fun getScrollMaxX(): Float = igGetScrollMaxX()

    actual fun getScrollMaxY(): Float = igGetScrollMaxY()

    actual fun getScrollX(): Float = igGetScrollX()

    actual fun getScrollY(): Float = igGetScrollY()

    actual fun getStateStorage(): ImGuiStorage = igGetStateStorage()!!.let(::ImGuiStorage)

    actual fun getStyle(): ImGuiStyle = igGetStyle()!!.let(::ImGuiStyle)

    actual fun getStyleColorName(idx: ImGuiCol): String? = igGetStyleColorName(idx.value)

    actual fun getStyleColorVec4(idx: ImGuiCol): ImVec4 =
            igGetStyleColorVec4(idx.value)!!.let(::ImVec4)

    actual fun getTextLineHeight(): Float = igGetTextLineHeight()

    actual fun getTextLineHeightWithSpacing(): Float = igGetTextLineHeightWithSpacing()

    actual fun getTime(): Double = igGetTime()

    actual fun getTopMostPopupModal(): ImGuiWindow = igGetTopMostPopupModal()!!.let(::ImGuiWindow)

    actual fun getTreeNodeToLabelSpacing(): Float = igGetTreeNodeToLabelSpacing()

    actual fun getVersion(): String? = igGetVersion()

    actual fun getWindowContentRegionWidth(): Float = igGetWindowContentRegionWidth()

    actual fun getWindowDrawList(): ImDrawList = igGetWindowDrawList()!!.let(::ImDrawList)

    actual fun getWindowHeight(): Float = igGetWindowHeight()

    actual fun getWindowResizeID(window: ImGuiWindow, n: Int): ImGuiID =
            igGetWindowResizeID(window.ptr, n).let(::ImGuiID)

    actual fun getWindowWidth(): Float = igGetWindowWidth()

    actual fun imAlphaBlendColors(colA: UInt, colB: UInt): UInt =
            igImAlphaBlendColors(colA.toLong(), colB.toLong()).toUInt()

    actual fun imCharIsBlankW(c: UInt): Boolean = igImCharIsBlankW(c.toLong())

    actual fun imDot(a: Vec2, b: Vec2): Float = usingVec2 { ptrA -> 
        usingVec2 { ptrB -> 
            igImDot(ptrA, ptrB)
        }
    }

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
    ): UInt = igImHashStr(data, dataSize.toLong(), seed.toLong()).toUInt()

    actual fun imInvLength(lhs: Vec2, failValue: Float): Float = usingVec2 { ptrLhs -> 
        igImInvLength(ptrLhs, failValue)
    }

    actual fun imIsPowerOfTwo(v: Int): Boolean = igImIsPowerOfTwo(v)

    actual fun imLengthSqr(lhs: Vec2): Float = usingVec2 { ptrLhs -> 
        igImLengthSqrVec2(ptrLhs)
    }

    actual fun imLengthSqr(lhs: Vec4): Float = usingVec4 { ptrLhs -> 
        igImLengthSqrVec4(ptrLhs)
    }

    actual fun imLinearSweep(
        current: Float,
        target: Float,
        speed: Float
    ): Float = igImLinearSweep(current, target, speed)

    actual fun imModPositive(a: Int, b: Int): Int = igImModPositive(a, b)

    actual fun imParseFormatFindEnd(format: String): String? = igImParseFormatFindEnd(format)

    actual fun imParseFormatFindStart(format: String): String? = igImParseFormatFindStart(format)

    actual fun imParseFormatPrecision(format: String, defaultValue: Int): Int =
            igImParseFormatPrecision(format, defaultValue)

    actual fun imPow(x: Float, y: Float): Float = igImPowFloat(x, y)

    actual fun imPow(x: Double, y: Double): Double = igImPowdouble(x, y)

    actual fun imSaturate(f: Float): Float = igImSaturate(f)

    actual fun imStrSkipBlank(str: String): String? = igImStrSkipBlank(str)

    actual fun imStrbolW(bufMidLine: String, bufBegin: String): String =
            bufMidLine.usingUTF16String { ptrBufMidLine -> 
        bufBegin.usingUTF16String { ptrBufBegin -> 
            igImStrbolW(ptrBufMidLine, ptrBufBegin)
        }
    }!!.toUTF16String()

    actual fun imStreolRange(str: String, strEnd: String): String? = igImStreolRange(str, strEnd)

    actual fun imStricmp(str1: String, str2: String): Int = igImStricmp(str1, str2)

    actual fun imStristr(
        haystack: String,
        haystackEnd: String,
        needle: String,
        needleEnd: String
    ): String? = igImStristr(haystack, haystackEnd, needle, needleEnd)

    actual fun imStrlenW(str: String): Int = str.usingUTF16String { ptrStr -> 
        igImStrlenW(ptrStr)
    }

    actual fun imStrnicmp(
        str1: String,
        str2: String,
        count: ULong
    ): Int = igImStrnicmp(str1, str2, count.toLong())

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
            inText.usingUTF16String { ptrInText -> 
        inTextEnd.usingUTF16String { ptrInTextEnd -> 
            igImTextCountUtf8BytesFromStr(ptrInText, ptrInTextEnd)
        }
    }

    actual fun imTriangleArea(
        a: Vec2,
        b: Vec2,
        c: Vec2
    ): Float = usingVec2 { ptrA -> 
        usingVec2 { ptrB -> 
            usingVec2 { ptrC -> 
                igImTriangleArea(ptrA, ptrB, ptrC)
            }
        }
    }

    actual fun imTriangleContainsPoint(
        a: Vec2,
        b: Vec2,
        c: Vec2,
        p: Vec2
    ): Boolean = usingVec2 { ptrA -> 
        usingVec2 { ptrB -> 
            usingVec2 { ptrC -> 
                usingVec2 { ptrP -> 
                    igImTriangleContainsPoint(ptrA, ptrB, ptrC, ptrP)
                }
            }
        }
    }

    actual fun imUpperPowerOfTwo(v: Int): Int = igImUpperPowerOfTwo(v)

    actual fun image(
        userTextureId: ImTextureID,
        size: Vec2,
        uv0: Vec2,
        uv1: Vec2,
        tintCol: Vec4,
        borderCol: Vec4
    ) {
        usingVec2 { ptrSize -> 
            usingVec2 { ptrUv0 -> 
                usingVec2 { ptrUv1 -> 
                    usingVec4 { ptrTintCol -> 
                        usingVec4 { ptrBorderCol -> 
                            igImage(userTextureId.value, ptrSize, ptrUv0, ptrUv1, ptrTintCol,
                                    ptrBorderCol)
                        }
                    }
                }
            }
        }
    }

    actual fun imageButton(
        userTextureId: ImTextureID,
        size: Vec2,
        uv0: Vec2,
        uv1: Vec2,
        framePadding: Int,
        bgCol: Vec4,
        tintCol: Vec4
    ): Boolean = usingVec2 { ptrSize -> 
        usingVec2 { ptrUv0 -> 
            usingVec2 { ptrUv1 -> 
                usingVec4 { ptrBgCol -> 
                    usingVec4 { ptrTintCol -> 
                        igImageButton(userTextureId.value, ptrSize, ptrUv0, ptrUv1, framePadding,
                                ptrBgCol, ptrTintCol)
                    }
                }
            }
        }
    }

    actual fun imageButtonEx(
        id: ImGuiID,
        textureId: ImTextureID,
        size: Vec2,
        uv0: Vec2,
        uv1: Vec2,
        padding: Vec2,
        bgCol: Vec4,
        tintCol: Vec4
    ): Boolean = usingVec2 { ptrSize -> 
        usingVec2 { ptrUv0 -> 
            usingVec2 { ptrUv1 -> 
                usingVec2 { ptrPadding -> 
                    usingVec4 { ptrBgCol -> 
                        usingVec4 { ptrTintCol -> 
                            igImageButtonEx(id.value, textureId.value, ptrSize, ptrUv0, ptrUv1,
                                    ptrPadding, ptrBgCol, ptrTintCol)
                        }
                    }
                }
            }
        }
    }

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

        return v.nativeCopy { pinnedV ->
            igInputFloat2(label, pinnedV, format, flags?.value ?: 0)
        }
    }

    actual fun inputFloat3(
        label: String,
        v: FloatArray,
        format: String,
        flags: Flag<ImGuiInputTextFlags>?
    ): Boolean {
        require(v.size >= 3)

        return v.nativeCopy { pinnedV ->
            igInputFloat3(label, pinnedV, format, flags?.value ?: 0)
        }
    }

    actual fun inputFloat4(
        label: String,
        v: FloatArray,
        format: String,
        flags: Flag<ImGuiInputTextFlags>?
    ): Boolean {
        require(v.size >= 4)

        return v.nativeCopy { pinnedV ->
            igInputFloat4(label, pinnedV, format, flags?.value ?: 0)
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

        return v.nativeCopy { pinnedV ->
            igInputInt2(label, pinnedV, flags?.value ?: 0)
        }
    }

    actual fun inputInt3(
        label: String,
        v: IntArray,
        flags: Flag<ImGuiInputTextFlags>?
    ): Boolean {
        require(v.size >= 3)

        return v.nativeCopy { pinnedV ->
            igInputInt3(label, pinnedV, flags?.value ?: 0)
        }
    }

    actual fun inputInt4(
        label: String,
        v: IntArray,
        flags: Flag<ImGuiInputTextFlags>?
    ): Boolean {
        require(v.size >= 4)

        return v.nativeCopy { pinnedV ->
            igInputInt4(label, pinnedV, flags?.value ?: 0)
        }
    }

    actual fun invisibleButton(strId: String, size: Vec2): Boolean = usingVec2 { ptrSize -> 
        igInvisibleButton(strId, ptrSize)
    }

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
    ): Boolean = usingVec2 { ptrRMin -> 
        usingVec2 { ptrRMax -> 
            igIsMouseHoveringRect(ptrRMin, ptrRMax, clip)
        }
    }

    actual fun isMousePosValid(mousePos: ImVec2?): Boolean = igIsMousePosValid(mousePos?.ptr)

    actual fun isMouseReleased(button: ImGuiMouseButton): Boolean = igIsMouseReleased(button.value)

    actual fun isNavInputDown(n: ImGuiNavInput): Boolean = igIsNavInputDown(n.value)

    actual fun isPopupOpen(strId: String, flags: Flag<ImGuiPopupFlags>?): Boolean =
            igIsPopupOpenStr(strId, flags?.value ?: 0)

    actual fun isPopupOpen(id: ImGuiID, popupFlags: Flag<ImGuiPopupFlags>): Boolean =
            igIsPopupOpenID(id.value, popupFlags.value)

    actual fun isRectVisible(size: Vec2): Boolean = usingVec2 { ptrSize -> 
        igIsRectVisibleNil(ptrSize)
    }

    actual fun isRectVisible(rectMin: Vec2, rectMax: Vec2): Boolean = usingVec2 { ptrRectMin -> 
        usingVec2 { ptrRectMax -> 
            igIsRectVisibleVec2(ptrRectMin, ptrRectMax)
        }
    }

    actual fun isWindowAppearing(): Boolean = igIsWindowAppearing()

    actual fun isWindowChildOf(window: ImGuiWindow, potentialParent: ImGuiWindow): Boolean =
            igIsWindowChildOf(window.ptr, potentialParent.ptr)

    actual fun isWindowCollapsed(): Boolean = igIsWindowCollapsed()

    actual fun isWindowFocused(flags: Flag<ImGuiFocusedFlags>?): Boolean =
            igIsWindowFocused(flags?.value ?: 0)

    actual fun isWindowHovered(flags: Flag<ImGuiHoveredFlags>?): Boolean =
            igIsWindowHovered(flags?.value ?: 0)

    actual fun isWindowNavFocusable(window: ImGuiWindow): Boolean =
            igIsWindowNavFocusable(window.ptr)

    actual fun itemSize(size: Vec2, textBaselineY: Float) {
        usingVec2 { ptrSize -> 
            igItemSizeVec2(ptrSize, textBaselineY)
        }
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

    actual fun listBoxHeader(label: String, size: Vec2): Boolean = usingVec2 { ptrSize -> 
        igListBoxHeaderVec2(label, ptrSize)
    }

    actual fun listBoxHeader(
        label: String,
        itemsCount: Int,
        heightInItems: Int
    ): Boolean = igListBoxHeaderInt(label, itemsCount, heightInItems)

    actual fun loadIniSettingsFromDisk(iniFilename: String) {
        igLoadIniSettingsFromDisk(iniFilename)
    }

    actual fun loadIniSettingsFromMemory(iniData: String, iniSize: ULong) {
        igLoadIniSettingsFromMemory(iniData, iniSize.toLong())
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

    actual fun openPopup(strId: String, popupFlags: Flag<ImGuiPopupFlags>?) {
        igOpenPopup(strId, popupFlags?.value ?: 0)
    }

    actual fun openPopupContextItem(strId: String?, popupFlags: Flag<ImGuiPopupFlags>): Boolean =
            igOpenPopupContextItem(strId, popupFlags.value)

    actual fun openPopupEx(id: ImGuiID, popupFlags: Flag<ImGuiPopupFlags>?) {
        igOpenPopupEx(id.value, popupFlags?.value ?: 0)
    }

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
        usingVec2 { ptrSizeArg -> 
            igProgressBar(fraction, ptrSizeArg, overlay)
        }
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
        usingVec2 { ptrClipRectMin -> 
            usingVec2 { ptrClipRectMax -> 
                igPushClipRect(ptrClipRectMin, ptrClipRectMax, intersectWithCurrentClipRect)
            }
        }
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
        igPushStyleColorU32(idx.value, col.toLong())
    }

    actual fun pushStyleColor(idx: ImGuiCol, col: Vec4) {
        usingVec4 { ptrCol -> 
            igPushStyleColorVec4(idx.value, ptrCol)
        }
    }

    actual fun pushStyleVar(idx: ImGuiStyleVar, `val`: Float) {
        igPushStyleVarFloat(idx.value, `val`)
    }

    actual fun pushStyleVar(idx: ImGuiStyleVar, `val`: Vec2) {
        usingVec2 { ptrVal -> 
            igPushStyleVarVec2(idx.value, ptrVal)
        }
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
        usingVec2 { ptrPos -> 
            igRenderArrow(drawList.ptr, ptrPos, col.toLong(), dir.value, scale)
        }
    }

    actual fun renderArrowPointingAt(
        drawList: ImDrawList,
        pos: Vec2,
        halfSz: Vec2,
        direction: ImGuiDir,
        col: UInt
    ) {
        usingVec2 { ptrPos -> 
            usingVec2 { ptrHalfSz -> 
                igRenderArrowPointingAt(drawList.ptr, ptrPos, ptrHalfSz, direction.value,
                        col.toLong())
            }
        }
    }

    actual fun renderBullet(
        drawList: ImDrawList,
        pos: Vec2,
        col: UInt
    ) {
        usingVec2 { ptrPos -> 
            igRenderBullet(drawList.ptr, ptrPos, col.toLong())
        }
    }

    actual fun renderCheckMark(
        drawList: ImDrawList,
        pos: Vec2,
        col: UInt,
        sz: Float
    ) {
        usingVec2 { ptrPos -> 
            igRenderCheckMark(drawList.ptr, ptrPos, col.toLong(), sz)
        }
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
        usingVec2 { ptrPMin -> 
            usingVec2 { ptrPMax -> 
                usingVec2 { ptrGridOff -> 
                    igRenderColorRectWithAlphaCheckerboard(drawList.ptr, ptrPMin, ptrPMax,
                            fillCol.toLong(), gridStep, ptrGridOff, rounding, roundingCornersFlags)
                }
            }
        }
    }

    actual fun renderFrame(
        pMin: Vec2,
        pMax: Vec2,
        fillCol: UInt,
        border: Boolean,
        rounding: Float
    ) {
        usingVec2 { ptrPMin -> 
            usingVec2 { ptrPMax -> 
                igRenderFrame(ptrPMin, ptrPMax, fillCol.toLong(), border, rounding)
            }
        }
    }

    actual fun renderFrameBorder(
        pMin: Vec2,
        pMax: Vec2,
        rounding: Float
    ) {
        usingVec2 { ptrPMin -> 
            usingVec2 { ptrPMax -> 
                igRenderFrameBorder(ptrPMin, ptrPMax, rounding)
            }
        }
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
        usingVec2 { ptrPos -> 
            igRenderMouseCursor(drawList.ptr, ptrPos, scale, mouseCursor.value, colFill.toLong(),
                    colBorder.toLong(), colShadow.toLong())
        }
    }

    actual fun renderText(
        pos: Vec2,
        text: String,
        textEnd: String?,
        hideTextAfterHash: Boolean
    ) {
        usingVec2 { ptrPos -> 
            igRenderText(ptrPos, text, textEnd, hideTextAfterHash)
        }
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
        usingVec2 { ptrPosMin -> 
            usingVec2 { ptrPosMax -> 
                usingVec2 { ptrAlign -> 
                    igRenderTextClipped(ptrPosMin, ptrPosMax, text, textEnd, textSizeIfKnown.ptr,
                            ptrAlign, clipRect?.ptr)
                }
            }
        }
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
        usingVec2 { ptrPosMin -> 
            usingVec2 { ptrPosMax -> 
                usingVec2 { ptrAlign -> 
                    igRenderTextClippedEx(drawList.ptr, ptrPosMin, ptrPosMax, text, textEnd,
                            textSizeIfKnown.ptr, ptrAlign, clipRect?.ptr)
                }
            }
        }
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
        usingVec2 { ptrPosMin -> 
            usingVec2 { ptrPosMax -> 
                igRenderTextEllipsis(drawList.ptr, ptrPosMin, ptrPosMax, clipMaxX, ellipsisMaxX,
                        text, textEnd, textSizeIfKnown.ptr)
            }
        }
    }

    actual fun renderTextWrapped(
        pos: Vec2,
        text: String,
        textEnd: String,
        wrapWidth: Float
    ) {
        usingVec2 { ptrPos -> 
            igRenderTextWrapped(ptrPos, text, textEnd, wrapWidth)
        }
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
    }

    actual fun selectable(
        label: String,
        selected: Boolean,
        flags: Flag<ImGuiSelectableFlags>?,
        size: Vec2
    ): Boolean = usingVec2 { ptrSize -> 
        igSelectableBool(label, selected, flags?.value ?: 0, ptrSize)
    }

    actual fun selectable(
        label: String,
        pSelected: KMutableProperty0<Boolean>,
        flags: Flag<ImGuiSelectableFlags>?,
        size: Vec2
    ): Boolean = usingProperty(pSelected) { ptrPSelected ->
        usingVec2 { ptrSize -> 
            igSelectableBoolPtr(label, ptrPSelected, flags?.value ?: 0, ptrSize)
        }
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
        usingVec2 { ptrLocalPos -> 
            igSetCursorPos(ptrLocalPos)
        }
    }

    actual fun setCursorPosX(localX: Float) {
        igSetCursorPosX(localX)
    }

    actual fun setCursorPosY(localY: Float) {
        igSetCursorPosY(localY)
    }

    actual fun setCursorScreenPos(pos: Vec2) {
        usingVec2 { ptrPos -> 
            igSetCursorScreenPos(ptrPos)
        }
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

    actual fun setNextWindowCollapsed(collapsed: Boolean, cond: Flag<ImGuiCond>?) {
        igSetNextWindowCollapsed(collapsed, cond?.value ?: 0)
    }

    actual fun setNextWindowContentSize(size: Vec2) {
        usingVec2 { ptrSize -> 
            igSetNextWindowContentSize(ptrSize)
        }
    }

    actual fun setNextWindowFocus() {
        igSetNextWindowFocus()
    }

    actual fun setNextWindowPos(
        pos: Vec2,
        cond: Flag<ImGuiCond>?,
        pivot: Vec2
    ) {
        usingVec2 { ptrPos -> 
            usingVec2 { ptrPivot -> 
                igSetNextWindowPos(ptrPos, cond?.value ?: 0, ptrPivot)
            }
        }
    }

    actual fun setNextWindowScroll(scroll: Vec2) {
        usingVec2 { ptrScroll -> 
            igSetNextWindowScroll(ptrScroll)
        }
    }

    actual fun setNextWindowSize(size: Vec2, cond: Flag<ImGuiCond>?) {
        usingVec2 { ptrSize -> 
            igSetNextWindowSize(ptrSize, cond?.value ?: 0)
        }
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

    actual fun setWindowFocus() {
        igSetWindowFocusNil()
    }

    actual fun setWindowFocus(name: String) {
        igSetWindowFocusStr(name)
    }

    actual fun setWindowFontScale(scale: Float) {
        igSetWindowFontScale(scale)
    }

    actual fun setWindowPos(pos: Vec2, cond: Flag<ImGuiCond>?) {
        usingVec2 { ptrPos -> 
            igSetWindowPosVec2(ptrPos, cond?.value ?: 0)
        }
    }

    actual fun setWindowPos(
        name: String,
        pos: Vec2,
        cond: Flag<ImGuiCond>?
    ) {
        usingVec2 { ptrPos -> 
            igSetWindowPosStr(name, ptrPos, cond?.value ?: 0)
        }
    }

    actual fun setWindowPos(
        window: ImGuiWindow,
        pos: Vec2,
        cond: Flag<ImGuiCond>?
    ) {
        usingVec2 { ptrPos -> 
            igSetWindowPosWindowPtr(window.ptr, ptrPos, cond?.value ?: 0)
        }
    }

    actual fun setWindowSize(size: Vec2, cond: Flag<ImGuiCond>?) {
        usingVec2 { ptrSize -> 
            igSetWindowSizeVec2(ptrSize, cond?.value ?: 0)
        }
    }

    actual fun setWindowSize(
        name: String,
        size: Vec2,
        cond: Flag<ImGuiCond>?
    ) {
        usingVec2 { ptrSize -> 
            igSetWindowSizeStr(name, ptrSize, cond?.value ?: 0)
        }
    }

    actual fun setWindowSize(
        window: ImGuiWindow,
        size: Vec2,
        cond: Flag<ImGuiCond>?
    ) {
        usingVec2 { ptrSize -> 
            igSetWindowSizeWindowPtr(window.ptr, ptrSize, cond?.value ?: 0)
        }
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
        usingVec2 { ptrGradientP0 -> 
            usingVec2 { ptrGradientP1 -> 
                igShadeVertsLinearColorGradientKeepAlpha(drawList.ptr, vertStartIdx, vertEndIdx,
                        ptrGradientP0, ptrGradientP1, col0.toLong(), col1.toLong())
            }
        }
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
        usingVec2 { ptrA -> 
            usingVec2 { ptrB -> 
                usingVec2 { ptrUvA -> 
                    usingVec2 { ptrUvB -> 
                        igShadeVertsLinearUV(drawList.ptr, vertStartIdx, vertEndIdx, ptrA, ptrB,
                                ptrUvA, ptrUvB, clamp)
                    }
                }
            }
        }
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

        return v.nativeCopy { pinnedV ->
            igSliderFloat2(label, pinnedV, vMin, vMax, format, power)
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

        return v.nativeCopy { pinnedV ->
            igSliderFloat3(label, pinnedV, vMin, vMax, format, power)
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

        return v.nativeCopy { pinnedV ->
            igSliderFloat4(label, pinnedV, vMin, vMax, format, power)
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

        return v.nativeCopy { pinnedV ->
            igSliderInt2(label, pinnedV, vMin, vMax, format)
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

        return v.nativeCopy { pinnedV ->
            igSliderInt3(label, pinnedV, vMin, vMax, format)
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

        return v.nativeCopy { pinnedV ->
            igSliderInt4(label, pinnedV, vMin, vMax, format)
        }
    }

    actual fun smallButton(label: String): Boolean = igSmallButton(label)

    actual fun spacing() {
        igSpacing()
    }

    actual fun startMouseMovingWindow(window: ImGuiWindow) {
        igStartMouseMovingWindow(window.ptr)
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

    actual fun tabBarCloseTab(tabBar: ImGuiTabBar, tab: ImGuiTabItem) {
        igTabBarCloseTab(tabBar.ptr, tab.ptr)
    }

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
        flags: Flag<ImGuiTabItemFlags>
    ): Boolean = usingProperty(pOpen) { ptrPOpen ->
        igTabItemEx(tabBar.ptr, label, ptrPOpen, flags.value)
    }

    actual fun tempInputIsActive(id: ImGuiID): Boolean = igTempInputIsActive(id.value)

    actual fun text(fmt: String) {
        igText(fmt)
    }

    actual fun textColored(col: Vec4, fmt: String) {
        usingVec4 { ptrCol -> 
            igTextColored(ptrCol, fmt)
        }
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
    ): Boolean = usingVec2 { ptrSize -> 
        usingProperty(v) { ptrV ->
            igVSliderFloat(label, ptrSize, ptrV, vMin, vMax, format, power)
        }
    }

    actual fun vSliderInt(
        label: String,
        size: Vec2,
        v: KMutableProperty0<Int>,
        vMin: Int,
        vMax: Int,
        format: String
    ): Boolean = usingVec2 { ptrSize -> 
        usingProperty(v) { ptrV ->
            igVSliderInt(label, ptrSize, ptrV, vMin, vMax, format)
        }
    }

    actual fun value(prefix: String, b: Boolean) {
        igValueBool(prefix, b)
    }

    actual fun value(prefix: String, v: Int) {
        igValueInt(prefix, v)
    }

    actual fun value(prefix: String, v: UInt) {
        igValueUint(prefix, v.toLong())
    }

    actual fun value(
        prefix: String,
        v: Float,
        floatFormat: String?
    ) {
        igValueFloat(prefix, v, floatFormat)
    }
}
