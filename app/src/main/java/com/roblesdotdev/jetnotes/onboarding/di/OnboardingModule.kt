package com.roblesdotdev.jetnotes.onboarding.di

import android.content.Context
import com.roblesdotdev.jetnotes.onboarding.data.repository.DefaultOnboardingRepository
import com.roblesdotdev.jetnotes.onboarding.domain.repository.OnboardingRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object OnboardingModule {

    @Provides
    @Singleton
    fun provideOnboardingRepository(@ApplicationContext context: Context): OnboardingRepository {
        return DefaultOnboardingRepository(context)
    }

}