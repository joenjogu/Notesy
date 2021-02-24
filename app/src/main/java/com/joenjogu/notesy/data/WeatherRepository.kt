package com.joenjogu.notesy.data

class WeatherRepository(private val weatherService: WeatherService, private val dao: WeatherDao) {

    val forecast = dao.getWeather()

    try {

    }
}