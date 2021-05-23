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

    var mAdress: TextView
    lateinit var mBonusCard: TextView
    lateinit var mBonus: TextView
    lateinit var mDiscount: TextView
    lateinit var mTotal: TextView
    lateinit var mTotalCount: TextView
    lateinit var mPayment: TextView


    init {
        mDelivery = itemView.findViewById(R.id.order_iv)
        mDeliveryT = itemView.findViewById(R.id.name_tv)
        mStatus = itemView.findViewById(R.id.articul_tv)
        mPrice = itemView.findViewById(R.id.price_info_tv)
        mData = itemView.findViewById(R.id.quantity_tv)
        mTotalCount = itemView.findViewById(R.id.items_count_tv)
        mPayment = itemView.findViewById(R.id.payment_tv)
        mAdress = itemView.findViewById(R.id.address_tv)
        mBonusCard = itemView.findViewById(R.id.bonus_card_tv)
        mBonus = itemView.findViewById(R.id.bonuses_tv)
        mDiscount = itemView.findViewById(R.id.discount_tv)
        mTotal = itemView.findViewById(R.id.total_sum_tv)
    }

    fun bind(model: ItemsInfo){
        mDeliveryT.text = model.name
        mStatus.text = model.articul.toString()
        mData.text = mData.context.getString(R.string.shtuk,model.quantity.toString())
        mDelivery.load(model.imageUrl)
        mPrice.text = mPrice.context.getString(R.string.ruble, model.price.toString())
    }

    fun bindInfo(base:BaseInfo){
        mPayment.text = base.payment.payment
        mAdress.text = base.address
        mBonusCard.text = base.bonusCard
        mBonus.text = base.amount.bonuses.toString()
        mDiscount.text = base.amount.discount.toString()
        mTotal.text = base.amount.total.toString()
        mTotalCount.text = mTotalCount.context.getString(R.string.total,base.totalItemCount.toString())
    }




}