package com.example.hofff.main.dagger.module


import com.example.hofff.main.mvp.model.repository.ModelOrder
import com.example.hofff.main.mvp.model.repositoryIm.ImodelOrder
import dagger.Binds
import dagger.Module

@Module
abstract class OrdersModule {

    @Binds
    abstract fun provideModuleOrder(repositoryImpl: ModelOrder): ImodelOrder
}