import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StructMember(
		val type: String,
		@SerialName("template_type")
		val templateType: String? = null,
		val name: String,
		val size: Int? = null
)
