package com.pet.diary.presentation.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.material.navigation.NavigationBarView
import com.pet.diary.R
import com.pet.diary.databinding.FragmentMainBinding
import com.pet.diary.hideFragment
import com.pet.diary.presentation.calendar.CalendarFragment
import com.pet.diary.presentation.check.CheckerFragment
import com.pet.diary.showFragment

class MainFragment : Fragment(R.layout.fragment_main) {

    private val binding by viewBinding(FragmentMainBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentInit()
        listenersInit()
    }

    private fun listenersInit() {

        binding.fab.setOnClickListener {
            binding.bottomNavigationView.selectedItemId =
                R.id.calendar  // init bottom, delete freeze
            showFragment(CALENDAR)
        }

        binding.bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            binding.bottomNavigationView.labelVisibilityMode =
                NavigationBarView.LABEL_VISIBILITY_SELECTED
            when (item.itemId) {
                R.id.checkList -> {
                    showFragment(CHECKER)
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

    private fun fragmentInit() {
        binding.bottomNavigationView.background =
            null// why work only dynamically? if xml not working
        showFragment(CalendarFragment(), R.id.fragmentContainer, CALENDAR)
    }

    private fun showFragment(tag: String) {
        when(tag){
            CALENDAR -> {
                showFragment(CalendarFragment(), R.id.fragmentContainer, CALENDAR)
                hideFragment(CHECKER)
            }
            CHECKER -> {
                showFragment(CheckerFragment(), R.id.fragmentContainer, CHECKER)
                hideFragment(CALENDAR)
            }
        }
    }

    companion object {
        private const val CALENDAR = "calendar"
        private const val CHECKER = "checker"
    }
}