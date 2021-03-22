package com.joenjogu.notesy.models

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName
import com.joenjogu.notesy.data.Converters

@Entity(primaryKeys = ["lat", "lon"])
@TypeConverters(Converters::class)
data class WeatherResponse(
        @TypeConverters(Converters::class)
        // TODO add serialized names from api to remove bug
        @SerializedName("daily")
        val daily: List<Daily>,
        var lat: Double,
        var lon: Double,
        var timezone: String,
        var timezone_offset: Int
)