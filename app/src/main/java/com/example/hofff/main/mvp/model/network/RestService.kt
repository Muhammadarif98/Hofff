package com.example.hofff.main.mvp.model.network

import com.example.hofff.main.mvp.model.data.BaseInfo
import com.example.hofff.main.mvp.model.mapper.models.ItemsNet
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query


interface RestService {

    @GET("order_list_ax?limit=20&page=1&device_id=43420881b672be1d&isAndroid=true&isGooglePayEnabled=1&isSamsungPayEnabled=0&isAvailableSberPay=0&app_version=1.8.43&token=d25ea6c66b30bd4e645f9c03084a8554&location=19&xhoff=5ef970f096b9905a25f67ea46ebc80228594a19a%3A4801")
    fun getItem(): Single<ItemsNet>

    @GET("order_info_ax?page=0&limit=20&device_id=8bba9f1d60af567d&isAndroid=true&isGooglePayEnabled=1&isSamsungPayEnabled=0&isAvailableSberPay=1&app_version=1.8.43&token=6c7ca481dbe77350a488c45f0615e5fd&location=19&xhoff=1ff0920a11e950e0e7c265f9bd35287e44558d23%3A8335")
    fun getItemInfo(@Query("order_id") orderId: String): Single<BaseInfo>
}