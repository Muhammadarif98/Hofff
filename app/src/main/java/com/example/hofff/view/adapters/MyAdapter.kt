package com.example.hofff.view.adapters

import Items

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hofff.R
import java.util.*

class MyAdapter : RecyclerView.Adapter<MyHolder>() {
    var models: MutableList<Items> = ArrayList()
    private val isLoadingAdded = false

    fun addItems(models: List<Items>?) {
        this.models.addAll(models!!)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, null)
        return MyHolder(view)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.bind(models[position])
    }

    override fun getItemCount(): Int {
        return models.size
    }

}
