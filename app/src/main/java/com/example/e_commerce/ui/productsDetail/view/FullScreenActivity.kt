package com.example.e_commerce.ui.productsDetail.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.navArgs
import com.bumptech.glide.Glide
import com.example.e_commerce.databinding.ActivityFullScreenBinding

class FullScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFullScreenBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFullScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val imageUrl = intent.getStringExtra("imageUrl")
        Glide.with(this).load(imageUrl).centerCrop().into(binding.fullScreenImage)
    }
}