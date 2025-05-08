package com.roblesdotdev.jetnotes.onboarding.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun OnboardingScreen(
    viewModel: OnboardingViewModel = hiltViewModel(),
    onGetStarted: () -> Unit
) {
    val hasSeenOnboarding = viewModel.hasSeenOnboarding.value

    LaunchedEffect(hasSeenOnboarding) {
        if (hasSeenOnboarding) {
            onGetStarted()
        }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text("Onboarding Screen")
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = {
            viewModel.completeOnboarding()
        }) {
            Text("Get Started")
        }
    }
}