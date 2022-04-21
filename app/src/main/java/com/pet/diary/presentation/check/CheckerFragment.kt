package com.pet.diary.presentation.check

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.pet.diary.R
import com.pet.diary.data.Task
import com.pet.diary.databinding.FragmentCheckerBinding
import com.pet.diary.presentation.main.MainFragmentDirections
import com.pet.diary.utils.autoCleared

class CheckerFragment : Fragment(R.layout.fragment_checker) {

    private val binding by viewBinding(FragmentCheckerBinding::bind)
    private var checkerAdapter: CheckerAdapter by autoCleared()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initList()
        binding.fabAdd.setOnClickListener {
            // replaceFragment(TaskAddFragment(), R.id.fragmentContainer, ADD_TASK )
            //findNavController().navigate(.actionMainFragmentToTaskAddFragment())
        }
        val list = (0..100).map {
            Task(
                1, "search",
                getString(R.string.test_long),
                false,
                false,
                234234L,
                9808L,
                3453L
            )
        }
        checkerAdapter.items = list
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

    companion object {
        const val ADD_TASK = "add_task"
    }
}