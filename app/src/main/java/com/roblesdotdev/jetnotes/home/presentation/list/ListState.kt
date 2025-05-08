package com.roblesdotdev.jetnotes.home.presentation.list

import com.roblesdotdev.jetnotes.home.domain.models.Note

data class ListState(
    val notes: List<Note> = mockNotes  // emptyList()
)

private val mockNotes = (1..30).map {
    Note(title = "Note $it", description = "Description for note $it")
}