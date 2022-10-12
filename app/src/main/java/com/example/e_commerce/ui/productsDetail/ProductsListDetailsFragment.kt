package com.example.e_commerce.ui.productsDetail
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.e_commerce.R
import com.example.e_commerce.databinding.FragmentProductsListDetailsBinding


class ProductsListDetailsFragment : Fragment(R.layout.fragment_products_list_details){

    private lateinit var binding:FragmentProductsListDetailsBinding
    private val args by navArgs<ProductsListDetailsFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentProductsListDetailsBinding.bind(view)
        Glide.with(requireContext()).load("${args.imageUrl}").centerCrop().into(binding.appBarImage)
        binding.txtDescription.text = args.description
        binding.priceTxt.text = "$${args.price}"
        binding.txtTitle.text = args.title
        binding.discountTxt.text = "-$${args.discount}"




    }
}
