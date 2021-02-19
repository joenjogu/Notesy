package com.joenjogu.notesy.data

import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {

    @GET
    suspend fun getThreeDayForecast(
            @Query("cityID") cityId: String,
            @Query("cnt") dayCount: Int,
            @Query("API key") apiKey: String
    )
}