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
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DatabaseModule {

    @Provides
    @Singleton
    fun provideDegExDatabase(@ApplicationContext context: Context): TrackerDatabase =
        Room.databaseBuilder(
            context.applicationContext,
            TrackerDatabase::class.java,
            "tracker-database"
        ).build()

    @Provides
    @Singleton
    fun provideAuthDao(trackerDatabase: TrackerDatabase): TrackerDao =
        trackerDatabase.trackerDao()

}