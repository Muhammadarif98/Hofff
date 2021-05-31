package com.example.hofff.main.domain.repositoryIm

import com.example.hofff.main.domain.model.BaseInfo
import io.reactivex.Single

interface ImodelInfo {
    fun getBaseInfo(
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
        location: Int,
        xhoff: String
    ): Single<BaseInfo>
}