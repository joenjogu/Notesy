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
                    API_KEY)

            //TODO weather response to forecast using utils domain class
            dao.insertWeather(weatherResponse)

            val daily = weatherResponse.daily
            val forecastList = mutableListOf<Forecast>()
            daily.forEachIndexed { index, day ->
                val forecastResponse = Forecast(
                        day.dt,
                        day.temp.day,
                        day.weather[index].description,
                        day.weather[index].icon
                )
                forecastList.add(forecastResponse)
            }
            dao.insertForecast(forecastList)
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