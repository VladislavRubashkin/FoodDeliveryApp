package com.example.fooddeliveryapp.presentation.screens.main.menu.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.fooddeliveryapp.R
import com.example.fooddeliveryapp.databinding.ItemFoodCategoryBinding
import com.example.fooddeliveryapp.domain.models.FoodCategory

class MenuAdapter : ListAdapter<FoodCategory, FoodCategoryViewHolder>(FoodCategoryDiffUtilCallback()) {

    var itemFoodCategoryClickListener: ((Int) -> Unit)? = null

    private val imagePlaceholderList = mutableListOf(
        R.drawable.placeholder_pizza1,
        R.drawable.placeholder_pizza2,
        R.drawable.placeholder_pizza3,
        R.drawable.placeholder_pizza1,
        R.drawable.placeholder_pizza2,
        R.drawable.placeholder_pizza3,
        R.drawable.placeholder_pizza1,
        R.drawable.placeholder_pizza2,
        R.drawable.placeholder_pizza3,
        R.drawable.placeholder_pizza1,
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodCategoryViewHolder {
        val binding = ItemFoodCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FoodCategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FoodCategoryViewHolder, position: Int) {
        val itemFoodCategory = getItem(position)
        val binding = holder.binding
        with(binding) {
            binding.progressBar.visibility = View.VISIBLE
            root.setOnClickListener {
                itemFoodCategoryClickListener?.invoke(itemFoodCategory.id)
            }
            tvCategoryTitle.text = itemFoodCategory.title

//            Picasso.get().load("https:" + itemFoodCategory.imageUrl).into(ivCategory)
            ivCategory.setImageResource(imagePlaceholderList[itemFoodCategory.id])

            binding.progressBar.visibility = View.GONE
        }

    }
}