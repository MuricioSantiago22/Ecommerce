package com.example.e_commerce.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.e_commerce.databinding.ActivityMainBinding
import java.util.*
import kotlin.collections.HashMap


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.fragmentContainerView
    }
}


