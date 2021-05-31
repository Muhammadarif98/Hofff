package com.example.hofff.main.presentation.view

import com.arellomobile.mvp.MvpView
import com.example.hofff.main.domain.model.Items

interface ViewOrder : View, MvpView {
    fun showData(list: List<Items>)
}