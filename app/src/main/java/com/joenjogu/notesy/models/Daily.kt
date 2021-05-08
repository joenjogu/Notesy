package com.joenjogu.notesy.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Daily(
    @PrimaryKey
    val dt: Int,
    val temp: Temp,
    val weather: List<Weather>
)
