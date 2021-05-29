package com.example.hofff.main.mvp.presenter


import com.arellomobile.mvp.InjectViewState
import com.example.hofff.main.mvp.model.interactors.OrderInteractor
import com.example.hofff.main.mvp.view.ViewOrder
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject
@InjectViewState
class PresenterOrder @Inject constructor(private val interactor: OrderInteractor) :
    Presenter<ViewOrder>() {

    fun loadData() {
        subscriptions.add(
            interactor.getBase()
                .subscribeBy(
                    onSuccess = { items ->
                        viewState.showData(items)
                    },
                    onError = {
                        viewState.showError("Error")
                    }

                )
        )
    }

}