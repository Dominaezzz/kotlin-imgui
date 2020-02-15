package com.imgui

import cimgui.internal.ImDrawList_AddBezierCurve
import cimgui.internal.ImDrawList_AddCircle
import cimgui.internal.ImDrawList_AddCircleFilled
import cimgui.internal.ImDrawList_AddConvexPolyFilled
import cimgui.internal.ImDrawList_AddDrawCmd
import cimgui.internal.ImDrawList_AddImage
import cimgui.internal.ImDrawList_AddImageQuad
import cimgui.internal.ImDrawList_AddImageRounded
import cimgui.internal.ImDrawList_AddLine
import cimgui.internal.ImDrawList_AddNgon
import cimgui.internal.ImDrawList_AddNgonFilled
import cimgui.internal.ImDrawList_AddPolyline
import cimgui.internal.ImDrawList_AddQuad
import cimgui.internal.ImDrawList_AddQuadFilled
import cimgui.internal.ImDrawList_AddRect
import cimgui.internal.ImDrawList_AddRectFilled
import cimgui.internal.ImDrawList_AddRectFilledMultiColor
import cimgui.internal.ImDrawList_AddText
import cimgui.internal.ImDrawList_AddTextFontPtr
import cimgui.internal.ImDrawList_AddTriangle
import cimgui.internal.ImDrawList_AddTriangleFilled
import cimgui.internal.ImDrawList_ChannelsMerge
import cimgui.internal.ImDrawList_ChannelsSetCurrent
import cimgui.internal.ImDrawList_ChannelsSplit
import cimgui.internal.ImDrawList_Clear
import cimgui.internal.ImDrawList_ClearFreeMemory
import cimgui.internal.ImDrawList_CloneOutput
import cimgui.internal.ImDrawList_GetClipRectMax
import cimgui.internal.ImDrawList_GetClipRectMin
import cimgui.internal.ImDrawList_ImDrawList
import cimgui.internal.ImDrawList_PathArcTo
import cimgui.internal.ImDrawList_PathArcToFast
import cimgui.internal.ImDrawList_PathBezierCurveTo
import cimgui.internal.ImDrawList_PathClear
import cimgui.internal.ImDrawList_PathFillConvex
import cimgui.internal.ImDrawList_PathLineTo
import cimgui.internal.ImDrawList_PathLineToMergeDuplicate
import cimgui.internal.ImDrawList_PathRect
import cimgui.internal.ImDrawList_PathStroke
import cimgui.internal.ImDrawList_PopClipRect
import cimgui.internal.ImDrawList_PopTextureID
import cimgui.internal.ImDrawList_PrimQuadUV
import cimgui.internal.ImDrawList_PrimRect
import cimgui.internal.ImDrawList_PrimRectUV
import cimgui.internal.ImDrawList_PrimReserve
import cimgui.internal.ImDrawList_PrimUnreserve
import cimgui.internal.ImDrawList_PrimVtx
import cimgui.internal.ImDrawList_PrimWriteVtx
import cimgui.internal.ImDrawList_PushClipRect
import cimgui.internal.ImDrawList_PushClipRectFullScreen
import cimgui.internal.ImDrawList_PushTextureID
import cimgui.internal.ImDrawList_UpdateClipRect
import cimgui.internal.ImDrawList_UpdateTextureID
import cimgui.internal.ImDrawList_destroy
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.UInt
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.pointed

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImDrawList(
  val ptr: CPointer<cimgui.internal.ImDrawList>
) {
  actual val flags: Flag<ImDrawListFlags>
    get() = ptr.pointed.Flags.let { ImDrawListFlags.fromMultiple(it) }

  actual constructor(sharedData: ImDrawListSharedData) :
      this(ImDrawList_ImDrawList(sharedData.ptr)!!)

  actual fun addBezierCurve(
    p1: Vec2,
    p2: Vec2,
    p3: Vec2,
    p4: Vec2,
    col: UInt,
    thickness: Float,
    numSegments: Int
  ) {
    ImDrawList_AddBezierCurve(ptr, p1.toCValue(), p2.toCValue(), p3.toCValue(), p4.toCValue(), col,
        thickness, numSegments)
  }

  actual fun addCircle(
    center: Vec2,
    radius: Float,
    col: UInt,
    numSegments: Int,
    thickness: Float
  ) {
    ImDrawList_AddCircle(ptr, center.toCValue(), radius, col, numSegments, thickness)
  }

  actual fun addCircleFilled(
    center: Vec2,
    radius: Float,
    col: UInt,
    numSegments: Int
  ) {
    ImDrawList_AddCircleFilled(ptr, center.toCValue(), radius, col, numSegments)
  }

  actual fun addConvexPolyFilled(
    points: ImVec2,
    numPoints: Int,
    col: UInt
  ) {
    ImDrawList_AddConvexPolyFilled(ptr, points.ptr, numPoints, col)
  }

  actual fun addDrawCmd() {
    ImDrawList_AddDrawCmd(ptr)
  }

  actual fun addImage(
    userTextureId: ImTextureID,
    pMin: Vec2,
    pMax: Vec2,
    uvMin: Vec2,
    uvMax: Vec2,
    col: UInt
  ) {
    ImDrawList_AddImage(ptr, userTextureId.value, pMin.toCValue(), pMax.toCValue(),
        uvMin.toCValue(), uvMax.toCValue(), col)
  }

  actual fun addImageQuad(
    userTextureId: ImTextureID,
    p1: Vec2,
    p2: Vec2,
    p3: Vec2,
    p4: Vec2,
    uv1: Vec2,
    uv2: Vec2,
    uv3: Vec2,
    uv4: Vec2,
    col: UInt
  ) {
    ImDrawList_AddImageQuad(ptr, userTextureId.value, p1.toCValue(), p2.toCValue(), p3.toCValue(),
        p4.toCValue(), uv1.toCValue(), uv2.toCValue(), uv3.toCValue(), uv4.toCValue(), col)
  }

  actual fun addImageRounded(
    userTextureId: ImTextureID,
    pMin: Vec2,
    pMax: Vec2,
    uvMin: Vec2,
    uvMax: Vec2,
    col: UInt,
    rounding: Float,
    roundingCorners: Flag<ImDrawCornerFlags>
  ) {
    ImDrawList_AddImageRounded(ptr, userTextureId.value, pMin.toCValue(), pMax.toCValue(),
        uvMin.toCValue(), uvMax.toCValue(), col, rounding, roundingCorners.value)
  }

  actual fun addLine(
    p1: Vec2,
    p2: Vec2,
    col: UInt,
    thickness: Float
  ) {
    ImDrawList_AddLine(ptr, p1.toCValue(), p2.toCValue(), col, thickness)
  }

  actual fun addNgon(
    center: Vec2,
    radius: Float,
    col: UInt,
    numSegments: Int,
    thickness: Float
  ) {
    ImDrawList_AddNgon(ptr, center.toCValue(), radius, col, numSegments, thickness)
  }

  actual fun addNgonFilled(
    center: Vec2,
    radius: Float,
    col: UInt,
    numSegments: Int
  ) {
    ImDrawList_AddNgonFilled(ptr, center.toCValue(), radius, col, numSegments)
  }

  actual fun addPolyline(
    points: ImVec2,
    numPoints: Int,
    col: UInt,
    closed: Boolean,
    thickness: Float
  ) {
    ImDrawList_AddPolyline(ptr, points.ptr, numPoints, col, closed, thickness)
  }

  actual fun addQuad(
    p1: Vec2,
    p2: Vec2,
    p3: Vec2,
    p4: Vec2,
    col: UInt,
    thickness: Float
  ) {
    ImDrawList_AddQuad(ptr, p1.toCValue(), p2.toCValue(), p3.toCValue(), p4.toCValue(), col,
        thickness)
  }

  actual fun addQuadFilled(
    p1: Vec2,
    p2: Vec2,
    p3: Vec2,
    p4: Vec2,
    col: UInt
  ) {
    ImDrawList_AddQuadFilled(ptr, p1.toCValue(), p2.toCValue(), p3.toCValue(), p4.toCValue(), col)
  }

  actual fun addRect(
    pMin: Vec2,
    pMax: Vec2,
    col: UInt,
    rounding: Float,
    roundingCorners: Flag<ImDrawCornerFlags>,
    thickness: Float
  ) {
    ImDrawList_AddRect(ptr, pMin.toCValue(), pMax.toCValue(), col, rounding, roundingCorners.value,
        thickness)
  }

  actual fun addRectFilled(
    pMin: Vec2,
    pMax: Vec2,
    col: UInt,
    rounding: Float,
    roundingCorners: Flag<ImDrawCornerFlags>
  ) {
    ImDrawList_AddRectFilled(ptr, pMin.toCValue(), pMax.toCValue(), col, rounding,
        roundingCorners.value)
  }

  actual fun addRectFilledMultiColor(
    pMin: Vec2,
    pMax: Vec2,
    colUprLeft: UInt,
    colUprRight: UInt,
    colBotRight: UInt,
    colBotLeft: UInt
  ) {
    ImDrawList_AddRectFilledMultiColor(ptr, pMin.toCValue(), pMax.toCValue(), colUprLeft,
        colUprRight, colBotRight, colBotLeft)
  }

  actual fun addText(
    pos: Vec2,
    col: UInt,
    textBegin: String,
    textEnd: String?
  ) {
    ImDrawList_AddText(ptr, pos.toCValue(), col, textBegin, textEnd)
  }

  actual fun addText(
    font: ImFont,
    fontSize: Float,
    pos: Vec2,
    col: UInt,
    textBegin: String,
    textEnd: String?,
    wrapWidth: Float,
    cpuFineClipRect: ImVec4?
  ) {
    ImDrawList_AddTextFontPtr(ptr, font.ptr, fontSize, pos.toCValue(), col, textBegin, textEnd,
        wrapWidth, cpuFineClipRect?.ptr)
  }

  actual fun addTriangle(
    p1: Vec2,
    p2: Vec2,
    p3: Vec2,
    col: UInt,
    thickness: Float
  ) {
    ImDrawList_AddTriangle(ptr, p1.toCValue(), p2.toCValue(), p3.toCValue(), col, thickness)
  }

  actual fun addTriangleFilled(
    p1: Vec2,
    p2: Vec2,
    p3: Vec2,
    col: UInt
  ) {
    ImDrawList_AddTriangleFilled(ptr, p1.toCValue(), p2.toCValue(), p3.toCValue(), col)
  }

  actual fun channelsMerge() {
    ImDrawList_ChannelsMerge(ptr)
  }

  actual fun channelsSetCurrent(n: Int) {
    ImDrawList_ChannelsSetCurrent(ptr, n)
  }

  actual fun channelsSplit(count: Int) {
    ImDrawList_ChannelsSplit(ptr, count)
  }

  actual fun clear() {
    ImDrawList_Clear(ptr)
  }

  actual fun clearFreeMemory() {
    ImDrawList_ClearFreeMemory(ptr)
  }

  actual fun cloneOutput(): ImDrawList = ImDrawList_CloneOutput(ptr)!!.let(::ImDrawList)

  actual fun getClipRectMax(): Vec2 = ImDrawList_GetClipRectMax(ptr).fromCValue()

  actual fun getClipRectMin(): Vec2 = ImDrawList_GetClipRectMin(ptr).fromCValue()

  actual fun pathArcTo(
    center: Vec2,
    radius: Float,
    aMin: Float,
    aMax: Float,
    numSegments: Int
  ) {
    ImDrawList_PathArcTo(ptr, center.toCValue(), radius, aMin, aMax, numSegments)
  }

  actual fun pathArcToFast(
    center: Vec2,
    radius: Float,
    aMinOf12: Int,
    aMaxOf12: Int
  ) {
    ImDrawList_PathArcToFast(ptr, center.toCValue(), radius, aMinOf12, aMaxOf12)
  }

  actual fun pathBezierCurveTo(
    p2: Vec2,
    p3: Vec2,
    p4: Vec2,
    numSegments: Int
  ) {
    ImDrawList_PathBezierCurveTo(ptr, p2.toCValue(), p3.toCValue(), p4.toCValue(), numSegments)
  }

  actual fun pathClear() {
    ImDrawList_PathClear(ptr)
  }

  actual fun pathFillConvex(col: UInt) {
    ImDrawList_PathFillConvex(ptr, col)
  }

  actual fun pathLineTo(pos: Vec2) {
    ImDrawList_PathLineTo(ptr, pos.toCValue())
  }

  actual fun pathLineToMergeDuplicate(pos: Vec2) {
    ImDrawList_PathLineToMergeDuplicate(ptr, pos.toCValue())
  }

  actual fun pathRect(
    rectMin: Vec2,
    rectMax: Vec2,
    rounding: Float,
    roundingCorners: Flag<ImDrawCornerFlags>
  ) {
    ImDrawList_PathRect(ptr, rectMin.toCValue(), rectMax.toCValue(), rounding,
        roundingCorners.value)
  }

  actual fun pathStroke(
    col: UInt,
    closed: Boolean,
    thickness: Float
  ) {
    ImDrawList_PathStroke(ptr, col, closed, thickness)
  }

  actual fun popClipRect() {
    ImDrawList_PopClipRect(ptr)
  }

  actual fun popTextureID() {
    ImDrawList_PopTextureID(ptr)
  }

  actual fun primQuadUV(
    a: Vec2,
    b: Vec2,
    c: Vec2,
    d: Vec2,
    uvA: Vec2,
    uvB: Vec2,
    uvC: Vec2,
    uvD: Vec2,
    col: UInt
  ) {
    ImDrawList_PrimQuadUV(ptr, a.toCValue(), b.toCValue(), c.toCValue(), d.toCValue(),
        uvA.toCValue(), uvB.toCValue(), uvC.toCValue(), uvD.toCValue(), col)
  }

  actual fun primRect(
    a: Vec2,
    b: Vec2,
    col: UInt
  ) {
    ImDrawList_PrimRect(ptr, a.toCValue(), b.toCValue(), col)
  }

  actual fun primRectUV(
    a: Vec2,
    b: Vec2,
    uvA: Vec2,
    uvB: Vec2,
    col: UInt
  ) {
    ImDrawList_PrimRectUV(ptr, a.toCValue(), b.toCValue(), uvA.toCValue(), uvB.toCValue(), col)
  }

  actual fun primReserve(idxCount: Int, vtxCount: Int) {
    ImDrawList_PrimReserve(ptr, idxCount, vtxCount)
  }

  actual fun primUnreserve(idxCount: Int, vtxCount: Int) {
    ImDrawList_PrimUnreserve(ptr, idxCount, vtxCount)
  }

  actual fun primVtx(
    pos: Vec2,
    uv: Vec2,
    col: UInt
  ) {
    ImDrawList_PrimVtx(ptr, pos.toCValue(), uv.toCValue(), col)
  }

  actual fun primWriteVtx(
    pos: Vec2,
    uv: Vec2,
    col: UInt
  ) {
    ImDrawList_PrimWriteVtx(ptr, pos.toCValue(), uv.toCValue(), col)
  }

  actual fun pushClipRect(
    clipRectMin: Vec2,
    clipRectMax: Vec2,
    intersectWithCurrentClipRect: Boolean
  ) {
    ImDrawList_PushClipRect(ptr, clipRectMin.toCValue(), clipRectMax.toCValue(),
        intersectWithCurrentClipRect)
  }

  actual fun pushClipRectFullScreen() {
    ImDrawList_PushClipRectFullScreen(ptr)
  }

  actual fun pushTextureID(textureId: ImTextureID) {
    ImDrawList_PushTextureID(ptr, textureId.value)
  }

  actual fun updateClipRect() {
    ImDrawList_UpdateClipRect(ptr)
  }

  actual fun updateTextureID() {
    ImDrawList_UpdateTextureID(ptr)
  }

  actual fun destroy() {
    ImDrawList_destroy(ptr)
  }
}
