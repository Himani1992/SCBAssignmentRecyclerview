package com.example.scbprojectassignment.api

import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiFactory {
        val gson = GsonBuilder().setLenient().create()

        private val tsdbClient = OkHttpClient().newBuilder()
            .build()

        fun retrofit(): Retrofit = Retrofit.Builder()
            .baseUrl("http://www.omdbapi.com/")
            .client(tsdbClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()

        val tsdbApi : TsdbApi = retrofit().create(TsdbApi::class.java)
}