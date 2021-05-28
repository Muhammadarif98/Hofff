package com.example.hofff.main.dagger.module

import com.example.hofff.main.mvp.model.network.RestService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
//import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import javax.inject.Singleton

@Module
class NetworkApiModule  {

    @Singleton
    @Provides
    fun provideRestService(): RestService =
        Retrofit.Builder()
            .baseUrl("https://hoff.ru/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(RestService::class.java)


}