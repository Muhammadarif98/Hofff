package com.example.hofff.main.mvp.model.repository

import com.example.hofff.main.mvp.model.data.Items
import com.example.hofff.main.mvp.model.mapper.ItemsMapper
import com.example.hofff.main.mvp.model.repositoryIm.ImodelOrder
import com.example.hofff.main.mvp.model.network.RestService
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ModelOrder @Inject constructor(
    private val mRestService: RestService,
    private val itemsMapper: ItemsMapper,
) : ImodelOrder {


    override fun getBase(): Single<List<Items>> =
        mRestService.getItem()
            .map {
                itemsMapper.map(it)
            }
            .subscribeOn(Schedulers.io())


}