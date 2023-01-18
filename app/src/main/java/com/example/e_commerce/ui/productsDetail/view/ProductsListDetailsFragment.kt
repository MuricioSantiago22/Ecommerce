package com.example.e_commerce.ui.productsDetail.view
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.e_commerce.R
import com.example.e_commerce.core.observe
import com.example.e_commerce.databinding.FragmentProductsListDetailsBinding
import com.example.e_commerce.ui.productsDetail.viewModel.ProductsDetailsViewModel


class ProductsListDetailsFragment : Fragment(R.layout.fragment_products_list_details){

    private lateinit var binding:FragmentProductsListDetailsBinding
    private val args by navArgs<ProductsListDetailsFragmentArgs>()
    private val viewModel : ProductsDetailsViewModel by viewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObservers()
        binding = FragmentProductsListDetailsBinding.bind(view)
        Glide.with(requireContext()).load(args.imageUrl).centerCrop().into(binding.appBarImage)
        binding.txtDescription.text = args.description
        binding.priceTxt.text = "$${args.price}"
        binding.txtTitle.text = args.title
        binding.discountTxt.text = "-$${args.discount}"
        binding.txtAmount.text = "1"
        amount()
        showFullScreen()

    }

    private fun initObservers(){
        observe(viewModel.getItemCounter()) { binding.txtAmount.text = it.toString() }
    }

    private fun amount(){
        binding.btnMas.setOnClickListener {
            viewModel.incrementItemCounter()

        }
        binding.btnMenos.setOnClickListener {
            viewModel.decrementItemCounter()
        }
    }
    private fun showFullScreen(){
        binding.appBarImage.setOnClickListener {
            val action = ProductsListDetailsFragmentDirections.actionProductsListDetailsFragmentToFullScreenActivity(
                args.imageUrl
            )
            findNavController().navigate(action)


        }
    }
}

