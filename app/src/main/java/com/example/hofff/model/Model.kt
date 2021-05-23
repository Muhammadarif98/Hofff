package com.example.hofff.model

import Base
import BaseInfo
import com.example.hofff.model.network.ApiService
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Response

class Model : Imodel{
    var mRestService = ApiService.instance?.jsonApi
    override fun getBase(): Single<Response<Base?>?>? {
         return mRestService?.getItem()
             ?.subscribeOn(Schedulers.io())
             ?.observeOn(AndroidSchedulers.mainThread())
    }

    override fun getBaseInfo(): Single<Response<BaseInfo?>?>? {
        return mRestService?.getItemInfo()
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())

    }

}