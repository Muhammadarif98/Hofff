package com.example.hofff.main.mvp.view

import com.arellomobile.mvp.MvpView
import com.example.hofff.main.mvp.model.data.*


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