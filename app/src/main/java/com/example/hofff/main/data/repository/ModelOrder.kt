package com.example.hofff.main.data.repository

import com.example.hofff.main.domain.model.Items
import com.example.hofff.main.data.mapper.ItemsMapper
import com.example.hofff.main.domain.repositoryIm.ImodelOrder
import com.example.hofff.main.data.retrofitService.RestService
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ModelOrder @Inject constructor(
    private val mRestService: RestService,
    private val itemsMapper: ItemsMapper,
) : ImodelOrder {

    override fun getBase(
        limit : Int,
        page : Int,
        device_id: String,
        isAndroid: Boolean,
        isGooglePayEnabled: Int,
        isSamsungPayEnabled: Int,
        isAvailableSberPay: Int,
        app_version: String,
        token: String,
        location :Int,
        xhoff: String
    ): Single<List<Items>> =
        mRestService.getItem(limit,page, device_id, isAndroid,
            isGooglePayEnabled, isSamsungPayEnabled,
            isAvailableSberPay, app_version, token, location, xhoff)
            .map {
                itemsMapper.map(it)
            }
            .subscribeOn(Schedulers.io())

}