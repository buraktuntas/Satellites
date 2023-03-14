package com.satellites.core.data.remote

import com.satellites.core.BuildConfig
import com.satellites.core.data.remote.interceptor.DefaultHeaderInterceptor
import com.squareup.moshi.Moshi
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

class ServiceCreator(
    baseUrl: String,
    defaultHeaderInterceptor: DefaultHeaderInterceptor,
    moshi: Moshi
) {
    private val retrofit: Retrofit
    fun <S> createService(serviceClass: Class<S>): S {
        return retrofit.create(serviceClass)
    }

    init {
        val builder: OkHttpClient.Builder = OkHttpClient.Builder()
            .writeTimeout(20, TimeUnit.SECONDS)
            .readTimeout(20, TimeUnit.SECONDS)
            .connectTimeout(20, TimeUnit.SECONDS)
            .addInterceptor(defaultHeaderInterceptor as Interceptor)
        if (BuildConfig.DEBUG) {
            builder.addInterceptor(
                HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
            )
        }
        val retrofitBuilder = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .client(builder.build())
        retrofit = retrofitBuilder.build()
    }
}
