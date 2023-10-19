package com.example.zstore.product

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.zstore.MainViewModel
import com.example.zstore.R
import java.text.NumberFormat
import java.util.Locale

class ProductViewHolder(
    itemView: View,
    private val mainViewModel: MainViewModel
): RecyclerView.ViewHolder(itemView) {
    fun bind(product: Product) {
        val productName = itemView.findViewById<TextView>(R.id.item_product_name)
        val productPrice = itemView.findViewById<TextView>(R.id.item_product_price)

        productName.text = product.name
        productPrice.text = mainViewModel.convertRupiah(product.price)
    }
}