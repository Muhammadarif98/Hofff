package com.example.hofff.main.mvp.view.adapters

import com.example.hofff.main.mvp.model.data.ItemsInfo
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.hofff.R
import com.example.hofff.main.mvp.model.data.BaseInfo

class MyHolderInfo(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var mDelivery: ImageView = itemView.findViewById(R.id.order_iv)
    var mDeliveryT: TextView = itemView.findViewById(R.id.name_tv)
    var mStatus: TextView = itemView.findViewById(R.id.articul_tv)
    var mPrice: TextView = itemView.findViewById(R.id.price_info_tv)
    var mData: TextView = itemView.findViewById(R.id.quantity_tv)


    fun bind(model: ItemsInfo) {
        mDeliveryT.text = model.name
        mStatus.text = model.articul.toString()
        mData.text = mData.context.getString(R.string.shtuk, model.quantity.toString())
        mDelivery.load(model.imageUrl)
        mPrice.text = mPrice.context.getString(R.string.ruble, model.price.toString())


    }


}