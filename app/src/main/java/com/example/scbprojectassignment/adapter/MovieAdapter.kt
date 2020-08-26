package com.example.scbprojectassignment.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.scbprojectassignment.BR
import com.example.scbprojectassignment.R
import com.example.scbprojectassignment.databinding.ItemRowBinding
import com.example.scbprojectassignment.model.Search


class MovieAdapter(dataModelList:List<Search>, ctx:Context,
                   private val listener: (Search) -> Unit
):RecyclerView.Adapter<MovieAdapter.ViewHolder>() {
    private val dataModelList:List<Search>
    private val context:Context

    init{
        this.dataModelList = dataModelList
        context = ctx
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieAdapter.ViewHolder {
        val binding: ItemRowBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.item_row, parent, false)
        return MovieAdapter.ViewHolder(binding)
    }

    override fun getItemCount(): Int = dataModelList.size

    // Bind data
    override fun onBindViewHolder(holder: MovieAdapter.ViewHolder, position: Int) {
        val item = dataModelList[position]
        holder.bind(dataModelList.get(position))
        holder.itemView.setOnClickListener{
            listener(item)
        }
    }

    // Creating ViewHolder
    class ViewHolder(val binding: ItemRowBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Any) {
            binding.setVariable(BR.model, data) //BR - generated class; BR.user - 'user' is variable name declared in layout
            binding.executePendingBindings()
        }
    }






}