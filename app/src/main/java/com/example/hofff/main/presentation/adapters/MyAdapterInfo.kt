package com.example.hofff.main.presentation.adapters

import com.example.hofff.main.domain.model.ItemsInfo
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.hofff.R
import com.example.hofff.databinding.OrderItemListBinding
import java.util.*

class MyAdapterInfo : RecyclerView.Adapter<MyAdapterInfo.MyHolderInfo>() {
    inner class MyHolderInfo(private val binding: OrderItemListBinding ):
        RecyclerView.ViewHolder(binding.root){

        fun bind(model: ItemsInfo) {
            with(binding) {
                nameTv.text = model.name
                articulTv.text = model.articul.toString()
                quantityTv.text = quantityTv.context.getString(R.string.shtuk, model.quantity.toString())
                orderIv.load(model.imageUrl)
                priceInfoTv.text = priceInfoTv.context.getString(R.string.ruble, model.price.toString())
            }
        }
    }

    var models: MutableList<ItemsInfo> = ArrayList()

    fun addItems(models: List<ItemsInfo>) {
        this.models.addAll(models)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)=
        MyHolderInfo(OrderItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: MyHolderInfo, position: Int) {
        holder.bind(models[position])
    }

    override fun getItemCount(): Int {
        return models.size
    }
}
