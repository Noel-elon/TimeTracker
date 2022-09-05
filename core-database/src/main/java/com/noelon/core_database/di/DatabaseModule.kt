package com.noelon.core_database.di

import android.content.Context
import androidx.room.Room
import com.noelon.core_database.TrackerDatabase
import com.noelon.core_database.dao.TrackerDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
 object DatabaseModule {

    @Provides
    @Singleton
    fun provideTrackerDatabase(@ApplicationContext context: Context): TrackerDatabase =
        Room.databaseBuilder(
            context.applicationContext,
            TrackerDatabase::class.java,
            "tracker-database"
        ).build()

    @Provides
    @Singleton
    fun provideTrackerDao(trackerDatabase: TrackerDatabase): TrackerDao =
        trackerDatabase.trackerDao()


    @Provides
    @Singleton
    fun provideCoroutineDispatcher(): CoroutineDispatcher {
        return Dispatchers.IO
    }

}