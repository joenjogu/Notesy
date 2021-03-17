package com.joenjogu.notesy.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.joenjogu.notesy.data.Converters

@Entity(primaryKeys = ["lat", "lon"])
data class WeatherResponse(
        @TypeConverters(Converters::class)
        val daily: List<Daily>,
        val lat: Double,
        val lon: Double,
        val timezone: String,
        val timezone_offset: Int
)