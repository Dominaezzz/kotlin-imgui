import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class EnumValue(
		val name: String,
		val value: String,
		@SerialName("calc_value")
		val calcValue: Int
)
