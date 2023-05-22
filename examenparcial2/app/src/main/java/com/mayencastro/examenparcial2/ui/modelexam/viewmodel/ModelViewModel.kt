package com.mayencastro.examenparcial2.ui.modelexam.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.mayencastro.examenparcial2.ModelApplication
import com.mayencastro.examenparcial2.data.model.Model
import com.mayencastro.examenparcial2.repositories.ModelRepository

class ModelViewModel(private val repository: ModelRepository) : ViewModel() {

    var name = MutableLiveData("")
    var status = MutableLiveData("")


    fun getModel() = repository.getModel()

    fun addModel(model: Model) = repository.addModel(model)


    fun create(){
        if (!validateData()) {
            status.value = WRONG_INFORMATION
            return
        }

        val model = Model(
            name.value!!,

        )
        addModel(model)
        clearData()

        status.value = M_CREATED
    }

    private fun validateData(): Boolean{
        when{
            name.value.isNullOrEmpty() -> return false

        }
        return true
    }

    fun clearData() {
        name.value = ""

    }

    fun clearStatus() {
        status.value = INACTIVE
    }


    fun setSelectedModel(model:Model){
        name.value= model.name

    }

    companion object {
        val Factory = viewModelFactory {
            initializer {
                val app = this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as ModelApplication
                ModelViewModel(app.modelRepository)
            }
        }
        const val M_CREATED = " created"
        const val WRONG_INFORMATION = "Wrong information"
        const val INACTIVE = ""
    }


}