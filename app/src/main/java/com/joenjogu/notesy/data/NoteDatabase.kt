package com.joenjogu.notesy.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.joenjogu.notesy.models.Forecast
import com.joenjogu.notesy.models.Note
import com.joenjogu.notesy.models.Weather
import com.joenjogu.notesy.models.WeatherResponse
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized

@Database(entities = [Note::class, WeatherResponse::class, Forecast::class], version = 2, exportSchema = false)
abstract class NoteDatabase : RoomDatabase(){

    abstract val noteDao: NoteDao
    abstract val weatherDao: WeatherDao
}