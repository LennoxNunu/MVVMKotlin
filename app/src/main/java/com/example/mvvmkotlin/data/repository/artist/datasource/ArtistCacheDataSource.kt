package com.example.mvvmkotlin.data.repository.artist.datasource

import com.example.mvvmkotlin.data.model.artist.Artist

interface ArtistCacheDataSource {
    suspend fun getArtistsFromCathe():List<Artist>
    suspend fun saveArtistsToCache(artists:List<Artist>)
}