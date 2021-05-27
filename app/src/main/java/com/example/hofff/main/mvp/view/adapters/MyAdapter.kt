package com.example.hofff.main.mvp.view.adapters


import com.example.hofff.main.mvp.model.data.Items
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.hofff.main.mvp.model.data.format
import com.example.hofff.R
import com.example.hofff.databinding.ItemListBinding
import java.util.*

class MyAdapter (private val listener: OrderSelectListener ): RecyclerView.Adapter<MyAdapter.MyHolder>() {

    inner class MyHolder (private val binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root){


        init {
            binding.relet.setOnClickListener {
                val item = models[adapterPosition]
                listener.onOrderSelected(item)
            }
        }

        fun bind(model: Items){
            with(binding){
            val id = model.id
            numberTv.text = model.number
            statusTv.text = model.status.name
            val statusId = model.status.id
            deliveryTv.text = model.delivery.name
            deliveryIv.load(model.delivery.icon)
            priceTv.text = priceTv.context.getString(R.string.ruble, model.sum.toString())
            dateTv.text = model.date.format()


            if (statusId.equals(8)){
                statusSiv.setImageResource(R.color.red)
            }else if(statusId.equals(1) or statusId.equals(2) or statusId.equals(7)){
                statusSiv.setImageResource(R.color.green)
            }else if(statusId.equals(3) or statusId.equals(4) or statusId.equals(5)) {
                statusSiv.setImageResource(R.color.grey)
            }
        }

        }
    }


    var models: MutableList<Items> = ArrayList()

    fun addItems(models:  List<Items>) {
        this.models.addAll(models!!)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MyHolder(ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.bind(models[position])
    }

    override fun getItemCount(): Int {
        return models.size
    }
    interface OrderSelectListener {
        fun onOrderSelected(items: Items)
    }
}
