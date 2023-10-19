package com.example.zstore.product

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.zstore.MainViewModel
import com.example.zstore.R

class ProductAdapter(
    private val mainViewModel: MainViewModel
): ListAdapter<Product, ProductViewHolder>(
    ProductDiffUtil()
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        return ProductViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_product,
                parent,
                false),
            mainViewModel = mainViewModel
        )
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}