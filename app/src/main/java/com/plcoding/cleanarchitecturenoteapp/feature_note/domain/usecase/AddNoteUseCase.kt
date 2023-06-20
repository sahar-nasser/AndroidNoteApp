package com.plcoding.cleanarchitecturenoteapp.feature_note.domain.usecase

import com.plcoding.cleanarchitecturenoteapp.feature_note.data.repository.NotesRepository
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.model.InvalidNoteException
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.model.Note

class AddNoteUseCase(private val repository: NotesRepository) {
    suspend operator fun invoke (note: Note){
        if(note.title.isBlank() && note.content.isBlank()){
          throw InvalidNoteException("Empty Note")
        }
        if (note.title.isBlank()){
            note.title = note.content
            repository.insertNote(note)
        }
        else{
            repository.insertNote(note)
        }
    }
}