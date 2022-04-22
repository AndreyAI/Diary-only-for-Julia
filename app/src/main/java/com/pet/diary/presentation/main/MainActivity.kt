package com.pet.diary.presentation.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationBarView
import com.pet.diary.R
import com.pet.diary.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private lateinit var navHostFragment: NavHostFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        bottomNavigationInit()

    }

    private fun bottomNavigationInit() {
        with(binding) {
            bottomNavigationView.background = null// why work only dynamically? if xml not working
            bottomNavigationView.labelVisibilityMode = NavigationBarView.LABEL_VISIBILITY_SELECTED
            bottomNavigationView.selectedItemId = R.id.calendar
            fab.setOnClickListener {
                bottomNavigationView.selectedItemId =
                    R.id.calendar  // init bottom, delete freeze
                navController.navigate(R.id.calendarFragment)
            }
        }

        navHostFragment = binding.fragment.getFragment()
        navController = navHostFragment.navController
        binding.bottomNavigationView.setupWithNavController(navController)
        navController.addOnDestinationChangedListener { _, destination, _ ->
            binding.bottomNavigation.isVisible = destination.id != R.id.taskAddFragment
        }
    }
}