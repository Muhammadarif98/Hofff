package com.example.hofff.main

import android.app.Application
import com.example.hofff.main.dagger.ApplicationComponent
import com.example.hofff.main.dagger.DaggerApplicationComponent


class HoffApp : Application() {

    val appComponent : ApplicationComponent = DaggerApplicationComponent.create()


    override fun onCreate() {
        INSTANCE = this
        super.onCreate()

    }

    companion object {
        lateinit var INSTANCE : HoffApp
            private set
    }


}