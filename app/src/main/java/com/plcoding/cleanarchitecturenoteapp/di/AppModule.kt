package com.plcoding.cleanarchitecturenoteapp.di

import android.app.Application
import androidx.room.Room
import com.plcoding.cleanarchitecturenoteapp.feature_note.data.localdatabase.NotesDao
import com.plcoding.cleanarchitecturenoteapp.feature_note.data.localdatabase.NotesDatabase
import com.plcoding.cleanarchitecturenoteapp.feature_note.data.repository.NotesRepository
import com.plcoding.cleanarchitecturenoteapp.feature_note.data.repository.NotesRepositoryImpl
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.usecase.DeleteNoteUseCase
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.usecase.GetNotesUseCase
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.usecase.NotesUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalDatabase(app: Application):NotesDatabase{
        return Room.databaseBuilder(
            app,
            NotesDatabase::class.java,
            "notes"
        ).build()
    }

    @Provides
    @Singleton
    fun provideRepository(dao: NotesDao):NotesRepository{
        return NotesRepositoryImpl(dao)
    }

    @Provides
    @Singleton
    fun provideNotesUseCases(repository: NotesRepository):NotesUseCases{
        return NotesUseCases(
            getNotesUseCase = GetNotesUseCase(repository),
            deleteNoteUseCase = DeleteNoteUseCase(repository)
        )
    }

}