package com.example.hofff.main.mvp.model.data


import com.google.gson.annotations.SerializedName



data class Base (

	@SerializedName("items") val items : List<Items>
)