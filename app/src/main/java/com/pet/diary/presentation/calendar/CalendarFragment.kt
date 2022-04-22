package com.pet.diary.presentation.calendar

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.material.tabs.TabLayout
import com.pet.diary.R
import com.pet.diary.databinding.FragmentCalendarBinding
import com.pet.diary.hideFragment
import com.pet.diary.presentation.calendar.month.MonthFragment
import com.pet.diary.presentation.calendar.week.WeekFragment
import com.pet.diary.showFragment
import com.pet.diary.withArguments

class CalendarFragment : Fragment(R.layout.fragment_calendar) {

    private val binding by viewBinding(FragmentCalendarBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //fragmentInit()

    }

    private fun fragmentInit() {

        showFragment(newInstanceMonthOrWeek(MONTH), R.id.fragmentContainerCalendar, MONTH)
        binding.tabPeriod.getTabAt(0)?.select()

        binding.tabPeriod.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when (tab?.text) {
                    resources.getString(R.string.month) -> {
                        showFragment(
                            newInstanceMonthOrWeek(MONTH),
                            R.id.fragmentContainerCalendar,
                            MONTH
                        )
                    }
                    resources.getString(R.string.week) -> {
                        showFragment(
                            WeekFragment(),
                            R.id.fragmentContainerCalendar,
                            WEEK
                        )
                    }
                }
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                when (tab?.text) {
                    resources.getString(R.string.month) -> {
                        hideFragment(MONTH)
                    }
                    resources.getString(R.string.week) -> {
                        hideFragment(WEEK)
                    }
                }
            }
        })

    }

    companion object {
        const val MONTH = "month"
        const val WEEK = "week"
        const val PERIOD_TYPE = "selected_list_type"

        fun newInstanceMonthOrWeek(text: String): MonthFragment {
            return MonthFragment().withArguments {
                putString(PERIOD_TYPE, text)
            }
        }
    }
}