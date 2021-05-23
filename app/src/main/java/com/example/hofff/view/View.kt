package com.example.hofff.view

import Items
import ItemsInfo
import Services


interface View {
    fun showData(list: List<Items>?)
    fun showDataInfo(list: List<ItemsInfo>?)
    fun showDataService(list: List<Services>?)
    fun showError(error: String?)
    fun showProgress(): Boolean
    fun hideProgress(): Boolean
}