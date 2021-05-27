package com.example.hofff.main.dagger.module

import com.example.hofff.main.mvp.model.repository.ModelInfo
import com.example.hofff.main.mvp.model.repositoryIm.ImodelInfo
import com.example.hofff.main.mvp.model.network.RestService
import dagger.Module
import dagger.Provides

@Module
class InfoModule {

    @Provides
    fun provideModelInfo(apiService: RestService): ImodelInfo =
        ModelInfo(apiService)
}