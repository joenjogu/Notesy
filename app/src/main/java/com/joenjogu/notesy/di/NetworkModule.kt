package com.joenjogu.notesy.di

import com.joenjogu.notesy.data.WeatherService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val networkModule = module {

    single { provideOkHttpClient() }
    single { provideRetrofit(client = get(), url = "https://api.openweathermap.org/data/2.5/") }
    single { provideNoteService(retrofit = get()) }
}

private fun provideOkHttpClient(): OkHttpClient {
    val httpLoggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    return OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()
}

private fun provideRetrofit(client: OkHttpClient, url: String): Retrofit {
    return Retrofit.Builder()
            .baseUrl(url)
            .client(client)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
}

private fun provideNoteService(retrofit: Retrofit): WeatherService {
    return retrofit.create(WeatherService::class.java)
}