package com.joenjogu.notesy.data

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.joenjogu.notesy.models.Daily
import com.joenjogu.notesy.models.Weather
import com.joenjogu.notesy.models.WeatherResponse

class Converters {
    private val gson = Gson()

    @TypeConverter
    fun dailyToString(daily: List<Daily>): String? {
        val dailyType = object : TypeToken<List<Daily>>() {}.type
        return gson.toJson(daily, dailyType)
    }

    @TypeConverter
    fun stringToDaily(json: String): Daily? {
        val dailyType = object : TypeToken<List<Daily>>() {}.type
        return gson.fromJson(json, dailyType)
    }

    /*@TypeConverter
    fun weatherResponseToString(weatherResponse: WeatherResponse): String? {
        return gson.toJson(weatherResponse)
    }

    @TypeConverter
    fun stringToWeatherResponse(json: String): WeatherResponse? {
        return gson.fromJson(json, WeatherResponse::class.java)
    }

    @TypeConverter
    fun weatherToString(weatherList: List<Weather>): String? {
        return gson.toJson(weatherList)
    }

    @TypeConverter
    fun stringToWeather(json: String): Weather? {
        return gson.fromJson(json, Weather::class.java)
    }*/
}