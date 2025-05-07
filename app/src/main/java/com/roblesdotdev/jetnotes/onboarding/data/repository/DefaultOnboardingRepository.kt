package com.roblesdotdev.jetnotes.onboarding.data.repository

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.roblesdotdev.jetnotes.onboarding.domain.repository.OnboardingRepository
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

class DefaultOnboardingRepository(
    private val context: Context
) : OnboardingRepository {
    companion object {
        private const val DATA_STORE_NAME = "onboarding_prefs"
        private const val KEY_SEEN_ONBOARDING = "seen_onboarding"
        private val Context.dataStore by preferencesDataStore(name = DATA_STORE_NAME)
    }
    override suspend fun hasSeenOnboarding(): Boolean {
        return context.dataStore.data
            .map { preferences -> preferences[booleanPreferencesKey(KEY_SEEN_ONBOARDING)] == true }
            .first()
    }

    override suspend fun setOnboardingSeen() {
        context.dataStore.edit { preferences ->
            preferences[booleanPreferencesKey(KEY_SEEN_ONBOARDING)] = true
        }
    }

}