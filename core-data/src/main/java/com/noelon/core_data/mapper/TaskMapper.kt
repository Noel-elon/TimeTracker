package com.noelon.core_data.mapper

import com.noelon.core_database.entity.TaskEntity
import com.noelon.core_model.TaskModel

fun TaskEntity.asTaskModel() =
    TaskModel(
        title,
        description,
        isCompleted
    )