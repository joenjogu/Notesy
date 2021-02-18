package com.joenjogu.notesy.viewmodels

import androidx.lifecycle.ViewModel
import com.joenjogu.notesy.data.Repository

class HomeFragmentViewModel(private val repository: Repository) : ViewModel() {

    val notes = repository.getAllNotes()
}