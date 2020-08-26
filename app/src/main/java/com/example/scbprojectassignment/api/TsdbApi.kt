package com.example.scbprojectassignment.api

import com.example.scbprojectassignment.model.SearchDetails
import com.example.scbprojectassignment.model.TsdbResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TsdbApi {

    @GET(".")
  fun getAllId(@Query("apikey")apikey:String,@Query("s")s:String,@Query("type")type:String): Deferred<Response<TsdbResponse>>


    @GET(".")
    fun getMovieDetails(@Query("apikey")apikey:String,@Query("i")imdbId:String): Deferred<Response<SearchDetails>>
}