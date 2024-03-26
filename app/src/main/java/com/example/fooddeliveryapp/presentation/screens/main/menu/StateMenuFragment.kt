package com.example.fooddeliveryapp.presentation.screens.main.menu

import com.example.fooddeliveryapp.domain.models.FoodCategory

data class StateMenuFragment(
    val result: List<FoodCategory> = emptyList(),
    val loading: Boolean = false,
    val error: ErrorMessage = ErrorMessage()
)
data class ErrorMessage(
    val isError: Boolean = false,
    val errorMessage: String = ""
)
//class Result(val result: List<FoodCategory> = emptyList()) : StateMenuFragment()
//data object Loading : StateMenuFragment()
//data object Error : StateMenuFragment()


