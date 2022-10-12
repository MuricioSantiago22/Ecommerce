package com.example.e_commerce.ui.productsList.viewModel

import androidx.lifecycle.*
import com.example.e_commerce.core.Resource
import com.example.e_commerce.data.repository.ProductsListRepository
import kotlinx.coroutines.Dispatchers


class ProductsListViewModel(private val repo: ProductsListRepository) : ViewModel() {
    fun fetchProductsList() = liveData(viewModelScope.coroutineContext + Dispatchers.Main) {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(repo.getAllProductsList()))

        } catch (e: Exception) {
            emit(Resource.Failure(e))
        }
    }

}

class ProductsListViewModelFactory(private val repo: ProductsListRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(ProductsListRepository::class.java).newInstance(repo)
    }
}









