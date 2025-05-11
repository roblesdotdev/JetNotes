package com.roblesdotdev.jetnotes.home.presentation.list

import com.roblesdotdev.jetnotes.home.domain.models.Note

data class ListState(
    val notes: List<Note> = emptyList(),
    val isLoading: Boolean = false,
)
