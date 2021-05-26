package com.example.hofff.main.dagger

import com.example.hofff.main.dagger.module.LocalNavigationModule
import com.example.hofff.main.dagger.module.NavigationModule
import com.example.hofff.main.mvp.view.fragments.InfoFragment

import com.example.hofff.main.mvp.view.fragments.OrderFragment
import com.example.hofff.view.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    NavigationModule::class,
    LocalNavigationModule::class]
)
interface ApplicationComponent {

    fun inject(mainActivity: MainActivity)

    fun inject(orderFragment: OrderFragment)

    fun inject(infoFragment: InfoFragment)
}