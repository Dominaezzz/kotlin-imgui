package com.imgui

import cimgui.internal.CImGui.igAcceptDragDropPayload
import cimgui.internal.CImGui.igAlignTextToFramePadding
import cimgui.internal.CImGui.igArrowButton
import cimgui.internal.CImGui.igBegin
import cimgui.internal.CImGui.igBeginChild
import cimgui.internal.CImGui.igBeginChildFrame
import cimgui.internal.CImGui.igBeginChildID
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
import cimgui.internal.CImGui.igBeginPopupModal
import cimgui.internal.CImGui.igBeginTabBar
import cimgui.internal.CImGui.igBeginTabItem
import cimgui.internal.CImGui.igBeginTooltip
import cimgui.internal.CImGui.igBullet
import cimgui.internal.CImGui.igBulletText
import cimgui.internal.CImGui.igButton
import cimgui.internal.CImGui.igCalcItemWidth
import cimgui.internal.CImGui.igCalcListClipping
import cimgui.internal.CImGui.igCalcTextSize_nonUDT
import cimgui.internal.CImGui.igCaptureKeyboardFromApp
import cimgui.internal.CImGui.igCaptureMouseFromApp
import cimgui.internal.CImGui.igCheckbox
import cimgui.internal.CImGui.igCheckboxFlags
import cimgui.internal.CImGui.igCloseCurrentPopup
import cimgui.internal.CImGui.igCollapsingHeader
import cimgui.internal.CImGui.igCollapsingHeaderBoolPtr
import cimgui.internal.CImGui.igColorButton
import cimgui.internal.CImGui.igColorConvertFloat4ToU32
import cimgui.internal.CImGui.igColorConvertHSVtoRGB
import cimgui.internal.CImGui.igColorConvertRGBtoHSV
import cimgui.internal.CImGui.igColorConvertU32ToFloat4_nonUDT
import cimgui.internal.CImGui.igColorEdit3
import cimgui.internal.CImGui.igColorEdit4
import cimgui.internal.CImGui.igColorPicker3
import cimgui.internal.CImGui.igColorPicker4
import cimgui.internal.CImGui.igColumns
import cimgui.internal.CImGui.igComboStr
import cimgui.internal.CImGui.igCreateContext
import cimgui.internal.CImGui.igDebugCheckVersionAndDataLayout
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
import cimgui.internal.CImGui.igGetBackgroundDrawList
import cimgui.internal.CImGui.igGetClipboardText
import cimgui.internal.CImGui.igGetColorU32
import cimgui.internal.CImGui.igGetColorU32U32
import cimgui.internal.CImGui.igGetColorU32Vec4
import cimgui.internal.CImGui.igGetColumnIndex
import cimgui.internal.CImGui.igGetColumnOffset
import cimgui.internal.CImGui.igGetColumnWidth
import cimgui.internal.CImGui.igGetColumnsCount
import cimgui.internal.CImGui.igGetContentRegionAvail_nonUDT
import cimgui.internal.CImGui.igGetContentRegionMax_nonUDT
import cimgui.internal.CImGui.igGetCurrentContext
import cimgui.internal.CImGui.igGetCursorPosX
import cimgui.internal.CImGui.igGetCursorPosY
import cimgui.internal.CImGui.igGetCursorPos_nonUDT
import cimgui.internal.CImGui.igGetCursorScreenPos_nonUDT
import cimgui.internal.CImGui.igGetCursorStartPos_nonUDT
import cimgui.internal.CImGui.igGetDragDropPayload
import cimgui.internal.CImGui.igGetDrawData
import cimgui.internal.CImGui.igGetDrawListSharedData
import cimgui.internal.CImGui.igGetFont
import cimgui.internal.CImGui.igGetFontSize
import cimgui.internal.CImGui.igGetFontTexUvWhitePixel_nonUDT
import cimgui.internal.CImGui.igGetForegroundDrawList
import cimgui.internal.CImGui.igGetFrameCount
import cimgui.internal.CImGui.igGetFrameHeight
import cimgui.internal.CImGui.igGetFrameHeightWithSpacing
import cimgui.internal.CImGui.igGetIDRange
import cimgui.internal.CImGui.igGetIDStr
import cimgui.internal.CImGui.igGetIO
import cimgui.internal.CImGui.igGetItemRectMax_nonUDT
import cimgui.internal.CImGui.igGetItemRectMin_nonUDT
import cimgui.internal.CImGui.igGetItemRectSize_nonUDT
import cimgui.internal.CImGui.igGetKeyIndex
import cimgui.internal.CImGui.igGetKeyPressedAmount
import cimgui.internal.CImGui.igGetMouseCursor
import cimgui.internal.CImGui.igGetMouseDragDelta_nonUDT
import cimgui.internal.CImGui.igGetMousePosOnOpeningCurrentPopup_nonUDT
import cimgui.internal.CImGui.igGetMousePos_nonUDT
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
import cimgui.internal.CImGui.igGetTreeNodeToLabelSpacing
import cimgui.internal.CImGui.igGetVersion
import cimgui.internal.CImGui.igGetWindowContentRegionMax_nonUDT
import cimgui.internal.CImGui.igGetWindowContentRegionMin_nonUDT
import cimgui.internal.CImGui.igGetWindowContentRegionWidth
import cimgui.internal.CImGui.igGetWindowDrawList
import cimgui.internal.CImGui.igGetWindowHeight
import cimgui.internal.CImGui.igGetWindowPos_nonUDT
import cimgui.internal.CImGui.igGetWindowSize_nonUDT
import cimgui.internal.CImGui.igGetWindowWidth
import cimgui.internal.CImGui.igImage
import cimgui.internal.CImGui.igImageButton
import cimgui.internal.CImGui.igIndent
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
import cimgui.internal.CImGui.igIsAnyItemActive
import cimgui.internal.CImGui.igIsAnyItemFocused
import cimgui.internal.CImGui.igIsAnyItemHovered
import cimgui.internal.CImGui.igIsAnyMouseDown
import cimgui.internal.CImGui.igIsItemActivated
import cimgui.internal.CImGui.igIsItemActive
import cimgui.internal.CImGui.igIsItemClicked
import cimgui.internal.CImGui.igIsItemDeactivated
import cimgui.internal.CImGui.igIsItemDeactivatedAfterEdit
import cimgui.internal.CImGui.igIsItemEdited
import cimgui.internal.CImGui.igIsItemFocused
import cimgui.internal.CImGui.igIsItemHovered
import cimgui.internal.CImGui.igIsItemToggledOpen
import cimgui.internal.CImGui.igIsItemVisible
import cimgui.internal.CImGui.igIsKeyDown
import cimgui.internal.CImGui.igIsKeyPressed
import cimgui.internal.CImGui.igIsKeyReleased
import cimgui.internal.CImGui.igIsMouseClicked
import cimgui.internal.CImGui.igIsMouseDoubleClicked
import cimgui.internal.CImGui.igIsMouseDown
import cimgui.internal.CImGui.igIsMouseDragging
import cimgui.internal.CImGui.igIsMouseHoveringRect
import cimgui.internal.CImGui.igIsMousePosValid
import cimgui.internal.CImGui.igIsMouseReleased
import cimgui.internal.CImGui.igIsPopupOpen
import cimgui.internal.CImGui.igIsRectVisible
import cimgui.internal.CImGui.igIsRectVisibleVec2
import cimgui.internal.CImGui.igIsWindowAppearing
import cimgui.internal.CImGui.igIsWindowCollapsed
import cimgui.internal.CImGui.igIsWindowFocused
import cimgui.internal.CImGui.igIsWindowHovered
import cimgui.internal.CImGui.igLabelText
import cimgui.internal.CImGui.igListBoxFooter
import cimgui.internal.CImGui.igListBoxHeaderInt
import cimgui.internal.CImGui.igListBoxHeaderVec2
import cimgui.internal.CImGui.igLoadIniSettingsFromDisk
import cimgui.internal.CImGui.igLoadIniSettingsFromMemory
import cimgui.internal.CImGui.igLogButtons
import cimgui.internal.CImGui.igLogFinish
import cimgui.internal.CImGui.igLogText
import cimgui.internal.CImGui.igLogToClipboard
import cimgui.internal.CImGui.igLogToFile
import cimgui.internal.CImGui.igLogToTTY
import cimgui.internal.CImGui.igMenuItemBool
import cimgui.internal.CImGui.igMenuItemBoolPtr
import cimgui.internal.CImGui.igNewFrame
import cimgui.internal.CImGui.igNewLine
import cimgui.internal.CImGui.igNextColumn
import cimgui.internal.CImGui.igOpenPopup
import cimgui.internal.CImGui.igOpenPopupOnItemClick
import cimgui.internal.CImGui.igPopAllowKeyboardFocus
import cimgui.internal.CImGui.igPopButtonRepeat
import cimgui.internal.CImGui.igPopClipRect
import cimgui.internal.CImGui.igPopFont
import cimgui.internal.CImGui.igPopID
import cimgui.internal.CImGui.igPopItemWidth
import cimgui.internal.CImGui.igPopStyleColor
import cimgui.internal.CImGui.igPopStyleVar
import cimgui.internal.CImGui.igPopTextWrapPos
import cimgui.internal.CImGui.igProgressBar
import cimgui.internal.CImGui.igPushAllowKeyboardFocus
import cimgui.internal.CImGui.igPushButtonRepeat
import cimgui.internal.CImGui.igPushClipRect
import cimgui.internal.CImGui.igPushFont
import cimgui.internal.CImGui.igPushIDInt
import cimgui.internal.CImGui.igPushIDRange
import cimgui.internal.CImGui.igPushIDStr
import cimgui.internal.CImGui.igPushItemWidth
import cimgui.internal.CImGui.igPushStyleColor
import cimgui.internal.CImGui.igPushStyleColorU32
import cimgui.internal.CImGui.igPushStyleVarFloat
import cimgui.internal.CImGui.igPushStyleVarVec2
import cimgui.internal.CImGui.igPushTextWrapPos
import cimgui.internal.CImGui.igRadioButtonBool
import cimgui.internal.CImGui.igRadioButtonIntPtr
import cimgui.internal.CImGui.igRender
import cimgui.internal.CImGui.igResetMouseDragDelta
import cimgui.internal.CImGui.igSameLine
import cimgui.internal.CImGui.igSaveIniSettingsToDisk
import cimgui.internal.CImGui.igSaveIniSettingsToMemory
import cimgui.internal.CImGui.igSelectable
import cimgui.internal.CImGui.igSelectableBoolPtr
import cimgui.internal.CImGui.igSeparator
import cimgui.internal.CImGui.igSetClipboardText
import cimgui.internal.CImGui.igSetColorEditOptions
import cimgui.internal.CImGui.igSetColumnOffset
import cimgui.internal.CImGui.igSetColumnWidth
import cimgui.internal.CImGui.igSetCurrentContext
import cimgui.internal.CImGui.igSetCursorPos
import cimgui.internal.CImGui.igSetCursorPosX
import cimgui.internal.CImGui.igSetCursorPosY
import cimgui.internal.CImGui.igSetCursorScreenPos
import cimgui.internal.CImGui.igSetItemAllowOverlap
import cimgui.internal.CImGui.igSetItemDefaultFocus
import cimgui.internal.CImGui.igSetKeyboardFocusHere
import cimgui.internal.CImGui.igSetMouseCursor
import cimgui.internal.CImGui.igSetNextItemOpen
import cimgui.internal.CImGui.igSetNextItemWidth
import cimgui.internal.CImGui.igSetNextWindowBgAlpha
import cimgui.internal.CImGui.igSetNextWindowCollapsed
import cimgui.internal.CImGui.igSetNextWindowContentSize
import cimgui.internal.CImGui.igSetNextWindowFocus
import cimgui.internal.CImGui.igSetNextWindowPos
import cimgui.internal.CImGui.igSetNextWindowSize
import cimgui.internal.CImGui.igSetScrollFromPosX
import cimgui.internal.CImGui.igSetScrollFromPosY
import cimgui.internal.CImGui.igSetScrollHereX
import cimgui.internal.CImGui.igSetScrollHereY
import cimgui.internal.CImGui.igSetScrollX
import cimgui.internal.CImGui.igSetScrollY
import cimgui.internal.CImGui.igSetStateStorage
import cimgui.internal.CImGui.igSetTabItemClosed
import cimgui.internal.CImGui.igSetTooltip
import cimgui.internal.CImGui.igSetWindowCollapsedBool
import cimgui.internal.CImGui.igSetWindowCollapsedStr
import cimgui.internal.CImGui.igSetWindowFocus
import cimgui.internal.CImGui.igSetWindowFocusStr
import cimgui.internal.CImGui.igSetWindowFontScale
import cimgui.internal.CImGui.igSetWindowPosStr
import cimgui.internal.CImGui.igSetWindowPosVec2
import cimgui.internal.CImGui.igSetWindowSizeStr
import cimgui.internal.CImGui.igSetWindowSizeVec2
import cimgui.internal.CImGui.igShowAboutWindow
import cimgui.internal.CImGui.igShowDemoWindow
import cimgui.internal.CImGui.igShowFontSelector
import cimgui.internal.CImGui.igShowMetricsWindow
import cimgui.internal.CImGui.igShowStyleEditor
import cimgui.internal.CImGui.igShowStyleSelector
import cimgui.internal.CImGui.igShowUserGuide
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
import cimgui.internal.CImGui.igStyleColorsClassic
import cimgui.internal.CImGui.igStyleColorsDark
import cimgui.internal.CImGui.igStyleColorsLight
import cimgui.internal.CImGui.igText
import cimgui.internal.CImGui.igTextColored
import cimgui.internal.CImGui.igTextDisabled
import cimgui.internal.CImGui.igTextUnformatted
import cimgui.internal.CImGui.igTextWrapped
import cimgui.internal.CImGui.igTreeNodeExStr
import cimgui.internal.CImGui.igTreeNodeExStrStr
import cimgui.internal.CImGui.igTreeNodeStr
import cimgui.internal.CImGui.igTreeNodeStrStr
import cimgui.internal.CImGui.igTreePop
import cimgui.internal.CImGui.igTreePushPtr
import cimgui.internal.CImGui.igTreePushStr
import cimgui.internal.CImGui.igUnindent
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

    actual fun alignTextToFramePadding() {
        igAlignTextToFramePadding()
    }

    actual fun arrowButton(strId: String, dir: ImGuiDir): Boolean = igArrowButton(strId, dir.value)

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
        igBeginChild(strId, ptrSize, border, flags?.value ?: 0)
    }

    actual fun beginChild(
        id: ImGuiID,
        size: Vec2,
        border: Boolean,
        flags: Flag<ImGuiWindowFlags>?
    ): Boolean = usingVec2 { ptrSize -> 
        igBeginChildID(id.value, ptrSize, border, flags?.value ?: 0)
    }

    actual fun beginChildFrame(
        id: ImGuiID,
        size: Vec2,
        flags: Flag<ImGuiWindowFlags>?
    ): Boolean = usingVec2 { ptrSize -> 
        igBeginChildFrame(id.value, ptrSize, flags?.value ?: 0)
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

    actual fun beginPopupContextItem(strId: String?, mouseButton: Int): Boolean =
            igBeginPopupContextItem(strId, mouseButton)

    actual fun beginPopupContextVoid(strId: String?, mouseButton: Int): Boolean =
            igBeginPopupContextVoid(strId, mouseButton)

    actual fun beginPopupContextWindow(
        strId: String?,
        mouseButton: Int,
        alsoOverItems: Boolean
    ): Boolean = igBeginPopupContextWindow(strId, mouseButton, alsoOverItems)

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

    actual fun bullet() {
        igBullet()
    }

    actual fun bulletText(fmt: String) {
        igBulletText(fmt)
    }

    actual fun button(label: String, size: Vec2): Boolean = usingVec2 { ptrSize -> 
        igButton(label, ptrSize)
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

    actual fun calcTextSize(
        text: String,
        textEnd: String?,
        hideTextAfterDoubleHash: Boolean,
        wrapWidth: Float
    ): Vec2 = returnVec2 { returnVal ->
        igCalcTextSize_nonUDT(returnVal, text, textEnd, hideTextAfterDoubleHash, wrapWidth)
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

    actual fun closeCurrentPopup() {
        igCloseCurrentPopup()
    }

    actual fun collapsingHeader(label: String, flags: Flag<ImGuiTreeNodeFlags>?): Boolean =
            igCollapsingHeader(label, flags?.value ?: 0)

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

    actual fun colorConvertU32ToFloat4(`in`: UInt): Vec4 = returnVec4 { returnVal ->
        igColorConvertU32ToFloat4_nonUDT(returnVal, `in`.toLong())
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

    actual fun getBackgroundDrawList(): ImDrawList = igGetBackgroundDrawList()!!.let(::ImDrawList)

    actual fun getClipboardText(): String? = igGetClipboardText()

    actual fun getColorU32(idx: ImGuiCol, alphaMul: Float): UInt = igGetColorU32(idx.value,
            alphaMul).toUInt()

    actual fun getColorU32(col: Vec4): UInt = usingVec4 { ptrCol -> 
        igGetColorU32Vec4(ptrCol)
    }.toUInt()

    actual fun getColorU32(col: UInt): UInt = igGetColorU32U32(col.toLong()).toUInt()

    actual fun getColumnIndex(): Int = igGetColumnIndex()

    actual fun getColumnOffset(columnIndex: Int): Float = igGetColumnOffset(columnIndex)

    actual fun getColumnWidth(columnIndex: Int): Float = igGetColumnWidth(columnIndex)

    actual fun getColumnsCount(): Int = igGetColumnsCount()

    actual fun getContentRegionAvail(): Vec2 = returnVec2 { returnVal ->
        igGetContentRegionAvail_nonUDT(returnVal)
    }

    actual fun getContentRegionMax(): Vec2 = returnVec2 { returnVal ->
        igGetContentRegionMax_nonUDT(returnVal)
    }

    actual fun getCurrentContext(): ImGuiContext = igGetCurrentContext()!!.let(::ImGuiContext)

    actual fun getCursorPos(): Vec2 = returnVec2 { returnVal ->
        igGetCursorPos_nonUDT(returnVal)
    }

    actual fun getCursorPosX(): Float = igGetCursorPosX()

    actual fun getCursorPosY(): Float = igGetCursorPosY()

    actual fun getCursorScreenPos(): Vec2 = returnVec2 { returnVal ->
        igGetCursorScreenPos_nonUDT(returnVal)
    }

    actual fun getCursorStartPos(): Vec2 = returnVec2 { returnVal ->
        igGetCursorStartPos_nonUDT(returnVal)
    }

    actual fun getDragDropPayload(): ImGuiPayload = igGetDragDropPayload()!!.let(::ImGuiPayload)

    actual fun getDrawData(): ImDrawData = igGetDrawData()!!.let(::ImDrawData)

    actual fun getDrawListSharedData(): ImDrawListSharedData =
            igGetDrawListSharedData()!!.let(::ImDrawListSharedData)

    actual fun getFont(): ImFont = igGetFont()!!.let(::ImFont)

    actual fun getFontSize(): Float = igGetFontSize()

    actual fun getFontTexUvWhitePixel(): Vec2 = returnVec2 { returnVal ->
        igGetFontTexUvWhitePixel_nonUDT(returnVal)
    }

    actual fun getForegroundDrawList(): ImDrawList = igGetForegroundDrawList()!!.let(::ImDrawList)

    actual fun getFrameCount(): Int = igGetFrameCount()

    actual fun getFrameHeight(): Float = igGetFrameHeight()

    actual fun getFrameHeightWithSpacing(): Float = igGetFrameHeightWithSpacing()

    actual fun getID(strId: String): ImGuiID = igGetIDStr(strId).let(::ImGuiID)

    actual fun getID(strIdBegin: String, strIdEnd: String): ImGuiID = igGetIDRange(strIdBegin,
            strIdEnd).let(::ImGuiID)

    actual fun getIO(): ImGuiIO = igGetIO()!!.let(::ImGuiIO)

    actual fun getItemRectMax(): Vec2 = returnVec2 { returnVal ->
        igGetItemRectMax_nonUDT(returnVal)
    }

    actual fun getItemRectMin(): Vec2 = returnVec2 { returnVal ->
        igGetItemRectMin_nonUDT(returnVal)
    }

    actual fun getItemRectSize(): Vec2 = returnVec2 { returnVal ->
        igGetItemRectSize_nonUDT(returnVal)
    }

    actual fun getKeyIndex(imguiKey: ImGuiKey): Int = igGetKeyIndex(imguiKey.value)

    actual fun getKeyPressedAmount(
        keyIndex: Int,
        repeatDelay: Float,
        rate: Float
    ): Int = igGetKeyPressedAmount(keyIndex, repeatDelay, rate)

    actual fun getMouseCursor(): ImGuiMouseCursor = igGetMouseCursor().let {
            ImGuiMouseCursor.from(it) }

    actual fun getMouseDragDelta(button: Int, lockThreshold: Float): Vec2 = returnVec2 {
            returnVal ->
        igGetMouseDragDelta_nonUDT(returnVal, button, lockThreshold)
    }

    actual fun getMousePos(): Vec2 = returnVec2 { returnVal ->
        igGetMousePos_nonUDT(returnVal)
    }

    actual fun getMousePosOnOpeningCurrentPopup(): Vec2 = returnVec2 { returnVal ->
        igGetMousePosOnOpeningCurrentPopup_nonUDT(returnVal)
    }

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

    actual fun getTreeNodeToLabelSpacing(): Float = igGetTreeNodeToLabelSpacing()

    actual fun getVersion(): String? = igGetVersion()

    actual fun getWindowContentRegionMax(): Vec2 = returnVec2 { returnVal ->
        igGetWindowContentRegionMax_nonUDT(returnVal)
    }

    actual fun getWindowContentRegionMin(): Vec2 = returnVec2 { returnVal ->
        igGetWindowContentRegionMin_nonUDT(returnVal)
    }

    actual fun getWindowContentRegionWidth(): Float = igGetWindowContentRegionWidth()

    actual fun getWindowDrawList(): ImDrawList = igGetWindowDrawList()!!.let(::ImDrawList)

    actual fun getWindowHeight(): Float = igGetWindowHeight()

    actual fun getWindowPos(): Vec2 = returnVec2 { returnVal ->
        igGetWindowPos_nonUDT(returnVal)
    }

    actual fun getWindowSize(): Vec2 = returnVec2 { returnVal ->
        igGetWindowSize_nonUDT(returnVal)
    }

    actual fun getWindowWidth(): Float = igGetWindowWidth()

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

    actual fun indent(indentW: Float) {
        igIndent(indentW)
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

    actual fun isAnyItemActive(): Boolean = igIsAnyItemActive()

    actual fun isAnyItemFocused(): Boolean = igIsAnyItemFocused()

    actual fun isAnyItemHovered(): Boolean = igIsAnyItemHovered()

    actual fun isAnyMouseDown(): Boolean = igIsAnyMouseDown()

    actual fun isItemActivated(): Boolean = igIsItemActivated()

    actual fun isItemActive(): Boolean = igIsItemActive()

    actual fun isItemClicked(mouseButton: Int): Boolean = igIsItemClicked(mouseButton)

    actual fun isItemDeactivated(): Boolean = igIsItemDeactivated()

    actual fun isItemDeactivatedAfterEdit(): Boolean = igIsItemDeactivatedAfterEdit()

    actual fun isItemEdited(): Boolean = igIsItemEdited()

    actual fun isItemFocused(): Boolean = igIsItemFocused()

    actual fun isItemHovered(flags: Flag<ImGuiHoveredFlags>?): Boolean =
            igIsItemHovered(flags?.value ?: 0)

    actual fun isItemToggledOpen(): Boolean = igIsItemToggledOpen()

    actual fun isItemVisible(): Boolean = igIsItemVisible()

    actual fun isKeyDown(userKeyIndex: Int): Boolean = igIsKeyDown(userKeyIndex)

    actual fun isKeyPressed(userKeyIndex: Int, repeat: Boolean): Boolean =
            igIsKeyPressed(userKeyIndex, repeat)

    actual fun isKeyReleased(userKeyIndex: Int): Boolean = igIsKeyReleased(userKeyIndex)

    actual fun isMouseClicked(button: Int, repeat: Boolean): Boolean = igIsMouseClicked(button,
            repeat)

    actual fun isMouseDoubleClicked(button: Int): Boolean = igIsMouseDoubleClicked(button)

    actual fun isMouseDown(button: Int): Boolean = igIsMouseDown(button)

    actual fun isMouseDragging(button: Int, lockThreshold: Float): Boolean =
            igIsMouseDragging(button, lockThreshold)

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

    actual fun isMouseReleased(button: Int): Boolean = igIsMouseReleased(button)

    actual fun isPopupOpen(strId: String): Boolean = igIsPopupOpen(strId)

    actual fun isRectVisible(size: Vec2): Boolean = usingVec2 { ptrSize -> 
        igIsRectVisible(ptrSize)
    }

    actual fun isRectVisible(rectMin: Vec2, rectMax: Vec2): Boolean = usingVec2 { ptrRectMin -> 
        usingVec2 { ptrRectMax -> 
            igIsRectVisibleVec2(ptrRectMin, ptrRectMax)
        }
    }

    actual fun isWindowAppearing(): Boolean = igIsWindowAppearing()

    actual fun isWindowCollapsed(): Boolean = igIsWindowCollapsed()

    actual fun isWindowFocused(flags: Flag<ImGuiFocusedFlags>?): Boolean =
            igIsWindowFocused(flags?.value ?: 0)

    actual fun isWindowHovered(flags: Flag<ImGuiHoveredFlags>?): Boolean =
            igIsWindowHovered(flags?.value ?: 0)

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

    actual fun logText(fmt: String) {
        igLogText(fmt)
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

    actual fun openPopupOnItemClick(strId: String?, mouseButton: Int): Boolean =
            igOpenPopupOnItemClick(strId, mouseButton)

    actual fun popAllowKeyboardFocus() {
        igPopAllowKeyboardFocus()
    }

    actual fun popButtonRepeat() {
        igPopButtonRepeat()
    }

    actual fun popClipRect() {
        igPopClipRect()
    }

    actual fun popFont() {
        igPopFont()
    }

    actual fun popID() {
        igPopID()
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

    actual fun pushFont(font: ImFont) {
        igPushFont(font.ptr)
    }

    actual fun pushID(strId: String) {
        igPushIDStr(strId)
    }

    actual fun pushID(strIdBegin: String, strIdEnd: String) {
        igPushIDRange(strIdBegin, strIdEnd)
    }

    actual fun pushID(intId: Int) {
        igPushIDInt(intId)
    }

    actual fun pushItemWidth(itemWidth: Float) {
        igPushItemWidth(itemWidth)
    }

    actual fun pushStyleColor(idx: ImGuiCol, col: UInt) {
        igPushStyleColorU32(idx.value, col.toLong())
    }

    actual fun pushStyleColor(idx: ImGuiCol, col: Vec4) {
        usingVec4 { ptrCol -> 
            igPushStyleColor(idx.value, ptrCol)
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

    actual fun resetMouseDragDelta(button: Int) {
        igResetMouseDragDelta(button)
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
        igSelectable(label, selected, flags?.value ?: 0, ptrSize)
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

    actual fun setItemAllowOverlap() {
        igSetItemAllowOverlap()
    }

    actual fun setItemDefaultFocus() {
        igSetItemDefaultFocus()
    }

    actual fun setKeyboardFocusHere(offset: Int) {
        igSetKeyboardFocusHere(offset)
    }

    actual fun setMouseCursor(type: ImGuiMouseCursor) {
        igSetMouseCursor(type.value)
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

    actual fun setNextWindowSize(size: Vec2, cond: Flag<ImGuiCond>?) {
        usingVec2 { ptrSize -> 
            igSetNextWindowSize(ptrSize, cond?.value ?: 0)
        }
    }

    actual fun setScrollFromPosX(localX: Float, centerXRatio: Float) {
        igSetScrollFromPosX(localX, centerXRatio)
    }

    actual fun setScrollFromPosY(localY: Float, centerYRatio: Float) {
        igSetScrollFromPosY(localY, centerYRatio)
    }

    actual fun setScrollHereX(centerXRatio: Float) {
        igSetScrollHereX(centerXRatio)
    }

    actual fun setScrollHereY(centerYRatio: Float) {
        igSetScrollHereY(centerYRatio)
    }

    actual fun setScrollX(scrollX: Float) {
        igSetScrollX(scrollX)
    }

    actual fun setScrollY(scrollY: Float) {
        igSetScrollY(scrollY)
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

    actual fun setWindowFocus() {
        igSetWindowFocus()
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

    actual fun styleColorsClassic(dst: ImGuiStyle?) {
        igStyleColorsClassic(dst?.ptr)
    }

    actual fun styleColorsDark(dst: ImGuiStyle?) {
        igStyleColorsDark(dst?.ptr)
    }

    actual fun styleColorsLight(dst: ImGuiStyle?) {
        igStyleColorsLight(dst?.ptr)
    }

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

    actual fun textUnformatted(text: String, textEnd: String?) {
        igTextUnformatted(text, textEnd)
    }

    actual fun textWrapped(fmt: String) {
        igTextWrapped(fmt)
    }

    actual fun treeNode(label: String): Boolean = igTreeNodeStr(label)

    actual fun treeNode(strId: String, fmt: String): Boolean = igTreeNodeStrStr(strId, fmt)

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

    actual fun unindent(indentW: Float) {
        igUnindent(indentW)
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
