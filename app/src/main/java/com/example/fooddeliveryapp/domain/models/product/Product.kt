package com.example.fooddeliveryapp.domain.models.product

data class Product(
    val id: Int,
    val name: String,
    val avatar: String,
    val description: String,
    val price: Int
)
