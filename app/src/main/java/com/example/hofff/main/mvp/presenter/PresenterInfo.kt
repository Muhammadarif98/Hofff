package com.example.hofff.main.mvp.presenter

import com.arellomobile.mvp.InjectViewState
import com.example.hofff.main.mvp.model.data.BaseInfo
import com.example.hofff.main.mvp.model.interactors.InfoInteractor
import com.example.hofff.main.mvp.view.ViewInfo
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject

@InjectViewState
class PresenterInfo @Inject constructor(private val interactor: InfoInteractor) :
    Presenter<ViewInfo>() {

    fun loadOrderInfo(itemsId: String) {

        subscriptions.add(
            interactor.getBaseInfo(itemsId)
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