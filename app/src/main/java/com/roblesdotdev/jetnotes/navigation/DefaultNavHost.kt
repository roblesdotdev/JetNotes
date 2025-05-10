package com.roblesdotdev.jetnotes.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.roblesdotdev.jetnotes.home.presentation.detail.DetailScreen
import com.roblesdotdev.jetnotes.home.presentation.list.ListScreen
import com.roblesdotdev.jetnotes.onboarding.presentation.OnboardingScreen

@Composable
fun DefaultNavHost(
    navController: NavHostController,
    startDestination: NavDestination
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None },
    ) {
        composable<NavDestination.Onboarding> {
            OnboardingScreen(
                onGetStarted = {
                    navController.popBackStack()
                    navController.navigate(NavDestination.Home)
                }
            )
        }

        composable<NavDestination.Home> {
            ListScreen(onNavigateToDetail = { id ->
                navController.navigate(NavDestination.Detail(id))
            })
        }

        composable<NavDestination.Detail> {
            DetailScreen(
                onSave = {
                    navController.popBackStack()
                },
                onDelete = {
                    navController.popBackStack()
                })
        }
    }
}