package com.example.zstore.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.zstore.MainViewModel
import com.example.zstore.databinding.FragmentHomeBinding
import com.example.zstore.product.ProductAdapter

class HomeFragment: Fragment() {
    private lateinit var binding: FragmentHomeBinding

    private val mainViewModel: MainViewModel by viewModels()
    private var productAdapter: ProductAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        productAdapter = ProductAdapter(mainViewModel)

        binding.recylerProduct.adapter = productAdapter
        binding.recylerProduct.layoutManager = GridLayoutManager(view.context, 2)

        binding.homeBtnCreateProduct.setOnClickListener { mainViewModel.createProduct() }

        observeProducts()

        mainViewModel?.fetchData()
    }

    private fun observeProducts() {
        mainViewModel.products.observe(viewLifecycleOwner) { products ->
            productAdapter?.submitList(products)
            productAdapter?.notifyDataSetChanged()
        }
    }
}