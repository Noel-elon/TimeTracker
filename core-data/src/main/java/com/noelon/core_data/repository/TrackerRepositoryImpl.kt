package com.noelon.core_data.repository

import com.noelon.core_data.mapper.asTaskModel
import com.noelon.core_database.dao.TrackerDao
import com.noelon.core_database.entity.asTaskEntity
import com.noelon.core_model.TaskModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class TrackerRepositoryImpl @Inject constructor(
    private val dispatcher: CoroutineDispatcher,
    private val trackerDao: TrackerDao
) : TrackerRepository {

    override suspend fun fetchTasks(): Flow<List<TaskModel>> = flow {
        val savedTasks = trackerDao.getTasks().map { it.asTaskModel() }
        if (savedTasks.isEmpty()) {
            emit(emptyList())
        }
        emit(savedTasks)
    }.flowOn(dispatcher)

    override suspend fun saveTask(taskModel: TaskModel) {
        trackerDao.saveTaskDetails(taskModel.asTaskEntity())
    }
}