package com.example.hofff.view

import Items


interface View {
    fun showData(list: List<Items>?)
    fun showError(error: String?)
}