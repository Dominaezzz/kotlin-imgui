import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

@Serializable
data class Definition(
		/**
		 * The name of the struct the function belongs to (will be "" if it is top level in ImGui namespace)
		 */
		@SerialName("stname")
		val structName: String,

		/**
		 * The overloaded cimgui name (if absent it would be taken from [cimguiName]).
		 */
		@SerialName("ov_cimguiname")
		val overloadedCimguiName: String?,

		/**
		 * The name without overloading (this should be used if there is not [overloadedCimguiName]).
		 */
		@SerialName("cimguiname")
		val cimguiName: String,

		/**
		 * the return type
		 */
		@SerialName("ret")
		val returnType: String? = null,

		/**
		 * Is setted if original return type is a reference. (will be a pointer in cimgui)
		 */
		@SerialName("retref")
		val returnRef: String? = null,

		/**
		 * An array of collections (each one with type: argument type and name: the argument name)
		 */
		val argsT: List<Arg>,

		/**
		 * A string of argsT concatenated and separated by commas
		 */
		val args: String,

		/**
		 * A string with the argument names separated by commas for calling imgui function
		 */
		@SerialName("call_args")
		val callArgs: String,

		/**
		 * A collection in which key is argument name and value is the default value.
		 */
		val defaults: JsonElement,

		/**
		 * will be true if this function is hand-written (not generated)
		 */
		val manual: Boolean = false,

		/**
		 * is setted if some argument is a vararg
		 */
		@SerialName("isvararg")
		val isVararg: String? = null,

		/**
		 * is setted if the function is a constructor for a class
		 */
		@SerialName("constructor")
		val isCtor: Boolean = false,

		/**
		 * is setted if the function is a destructor for a class
		 */
		@SerialName("destructor")
		val isDtor: Boolean = false,

		/**
		 * is setted if the function belongs to a templated class (ImVector)
		 */
		@SerialName("templated")
		val isTemplated: Boolean = false,

		/**
		 * is setted if the function belongs to a struct generated from template (ImVector_ImWchar)
		 */
		@SerialName("templatedgen")
		val isTemplatedGen: Boolean = false,

		/**
		 * If present can be 1 or 2 (explained meaning in usage) if return type was a user defined type
		 */
		val nonUDT: Int? = null,

		@SerialName("funcname")
		val functionName: String? = null,

		/**
		 * The header file that this functions was declared in (should be either 'imgui' or 'internal')
		 */
		val location: String? = null
)
{
	@Serializable
	data class Arg(val name: String, val type: String)
}
