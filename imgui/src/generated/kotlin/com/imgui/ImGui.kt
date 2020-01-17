package com.imgui

import cimgui.internal.igAcceptDragDropPayload
import cimgui.internal.igAlignTextToFramePadding
import cimgui.internal.igArrowButton
import cimgui.internal.igBegin
import cimgui.internal.igBeginChild
import cimgui.internal.igBeginChildFrame
import cimgui.internal.igBeginChildID
import cimgui.internal.igBeginCombo
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
import cimgui.internal.igBeginPopupModal
import cimgui.internal.igBeginTabBar
import cimgui.internal.igBeginTabItem
import cimgui.internal.igBeginTooltip
import cimgui.internal.igBullet
import cimgui.internal.igBulletText
import cimgui.internal.igButton
import cimgui.internal.igCalcItemWidth
import cimgui.internal.igCalcListClipping
import cimgui.internal.igCalcTextSize
import cimgui.internal.igCaptureKeyboardFromApp
import cimgui.internal.igCaptureMouseFromApp
import cimgui.internal.igCheckbox
import cimgui.internal.igCheckboxFlags
import cimgui.internal.igCloseCurrentPopup
import cimgui.internal.igCollapsingHeader
import cimgui.internal.igCollapsingHeaderBoolPtr
import cimgui.internal.igColorButton
import cimgui.internal.igColorConvertFloat4ToU32
import cimgui.internal.igColorConvertHSVtoRGB
import cimgui.internal.igColorConvertRGBtoHSV
import cimgui.internal.igColorConvertU32ToFloat4
import cimgui.internal.igColorEdit3
import cimgui.internal.igColorEdit4
import cimgui.internal.igColorPicker3
import cimgui.internal.igColorPicker4
import cimgui.internal.igColumns
import cimgui.internal.igComboStr
import cimgui.internal.igCreateContext
import cimgui.internal.igDebugCheckVersionAndDataLayout
import cimgui.internal.igDestroyContext
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
import cimgui.internal.igGetBackgroundDrawList
import cimgui.internal.igGetClipboardText
import cimgui.internal.igGetColorU32
import cimgui.internal.igGetColorU32U32
import cimgui.internal.igGetColorU32Vec4
import cimgui.internal.igGetColumnIndex
import cimgui.internal.igGetColumnOffset
import cimgui.internal.igGetColumnWidth
import cimgui.internal.igGetColumnsCount
import cimgui.internal.igGetContentRegionAvail
import cimgui.internal.igGetContentRegionMax
import cimgui.internal.igGetCurrentContext
import cimgui.internal.igGetCursorPos
import cimgui.internal.igGetCursorPosX
import cimgui.internal.igGetCursorPosY
import cimgui.internal.igGetCursorScreenPos
import cimgui.internal.igGetCursorStartPos
import cimgui.internal.igGetDragDropPayload
import cimgui.internal.igGetDrawData
import cimgui.internal.igGetDrawListSharedData
import cimgui.internal.igGetFont
import cimgui.internal.igGetFontSize
import cimgui.internal.igGetFontTexUvWhitePixel
import cimgui.internal.igGetForegroundDrawList
import cimgui.internal.igGetFrameCount
import cimgui.internal.igGetFrameHeight
import cimgui.internal.igGetFrameHeightWithSpacing
import cimgui.internal.igGetIDRange
import cimgui.internal.igGetIDStr
import cimgui.internal.igGetIO
import cimgui.internal.igGetItemRectMax
import cimgui.internal.igGetItemRectMin
import cimgui.internal.igGetItemRectSize
import cimgui.internal.igGetKeyIndex
import cimgui.internal.igGetKeyPressedAmount
import cimgui.internal.igGetMouseCursor
import cimgui.internal.igGetMouseDragDelta
import cimgui.internal.igGetMousePos
import cimgui.internal.igGetMousePosOnOpeningCurrentPopup
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
import cimgui.internal.igGetTreeNodeToLabelSpacing
import cimgui.internal.igGetVersion
import cimgui.internal.igGetWindowContentRegionMax
import cimgui.internal.igGetWindowContentRegionMin
import cimgui.internal.igGetWindowContentRegionWidth
import cimgui.internal.igGetWindowDrawList
import cimgui.internal.igGetWindowHeight
import cimgui.internal.igGetWindowPos
import cimgui.internal.igGetWindowSize
import cimgui.internal.igGetWindowWidth
import cimgui.internal.igImage
import cimgui.internal.igImageButton
import cimgui.internal.igIndent
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
import cimgui.internal.igIsAnyItemActive
import cimgui.internal.igIsAnyItemFocused
import cimgui.internal.igIsAnyItemHovered
import cimgui.internal.igIsAnyMouseDown
import cimgui.internal.igIsItemActivated
import cimgui.internal.igIsItemActive
import cimgui.internal.igIsItemClicked
import cimgui.internal.igIsItemDeactivated
import cimgui.internal.igIsItemDeactivatedAfterEdit
import cimgui.internal.igIsItemEdited
import cimgui.internal.igIsItemFocused
import cimgui.internal.igIsItemHovered
import cimgui.internal.igIsItemToggledOpen
import cimgui.internal.igIsItemVisible
import cimgui.internal.igIsKeyDown
import cimgui.internal.igIsKeyPressed
import cimgui.internal.igIsKeyReleased
import cimgui.internal.igIsMouseClicked
import cimgui.internal.igIsMouseDoubleClicked
import cimgui.internal.igIsMouseDown
import cimgui.internal.igIsMouseDragging
import cimgui.internal.igIsMouseHoveringRect
import cimgui.internal.igIsMousePosValid
import cimgui.internal.igIsMouseReleased
import cimgui.internal.igIsPopupOpen
import cimgui.internal.igIsRectVisible
import cimgui.internal.igIsRectVisibleVec2
import cimgui.internal.igIsWindowAppearing
import cimgui.internal.igIsWindowCollapsed
import cimgui.internal.igIsWindowFocused
import cimgui.internal.igIsWindowHovered
import cimgui.internal.igLabelText
import cimgui.internal.igListBoxFooter
import cimgui.internal.igListBoxHeaderInt
import cimgui.internal.igListBoxHeaderVec2
import cimgui.internal.igLoadIniSettingsFromDisk
import cimgui.internal.igLoadIniSettingsFromMemory
import cimgui.internal.igLogButtons
import cimgui.internal.igLogFinish
import cimgui.internal.igLogText
import cimgui.internal.igLogToClipboard
import cimgui.internal.igLogToFile
import cimgui.internal.igLogToTTY
import cimgui.internal.igMenuItemBool
import cimgui.internal.igMenuItemBoolPtr
import cimgui.internal.igNewFrame
import cimgui.internal.igNewLine
import cimgui.internal.igNextColumn
import cimgui.internal.igOpenPopup
import cimgui.internal.igOpenPopupOnItemClick
import cimgui.internal.igPopAllowKeyboardFocus
import cimgui.internal.igPopButtonRepeat
import cimgui.internal.igPopClipRect
import cimgui.internal.igPopFont
import cimgui.internal.igPopID
import cimgui.internal.igPopItemWidth
import cimgui.internal.igPopStyleColor
import cimgui.internal.igPopStyleVar
import cimgui.internal.igPopTextWrapPos
import cimgui.internal.igProgressBar
import cimgui.internal.igPushAllowKeyboardFocus
import cimgui.internal.igPushButtonRepeat
import cimgui.internal.igPushClipRect
import cimgui.internal.igPushFont
import cimgui.internal.igPushIDInt
import cimgui.internal.igPushIDRange
import cimgui.internal.igPushIDStr
import cimgui.internal.igPushItemWidth
import cimgui.internal.igPushStyleColor
import cimgui.internal.igPushStyleColorU32
import cimgui.internal.igPushStyleVarFloat
import cimgui.internal.igPushStyleVarVec2
import cimgui.internal.igPushTextWrapPos
import cimgui.internal.igRadioButtonBool
import cimgui.internal.igRadioButtonIntPtr
import cimgui.internal.igRender
import cimgui.internal.igResetMouseDragDelta
import cimgui.internal.igSameLine
import cimgui.internal.igSaveIniSettingsToDisk
import cimgui.internal.igSaveIniSettingsToMemory
import cimgui.internal.igSelectable
import cimgui.internal.igSelectableBoolPtr
import cimgui.internal.igSeparator
import cimgui.internal.igSetClipboardText
import cimgui.internal.igSetColorEditOptions
import cimgui.internal.igSetColumnOffset
import cimgui.internal.igSetColumnWidth
import cimgui.internal.igSetCurrentContext
import cimgui.internal.igSetCursorPos
import cimgui.internal.igSetCursorPosX
import cimgui.internal.igSetCursorPosY
import cimgui.internal.igSetCursorScreenPos
import cimgui.internal.igSetItemAllowOverlap
import cimgui.internal.igSetItemDefaultFocus
import cimgui.internal.igSetKeyboardFocusHere
import cimgui.internal.igSetMouseCursor
import cimgui.internal.igSetNextItemOpen
import cimgui.internal.igSetNextItemWidth
import cimgui.internal.igSetNextWindowBgAlpha
import cimgui.internal.igSetNextWindowCollapsed
import cimgui.internal.igSetNextWindowContentSize
import cimgui.internal.igSetNextWindowFocus
import cimgui.internal.igSetNextWindowPos
import cimgui.internal.igSetNextWindowSize
import cimgui.internal.igSetScrollFromPosX
import cimgui.internal.igSetScrollFromPosY
import cimgui.internal.igSetScrollHereX
import cimgui.internal.igSetScrollHereY
import cimgui.internal.igSetScrollX
import cimgui.internal.igSetScrollY
import cimgui.internal.igSetStateStorage
import cimgui.internal.igSetTabItemClosed
import cimgui.internal.igSetTooltip
import cimgui.internal.igSetWindowCollapsedBool
import cimgui.internal.igSetWindowCollapsedStr
import cimgui.internal.igSetWindowFocus
import cimgui.internal.igSetWindowFocusStr
import cimgui.internal.igSetWindowFontScale
import cimgui.internal.igSetWindowPosStr
import cimgui.internal.igSetWindowPosVec2
import cimgui.internal.igSetWindowSizeStr
import cimgui.internal.igSetWindowSizeVec2
import cimgui.internal.igShowAboutWindow
import cimgui.internal.igShowDemoWindow
import cimgui.internal.igShowFontSelector
import cimgui.internal.igShowMetricsWindow
import cimgui.internal.igShowStyleEditor
import cimgui.internal.igShowStyleSelector
import cimgui.internal.igShowUserGuide
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
import cimgui.internal.igStyleColorsClassic
import cimgui.internal.igStyleColorsDark
import cimgui.internal.igStyleColorsLight
import cimgui.internal.igText
import cimgui.internal.igTextColored
import cimgui.internal.igTextDisabled
import cimgui.internal.igTextUnformatted
import cimgui.internal.igTextWrapped
import cimgui.internal.igTreeNodeExStr
import cimgui.internal.igTreeNodeExStrStr
import cimgui.internal.igTreeNodeStr
import cimgui.internal.igTreeNodeStrStr
import cimgui.internal.igTreePop
import cimgui.internal.igTreePushPtr
import cimgui.internal.igTreePushStr
import cimgui.internal.igUnindent
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
import kotlinx.cinterop.toKString
import kotlinx.cinterop.usePinned

