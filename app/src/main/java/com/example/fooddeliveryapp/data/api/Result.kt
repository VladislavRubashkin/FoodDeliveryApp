package com.example.fooddeliveryapp.data.api

import com.example.fooddeliveryapp.domain.models.FoodCategory
import com.example.fooddeliveryapp.domain.models.Product

data class Result (
    val categories: List<FoodCategory>
)