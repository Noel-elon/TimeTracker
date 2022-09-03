package com.noelon.core_data

import com.noelon.core_model.TaskModel

val dummyTaskList = listOf(
    TaskModel(
        title = "Prepare lunch for family",
        description = "It's time to make lunch",
        isCompleted = false
    ),
    TaskModel(
        title = "Go to church before 10am",
        description = "Church time, blessing time",
        isCompleted = true
    ),
    TaskModel(
        title = "Submit Decagon task to HR",
        description = "Submit the android project you were asked to build",
        isCompleted = false
    ),
)