package com.example.scbprojectassignment.bindings

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.scbprojectassignment.R

object CustomViewBindings {
//    @BindingAdapter("setAdapter")
//    fun bindRecyclerViewAdapter(recyclerView: RecyclerView, adapter:RecyclerView.Adapter<*>) {
//        recyclerView.setHasFixedSize(true)
//        recyclerView.setLayoutManager(LinearLayoutManager(recyclerView.getContext()))
//        recyclerView.setAdapter(adapter)
//    }
//    @BindingAdapter("imageUrl")
//    fun bindRecyclerViewAdapter(imageView: ImageView, imageUrl:String) {
//        if (imageUrl != null)
//        {
//            // If we don't do this, you'll see the old image appear briefly
//            // before it's replaced with the current image
//            if (imageView.getTag(R.id.image_url) == null || !imageView.getTag(R.id.image_url).equals(imageUrl))
//            {
//                imageView.setImageBitmap(null)
//                imageView.setTag(R.id.image_url, imageUrl)
//                Glide.with(imageView).load(imageUrl).into(imageView)
//            }
//        }
//        else
//        {
//            imageView.setTag(R.id.image_url, null)
//            imageView.setImageBitmap(null)
//        }
//    }
}