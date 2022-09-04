package com.noelon.core_data.mapper

import com.noelon.core_database.entity.TaskEntity
import com.noelon.core_model.TaskModel

fun TaskEntity.asTaskModel() =
    TaskModel(
        title,
        description,
        isCompleted
    )

fun List<TaskEntity>.asListOfTaskModel() =
    this.map {
        TaskModel(
            title = it.title,
            description = it.description,
            isCompleted = it.isCompleted
        )
    }