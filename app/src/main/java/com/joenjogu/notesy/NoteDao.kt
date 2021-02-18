package com.joenjogu.notesy

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: Note)

    @Query("DELETE FROM note WHERE id = :id")
    suspend fun deleteNote(id: Int)

    @Query("SELECT * FROM Note")
    fun getAllNotes(): LiveData<List<Note>>

    @Query("SELECT * FROM note WHERE id = :id")
    fun getNoteById(id: Int): LiveData<Note>
}