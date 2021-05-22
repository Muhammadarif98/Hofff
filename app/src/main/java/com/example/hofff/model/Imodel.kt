package com.example.hofff.model

import Base
import BaseInfo
import io.reactivex.Single
import retrofit2.Response

interface Imodel {
    fun getBase(): Single<Response<Base?>?>?
    fun getBaseInfo(): Single<Response<BaseInfo?>?>?
}