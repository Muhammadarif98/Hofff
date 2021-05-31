package com.example.hofff.main.domain.model

import com.google.gson.annotations.SerializedName

data class ItemsInfo (
	@SerializedName("articul") val articul : Int,
	@SerializedName("name") val name : String,
	@SerializedName("quantity") val quantity : Int,
	@SerializedName("price") val price : Int,
	@SerializedName("DiscAmount") val discAmount : String,
	@SerializedName("imageUrl") val imageUrl : String,
	@SerializedName("services") val services : List<String>
)