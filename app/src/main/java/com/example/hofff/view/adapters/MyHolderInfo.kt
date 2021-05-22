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
    lateinit var mPayment: TextView

    init {
        mDelivery = itemView.findViewById(R.id.order_iv)
        mDeliveryT = itemView.findViewById(R.id.name_tv)
//        mPayment = itemView.findViewById(R.id.payment_tv)
        mStatus = itemView.findViewById(R.id.articul_tv)
        mPrice = itemView.findViewById(R.id.price_info_tv)
        mData = itemView.findViewById(R.id.quantity_tv)
    }

    fun bind(model: ItemsInfo){

//        val id = model.id
//        mNumber.text = model.number
//
//
//        val statusId = model.status.id
//        mStatus.text = model.status.name
//
//
        mDeliveryT.text = model.name

        mStatus.text = model.articul.toString()
        mData.text = model.quantity.toString()
        mDelivery.load(model.imageUrl)
//
        mPrice.text = mPrice.context.getString(R.string.ruble, model.price.toString())

//        @SuppressLint("SimpleDateFormat")
//        var df = SimpleDateFormat("'от 'dd-MM-yyyy, HH:mm")
//        var date = df.format(model.datetime*1000L)
//        mData.text = date

//        if (statusId.equals(8)){
//            mStatusI.setImageResource(R.color.red)
//        }else if(statusId.equals(1) or statusId.equals(2) or statusId.equals(7)){
//            mStatusI.setImageResource(R.color.green)
//        }else if(statusId.equals(3) or statusId.equals(4) or statusId.equals(5)) {
//            mStatusI.setImageResource(R.color.grey)
//        }




    }




}