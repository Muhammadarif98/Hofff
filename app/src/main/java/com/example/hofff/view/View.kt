package com.example.hofff.view

import Items
import ItemsInfo


interface View {
    fun showData(list: List<Items>?)
    fun showDataInfo(list: List<ItemsInfo>?)
    fun showError(error: String?)
    fun showProgress(): Boolean
    fun hideProgress(): Boolean
}