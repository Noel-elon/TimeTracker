package com.noelon.core_data.repository

import com.noelon.core_model.TaskModel
import kotlinx.coroutines.flow.Flow

interface TrackerRepository {
    suspend fun fetchTasks(): Flow<List<TaskModel>>

    suspend fun saveTask(taskModel: TaskModel)
}