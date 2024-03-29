package com.example.hofff.main.domain.model

import java.io.Serializable
import java.util.*

data class Items(
	val date: Date,
	val delivery: Delivery,
	val status: Status,
	val id: String,
	val number: String,
	val phone: String,
	val sum: Int
): Serializable