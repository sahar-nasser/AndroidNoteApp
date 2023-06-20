package com.plcoding.cleanarchitecturenoteapp.feature_note.presentation.notes

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.model.Note
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.usecase.NotesUseCases
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.util.GroupBy
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.util.NoteEvents
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.util.NoteState
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.util.OrderBy
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(private val notesUseCases: NotesUseCases) : ViewModel() {

    private var recentlyDeletedNote: Note? = null

    private val _state = mutableStateOf(NoteState())
    val state: State<NoteState> = _state

    private var getNotesJob: Job? = null

    init {
        getNotes(GroupBy.Date(OrderBy.Dec))
    }

    fun onEvent(event: NoteEvents) {
        when (event) {
            is NoteEvents.OrderEvent -> {
                if (state.value.groupBy::class == event.groupBy::class &&
                    state.value.groupBy.orderBy == event.groupBy.orderBy
                ) {
                    return
                }
                getNotes(event.groupBy)
            }

            is NoteEvents.DeleteNoteEvent -> {
                viewModelScope.launch {
                    notesUseCases.deleteNoteUseCase(event.note)
                    recentlyDeletedNote = event.note
                }
            }

            is NoteEvents.RestoreNoteEvent -> {
                viewModelScope.launch {
                    notesUseCases.addNoteUseCase(recentlyDeletedNote ?: return@launch)
                    recentlyDeletedNote = null
                }
            }

            is NoteEvents.ToggleOrderSectionEvent -> {
                _state.value = _state.value.copy(
                    isSectionVisible = !state.value.isSectionVisible
                )
            }
        }
    }

    private fun getNotes(groupBy: GroupBy) {
        getNotesJob?.cancel()
        getNotesJob = notesUseCases.getNotesUseCase(groupBy).onEach { noteList ->
            _state.value = state.value.copy(
                notes = noteList,
                groupBy = groupBy
            )
        }.launchIn(viewModelScope)
    }
}

