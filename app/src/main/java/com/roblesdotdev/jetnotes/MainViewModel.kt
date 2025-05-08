package com.roblesdotdev.jetnotes

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.roblesdotdev.jetnotes.onboarding.domain.repository.OnboardingRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val onboardingRepo: OnboardingRepository
) : ViewModel() {
    var state by mutableStateOf(MainState())
        private set

    init {
        viewModelScope.launch {
            state = state.copy(
                isLoading = true
            )
            state = state.copy(
                hasSeenOnboarding = onboardingRepo.hasSeenOnboarding()
            )
            state = state.copy(
                isLoading = false
            )
        }
    }
}