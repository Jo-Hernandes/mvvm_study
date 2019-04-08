package com.joohernandes.mvvmstudy

import android.app.Application
import com.joohernandes.mvvmstudy.dependencyInjection.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            // Android context
            androidContext(this@MainApplication)
            // modules
            modules(applicationModule + dataSource)
        }
    }
}