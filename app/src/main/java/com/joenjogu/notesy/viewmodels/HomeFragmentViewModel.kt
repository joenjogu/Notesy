package com.joenjogu.notesy.viewmodels

import androidx.lifecycle.ViewModel
import com.joenjogu.notesy.data.Repository
import com.joenjogu.notesy.data.WeatherRepository

class HomeFragmentViewModel(repository: Repository, weatherRepository: WeatherRepository) : ViewModel() {

    val notes = repository.getAllNotes()
    val forecast = weatherRepository.forecast
}