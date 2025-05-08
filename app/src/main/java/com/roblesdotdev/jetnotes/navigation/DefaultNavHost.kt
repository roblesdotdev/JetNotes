package com.roblesdotdev.jetnotes.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.roblesdotdev.jetnotes.onboarding.presentation.OnboardingScreen

@Composable
fun DefaultNavHost(
    navController: NavHostController,
    startDestination: NavDestination
) {
    NavHost(navController = navController, startDestination = startDestination) {
        composable<NavDestination.Onboarding> {
            OnboardingScreen(
                onGetStarted = {
                    navController.popBackStack()
                    navController.navigate(NavDestination.Home)
                }
            )
        }

        composable<NavDestination.Home> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text("Home Screen not implemented yet!")
            }
        }
    }
}