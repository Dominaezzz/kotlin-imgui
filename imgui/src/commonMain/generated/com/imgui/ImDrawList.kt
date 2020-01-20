package com.imgui

import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.String
import kotlin.UInt

expect class ImDrawList {
  val flags: Flag<ImDrawListFlags>

  constructor(sharedData: ImDrawListSharedData)

  fun addBezierCurve(
    pos0: Vec2,
    cp0: Vec2,
    cp1: Vec2,
    pos1: Vec2,
    col: UInt,
    thickness: Float,
    numSegments: Int = 0
  )

  fun addCircle(
    center: Vec2,
    radius: Float,
    col: UInt,
    numSegments: Int = 12,
    thickness: Float = 1.0f
  )

  fun addCircleFilled(
    center: Vec2,
    radius: Float,
    col: UInt,
    numSegments: Int = 12
  )

  fun addConvexPolyFilled(
    points: ImVec2,
    numPoints: Int,
    col: UInt
  )

  fun addDrawCmd()

  fun addImage(
    userTextureId: ImTextureID,
    pMin: Vec2,
    pMax: Vec2,
    uvMin: Vec2 = Vec2.Zero,
    uvMax: Vec2 = Vec2(1f, 1f),
    col: UInt = (255u shl 24) or (255u shl 16) or (255u shl 8) or (255u shl 0)
  )

  fun addImageQuad(
    userTextureId: ImTextureID,
    p1: Vec2,
    p2: Vec2,
    p3: Vec2,
    p4: Vec2,
    uv1: Vec2 = Vec2.Zero,
    uv2: Vec2 = Vec2(1f, 0f),
    uv3: Vec2 = Vec2(1f, 1f),
    uv4: Vec2 = Vec2(0f, 1f),
    col: UInt = (255u shl 24) or (255u shl 16) or (255u shl 8) or (255u shl 0)
  )

  fun addImageRounded(
    userTextureId: ImTextureID,
    pMin: Vec2,
    pMax: Vec2,
    uvMin: Vec2,
    uvMax: Vec2,
    col: UInt,
    rounding: Float,
    roundingCorners: Flag<ImDrawCornerFlags> = ImDrawCornerFlags.All
  )

  fun addLine(
    p1: Vec2,
    p2: Vec2,
    col: UInt,
    thickness: Float = 1.0f
  )

  fun addPolyline(
    points: ImVec2,
    numPoints: Int,
    col: UInt,
    closed: Boolean,
    thickness: Float
  )

  fun addQuad(
    p1: Vec2,
    p2: Vec2,
    p3: Vec2,
    p4: Vec2,
    col: UInt,
    thickness: Float = 1.0f
  )

  fun addQuadFilled(
    p1: Vec2,
    p2: Vec2,
    p3: Vec2,
    p4: Vec2,
    col: UInt
  )

  fun addRect(
    pMin: Vec2,
    pMax: Vec2,
    col: UInt,
    rounding: Float = 0.0f,
    roundingCorners: Flag<ImDrawCornerFlags> = ImDrawCornerFlags.All,
    thickness: Float = 1.0f
  )

  fun addRectFilled(
    pMin: Vec2,
    pMax: Vec2,
    col: UInt,
    rounding: Float = 0.0f,
    roundingCorners: Flag<ImDrawCornerFlags> = ImDrawCornerFlags.All
  )

  fun addRectFilledMultiColor(
    pMin: Vec2,
    pMax: Vec2,
    colUprLeft: UInt,
    colUprRight: UInt,
    colBotRight: UInt,
    colBotLeft: UInt
  )

  fun addText(
    pos: Vec2,
    col: UInt,
    textBegin: String,
    textEnd: String? = null
  )

  fun addText(
    font: ImFont,
    fontSize: Float,
    pos: Vec2,
    col: UInt,
    textBegin: String,
    textEnd: String? = null,
    wrapWidth: Float = 0.0f,
    cpuFineClipRect: ImVec4? = null
  )

  fun addTriangle(
    p1: Vec2,
    p2: Vec2,
    p3: Vec2,
    col: UInt,
    thickness: Float = 1.0f
  )

  fun addTriangleFilled(
    p1: Vec2,
    p2: Vec2,
    p3: Vec2,
    col: UInt
  )

  fun channelsMerge()

  fun channelsSetCurrent(n: Int)

  fun channelsSplit(count: Int)

  fun clear()

  fun clearFreeMemory()

  fun cloneOutput(): ImDrawList

  fun getClipRectMax(): Vec2

  fun getClipRectMin(): Vec2

  fun pathArcTo(
    center: Vec2,
    radius: Float,
    aMin: Float,
    aMax: Float,
    numSegments: Int = 10
  )

  fun pathArcToFast(
    center: Vec2,
    radius: Float,
    aMinOf12: Int,
    aMaxOf12: Int
  )

  fun pathBezierCurveTo(
    p1: Vec2,
    p2: Vec2,
    p3: Vec2,
    numSegments: Int = 0
  )

  fun pathClear()

  fun pathFillConvex(col: UInt)

  fun pathLineTo(pos: Vec2)

  fun pathLineToMergeDuplicate(pos: Vec2)

  fun pathRect(
    rectMin: Vec2,
    rectMax: Vec2,
    rounding: Float = 0.0f,
    roundingCorners: Flag<ImDrawCornerFlags> = ImDrawCornerFlags.All
  )

  fun pathStroke(
    col: UInt,
    closed: Boolean,
    thickness: Float = 1.0f
  )

  fun popClipRect()

  fun popTextureID()

  fun primQuadUV(
    a: Vec2,
    b: Vec2,
    c: Vec2,
    d: Vec2,
    uvA: Vec2,
    uvB: Vec2,
    uvC: Vec2,
    uvD: Vec2,
    col: UInt
  )

  fun primRect(
    a: Vec2,
    b: Vec2,
    col: UInt
  )

  fun primRectUV(
    a: Vec2,
    b: Vec2,
    uvA: Vec2,
    uvB: Vec2,
    col: UInt
  )

  fun primReserve(idxCount: Int, vtxCount: Int)

  fun primVtx(
    pos: Vec2,
    uv: Vec2,
    col: UInt
  )

  fun primWriteVtx(
    pos: Vec2,
    uv: Vec2,
    col: UInt
  )

  fun pushClipRect(
    clipRectMin: Vec2,
    clipRectMax: Vec2,
    intersectWithCurrentClipRect: Boolean = false
  )

  fun pushClipRectFullScreen()

  fun pushTextureID(textureId: ImTextureID)

  fun updateClipRect()

  fun updateTextureID()

  fun destroy()
}