object ImGui {
    fun acceptDragDropPayload(type: String, flags: Flag<ImGuiDragDropFlags>? = null): ImGuiPayload =
            igAcceptDragDropPayload(type, flags?.value ?: 0)!!.let(::ImGuiPayload)

    fun alignTextToFramePadding() {
        igAlignTextToFramePadding()
    }

    fun arrowButton(strId: String, dir: ImGuiDir): Boolean = igArrowButton(strId, dir.value)

    fun begin(
        name: String,
        pOpen: KMutableProperty0<Boolean>? = null,
        flags: Flag<ImGuiWindowFlags>? = null
    ): Boolean = usingPropertyN(pOpen) { ptrPOpen ->
        igBegin(name, ptrPOpen, flags?.value ?: 0)
    }

    fun beginChild(
        strId: String,
        size: Vec2 = Vec2.Zero,
        border: Boolean = false,
        flags: Flag<ImGuiWindowFlags>? = null
    ): Boolean = igBeginChild(strId, size.toCValue(), border, flags?.value ?: 0)

    fun beginChild(
        id: ImGuiID,
        size: Vec2 = Vec2.Zero,
        border: Boolean = false,
        flags: Flag<ImGuiWindowFlags>? = null
    ): Boolean = igBeginChildID(id.value, size.toCValue(), border, flags?.value ?: 0)

    fun beginChildFrame(
        id: ImGuiID,
        size: Vec2,
        flags: Flag<ImGuiWindowFlags>? = null
    ): Boolean = igBeginChildFrame(id.value, size.toCValue(), flags?.value ?: 0)

    fun beginCombo(
        label: String,
        previewValue: String,
        flags: Flag<ImGuiComboFlags>? = null
    ): Boolean = igBeginCombo(label, previewValue, flags?.value ?: 0)

    fun beginDragDropSource(flags: Flag<ImGuiDragDropFlags>? = null): Boolean =
            igBeginDragDropSource(flags?.value ?: 0)

    fun beginDragDropTarget(): Boolean = igBeginDragDropTarget()

    fun beginGroup() {
        igBeginGroup()
    }

    fun beginMainMenuBar(): Boolean = igBeginMainMenuBar()

    fun beginMenu(label: String, enabled: Boolean = true): Boolean = igBeginMenu(label, enabled)

    fun beginMenuBar(): Boolean = igBeginMenuBar()

    fun beginPopup(strId: String, flags: Flag<ImGuiWindowFlags>? = null): Boolean =
            igBeginPopup(strId, flags?.value ?: 0)

    fun beginPopupContextItem(strId: String? = null, mouseButton: Int = 1): Boolean =
            igBeginPopupContextItem(strId, mouseButton)

    fun beginPopupContextVoid(strId: String? = null, mouseButton: Int = 1): Boolean =
            igBeginPopupContextVoid(strId, mouseButton)

    fun beginPopupContextWindow(
        strId: String? = null,
        mouseButton: Int = 1,
        alsoOverItems: Boolean = true
    ): Boolean = igBeginPopupContextWindow(strId, mouseButton, alsoOverItems)

    fun beginPopupModal(
        name: String,
        pOpen: KMutableProperty0<Boolean>? = null,
        flags: Flag<ImGuiWindowFlags>? = null
    ): Boolean = usingPropertyN(pOpen) { ptrPOpen ->
        igBeginPopupModal(name, ptrPOpen, flags?.value ?: 0)
    }

