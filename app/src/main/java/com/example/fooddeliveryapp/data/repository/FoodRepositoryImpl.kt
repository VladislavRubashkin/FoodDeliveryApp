package com.example.fooddeliveryapp.data.repository

import com.example.fooddeliveryapp.data.api.ApiFactory
import com.example.fooddeliveryapp.domain.models.FoodCategory
import com.example.fooddeliveryapp.domain.repositorys.FoodRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async

class FoodRepositoryImpl : FoodRepository {

    private val apiService = ApiFactory.apiService

    private val scope = CoroutineScope(Dispatchers.Main)
    override suspend fun loadCategories(): List<FoodCategory> {
        val job = scope.async {
            val result = apiService.getCategories()

            result.categories
        }
        return job.await()
    }


}