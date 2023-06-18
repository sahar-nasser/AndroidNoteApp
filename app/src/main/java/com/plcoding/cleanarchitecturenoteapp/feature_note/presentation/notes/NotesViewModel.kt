package com.plcoding.cleanarchitecturenoteapp.feature_note.presentation.notes

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.usecase.NotesUseCases
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.util.NoteEvents
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.util.NoteState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(private val notesUseCases: NotesUseCases) : ViewModel() {

    private val _state  = mutableStateOf(NoteState())
    val state: State<NoteState> = _state

    fun onEvent(event: NoteEvents) {
        when (event) {
            is NoteEvents.OrderEvent -> {}

            is NoteEvents.DeleteNoteEvent -> {}

            is NoteEvents.RestoreNoteEvent -> {}

            is NoteEvents.ToggleOrderSectionEvent -> {}
        }
    }
}

