package com.pet.diary.presentation.check

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import androidx.transition.AutoTransition
import androidx.transition.TransitionManager
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate
import com.pet.diary.R
import com.pet.diary.data.Task
import com.pet.diary.databinding.ItemCheckBinding

class CheckerAdapterDelegate(
    private val onEdit: (Task) -> Unit,
    private val onArchive: (Task) -> Unit,
    private val onDelete: (Task) -> Unit,
    private val onExpand: (Task) -> Unit
) : AbsListItemAdapterDelegate<Task, Task, CheckerAdapterDelegate.Holder>() {

    override fun isForViewType(item: Task, items: MutableList<Task>, position: Int): Boolean {
        return true
    }

    override fun onCreateViewHolder(parent: ViewGroup): Holder {
        val binding = ItemCheckBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding, onEdit, onArchive, onDelete, onExpand)
    }

    override fun onBindViewHolder(item: Task, holder: Holder, payloads: MutableList<Any>) {
        holder.bind(item)
    }

    class Holder(
        private val binding: ItemCheckBinding,
        private val onEdit: (Task) -> Unit,
        private val onArchive: (Task) -> Unit,
        private val onDelete: (Task) -> Unit,
        private val onExpand: (Task) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        private lateinit var currentTask: Task

        init {
            initListeners()
        }

        fun bind(task: Task) {
            currentTask = task

            with(binding) {
                checkbox.text = currentTask.title
                textDesc.text = currentTask.desc
                if (currentTask.isCompleted)
                    checkbox.isChecked = true
                if (currentTask.isArchived) {
                    checkbox.isEnabled = false
                    checkbox.isActivated = false
                }
            }
        }

        private fun initListeners() {
            with(binding) {
                imageEdit.setOnClickListener {
                    onEdit(currentTask)
                }
                imageArchive.setOnClickListener {
                    onArchive(currentTask)
                }
                imageDelete.setOnClickListener {
                    onDelete(currentTask)
                }
                imageDownArrow.setOnClickListener {
                    onExpandHandler()
                }
            }
        }

        private fun onExpandHandler() {
            if (binding.textDesc.isVisible) {
                TransitionManager.beginDelayedTransition(
                    binding.card,
                    AutoTransition()
                )
                binding.textDesc.isVisible = false
                binding.imageDownArrow.setImageResource(R.drawable.ic_arrow_down)
            } else {
                TransitionManager.beginDelayedTransition(
                    binding.card,
                    AutoTransition()
                )
                binding.textDesc.isVisible = true
                binding.imageDownArrow.setImageResource(R.drawable.ic_arrow_up)
            }
        }
    }
}