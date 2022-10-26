package com.example.e_commerce.ui.productsDetail.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class ProductsDetailsViewModel : ViewModel() {

    private val itemCounterMLD: MutableLiveData<Int> = MutableLiveData()
    var itemCounter : Int = 1


    fun incrementItemCounter() {
   //     itemCounterMLD.value = itemCounterMLD.value?.plus(1)
        itemCounter = itemCounter + 1
        itemCounterMLD.value = itemCounter

    }

    fun decrementItemCounter(){
    //    itemCounterMLD.value = itemCounterMLD.value?.minus(1)
        if (itemCounter > 1)
        itemCounter = itemCounter - 1
        itemCounterMLD.value = itemCounter

    }

    fun getItemCounter(): LiveData<Int> = itemCounterMLD
}
