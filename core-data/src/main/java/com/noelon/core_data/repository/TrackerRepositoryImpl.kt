package com.noelon.core_data.repository

import com.noelon.core_data.mapper.asListOfTaskModel
import com.noelon.core_data.mapper.asTaskModel
import com.noelon.core_database.dao.TrackerDao
import com.noelon.core_database.entity.asTaskEntity
import com.noelon.core_model.TaskModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class TrackerRepositoryImpl @Inject constructor(
    private val dispatcher: CoroutineDispatcher,
    private val trackerDao: TrackerDao
) : TrackerRepository {

    override fun fetchTasks(): Flow<List<TaskModel>> {
        return trackerDao.getTasks().map {
            it.asListOfTaskModel()
        }.flowOn(dispatcher)
    }

    override suspend fun saveTask(taskModel: TaskModel) {
        trackerDao.saveTaskDetails(taskModel.asTaskEntity())
    }
}