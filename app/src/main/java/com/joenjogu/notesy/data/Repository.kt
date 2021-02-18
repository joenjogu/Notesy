package com.joenjogu.notesy.data

import com.joenjogu.notesy.models.Note

class Repository(private val noteDao: NoteDao) {

    fun getAllNotes() = noteDao.getAllNotes()
    fun getNote(noteId: Int) = noteDao.getNoteById(noteId)

    suspend fun insertNote(note: Note){
        noteDao.insertNote(note)
    }

    suspend fun deleteNote(noteId: Int) {
        noteDao.deleteNote(noteId)
    }
}