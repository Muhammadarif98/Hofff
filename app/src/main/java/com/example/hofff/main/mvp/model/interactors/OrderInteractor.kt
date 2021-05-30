package com.example.hofff.main.mvp.model.interactors

import com.example.hofff.main.mvp.model.repositoryIm.ImodelOrder
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

class OrderInteractor @Inject constructor(private val repository: ImodelOrder) {

    fun getBase() = repository.getBase()
        .observeOn(AndroidSchedulers.mainThread())
}