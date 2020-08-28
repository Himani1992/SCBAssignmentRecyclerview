package com.example.scbprojectassignment.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.scbprojectassignment.R
import com.example.scbprojectassignment.adapter.CommonUtil
import com.example.scbprojectassignment.adapter.MovieAdapter
import com.example.scbprojectassignment.api.ApiFactory
import com.example.scbprojectassignment.databinding.ActivityMainBinding
import com.example.scbprojectassignment.viewmodel.MyListViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_progress.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {

    lateinit var myListViewModel: MyListViewModel
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
//        observe viewModel live data
        myListViewModel = ViewModelProviders.of(this).get(MyListViewModel::class.java)
        observeApi();

        myListViewModel.getAllList()
        myListViewModel._repos.observe(this, Observer {
            //bind your ui here
            listOfMovies?.apply {
                layoutManager = LinearLayoutManager(this@MainActivity)
                addItemDecoration(
                    DividerItemDecoration(
                        this@MainActivity,
                        DividerItemDecoration.VERTICAL
                    )
                )
                adapter = MovieAdapter(it, this@MainActivity) {
                    var intent = Intent(this@MainActivity, DetailsActivity::class.java)
                    intent.putExtra("imdbID", it.imdbID)
                    startActivity(intent)
                }
            }
        })
    }

    private fun observeApi() {
         myListViewModel.isLoading.observe(this, object:Observer<Boolean> {
            override fun onChanged(@Nullable isLoading:Boolean) {
                if (isLoading)
                {
                    progressBar.visibility = View.VISIBLE

                }else{
                    progressBar.visibility = View.INVISIBLE

                }
            }
        })
    }


}