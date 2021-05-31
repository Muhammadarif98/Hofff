package com.example.hofff.main.data.retrofitService

import com.example.hofff.main.domain.model.BaseInfo
import com.example.hofff.main.data.models.ItemsNet
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface RestService {

    @GET("order_list_ax?")
    fun getItem( @Query("limit") limit :Int,
                 @Query("page") page :Int,
                 @Query("device_id") device_id :String,
                 @Query("isAndroid") isAndroid :Boolean,
                 @Query("isGooglePayEnabled") isGooglePayEnabled :Int,
                 @Query("isSamsungPayEnabled") isSamsungPayEnabled :Int,
                 @Query("isAvailableSberPay") isAvailableSberPay :Int,
                 @Query("app_version") app_version :String,
                 @Query("token") token :String,
                 @Query("location") location :Int,
                 @Query("xhoff") xhoff :String): Single<ItemsNet>

    @GET("order_info_ax?")
    fun getItemInfo(@Query("order_id") orderId: String,
                    @Query("page") page :Int,
                    @Query("limit") limit :Int,
                    @Query("device_id") device_id :String,
                    @Query("isAndroid") isAndroid :Boolean,
                    @Query("isGooglePayEnabled") isGooglePayEnabled :Int,
                    @Query("isSamsungPayEnabled") isSamsungPayEnabled :Int,
                    @Query("isAvailableSberPay") isAvailableSberPay :Int,
                    @Query("app_version") app_version :String,
                    @Query("token") token :String,
                    @Query("location") location :Int,
                    @Query("xhoff") xhoff :String): Single<BaseInfo>
}

