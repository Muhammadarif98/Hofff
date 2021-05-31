package com.example.hofff.main.domain.model

import com.google.gson.annotations.SerializedName

data class Services (
	@SerializedName("icon") val icon : String,
	@SerializedName("name") val name : String,
	@SerializedName("price") val price : Int
)