package com.example.hofff.main.domain.model

import com.google.gson.annotations.SerializedName

data class Delivery (
	@SerializedName("name") val name : String,
	@SerializedName("icon") val icon : String
)