package com.example.hofff.main.mvp.presenter

import com.example.hofff.main.mvp.model.data.BaseInfo
import com.example.hofff.main.mvp.model.interactors.InfoInteractor
import com.example.hofff.main.mvp.view.ViewInfo
import javax.inject.Inject

class PresenterInfo @Inject constructor(private val interactor: InfoInteractor): Presenter<ViewInfo>() {

    fun loadOrderInfo(itemsId: String) {

        subscriptions.add(
            interactor.getBaseInfo(itemsId)

                ?.doOnSuccess { orderInfo ->
                    showOrderInfo(orderInfo)
                }
                ?.doOnError { e ->
                    //viewState.showError(e.message ?: "Unknown error")
                }
                ?.subscribe()
        )
    }

    private fun showOrderInfo(baseInfo: BaseInfo) {
        viewState.showContent()

        viewState.showTopOrderInfo()

        viewState.showDeliveryTime(baseInfo.deliveryTime)

        viewState.showAddress(baseInfo.address)

        viewState.showOtherCenterInfo(baseInfo)

        viewState.showOrderSum(baseInfo.amount)

        viewState.showDataService(baseInfo.services)

        viewState.showDataInfo(baseInfo.itemsInfo)
    }

//    override fun onStop() {
//        if (!mDisposable!!.isDisposed) {
//            mDisposable!!.dispose()
//        }
//    }
}