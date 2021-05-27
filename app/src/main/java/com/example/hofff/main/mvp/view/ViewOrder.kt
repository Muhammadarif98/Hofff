package com.example.hofff.main.mvp.view

import com.arellomobile.mvp.MvpView
import com.example.hofff.main.mvp.model.data.Items


interface ViewOrder : View, MvpView{

    fun showData(list:List< Items>)
    fun onStop()


}