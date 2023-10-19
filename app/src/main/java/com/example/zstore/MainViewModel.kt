package com.example.zstore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.zstore.product.Product
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.text.NumberFormat
import java.util.Locale

class MainViewModel: ViewModel() {
    private var index = 1
    private val productList: MutableList<Product> = mutableListOf()

    private val _products = MutableLiveData<List<Product>>()
    val products: LiveData<List<Product>> = _products

    fun createProduct() {
        val product = Product("Product $index", 11499000)
        index++
        productList.add(product)
        fetchData()
    }

    fun fetchData() {
        viewModelScope.launch {
            withContext(Dispatchers.Main) {
                _products.value = this@MainViewModel.productList
            }
        }
    }

    fun convertRupiah(value: Int): String {
        val localId = Locale("in", "ID")
        val formatter = NumberFormat.getCurrencyInstance(localId)
        return formatter.format(value)
    }
}