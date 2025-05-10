package com.roblesdotdev.jetnotes.home.data.repository

import com.roblesdotdev.jetnotes.home.data.local.HomeDao
import com.roblesdotdev.jetnotes.home.data.mapper.toDomain
import com.roblesdotdev.jetnotes.home.data.mapper.toEntity
import com.roblesdotdev.jetnotes.home.domain.models.Note
import com.roblesdotdev.jetnotes.home.domain.repository.HomeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class DefaultHomeRepository(
    private val dao: HomeDao
) : HomeRepository {
    override fun getAllNotes(): Flow<List<Note>> {
        return dao.getAllNotes().map {
            it.map { it.toDomain() }
        }
    }

    override suspend fun getNoteById(id: String): Note {
        return withContext(Dispatchers.IO) {
            dao.getNoteById(id).toDomain()
        }
    }

    override suspend fun deleteNote(id: String) {
        dao.deleteNote(id)
    }

    override suspend fun upsertNote(note: Note) {
        dao.upsertNote(note.toEntity())
    }
}