package com.example.hofff.main.domain.model

import com.google.gson.annotations.SerializedName

data class BaseInfo (
	@SerializedName("address") val address : String,
	@SerializedName("payment") val payment : Payment,
	@SerializedName("bonusCard") val bonusCard : String,
	@SerializedName("totalItemCount") val totalItemCount : Int,
	@SerializedName("items") val itemsInfo : List<ItemsInfo>,
	@SerializedName("services") val services : List<Services>,
	@SerializedName("amount") val amount : Amount,
	@SerializedName("status") val status : Status,
	@SerializedName("pickupAddress") val pickupAddress : PickupAddress,
	@SerializedName("shop") val shop : Shop,
	@SerializedName("deliveryTime") val deliveryTime : DeliveryTime
)