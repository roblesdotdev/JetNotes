package com.roblesdotdev.jetnotes.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.roblesdotdev.jetnotes.home.presentation.list.ListScreen
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
            ListScreen(onAddNote = {
                // TODO: navigate to create note screen
            })
        }
    }
}