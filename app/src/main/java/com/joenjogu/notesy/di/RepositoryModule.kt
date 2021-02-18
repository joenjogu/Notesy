package com.joenjogu.notesy.di

import com.joenjogu.notesy.data.Repository
import org.koin.dsl.module

val repositoryModule = module {
        single {
            Repository(
                noteDao = get()
            )
        }
}