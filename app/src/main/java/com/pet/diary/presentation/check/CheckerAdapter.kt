package com.pet.diary.presentation.check

import androidx.recyclerview.widget.DiffUtil
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import com.pet.diary.data.Task

class CheckerAdapter(
    onEdit: (Task) -> Unit,
    onArchive: (Task) -> Unit,
    onDelete: (Task) -> Unit,
    onExpand: (Task) -> Unit
) : AsyncListDifferDelegationAdapter<Task>(TaskDiffUtilCallback()) {

    init {
        delegatesManager.addDelegate(CheckerAdapterDelegate(onEdit, onArchive, onDelete, onExpand))
    }

    class TaskDiffUtilCallback : DiffUtil.ItemCallback<Task>() {
        override fun areItemsTheSame(
            oldItem: Task,
            newItem: Task
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: Task,
            newItem: Task
        ): Boolean {
            return oldItem == newItem
        }
    }

}