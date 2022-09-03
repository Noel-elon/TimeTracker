package com.noelon.core_database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.noelon.core_database.dao.TrackerDao
import com.noelon.core_database.entity.TaskEntity

@Database(
    entities = [TaskEntity::class],
    version = 1,
    exportSchema = true
)
abstract class TrackerDatabase : RoomDatabase() {
    abstract fun trackerDao() : TrackerDao
}