package com.roblesdotdev.jetnotes.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.roblesdotdev.jetnotes.onboarding.data.repository.DefaultOnboardingRepository
import com.roblesdotdev.jetnotes.onboarding.presentation.OnboardingScreen
import com.roblesdotdev.jetnotes.onboarding.presentation.OnboardingViewModel

@Composable
fun DefaultNavHost(
    navController: NavHostController,
    startDestination: NavDestination
) {
    NavHost(navController = navController, startDestination = startDestination) {
        composable<NavDestination.Onboarding> {
            val context = LocalContext.current
            OnboardingScreen(
                viewModel = OnboardingViewModel(repo = DefaultOnboardingRepository(
                    context = context
                )),
                onGetStarted = {
                    navController.popBackStack()
                    navController.navigate(NavDestination.Home)
                }
            )
        }

        composable<NavDestination.Home> {
            Text("Home Screen not implemented yet!")
        }
    }
}