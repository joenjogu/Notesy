package com.joenjogu.notesy.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(primaryKeys = ["lat", "lon"])
data class WeatherResponse(
        val daily: List<Daily>,
        val lat: Double,
        val lon: Double,
        val timezone: String,
        val timezone_offset: Int
)