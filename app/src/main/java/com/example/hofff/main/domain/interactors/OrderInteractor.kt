package com.example.hofff.main.domain.interactors

import com.example.hofff.main.domain.repositoryIm.ImodelOrder
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

class OrderInteractor @Inject constructor(private val repository: ImodelOrder) {
    fun getBase(
        limit: Int,
        page: Int, device_id: String,
        isAndroid: Boolean,
        isGooglePayEnabled: Int,
        isSamsungPayEnabled: Int,
        isAvailableSberPay: Int,
        app_version: String,
        token: String,
        location: Int,
        xhoff: String
    ) = repository.getBase(
        limit, page, device_id, isAndroid,
        isGooglePayEnabled, isSamsungPayEnabled,
        isAvailableSberPay, app_version, token, location, xhoff
    )
        .observeOn(AndroidSchedulers.mainThread())
}