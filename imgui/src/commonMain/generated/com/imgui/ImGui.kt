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

    fun activateItem(id: ImGuiID)

    fun alignTextToFramePadding()

    fun arrowButton(strId: String, dir: ImGuiDir): Boolean

    fun arrowButtonEx(
        strId: String,
        dir: ImGuiDir,
        sizeArg: Vec2,
        flags: Flag<ImGuiButtonFlags>? = null
    ): Boolean

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

    fun beginChildEx(
        name: String,
        id: ImGuiID,
        sizeArg: Vec2,
        border: Boolean,
        flags: Flag<ImGuiWindowFlags>
    ): Boolean

    fun beginChildFrame(
        id: ImGuiID,
        size: Vec2,
        flags: Flag<ImGuiWindowFlags>? = null
    ): Boolean

    fun beginColumns(
        strId: String,
        count: Int,
        flags: Flag<ImGuiColumnsFlags>? = null
    )

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

    fun beginPopupContextItem(strId: String? = null, popupFlags: Flag<ImGuiPopupFlags> =
            ImGuiPopupFlags.MouseButtonRight): Boolean

    fun beginPopupContextVoid(strId: String? = null, popupFlags: Flag<ImGuiPopupFlags> =
            ImGuiPopupFlags.MouseButtonRight): Boolean

    fun beginPopupContextWindow(strId: String? = null, popupFlags: Flag<ImGuiPopupFlags> =
            ImGuiPopupFlags.MouseButtonRight): Boolean

    fun beginPopupEx(id: ImGuiID, extraFlags: Flag<ImGuiWindowFlags>): Boolean

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

    fun beginTooltipEx(extraFlags: Flag<ImGuiWindowFlags>, tooltipFlags: Flag<ImGuiTooltipFlags>)

    fun bringWindowToDisplayBack(window: ImGuiWindow)

    fun bringWindowToDisplayFront(window: ImGuiWindow)

    fun bringWindowToFocusFront(window: ImGuiWindow)

    fun bullet()

    fun bulletText(fmt: String)

    fun button(label: String, size: Vec2 = Vec2.Zero): Boolean

    fun buttonEx(
        label: String,
        sizeArg: Vec2 = Vec2.Zero,
        flags: Flag<ImGuiButtonFlags>? = null
    ): Boolean

    fun calcItemWidth(): Float

    fun calcListClipping(
        itemsCount: Int,
        itemsHeight: Float,
        outItemsDisplayStart: KMutableProperty0<Int>,
        outItemsDisplayEnd: KMutableProperty0<Int>
    )

    fun calcTypematicRepeatAmount(
        t0: Float,
        t1: Float,
        repeatDelay: Float,
        repeatRate: Float
    ): Int

    fun calcWrapWidthForPos(pos: Vec2, wrapPosX: Float): Float

    fun captureKeyboardFromApp(wantCaptureKeyboardValue: Boolean = true)

    fun captureMouseFromApp(wantCaptureMouseValue: Boolean = true)

    fun checkbox(label: String, v: KMutableProperty0<Boolean>): Boolean

    fun checkboxFlags(
        label: String,
        flags: KMutableProperty0<UInt>,
        flagsValue: UInt
    ): Boolean

    fun clearActiveID()

    fun clearDragDrop()

    fun clearIniSettings()

    fun closeButton(id: ImGuiID, pos: Vec2): Boolean

    fun closeCurrentPopup()

    fun closePopupToLevel(remaining: Int, restoreFocusToWindowUnderPopup: Boolean)

    fun closePopupsOverWindow(refWindow: ImGuiWindow, restoreFocusToWindowUnderPopup: Boolean)

    fun collapseButton(id: ImGuiID, pos: Vec2): Boolean

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

    fun createNewWindowSettings(name: String): ImGuiWindowSettings

    fun dataTypeGetInfo(dataType: ImGuiDataType): ImGuiDataTypeInfo

    fun debugCheckVersionAndDataLayout(
        versionStr: String,
        szIo: ULong,
        szStyle: ULong,
        szVec2: ULong,
        szVec4: ULong,
        szDrawvert: ULong,
        szDrawidx: ULong
    ): Boolean

    fun debugDrawItemRect(col: UInt = (255u shl 24) or (0u shl 16) or (0u shl 8) or (255u shl 0))

    fun debugStartItemPicker()

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

    fun endColumns()

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

    fun findOrCreateColumns(window: ImGuiWindow, id: ImGuiID): ImGuiColumns

    fun findOrCreateWindowSettings(name: String): ImGuiWindowSettings

    fun findRenderedTextEnd(text: String, textEnd: String? = null): String?

    fun findSettingsHandler(typeName: String): ImGuiSettingsHandler

    fun findWindowByID(id: ImGuiID): ImGuiWindow

    fun findWindowByName(name: String): ImGuiWindow

    fun findWindowSettings(id: ImGuiID): ImGuiWindowSettings

    fun focusTopMostWindowUnderOne(underThisWindow: ImGuiWindow, ignoreWindow: ImGuiWindow)

    fun focusWindow(window: ImGuiWindow)

    fun focusableItemRegister(window: ImGuiWindow, id: ImGuiID): Boolean

    fun focusableItemUnregister(window: ImGuiWindow)

    fun gcAwakeTransientWindowBuffers(window: ImGuiWindow)

    fun gcCompactTransientWindowBuffers(window: ImGuiWindow)

    fun getActiveID(): ImGuiID

    fun getBackgroundDrawList(): ImDrawList

    fun getClipboardText(): String?

    fun getColorU32(idx: ImGuiCol, alphaMul: Float = 1.0f): UInt

    fun getColorU32(col: Vec4): UInt

    fun getColorU32(col: UInt): UInt

    fun getColumnIndex(): Int

    fun getColumnNormFromOffset(columns: ImGuiColumns, offset: Float): Float

    fun getColumnOffset(columnIndex: Int = -1): Float

    fun getColumnOffsetFromNorm(columns: ImGuiColumns, offsetNorm: Float): Float

    fun getColumnWidth(columnIndex: Int = -1): Float

    fun getColumnsCount(): Int

    fun getColumnsID(strId: String, count: Int): ImGuiID

    fun getCurrentContext(): ImGuiContext

    fun getCurrentWindow(): ImGuiWindow

    fun getCurrentWindowRead(): ImGuiWindow

    fun getCursorPosX(): Float

    fun getCursorPosY(): Float

    fun getDefaultFont(): ImFont

    fun getDragDropPayload(): ImGuiPayload

    fun getDrawData(): ImDrawData

    fun getDrawListSharedData(): ImDrawListSharedData

    fun getFocusID(): ImGuiID

    fun getFocusScopeID(): ImGuiID

    fun getFont(): ImFont

    fun getFontSize(): Float

    fun getForegroundDrawList(): ImDrawList

    fun getForegroundDrawList(window: ImGuiWindow): ImDrawList

    fun getFrameCount(): Int

    fun getFrameHeight(): Float

    fun getFrameHeightWithSpacing(): Float

    fun getHoveredID(): ImGuiID

    fun getID(strId: String): ImGuiID

    fun getID(strIdBegin: String, strIdEnd: String): ImGuiID

    fun getIO(): ImGuiIO

    fun getInputTextState(id: ImGuiID): ImGuiInputTextState

    fun getItemID(): ImGuiID

    fun getItemStatusFlags(): Flag<ImGuiItemStatusFlags>

    fun getKeyIndex(imguiKey: ImGuiKey): Int

    fun getKeyPressedAmount(
        keyIndex: Int,
        repeatDelay: Float,
        rate: Float
    ): Int

    fun getMergedKeyModFlags(): Flag<ImGuiKeyModFlags>

    fun getMouseCursor(): ImGuiMouseCursor

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

    fun getTopMostPopupModal(): ImGuiWindow

    fun getTreeNodeToLabelSpacing(): Float

    fun getVersion(): String?

    fun getWindowContentRegionWidth(): Float

    fun getWindowDrawList(): ImDrawList

    fun getWindowHeight(): Float

    fun getWindowResizeID(window: ImGuiWindow, n: Int): ImGuiID

    fun getWindowWidth(): Float

    fun imAlphaBlendColors(colA: UInt, colB: UInt): UInt

    fun imCharIsBlankW(c: UInt): Boolean

    fun imDot(a: Vec2, b: Vec2): Float

    fun imFloor(f: Float): Float

    fun imFontAtlasBuildFinish(atlas: ImFontAtlas)

    fun imFontAtlasBuildInit(atlas: ImFontAtlas)

    fun imFontAtlasBuildSetupFont(
        atlas: ImFontAtlas,
        font: ImFont,
        fontConfig: ImFontConfig,
        ascent: Float,
        descent: Float
    )

    fun imFontAtlasBuildWithStbTruetype(atlas: ImFontAtlas): Boolean

    fun imGetDirQuadrantFromDelta(dx: Float, dy: Float): ImGuiDir

    fun imHashStr(
        data: String,
        dataSize: ULong = 0uL,
        seed: UInt = 0u
    ): UInt

    fun imInvLength(lhs: Vec2, failValue: Float): Float

    fun imIsPowerOfTwo(v: Int): Boolean

    fun imLengthSqr(lhs: Vec2): Float

    fun imLengthSqr(lhs: Vec4): Float

    fun imLinearSweep(
        current: Float,
        target: Float,
        speed: Float
    ): Float

    fun imModPositive(a: Int, b: Int): Int

    fun imParseFormatFindEnd(format: String): String?

    fun imParseFormatFindStart(format: String): String?

    fun imParseFormatPrecision(format: String, defaultValue: Int): Int

    fun imPow(x: Float, y: Float): Float

    fun imPow(x: Double, y: Double): Double

    fun imSaturate(f: Float): Float

    fun imStrSkipBlank(str: String): String?

    fun imStrbolW(bufMidLine: String, bufBegin: String): String

    fun imStreolRange(str: String, strEnd: String): String?

    fun imStricmp(str1: String, str2: String): Int

    fun imStristr(
        haystack: String,
        haystackEnd: String,
        needle: String,
        needleEnd: String
    ): String?

    fun imStrlenW(str: String): Int

    fun imStrnicmp(
        str1: String,
        str2: String,
        count: ULong
    ): Int

    fun imTextCharFromUtf8(
        outChar: KMutableProperty0<UInt>,
        inText: String,
        inTextEnd: String
    ): Int

    fun imTextCountCharsFromUtf8(inText: String, inTextEnd: String): Int

    fun imTextCountUtf8BytesFromChar(inText: String, inTextEnd: String): Int

    fun imTextCountUtf8BytesFromStr(inText: String, inTextEnd: String): Int

    fun imTriangleArea(
        a: Vec2,
        b: Vec2,
        c: Vec2
    ): Float

    fun imTriangleContainsPoint(
        a: Vec2,
        b: Vec2,
        c: Vec2,
        p: Vec2
    ): Boolean

    fun imUpperPowerOfTwo(v: Int): Int

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

    fun imageButtonEx(
        id: ImGuiID,
        textureId: ImTextureID,
        size: Vec2,
        uv0: Vec2,
        uv1: Vec2,
        padding: Vec2,
        bgCol: Vec4,
        tintCol: Vec4
    ): Boolean

    fun indent(indentW: Float = 0.0f)

    fun initialize(context: ImGuiContext)

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

    fun isActiveIdUsingKey(key: ImGuiKey): Boolean

    fun isActiveIdUsingNavDir(dir: ImGuiDir): Boolean

    fun isActiveIdUsingNavInput(input: ImGuiNavInput): Boolean

    fun isAnyItemActive(): Boolean

    fun isAnyItemFocused(): Boolean

    fun isAnyItemHovered(): Boolean

    fun isAnyMouseDown(): Boolean

    fun isDragDropPayloadBeingAccepted(): Boolean

    fun isItemActivated(): Boolean

    fun isItemActive(): Boolean

    fun isItemClicked(mouseButton: ImGuiMouseButton = ImGuiMouseButton.Left): Boolean

    fun isItemDeactivated(): Boolean

    fun isItemDeactivatedAfterEdit(): Boolean

    fun isItemEdited(): Boolean

    fun isItemFocused(): Boolean

    fun isItemHovered(flags: Flag<ImGuiHoveredFlags>? = null): Boolean

    fun isItemToggledOpen(): Boolean

    fun isItemToggledSelection(): Boolean

    fun isItemVisible(): Boolean

    fun isKeyDown(userKeyIndex: Int): Boolean

    fun isKeyPressed(userKeyIndex: Int, repeat: Boolean = true): Boolean

    fun isKeyPressedMap(key: ImGuiKey, repeat: Boolean = true): Boolean

    fun isKeyReleased(userKeyIndex: Int): Boolean

    fun isMouseClicked(button: ImGuiMouseButton, repeat: Boolean = false): Boolean

    fun isMouseDoubleClicked(button: ImGuiMouseButton): Boolean

    fun isMouseDown(button: ImGuiMouseButton): Boolean

    fun isMouseDragPastThreshold(button: ImGuiMouseButton, lockThreshold: Float = -1.0f): Boolean

    fun isMouseDragging(button: ImGuiMouseButton, lockThreshold: Float = -1.0f): Boolean

    fun isMouseHoveringRect(
        rMin: Vec2,
        rMax: Vec2,
        clip: Boolean = true
    ): Boolean

    fun isMousePosValid(mousePos: ImVec2? = null): Boolean

    fun isMouseReleased(button: ImGuiMouseButton): Boolean

    fun isNavInputDown(n: ImGuiNavInput): Boolean

    fun isPopupOpen(strId: String, flags: Flag<ImGuiPopupFlags>? = null): Boolean

    fun isPopupOpen(id: ImGuiID, popupFlags: Flag<ImGuiPopupFlags>): Boolean

    fun isRectVisible(size: Vec2): Boolean

    fun isRectVisible(rectMin: Vec2, rectMax: Vec2): Boolean

    fun isWindowAppearing(): Boolean

    fun isWindowChildOf(window: ImGuiWindow, potentialParent: ImGuiWindow): Boolean

    fun isWindowCollapsed(): Boolean

    fun isWindowFocused(flags: Flag<ImGuiFocusedFlags>? = null): Boolean

    fun isWindowHovered(flags: Flag<ImGuiHoveredFlags>? = null): Boolean

    fun isWindowNavFocusable(window: ImGuiWindow): Boolean

    fun itemSize(size: Vec2, textBaselineY: Float = -1.0f)

    fun keepAliveID(id: ImGuiID)

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

    fun logRenderedText(
        refPos: ImVec2,
        text: String,
        textEnd: String? = null
    )

    fun logText(fmt: String)

    fun logToBuffer(autoOpenDepth: Int = -1)

    fun logToClipboard(autoOpenDepth: Int = -1)

    fun logToFile(autoOpenDepth: Int = -1, filename: String? = null)

    fun logToTTY(autoOpenDepth: Int = -1)

    fun markIniSettingsDirty()

    fun markIniSettingsDirty(window: ImGuiWindow)

    fun markItemEdited(id: ImGuiID)

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

    fun navInitWindow(window: ImGuiWindow, forceReinit: Boolean)

    fun navMoveRequestButNoResultYet(): Boolean

    fun navMoveRequestCancel()

    fun navMoveRequestTryWrapping(window: ImGuiWindow, moveFlags: Flag<ImGuiNavMoveFlags>)

    fun newFrame()

    fun newLine()

    fun nextColumn()

    fun openPopup(strId: String, popupFlags: Flag<ImGuiPopupFlags>? = null)

    fun openPopupContextItem(strId: String? = null, popupFlags: Flag<ImGuiPopupFlags> =
            ImGuiPopupFlags.MouseButtonRight): Boolean

    fun openPopupEx(id: ImGuiID, popupFlags: Flag<ImGuiPopupFlags>? = null)

    fun popAllowKeyboardFocus()

    fun popButtonRepeat()

    fun popClipRect()

    fun popColumnsBackground()

    fun popFocusScope()

    fun popFont()

    fun popID()

    fun popItemFlag()

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

    fun pushColumnClipRect(columnIndex: Int)

    fun pushColumnsBackground()

    fun pushFocusScope(id: ImGuiID)

    fun pushFont(font: ImFont)

    fun pushID(strId: String)

    fun pushID(strIdBegin: String, strIdEnd: String)

    fun pushID(intId: Int)

    fun pushItemFlag(option: Flag<ImGuiItemFlags>, enabled: Boolean)

    fun pushItemWidth(itemWidth: Float)

    fun pushMultiItemsWidths(components: Int, widthFull: Float)

    fun pushOverrideID(id: ImGuiID)

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

    fun renderArrow(
        drawList: ImDrawList,
        pos: Vec2,
        col: UInt,
        dir: ImGuiDir,
        scale: Float = 1.0f
    )

    fun renderArrowPointingAt(
        drawList: ImDrawList,
        pos: Vec2,
        halfSz: Vec2,
        direction: ImGuiDir,
        col: UInt
    )

    fun renderBullet(
        drawList: ImDrawList,
        pos: Vec2,
        col: UInt
    )

    fun renderCheckMark(
        drawList: ImDrawList,
        pos: Vec2,
        col: UInt,
        sz: Float
    )

    fun renderColorRectWithAlphaCheckerboard(
        drawList: ImDrawList,
        pMin: Vec2,
        pMax: Vec2,
        fillCol: UInt,
        gridStep: Float,
        gridOff: Vec2,
        rounding: Float = 0.0f,
        roundingCornersFlags: Int
    )

    fun renderFrame(
        pMin: Vec2,
        pMax: Vec2,
        fillCol: UInt,
        border: Boolean = true,
        rounding: Float = 0.0f
    )

    fun renderFrameBorder(
        pMin: Vec2,
        pMax: Vec2,
        rounding: Float = 0.0f
    )

    fun renderMouseCursor(
        drawList: ImDrawList,
        pos: Vec2,
        scale: Float,
        mouseCursor: ImGuiMouseCursor,
        colFill: UInt,
        colBorder: UInt,
        colShadow: UInt
    )

    fun renderText(
        pos: Vec2,
        text: String,
        textEnd: String? = null,
        hideTextAfterHash: Boolean = true
    )

    fun renderTextClipped(
        posMin: Vec2,
        posMax: Vec2,
        text: String,
        textEnd: String,
        textSizeIfKnown: ImVec2,
        align: Vec2 = Vec2.Zero,
        clipRect: ImRect? = null
    )

    fun renderTextClippedEx(
        drawList: ImDrawList,
        posMin: Vec2,
        posMax: Vec2,
        text: String,
        textEnd: String,
        textSizeIfKnown: ImVec2,
        align: Vec2 = Vec2.Zero,
        clipRect: ImRect? = null
    )

    fun renderTextEllipsis(
        drawList: ImDrawList,
        posMin: Vec2,
        posMax: Vec2,
        clipMaxX: Float,
        ellipsisMaxX: Float,
        text: String,
        textEnd: String,
        textSizeIfKnown: ImVec2
    )

    fun renderTextWrapped(
        pos: Vec2,
        text: String,
        textEnd: String,
        wrapWidth: Float
    )

    fun resetMouseDragDelta(button: ImGuiMouseButton = ImGuiMouseButton.Left)

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

    fun separatorEx(flags: Flag<ImGuiSeparatorFlags>)

    fun setActiveID(id: ImGuiID, window: ImGuiWindow)

    fun setClipboardText(text: String)

    fun setColorEditOptions(flags: Flag<ImGuiColorEditFlags>)

    fun setColumnOffset(columnIndex: Int, offsetX: Float)

    fun setColumnWidth(columnIndex: Int, width: Float)

    fun setCurrentContext(ctx: ImGuiContext)

    fun setCurrentFont(font: ImFont)

    fun setCursorPos(localPos: Vec2)

    fun setCursorPosX(localX: Float)

    fun setCursorPosY(localY: Float)

    fun setCursorScreenPos(pos: Vec2)

    fun setFocusID(id: ImGuiID, window: ImGuiWindow)

    fun setHoveredID(id: ImGuiID)

    fun setItemAllowOverlap()

    fun setItemDefaultFocus()

    fun setKeyboardFocusHere(offset: Int = 0)

    fun setMouseCursor(cursorType: ImGuiMouseCursor)

    fun setNavID(
        id: ImGuiID,
        navLayer: Int,
        focusScopeId: ImGuiID
    )

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

    fun setNextWindowScroll(scroll: Vec2)

    fun setNextWindowSize(size: Vec2, cond: Flag<ImGuiCond>? = null)

    fun setScrollFromPosX(localX: Float, centerXRatio: Float = 0.5f)

    fun setScrollFromPosX(
        window: ImGuiWindow,
        localX: Float,
        centerXRatio: Float = 0.5f
    )

    fun setScrollFromPosY(localY: Float, centerYRatio: Float = 0.5f)

    fun setScrollFromPosY(
        window: ImGuiWindow,
        localY: Float,
        centerYRatio: Float = 0.5f
    )

    fun setScrollHereX(centerXRatio: Float = 0.5f)

    fun setScrollHereY(centerYRatio: Float = 0.5f)

    fun setScrollX(scrollX: Float)

    fun setScrollX(window: ImGuiWindow, newScrollX: Float)

    fun setScrollY(scrollY: Float)

    fun setScrollY(window: ImGuiWindow, newScrollY: Float)

    fun setStateStorage(storage: ImGuiStorage)

    fun setTabItemClosed(tabOrDockedWindowLabel: String)

    fun setTooltip(fmt: String)

    fun setWindowCollapsed(collapsed: Boolean, cond: Flag<ImGuiCond>? = null)

    fun setWindowCollapsed(
        name: String,
        collapsed: Boolean,
        cond: Flag<ImGuiCond>? = null
    )

    fun setWindowCollapsed(
        window: ImGuiWindow,
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

    fun setWindowPos(
        window: ImGuiWindow,
        pos: Vec2,
        cond: Flag<ImGuiCond>? = null
    )

    fun setWindowSize(size: Vec2, cond: Flag<ImGuiCond>? = null)

    fun setWindowSize(
        name: String,
        size: Vec2,
        cond: Flag<ImGuiCond>? = null
    )

    fun setWindowSize(
        window: ImGuiWindow,
        size: Vec2,
        cond: Flag<ImGuiCond>? = null
    )

    fun shadeVertsLinearColorGradientKeepAlpha(
        drawList: ImDrawList,
        vertStartIdx: Int,
        vertEndIdx: Int,
        gradientP0: Vec2,
        gradientP1: Vec2,
        col0: UInt,
        col1: UInt
    )

    fun shadeVertsLinearUV(
        drawList: ImDrawList,
        vertStartIdx: Int,
        vertEndIdx: Int,
        a: Vec2,
        b: Vec2,
        uvA: Vec2,
        uvB: Vec2,
        clamp: Boolean
    )

    fun showAboutWindow(pOpen: KMutableProperty0<Boolean>? = null)

    fun showDemoWindow(pOpen: KMutableProperty0<Boolean>? = null)

    fun showFontSelector(label: String)

    fun showMetricsWindow(pOpen: KMutableProperty0<Boolean>? = null)

    fun showStyleEditor(ref: ImGuiStyle? = null)

    fun showStyleSelector(label: String): Boolean

    fun showUserGuide()

    fun shrinkWidths(
        items: ImGuiShrinkWidthItem,
        count: Int,
        widthExcess: Float
    )

    fun shutdown(context: ImGuiContext)

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

    fun startMouseMovingWindow(window: ImGuiWindow)

    fun styleColorsClassic(dst: ImGuiStyle? = null)

    fun styleColorsDark(dst: ImGuiStyle? = null)

    fun styleColorsLight(dst: ImGuiStyle? = null)

    fun tabBarCloseTab(tabBar: ImGuiTabBar, tab: ImGuiTabItem)

    fun tabBarFindTabByID(tabBar: ImGuiTabBar, tabId: ImGuiID): ImGuiTabItem

    fun tabBarQueueChangeTabOrder(
        tabBar: ImGuiTabBar,
        tab: ImGuiTabItem,
        dir: Int
    )

    fun tabBarRemoveTab(tabBar: ImGuiTabBar, tabId: ImGuiID)

    fun tabItemEx(
        tabBar: ImGuiTabBar,
        label: String,
        pOpen: KMutableProperty0<Boolean>,
        flags: Flag<ImGuiTabItemFlags>
    ): Boolean

    fun tempInputIsActive(id: ImGuiID): Boolean

    fun text(fmt: String)

    fun textColored(col: Vec4, fmt: String)

    fun textDisabled(fmt: String)

    fun textEx(
        text: String,
        textEnd: String? = null,
        flags: Flag<ImGuiTextFlags>? = null
    )

    fun textUnformatted(text: String, textEnd: String? = null)

    fun textWrapped(fmt: String)

    fun treeNode(label: String): Boolean

    fun treeNode(strId: String, fmt: String): Boolean

    fun treeNodeBehavior(
        id: ImGuiID,
        flags: Flag<ImGuiTreeNodeFlags>,
        label: String,
        labelEnd: String? = null
    ): Boolean

    fun treeNodeBehaviorIsOpen(id: ImGuiID, flags: Flag<ImGuiTreeNodeFlags>? = null): Boolean

    fun treeNodeEx(label: String, flags: Flag<ImGuiTreeNodeFlags>? = null): Boolean

    fun treeNodeEx(
        strId: String,
        flags: Flag<ImGuiTreeNodeFlags>,
        fmt: String
    ): Boolean

    fun treePop()

    fun treePush(strId: String)

    fun treePush()

    fun treePushOverrideID(id: ImGuiID)

    fun unindent(indentW: Float = 0.0f)

    fun updateHoveredWindowAndCaptureFlags()

    fun updateMouseMovingWindowEndFrame()

    fun updateMouseMovingWindowNewFrame()

    fun updateWindowParentAndRootLinks(
        window: ImGuiWindow,
        flags: Flag<ImGuiWindowFlags>,
        parentWindow: ImGuiWindow
    )

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
