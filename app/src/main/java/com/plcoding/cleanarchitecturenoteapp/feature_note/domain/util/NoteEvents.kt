package com.plcoding.cleanarchitecturenoteapp.feature_note.domain.util

import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.model.Note

sealed class NoteEvents {
    data class OrderEvent(val groupBy: GroupBy) : NoteEvents()
    data class DeleteNoteEvent(val note: Note) : NoteEvents()
    object RestoreNoteEvent : NoteEvents()
    object ToggleOrderSectionEvent : NoteEvents()
}
