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
                       // viewState.showError("Error")
                    }

                )
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