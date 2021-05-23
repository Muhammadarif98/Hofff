package com.example.hofff.view.adapters

import Services

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.hofff.R


class MyHolderServices (itemView: View) : RecyclerView.ViewHolder(itemView){

    var mDelivery: ImageView
    var mDeliveryT: TextView
    var mPrice: TextView


    init {
        mDelivery = itemView.findViewById(R.id.us)
        mDeliveryT = itemView.findViewById(R.id.uslu)
        mPrice = itemView.findViewById(R.id.price_info_tv)

    }

    fun bind(model: Services){

        mDeliveryT.text = model.name
        mDelivery.load(model.icon)
        mPrice.text = mPrice.context.getString(R.string.ruble, model.price.toString())

    }




}