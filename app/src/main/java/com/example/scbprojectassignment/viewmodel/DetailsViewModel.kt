package com.example.scbprojectassignment.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.scbprojectassignment.api.ApiFactory
import com.example.scbprojectassignment.model.Search
import com.example.scbprojectassignment.model.SearchDetails
import com.example.scbprojectassignment.model.TsdbResponse
import com.example.scbprojectassignment.repository.MovieRepository
import kotlinx.coroutines.*
import java.lang.Exception


class DetailsViewModel(): ViewModel() {
         val myRepository:MovieRepository
         val _repos = MutableLiveData<SearchDetails>()
    var isLoading:MutableLiveData<Boolean> = MutableLiveData()

          init {
              myRepository= MovieRepository( ApiFactory.tsdbApi)
           }


    // Get list
     fun getMovieDetails(imdbID:String) {
        isLoading.postValue(true)

        viewModelScope.launch(Dispatchers.IO) {
          var result= myRepository.getMovieDetails(imdbID)
            var tsdbResponse=result
            isLoading.postValue(false)

            _repos.postValue(result)

        }
    }


    }