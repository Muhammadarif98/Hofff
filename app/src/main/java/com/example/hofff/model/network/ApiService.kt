package com.example.hofff.model.network

import retrofit2.Retrofit
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.OkHttpClient
import retrofit2.converter.gson.GsonConverterFactory
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory



class ApiService private constructor() {
    private val retrofit: Retrofit
    private var BASE_URL = "https://hoff.ru/api/v2/"

    init {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
             retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }
    companion object {
        private var INSTANCE: ApiService? = null
        @JvmStatic
        val instance: ApiService?
            get() {
                if (INSTANCE == null) {
                    INSTANCE = ApiService()
                }
                return INSTANCE
            }

        annotation class JvmStatic
    }

    val jsonApi: RestService
        get() = retrofit.create(RestService::class.java)

}