package com.example.fooddeliveryapp.presentation.screens.main.menu.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.fooddeliveryapp.domain.models.FoodCategory

class FoodCategoryDiffUtilCallback: DiffUtil.ItemCallback<FoodCategory>() {
    override fun areItemsTheSame(oldItem: FoodCategory, newItem: FoodCategory): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: FoodCategory, newItem: FoodCategory): Boolean {
        return oldItem == newItem
    }
}