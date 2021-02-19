package com.joenjogu.notesy

import android.app.Application
import com.joenjogu.notesy.di.databaseModule
import com.joenjogu.notesy.di.repositoryModule
import com.joenjogu.notesy.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class NotesyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@NotesyApplication)
            modules(
                    databaseModule,
                    viewModelModule,
                    repositoryModule,
            )
        }
    }
}