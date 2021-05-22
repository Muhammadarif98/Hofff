package com.example.hofff.model.network

import Base
import BaseInfo
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET

interface RestService {

    @GET("order_list_ax?limit=20&page=1&device_id=8bba9f1d60af567d&isAndroid=true&isGooglePayEnabled=1&isSamsungPayEnabled=0&isAvailableSberPay=1&app_version=1.8.43&token=6c7ca481dbe77350a488c45f0615e5fd&location=19&xhoff=1018ce077ce6613911d3814c4eb6f464a781b045%3A3789")
    fun getItem(): Single<Response<Base?>?>?

    @GET("order_info_ax?order_id=4or43mrykg&page=0&limit=20&device_id=8bba9f1d60af567d&isAndroid=true&isGooglePayEnabled=1&isSamsungPayEnabled=0&isAvailableSberPay=1&app_version=1.8.43&token=6c7ca481dbe77350a488c45f0615e5fd&location=19&xhoff=1ff0920a11e950e0e7c265f9bd35287e44558d23%3A8335")
    fun getItemInfo(): Single<Response<BaseInfo?>?>?
}