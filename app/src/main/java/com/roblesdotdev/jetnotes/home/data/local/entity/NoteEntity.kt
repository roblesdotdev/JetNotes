package com.roblesdotdev.jetnotes.home.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class NoteEntity(
    @PrimaryKey(autoGenerate = false)
    val id: String,
    val title: String,
    val description: String
)