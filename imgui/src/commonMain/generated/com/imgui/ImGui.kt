package com.imgui

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

expect object ImGui {
    fun acceptDragDropPayload(type: String, flags: Flag<ImGuiDragDropFlags>? = null): ImGuiPayload

    fun alignTextToFramePadding()

    fun arrowButton(strId: String, dir: ImGuiDir): Boolean

    fun begin(
        name: String,
        pOpen: KMutableProperty0<Boolean>? = null,
        flags: Flag<ImGuiWindowFlags>? = null
    ): Boolean

    fun beginChild(
        strId: String,
        size: Vec2 = Vec2.Zero,
        border: Boolean = false,
        flags: Flag<ImGuiWindowFlags>? = null
    ): Boolean

    fun beginChild(
        id: ImGuiID,
        size: Vec2 = Vec2.Zero,
        border: Boolean = false,
        flags: Flag<ImGuiWindowFlags>? = null
    ): Boolean

    fun beginChildFrame(
        id: ImGuiID,
        size: Vec2,
        flags: Flag<ImGuiWindowFlags>? = null
    ): Boolean

    fun beginCombo(
        label: String,
        previewValue: String,
        flags: Flag<ImGuiComboFlags>? = null
    ): Boolean

    fun beginDragDropSource(flags: Flag<ImGuiDragDropFlags>? = null): Boolean

    fun beginDragDropTarget(): Boolean

    fun beginGroup()

    fun beginMainMenuBar(): Boolean

    fun beginMenu(label: String, enabled: Boolean = true): Boolean

    fun beginMenuBar(): Boolean

    fun beginPopup(strId: String, flags: Flag<ImGuiWindowFlags>? = null): Boolean

    fun beginPopupContextItem(strId: String? = null, mouseButton: Int = 1): Boolean

    fun beginPopupContextVoid(strId: String? = null, mouseButton: Int = 1): Boolean

    fun beginPopupContextWindow(
        strId: String? = null,
        mouseButton: Int = 1,
        alsoOverItems: Boolean = true
    ): Boolean

    fun beginPopupModal(
        name: String,
        pOpen: KMutableProperty0<Boolean>? = null,
        flags: Flag<ImGuiWindowFlags>? = null
    ): Boolean

    fun beginTabBar(strId: String, flags: Flag<ImGuiTabBarFlags>? = null): Boolean

    fun beginTabItem(
        label: String,
        pOpen: KMutableProperty0<Boolean>? = null,
        flags: Flag<ImGuiTabItemFlags>? = null
    ): Boolean

    fun beginTooltip()

    fun bullet()

    fun bulletText(fmt: String)

    fun button(label: String, size: Vec2 = Vec2.Zero): Boolean

    fun calcItemWidth(): Float

    fun calcListClipping(
        itemsCount: Int,
        itemsHeight: Float,
        outItemsDisplayStart: KMutableProperty0<Int>,
        outItemsDisplayEnd: KMutableProperty0<Int>
    )

    fun calcTextSize(
        text: String,
        textEnd: String? = null,
        hideTextAfterDoubleHash: Boolean = false,
        wrapWidth: Float = -1.0f
    ): Vec2

    fun captureKeyboardFromApp(wantCaptureKeyboardValue: Boolean = true)

    fun captureMouseFromApp(wantCaptureMouseValue: Boolean = true)

    fun checkbox(label: String, v: KMutableProperty0<Boolean>): Boolean

    fun checkboxFlags(
        label: String,
        flags: KMutableProperty0<UInt>,
        flagsValue: UInt
    ): Boolean

    fun closeCurrentPopup()

    fun collapsingHeader(label: String, flags: Flag<ImGuiTreeNodeFlags>? = null): Boolean

    fun collapsingHeader(
        label: String,
        pOpen: KMutableProperty0<Boolean>,
        flags: Flag<ImGuiTreeNodeFlags>? = null
    ): Boolean

    fun colorButton(
        descId: String,
        col: Vec4,
        flags: Flag<ImGuiColorEditFlags>? = null,
        size: Vec2 = Vec2.Zero
    ): Boolean

    fun colorConvertFloat4ToU32(`in`: Vec4): UInt

    fun colorConvertHSVtoRGB(
        h: Float,
        s: Float,
        v: Float,
        outR: KMutableProperty0<Float>,
        outG: KMutableProperty0<Float>,
        outB: KMutableProperty0<Float>
    )

    fun colorConvertRGBtoHSV(
        r: Float,
        g: Float,
        b: Float,
        outH: KMutableProperty0<Float>,
        outS: KMutableProperty0<Float>,
        outV: KMutableProperty0<Float>
    )

    fun colorConvertU32ToFloat4(`in`: UInt): Vec4

    fun colorEdit3(
        label: String,
        col: FloatArray,
        flags: Flag<ImGuiColorEditFlags>? = null
    ): Boolean

    fun colorEdit4(
        label: String,
        col: FloatArray,
        flags: Flag<ImGuiColorEditFlags>? = null
    ): Boolean

    fun colorPicker3(
        label: String,
        col: FloatArray,
        flags: Flag<ImGuiColorEditFlags>? = null
    ): Boolean

    fun colorPicker4(
        label: String,
        col: FloatArray,
        flags: Flag<ImGuiColorEditFlags>? = null
    ): Boolean

    fun columns(
        count: Int = 1,
        id: String? = null,
        border: Boolean = true
    )

    fun combo(
        label: String,
        currentItem: KMutableProperty0<Int>,
        itemsSeparatedByZeros: String,
        popupMaxHeightInItems: Int = -1
    ): Boolean

    fun createContext(sharedFontAtlas: ImFontAtlas? = null): ImGuiContext

    fun debugCheckVersionAndDataLayout(
        versionStr: String,
        szIo: ULong,
        szStyle: ULong,
        szVec2: ULong,
        szVec4: ULong,
        szDrawvert: ULong,
        szDrawidx: ULong
    ): Boolean

    fun destroyContext(ctx: ImGuiContext? = null)

    fun dragFloat(
        label: String,
        v: KMutableProperty0<Float>,
        vSpeed: Float = 1.0f,
        vMin: Float = 0.0f,
        vMax: Float = 0.0f,
        format: String = "%.3f",
        power: Float = 1.0f
    ): Boolean

    fun dragFloat2(
        label: String,
        v: FloatArray,
        vSpeed: Float = 1.0f,
        vMin: Float = 0.0f,
        vMax: Float = 0.0f,
        format: String = "%.3f",
        power: Float = 1.0f
    ): Boolean

    fun dragFloat3(
        label: String,
        v: FloatArray,
        vSpeed: Float = 1.0f,
        vMin: Float = 0.0f,
        vMax: Float = 0.0f,
        format: String = "%.3f",
        power: Float = 1.0f
    ): Boolean

    fun dragFloat4(
        label: String,
        v: FloatArray,
        vSpeed: Float = 1.0f,
        vMin: Float = 0.0f,
        vMax: Float = 0.0f,
        format: String = "%.3f",
        power: Float = 1.0f
    ): Boolean

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
    ): Boolean

    fun dragInt(
        label: String,
        v: KMutableProperty0<Int>,
        vSpeed: Float = 1.0f,
        vMin: Int = 0,
        vMax: Int = 0,
        format: String = "%d"
    ): Boolean

    fun dragInt2(
        label: String,
        v: IntArray,
        vSpeed: Float = 1.0f,
        vMin: Int = 0,
        vMax: Int = 0,
        format: String = "%d"
    ): Boolean

    fun dragInt3(
        label: String,
        v: IntArray,
        vSpeed: Float = 1.0f,
        vMin: Int = 0,
        vMax: Int = 0,
        format: String = "%d"
    ): Boolean

    fun dragInt4(
        label: String,
        v: IntArray,
        vSpeed: Float = 1.0f,
        vMin: Int = 0,
        vMax: Int = 0,
        format: String = "%d"
    ): Boolean

    fun dragIntRange2(
        label: String,
        vCurrentMin: KMutableProperty0<Int>,
        vCurrentMax: KMutableProperty0<Int>,
        vSpeed: Float = 1.0f,
        vMin: Int = 0,
        vMax: Int = 0,
        format: String = "%d",
        formatMax: String? = null
    ): Boolean

    fun dummy(size: Vec2)

    fun end()

    fun endChild()

    fun endChildFrame()

    fun endCombo()

    fun endDragDropSource()

    fun endDragDropTarget()

    fun endFrame()

    fun endGroup()

    fun endMainMenuBar()

    fun endMenu()

    fun endMenuBar()

    fun endPopup()

    fun endTabBar()

    fun endTabItem()

    fun endTooltip()

    fun getBackgroundDrawList(): ImDrawList

    fun getClipboardText(): String?

    fun getColorU32(idx: ImGuiCol, alphaMul: Float = 1.0f): UInt

    fun getColorU32(col: Vec4): UInt

    fun getColorU32(col: UInt): UInt

    fun getColumnIndex(): Int

    fun getColumnOffset(columnIndex: Int = -1): Float

    fun getColumnWidth(columnIndex: Int = -1): Float

    fun getColumnsCount(): Int

    fun getContentRegionAvail(): Vec2

    fun getContentRegionMax(): Vec2

    fun getCurrentContext(): ImGuiContext

    fun getCursorPos(): Vec2

    fun getCursorPosX(): Float

    fun getCursorPosY(): Float

    fun getCursorScreenPos(): Vec2

    fun getCursorStartPos(): Vec2

    fun getDragDropPayload(): ImGuiPayload

    fun getDrawData(): ImDrawData

    fun getDrawListSharedData(): ImDrawListSharedData

    fun getFont(): ImFont

    fun getFontSize(): Float

    fun getFontTexUvWhitePixel(): Vec2

    fun getForegroundDrawList(): ImDrawList

    fun getFrameCount(): Int

    fun getFrameHeight(): Float

    fun getFrameHeightWithSpacing(): Float

    fun getID(strId: String): ImGuiID

    fun getID(strIdBegin: String, strIdEnd: String): ImGuiID

    fun getIO(): ImGuiIO

    fun getItemRectMax(): Vec2

    fun getItemRectMin(): Vec2

    fun getItemRectSize(): Vec2

    fun getKeyIndex(imguiKey: ImGuiKey): Int

    fun getKeyPressedAmount(
        keyIndex: Int,
        repeatDelay: Float,
        rate: Float
    ): Int

    fun getMouseCursor(): ImGuiMouseCursor

    fun getMouseDragDelta(button: Int = 0, lockThreshold: Float = -1.0f): Vec2

    fun getMousePos(): Vec2

    fun getMousePosOnOpeningCurrentPopup(): Vec2

    fun getScrollMaxX(): Float

    fun getScrollMaxY(): Float

    fun getScrollX(): Float

    fun getScrollY(): Float

    fun getStateStorage(): ImGuiStorage

    fun getStyle(): ImGuiStyle

    fun getStyleColorName(idx: ImGuiCol): String?

    fun getStyleColorVec4(idx: ImGuiCol): ImVec4

    fun getTextLineHeight(): Float

    fun getTextLineHeightWithSpacing(): Float

    fun getTime(): Double

    fun getTreeNodeToLabelSpacing(): Float

    fun getVersion(): String?

    fun getWindowContentRegionMax(): Vec2

    fun getWindowContentRegionMin(): Vec2

    fun getWindowContentRegionWidth(): Float

    fun getWindowDrawList(): ImDrawList

    fun getWindowHeight(): Float

    fun getWindowPos(): Vec2

    fun getWindowSize(): Vec2

    fun getWindowWidth(): Float

    fun image(
        userTextureId: ImTextureID,
        size: Vec2,
        uv0: Vec2 = Vec2.Zero,
        uv1: Vec2 = Vec2(1f, 1f),
        tintCol: Vec4 = Vec4(1f, 1f, 1f, 1f),
        borderCol: Vec4 = Vec4.Zero
    )

    fun imageButton(
        userTextureId: ImTextureID,
        size: Vec2,
        uv0: Vec2 = Vec2.Zero,
        uv1: Vec2 = Vec2(1f, 1f),
        framePadding: Int = -1,
        bgCol: Vec4 = Vec4.Zero,
        tintCol: Vec4 = Vec4(1f, 1f, 1f, 1f)
    ): Boolean

    fun indent(indentW: Float = 0.0f)

    fun inputDouble(
        label: String,
        v: KMutableProperty0<Double>,
        step: Double = 0.0,
        stepFast: Double = 0.0,
        format: String = "%.6f",
        flags: Flag<ImGuiInputTextFlags>? = null
    ): Boolean

    fun inputFloat(
        label: String,
        v: KMutableProperty0<Float>,
        step: Float = 0.0f,
        stepFast: Float = 0.0f,
        format: String = "%.3f",
        flags: Flag<ImGuiInputTextFlags>? = null
    ): Boolean

    fun inputFloat2(
        label: String,
        v: FloatArray,
        format: String = "%.3f",
        flags: Flag<ImGuiInputTextFlags>? = null
    ): Boolean

    fun inputFloat3(
        label: String,
        v: FloatArray,
        format: String = "%.3f",
        flags: Flag<ImGuiInputTextFlags>? = null
    ): Boolean

    fun inputFloat4(
        label: String,
        v: FloatArray,
        format: String = "%.3f",
        flags: Flag<ImGuiInputTextFlags>? = null
    ): Boolean

    fun inputInt(
        label: String,
        v: KMutableProperty0<Int>,
        step: Int = 1,
        stepFast: Int = 100,
        flags: Flag<ImGuiInputTextFlags>? = null
    ): Boolean

    fun inputInt2(
        label: String,
        v: IntArray,
        flags: Flag<ImGuiInputTextFlags>? = null
    ): Boolean

    fun inputInt3(
        label: String,
        v: IntArray,
        flags: Flag<ImGuiInputTextFlags>? = null
    ): Boolean

    fun inputInt4(
        label: String,
        v: IntArray,
        flags: Flag<ImGuiInputTextFlags>? = null
    ): Boolean

    fun invisibleButton(strId: String, size: Vec2): Boolean

    fun isAnyItemActive(): Boolean

    fun isAnyItemFocused(): Boolean

    fun isAnyItemHovered(): Boolean

    fun isAnyMouseDown(): Boolean

    fun isItemActivated(): Boolean

    fun isItemActive(): Boolean

    fun isItemClicked(mouseButton: Int = 0): Boolean

    fun isItemDeactivated(): Boolean

    fun isItemDeactivatedAfterEdit(): Boolean

    fun isItemEdited(): Boolean

    fun isItemFocused(): Boolean

    fun isItemHovered(flags: Flag<ImGuiHoveredFlags>? = null): Boolean

    fun isItemToggledOpen(): Boolean

    fun isItemVisible(): Boolean

    fun isKeyDown(userKeyIndex: Int): Boolean

    fun isKeyPressed(userKeyIndex: Int, repeat: Boolean = true): Boolean

    fun isKeyReleased(userKeyIndex: Int): Boolean

    fun isMouseClicked(button: Int, repeat: Boolean = false): Boolean

    fun isMouseDoubleClicked(button: Int): Boolean

    fun isMouseDown(button: Int): Boolean

    fun isMouseDragging(button: Int = 0, lockThreshold: Float = -1.0f): Boolean

    fun isMouseHoveringRect(
        rMin: Vec2,
        rMax: Vec2,
        clip: Boolean = true
    ): Boolean

    fun isMousePosValid(mousePos: ImVec2? = null): Boolean

    fun isMouseReleased(button: Int): Boolean

    fun isPopupOpen(strId: String): Boolean

    fun isRectVisible(size: Vec2): Boolean

    fun isRectVisible(rectMin: Vec2, rectMax: Vec2): Boolean

    fun isWindowAppearing(): Boolean

    fun isWindowCollapsed(): Boolean

    fun isWindowFocused(flags: Flag<ImGuiFocusedFlags>? = null): Boolean

    fun isWindowHovered(flags: Flag<ImGuiHoveredFlags>? = null): Boolean

    fun labelText(label: String, fmt: String)

    fun listBoxFooter()

    fun listBoxHeader(label: String, size: Vec2 = Vec2.Zero): Boolean

    fun listBoxHeader(
        label: String,
        itemsCount: Int,
        heightInItems: Int = -1
    ): Boolean

    fun loadIniSettingsFromDisk(iniFilename: String)

    fun loadIniSettingsFromMemory(iniData: String, iniSize: ULong = 0uL)

    fun logButtons()

    fun logFinish()

    fun logText(fmt: String)

    fun logToClipboard(autoOpenDepth: Int = -1)

    fun logToFile(autoOpenDepth: Int = -1, filename: String? = null)

    fun logToTTY(autoOpenDepth: Int = -1)

    fun menuItem(
        label: String,
        shortcut: String? = null,
        selected: Boolean = false,
        enabled: Boolean = true
    ): Boolean

    fun menuItem(
        label: String,
        shortcut: String,
        pSelected: KMutableProperty0<Boolean>,
        enabled: Boolean = true
    ): Boolean

    fun newFrame()

    fun newLine()

    fun nextColumn()

    fun openPopup(strId: String)

    fun openPopupOnItemClick(strId: String? = null, mouseButton: Int = 1): Boolean

    fun popAllowKeyboardFocus()

    fun popButtonRepeat()

    fun popClipRect()

    fun popFont()

    fun popID()

    fun popItemWidth()

    fun popStyleColor(count: Int = 1)

    fun popStyleVar(count: Int = 1)

    fun popTextWrapPos()

    fun progressBar(
        fraction: Float,
        sizeArg: Vec2 = Vec2(-1f, 0f),
        overlay: String? = null
    )

    fun pushAllowKeyboardFocus(allowKeyboardFocus: Boolean)

    fun pushButtonRepeat(repeat: Boolean)

    fun pushClipRect(
        clipRectMin: Vec2,
        clipRectMax: Vec2,
        intersectWithCurrentClipRect: Boolean
    )

    fun pushFont(font: ImFont)

    fun pushID(strId: String)

    fun pushID(strIdBegin: String, strIdEnd: String)

    fun pushID(intId: Int)

    fun pushItemWidth(itemWidth: Float)

    fun pushStyleColor(idx: ImGuiCol, col: UInt)

    fun pushStyleColor(idx: ImGuiCol, col: Vec4)

    fun pushStyleVar(idx: ImGuiStyleVar, `val`: Float)

    fun pushStyleVar(idx: ImGuiStyleVar, `val`: Vec2)

    fun pushTextWrapPos(wrapLocalPosX: Float = 0.0f)

    fun radioButton(label: String, active: Boolean): Boolean

    fun radioButton(
        label: String,
        v: KMutableProperty0<Int>,
        vButton: Int
    ): Boolean

    fun render()

    fun resetMouseDragDelta(button: Int = 0)

    fun sameLine(offsetFromStartX: Float = 0.0f, spacing: Float = -1.0f)

    fun saveIniSettingsToDisk(iniFilename: String)

    fun saveIniSettingsToMemory(outIniSize: KMutableProperty0<ULong>? = null): String?

    fun selectable(
        label: String,
        selected: Boolean = false,
        flags: Flag<ImGuiSelectableFlags>? = null,
        size: Vec2 = Vec2.Zero
    ): Boolean

    fun selectable(
        label: String,
        pSelected: KMutableProperty0<Boolean>,
        flags: Flag<ImGuiSelectableFlags>? = null,
        size: Vec2 = Vec2.Zero
    ): Boolean

    fun separator()

    fun setClipboardText(text: String)

    fun setColorEditOptions(flags: Flag<ImGuiColorEditFlags>)

    fun setColumnOffset(columnIndex: Int, offsetX: Float)

    fun setColumnWidth(columnIndex: Int, width: Float)

    fun setCurrentContext(ctx: ImGuiContext)

    fun setCursorPos(localPos: Vec2)

    fun setCursorPosX(localX: Float)

    fun setCursorPosY(localY: Float)

    fun setCursorScreenPos(pos: Vec2)

    fun setItemAllowOverlap()

    fun setItemDefaultFocus()

    fun setKeyboardFocusHere(offset: Int = 0)

    fun setMouseCursor(type: ImGuiMouseCursor)

    fun setNextItemOpen(isOpen: Boolean, cond: Flag<ImGuiCond>? = null)

    fun setNextItemWidth(itemWidth: Float)

    fun setNextWindowBgAlpha(alpha: Float)

    fun setNextWindowCollapsed(collapsed: Boolean, cond: Flag<ImGuiCond>? = null)

    fun setNextWindowContentSize(size: Vec2)

    fun setNextWindowFocus()

    fun setNextWindowPos(
        pos: Vec2,
        cond: Flag<ImGuiCond>? = null,
        pivot: Vec2 = Vec2.Zero
    )

    fun setNextWindowSize(size: Vec2, cond: Flag<ImGuiCond>? = null)

    fun setScrollFromPosX(localX: Float, centerXRatio: Float = 0.5f)

    fun setScrollFromPosY(localY: Float, centerYRatio: Float = 0.5f)

    fun setScrollHereX(centerXRatio: Float = 0.5f)

    fun setScrollHereY(centerYRatio: Float = 0.5f)

    fun setScrollX(scrollX: Float)

    fun setScrollY(scrollY: Float)

    fun setStateStorage(storage: ImGuiStorage)

    fun setTabItemClosed(tabOrDockedWindowLabel: String)

    fun setTooltip(fmt: String)

    fun setWindowCollapsed(collapsed: Boolean, cond: Flag<ImGuiCond>? = null)

    fun setWindowCollapsed(
        name: String,
        collapsed: Boolean,
        cond: Flag<ImGuiCond>? = null
    )

    fun setWindowFocus()

    fun setWindowFocus(name: String)

    fun setWindowFontScale(scale: Float)

    fun setWindowPos(pos: Vec2, cond: Flag<ImGuiCond>? = null)

    fun setWindowPos(
        name: String,
        pos: Vec2,
        cond: Flag<ImGuiCond>? = null
    )

    fun setWindowSize(size: Vec2, cond: Flag<ImGuiCond>? = null)

    fun setWindowSize(
        name: String,
        size: Vec2,
        cond: Flag<ImGuiCond>? = null
    )

    fun showAboutWindow(pOpen: KMutableProperty0<Boolean>? = null)

    fun showDemoWindow(pOpen: KMutableProperty0<Boolean>? = null)

    fun showFontSelector(label: String)

    fun showMetricsWindow(pOpen: KMutableProperty0<Boolean>? = null)

    fun showStyleEditor(ref: ImGuiStyle? = null)

    fun showStyleSelector(label: String): Boolean

    fun showUserGuide()

    fun sliderAngle(
        label: String,
        vRad: KMutableProperty0<Float>,
        vDegreesMin: Float = -360.0f,
        vDegreesMax: Float = +360.0f,
        format: String = "%.0f deg"
    ): Boolean

    fun sliderFloat(
        label: String,
        v: KMutableProperty0<Float>,
        vMin: Float,
        vMax: Float,
        format: String = "%.3f",
        power: Float = 1.0f
    ): Boolean

    fun sliderFloat2(
        label: String,
        v: FloatArray,
        vMin: Float,
        vMax: Float,
        format: String = "%.3f",
        power: Float = 1.0f
    ): Boolean

    fun sliderFloat3(
        label: String,
        v: FloatArray,
        vMin: Float,
        vMax: Float,
        format: String = "%.3f",
        power: Float = 1.0f
    ): Boolean

    fun sliderFloat4(
        label: String,
        v: FloatArray,
        vMin: Float,
        vMax: Float,
        format: String = "%.3f",
        power: Float = 1.0f
    ): Boolean

    fun sliderInt(
        label: String,
        v: KMutableProperty0<Int>,
        vMin: Int,
        vMax: Int,
        format: String = "%d"
    ): Boolean

    fun sliderInt2(
        label: String,
        v: IntArray,
        vMin: Int,
        vMax: Int,
        format: String = "%d"
    ): Boolean

    fun sliderInt3(
        label: String,
        v: IntArray,
        vMin: Int,
        vMax: Int,
        format: String = "%d"
    ): Boolean

    fun sliderInt4(
        label: String,
        v: IntArray,
        vMin: Int,
        vMax: Int,
        format: String = "%d"
    ): Boolean

    fun smallButton(label: String): Boolean

    fun spacing()

    fun styleColorsClassic(dst: ImGuiStyle? = null)

    fun styleColorsDark(dst: ImGuiStyle? = null)

    fun styleColorsLight(dst: ImGuiStyle? = null)

    fun text(fmt: String)

    fun textColored(col: Vec4, fmt: String)

    fun textDisabled(fmt: String)

    fun textUnformatted(text: String, textEnd: String? = null)

    fun textWrapped(fmt: String)

    fun treeNode(label: String): Boolean

    fun treeNode(strId: String, fmt: String): Boolean

    fun treeNodeEx(label: String, flags: Flag<ImGuiTreeNodeFlags>? = null): Boolean

    fun treeNodeEx(
        strId: String,
        flags: Flag<ImGuiTreeNodeFlags>,
        fmt: String
    ): Boolean

    fun treePop()

    fun treePush(strId: String)

    fun treePush()

    fun unindent(indentW: Float = 0.0f)

    fun vSliderFloat(
        label: String,
        size: Vec2,
        v: KMutableProperty0<Float>,
        vMin: Float,
        vMax: Float,
        format: String = "%.3f",
        power: Float = 1.0f
    ): Boolean

    fun vSliderInt(
        label: String,
        size: Vec2,
        v: KMutableProperty0<Int>,
        vMin: Int,
        vMax: Int,
        format: String = "%d"
    ): Boolean

    fun value(prefix: String, b: Boolean)

    fun value(prefix: String, v: Int)

    fun value(prefix: String, v: UInt)

    fun value(
        prefix: String,
        v: Float,
        floatFormat: String? = null
    )
}
