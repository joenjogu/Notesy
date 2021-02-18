package com.joenjogu.notesy.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.joenjogu.notesy.models.Note

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