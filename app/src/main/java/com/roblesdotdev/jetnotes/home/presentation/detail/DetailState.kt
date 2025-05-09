package com.roblesdotdev.jetnotes.home.presentation.detail

data class DetailState(
    val id: String? = null,
    val title: String = "",
    val description: String = "",
    val isSaved: Boolean = false,
)
