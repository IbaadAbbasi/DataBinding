package com.example.databinding

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import androidx.recyclerview.widget.RecyclerView
import com.example.databinding.databinding.ItemsBinding


class dataAdapter(private val data:List<DataModel>): RecyclerView.Adapter<dataAdapter.Data>() {
    lateinit var contex:Context
    inner class Data(val binding: ItemsBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item:DataModel){
            binding.listItem = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): dataAdapter.Data {
        contex = parent.context
       val inflater = LayoutInflater.from(parent.context)
        val items = ItemsBinding.inflate(inflater,parent,false);
        return Data(items)
    }

    override fun onBindViewHolder(holder: dataAdapter.Data, position: Int) {
           holder.bind(data[position])

        holder.binding.textView.setOnClickListener {
           var value = data[position].name
            Toast.makeText(contex, value,Toast.LENGTH_LONG).show()
        }
    }

    override fun getItemCount(): Int {
       return data.size
    }
}