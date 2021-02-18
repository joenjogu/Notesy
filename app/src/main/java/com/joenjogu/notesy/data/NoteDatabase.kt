package com.joenjogu.notesy.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.joenjogu.notesy.models.Note
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized

@Database(entities = [Note::class], version = 1, exportSchema = false)
abstract class NoteDatabase : RoomDatabase(){

    abstract val noteDao: NoteDao

    companion object {

        @Volatile
        private var INSTANCE: NoteDatabase? = null

        @InternalCoroutinesApi
        fun getInstance(context: Context): NoteDatabase {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }
        }

        private fun buildDatabase(context: Context): NoteDatabase {
            return Room.databaseBuilder(
                    context,
                    NoteDatabase::class.java,
                    "note_db"
            ).build()
        }

    }
}