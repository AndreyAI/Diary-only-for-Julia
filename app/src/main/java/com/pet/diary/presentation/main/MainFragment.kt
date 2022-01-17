package com.pet.diary.presentation.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.material.navigation.NavigationBarView
import com.pet.diary.R
import com.pet.diary.databinding.FragmentMainBinding
import com.pet.diary.presentation.calendar.CalendarFragment


class MainFragment : Fragment(R.layout.fragment_main) {

    private val binding by viewBinding(FragmentMainBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.bottomNavigationView.background =
            null // why work only dynamically? if xml not working

        childFragmentManager.beginTransaction()
            .add(R.id.fragmentContainer, CalendarFragment(), "calendar") // companion object
           // .show(CalendarFragment())
            .commit()



    }

    private fun listenersInit(){
        binding.fab.setOnClickListener {
            binding.bottomNavigationView.selectedItemId = R.id.calendar
        }

        binding.bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            binding.bottomNavigationView.labelVisibilityMode =
                NavigationBarView.LABEL_VISIBILITY_SELECTED
            when (item.itemId) {
                R.id.checkList -> {
                    true
                }
                R.id.shoppingList -> {
                    true
                }
                R.id.habitsTracker -> {
                    true
                }
                R.id.notes -> {
                    true
                }
                else -> false
            }
        }
    }


}