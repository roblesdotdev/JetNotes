package com.roblesdotdev.jetnotes.home.data.repository

import com.roblesdotdev.jetnotes.home.domain.models.Note
import com.roblesdotdev.jetnotes.home.domain.repository.HomeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class DefaultHomeRepository : HomeRepository {
    private val mockNotes = (1..5).map {
        Note(id = "$it", title = "Note $it", description = "Description for note $it")
    }.toMutableList()

    override fun getAllNotes(): Flow<List<Note>> {
        return flowOf(mockNotes)
    }

    override suspend fun getNoteById(id: String): Note {
        return mockNotes.first { it.id == id }
    }

    override suspend fun deleteNote(id: String) {
        mockNotes.removeIf { it.id == id }
    }

    override suspend fun upsertNote(note: Note) {
        val idx = mockNotes.indexOfFirst { it.id == note.id }
        if (idx == -1) {
            mockNotes.add(note)
        } else {
            mockNotes.removeAt(idx)
            mockNotes.add(idx, note)
        }
    }
}