package com.roblesdotdev.jetnotes.onboarding.domain.repository

interface OnboardingRepository {
    suspend fun hasSeenOnboarding(): Boolean
    suspend fun setOnboardingSeen()
}