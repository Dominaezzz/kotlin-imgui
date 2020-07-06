package com.imgui

import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.OptIn
import kotlin.String
import kotlin.UInt
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import kotlin.reflect.KMutableProperty0

@OptIn(ExperimentalContracts::class)
inline fun ImGui.columns(
    strId: String,
    count: Int,
    flags: Flag<ImGuiColumnsFlags>? = null,
    block: () -> Unit
) {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }

    beginColumns(strId, count, flags)
    try {
        block()
    } finally {
        endColumns()
    }
}

@OptIn(ExperimentalContracts::class)
inline fun ImGui.combo(
    label: String,
    previewValue: String,
    flags: Flag<ImGuiComboFlags>? = null,
    block: () -> Unit
) {
    contract {
        callsInPlace(block, InvocationKind.AT_MOST_ONCE)
    }

    if (beginCombo(label, previewValue, flags)) {
        try {
            block()
        } finally {
            endCombo()
        }
    }
}

@OptIn(ExperimentalContracts::class)
inline fun ImGui.dragDropSource(flags: Flag<ImGuiDragDropFlags>? = null, block: () -> Unit) {
    contract {
        callsInPlace(block, InvocationKind.AT_MOST_ONCE)
    }

    if (beginDragDropSource(flags)) {
        try {
            block()
        } finally {
            endDragDropSource()
        }
    }
}

@OptIn(ExperimentalContracts::class)
inline fun ImGui.dragDropTarget(block: () -> Unit) {
    contract {
        callsInPlace(block, InvocationKind.AT_MOST_ONCE)
    }

    if (beginDragDropTarget()) {
        try {
            block()
        } finally {
            endDragDropTarget()
        }
    }
}

@OptIn(ExperimentalContracts::class)
inline fun ImGui.group(block: () -> Unit) {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }

    beginGroup()
    try {
        block()
    } finally {
        endGroup()
    }
}

@OptIn(ExperimentalContracts::class)
inline fun ImGui.mainMenuBar(block: () -> Unit) {
    contract {
        callsInPlace(block, InvocationKind.AT_MOST_ONCE)
    }

    if (beginMainMenuBar()) {
        try {
            block()
        } finally {
            endMainMenuBar()
        }
    }
}

@OptIn(ExperimentalContracts::class)
inline fun ImGui.menu(
    label: String,
    enabled: Boolean = true,
    block: () -> Unit
) {
    contract {
        callsInPlace(block, InvocationKind.AT_MOST_ONCE)
    }

    if (beginMenu(label, enabled)) {
        try {
            block()
        } finally {
            endMenu()
        }
    }
}

@OptIn(ExperimentalContracts::class)
inline fun ImGui.menuBar(block: () -> Unit) {
    contract {
        callsInPlace(block, InvocationKind.AT_MOST_ONCE)
    }

    if (beginMenuBar()) {
        try {
            block()
        } finally {
            endMenuBar()
        }
    }
}

@OptIn(ExperimentalContracts::class)
inline fun ImGui.popup(
    strId: String,
    flags: Flag<ImGuiWindowFlags>? = null,
    block: () -> Unit
) {
    contract {
        callsInPlace(block, InvocationKind.AT_MOST_ONCE)
    }

    if (beginPopup(strId, flags)) {
        try {
            block()
        } finally {
            endPopup()
        }
    }
}

@OptIn(ExperimentalContracts::class)
inline fun ImGui.popupContextItem(
    strId: String? = null,
    popupFlags: Flag<ImGuiPopupFlags> = ImGuiPopupFlags.MouseButtonRight,
    block: () -> Unit
) {
    contract {
        callsInPlace(block, InvocationKind.AT_MOST_ONCE)
    }

    if (beginPopupContextItem(strId, popupFlags)) {
        try {
            block()
        } finally {
            endPopup()
        }
    }
}

@OptIn(ExperimentalContracts::class)
inline fun ImGui.popupContextVoid(
    strId: String? = null,
    popupFlags: Flag<ImGuiPopupFlags> = ImGuiPopupFlags.MouseButtonRight,
    block: () -> Unit
) {
    contract {
        callsInPlace(block, InvocationKind.AT_MOST_ONCE)
    }

    if (beginPopupContextVoid(strId, popupFlags)) {
        try {
            block()
        } finally {
            endPopup()
        }
    }
}

@OptIn(ExperimentalContracts::class)
inline fun ImGui.popupContextWindow(
    strId: String? = null,
    popupFlags: Flag<ImGuiPopupFlags> = ImGuiPopupFlags.MouseButtonRight,
    block: () -> Unit
) {
    contract {
        callsInPlace(block, InvocationKind.AT_MOST_ONCE)
    }

    if (beginPopupContextWindow(strId, popupFlags)) {
        try {
            block()
        } finally {
            endPopup()
        }
    }
}

