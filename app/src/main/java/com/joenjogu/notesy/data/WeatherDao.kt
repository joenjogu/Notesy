package com.joenjogu.notesy.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.joenjogu.notesy.WeatherResponse

@Dao
interface WeatherDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertWeather(weatherResponse: WeatherResponse)

    @Query("")
    fun getWeather(): WeatherResponse
}