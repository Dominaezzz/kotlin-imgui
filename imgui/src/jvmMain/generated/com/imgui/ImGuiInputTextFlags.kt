package com.imgui

import cimgui.internal.ImGuiInputTextFlags_.ImGuiInputTextFlags_AllowTabInput
import cimgui.internal.ImGuiInputTextFlags_.ImGuiInputTextFlags_AlwaysInsertMode
import cimgui.internal.ImGuiInputTextFlags_.ImGuiInputTextFlags_AutoSelectAll
import cimgui.internal.ImGuiInputTextFlags_.ImGuiInputTextFlags_CallbackAlways
import cimgui.internal.ImGuiInputTextFlags_.ImGuiInputTextFlags_CallbackCharFilter
import cimgui.internal.ImGuiInputTextFlags_.ImGuiInputTextFlags_CallbackCompletion
import cimgui.internal.ImGuiInputTextFlags_.ImGuiInputTextFlags_CallbackHistory
import cimgui.internal.ImGuiInputTextFlags_.ImGuiInputTextFlags_CallbackResize
import cimgui.internal.ImGuiInputTextFlags_.ImGuiInputTextFlags_CharsDecimal
import cimgui.internal.ImGuiInputTextFlags_.ImGuiInputTextFlags_CharsHexadecimal
import cimgui.internal.ImGuiInputTextFlags_.ImGuiInputTextFlags_CharsNoBlank
import cimgui.internal.ImGuiInputTextFlags_.ImGuiInputTextFlags_CharsScientific
import cimgui.internal.ImGuiInputTextFlags_.ImGuiInputTextFlags_CharsUppercase
import cimgui.internal.ImGuiInputTextFlags_.ImGuiInputTextFlags_CtrlEnterForNewLine
import cimgui.internal.ImGuiInputTextFlags_.ImGuiInputTextFlags_EnterReturnsTrue
import cimgui.internal.ImGuiInputTextFlags_.ImGuiInputTextFlags_Multiline
import cimgui.internal.ImGuiInputTextFlags_.ImGuiInputTextFlags_NoHorizontalScroll
import cimgui.internal.ImGuiInputTextFlags_.ImGuiInputTextFlags_NoMarkEdited
import cimgui.internal.ImGuiInputTextFlags_.ImGuiInputTextFlags_NoUndoRedo
import cimgui.internal.ImGuiInputTextFlags_.ImGuiInputTextFlags_Password
import cimgui.internal.ImGuiInputTextFlags_.ImGuiInputTextFlags_ReadOnly
import kotlin.Int

actual enum class ImGuiInputTextFlags(
  override val value: Int
) : Flag<ImGuiInputTextFlags> {
  CharsDecimal(ImGuiInputTextFlags_CharsDecimal),

  CharsHexadecimal(ImGuiInputTextFlags_CharsHexadecimal),

  CharsUppercase(ImGuiInputTextFlags_CharsUppercase),

  CharsNoBlank(ImGuiInputTextFlags_CharsNoBlank),

  AutoSelectAll(ImGuiInputTextFlags_AutoSelectAll),

  EnterReturnsTrue(ImGuiInputTextFlags_EnterReturnsTrue),

  CallbackCompletion(ImGuiInputTextFlags_CallbackCompletion),

  CallbackHistory(ImGuiInputTextFlags_CallbackHistory),

  CallbackAlways(ImGuiInputTextFlags_CallbackAlways),

  CallbackCharFilter(ImGuiInputTextFlags_CallbackCharFilter),

  AllowTabInput(ImGuiInputTextFlags_AllowTabInput),

  CtrlEnterForNewLine(ImGuiInputTextFlags_CtrlEnterForNewLine),

  NoHorizontalScroll(ImGuiInputTextFlags_NoHorizontalScroll),

  AlwaysInsertMode(ImGuiInputTextFlags_AlwaysInsertMode),

  ReadOnly(ImGuiInputTextFlags_ReadOnly),

  Password(ImGuiInputTextFlags_Password),

  NoUndoRedo(ImGuiInputTextFlags_NoUndoRedo),

  CharsScientific(ImGuiInputTextFlags_CharsScientific),

  CallbackResize(ImGuiInputTextFlags_CallbackResize),

  Multiline(ImGuiInputTextFlags_Multiline),

  NoMarkEdited(ImGuiInputTextFlags_NoMarkEdited);

  override val info: Flag.EnumInfo<ImGuiInputTextFlags>
    get() = cachedInfo
  actual companion object {
    private val cachedInfo: Flag.EnumInfo<ImGuiInputTextFlags> = Flag.enumInfo()

    fun from(value: Int): ImGuiInputTextFlags = when (value) {
      ImGuiInputTextFlags_CharsDecimal -> CharsDecimal
      ImGuiInputTextFlags_CharsHexadecimal -> CharsHexadecimal
      ImGuiInputTextFlags_CharsUppercase -> CharsUppercase
      ImGuiInputTextFlags_CharsNoBlank -> CharsNoBlank
      ImGuiInputTextFlags_AutoSelectAll -> AutoSelectAll
      ImGuiInputTextFlags_EnterReturnsTrue -> EnterReturnsTrue
      ImGuiInputTextFlags_CallbackCompletion -> CallbackCompletion
      ImGuiInputTextFlags_CallbackHistory -> CallbackHistory
      ImGuiInputTextFlags_CallbackAlways -> CallbackAlways
      ImGuiInputTextFlags_CallbackCharFilter -> CallbackCharFilter
      ImGuiInputTextFlags_AllowTabInput -> AllowTabInput
      ImGuiInputTextFlags_CtrlEnterForNewLine -> CtrlEnterForNewLine
      ImGuiInputTextFlags_NoHorizontalScroll -> NoHorizontalScroll
      ImGuiInputTextFlags_AlwaysInsertMode -> AlwaysInsertMode
      ImGuiInputTextFlags_ReadOnly -> ReadOnly
      ImGuiInputTextFlags_Password -> Password
      ImGuiInputTextFlags_NoUndoRedo -> NoUndoRedo
      ImGuiInputTextFlags_CharsScientific -> CharsScientific
      ImGuiInputTextFlags_CallbackResize -> CallbackResize
      ImGuiInputTextFlags_Multiline -> Multiline
      ImGuiInputTextFlags_NoMarkEdited -> NoMarkEdited
      else -> throw NoSuchElementException("""Unknown enum constant $value""")
    }

    fun fromMultiple(value: Int): Flag<ImGuiInputTextFlags> = Flag(value, cachedInfo)
  }
}
