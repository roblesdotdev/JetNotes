package com.roblesdotdev.jetnotes.home.data.repository

import com.roblesdotdev.jetnotes.home.domain.models.Note
import com.roblesdotdev.jetnotes.home.domain.repository.HomeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class DefaultHomeRepository : HomeRepository {
    private val mockNotes = (1..5).map {
        Note(title = "Note $it", description = "Description for note $it")
    }.toMutableList()

    override fun getAllNotes(): Flow<List<Note>> {
        return flowOf(mockNotes)
    }
}