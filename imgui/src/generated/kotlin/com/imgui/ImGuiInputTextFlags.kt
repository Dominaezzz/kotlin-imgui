package com.imgui

import cimgui.internal.ImGuiInputTextFlags_
import cimgui.internal.ImGuiInputTextFlags_AllowTabInput
import cimgui.internal.ImGuiInputTextFlags_AlwaysInsertMode
import cimgui.internal.ImGuiInputTextFlags_AutoSelectAll
import cimgui.internal.ImGuiInputTextFlags_CallbackAlways
import cimgui.internal.ImGuiInputTextFlags_CallbackCharFilter
import cimgui.internal.ImGuiInputTextFlags_CallbackCompletion
import cimgui.internal.ImGuiInputTextFlags_CallbackHistory
import cimgui.internal.ImGuiInputTextFlags_CallbackResize
import cimgui.internal.ImGuiInputTextFlags_CharsDecimal
import cimgui.internal.ImGuiInputTextFlags_CharsHexadecimal
import cimgui.internal.ImGuiInputTextFlags_CharsNoBlank
import cimgui.internal.ImGuiInputTextFlags_CharsScientific
import cimgui.internal.ImGuiInputTextFlags_CharsUppercase
import cimgui.internal.ImGuiInputTextFlags_CtrlEnterForNewLine
import cimgui.internal.ImGuiInputTextFlags_EnterReturnsTrue
import cimgui.internal.ImGuiInputTextFlags_Multiline
import cimgui.internal.ImGuiInputTextFlags_NoHorizontalScroll
import cimgui.internal.ImGuiInputTextFlags_NoMarkEdited
import cimgui.internal.ImGuiInputTextFlags_NoUndoRedo
import cimgui.internal.ImGuiInputTextFlags_Password
import cimgui.internal.ImGuiInputTextFlags_ReadOnly
import kotlinx.cinterop.convert

enum class ImGuiInputTextFlags(
  override val value: cimgui.internal.ImGuiInputTextFlags
) : Flag<ImGuiInputTextFlags> {
  CharsDecimal(ImGuiInputTextFlags_CharsDecimal.convert()),

  CharsHexadecimal(ImGuiInputTextFlags_CharsHexadecimal.convert()),

  CharsUppercase(ImGuiInputTextFlags_CharsUppercase.convert()),

  CharsNoBlank(ImGuiInputTextFlags_CharsNoBlank.convert()),

  AutoSelectAll(ImGuiInputTextFlags_AutoSelectAll.convert()),

  EnterReturnsTrue(ImGuiInputTextFlags_EnterReturnsTrue.convert()),

  CallbackCompletion(ImGuiInputTextFlags_CallbackCompletion.convert()),

  CallbackHistory(ImGuiInputTextFlags_CallbackHistory.convert()),

  CallbackAlways(ImGuiInputTextFlags_CallbackAlways.convert()),

  CallbackCharFilter(ImGuiInputTextFlags_CallbackCharFilter.convert()),

  AllowTabInput(ImGuiInputTextFlags_AllowTabInput.convert()),

  CtrlEnterForNewLine(ImGuiInputTextFlags_CtrlEnterForNewLine.convert()),

  NoHorizontalScroll(ImGuiInputTextFlags_NoHorizontalScroll.convert()),

  AlwaysInsertMode(ImGuiInputTextFlags_AlwaysInsertMode.convert()),

  ReadOnly(ImGuiInputTextFlags_ReadOnly.convert()),

  Password(ImGuiInputTextFlags_Password.convert()),

  NoUndoRedo(ImGuiInputTextFlags_NoUndoRedo.convert()),

  CharsScientific(ImGuiInputTextFlags_CharsScientific.convert()),

  CallbackResize(ImGuiInputTextFlags_CallbackResize.convert()),

  Multiline(ImGuiInputTextFlags_Multiline.convert()),

  NoMarkEdited(ImGuiInputTextFlags_NoMarkEdited.convert());

  override val info: Flag.EnumInfo<ImGuiInputTextFlags>
    get() = cachedInfo
  companion object {
    private val cachedInfo: Flag.EnumInfo<ImGuiInputTextFlags> = Flag.enumInfo()

    fun from(value: cimgui.internal.ImGuiInputTextFlags): ImGuiInputTextFlags = when
        (value.convert<ImGuiInputTextFlags_>()) {
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


    fun fromMultiple(value: cimgui.internal.ImGuiInputTextFlags): Flag<ImGuiInputTextFlags> =
        Flag(value.convert(), cachedInfo)
  }
}
