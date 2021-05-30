package com.example.hofff.main.mvp.view.adapters

import com.example.hofff.main.mvp.model.data.Services

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.hofff.R


class MyHolderServices(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var mDelivery: ImageView = itemView.findViewById(R.id.us)
    var mDeliveryT: TextView = itemView.findViewById(R.id.uslu)
    var mPrice: TextView = itemView.findViewById(R.id.price_info_tv)


    fun bind(model: Services) {
        mDeliveryT.text = model.name
        mDelivery.load(model.icon)
        mPrice.text = mPrice.context.getString(R.string.ruble, model.price.toString())

    }


}