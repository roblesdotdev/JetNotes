package com.roblesdotdev.jetnotes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.roblesdotdev.jetnotes.navigation.DefaultNavHost
import com.roblesdotdev.jetnotes.navigation.NavDestination
import com.roblesdotdev.jetnotes.ui.theme.JetNotesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen().apply {
            setKeepOnScreenCondition {
                viewModel.state.isLoading
            }
        }
        enableEdgeToEdge()
        setContent {
            JetNotesTheme {
                if (!viewModel.state.isLoading) {
                    val navController = rememberNavController()
                    DefaultNavHost(
                        navController = navController,
                        startDestination = getStartDestination(viewModel.state.hasSeenOnboarding)
                    )
                }
            }
        }
    }

    private fun getStartDestination(hasSeenOnboarding: Boolean): NavDestination {
        return if (hasSeenOnboarding) {
            NavDestination.Home
        } else {
            return NavDestination.Onboarding
        }
    }
}
