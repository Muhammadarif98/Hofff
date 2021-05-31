package com.example.hofff.main.domain.model

import com.google.gson.annotations.SerializedName

data class Base (
	@SerializedName("items") val items : List<Items>
)