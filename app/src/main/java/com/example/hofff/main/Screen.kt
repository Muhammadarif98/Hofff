package com.example.hofff.main


import android.os.Bundle
import com.example.hofff.main.mvp.view.fragments.InfoFragment
import com.example.hofff.main.mvp.view.fragments.OrderFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screen {
    fun orderScreen() = FragmentScreen { OrderFragment() }

    fun infoScreen(bundle: Bundle) = FragmentScreen {
        InfoFragment().apply {
            arguments = bundle
        }
    }

}