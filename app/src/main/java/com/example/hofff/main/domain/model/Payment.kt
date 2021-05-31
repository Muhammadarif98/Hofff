package com.example.hofff.main.domain.model

import com.google.gson.annotations.SerializedName

data class Payment (
	@SerializedName("name") val payment : String
)