package com.mayencastro.examenparcial2.repositories
import com.mayencastro.examenparcial2.data.model.Model

class ModelRepository (private val models: MutableList<Model>) {
    fun getModel() = models
    fun addModel(model : Model) = models.add(model)
    fun deleteModel(model: Model) = models.remove(model)


}