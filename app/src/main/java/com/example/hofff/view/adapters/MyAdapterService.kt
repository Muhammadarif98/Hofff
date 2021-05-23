package com.example.hofff.view.adapters

import Base
import Items
import Services

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hofff.R
import java.util.*

class MyAdapterService : RecyclerView.Adapter<MyHolderServices>() {
    var models: MutableList<Services> = ArrayList()
    private val isLoadingAdded = false

    fun addItems(models: List<Services>?) {
        this.models.addAll(models!!)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolderServices {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.service_item_list, null)
        return MyHolderServices(view)
    }

    override fun onBindViewHolder(holder: MyHolderServices, position: Int) {
        holder.bind(models[position])
    }

    override fun getItemCount(): Int {
        return models.size
    }

}
