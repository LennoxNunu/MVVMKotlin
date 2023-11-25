package com.example.mvvmkotlin.data


import com.example.mvvmkotlin.data.Movie
import com.google.gson.annotations.SerializedName

data class MovieList(
    @SerializedName("results")
    val results: List<Movie>
)