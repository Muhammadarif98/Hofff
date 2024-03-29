package com.example.hofff.main.presentation.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.hofff.R
import com.example.hofff.main.presentation.HoffApp
import com.example.hofff.main.presentation.Screen
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppNavigator
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private val navigator = AppNavigator(this, R.id.fragment_container)

    @Inject
    lateinit var navHolder: NavigatorHolder

    @Inject
    lateinit var router: Router

    override fun onCreate(savedInstanceState: Bundle?) {

        HoffApp.INSTANCE.appComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        router.navigateTo(Screen.orderScreen())
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navHolder.removeNavigator()
        super.onPause()
    }

    fun uTitle(title: String) {
        supportActionBar?.title = title
    }
}