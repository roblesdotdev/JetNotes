package com.roblesdotdev.jetnotes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.rememberNavController
import com.roblesdotdev.jetnotes.navigation.DefaultNavHost
import com.roblesdotdev.jetnotes.navigation.NavDestination
import com.roblesdotdev.jetnotes.onboarding.data.repository.DefaultOnboardingRepository
import com.roblesdotdev.jetnotes.ui.theme.JetNotesTheme

@Suppress("UNCHECKED_CAST")
class MainActivity : ComponentActivity() {
    private val onboardingRepo by lazy {
        DefaultOnboardingRepository(applicationContext)
    }

    private val viewModelFactory by lazy {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
                    return MainViewModel(onboardingRepo) as T
                }
                throw IllegalArgumentException("Unknown ViewModel class")
            }
        }
    }

    private val viewModel: MainViewModel by viewModels { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetNotesTheme {
                val navController = rememberNavController()
                DefaultNavHost(
                    navController = navController,
                    startDestination = getStartDestination(viewModel.hasSeenOnboarding.value)
                )
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
