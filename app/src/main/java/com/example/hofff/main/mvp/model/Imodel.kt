package com.example.hofff.model

import com.example.hofff.main.mvp.model.data.Base
import com.example.hofff.main.mvp.model.data.BaseInfo
import io.reactivex.Single
import retrofit2.Response

interface Imodel {
    fun getBase(): Single<Response<Base?>?>?
    fun getBaseInfo(): Single<Response<BaseInfo?>?>?
}