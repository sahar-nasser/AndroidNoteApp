package com.plcoding.cleanarchitecturenoteapp.feature_note.data.localdatabase

import androidx.room.Database
import androidx.room.RoomDatabase
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.model.Note

@Database(entities = [Note::class], version = 1)
abstract class NotesDatabase : RoomDatabase() {
    abstract val notesDao: NotesDao
}