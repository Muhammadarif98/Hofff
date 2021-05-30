package com.example.hofff.main

import android.app.Application
import com.example.hofff.main.dagger.AppComponent
import com.example.hofff.main.dagger.DaggerAppComponent


class HoffApp : Application() {

    val appComponent : AppComponent = DaggerAppComponent.create()


    override fun onCreate() {
        INSTANCE = this
        super.onCreate()

    }

    companion object {
        lateinit var INSTANCE : HoffApp
            private set
    }


}