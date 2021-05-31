package com.example.hofff.main.presentation.view

import com.arellomobile.mvp.MvpView
import com.example.hofff.main.domain.model.*

interface ViewInfo : View, MvpView {
    fun showDataInfo(list: List<ItemsInfo>)
    fun showDataService(list: List<Services>?)
    fun showInfoTwo()
    fun showStatus()
    fun showAddress(address: String)
    fun showInfo(itemsInfo: BaseInfo)
    fun showSum(amount: Amount)
    fun onStop()
}