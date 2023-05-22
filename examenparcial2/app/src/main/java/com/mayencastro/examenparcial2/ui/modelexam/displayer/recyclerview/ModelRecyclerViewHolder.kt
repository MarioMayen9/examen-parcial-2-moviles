package com.mayencastro.examenparcial2.ui.modelexam.displayer.recyclerview

import androidx.recyclerview.widget.RecyclerView
import com.mayencastro.examenparcial2.data.model.Model
import com.mayencastro.examenparcial2.databinding.ModelItemBinding

class ModelRecyclerViewHolder(private val binding: ModelItemBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(model: Model, clickListener: (Model) -> Unit){
        binding.titleTextView.text = model.name


        binding.modelCard.setOnClickListener{
            clickListener(model)
        }
    }

}