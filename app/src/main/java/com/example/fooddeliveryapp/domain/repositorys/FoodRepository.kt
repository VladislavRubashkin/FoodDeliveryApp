package com.example.fooddeliveryapp.domain.repositorys

import androidx.lifecycle.LiveData
import com.example.fooddeliveryapp.domain.models.FoodCategory

interface FoodRepository {

     suspend fun loadCategories(): List<FoodCategory>
}