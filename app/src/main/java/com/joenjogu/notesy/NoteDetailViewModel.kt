package com.joenjogu.notesy

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class NoteDetailViewModel(private val repository: Repository) : ViewModel() {

    fun getNote(noteId: Int): LiveData<Note> {
        return repository.getNote(noteId)
    }

    fun insertNote(note: Note) {
        viewModelScope.launch{
            repository.insertNote(note)
        }
    }

    fun deleteNote(noteId: Int) {
        viewModelScope.launch {
            repository.deleteNote(noteId)
        }

    }
}