package com.noelon.core_data.di

import com.noelon.core_data.repository.TrackerRepository
import com.noelon.core_data.repository.TrackerRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    abstract fun bindsTrackerRepositoryImpl(
        trackerRepositoryImpl: TrackerRepositoryImpl
    ): TrackerRepository


}