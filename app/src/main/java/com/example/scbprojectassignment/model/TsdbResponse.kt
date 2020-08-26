package com.example.scbprojectassignment.model

import com.google.gson.annotations.SerializedName

class TsdbResponse {
    @SerializedName("Search")
    var Search = ArrayList<Search>()
}
class Search {
    @SerializedName("Title")
    lateinit var Title: String

    @SerializedName("Year")
    lateinit var Year: String

    @SerializedName("imdbID")
    lateinit var imdbID: String

    @SerializedName("Type")
    lateinit var Type: String

    @SerializedName("Poster")
    lateinit var Poster: String


}