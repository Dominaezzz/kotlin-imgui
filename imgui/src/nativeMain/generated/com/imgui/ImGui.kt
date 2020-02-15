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
import kotlinx.cinterop.convert
import kotlinx.cinterop.toKString
import kotlinx.cinterop.usePinned

actual object ImGui {
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
    ): Boolean = igBeginChild(strId, size.toCValue(), border, flags?.value ?: 0)

    actual fun beginChild(
        id: ImGuiID,
        size: Vec2,
        border: Boolean,
        flags: Flag<ImGuiWindowFlags>?
    ): Boolean = igBeginChildID(id.value, size.toCValue(), border, flags?.value ?: 0)

    actual fun beginChildFrame(
        id: ImGuiID,
        size: Vec2,
        flags: Flag<ImGuiWindowFlags>?
    ): Boolean = igBeginChildFrame(id.value, size.toCValue(), flags?.value ?: 0)

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

    actual fun beginPopupContextItem(strId: String?, mouseButton: ImGuiMouseButton): Boolean =
            igBeginPopupContextItem(strId, mouseButton.value)

    actual fun beginPopupContextVoid(strId: String?, mouseButton: ImGuiMouseButton): Boolean =
            igBeginPopupContextVoid(strId, mouseButton.value)

    actual fun beginPopupContextWindow(
        strId: String?,
        mouseButton: ImGuiMouseButton,
        alsoOverItems: Boolean
    ): Boolean = igBeginPopupContextWindow(strId, mouseButton.value, alsoOverItems)

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

    actual fun button(label: String, size: Vec2): Boolean = igButton(label, size.toCValue())

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
    ): Vec2 = igCalcTextSize(text, textEnd, hideTextAfterDoubleHash, wrapWidth).fromCValue()

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

    actual fun colorConvertU32ToFloat4(`in`: UInt): Vec4 =
            igColorConvertU32ToFloat4(`in`).fromCValue()

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

    actual fun getClipboardText(): String? = igGetClipboardText()?.toKString()

    actual fun getColorU32(idx: ImGuiCol, alphaMul: Float): UInt = igGetColorU32(idx.value,
            alphaMul).toUInt()

    actual fun getColorU32(col: Vec4): UInt = igGetColorU32Vec4(col.toCValue()).toUInt()

    actual fun getColorU32(col: UInt): UInt = igGetColorU32U32(col).toUInt()

    actual fun getColumnIndex(): Int = igGetColumnIndex()

    actual fun getColumnOffset(columnIndex: Int): Float = igGetColumnOffset(columnIndex)

    actual fun getColumnWidth(columnIndex: Int): Float = igGetColumnWidth(columnIndex)

    actual fun getColumnsCount(): Int = igGetColumnsCount()

    actual fun getContentRegionAvail(): Vec2 = igGetContentRegionAvail().fromCValue()

    actual fun getContentRegionMax(): Vec2 = igGetContentRegionMax().fromCValue()

    actual fun getCurrentContext(): ImGuiContext = igGetCurrentContext()!!.let(::ImGuiContext)

    actual fun getCursorPos(): Vec2 = igGetCursorPos().fromCValue()

    actual fun getCursorPosX(): Float = igGetCursorPosX()

    actual fun getCursorPosY(): Float = igGetCursorPosY()

    actual fun getCursorScreenPos(): Vec2 = igGetCursorScreenPos().fromCValue()

    actual fun getCursorStartPos(): Vec2 = igGetCursorStartPos().fromCValue()

    actual fun getDragDropPayload(): ImGuiPayload = igGetDragDropPayload()!!.let(::ImGuiPayload)

    actual fun getDrawData(): ImDrawData = igGetDrawData()!!.let(::ImDrawData)

    actual fun getDrawListSharedData(): ImDrawListSharedData =
            igGetDrawListSharedData()!!.let(::ImDrawListSharedData)

    actual fun getFont(): ImFont = igGetFont()!!.let(::ImFont)

    actual fun getFontSize(): Float = igGetFontSize()

    actual fun getFontTexUvWhitePixel(): Vec2 = igGetFontTexUvWhitePixel().fromCValue()

    actual fun getForegroundDrawList(): ImDrawList = igGetForegroundDrawList()!!.let(::ImDrawList)

    actual fun getFrameCount(): Int = igGetFrameCount()

    actual fun getFrameHeight(): Float = igGetFrameHeight()

    actual fun getFrameHeightWithSpacing(): Float = igGetFrameHeightWithSpacing()

    actual fun getID(strId: String): ImGuiID = igGetIDStr(strId).let(::ImGuiID)

    actual fun getID(strIdBegin: String, strIdEnd: String): ImGuiID = igGetIDRange(strIdBegin,
            strIdEnd).let(::ImGuiID)

    actual fun getIO(): ImGuiIO = igGetIO()!!.let(::ImGuiIO)

    actual fun getItemRectMax(): Vec2 = igGetItemRectMax().fromCValue()

    actual fun getItemRectMin(): Vec2 = igGetItemRectMin().fromCValue()

    actual fun getItemRectSize(): Vec2 = igGetItemRectSize().fromCValue()

    actual fun getKeyIndex(imguiKey: ImGuiKey): Int = igGetKeyIndex(imguiKey.value)

    actual fun getKeyPressedAmount(
        keyIndex: Int,
        repeatDelay: Float,
        rate: Float
    ): Int = igGetKeyPressedAmount(keyIndex, repeatDelay, rate)

    actual fun getMouseCursor(): ImGuiMouseCursor = igGetMouseCursor().let {
            ImGuiMouseCursor.from(it) }

    actual fun getMouseDragDelta(button: ImGuiMouseButton, lockThreshold: Float): Vec2 =
            igGetMouseDragDelta(button.value, lockThreshold).fromCValue()

    actual fun getMousePos(): Vec2 = igGetMousePos().fromCValue()

    actual fun getMousePosOnOpeningCurrentPopup(): Vec2 =
            igGetMousePosOnOpeningCurrentPopup().fromCValue()

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

    actual fun getTreeNodeToLabelSpacing(): Float = igGetTreeNodeToLabelSpacing()

    actual fun getVersion(): String? = igGetVersion()?.toKString()

    actual fun getWindowContentRegionMax(): Vec2 = igGetWindowContentRegionMax().fromCValue()

    actual fun getWindowContentRegionMin(): Vec2 = igGetWindowContentRegionMin().fromCValue()

    actual fun getWindowContentRegionWidth(): Float = igGetWindowContentRegionWidth()

    actual fun getWindowDrawList(): ImDrawList = igGetWindowDrawList()!!.let(::ImDrawList)

    actual fun getWindowHeight(): Float = igGetWindowHeight()

    actual fun getWindowPos(): Vec2 = igGetWindowPos().fromCValue()

    actual fun getWindowSize(): Vec2 = igGetWindowSize().fromCValue()

    actual fun getWindowWidth(): Float = igGetWindowWidth()

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

    actual fun isAnyItemActive(): Boolean = igIsAnyItemActive()

    actual fun isAnyItemFocused(): Boolean = igIsAnyItemFocused()

    actual fun isAnyItemHovered(): Boolean = igIsAnyItemHovered()

    actual fun isAnyMouseDown(): Boolean = igIsAnyMouseDown()

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

    actual fun isItemVisible(): Boolean = igIsItemVisible()

    actual fun isKeyDown(userKeyIndex: Int): Boolean = igIsKeyDown(userKeyIndex)

    actual fun isKeyPressed(userKeyIndex: Int, repeat: Boolean): Boolean =
            igIsKeyPressed(userKeyIndex, repeat)

    actual fun isKeyReleased(userKeyIndex: Int): Boolean = igIsKeyReleased(userKeyIndex)

    actual fun isMouseClicked(button: ImGuiMouseButton, repeat: Boolean): Boolean =
            igIsMouseClicked(button.value, repeat)

    actual fun isMouseDoubleClicked(button: ImGuiMouseButton): Boolean =
            igIsMouseDoubleClicked(button.value)

    actual fun isMouseDown(button: ImGuiMouseButton): Boolean = igIsMouseDown(button.value)

    actual fun isMouseDragging(button: ImGuiMouseButton, lockThreshold: Float): Boolean =
            igIsMouseDragging(button.value, lockThreshold)

    actual fun isMouseHoveringRect(
        rMin: Vec2,
        rMax: Vec2,
        clip: Boolean
    ): Boolean = igIsMouseHoveringRect(rMin.toCValue(), rMax.toCValue(), clip)

    actual fun isMousePosValid(mousePos: ImVec2?): Boolean = igIsMousePosValid(mousePos?.ptr)

    actual fun isMouseReleased(button: ImGuiMouseButton): Boolean = igIsMouseReleased(button.value)

    actual fun isPopupOpen(strId: String): Boolean = igIsPopupOpen(strId)

    actual fun isRectVisible(size: Vec2): Boolean = igIsRectVisible(size.toCValue())

    actual fun isRectVisible(rectMin: Vec2, rectMax: Vec2): Boolean =
            igIsRectVisibleVec2(rectMin.toCValue(), rectMax.toCValue())

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
        igPushStyleColorU32(idx.value, col)
    }

    actual fun pushStyleColor(idx: ImGuiCol, col: Vec4) {
        igPushStyleColor(idx.value, col.toCValue())
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

    actual fun selectable(
        label: String,
        selected: Boolean,
        flags: Flag<ImGuiSelectableFlags>?,
        size: Vec2
    ): Boolean = igSelectable(label, selected, flags?.value ?: 0, size.toCValue())

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
        igSetNextWindowContentSize(size.toCValue())
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

    actual fun setNextWindowSize(size: Vec2, cond: Flag<ImGuiCond>?) {
        igSetNextWindowSize(size.toCValue(), cond?.value ?: 0)
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
        igSetWindowPosVec2(pos.toCValue(), cond?.value ?: 0)
    }

    actual fun setWindowPos(
        name: String,
        pos: Vec2,
        cond: Flag<ImGuiCond>?
    ) {
        igSetWindowPosStr(name, pos.toCValue(), cond?.value ?: 0)
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
        igTextColored(col.toCValue(), fmt)
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
