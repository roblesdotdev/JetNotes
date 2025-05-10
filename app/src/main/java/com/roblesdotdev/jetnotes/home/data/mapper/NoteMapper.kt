package com.roblesdotdev.jetnotes.home.data.mapper

import com.roblesdotdev.jetnotes.home.data.local.entity.NoteEntity
import com.roblesdotdev.jetnotes.home.domain.models.Note

fun NoteEntity.toDomain(): Note {
    return Note(
        id = this.id,
        title = this.title,
        description = this.description
    )
}

fun Note.toEntity(): NoteEntity {
    return NoteEntity(
        id = this.id,
        title = this.title,
        description = this.description
    )
}