@OptIn(ExperimentalContracts::class)
inline fun ImGui.popupEx(
    id: ImGuiID,
    extraFlags: Flag<ImGuiWindowFlags>,
    block: () -> Unit
) {
    contract {
        callsInPlace(block, InvocationKind.AT_MOST_ONCE)
    }

    if (beginPopupEx(id, extraFlags)) {
        try {
            block()
        } finally {
            endPopup()
        }
    }
}

@OptIn(ExperimentalContracts::class)
inline fun ImGui.popupModal(
    name: String,
    pOpen: KMutableProperty0<Boolean>? = null,
    flags: Flag<ImGuiWindowFlags>? = null,
    block: () -> Unit
) {
    contract {
        callsInPlace(block, InvocationKind.AT_MOST_ONCE)
    }

    if (beginPopupModal(name, pOpen, flags)) {
        try {
            block()
        } finally {
            endPopup()
        }
    }
}

@OptIn(ExperimentalContracts::class)
inline fun ImGui.tabBar(
    strId: String,
    flags: Flag<ImGuiTabBarFlags>? = null,
    block: () -> Unit
) {
    contract {
        callsInPlace(block, InvocationKind.AT_MOST_ONCE)
    }

    if (beginTabBar(strId, flags)) {
        try {
            block()
        } finally {
            endTabBar()
        }
    }
}

@OptIn(ExperimentalContracts::class)
inline fun ImGui.tabItem(
    label: String,
    pOpen: KMutableProperty0<Boolean>? = null,
    flags: Flag<ImGuiTabItemFlags>? = null,
    block: () -> Unit
) {
    contract {
        callsInPlace(block, InvocationKind.AT_MOST_ONCE)
    }

    if (beginTabItem(label, pOpen, flags)) {
        try {
            block()
        } finally {
            endTabItem()
        }
    }
}

@OptIn(ExperimentalContracts::class)
inline fun ImGui.tooltip(block: () -> Unit) {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }

    beginTooltip()
    try {
        block()
    } finally {
        endTooltip()
    }
}

@OptIn(ExperimentalContracts::class)
inline fun ImGui.listBox(
    label: String,
    size: Vec2 = Vec2.Zero,
    block: () -> Unit
) {
    contract {
        callsInPlace(block, InvocationKind.AT_MOST_ONCE)
    }

    if (listBoxHeader(label, size)) {
        try {
            block()
        } finally {
            listBoxFooter()
        }
    }
}

@OptIn(ExperimentalContracts::class)
inline fun ImGui.listBox(
    label: String,
    itemsCount: Int,
    heightInItems: Int = -1,
    block: () -> Unit
) {
    contract {
        callsInPlace(block, InvocationKind.AT_MOST_ONCE)
    }

    if (listBoxHeader(label, itemsCount, heightInItems)) {
        try {
            block()
        } finally {
            listBoxFooter()
        }
    }
}

@OptIn(ExperimentalContracts::class)
inline fun ImGui.withAllowKeyboardFocus(allowKeyboardFocus: Boolean, block: () -> Unit) {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }

    pushAllowKeyboardFocus(allowKeyboardFocus)
    try {
        block()
    } finally {
        popAllowKeyboardFocus()
    }
}

@OptIn(ExperimentalContracts::class)
inline fun ImGui.withButtonRepeat(repeat: Boolean, block: () -> Unit) {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }

    pushButtonRepeat(repeat)
    try {
        block()
    } finally {
        popButtonRepeat()
    }
}

@OptIn(ExperimentalContracts::class)
inline fun ImGui.withClipRect(
    clipRectMin: Vec2,
    clipRectMax: Vec2,
    intersectWithCurrentClipRect: Boolean,
    block: () -> Unit
) {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }

    pushClipRect(clipRectMin, clipRectMax, intersectWithCurrentClipRect)
    try {
        block()
    } finally {
        popClipRect()
    }
}

@OptIn(ExperimentalContracts::class)
inline fun ImGui.withColumnsBackground(block: () -> Unit) {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }

    pushColumnsBackground()
    try {
        block()
    } finally {
        popColumnsBackground()
    }
}

@OptIn(ExperimentalContracts::class)
inline fun ImGui.withFocusScope(id: ImGuiID, block: () -> Unit) {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }

    pushFocusScope(id)
    try {
        block()
    } finally {
        popFocusScope()
    }
}

@OptIn(ExperimentalContracts::class)
inline fun ImGui.withFont(font: ImFont, block: () -> Unit) {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }

    pushFont(font)
    try {
        block()
    } finally {
        popFont()
    }
}

@OptIn(ExperimentalContracts::class)
inline fun ImGui.withID(strId: String, block: () -> Unit) {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }

    pushID(strId)
    try {
        block()
    } finally {
        popID()
    }
}

@OptIn(ExperimentalContracts::class)
inline fun ImGui.withID(
    strIdBegin: String,
    strIdEnd: String,
    block: () -> Unit
) {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }

    pushID(strIdBegin, strIdEnd)
    try {
        block()
    } finally {
        popID()
    }
}

