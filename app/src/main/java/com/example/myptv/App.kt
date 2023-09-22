package com.example.myptv

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
import com.example.myptv.di.appModule
import com.example.myptv.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        MultiDex.install(this)

        startKoin {
            androidContext(this@App)
            modules(listOf(appModule, networkModule))
        }
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }
}