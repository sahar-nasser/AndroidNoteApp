package com.plcoding.cleanarchitecturenoteapp.feature_note.data.localdatabase

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.model.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NotesDao {

    @Query("select * from note")
    fun getAllNotes(): Flow<List<Note>>

    @Query("select * from note where id=:id")
    suspend fun getNoteByID(id: Int): Note?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: Note)

    @Delete
    suspend fun deleteNode(note:Note)
}