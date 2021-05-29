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


                when {
                    statusId == 8 -> {
                        statusSiv.setImageResource(R.color.red)
                    }
                    (statusId == 1) or (statusId == 2) or (statusId == 7) -> {
                        statusSiv.setImageResource(R.color.green)
                    }
                    (statusId == 3) or (statusId == 4) or (statusId == 5) -> {
                        statusSiv.setImageResource(R.color.grey)
                    }
                }
        }

        }
    }


    var models: MutableList<Items> = ArrayList()
//    private val models by lazy {
//        arrayListOf<Items>()
//    }
    fun addItems(models:  List<Items>) {
        this.models.apply {
            clear()
            addAll(models)
        }
        notifyDataSetChanged()

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MyHolder(ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.bind(models[position])
    }

    override fun getItemCount():
            Int = models.size

    interface OrderSelectListener {
        fun onOrderSelected(items: Items)
    }
}
