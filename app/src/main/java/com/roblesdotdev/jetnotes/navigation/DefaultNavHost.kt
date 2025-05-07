package com.roblesdotdev.jetnotes.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.roblesdotdev.jetnotes.onboarding.presentation.OnboardingScreen

@Composable
fun DefaultNavHost(
    navController: NavHostController
) {
    NavHost(navController = navController, startDestination = Onboarding) {
        composable<Onboarding> {
            OnboardingScreen {
                navController.navigate(Home)
            }
        }

        composable<Home> {
            Text("Home Screen not implemented yet!")
        }
    }
}