package com.roblesdotdev.jetnotes.navigation

import kotlinx.serialization.Serializable

sealed class NavDestination {
    @Serializable
    object Onboarding: NavDestination()

    @Serializable
    object Home: NavDestination()
}
