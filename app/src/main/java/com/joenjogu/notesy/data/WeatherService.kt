package com.joenjogu.notesy.data

import com.joenjogu.notesy.models.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {

    @GET("onecall")
    suspend fun getDailyForecast(
            @Query("lat") latitude: Double,
            @Query("lon") longitude: Double,
            @Query("exclude") exclude: String,
            @Query("API key") apiKey: String
    ): WeatherResponse
}