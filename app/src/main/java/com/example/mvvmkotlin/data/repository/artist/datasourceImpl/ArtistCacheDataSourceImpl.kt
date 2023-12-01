package com.example.mvvmkotlin.data.repository.artist.datasourceImpl

import com.example.mvvmkotlin.data.model.artist.Artist
import com.example.mvvmkotlin.data.repository.artist.datasource.ArtistCacheDataSource


class ArtistCacheDataSourceImpl : ArtistCacheDataSource {

    private var artistList = ArrayList<Artist>()

    override suspend fun getArtistsFromCathe(): List<Artist> {
        return artistList
    }

    override suspend fun saveArtistsToCache(artists: List<Artist>) {
        artistList.clear()
        artistList = ArrayList(artists)
    }
}