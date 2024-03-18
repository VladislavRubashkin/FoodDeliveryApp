package com.example.fooddeliveryapp.presentation.screens.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.fooddeliveryapp.databinding.FragmentFoodItemBinding

class FoodItemFragment : Fragment() {

    private var _binding: FragmentFoodItemBinding? = null
    private val binding: FragmentFoodItemBinding
        get() = _binding ?: throw RuntimeException()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFoodItemBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        backToCategory()
    }

    private fun backToCategory() {
        binding.ibBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }

}