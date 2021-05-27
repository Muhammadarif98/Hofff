package com.example.hofff.main.mvp.model.mapper.models


import com.example.hofff.main.mvp.model.data.Delivery
import com.example.hofff.main.mvp.model.data.Status


data class ItemNet(
    val datetime: Long,
    val delivery: Delivery,
    val status: Status,
    val id: String,
    val number: String,
    val phone: String,
    val sum: Int
)