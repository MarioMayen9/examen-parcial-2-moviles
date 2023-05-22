package com.mayencastro.examenparcial2.ui.modelexam.displayer.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mayencastro.examenparcial2.data.model.Model
import com.mayencastro.examenparcial2.databinding.ModelItemBinding

class ModelRecyclerViewAdapter (
    private val clickListener: (Model) -> Unit,
    private val deleteListener: (Model) -> Unit

    ) : RecyclerView.Adapter<ModelRecyclerViewHolder>() {
    private val model = ArrayList<Model>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModelRecyclerViewHolder {
        val binding = ModelItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ModelRecyclerViewHolder(binding)

    }

    override fun getItemCount(): Int {
        return model.size
    }

    override fun onBindViewHolder(holder: ModelRecyclerViewHolder, position: Int) {
        val model = model[position]
        holder.bind(model,clickListener,deleteListener)



    }
    fun deleteModel(position: Int) {
        if (position < model.size) {
            val deletedModel = model.removeAt(position)
            notifyItemRemoved(position)
            deleteListener(deletedModel)
        }
    }

    fun setData(modelList: List<Model>){
        model.clear()
        model.addAll(modelList)
    }



}
