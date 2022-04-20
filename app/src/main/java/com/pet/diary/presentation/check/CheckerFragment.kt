package com.pet.diary.presentation.check

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.pet.diary.R
import com.pet.diary.data.Task
import com.pet.diary.databinding.FragmentCheckerBinding
import com.pet.diary.utils.autoCleared

class CheckerFragment : Fragment(R.layout.fragment_checker) {

    private val binding by viewBinding(FragmentCheckerBinding::bind)
    private var checkerAdapter: CheckerAdapter by autoCleared()

//    private val list = (0..100).map {
//        Task(1, "search",
//            getString(R.string.test_long),
//            false,
//            false,
//            234234L,
//            9808L,
//            3453L)
//    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initList()
        val list = (0..100).map {
            Task(1, "search",
                getString(R.string.test_long),
                false,
                false,
                234234L,
                9808L,
                3453L)
        }
        checkerAdapter.items = list
//        binding.imageDownArrow.setOnClickListener {
//            if (binding.textDesc.isVisible) {
//                TransitionManager.beginDelayedTransition(
//                    binding.card,
//                    AutoTransition()
//                )
//                binding.textDesc.isVisible = false
//                binding.imageDownArrow.setImageResource(R.drawable.ic_arrow_down)
//            }
//            else {
//                TransitionManager.beginDelayedTransition(
//                    binding.card,
//                    AutoTransition()
//                )
//                binding.textDesc.isVisible = true
//                binding.imageDownArrow.setImageResource(R.drawable.ic_arrow_up)
//            }
//        }

    }

    private fun initList() {
        checkerAdapter = CheckerAdapter(
            onEdit = ::onEditHandler,
            onArchive = ::onArchiveHandler,
            onDelete = ::onDeleteHandler,
            onExpand = ::onExpandHandler
        )
        with(binding.listTask) {
            setHasFixedSize(true)
            adapter = checkerAdapter
        }
    }

    private fun onEditHandler(task: Task) {

    }

    private fun onArchiveHandler(task: Task) {

    }

    private fun onDeleteHandler(task: Task) {

    }

    private fun onExpandHandler(task: Task) {

    }
}