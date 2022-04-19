package com.pet.diary.presentation.calendar.month

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.applandeo.materialcalendarview.EventDay
import com.pet.diary.R
import com.pet.diary.databinding.FragmentMonthBinding
import com.pet.diary.presentation.calendar.CalendarFragment
import timber.log.Timber
import java.util.*


class MonthFragment : Fragment(R.layout.fragment_month) {

    private val binding by viewBinding(FragmentMonthBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        val events: MutableList<EventDay> = ArrayList()
//        val calendar = Calendar.getInstance()
//        events.add(EventDay(calendar, R.drawable.check))
//        binding.calendarView.setEvents(events)

        setPeriod()

    }

    private fun weekActivate() {
        Timber.d("week")
        binding.calendarView.setMinimumDate(Calendar.getInstance())
        binding.calendarView.setMaximumDate(
            Calendar.getInstance().apply { add(Calendar.DAY_OF_WEEK, 7) })
    }

    private fun monthActivate() {
        binding.calendarView.setMinimumDate(Calendar.getInstance())
        binding.calendarView.setMaximumDate(
            Calendar.getInstance().apply { add(Calendar.MONTH, 1) })
    }

    private fun setPeriod() {
        when (arguments?.getString(CalendarFragment.PERIOD_TYPE)) {
            CalendarFragment.MONTH -> monthActivate()
            CalendarFragment.WEEK -> weekActivate()
        }
    }
}