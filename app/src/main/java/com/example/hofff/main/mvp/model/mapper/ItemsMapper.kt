package com.example.hofff.main.mvp.model.mapper

import com.example.hofff.main.mvp.model.mapper.models.ItemsNet

import com.example.hofff.main.mvp.model.data.Items
import java.util.*
import javax.inject.Inject

class ItemsMapper @Inject constructor() {

    fun map(item: ItemsNet) =
        item.items.map {
            it.run {
                Items(
                    date = Date(datetime * 1000L),
                    delivery = delivery,
                    status = status,
                    id = id,
                    number = number,
                    phone = phone,
                    sum = sum
                )
            }
        }
}