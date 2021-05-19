import com.google.gson.annotations.SerializedName




data class Items (

	@SerializedName("id") val id : String,
	@SerializedName("number") val number : String,
	@SerializedName("datetime") val datetime : Int,
	@SerializedName("status") val status : Status,
	@SerializedName("delivery") val delivery : Delivery,
	@SerializedName("phone") val phone : String,
	@SerializedName("sum") val sum : Int
)