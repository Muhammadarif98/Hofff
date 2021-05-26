package com.example.hofff.main.mvp.model.data

import com.google.gson.annotations.SerializedName



data class StatusInfo (

	@SerializedName("id") val id : Int,
	@SerializedName("name") val name : String
)