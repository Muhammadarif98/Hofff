package com.example.hofff.main.data.mapper

import com.example.hofff.main.data.models.ItemsNet
import com.example.hofff.main.domain.model.Items
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