package com.example.scbprojectassignment.adapter

import android.content.Context
import android.widget.ImageView
import androidx.core.content.ContextCompat.getSystemService
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide


object CommonUtil {
    @JvmStatic
    @BindingAdapter("android:src")
     fun setImageUrl(view: ImageView, url: String) {
        Glide.with(view.context).load(url).into(view)
    }

}