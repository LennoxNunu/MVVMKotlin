package com.example.mvvmkotlin.data.model.movie


import com.example.mvvmkotlin.data.model.movie.Movie
import com.google.gson.annotations.SerializedName

data class MovieList(
    @SerializedName("results")
    val movies: List<Movie>
)