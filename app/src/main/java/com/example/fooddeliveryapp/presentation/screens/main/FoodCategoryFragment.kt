package com.example.fooddeliveryapp.presentation.screens.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.fooddeliveryapp.R
import com.example.fooddeliveryapp.databinding.FragmentFoodCategoryBinding

class FoodCategoryFragment : Fragment() {

    private var _binding: FragmentFoodCategoryBinding? = null
    private val binding: FragmentFoodCategoryBinding
        get() = _binding ?: throw RuntimeException()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFoodCategoryBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //test
        binding.button2.setOnClickListener {
            findNavController().navigate(R.id.action_foodCategoryFragment_to_foodItemFragment)
        }
        backToMenu()
    }

    private fun backToMenu() {
        binding.ibBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}