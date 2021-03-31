package com.joenjogu.notesy.data

import android.accounts.NetworkErrorException
import android.util.Log
import com.joenjogu.notesy.API_KEY
import com.joenjogu.notesy.NAIROBI_CITY_LAT
import com.joenjogu.notesy.NAIROBI_CITY_LONG
import com.joenjogu.notesy.models.Forecast
import java.io.IOException

class WeatherRepository(private val weatherService: WeatherService, private val dao: WeatherDao) {

    val forecast = dao.getForecast()

    suspend fun getWeatherResponse() {
        try {
            val weatherResponse = weatherService.getDailyForecast(
                    NAIROBI_CITY_LAT,
                    NAIROBI_CITY_LONG,
                    "current,hourly,minutely",
                    "metric",
                    API_KEY)
            Log.d(TAG, "getWeatherResponse: $weatherResponse")

            val daily = weatherResponse.daily
            Log.d(TAG, "getWeatherResponse: $daily")
            val forecastList = mutableListOf<Forecast>()
            daily.forEach { day ->
                val forecastResponse = Forecast(
                        day.dt,
                        day.temp.day,
                        day.weather[0].description,
                        day.weather[0].icon
                )
                forecastList.add(forecastResponse)
            }
            Log.d(TAG, "getWeatherResponse: $forecastList")
            val deleted = dao.deleteAll()
            Log.d(TAG, "getWeatherResponse: $deleted")
            val inserted = dao.insertForecast(forecastList)
            Log.d(TAG, "getWeatherResponse: $inserted")
        }
        catch (exception : IOException){
            Log.d(TAG, "getForecast: $exception")
        }
        catch (exception: NetworkErrorException) {
            Log.d(TAG, "getForecast: $exception")
        }
    }

    companion object {
        val TAG: String = this::class.java.name
    }
}