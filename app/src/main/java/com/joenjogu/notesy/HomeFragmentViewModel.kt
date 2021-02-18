package com.joenjogu.notesy

import androidx.lifecycle.ViewModel

class HomeFragmentViewModel(private val repository: Repository) : ViewModel() {

    val notes = repository.getAllNotes()
}