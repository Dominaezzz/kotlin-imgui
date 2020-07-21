import com.imgui.ImGui
import com.imgui.Vec2
import kotlin.test.Test

class ImGuiTest {
	@Test
	fun basicTest() {
		ImGui.createContext()

		val io = ImGui.getIO()

		// Build atlas
		io.fonts!!.getTexDataAsRGBA32()

		io.displaySize = Vec2(1920f, 1080f)
		io.deltaTime = 1.0f / 60.0f

		ImGui.newFrame()
		run {
			ImGui.text("This is some text")
		}
		ImGui.render()

		ImGui.destroyContext()
	}
}
