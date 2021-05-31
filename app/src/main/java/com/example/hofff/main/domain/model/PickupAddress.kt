package com.example.hofff.main.domain.model

import com.google.gson.annotations.SerializedName

data class PickupAddress (
	@SerializedName("pickupAddress") val pickupAddress : String,
	@SerializedName("pickupId") val pickupId : String
)