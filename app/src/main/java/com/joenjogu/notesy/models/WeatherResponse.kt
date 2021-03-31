package com.joenjogu.notesy.models

import androidx.room.Ignore
import com.google.gson.annotations.SerializedName

data class WeatherResponse(
        @SerializedName("daily")
        @Ignore
        val daily: List<Daily>,
        var lat: Double,
        var lon: Double,
        var timezone: String,
        var timezone_offset: Int
)