package com.example.mvvmkotlin.data.repository.tvshow.datasourceImpl

import com.example.mvvmkotlin.data.api.TMDBService
import com.example.mvvmkotlin.data.model.tvshow.TvShowList
import com.example.mvvmkotlin.data.repository.tvshow.datasource.TvShowRemoteDatasource
import retrofit2.Response

class TvShowRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apikey:String
    ) : TvShowRemoteDatasource {
    override suspend fun getTvShows(): Response<TvShowList> = tmdbService.getPopularTvShows(apikey)
}