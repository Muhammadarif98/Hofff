package com.example.hofff.main.dagger.module

import com.example.hofff.main.data.repository.ModelInfo
import com.example.hofff.main.domain.repositoryIm.ImodelInfo
import com.example.hofff.main.data.retrofitService.RestService
import dagger.Module
import dagger.Provides
@Module
class InfoModule {
    @Provides
    fun provideModelInfo(apiService: RestService): ImodelInfo =
        ModelInfo(apiService)
}