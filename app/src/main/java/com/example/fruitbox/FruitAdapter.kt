package com.example.fruitbox

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fruitbox.databinding.ItemFruitBinding

typealias OnClickFruit = (Fruit) -> Unit

class FruitAdapter(private val listFruit : List<Fruit>,
    private val onClickFruit: OnClickFruit):
    RecyclerView.Adapter<FruitAdapter.ItemFruitViewHolder>() {

        inner class ItemFruitViewHolder(private val binding: ItemFruitBinding):
            RecyclerView.ViewHolder(binding.root) {
                fun bind(data: Fruit) {
                    with(binding){
                        nameTxt.text = data.name
                        weightTxt.text = data.weight
                        imgIcon.setImageResource(data.gambar)

                        itemView.setOnClickListener(){
                            onClickFruit(data)
                        }
                    }
                }
        }

    fun updateData(newFruitList: List<Fruit>) {
        var fruitList = newFruitList
        notifyDataSetChanged() // Memperbarui tampilan RecyclerView setelah data berubah
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemFruitViewHolder {
        val binding = ItemFruitBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return ItemFruitViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemFruitViewHolder, position: Int) {
        holder.bind(listFruit[position])
    }

    override fun getItemCount(): Int {
        return listFruit.size
    }


    }
