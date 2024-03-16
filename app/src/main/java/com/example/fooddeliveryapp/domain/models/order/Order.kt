package com.example.fooddeliveryapp.domain.models.order

import com.example.fooddeliveryapp.domain.models.product.Product

data class Order(
    val id: Int,
    val customerName: String,
    val deliveryAddress: String,
    val details: String,
    val products: List<Product>
)
