package com.example.hofff.main.mvp.view

import com.arellomobile.mvp.MvpView
import com.example.hofff.main.mvp.model.data.*


interface ViewInfo: View, MvpView {
    fun showDataInfo(list: List<ItemsInfo>)
    fun showDataService(list: List<Services>?)

    fun showContent()

    fun showTopOrderInfo()

    fun showDeliveryTime(deliveryTime: DeliveryTime)

    fun showAddress(address: String)

    fun showOtherCenterInfo(itemsInfo:BaseInfo)

    fun showOrderSum(amount: Amount)
    fun onStop()


}