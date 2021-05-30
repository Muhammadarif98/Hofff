package com.example.hofff.main.mvp.model.repository

import com.example.hofff.main.mvp.model.data.BaseInfo
import com.example.hofff.main.mvp.model.repositoryIm.ImodelInfo
import com.example.hofff.main.mvp.model.network.RestService
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

class ModelInfo(private val mRestService: RestService) : ImodelInfo {


    override fun getBaseInfo(id: String): Single<BaseInfo> {
        return mRestService.getItemInfo(id)
            .subscribeOn(Schedulers.io())


    }

}