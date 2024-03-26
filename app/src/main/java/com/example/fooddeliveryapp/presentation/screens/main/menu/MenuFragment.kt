package com.example.fooddeliveryapp.presentation.screens.main.menu

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.fooddeliveryapp.R
import com.example.fooddeliveryapp.databinding.FragmentMenuBinding
import com.example.fooddeliveryapp.domain.BindingException
import com.example.fooddeliveryapp.presentation.screens.main.menu.adapter.MenuAdapter

class MenuFragment : Fragment() {

    private var _binding: FragmentMenuBinding? = null
    private val binding: FragmentMenuBinding
        get() = _binding ?: throw BindingException("FragmentMenuBinding == null")

    private val viewModel by lazy {
        ViewModelProvider(this)[MenuViewModel::class.java]
    }

    private lateinit var menuAdapter: MenuAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMenuBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView()
        updateState()
        launchFoodCategoryFragment()
    }

    private fun initRecyclerView() {
        menuAdapter = MenuAdapter()
        binding.rcViewFoodCategory.adapter = menuAdapter
        binding.rcViewFoodCategory.layoutManager = GridLayoutManager(requireContext(), 2)
    }

    private fun updateState() {
        viewModel.categories.observe(viewLifecycleOwner) {
            binding.progressBar.visibility = View.GONE
            if (it.loading) {
                binding.progressBar.visibility = View.VISIBLE
            }
            if (it.error.isError) {
                Toast.makeText(requireContext(), it.error.errorMessage, Toast.LENGTH_SHORT). apply {
                    setGravity(Gravity.CENTER, 0, 0)
                }.show()
            }
            menuAdapter.submitList(it.result)
        }
    }

    private fun launchFoodCategoryFragment() {
        menuAdapter.itemFoodCategoryClickListener = {
            findNavController().navigate(MenuFragmentDirections.actionMenuFragmentToFoodCategoryFragment(it))
        }
    }

    override fun onCreateAnimation(transit: Int, enter: Boolean, nextAnim: Int): Animation? {
        return if (enter) {
            AnimationUtils.loadAnimation(context, R.anim.slide_in_left)
        } else {
            AnimationUtils.loadAnimation(context, R.anim.slide_out_right)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}