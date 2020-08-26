package com.example.scbprojectassignment.model

import com.google.gson.annotations.SerializedName

class Ratings {
    @SerializedName("Value")
    lateinit var Value: String

    @SerializedName("Source")
    lateinit var Source: String
}