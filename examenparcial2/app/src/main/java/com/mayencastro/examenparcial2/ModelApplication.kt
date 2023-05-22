package com.mayencastro.examenparcial2

import android.app.Application
import com.mayencastro.examenparcial2.data.model
import com.mayencastro.examenparcial2.repositories.ModelRepository

class ModelApplication: Application() {
    val modelRepository: ModelRepository by lazy{
        ModelRepository(model)
    }
}