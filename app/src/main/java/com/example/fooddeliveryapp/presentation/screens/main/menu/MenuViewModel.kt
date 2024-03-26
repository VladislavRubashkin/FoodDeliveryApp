package com.example.fooddeliveryapp.presentation.screens.main.menu

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fooddeliveryapp.data.repository.FoodRepositoryImpl
import com.example.fooddeliveryapp.domain.models.FoodCategory
import com.example.fooddeliveryapp.domain.usecases.GetCategoryUseCase
import kotlinx.coroutines.launch
import java.io.IOException



class MenuViewModel : ViewModel() {

    private val repo = FoodRepositoryImpl()
    private val getCategoryUseCase =  GetCategoryUseCase(repo)

    private val _categories = MutableLiveData<StateMenuFragment>()
    val categories: LiveData<StateMenuFragment>
        get() = _categories

    init {
        getCategories()
    }

    private fun getCategories() {
        _categories.value = StateMenuFragment(loading = true)
        viewModelScope.launch {
            try {
                _categories.value = StateMenuFragment(result = getCategoryUseCase())
            } catch (e: IOException) {
                if (_categories.value == StateMenuFragment(result = emptyList<FoodCategory>())) {
                    _categories.value = StateMenuFragment(
                        error = ErrorMessage(isError = true, errorMessage = "error message")
                    )
                }
            }


        }
    }

}