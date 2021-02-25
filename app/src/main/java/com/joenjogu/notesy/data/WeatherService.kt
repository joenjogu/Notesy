package com.joenjogu.notesy.data

import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {

    @GET("onecall")
    suspend fun getThreeDayForecast(
            @Query("lat") latitude: String,
            @Query("long") longitude: String,
            @Query("exclude") exclude: String,
            @Query("API key") apiKey: String
    )
}