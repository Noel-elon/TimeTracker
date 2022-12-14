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

val dummyTime = listOf(
    "12:00 PM",
    "1:00 PM",
    "2:00 PM", "3:00 PM", "4:00 PM", "5:00 PM", "6:00 PM",

    )

val dummyConditions = listOf(
    "Does not repeat",
    "Daily",
    "Weekly on tuesday",
    "Monthly on last tuesday",
    "Annually on July 28"
)

val dummySort = listOf(
    "Name",
    "Date modified",
    "Ascending",
    "Descending"
)