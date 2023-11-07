package com.example.fruitbox

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fruitbox.databinding.ItemFruitBinding

typealias OnClickFruit = (Fruit) -> Unit

class FruitAdapter(private val listFruit : List<Fruit>,
                   private val onClickFruit: OnClickFruit):
    RecyclerView.Adapter<FruitAdapter.ItemFruitViewHolder>() {

    inner class ItemFruitViewHolder(val binding: ItemFruitBinding):
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Fruit) {
            with(binding){
                nameTxt.text = data.name
                priceTxt.text = data.price
                imgIcon.setImageResource(data.image)

                itemView.setOnClickListener(){
                    onClickFruit(data)
                }
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemFruitViewHolder {
        val binding = ItemFruitBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return ItemFruitViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemFruitViewHolder, position: Int) {
        val fruit = listFruit[position]
        holder.bind(fruit)
        holder.binding.imgIcon.setImageResource(fruit.image)

        holder.itemView.setOnClickListener(){
            onClickFruit(fruit)
        }
    }

    override fun getItemCount(): Int {
        return listFruit.size
    }


}
