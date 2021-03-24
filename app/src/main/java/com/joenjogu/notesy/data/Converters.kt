package com.joenjogu.notesy.data

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.joenjogu.notesy.models.Temp
import com.joenjogu.notesy.models.Weather

class Converters {

    companion object {
        val gson = Gson()
    }
    @TypeConverter
    fun tempToString(temp: Temp): String {
        return gson.toJson(temp)
    }

    @TypeConverter
    fun stringToTemp(string: String): Temp {
        return gson.fromJson(string, Temp::class.java)
    }

    @TypeConverter
    fun weatherToString(weatherList: List<Weather>): String {
        val weatherType = object : TypeToken<List<Weather>>() {}.type
        return gson.toJson(weatherList, weatherType)
    }

    @TypeConverter
    fun stringToWeather(string: String): List<Weather> {
        val weatherType = object : TypeToken<List<Weather>>() {}.type
        return gson.fromJson(string, weatherType)
    }
}