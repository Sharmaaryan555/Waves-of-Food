package com.example.wavesoffood.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBindings
import com.example.wavesoffood.databinding.BuyAgainItemBinding

class BuyAgainAdapter(private val buyAgainFoodName: ArrayList<String>, private val buyAgainFoodPrice:ArrayList<String>,private val buyAgainFoodImage :ArrayList<Int>):
    RecyclerView.Adapter<BuyAgainAdapter.BuyAgainViewHolder>() {

    override fun onBindViewHolder(holder: BuyAgainViewHolder, position: Int) {
            holder.bind(buyAgainFoodName[position],buyAgainFoodPrice[position],buyAgainFoodImage[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BuyAgainViewHolder {
    val bindings = BuyAgainItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return BuyAgainViewHolder(bindings)
    }

    override fun getItemCount(): Int = buyAgainFoodName.size


    class BuyAgainViewHolder(private val bindings: BuyAgainItemBinding):RecyclerView.ViewHolder(bindings.root) {
        fun bind(foodName: String, foodPrice: String, foodImage: Int) {
            bindings.buyAgainFoodName.text = foodName
            bindings.buyAgainFoodPrice.text = foodPrice
            bindings.buyAgianFoodImage.setImageResource(foodImage)
        }
    }

}