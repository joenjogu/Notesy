package com.joenjogu.notesy.di

import com.joenjogu.notesy.data.WeatherRepository
import org.koin.dsl.module

val weatherRepositoryModule = module {
    single {
        WeatherRepository(weatherService = get(), dao = get())
    }
}
