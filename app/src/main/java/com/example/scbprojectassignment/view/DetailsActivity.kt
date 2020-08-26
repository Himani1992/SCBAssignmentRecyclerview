package com.example.scbprojectassignment.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.example.scbprojectassignment.R
import com.example.scbprojectassignment.databinding.ActivityDetailsDataBinding
import com.example.scbprojectassignment.viewmodel.DetailsViewModel
import kotlinx.android.synthetic.main.activity_details_data.*
import kotlinx.android.synthetic.main.layout_progress.*

class DetailsActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetailsDataBinding
    lateinit var myListViewModel: DetailsViewModel
    var imdbID: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        imdbID = intent.getStringExtra("imdbID")

        binding = DataBindingUtil.setContentView(this, R.layout.activity_details_data);
        myListViewModel = ViewModelProviders.of(this).get(DetailsViewModel::class.java)
        observeApi()
        imdbID?.let { myListViewModel.getMovieDetails(it) }
        myListViewModel._repos.observe(this, Observer {
            binding.model = it
            Glide.with(image)
                .load(it.Poster)
                .into(image);
        })
    }

    private fun observeApi() {
        myListViewModel.isLoading.observe(this, object : Observer<Boolean> {
            override fun onChanged(@Nullable isLoading: Boolean) {
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