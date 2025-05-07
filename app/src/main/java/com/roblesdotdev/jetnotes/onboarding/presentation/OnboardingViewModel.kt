package com.roblesdotdev.jetnotes.onboarding.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.roblesdotdev.jetnotes.onboarding.domain.repository.OnboardingRepository
import kotlinx.coroutines.launch

class OnboardingViewModel(
    private val repo: OnboardingRepository
) : ViewModel() {
    private var _hasSeenOnboarding = mutableStateOf(false)
    val hasSeenOnboarding: State<Boolean> = _hasSeenOnboarding

    init {
        viewModelScope.launch {
            _hasSeenOnboarding.value = repo.hasSeenOnboarding()
        }
    }

    fun completeOnboarding() {
        viewModelScope.launch {
            repo.setOnboardingSeen()
            _hasSeenOnboarding.value = true
        }
    }
}