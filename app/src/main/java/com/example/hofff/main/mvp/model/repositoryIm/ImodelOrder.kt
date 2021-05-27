package com.example.hofff.main.mvp.model.repositoryIm

import com.example.hofff.main.mvp.model.data.Base
import com.example.hofff.main.mvp.model.data.BaseInfo
import com.example.hofff.main.mvp.model.data.Items
import io.reactivex.Single
import retrofit2.Response

interface ImodelOrder {
    fun getBase(): Single<List<Items>>?

}