package com.example.hofff.view.adapters

import BaseInfo
import Items
import ItemsInfo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hofff.R
import java.util.*

class MyAdapterInfo : RecyclerView.Adapter<MyHolderInfo>() {
    var models: MutableList<ItemsInfo> = ArrayList()
    private val isLoadingAdded = false

    fun addItems(models: List<ItemsInfo>?) {
        this.models.addAll(models!!)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolderInfo {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.order_item_list, null)
        return MyHolderInfo(view)
    }

    override fun onBindViewHolder(holder: MyHolderInfo, position: Int) {
        holder.bind(models[position])
    }

    override fun getItemCount(): Int {
        return models.size
    }

}