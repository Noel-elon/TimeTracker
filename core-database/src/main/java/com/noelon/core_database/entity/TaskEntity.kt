package com.noelon.core_database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasks")
data class TaskEntity(
    @PrimaryKey
    val title: String,
    val description: String,
    val isCompleted: Boolean
)