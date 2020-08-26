package com.example.scbprojectassignment.model

import com.google.gson.annotations.SerializedName


class SearchDetails {
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

    @SerializedName("Rated")
    lateinit var Rated: String

    @SerializedName("Released")
    lateinit var Released: String

    @SerializedName("Genre")
    lateinit var Genre: String

    @SerializedName("Director")
    lateinit var Director: String

    @SerializedName("Writer")
    lateinit var Writer: String

    @SerializedName("Actors")
    lateinit var Actors: String

    @SerializedName("Plot")
    lateinit var Plot: String

    @SerializedName("Language")
    lateinit var Language: String

    @SerializedName("Country")
    lateinit var Country: String

    @SerializedName("Awards")
    lateinit var Awards: String

    @SerializedName("Ratings")
    lateinit var Ratings:Array<Ratings>

    @SerializedName("Metascore")
    lateinit var Metascore: String

    @SerializedName("imdbRating")
    lateinit var imdbRating: String

    @SerializedName("imdbVotes")
    lateinit var imdbVotes: String

    @SerializedName("DVD")
    lateinit var DVD: String

    @SerializedName("BoxOffice")
    lateinit var BoxOffice: String

    @SerializedName("Production")
    lateinit var Production: String

    @SerializedName("Website")
    lateinit var Website: String

    @SerializedName("Response")
    lateinit var Response: String
}

