package com.example.cinemashift2025

import android.app.Application
import com.example.cinemashift2025.addiche.di.afficheModule
import com.example.cinemashift2025.di.networkModule
import com.example.cinemashift2025.filmdetails.di.filmDetailsModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MainApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(level = Level.DEBUG)
            androidContext(this@MainApplication)
            modules(
                networkModule,
                afficheModule,
                filmDetailsModule,
            )
        }
    }
}