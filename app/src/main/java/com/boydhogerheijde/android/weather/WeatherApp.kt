package com.boydhogerheijde.android.weather

import android.app.Application

/**
 * @author Boyd Hogerheijde.
 */
class WeatherApp : Application() {

    companion object {
        lateinit var instance: Application
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}