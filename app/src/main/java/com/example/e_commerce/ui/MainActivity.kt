package com.example.e_commerce.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.e_commerce.databinding.ActivityMainBinding
import com.example.e_commerce.ui.productsList.viewModel.ProductsListViewModel


class MainActivity : AppCompatActivity() {



    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.fragmentContainerView

    }
}

