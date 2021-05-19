package com.example.hofff.presenter

import Base
import android.util.Log
import com.example.hofff.model.Imodel
import com.example.hofff.model.Model
import com.example.hofff.view.View
import io.reactivex.disposables.Disposable
import retrofit2.Response

class Presenter(private val mView: View) :Ipresenter{

    private val model: Imodel = Model()
    private var mDisposable: Disposable? = null
    override fun loadData() {
        mDisposable = model.getBase()
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

    override fun onStop() {
        if (!mDisposable!!.isDisposed) {
            mDisposable!!.dispose()
        }
    }
}