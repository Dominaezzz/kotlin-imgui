import kotlinx.serialization.*

@Serializable
data class StructMember(
	val type: String,
	@SerialName("template_type")
	val templateType: String? = null,
	val name: String,
	val size: Int? = null
)
