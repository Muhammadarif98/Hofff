package com.example.hofff.presenter

import Base
import BaseInfo
import android.util.Log
import com.example.hofff.model.Imodel
import com.example.hofff.model.Model
import com.example.hofff.view.View
import io.reactivex.disposables.Disposable
import retrofit2.Response

class Presenter(private val mView: View) :Ipresenter{

    private val model: Imodel = Model()
    private var mDisposable: Disposable? = null
    private var mDisposableInfo: Disposable? = null
    override fun loadData() {
        mDisposable = model.getBase()
            ?.doOnSubscribe { disposable: Disposable? -> mView.showProgress() }
            ?.doAfterSuccess { exampleResponse: Response<Base?>? -> mView.hideProgress() }
            ?.subscribe({ response: Response<Base?> ->
            if (response.isSuccessful && response.body() != null) {
                val body = response.body()
                mView.showData(body!!.items)
            }
            } as ((Response<Base?>?) -> Unit)?) { e: Throwable ->
            mView.showError("Упс! Что то пошло не так")
            Log.d("TAG", "onError =$e")
        }
    }

    override fun loadDataInfo() {
        mDisposableInfo= model.getBaseInfo()
            ?.doOnSubscribe { disposable: Disposable? -> mView.showProgress() }
            ?.doAfterSuccess { exampleResponse: Response<BaseInfo?>? -> mView.hideProgress() }
            ?.subscribe({ response: Response<BaseInfo?> ->
                if (response.isSuccessful && response.body() != null) {
                    val body = response.body()
                    mView.showDataInfo(body!!.itemsInfo)
                }
            } as ((Response<BaseInfo?>?) -> Unit)?) { e: Throwable ->
                mView.showError("Упс! Что то пошло не так")
                Log.d("TAG2", "onError =$e")
            }
    }

    override fun onStop() {
        if (!mDisposable!!.isDisposed) {
            mDisposable!!.dispose()
        }
    }
}