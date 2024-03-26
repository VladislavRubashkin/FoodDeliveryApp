package com.example.fooddeliveryapp.domain.usecases

import com.example.fooddeliveryapp.domain.repositorys.FoodRepository

class GetCategoryUseCase(private val repository: FoodRepository) {

     suspend operator fun invoke() = repository.loadCategories()
}