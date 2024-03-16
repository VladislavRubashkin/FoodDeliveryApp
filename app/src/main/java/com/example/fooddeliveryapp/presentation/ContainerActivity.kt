package com.example.fooddeliveryapp.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.fooddeliveryapp.R
import com.example.fooddeliveryapp.databinding.ActivityContainerBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

/**
 * TODO !!!!!ПРИ СОЗДАНИИ НОВОЙ ВЕТКИ В Git, ПЕРЕКЛЮЧАТЬСЯ ОБРАТНО В Master И ДЕЛАТЬ New Branch ОТ НЕЁ!!!!!
 */

class ContainerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityContainerBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContainerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupNavigationMenu()
    }

    private fun setupNavigationMenu() {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.tabs_container) as NavHostFragment
        navController = navHostFragment.navController
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation_view)
        NavigationUI.setupWithNavController(bottomNavigationView, navController)
    }
}