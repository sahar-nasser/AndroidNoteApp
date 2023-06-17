package com.plcoding.cleanarchitecturenoteapp.feature_note.data.repository

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.model.Note
import kotlinx.coroutines.flow.Flow

interface NotesRepository {

    fun getAllNotes(): Flow<List<Note>>

    suspend fun getNoteByID(id: Int): Note?

    suspend fun insertNote(note: Note)

    suspend fun deleteNode(note: Note)
}