package com.joenjogu.notesy.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.joenjogu.notesy.models.Forecast

@Dao
interface WeatherDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertForecast(forecast: List<Forecast>): List<Long>

    @Query("DELETE FROM Forecast")
    suspend fun deleteAll(): Int

    @Query("SELECT * FROM Forecast")
    fun getForecast(): LiveData<List<Forecast>>
}
