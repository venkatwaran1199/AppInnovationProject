package com.example.appinnovationproject.ui.local

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appinnovationproject.databinding.LocalContentBinding
import com.example.appinnovationproject.models.data.Localdata

class LocalAdapter:RecyclerView.Adapter<LocalAdapter.myViewholder>() {

    var datalist = mutableListOf<Localdata>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewholder {
        val binding = LocalContentBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return myViewholder(binding)
    }

    override fun onBindViewHolder(holder: myViewholder, position: Int) {
       val curritem = datalist[position]
        holder.bind(curritem)
    }

    override fun getItemCount(): Int {
        return datalist.size
    }

    class myViewholder(private val binding:LocalContentBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(curritem:Localdata){
            binding.localdata = curritem
            binding.executePendingBindings()
        }
    }

    fun setdata(datalist:List<Localdata>){
        this.datalist = datalist.toMutableList()
        notifyDataSetChanged()
    }
}