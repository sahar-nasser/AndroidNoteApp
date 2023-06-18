package com.plcoding.cleanarchitecturenoteapp.feature_note.domain.util

import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.model.Note

data class NoteState(
    val notes: List<Note> = emptyList(),
    val groupBy: GroupBy = GroupBy.Date(OrderBy.Dec),
    val isSectionVisible : Boolean = false
)
