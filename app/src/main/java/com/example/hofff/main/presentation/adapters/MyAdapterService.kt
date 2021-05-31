package com.example.hofff.main.presentation.adapters

import com.example.hofff.main.domain.model.Services
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.hofff.R
import com.example.hofff.databinding.ServiceItemListBinding
import java.util.*

class MyAdapterService : RecyclerView.Adapter<MyAdapterService.MyHolderServices>() {
    inner class MyHolderServices(private val binding: ServiceItemListBinding):
        RecyclerView.ViewHolder(binding.root){

        fun bind(model: Services) {
            with(binding) {
                uslu.text = model.name
                us.load(model.icon)
                priceInfoTv.text = priceInfoTv.context.getString(R.string.ruble, model.price.toString())
            }
        }
    }

    var models: MutableList<Services> = ArrayList()

    fun addItems(models: List<Services>?) {
        if (models != null) {
            this.models.addAll(models!!)}
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolderServices =
        MyHolderServices(ServiceItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: MyHolderServices, position: Int) {
        holder.bind(models[position])
    }

    override fun getItemCount(): Int {
        return models.size
    }
}
