package com.joenjogu.notesy

import com.joenjogu.notesy.models.Forecast
import com.joenjogu.notesy.models.Temp
import com.joenjogu.notesy.models.Weather
import com.joenjogu.notesy.models.WeatherResponse

const val NAIROBI_CITY_LAT = -1.28333
const val NAIROBI_CITY_LONG = 36.816669
const val API_KEY = "e33c780968e0596428b360e55c69db6d"

fun WeatherResponse.toDomain(): Forecast {
    return Forecast(
        25.6,
            "Clear"
    )
}

fun Temp.toDomain(): Double {
    return this.day
}

fun Weather.toDomain(): String {
    return this.main
}