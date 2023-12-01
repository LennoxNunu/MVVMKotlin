package com.example.mvvmkotlin.data.repository.artist.datasource

import com.example.mvvmkotlin.data.model.artist.ArtistList
import retrofit2.Response

interface ArtistRemoteDatasource {
    suspend fun getArtists(): Response<ArtistList>
}