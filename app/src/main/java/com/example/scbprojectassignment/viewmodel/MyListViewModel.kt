package com.example.scbprojectassignment.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.scbprojectassignment.api.ApiFactory
import com.example.scbprojectassignment.model.Search
import com.example.scbprojectassignment.repository.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MyListViewModel(): ViewModel() {
         val myRepository:MovieRepository
         val _repos = MutableLiveData<ArrayList<Search>>()
    var isLoading:MutableLiveData<Boolean> = MutableLiveData()
    init {
              myRepository= MovieRepository( ApiFactory.tsdbApi)
           }


    // Get list
     fun getAllList() {
        isLoading.postValue(true)
        viewModelScope.launch(Dispatchers.IO) {
          var result= myRepository.getMovieList()
            var tsdbResponse=result
            isLoading.postValue(false)

            _repos.postValue(result)

        }
    }


    }