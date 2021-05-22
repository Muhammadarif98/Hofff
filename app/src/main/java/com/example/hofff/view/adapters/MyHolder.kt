package com.example.hofff.view.adapters

import Items
import android.annotation.SuppressLint
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.hofff.R
import java.text.SimpleDateFormat
import java.util.*

class MyHolder (itemView: View) : RecyclerView.ViewHolder(itemView){

    var mDelivery: ImageView
    var mDeliveryT: TextView
    var mStatus: TextView
    var mStatusI: ImageView
    var mPrice: TextView
    var mNumber: TextView
    var mData: TextView

    init {
        mDelivery = itemView.findViewById(R.id.delivery_iv)
        mDeliveryT = itemView.findViewById(R.id.delivery_tv)
        mStatus = itemView.findViewById(R.id.status_tv)
        mStatusI = itemView.findViewById(R.id.status_siv)
        mPrice = itemView.findViewById(R.id.price_tv)
        mData = itemView.findViewById(R.id.date_tv)
        mNumber = itemView.findViewById(R.id.number_tv)
    }

    fun bind(model: Items){

        val id = model.id
        mNumber.text = model.number


        val statusId = model.status.id
        mStatus.text = model.status.name


        mDeliveryT.text = model.delivery.name
        mDelivery.load(model.delivery.icon)

        mPrice.text = mPrice.context.getString(R.string.ruble, model.sum.toString())

        @SuppressLint("SimpleDateFormat")
        var df = SimpleDateFormat("'от 'dd-MM-yyyy, HH:mm")
        var date = df.format(model.datetime*1000L)
        mData.text = date

        if (statusId.equals(8)){
            mStatusI.setImageResource(R.color.red)
        }else if(statusId.equals(1) or statusId.equals(2) or statusId.equals(7)){
            mStatusI.setImageResource(R.color.green)
        }else if(statusId.equals(3) or statusId.equals(4) or statusId.equals(5)) {
            mStatusI.setImageResource(R.color.grey)
        }




    }




}