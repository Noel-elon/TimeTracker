package com.noelon.core_database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.noelon.core_model.TaskModel

@Entity(tableName = "tasks")
data class TaskEntity(
    @PrimaryKey
    val title: String,
    val description: String,
    val isCompleted: Boolean
)

fun TaskModel.asTaskEntity() =
    TaskEntity(
        title,
        description,
        isCompleted
    )