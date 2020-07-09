import kotlinx.serialization.*

@Serializable
data class EnumValue(
	val name: String,
	val value: String,
	@SerialName("calc_value")
	val calcValue: Int
)
