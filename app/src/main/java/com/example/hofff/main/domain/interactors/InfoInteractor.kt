package com.example.hofff.main.domain.interactors

import com.example.hofff.main.domain.repositoryIm.ImodelInfo
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

class InfoInteractor @Inject constructor(private val repository: ImodelInfo) {
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
    ) =
        repository.getBaseInfo(
            id, page, limit,
            device_id, isAndroid, isGooglePayEnabled,
            isSamsungPayEnabled, isAvailableSberPay,
            app_version, token, location, xhoff
        )
            .observeOn(AndroidSchedulers.mainThread())
}