package com.joenjogu.notesy.viewmodels

import androidx.lifecycle.ViewModel
import com.joenjogu.notesy.data.Repository

class HomeFragmentViewModel(repository: Repository) : ViewModel() {

    //TODO use banner forecast here
    val notes = repository.getAllNotes()
}