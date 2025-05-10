package com.roblesdotdev.jetnotes.home.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.roblesdotdev.jetnotes.home.data.local.entity.NoteEntity

@Database(entities = [NoteEntity::class], version = 1)
abstract class HomeDatabase : RoomDatabase() {
    abstract val dao: HomeDao
}