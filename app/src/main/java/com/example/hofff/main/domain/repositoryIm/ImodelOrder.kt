package com.example.hofff.main.domain.repositoryIm

import com.example.hofff.main.domain.model.Items
import io.reactivex.Single

interface ImodelOrder {
    fun getBase(
        limit : Int,
        page : Int,
        device_id :String,
        isAndroid :Boolean,
        isGooglePayEnabled :Int,
        isSamsungPayEnabled :Int,
        isAvailableSberPay :Int,
        app_version :String,
        token :String,
        location :Int,
        xhoff :String): Single<List<Items>>

}