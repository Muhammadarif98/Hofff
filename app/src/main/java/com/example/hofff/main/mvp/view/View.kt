package com.example.hofff.view

import com.example.hofff.main.mvp.model.data.Items
import com.example.hofff.main.mvp.model.data.ItemsInfo
import com.example.hofff.main.mvp.model.data.Services


interface View {
    fun showData(list: List<Items>)
    fun showDataInfo(list: List<ItemsInfo>)
    fun showDataService(list: List<Services>?)
    fun showError(error: String?)
    fun showProgress(): Boolean
    fun hideProgress(): Boolean
}