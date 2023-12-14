package com.example.mvvmkotlin.data.repository.tvshow

import com.example.mvvmkotlin.data.model.tvshow.TvShow
import com.example.mvvmkotlin.domain.repository.TvShowRepository

class FakeTvShowRepositoryImpl: TvShowRepository {
    private val tvShows = mutableListOf<TvShow>()

    init {
        tvShows.add(TvShow("",1,"name1","overview1","posterPath1"))
        tvShows.add(TvShow("",1,"name1","overview1","posterPath1"))
    }

    override suspend fun getTvShows(): List<TvShow>? {
        return tvShows
    }

    override suspend fun updateTvShows(): List<TvShow>? {
        tvShows.clear()
        tvShows.add(TvShow("",1,"name1","overview1","posterPath1"))
        tvShows.add(TvShow("",1,"name1","overview1","posterPath1"))
        return tvShows
    }

}