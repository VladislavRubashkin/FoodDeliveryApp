package com.example.fooddeliveryapp.domain.models

data class Product(
    val id: Int,
    val name: String,
    val description: String,
    val imageUrl: String,
    val price: Int
)
