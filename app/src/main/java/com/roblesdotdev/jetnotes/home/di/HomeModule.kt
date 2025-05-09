package com.roblesdotdev.jetnotes.home.di

import com.roblesdotdev.jetnotes.home.data.repository.DefaultHomeRepository
import com.roblesdotdev.jetnotes.home.domain.repository.HomeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object HomeModule {
    @Singleton
    @Provides
    fun provideHomeRepository(): HomeRepository {
        return DefaultHomeRepository()
    }
}