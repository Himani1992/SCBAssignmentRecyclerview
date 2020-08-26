package com.example.scbprojectassignment.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.scbprojectassignment.api.TsdbApi
import com.example.scbprojectassignment.model.Search
import com.example.scbprojectassignment.model.SearchDetails
import java.lang.Exception

class MovieRepository(val api: TsdbApi) {
    var resultListData = ArrayList<Search>()
    var resultDeatilsData = SearchDetails()

    suspend fun getMovieList(): ArrayList<Search> {

        try {
            val allIdRequests = api.getAllId("b9bd48a6", "Marvel", "movie").await()
            val tsdbResponse = allIdRequests.body()

            var resultList = tsdbResponse?.Search
            resultListData = resultList!!


        } catch (e: Exception) {
            Log.d("ErrorMessage", "getMovieList: " + e.message)
        }
        return resultListData
    }


    suspend fun getMovieDetails(imdbID:String): SearchDetails {

        try {
            val allIdRequests = api.getMovieDetails("b9bd48a6", imdbID).await()
            val tsdbResponse = allIdRequests.body()

            resultDeatilsData = tsdbResponse!!


        } catch (e: Exception) {
            Log.d("ErrorMessage", "getMovieList: " + e.message)
        }
        return resultDeatilsData
    }

}