package com.example.hofff.main.mvp.model.interactors


import com.example.hofff.main.mvp.model.repositoryIm.ImodelInfo
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

class InfoInteractor @Inject constructor(private val repository: ImodelInfo) {

    fun getBaseInfo(id: String) =
        repository.getBaseInfo(id)
            .observeOn(AndroidSchedulers.mainThread())
}