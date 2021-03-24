package com.joenjogu.notesy.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.joenjogu.notesy.models.Forecast
import com.joenjogu.notesy.models.WeatherResponse

@Dao
interface WeatherDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertForecast(forecast: List<Forecast>)

    @Query("SELECT * FROM Forecast")
    fun getForecast(): LiveData<List<Forecast>>

}