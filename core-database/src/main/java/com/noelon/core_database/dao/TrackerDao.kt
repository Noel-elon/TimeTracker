package com.noelon.core_database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.noelon.core_database.entity.TaskEntity

@Dao
interface TrackerDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTaskDetails(task: TaskEntity)

    @Query(value = "SELECT * FROM tasks")
    suspend fun getTasks() : List<TaskEntity>
}