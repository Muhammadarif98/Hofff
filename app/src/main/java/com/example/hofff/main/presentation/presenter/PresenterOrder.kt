package com.example.hofff.main.presentation.presenter


import com.arellomobile.mvp.InjectViewState
import com.example.hofff.main.domain.interactors.OrderInteractor
import com.example.hofff.main.presentation.view.ViewOrder
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject

@InjectViewState
class PresenterOrder @Inject constructor(private val interactor: OrderInteractor) :
    Presenter<ViewOrder>() {

    fun loadData(
        limit: Int,
        page: Int,
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
            interactor.getBase(
                limit, page,
                device_id, isAndroid,
                isGooglePayEnabled, isSamsungPayEnabled,
                isAvailableSberPay, app_version, token, location, xhoff
            )
                .subscribeBy(
                    onSuccess = { items ->
                        viewState.showData(items)
                    },
                    onError = {
                        viewState.showError("Error, don't found network")
                    }
                )
        )
    }
}