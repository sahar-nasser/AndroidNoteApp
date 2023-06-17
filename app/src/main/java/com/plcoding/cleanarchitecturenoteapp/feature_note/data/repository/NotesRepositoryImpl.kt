package com.plcoding.cleanarchitecturenoteapp.feature_note.data.repository

import com.plcoding.cleanarchitecturenoteapp.feature_note.data.localdatabase.NotesDao
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.model.Note
import kotlinx.coroutines.flow.Flow

class NotesRepositoryImpl(private val dao: NotesDao) :NotesRepository {
    override fun getAllNotes(): Flow<List<Note>> {
        return dao.getAllNotes()
    }

    override suspend fun getNoteByID(id: Int): Note? {
        return dao.getNoteByID(id)
    }

    override suspend fun insertNote(note: Note) {
        dao.insertNote(note)
    }

    override suspend fun deleteNode(note: Note) {
        dao.deleteNode(note)
    }


}