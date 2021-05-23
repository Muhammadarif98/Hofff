package com.example.hofff.view.adapters

import BaseInfo
import Items
import ItemsInfo
import android.annotation.SuppressLint
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.hofff.R
import java.text.SimpleDateFormat
import java.util.*

class MyHolderInfo (itemView: View) : RecyclerView.ViewHolder(itemView){

    var mDelivery: ImageView
    var mDeliveryT: TextView
    var mStatus: TextView
    var mPrice: TextView
    var mData: TextView




    init {
        mDelivery = itemView.findViewById(R.id.order_iv)
        mDeliveryT = itemView.findViewById(R.id.name_tv)
        mStatus = itemView.findViewById(R.id.articul_tv)
        mPrice = itemView.findViewById(R.id.price_info_tv)
        mData = itemView.findViewById(R.id.quantity_tv)

    }

    fun bind(model: ItemsInfo){
        mDeliveryT.text = model.name
        mStatus.text = model.articul.toString()
        mData.text = mData.context.getString(R.string.shtuk,model.quantity.toString())
        mDelivery.load(model.imageUrl)
        mPrice.text = mPrice.context.getString(R.string.ruble, model.price.toString())
    }






}