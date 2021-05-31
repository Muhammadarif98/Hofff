package com.example.hofff.main.dagger

import com.example.hofff.main.dagger.module.*
import com.example.hofff.main.presentation.fragments.InfoFragment
import com.example.hofff.main.presentation.fragments.OrderFragment
import com.example.hofff.main.presentation.activities.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        NavigationModule::class,
        InfoModule::class,
        OrdersModule::class,
        NetworkApiModule::class,
        LocalNavigationModule::class]
)
interface AppComponent {

    fun inject(orderFragment: OrderFragment)

    fun inject(infoFragment: InfoFragment)

    fun inject(mainActivity: MainActivity)
}
