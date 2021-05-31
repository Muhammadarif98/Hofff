package com.example.hofff.main.data.repository

import com.example.hofff.main.domain.model.BaseInfo
import com.example.hofff.main.domain.repositoryIm.ImodelInfo
import com.example.hofff.main.data.retrofitService.RestService
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

class ModelInfo(private val mRestService: RestService) : ImodelInfo {

    override fun getBaseInfo(
        id: String,
        page: Int,
        limit: Int,
        device_id: String,
        isAndroid: Boolean,
        isGooglePayEnabled: Int,
        isSamsungPayEnabled: Int,
        isAvailableSberPay: Int,
        app_version: String,
        token: String,
        location :Int,
        xhoff: String
    ): Single<BaseInfo> {
        return mRestService.getItemInfo(id, page, limit,
            device_id, isAndroid, isGooglePayEnabled,
            isSamsungPayEnabled, isAvailableSberPay,
            app_version, token, location, xhoff)
            .subscribeOn(Schedulers.io())
    }
}