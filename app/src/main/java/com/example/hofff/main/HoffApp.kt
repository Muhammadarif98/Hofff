package com.example.hofff.main

import android.app.Application
import com.example.hofff.main.dagger.ApplicationComponent
import com.example.hofff.main.dagger.DaggerApplicationComponent

import com.github.terrakok.cicerone.Cicerone



class HoffApp : Application() {


  val appComponent : ApplicationComponent = DaggerApplicationComponent.create()

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
    }

    companion object {
        lateinit var INSTANCE: HoffApp
        private set
    }

}