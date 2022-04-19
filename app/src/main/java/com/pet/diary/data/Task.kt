package com.pet.diary.data

data class Task(
    val id: Int,
    val title: String,
    val desc: String?,
    val isCompleted: Boolean,
    val isArchived: Boolean,
    val planingTime: Long?,
    val timeCreate: Long,
    val timeCompleted: Long
)
