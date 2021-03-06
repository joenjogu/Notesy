package com.joenjogu.notesy.data

import android.accounts.NetworkErrorException
import android.util.Log
import com.joenjogu.notesy.API_KEY
import com.joenjogu.notesy.NAIROBI_CITY_LAT
import com.joenjogu.notesy.NAIROBI_CITY_LONG
import java.io.IOException

class WeatherRepository(private val weatherService: WeatherService, private val dao: WeatherDao) {

    val forecast = dao.getForecast()

    suspend fun getWeatherResponse() {
        try {
            val weatherResponse = weatherService.getDailyForecast(
                    NAIROBI_CITY_LAT,
                    NAIROBI_CITY_LONG,
                    "current,hourly,minutely",
                    API_KEY)

            //TODO weather response to forecast using utils domain class
            dao.insertWeather(weatherResponse)
        }
        catch (exception : IOException){
            Log.d(TAG, "getForecast: $exception")
            throw exception
        }
        catch (exception: NetworkErrorException) {
            Log.d(TAG, "getForecast: $exception")
            throw exception
        }
    }

    companion object {
        val TAG: String = this::class.java.name
    }
}