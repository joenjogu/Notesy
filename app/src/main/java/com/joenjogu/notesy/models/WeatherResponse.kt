package com.joenjogu.notesy.models

import androidx.room.Entity

@Entity
data class WeatherResponse(
        val daily: List<Daily>,
        val lat: Double,
        val lon: Double,
        val timezone: String,
        val timezone_offset: Int
)