    fun beginTabBar(strId: String, flags: Flag<ImGuiTabBarFlags>? = null): Boolean =
            igBeginTabBar(strId, flags?.value ?: 0)

    fun beginTabItem(
        label: String,
        pOpen: KMutableProperty0<Boolean>? = null,
        flags: Flag<ImGuiTabItemFlags>? = null
    ): Boolean = usingPropertyN(pOpen) { ptrPOpen ->
        igBeginTabItem(label, ptrPOpen, flags?.value ?: 0)
    }

    fun beginTooltip() {
        igBeginTooltip()
    }

    fun bullet() {
        igBullet()
    }

    fun bulletText(fmt: String) {
        igBulletText(fmt)
    }

    fun button(label: String, size: Vec2 = Vec2.Zero): Boolean = igButton(label, size.toCValue())

    fun calcItemWidth(): Float = igCalcItemWidth()

    fun calcListClipping(
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

    fun calcTextSize(
        text: String,
        textEnd: String? = null,
        hideTextAfterDoubleHash: Boolean = false,
        wrapWidth: Float = -1.0f
    ): Vec2 = igCalcTextSize(text, textEnd, hideTextAfterDoubleHash, wrapWidth).fromCValue()

    fun captureKeyboardFromApp(wantCaptureKeyboardValue: Boolean = true) {
        igCaptureKeyboardFromApp(wantCaptureKeyboardValue)
    }

    fun captureMouseFromApp(wantCaptureMouseValue: Boolean = true) {
        igCaptureMouseFromApp(wantCaptureMouseValue)
    }

    fun checkbox(label: String, v: KMutableProperty0<Boolean>): Boolean = usingProperty(v) { ptrV ->
        igCheckbox(label, ptrV)
    }

    fun checkboxFlags(
        label: String,
        flags: KMutableProperty0<UInt>,
        flagsValue: UInt
    ): Boolean = usingProperty(flags) { ptrFlags ->
        igCheckboxFlags(label, ptrFlags, flagsValue)
    }

    fun closeCurrentPopup() {
        igCloseCurrentPopup()
    }

    fun collapsingHeader(label: String, flags: Flag<ImGuiTreeNodeFlags>? = null): Boolean =
            igCollapsingHeader(label, flags?.value ?: 0)

    fun collapsingHeader(
        label: String,
        pOpen: KMutableProperty0<Boolean>,
        flags: Flag<ImGuiTreeNodeFlags>? = null
    ): Boolean = usingProperty(pOpen) { ptrPOpen ->
        igCollapsingHeaderBoolPtr(label, ptrPOpen, flags?.value ?: 0)
    }

    fun colorButton(
        descId: String,
        col: Vec4,
        flags: Flag<ImGuiColorEditFlags>? = null,
        size: Vec2 = Vec2.Zero
    ): Boolean = igColorButton(descId, col.toCValue(), flags?.value ?: 0, size.toCValue())

    fun colorConvertFloat4ToU32(`in`: Vec4): UInt = igColorConvertFloat4ToU32(`in`.toCValue())

    fun colorConvertHSVtoRGB(
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

    fun colorConvertRGBtoHSV(
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

    fun colorConvertU32ToFloat4(`in`: UInt): Vec4 = igColorConvertU32ToFloat4(`in`).fromCValue()

    fun colorEdit3(
        label: String,
        col: FloatArray,
        flags: Flag<ImGuiColorEditFlags>? = null
    ): Boolean {
        require(col.size >= 3)
        return col.usePinned { pinnedCol ->
            igColorEdit3(label, pinnedCol.addressOf(0), flags?.value ?: 0)
        }
    }

    fun colorEdit4(
        label: String,
        col: FloatArray,
        flags: Flag<ImGuiColorEditFlags>? = null
    ): Boolean {
        require(col.size >= 4)
        return col.usePinned { pinnedCol ->
            igColorEdit4(label, pinnedCol.addressOf(0), flags?.value ?: 0)
        }
    }

    fun colorPicker3(
        label: String,
        col: FloatArray,
        flags: Flag<ImGuiColorEditFlags>? = null
    ): Boolean {
        require(col.size >= 3)
        return col.usePinned { pinnedCol ->
            igColorPicker3(label, pinnedCol.addressOf(0), flags?.value ?: 0)
        }
    }

    fun colorPicker4(
        label: String,
        col: FloatArray,
        flags: Flag<ImGuiColorEditFlags>? = null
    ): Boolean {
        require(col.size >= 4)
        return col.usePinned { pinnedCol ->
            igColorPicker4(label, pinnedCol.addressOf(0), flags?.value ?: 0, null)
        }
    }

    fun columns(
        count: Int = 1,
        id: String? = null,
        border: Boolean = true
    ) {
        igColumns(count, id, border)
    }

    fun combo(
        label: String,
        currentItem: KMutableProperty0<Int>,
        itemsSeparatedByZeros: String,
        popupMaxHeightInItems: Int = -1
    ): Boolean = usingProperty(currentItem) { ptrCurrentItem ->
        igComboStr(label, ptrCurrentItem, itemsSeparatedByZeros, popupMaxHeightInItems)
    }

    fun createContext(sharedFontAtlas: ImFontAtlas? = null): ImGuiContext =
            igCreateContext(sharedFontAtlas?.ptr)!!.let(::ImGuiContext)

    fun debugCheckVersionAndDataLayout(
        versionStr: String,
        szIo: ULong,
        szStyle: ULong,
        szVec2: ULong,
        szVec4: ULong,
        szDrawvert: ULong,
        szDrawidx: ULong
    ): Boolean = igDebugCheckVersionAndDataLayout(versionStr, szIo, szStyle, szVec2, szVec4,
            szDrawvert, szDrawidx)

    fun destroyContext(ctx: ImGuiContext? = null) {
        igDestroyContext(ctx?.ptr)
    }

    fun dragFloat(
        label: String,
        v: KMutableProperty0<Float>,
        vSpeed: Float = 1.0f,
        vMin: Float = 0.0f,
        vMax: Float = 0.0f,
        format: String = "%.3f",
        power: Float = 1.0f
    ): Boolean = usingProperty(v) { ptrV ->
        igDragFloat(label, ptrV, vSpeed, vMin, vMax, format, power)
    }

    fun dragFloat2(
        label: String,
        v: FloatArray,
        vSpeed: Float = 1.0f,
        vMin: Float = 0.0f,
        vMax: Float = 0.0f,
        format: String = "%.3f",
        power: Float = 1.0f
    ): Boolean {
        require(v.size >= 2)
        return v.usePinned { pinnedV ->
            igDragFloat2(label, pinnedV.addressOf(0), vSpeed, vMin, vMax, format, power)
        }
    }

    fun dragFloat3(
        label: String,
        v: FloatArray,
        vSpeed: Float = 1.0f,
        vMin: Float = 0.0f,
        vMax: Float = 0.0f,
        format: String = "%.3f",
        power: Float = 1.0f
    ): Boolean {
        require(v.size >= 3)
        return v.usePinned { pinnedV ->
            igDragFloat3(label, pinnedV.addressOf(0), vSpeed, vMin, vMax, format, power)
        }
    }

    fun dragFloat4(
        label: String,
        v: FloatArray,
        vSpeed: Float = 1.0f,
        vMin: Float = 0.0f,
        vMax: Float = 0.0f,
        format: String = "%.3f",
        power: Float = 1.0f
    ): Boolean {
        require(v.size >= 4)
        return v.usePinned { pinnedV ->
            igDragFloat4(label, pinnedV.addressOf(0), vSpeed, vMin, vMax, format, power)
        }
    }

    fun dragFloatRange2(
        label: String,
        vCurrentMin: KMutableProperty0<Float>,
        vCurrentMax: KMutableProperty0<Float>,
        vSpeed: Float = 1.0f,
        vMin: Float = 0.0f,
        vMax: Float = 0.0f,
        format: String = "%.3f",
        formatMax: String? = null,
        power: Float = 1.0f
    ): Boolean = usingProperty(vCurrentMin) { ptrVCurrentMin ->
        usingProperty(vCurrentMax) { ptrVCurrentMax ->
            igDragFloatRange2(label, ptrVCurrentMin, ptrVCurrentMax, vSpeed, vMin, vMax, format,
                    formatMax, power)
        }
    }

    fun dragInt(
        label: String,
        v: KMutableProperty0<Int>,
        vSpeed: Float = 1.0f,
        vMin: Int = 0,
        vMax: Int = 0,
        format: String = "%d"
    ): Boolean = usingProperty(v) { ptrV ->
        igDragInt(label, ptrV, vSpeed, vMin, vMax, format)
    }

    fun dragInt2(
        label: String,
        v: IntArray,
        vSpeed: Float = 1.0f,
        vMin: Int = 0,
        vMax: Int = 0,
        format: String = "%d"
    ): Boolean {
        require(v.size >= 2)
        return v.usePinned { pinnedV ->
            igDragInt2(label, pinnedV.addressOf(0), vSpeed, vMin, vMax, format)
        }
    }

    fun dragInt3(
        label: String,
        v: IntArray,
        vSpeed: Float = 1.0f,
        vMin: Int = 0,
        vMax: Int = 0,
        format: String = "%d"
    ): Boolean {
        require(v.size >= 3)
        return v.usePinned { pinnedV ->
            igDragInt3(label, pinnedV.addressOf(0), vSpeed, vMin, vMax, format)
        }
    }

    fun dragInt4(
        label: String,
        v: IntArray,
        vSpeed: Float = 1.0f,
        vMin: Int = 0,
        vMax: Int = 0,
        format: String = "%d"
    ): Boolean {
        require(v.size >= 4)
        return v.usePinned { pinnedV ->
            igDragInt4(label, pinnedV.addressOf(0), vSpeed, vMin, vMax, format)
        }
    }

    fun dragIntRange2(
        label: String,
        vCurrentMin: KMutableProperty0<Int>,
        vCurrentMax: KMutableProperty0<Int>,
        vSpeed: Float = 1.0f,
        vMin: Int = 0,
        vMax: Int = 0,
        format: String = "%d",
        formatMax: String? = null
    ): Boolean = usingProperty(vCurrentMin) { ptrVCurrentMin ->
        usingProperty(vCurrentMax) { ptrVCurrentMax ->
            igDragIntRange2(label, ptrVCurrentMin, ptrVCurrentMax, vSpeed, vMin, vMax, format,
                    formatMax)
        }
    }

    fun dummy(size: Vec2) {
        igDummy(size.toCValue())
    }

    fun end() {
        igEnd()
    }

    fun endChild() {
        igEndChild()
    }

    fun endChildFrame() {
        igEndChildFrame()
    }

    fun endCombo() {
        igEndCombo()
    }

    fun endDragDropSource() {
        igEndDragDropSource()
    }

    fun endDragDropTarget() {
        igEndDragDropTarget()
    }

    fun endFrame() {
        igEndFrame()
    }

    fun endGroup() {
        igEndGroup()
    }

    fun endMainMenuBar() {
        igEndMainMenuBar()
    }

    fun endMenu() {
        igEndMenu()
    }

    fun endMenuBar() {
        igEndMenuBar()
    }

    fun endPopup() {
        igEndPopup()
    }

    fun endTabBar() {
        igEndTabBar()
    }

    fun endTabItem() {
        igEndTabItem()
    }

    fun endTooltip() {
        igEndTooltip()
    }

    fun getBackgroundDrawList(): ImDrawList = igGetBackgroundDrawList()!!.let(::ImDrawList)

    fun getClipboardText(): String? = igGetClipboardText()?.toKString()

    fun getColorU32(idx: ImGuiCol, alphaMul: Float = 1.0f): UInt = igGetColorU32(idx.value,
            alphaMul)

    fun getColorU32(col: Vec4): UInt = igGetColorU32Vec4(col.toCValue())

    fun getColorU32(col: UInt): UInt = igGetColorU32U32(col)

    fun getColumnIndex(): Int = igGetColumnIndex()

    fun getColumnOffset(columnIndex: Int = -1): Float = igGetColumnOffset(columnIndex)

    fun getColumnWidth(columnIndex: Int = -1): Float = igGetColumnWidth(columnIndex)

    fun getColumnsCount(): Int = igGetColumnsCount()

    fun getContentRegionAvail(): Vec2 = igGetContentRegionAvail().fromCValue()

    fun getContentRegionMax(): Vec2 = igGetContentRegionMax().fromCValue()

    fun getCurrentContext(): ImGuiContext = igGetCurrentContext()!!.let(::ImGuiContext)

    fun getCursorPos(): Vec2 = igGetCursorPos().fromCValue()

    fun getCursorPosX(): Float = igGetCursorPosX()

    fun getCursorPosY(): Float = igGetCursorPosY()

    fun getCursorScreenPos(): Vec2 = igGetCursorScreenPos().fromCValue()

    fun getCursorStartPos(): Vec2 = igGetCursorStartPos().fromCValue()

    fun getDragDropPayload(): ImGuiPayload = igGetDragDropPayload()!!.let(::ImGuiPayload)

    fun getDrawData(): ImDrawData = igGetDrawData()!!.let(::ImDrawData)

    fun getDrawListSharedData(): ImDrawListSharedData =
            igGetDrawListSharedData()!!.let(::ImDrawListSharedData)

    fun getFont(): ImFont = igGetFont()!!.let(::ImFont)

    fun getFontSize(): Float = igGetFontSize()

    fun getFontTexUvWhitePixel(): Vec2 = igGetFontTexUvWhitePixel().fromCValue()

    fun getForegroundDrawList(): ImDrawList = igGetForegroundDrawList()!!.let(::ImDrawList)

    fun getFrameCount(): Int = igGetFrameCount()

    fun getFrameHeight(): Float = igGetFrameHeight()

    fun getFrameHeightWithSpacing(): Float = igGetFrameHeightWithSpacing()

    fun getID(strId: String): ImGuiID = igGetIDStr(strId).let(::ImGuiID)

    fun getID(strIdBegin: String, strIdEnd: String): ImGuiID = igGetIDRange(strIdBegin,
            strIdEnd).let(::ImGuiID)

    fun getIO(): ImGuiIO = igGetIO()!!.let(::ImGuiIO)

    fun getItemRectMax(): Vec2 = igGetItemRectMax().fromCValue()

    fun getItemRectMin(): Vec2 = igGetItemRectMin().fromCValue()

    fun getItemRectSize(): Vec2 = igGetItemRectSize().fromCValue()

    fun getKeyIndex(imguiKey: ImGuiKey): Int = igGetKeyIndex(imguiKey.value)

    fun getKeyPressedAmount(
        keyIndex: Int,
        repeatDelay: Float,
        rate: Float
    ): Int = igGetKeyPressedAmount(keyIndex, repeatDelay, rate)

    fun getMouseCursor(): ImGuiMouseCursor = igGetMouseCursor().let { ImGuiMouseCursor.from(it) }

    fun getMouseDragDelta(button: Int = 0, lockThreshold: Float = -1.0f): Vec2 =
            igGetMouseDragDelta(button, lockThreshold).fromCValue()

    fun getMousePos(): Vec2 = igGetMousePos().fromCValue()

    fun getMousePosOnOpeningCurrentPopup(): Vec2 = igGetMousePosOnOpeningCurrentPopup().fromCValue()

    fun getScrollMaxX(): Float = igGetScrollMaxX()

    fun getScrollMaxY(): Float = igGetScrollMaxY()

    fun getScrollX(): Float = igGetScrollX()

    fun getScrollY(): Float = igGetScrollY()

    fun getStateStorage(): ImGuiStorage = igGetStateStorage()!!.let(::ImGuiStorage)

    fun getStyle(): ImGuiStyle = igGetStyle()!!.let(::ImGuiStyle)

    fun getStyleColorName(idx: ImGuiCol): String? = igGetStyleColorName(idx.value)?.toKString()

    fun getStyleColorVec4(idx: ImGuiCol): ImVec4 = igGetStyleColorVec4(idx.value)!!.let(::ImVec4)

    fun getTextLineHeight(): Float = igGetTextLineHeight()

    fun getTextLineHeightWithSpacing(): Float = igGetTextLineHeightWithSpacing()

    fun getTime(): Double = igGetTime()

    fun getTreeNodeToLabelSpacing(): Float = igGetTreeNodeToLabelSpacing()

    fun getVersion(): String? = igGetVersion()?.toKString()

    fun getWindowContentRegionMax(): Vec2 = igGetWindowContentRegionMax().fromCValue()

    fun getWindowContentRegionMin(): Vec2 = igGetWindowContentRegionMin().fromCValue()

    fun getWindowContentRegionWidth(): Float = igGetWindowContentRegionWidth()

    fun getWindowDrawList(): ImDrawList = igGetWindowDrawList()!!.let(::ImDrawList)

    fun getWindowHeight(): Float = igGetWindowHeight()

    fun getWindowPos(): Vec2 = igGetWindowPos().fromCValue()

    fun getWindowSize(): Vec2 = igGetWindowSize().fromCValue()

    fun getWindowWidth(): Float = igGetWindowWidth()

    fun image(
        userTextureId: ImTextureID,
        size: Vec2,
        uv0: Vec2 = Vec2.Zero,
        uv1: Vec2 = Vec2(1f, 1f),
        tintCol: Vec4 = Vec4(1f, 1f, 1f, 1f),
        borderCol: Vec4 = Vec4.Zero
    ) {
        igImage(userTextureId.value, size.toCValue(), uv0.toCValue(), uv1.toCValue(),
                tintCol.toCValue(), borderCol.toCValue())
    }

    fun imageButton(
        userTextureId: ImTextureID,
        size: Vec2,
        uv0: Vec2 = Vec2.Zero,
        uv1: Vec2 = Vec2(1f, 1f),
        framePadding: Int = -1,
        bgCol: Vec4 = Vec4.Zero,
        tintCol: Vec4 = Vec4(1f, 1f, 1f, 1f)
    ): Boolean = igImageButton(userTextureId.value, size.toCValue(), uv0.toCValue(), uv1.toCValue(),
            framePadding, bgCol.toCValue(), tintCol.toCValue())

    fun indent(indentW: Float = 0.0f) {
        igIndent(indentW)
    }

    fun inputDouble(
        label: String,
        v: KMutableProperty0<Double>,
        step: Double = 0.0,
        stepFast: Double = 0.0,
        format: String = "%.6f",
        flags: Flag<ImGuiInputTextFlags>? = null
    ): Boolean = usingProperty(v) { ptrV ->
        igInputDouble(label, ptrV, step, stepFast, format, flags?.value ?: 0)
    }

    fun inputFloat(
        label: String,
        v: KMutableProperty0<Float>,
        step: Float = 0.0f,
        stepFast: Float = 0.0f,
        format: String = "%.3f",
        flags: Flag<ImGuiInputTextFlags>? = null
    ): Boolean = usingProperty(v) { ptrV ->
        igInputFloat(label, ptrV, step, stepFast, format, flags?.value ?: 0)
    }

    fun inputFloat2(
        label: String,
        v: FloatArray,
        format: String = "%.3f",
        flags: Flag<ImGuiInputTextFlags>? = null
    ): Boolean {
        require(v.size >= 2)
        return v.usePinned { pinnedV ->
            igInputFloat2(label, pinnedV.addressOf(0), format, flags?.value ?: 0)
        }
    }

    fun inputFloat3(
        label: String,
        v: FloatArray,
        format: String = "%.3f",
        flags: Flag<ImGuiInputTextFlags>? = null
    ): Boolean {
        require(v.size >= 3)
        return v.usePinned { pinnedV ->
            igInputFloat3(label, pinnedV.addressOf(0), format, flags?.value ?: 0)
        }
    }

    fun inputFloat4(
        label: String,
        v: FloatArray,
        format: String = "%.3f",
        flags: Flag<ImGuiInputTextFlags>? = null
    ): Boolean {
        require(v.size >= 4)
        return v.usePinned { pinnedV ->
            igInputFloat4(label, pinnedV.addressOf(0), format, flags?.value ?: 0)
        }
    }

    fun inputInt(
        label: String,
        v: KMutableProperty0<Int>,
        step: Int = 1,
        stepFast: Int = 100,
        flags: Flag<ImGuiInputTextFlags>? = null
    ): Boolean = usingProperty(v) { ptrV ->
        igInputInt(label, ptrV, step, stepFast, flags?.value ?: 0)
    }

    fun inputInt2(
        label: String,
        v: IntArray,
        flags: Flag<ImGuiInputTextFlags>? = null
    ): Boolean {
        require(v.size >= 2)
        return v.usePinned { pinnedV ->
            igInputInt2(label, pinnedV.addressOf(0), flags?.value ?: 0)
        }
    }

    fun inputInt3(
        label: String,
        v: IntArray,
        flags: Flag<ImGuiInputTextFlags>? = null
    ): Boolean {
        require(v.size >= 3)
        return v.usePinned { pinnedV ->
            igInputInt3(label, pinnedV.addressOf(0), flags?.value ?: 0)
        }
    }

    fun inputInt4(
        label: String,
        v: IntArray,
        flags: Flag<ImGuiInputTextFlags>? = null
    ): Boolean {
        require(v.size >= 4)
        return v.usePinned { pinnedV ->
            igInputInt4(label, pinnedV.addressOf(0), flags?.value ?: 0)
        }
    }

    fun invisibleButton(strId: String, size: Vec2): Boolean = igInvisibleButton(strId,
            size.toCValue())

    fun isAnyItemActive(): Boolean = igIsAnyItemActive()

    fun isAnyItemFocused(): Boolean = igIsAnyItemFocused()

    fun isAnyItemHovered(): Boolean = igIsAnyItemHovered()

    fun isAnyMouseDown(): Boolean = igIsAnyMouseDown()

    fun isItemActivated(): Boolean = igIsItemActivated()

    fun isItemActive(): Boolean = igIsItemActive()

    fun isItemClicked(mouseButton: Int = 0): Boolean = igIsItemClicked(mouseButton)

    fun isItemDeactivated(): Boolean = igIsItemDeactivated()

    fun isItemDeactivatedAfterEdit(): Boolean = igIsItemDeactivatedAfterEdit()

    fun isItemEdited(): Boolean = igIsItemEdited()

    fun isItemFocused(): Boolean = igIsItemFocused()

    fun isItemHovered(flags: Flag<ImGuiHoveredFlags>? = null): Boolean =
            igIsItemHovered(flags?.value ?: 0)

    fun isItemToggledOpen(): Boolean = igIsItemToggledOpen()

    fun isItemVisible(): Boolean = igIsItemVisible()

    fun isKeyDown(userKeyIndex: Int): Boolean = igIsKeyDown(userKeyIndex)

    fun isKeyPressed(userKeyIndex: Int, repeat: Boolean = true): Boolean =
            igIsKeyPressed(userKeyIndex, repeat)

    fun isKeyReleased(userKeyIndex: Int): Boolean = igIsKeyReleased(userKeyIndex)

    fun isMouseClicked(button: Int, repeat: Boolean = false): Boolean = igIsMouseClicked(button,
            repeat)

    fun isMouseDoubleClicked(button: Int): Boolean = igIsMouseDoubleClicked(button)

    fun isMouseDown(button: Int): Boolean = igIsMouseDown(button)

    fun isMouseDragging(button: Int = 0, lockThreshold: Float = -1.0f): Boolean =
            igIsMouseDragging(button, lockThreshold)

    fun isMouseHoveringRect(
        rMin: Vec2,
        rMax: Vec2,
        clip: Boolean = true
    ): Boolean = igIsMouseHoveringRect(rMin.toCValue(), rMax.toCValue(), clip)

    fun isMousePosValid(mousePos: ImVec2? = null): Boolean = igIsMousePosValid(mousePos?.ptr)

    fun isMouseReleased(button: Int): Boolean = igIsMouseReleased(button)

    fun isPopupOpen(strId: String): Boolean = igIsPopupOpen(strId)

    fun isRectVisible(size: Vec2): Boolean = igIsRectVisible(size.toCValue())

    fun isRectVisible(rectMin: Vec2, rectMax: Vec2): Boolean =
            igIsRectVisibleVec2(rectMin.toCValue(), rectMax.toCValue())

    fun isWindowAppearing(): Boolean = igIsWindowAppearing()

    fun isWindowCollapsed(): Boolean = igIsWindowCollapsed()

    fun isWindowFocused(flags: Flag<ImGuiFocusedFlags>? = null): Boolean =
            igIsWindowFocused(flags?.value ?: 0)

    fun isWindowHovered(flags: Flag<ImGuiHoveredFlags>? = null): Boolean =
            igIsWindowHovered(flags?.value ?: 0)

    fun labelText(label: String, fmt: String) {
        igLabelText(label, fmt)
    }

    fun listBoxFooter() {
        igListBoxFooter()
    }

    fun listBoxHeader(label: String, size: Vec2 = Vec2.Zero): Boolean = igListBoxHeaderVec2(label,
            size.toCValue())

    fun listBoxHeader(
        label: String,
        itemsCount: Int,
        heightInItems: Int = -1
    ): Boolean = igListBoxHeaderInt(label, itemsCount, heightInItems)

    fun loadIniSettingsFromDisk(iniFilename: String) {
        igLoadIniSettingsFromDisk(iniFilename)
    }

    fun loadIniSettingsFromMemory(iniData: String, iniSize: ULong = 0uL) {
        igLoadIniSettingsFromMemory(iniData, iniSize)
    }

    fun logButtons() {
        igLogButtons()
    }

    fun logFinish() {
        igLogFinish()
    }

    fun logText(fmt: String) {
        igLogText(fmt)
    }

    fun logToClipboard(autoOpenDepth: Int = -1) {
        igLogToClipboard(autoOpenDepth)
    }

    fun logToFile(autoOpenDepth: Int = -1, filename: String? = null) {
        igLogToFile(autoOpenDepth, filename)
    }

    fun logToTTY(autoOpenDepth: Int = -1) {
        igLogToTTY(autoOpenDepth)
    }

    fun menuItem(
        label: String,
        shortcut: String? = null,
        selected: Boolean = false,
        enabled: Boolean = true
    ): Boolean = igMenuItemBool(label, shortcut, selected, enabled)

    fun menuItem(
        label: String,
        shortcut: String,
        pSelected: KMutableProperty0<Boolean>,
        enabled: Boolean = true
    ): Boolean = usingProperty(pSelected) { ptrPSelected ->
        igMenuItemBoolPtr(label, shortcut, ptrPSelected, enabled)
    }

    fun newFrame() {
        igNewFrame()
    }

    fun newLine() {
        igNewLine()
    }

    fun nextColumn() {
        igNextColumn()
    }

    fun openPopup(strId: String) {
        igOpenPopup(strId)
    }

    fun openPopupOnItemClick(strId: String? = null, mouseButton: Int = 1): Boolean =
            igOpenPopupOnItemClick(strId, mouseButton)

    fun popAllowKeyboardFocus() {
        igPopAllowKeyboardFocus()
    }

    fun popButtonRepeat() {
        igPopButtonRepeat()
    }

    fun popClipRect() {
        igPopClipRect()
    }

    fun popFont() {
        igPopFont()
    }

    fun popID() {
        igPopID()
    }

    fun popItemWidth() {
        igPopItemWidth()
    }

    fun popStyleColor(count: Int = 1) {
        igPopStyleColor(count)
    }

    fun popStyleVar(count: Int = 1) {
        igPopStyleVar(count)
    }

    fun popTextWrapPos() {
        igPopTextWrapPos()
    }

    fun progressBar(
        fraction: Float,
        sizeArg: Vec2 = Vec2(-1f, 0f),
        overlay: String? = null
    ) {
        igProgressBar(fraction, sizeArg.toCValue(), overlay)
    }

    fun pushAllowKeyboardFocus(allowKeyboardFocus: Boolean) {
        igPushAllowKeyboardFocus(allowKeyboardFocus)
    }

    fun pushButtonRepeat(repeat: Boolean) {
        igPushButtonRepeat(repeat)
    }

    fun pushClipRect(
        clipRectMin: Vec2,
        clipRectMax: Vec2,
        intersectWithCurrentClipRect: Boolean
    ) {
        igPushClipRect(clipRectMin.toCValue(), clipRectMax.toCValue(), intersectWithCurrentClipRect)
    }

    fun pushFont(font: ImFont) {
        igPushFont(font.ptr)
    }

    fun pushID(strId: String) {
        igPushIDStr(strId)
    }

    fun pushID(strIdBegin: String, strIdEnd: String) {
        igPushIDRange(strIdBegin, strIdEnd)
    }

    fun pushID(intId: Int) {
        igPushIDInt(intId)
    }

    fun pushItemWidth(itemWidth: Float) {
        igPushItemWidth(itemWidth)
    }

    fun pushStyleColor(idx: ImGuiCol, col: UInt) {
        igPushStyleColorU32(idx.value, col)
    }

    fun pushStyleColor(idx: ImGuiCol, col: Vec4) {
        igPushStyleColor(idx.value, col.toCValue())
    }

    fun pushStyleVar(idx: ImGuiStyleVar, `val`: Float) {
        igPushStyleVarFloat(idx.value, `val`)
    }

    fun pushStyleVar(idx: ImGuiStyleVar, `val`: Vec2) {
        igPushStyleVarVec2(idx.value, `val`.toCValue())
    }

    fun pushTextWrapPos(wrapLocalPosX: Float = 0.0f) {
        igPushTextWrapPos(wrapLocalPosX)
    }

    fun radioButton(label: String, active: Boolean): Boolean = igRadioButtonBool(label, active)

    fun radioButton(
        label: String,
        v: KMutableProperty0<Int>,
        vButton: Int
    ): Boolean = usingProperty(v) { ptrV ->
        igRadioButtonIntPtr(label, ptrV, vButton)
    }

    fun render() {
        igRender()
    }

    fun resetMouseDragDelta(button: Int = 0) {
        igResetMouseDragDelta(button)
    }

    fun sameLine(offsetFromStartX: Float = 0.0f, spacing: Float = -1.0f) {
        igSameLine(offsetFromStartX, spacing)
    }

    fun saveIniSettingsToDisk(iniFilename: String) {
        igSaveIniSettingsToDisk(iniFilename)
    }

    fun saveIniSettingsToMemory(outIniSize: KMutableProperty0<ULong>? = null): String? =
            usingPropertyN(outIniSize) { ptrOutIniSize ->
        igSaveIniSettingsToMemory(ptrOutIniSize)
    }?.toKString()

    fun selectable(
        label: String,
        selected: Boolean = false,
        flags: Flag<ImGuiSelectableFlags>? = null,
        size: Vec2 = Vec2.Zero
    ): Boolean = igSelectable(label, selected, flags?.value ?: 0, size.toCValue())

    fun selectable(
        label: String,
        pSelected: KMutableProperty0<Boolean>,
        flags: Flag<ImGuiSelectableFlags>? = null,
        size: Vec2 = Vec2.Zero
    ): Boolean = usingProperty(pSelected) { ptrPSelected ->
        igSelectableBoolPtr(label, ptrPSelected, flags?.value ?: 0, size.toCValue())
    }

    fun separator() {
        igSeparator()
    }

    fun setClipboardText(text: String) {
        igSetClipboardText(text)
    }

    fun setColorEditOptions(flags: Flag<ImGuiColorEditFlags>) {
        igSetColorEditOptions(flags.value)
    }

    fun setColumnOffset(columnIndex: Int, offsetX: Float) {
        igSetColumnOffset(columnIndex, offsetX)
    }

    fun setColumnWidth(columnIndex: Int, width: Float) {
        igSetColumnWidth(columnIndex, width)
    }

    fun setCurrentContext(ctx: ImGuiContext) {
        igSetCurrentContext(ctx.ptr)
    }

    fun setCursorPos(localPos: Vec2) {
        igSetCursorPos(localPos.toCValue())
    }

    fun setCursorPosX(localX: Float) {
        igSetCursorPosX(localX)
    }

    fun setCursorPosY(localY: Float) {
        igSetCursorPosY(localY)
    }

    fun setCursorScreenPos(pos: Vec2) {
        igSetCursorScreenPos(pos.toCValue())
    }

    fun setItemAllowOverlap() {
        igSetItemAllowOverlap()
    }

    fun setItemDefaultFocus() {
        igSetItemDefaultFocus()
    }

    fun setKeyboardFocusHere(offset: Int = 0) {
        igSetKeyboardFocusHere(offset)
    }

    fun setMouseCursor(type: ImGuiMouseCursor) {
        igSetMouseCursor(type.value)
    }

    fun setNextItemOpen(isOpen: Boolean, cond: Flag<ImGuiCond>? = null) {
        igSetNextItemOpen(isOpen, cond?.value ?: 0)
    }

    fun setNextItemWidth(itemWidth: Float) {
        igSetNextItemWidth(itemWidth)
    }

    fun setNextWindowBgAlpha(alpha: Float) {
        igSetNextWindowBgAlpha(alpha)
    }

    fun setNextWindowCollapsed(collapsed: Boolean, cond: Flag<ImGuiCond>? = null) {
        igSetNextWindowCollapsed(collapsed, cond?.value ?: 0)
    }

    fun setNextWindowContentSize(size: Vec2) {
        igSetNextWindowContentSize(size.toCValue())
    }

    fun setNextWindowFocus() {
        igSetNextWindowFocus()
    }

    fun setNextWindowPos(
        pos: Vec2,
        cond: Flag<ImGuiCond>? = null,
        pivot: Vec2 = Vec2.Zero
    ) {
        igSetNextWindowPos(pos.toCValue(), cond?.value ?: 0, pivot.toCValue())
    }

    fun setNextWindowSize(size: Vec2, cond: Flag<ImGuiCond>? = null) {
        igSetNextWindowSize(size.toCValue(), cond?.value ?: 0)
    }

    fun setScrollFromPosX(localX: Float, centerXRatio: Float = 0.5f) {
        igSetScrollFromPosX(localX, centerXRatio)
    }

    fun setScrollFromPosY(localY: Float, centerYRatio: Float = 0.5f) {
        igSetScrollFromPosY(localY, centerYRatio)
    }

    fun setScrollHereX(centerXRatio: Float = 0.5f) {
        igSetScrollHereX(centerXRatio)
    }

    fun setScrollHereY(centerYRatio: Float = 0.5f) {
        igSetScrollHereY(centerYRatio)
    }

    fun setScrollX(scrollX: Float) {
        igSetScrollX(scrollX)
    }

    fun setScrollY(scrollY: Float) {
        igSetScrollY(scrollY)
    }

    fun setStateStorage(storage: ImGuiStorage) {
        igSetStateStorage(storage.ptr)
    }

    fun setTabItemClosed(tabOrDockedWindowLabel: String) {
        igSetTabItemClosed(tabOrDockedWindowLabel)
    }

    fun setTooltip(fmt: String) {
        igSetTooltip(fmt)
    }

    fun setWindowCollapsed(collapsed: Boolean, cond: Flag<ImGuiCond>? = null) {
        igSetWindowCollapsedBool(collapsed, cond?.value ?: 0)
    }

    fun setWindowCollapsed(
        name: String,
        collapsed: Boolean,
        cond: Flag<ImGuiCond>? = null
    ) {
        igSetWindowCollapsedStr(name, collapsed, cond?.value ?: 0)
    }

    fun setWindowFocus() {
        igSetWindowFocus()
    }

    fun setWindowFocus(name: String) {
        igSetWindowFocusStr(name)
    }

    fun setWindowFontScale(scale: Float) {
        igSetWindowFontScale(scale)
    }

    fun setWindowPos(pos: Vec2, cond: Flag<ImGuiCond>? = null) {
        igSetWindowPosVec2(pos.toCValue(), cond?.value ?: 0)
    }

    fun setWindowPos(
        name: String,
        pos: Vec2,
        cond: Flag<ImGuiCond>? = null
    ) {
        igSetWindowPosStr(name, pos.toCValue(), cond?.value ?: 0)
    }

    fun setWindowSize(size: Vec2, cond: Flag<ImGuiCond>? = null) {
        igSetWindowSizeVec2(size.toCValue(), cond?.value ?: 0)
    }

    fun setWindowSize(
        name: String,
        size: Vec2,
        cond: Flag<ImGuiCond>? = null
    ) {
        igSetWindowSizeStr(name, size.toCValue(), cond?.value ?: 0)
    }

    fun showAboutWindow(pOpen: KMutableProperty0<Boolean>? = null) {
        usingPropertyN(pOpen) { ptrPOpen ->
            igShowAboutWindow(ptrPOpen)
        }
    }

    fun showDemoWindow(pOpen: KMutableProperty0<Boolean>? = null) {
        usingPropertyN(pOpen) { ptrPOpen ->
            igShowDemoWindow(ptrPOpen)
        }
    }

    fun showFontSelector(label: String) {
        igShowFontSelector(label)
    }

    fun showMetricsWindow(pOpen: KMutableProperty0<Boolean>? = null) {
        usingPropertyN(pOpen) { ptrPOpen ->
            igShowMetricsWindow(ptrPOpen)
        }
    }

    fun showStyleEditor(ref: ImGuiStyle? = null) {
        igShowStyleEditor(ref?.ptr)
    }

    fun showStyleSelector(label: String): Boolean = igShowStyleSelector(label)

    fun showUserGuide() {
        igShowUserGuide()
    }

    fun sliderAngle(
        label: String,
        vRad: KMutableProperty0<Float>,
        vDegreesMin: Float = -360.0f,
        vDegreesMax: Float = +360.0f,
        format: String = "%.0f deg"
    ): Boolean = usingProperty(vRad) { ptrVRad ->
        igSliderAngle(label, ptrVRad, vDegreesMin, vDegreesMax, format)
    }

    fun sliderFloat(
        label: String,
        v: KMutableProperty0<Float>,
        vMin: Float,
        vMax: Float,
        format: String = "%.3f",
        power: Float = 1.0f
    ): Boolean = usingProperty(v) { ptrV ->
        igSliderFloat(label, ptrV, vMin, vMax, format, power)
    }

    fun sliderFloat2(
        label: String,
        v: FloatArray,
        vMin: Float,
        vMax: Float,
        format: String = "%.3f",
        power: Float = 1.0f
    ): Boolean {
        require(v.size >= 2)
        return v.usePinned { pinnedV ->
            igSliderFloat2(label, pinnedV.addressOf(0), vMin, vMax, format, power)
        }
    }

    fun sliderFloat3(
        label: String,
        v: FloatArray,
        vMin: Float,
        vMax: Float,
        format: String = "%.3f",
        power: Float = 1.0f
    ): Boolean {
        require(v.size >= 3)
        return v.usePinned { pinnedV ->
            igSliderFloat3(label, pinnedV.addressOf(0), vMin, vMax, format, power)
        }
    }

    fun sliderFloat4(
        label: String,
        v: FloatArray,
        vMin: Float,
        vMax: Float,
        format: String = "%.3f",
        power: Float = 1.0f
    ): Boolean {
        require(v.size >= 4)
        return v.usePinned { pinnedV ->
            igSliderFloat4(label, pinnedV.addressOf(0), vMin, vMax, format, power)
        }
    }

    fun sliderInt(
        label: String,
        v: KMutableProperty0<Int>,
        vMin: Int,
        vMax: Int,
        format: String = "%d"
    ): Boolean = usingProperty(v) { ptrV ->
        igSliderInt(label, ptrV, vMin, vMax, format)
    }

    fun sliderInt2(
        label: String,
        v: IntArray,
        vMin: Int,
        vMax: Int,
        format: String = "%d"
    ): Boolean {
        require(v.size >= 2)
        return v.usePinned { pinnedV ->
            igSliderInt2(label, pinnedV.addressOf(0), vMin, vMax, format)
        }
    }

    fun sliderInt3(
        label: String,
        v: IntArray,
        vMin: Int,
        vMax: Int,
        format: String = "%d"
    ): Boolean {
        require(v.size >= 3)
        return v.usePinned { pinnedV ->
            igSliderInt3(label, pinnedV.addressOf(0), vMin, vMax, format)
        }
    }

    fun sliderInt4(
        label: String,
        v: IntArray,
        vMin: Int,
        vMax: Int,
        format: String = "%d"
    ): Boolean {
        require(v.size >= 4)
        return v.usePinned { pinnedV ->
            igSliderInt4(label, pinnedV.addressOf(0), vMin, vMax, format)
        }
    }

    fun smallButton(label: String): Boolean = igSmallButton(label)

    fun spacing() {
        igSpacing()
    }

    fun styleColorsClassic(dst: ImGuiStyle? = null) {
        igStyleColorsClassic(dst?.ptr)
    }

    fun styleColorsDark(dst: ImGuiStyle? = null) {
        igStyleColorsDark(dst?.ptr)
    }

    fun styleColorsLight(dst: ImGuiStyle? = null) {
        igStyleColorsLight(dst?.ptr)
    }

    fun text(fmt: String) {
        igText(fmt)
    }

    fun textColored(col: Vec4, fmt: String) {
        igTextColored(col.toCValue(), fmt)
    }

    fun textDisabled(fmt: String) {
        igTextDisabled(fmt)
    }

    fun textUnformatted(text: String, textEnd: String? = null) {
        igTextUnformatted(text, textEnd)
    }

    fun textWrapped(fmt: String) {
        igTextWrapped(fmt)
    }

    fun treeNode(label: String): Boolean = igTreeNodeStr(label)

    fun treeNode(strId: String, fmt: String): Boolean = igTreeNodeStrStr(strId, fmt)

    fun treeNodeEx(label: String, flags: Flag<ImGuiTreeNodeFlags>? = null): Boolean =
            igTreeNodeExStr(label, flags?.value ?: 0)

    fun treeNodeEx(
        strId: String,
        flags: Flag<ImGuiTreeNodeFlags>,
        fmt: String
    ): Boolean = igTreeNodeExStrStr(strId, flags.value, fmt)

    fun treePop() {
        igTreePop()
    }

    fun treePush(strId: String) {
        igTreePushStr(strId)
    }

    fun treePush() {
        igTreePushPtr(null)
    }

    fun unindent(indentW: Float = 0.0f) {
        igUnindent(indentW)
    }

    fun vSliderFloat(
        label: String,
        size: Vec2,
        v: KMutableProperty0<Float>,
        vMin: Float,
        vMax: Float,
        format: String = "%.3f",
        power: Float = 1.0f
    ): Boolean = usingProperty(v) { ptrV ->
        igVSliderFloat(label, size.toCValue(), ptrV, vMin, vMax, format, power)
    }

    fun vSliderInt(
        label: String,
        size: Vec2,
        v: KMutableProperty0<Int>,
        vMin: Int,
        vMax: Int,
        format: String = "%d"
    ): Boolean = usingProperty(v) { ptrV ->
        igVSliderInt(label, size.toCValue(), ptrV, vMin, vMax, format)
    }

    fun value(prefix: String, b: Boolean) {
        igValueBool(prefix, b)
    }

    fun value(prefix: String, v: Int) {
        igValueInt(prefix, v)
    }

    fun value(prefix: String, v: UInt) {
        igValueUint(prefix, v)
    }

    fun value(
        prefix: String,
        v: Float,
        floatFormat: String? = null
    ) {
        igValueFloat(prefix, v, floatFormat)
    }
}
