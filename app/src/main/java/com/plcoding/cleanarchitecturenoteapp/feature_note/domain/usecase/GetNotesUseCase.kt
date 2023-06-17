package com.plcoding.cleanarchitecturenoteapp.feature_note.domain.usecase

import com.plcoding.cleanarchitecturenoteapp.feature_note.data.repository.NotesRepository
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.model.Note
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.util.GroupBy
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.util.OrderBy
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetNotesUseCase (private val repository: NotesRepository) {
    operator fun invoke(
        groupBy: GroupBy = GroupBy.Date(OrderBy.Dec)
    ): Flow<List<Note>>{
        return repository.getAllNotes().map { notes ->
            when (groupBy.orderBy){
                is OrderBy.Dec->{
                    when(groupBy){
                        is GroupBy.Title -> notes.sortedByDescending { it.title.lowercase() }
                        is GroupBy.Date -> notes.sortedByDescending { it.timestamp }
                        is GroupBy.Color -> notes.sortedByDescending { it.color }
                    }
                }
                is OrderBy.Asc->{
                    when(groupBy){
                        is GroupBy.Title -> notes.sortedBy { it.title.lowercase() }
                        is GroupBy.Date -> notes.sortedBy { it.timestamp }
                        is GroupBy.Color -> notes.sortedBy { it.color }
                    }
                }
            }
        }
    }
}