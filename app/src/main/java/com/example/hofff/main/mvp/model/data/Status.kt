package com.example.hofff.main.mvp.model.data

import com.google.gson.annotations.SerializedName



data class Status (

	@SerializedName("id") val id : Int,
	@SerializedName("name") val name : String
)