@OptIn(ExperimentalContracts::class)
inline fun ImGui.withID(intId: Int, block: () -> Unit) {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }

    pushID(intId)
    try {
        block()
    } finally {
        popID()
    }
}

@OptIn(ExperimentalContracts::class)
inline fun ImGui.withItemFlag(
    option: Flag<ImGuiItemFlags>,
    enabled: Boolean,
    block: () -> Unit
) {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }

    pushItemFlag(option, enabled)
    try {
        block()
    } finally {
        popItemFlag()
    }
}

@OptIn(ExperimentalContracts::class)
inline fun ImGui.withItemWidth(itemWidth: Float, block: () -> Unit) {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }

    pushItemWidth(itemWidth)
    try {
        block()
    } finally {
        popItemWidth()
    }
}

@OptIn(ExperimentalContracts::class)
inline fun ImGui.withStyleColor(
    idx: ImGuiCol,
    col: UInt,
    block: () -> Unit
) {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }

    pushStyleColor(idx, col)
    try {
        block()
    } finally {
        popStyleColor()
    }
}

@OptIn(ExperimentalContracts::class)
inline fun ImGui.withStyleColor(
    idx: ImGuiCol,
    col: Vec4,
    block: () -> Unit
) {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }

    pushStyleColor(idx, col)
    try {
        block()
    } finally {
        popStyleColor()
    }
}

@OptIn(ExperimentalContracts::class)
inline fun ImGui.withStyleVar(
    idx: ImGuiStyleVar,
    `val`: Float,
    block: () -> Unit
) {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }

    pushStyleVar(idx, `val`)
    try {
        block()
    } finally {
        popStyleVar()
    }
}

@OptIn(ExperimentalContracts::class)
inline fun ImGui.withStyleVar(
    idx: ImGuiStyleVar,
    `val`: Vec2,
    block: () -> Unit
) {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }

    pushStyleVar(idx, `val`)
    try {
        block()
    } finally {
        popStyleVar()
    }
}

@OptIn(ExperimentalContracts::class)
inline fun ImGui.withTextWrapPos(wrapLocalPosX: Float = 0.0f, block: () -> Unit) {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }

    pushTextWrapPos(wrapLocalPosX)
    try {
        block()
    } finally {
        popTextWrapPos()
    }
}

@OptIn(ExperimentalContracts::class)
inline fun ImGui.treeNode(label: String, block: () -> Unit) {
    contract {
        callsInPlace(block, InvocationKind.AT_MOST_ONCE)
    }

    if (treeNode(label)) {
        try {
            block()
        } finally {
            treePop()
        }
    }
}

@OptIn(ExperimentalContracts::class)
inline fun ImGui.treeNode(
    strId: String,
    fmt: String,
    block: () -> Unit
) {
    contract {
        callsInPlace(block, InvocationKind.AT_MOST_ONCE)
    }

    if (treeNode(strId, fmt)) {
        try {
            block()
        } finally {
            treePop()
        }
    }
}

@OptIn(ExperimentalContracts::class)
inline fun ImGui.treeNodeBehavior(
    id: ImGuiID,
    flags: Flag<ImGuiTreeNodeFlags>,
    label: String,
    labelEnd: String? = null,
    block: () -> Unit
) {
    contract {
        callsInPlace(block, InvocationKind.AT_MOST_ONCE)
    }

    if (treeNodeBehavior(id, flags, label, labelEnd)) {
        try {
            block()
        } finally {
            treePop()
        }
    }
}

@OptIn(ExperimentalContracts::class)
inline fun ImGui.treeNodeBehaviorIsOpen(
    id: ImGuiID,
    flags: Flag<ImGuiTreeNodeFlags>? = null,
    block: () -> Unit
) {
    contract {
        callsInPlace(block, InvocationKind.AT_MOST_ONCE)
    }

    if (treeNodeBehaviorIsOpen(id, flags)) {
        try {
            block()
        } finally {
            treePop()
        }
    }
}

@OptIn(ExperimentalContracts::class)
inline fun ImGui.treeNodeEx(
    label: String,
    flags: Flag<ImGuiTreeNodeFlags>? = null,
    block: () -> Unit
) {
    contract {
        callsInPlace(block, InvocationKind.AT_MOST_ONCE)
    }

    if (treeNodeEx(label, flags)) {
        try {
            block()
        } finally {
            treePop()
        }
    }
}

@OptIn(ExperimentalContracts::class)
inline fun ImGui.treeNodeEx(
    strId: String,
    flags: Flag<ImGuiTreeNodeFlags>,
    fmt: String,
    block: () -> Unit
) {
    contract {
        callsInPlace(block, InvocationKind.AT_MOST_ONCE)
    }

    if (treeNodeEx(strId, flags, fmt)) {
        try {
            block()
        } finally {
            treePop()
        }
    }
}
