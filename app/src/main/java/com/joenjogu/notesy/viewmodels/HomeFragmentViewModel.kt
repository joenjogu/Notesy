package com.joenjogu.notesy.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.joenjogu.notesy.data.Repository
import com.joenjogu.notesy.data.WeatherRepository
import kotlinx.coroutines.launch

class HomeFragmentViewModel(repository: Repository, val weatherRepository: WeatherRepository) : ViewModel() {

    val notes = repository.getAllNotes()
    val forecast = weatherRepository.forecast

    init {
        getWeatherResponse()
    }

    private fun getWeatherResponse() {
        viewModelScope.launch {
            weatherRepository.getWeatherResponse()
            Log.d("ViewModel", "getWeatherResponse: Fetching Weather Response")
        }
    }
}