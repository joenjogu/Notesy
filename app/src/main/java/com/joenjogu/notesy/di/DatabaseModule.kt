package com.joenjogu.notesy.di

import androidx.room.Room
import com.joenjogu.notesy.data.NoteDao
import com.joenjogu.notesy.data.NoteDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {

    single { provideNoteDao(database = get()) }

    single {
        Room.databaseBuilder(
                androidContext(),
                NoteDatabase::class.java,
                "note_db"
        ).build()
    }
}

private fun provideNoteDao(database: NoteDatabase): NoteDao {
    return database.noteDao
}