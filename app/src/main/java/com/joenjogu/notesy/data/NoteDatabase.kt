package com.joenjogu.notesy.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.joenjogu.notesy.models.Daily
import com.joenjogu.notesy.models.Forecast
import com.joenjogu.notesy.models.Note

@Database(
    entities = [Note::class, Daily::class, Forecast::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class NoteDatabase : RoomDatabase() {

    abstract val noteDao: NoteDao
    abstract val weatherDao: WeatherDao
}
