package com.pet.diary.presentation.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.material.navigation.NavigationBarView
import com.pet.diary.R
import com.pet.diary.databinding.FragmentMainBinding


class MainFragment : Fragment(R.layout.fragment_main) {

    private val binding by viewBinding(FragmentMainBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.bottomNavigationView.background = null // why work only dynamically? if xml not working
        binding.fab.setOnClickListener {
            binding.bottomNavigationView.labelVisibilityMode = NavigationBarView.LABEL_VISIBILITY_UNLABELED
        }


        binding.bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            binding.bottomNavigationView.labelVisibilityMode = NavigationBarView.LABEL_VISIBILITY_UNLABELED
            binding.bottomNavigationView.labelVisibilityMode = NavigationBarView.LABEL_VISIBILITY_SELECTED
            when (item.itemId) {
                R.id.checkList -> {
                    // Respond to navigation item 1 click
                    true
                }
                R.id.shoppingList -> {
                    // Respond to navigation item 2 click
                    true
                }
                R.id.habitsTracker -> {
                    // Respond to navigation item 1 click
                    true
                }
                R.id.notes -> {
                    // Respond to navigation item 2 click
                    true
                }
                else -> false

            }
        }
    }


}