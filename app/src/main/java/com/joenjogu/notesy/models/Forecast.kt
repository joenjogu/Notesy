package com.joenjogu.notesy.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Forecast(
    @PrimaryKey
    val date: Int,
    val temperature: Double,
    val weather: String,
    val iconUrl: String
)
