package com.example.hofff.main.data.models

import com.example.hofff.main.domain.model.Delivery
import com.example.hofff.main.domain.model.Status

data class ItemNet(
    val datetime: Long,
    val delivery: Delivery,
    val status: Status,
    val id: String,
    val number: String,
    val phone: String,
    val sum: Int
)