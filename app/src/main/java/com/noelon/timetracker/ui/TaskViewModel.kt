package com.noelon.timetracker.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.noelon.core_data.dummyTaskList
import com.noelon.core_data.repository.TrackerRepository
import com.noelon.core_model.TaskModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TaskViewModel @Inject constructor(
    private val taskRepository: TrackerRepository
) : ViewModel() {

    private val _taskDetails: MutableStateFlow<List<TaskModel>> = MutableStateFlow(emptyList())
    val taskDetails = _taskDetails as StateFlow<List<TaskModel>>

    init {

        dummyTaskList.forEach {
            saveTaskDetails(it)
            getTaskDetails()
        }

    }

    fun getTaskDetails() {
        viewModelScope.launch {
            taskRepository.fetchTasks()
                .collect {
                    _taskDetails.value = it
                }
        }

    }

    fun saveTaskDetails(taskModel: TaskModel) {
        viewModelScope.launch {
            taskRepository.saveTask(taskModel)
        }
    }
}