package com.example.hofff.main.mvp.presenter

import com.example.hofff.main.mvp.model.interactors.OrderInteractor
import com.example.hofff.main.mvp.view.ViewOrder
import javax.inject.Inject

class PresenterOrder @Inject constructor(private val interactor: OrderInteractor) :
    Presenter<ViewOrder>() {

    fun loadOrders() {
        subscriptions.add(
            interactor.getBase()
                ?.doOnSuccess { items -> viewState.showData(items) }
                ?.doOnError { e ->
                    e.printStackTrace()
//                    viewState.showError(e.message ?: "Unknown Error")
                }
                ?.subscribe()
        )
    }

//    override fun onStop() {
//        if (!mDisposable!!.isDisposed) {
//            mDisposable!!.dispose()
//        }
//    }
}