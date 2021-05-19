package com.example.hofff.model.network

import Base
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET

interface RestService {

    @GET("order_list_ax?limit=20&page=1&device_id=8bba9f1d60af567d&isAndroid=true&isGooglePayEnabled=1&isSamsungPayEnabled=0&isAvailableSberPay=1&app_version=1.8.43&token=6c7ca481dbe77350a488c45f0615e5fd&location=19&xhoff=1018ce077ce6613911d3814c4eb6f464a781b045%3A3789")
    fun getData(): Single<Response<Base?>?>?
}