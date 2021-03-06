package com.joenjogu.notesy.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.joenjogu.notesy.data.WeatherRepository
import com.joenjogu.notesy.models.Forecast

class BannerViewModel(val repository: WeatherRepository) : ViewModel(){

    //TODO move to homefrag viewmodel
    fun getThreeDayForecast(): LiveData<List<Forecast>> {
        return repository.forecast
    }
}