package com.joenjogu.notesy.di

import com.joenjogu.notesy.viewmodels.HomeFragmentViewModel
import com.joenjogu.notesy.viewmodels.NoteDetailViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        HomeFragmentViewModel(
            repository = get(),
            weatherRepository = get()
        )
    }

    viewModel {
        NoteDetailViewModel(
            repository = get()
        )
    }
}
