package com.example.e_commerce.ui.productsDetail.view

import android.content.ContentProvider
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.navigation.navArgs
import com.bumptech.glide.Glide
import com.example.e_commerce.databinding.ActivityFullScreenBinding

class FullScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFullScreenBinding
    private val args by navArgs<FullScreenActivityArgs>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFullScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Glide.with(this).load(args.imageUrl).centerCrop().into(binding.fullScreenImage)
    }
}