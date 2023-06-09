package com.mayencastro.examenparcial2.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mayencastro.examenparcial2.R
import com.mayencastro.examenparcial2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}