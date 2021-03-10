package com.joenjogu.notesy.models

import java.util.*

data class Forecast(
        val date: Int,
        val temperature: Double,
        val weather: String,
        val iconUrl: String
)
