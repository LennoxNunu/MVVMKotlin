package com.example.mvvmkotlin.data.repository.artist.datasourceImpl

import com.example.mvvmkotlin.data.api.TMDBService
import com.example.mvvmkotlin.data.model.artist.ArtistList
import com.example.mvvmkotlin.data.repository.artist.datasource.ArtistRemoteDatasource
import retrofit2.Response

class ArtistRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apikey:String
    ) : ArtistRemoteDatasource {
    override suspend fun getArtists(): Response<ArtistList> = tmdbService.getPopularArtists(apikey)
}