package com.roblesdotdev.jetnotes.navigation

import kotlinx.serialization.Serializable

sealed class NavDestination {
    @Serializable
    object Onboarding: NavDestination()

    @Serializable
    object Home: NavDestination()

    @Serializable
    data class Detail(val id: String? = null) : NavDestination()
}
