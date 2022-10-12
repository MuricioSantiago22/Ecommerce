package com.example.e_commerce.ui.productsList.view
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.e_commerce.R
import com.example.e_commerce.core.Resource
import com.example.e_commerce.data.model.Product
import com.example.e_commerce.data.repository.ProductsListRepository
import com.example.e_commerce.databinding.FragmentProductsListBinding
import com.example.e_commerce.databinding.ItemProductListBinding
import com.example.e_commerce.ui.productsDetail.ProductsListDetailsFragmentDirections
import com.example.e_commerce.ui.productsList.adapter.ProductListAdapter
import com.example.e_commerce.ui.productsList.viewModel.ProductsListViewModel
import com.example.e_commerce.ui.productsList.viewModel.ProductsListViewModelFactory


class ProductsListFragment : Fragment(R.layout.fragment_products_list),ProductListAdapter.OnProductListClickListener {

    private lateinit var binding: FragmentProductsListBinding
    private lateinit var  adapter: ProductListAdapter


    private val viewModel by viewModels<ProductsListViewModel> {
        ProductsListViewModelFactory(ProductsListRepository(

        ))}




    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentProductsListBinding.bind(view)



        viewModel.fetchProductsList().observe(viewLifecycleOwner, Observer { result ->
            when(result){
                is Resource.Loading ->{
                    binding.progressBar.visibility = View.VISIBLE
                }
                is Resource.Success ->{
                    binding.progressBar.visibility = View.GONE
                    val products = result.data.response
                    Log.d("LiveData", "${result.data}")
                    initRecyclerView(products)
                }
                is Resource.Failure ->{
                    binding.progressBar.visibility = View.GONE

                    Log.d("Error", "${result.exception}")
                }
            }
        })


    }
    private fun initRecyclerView(list: List<Product>?) {
        list?.let {_list ->
            adapter = ProductListAdapter(listProduct = _list, itemClickListener = this )
            binding.rvProductsList.layoutManager= LinearLayoutManager(context)
            binding.rvProductsList.adapter = adapter
        }
    }

    override fun onProductListClick(product: Product) {
        val action = ProductsListFragmentDirections.actionProductsListFragmentToProductsListDetailsFragment(
            product.price,
            product.title,
            product.discount,
            product.imageUrl,
            product.description
        )
        findNavController().navigate(action)
    }
}
