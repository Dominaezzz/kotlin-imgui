package com.imgui

import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.String
import kotlin.UInt
import kotlin.Unit
import kotlin.UseExperimental
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import kotlin.reflect.KMutableProperty0

@UseExperimental(ExperimentalContracts::class)
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

@UseExperimental(ExperimentalContracts::class)
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

@UseExperimental(ExperimentalContracts::class)
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

@UseExperimental(ExperimentalContracts::class)
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

@UseExperimental(ExperimentalContracts::class)
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

@UseExperimental(ExperimentalContracts::class)
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

@UseExperimental(ExperimentalContracts::class)
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

@UseExperimental(ExperimentalContracts::class)
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

@UseExperimental(ExperimentalContracts::class)
inline fun ImGui.popupContextItem(
    strId: String? = null,
    mouseButton: ImGuiMouseButton = ImGuiMouseButton.Right,
    block: () -> Unit
) {
    contract {
        callsInPlace(block, InvocationKind.AT_MOST_ONCE)
    }

    if (beginPopupContextItem(strId, mouseButton)) {
        try {
            block()
        } finally {
            endPopup()
        }
    }
}

@UseExperimental(ExperimentalContracts::class)
inline fun ImGui.popupContextVoid(
    strId: String? = null,
    mouseButton: ImGuiMouseButton = ImGuiMouseButton.Right,
    block: () -> Unit
) {
    contract {
        callsInPlace(block, InvocationKind.AT_MOST_ONCE)
    }

    if (beginPopupContextVoid(strId, mouseButton)) {
        try {
            block()
        } finally {
            endPopup()
        }
    }
}

@UseExperimental(ExperimentalContracts::class)
inline fun ImGui.popupContextWindow(
    strId: String? = null,
    mouseButton: ImGuiMouseButton = ImGuiMouseButton.Right,
    alsoOverItems: Boolean = true,
    block: () -> Unit
) {
    contract {
        callsInPlace(block, InvocationKind.AT_MOST_ONCE)
    }

    if (beginPopupContextWindow(strId, mouseButton, alsoOverItems)) {
        try {
            block()
        } finally {
            endPopup()
        }
    }
}

@UseExperimental(ExperimentalContracts::class)
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

@UseExperimental(ExperimentalContracts::class)
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

@UseExperimental(ExperimentalContracts::class)
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

@UseExperimental(ExperimentalContracts::class)
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

@UseExperimental(ExperimentalContracts::class)
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

@UseExperimental(ExperimentalContracts::class)
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

@UseExperimental(ExperimentalContracts::class)
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

@UseExperimental(ExperimentalContracts::class)
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

@UseExperimental(ExperimentalContracts::class)
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

@UseExperimental(ExperimentalContracts::class)
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

@UseExperimental(ExperimentalContracts::class)
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

@UseExperimental(ExperimentalContracts::class)
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

@UseExperimental(ExperimentalContracts::class)
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

@UseExperimental(ExperimentalContracts::class)
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

@UseExperimental(ExperimentalContracts::class)
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

@UseExperimental(ExperimentalContracts::class)
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

@UseExperimental(ExperimentalContracts::class)
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

@UseExperimental(ExperimentalContracts::class)
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

@UseExperimental(ExperimentalContracts::class)
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

@UseExperimental(ExperimentalContracts::class)
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

@UseExperimental(ExperimentalContracts::class)
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

@UseExperimental(ExperimentalContracts::class)
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

@UseExperimental(ExperimentalContracts::class)
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
