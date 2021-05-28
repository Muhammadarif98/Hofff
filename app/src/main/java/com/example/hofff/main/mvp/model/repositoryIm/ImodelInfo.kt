package com.example.hofff.main.mvp.model.repositoryIm

import com.example.hofff.main.mvp.model.data.BaseInfo
import io.reactivex.Single
import retrofit2.Response

interface ImodelInfo {
    fun getBaseInfo(id: String): Single<BaseInfo>
}