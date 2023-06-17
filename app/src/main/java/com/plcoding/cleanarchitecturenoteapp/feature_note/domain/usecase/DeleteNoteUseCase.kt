package com.plcoding.cleanarchitecturenoteapp.feature_note.domain.usecase

import com.plcoding.cleanarchitecturenoteapp.feature_note.data.repository.NotesRepository
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.model.Note

class DeleteNoteUseCase (private val repository: NotesRepository){

    suspend operator fun invoke(note: Note){
        repository.deleteNode(note)
    }
}