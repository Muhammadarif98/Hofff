package com.example.hofff.main.presentation.presenter

import com.arellomobile.mvp.InjectViewState
import com.example.hofff.main.domain.model.BaseInfo
import com.example.hofff.main.domain.interactors.InfoInteractor
import com.example.hofff.main.presentation.view.ViewInfo
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject

@InjectViewState
class PresenterInfo @Inject constructor(private val interactor: InfoInteractor) :
    Presenter<ViewInfo>() {

    fun loadOrderInfo(
        itemsId: String, page: Int,
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
    ) {
        subscriptions.add(
            interactor.getBaseInfo(
                itemsId, page, limit,
                device_id, isAndroid, isGooglePayEnabled,
                isSamsungPayEnabled, isAvailableSberPay,
                app_version, token, location, xhoff
            )
                .subscribeBy(
                    onSuccess = { orderInfo ->
                        showOrderInfo(orderInfo)
                    },
                    onError = {
                        viewState.showError("Error")
                    }
                )
        )
    }

    private fun showOrderInfo(baseInfo: BaseInfo) {
        viewState.showInfoTwo()
        viewState.showStatus()
        viewState.showAddress(baseInfo.address)
        viewState.showInfo(baseInfo)
        viewState.showSum(baseInfo.amount)
        viewState.showDataService(baseInfo.services)
        viewState.showDataInfo(baseInfo.itemsInfo)
    }

}