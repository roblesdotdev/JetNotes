package com.roblesdotdev.jetnotes.home.di

import android.content.Context
import androidx.room.Room
import com.roblesdotdev.jetnotes.home.data.local.HomeDao
import com.roblesdotdev.jetnotes.home.data.local.HomeDatabase
import com.roblesdotdev.jetnotes.home.data.repository.DefaultHomeRepository
import com.roblesdotdev.jetnotes.home.domain.repository.HomeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object HomeModule {
    @Singleton
    @Provides
    fun provideHomeRepository(dao: HomeDao)  : HomeRepository {
        return DefaultHomeRepository(dao)
    }

    @Singleton
    @Provides
    fun provideHomeDao(@ApplicationContext context: Context) : HomeDao {
        return Room.databaseBuilder(
            context,
            HomeDatabase::class.java,
            "notes_db"
        ).build().dao
    }
}