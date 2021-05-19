package com.example.hofff.model

import Base
import io.reactivex.Single
import retrofit2.Response

interface Imodel {
    fun getBase(): Single<Response<Base?>?>?
}