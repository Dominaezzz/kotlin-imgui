import cimgui.internal.CImGui
import com.imgui.ImFontAtlas

actual fun ImFontAtlas.getTexDataAsRGBA32() {
	val pixels = CImGui.new_unsigned_charpp()
	val width = CImGui.new_intp()
	val height = CImGui.new_intp()
	try {
		CImGui.ImFontAtlas_GetTexDataAsRGBA32(ptr, pixels, width, height, null)
	} finally {
		CImGui.delete_unsigned_charpp(pixels)
		CImGui.delete_intp(width)
		CImGui.delete_intp(height)
	}
}
