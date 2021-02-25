package com.joenjogu.notesy.data

import android.accounts.NetworkErrorException
import com.joenjogu.notesy.API_KEY
import com.joenjogu.notesy.NAIROBI_CITY_ID
import java.io.IOException

class WeatherRepository(private val weatherService: WeatherService, private val dao: WeatherDao) {

    val forecast = dao.getWeather()

    suspend fun getForecast() {
        try {
            val weatherForecast = weatherService.getThreeDayForecast(NAIROBI_CITY_ID, 3, API_KEY)
            dao.insertWeather(weatherForecast)
        }
        catch (exception : IOException){}
        catch (exception: NetworkErrorException) {}
    }
}