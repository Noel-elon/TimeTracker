package com.noelon.timetracker.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.noelon.core_data.dummyTaskList
import com.noelon.core_data.repository.TrackerRepository
import com.noelon.core_model.TaskModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
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
            taskRepository.fetchTasks().map {
                _taskDetails.value = it
                Log.d("Saved Tasks: ", it.toString())
            }
        }
    }

    fun saveTaskDetails(taskModel: TaskModel) {
        viewModelScope.launch {
            taskRepository.saveTask(taskModel)
        }
    }
}