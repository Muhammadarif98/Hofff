package com.example.hofff.main.dagger.module

import com.example.hofff.main.data.repository.ModelOrder
import com.example.hofff.main.domain.repositoryIm.ImodelOrder
import dagger.Binds
import dagger.Module
@Module
abstract class OrdersModule {
    @Binds
    abstract fun provideModuleOrder(repositoryImpl: ModelOrder): ImodelOrder
}