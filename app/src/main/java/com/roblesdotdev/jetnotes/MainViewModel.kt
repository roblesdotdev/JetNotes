package com.roblesdotdev.jetnotes

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.roblesdotdev.jetnotes.onboarding.domain.repository.OnboardingRepository
import kotlinx.coroutines.launch

class MainViewModel(
    private val onboardingRepo: OnboardingRepository
) : ViewModel() {
    private var _hasSeenOnboarding = mutableStateOf(false)
    val hasSeenOnboarding: State<Boolean> = _hasSeenOnboarding

    init {
        viewModelScope.launch {
            _hasSeenOnboarding.value = onboardingRepo.hasSeenOnboarding()
        }
    }
}