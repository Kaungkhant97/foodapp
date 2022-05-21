package com.interview.fatsecret.util

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class FoodApp : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}