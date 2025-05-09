package com.roblesdotdev.jetnotes.home.domain.repository

import com.roblesdotdev.jetnotes.home.domain.models.Note
import kotlinx.coroutines.flow.Flow

interface HomeRepository {
    fun getAllNotes(): Flow<List<Note>>

    suspend fun getNoteById(id: String): Note

    suspend fun deleteNote(id: String)

    suspend fun upsertNote(note: Note)
}