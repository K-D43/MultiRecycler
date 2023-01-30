package com.example.multirecycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.multirecycler.Database.TYPE_HEADER
import com.example.multirecycler.Database.TYPE_ITEM
import com.example.multirecycler.databinding.HeaderDesignBinding
import com.example.multirecycler.databinding.ItemDesignBinding

class Adapter:RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class ItemViewHolder(val binding: ItemDesignBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(item: DataItem.Item){
            binding.item=item
        }
    }
    class HeaderViewHolder(val binding: HeaderDesignBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(header: DataItem.Header){
            binding.header=header.text
        }
    }

    private val itemList= arrayListOf<Any>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType){
            TYPE_ITEM-> ItemViewHolder(ItemDesignBinding.inflate(LayoutInflater.from(parent.context),parent,false))
            TYPE_HEADER-> HeaderViewHolder(HeaderDesignBinding.inflate(LayoutInflater.from(parent.context),parent,false))
            else -> throw IllegalArgumentException("Invalid ViewHolder")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is ItemViewHolder -> holder.bind(itemList[position] as DataItem.Item)
            is HeaderViewHolder -> holder.bind(itemList[position] as DataItem.Header)
            else -> throw IllegalArgumentException("Invalid Holder")
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun getItemViewType(position: Int): Int {
        return when(itemList[position]){
            is DataItem.Item -> TYPE_ITEM
            is DataItem.Header -> TYPE_HEADER
            else -> throw IllegalArgumentException("Invalid Item")
        }
    }
    fun updateList(updatedList: List<Any>){
        itemList.clear()
        itemList.addAll(updatedList)
        notifyDataSetChanged()
    }
}